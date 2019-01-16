// #######################################
// Author: Felix Ziegner
// #######################################
package listener;

import org.codehaus.jackson.map.ObjectMapper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import adapter.CamundaCorrelationKey;
import adapter.CamundaMessage;
import adapter.CamundaVariableType;
import custom.JMSManager;
import event.DronePositionNotification;

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
				"" + dronePositionNotificationHome.getDroneId(), CamundaVariableType.INTEGER);
		camundaMessage.addCorrelationKey(camundaKorrelationKey);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(camundaMessage);
			jmsManager.sendMessage(jsonString, "messages-to-camunda");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
