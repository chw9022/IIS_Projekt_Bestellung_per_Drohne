package iis.project.processengine.delegate;

import java.io.StringWriter;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jms.JMSManager;
import iis.project.jpa.entities.Order;
import iis.project.processengine.message.DroneStartedMessage;

public class DroneStarted implements JavaDelegate {
    
    private static final String ORDER_VARIABLE = "order";

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		JMSManager m = new JMSManager();
	    Order order = (Order) execution.getVariable(ORDER_VARIABLE);
		Integer droneId = order.getDroneId();
		Calendar timeOfArrival = Calendar.getInstance();
		timeOfArrival.add(Calendar.MINUTE, 5);
		DroneStartedMessage message = new DroneStartedMessage();
		message.setDroneId(droneId);
		JAXBContext jaxbContext = JAXBContext.newInstance(DroneStartedMessage.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(message, stringWriter);
		m.sendTextMessage(stringWriter.toString(), "drone-started");
	}
}
