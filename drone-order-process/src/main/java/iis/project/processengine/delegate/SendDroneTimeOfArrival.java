package iis.project.processengine.delegate;

import java.util.Calendar;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.map.ObjectMapper;

import iis.project.jms.JMSManager;
import iis.project.processengine.message.DroneArrivalTimeMessage;

public class SendDroneTimeOfArrival implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		JMSManager m = new JMSManager();
		// Todo: get order id
		Calendar timeOfArrival = Calendar.getInstance();
		timeOfArrival.add(Calendar.MINUTE, 5);
		DroneArrivalTimeMessage message = new DroneArrivalTimeMessage();
		message.setOrder(1);
		message.setTtimeOfArrival(timeOfArrival);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
		m.sendMessage(jsonString, "package-arrival-time");
	}
}
