// #######################################
// Author: Felix Ziegner
// #######################################
package listener;

import java.io.StringWriter;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.map.ObjectMapper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import adapter.CamundaCorrelationKey;
import adapter.CamundaMessage;
import adapter.CamundaVariableType;

import event.DronePositionNotification;
import iis.project.jms.JMSManager;
import iis.project.processengine.message.DroneLandedMessage;

public class DroneHomeListener implements UpdateListener {

	public String getQuery() {
		return "select * from DronePositionNotification match_recognize (partition by droneId"
				+ " measures A as event1, B as event2 pattern (A B) define A as A.isHome = false,"
				+ " B as B.isHome = true)";
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		DronePositionNotification dronePositionNotificationHome = (DronePositionNotification) newEvents[0]
				.get("event2");
		JMSManager jmsManager = new JMSManager();
		CamundaMessage camundaMessage = new CamundaMessage("droneHomeMessage");
		CamundaCorrelationKey camundaKorrelationKey = new CamundaCorrelationKey("droneId",
				"" + dronePositionNotificationHome.getDroneId(), CamundaVariableType.LONG);
		camundaMessage.addCorrelationKey(camundaKorrelationKey);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(camundaMessage);
			System.out.println("send to queue messages-to-camunda: " + jsonString);
			jmsManager.sendTextMessage(jsonString, "messages-to-camunda");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        DroneLandedMessage message = new DroneLandedMessage();
        message.setDroneId(dronePositionNotificationHome.getDroneId());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DroneLandedMessage.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(message, stringWriter);
            jmsManager.sendTextMessage(stringWriter.toString(), "drone-landed");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
