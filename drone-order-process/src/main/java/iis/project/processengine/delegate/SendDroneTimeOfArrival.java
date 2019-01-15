package iis.project.processengine.delegate;

import java.util.Calendar;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.map.ObjectMapper;

import iis.project.jms.JMSManager;
import iis.project.jpa.services.DroneArrivalTimeMessage;
import iis.project.jpa.entities.Order;

public class SendDroneTimeOfArrival implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		JMSManager m = new JMSManager();
		Order order = (Order) execution.getVariable("order");
		Calendar timeOfArrival = Calendar.getInstance();
		timeOfArrival.add(Calendar.MINUTE, 5);
		DroneArrivalTimeMessage message = new DroneArrivalTimeMessage();
		message.setOrder(order);
		message.setTtimeOfArrival(timeOfArrival);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
		m.sendMessage(jsonString, "package-arrival-time");
	}
}
