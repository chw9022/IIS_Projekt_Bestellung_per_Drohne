package iis.project.processengine.delegate;

import java.io.StringWriter;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jms.JMSManager;
import iis.project.processengine.message.DroneStartedMessage;

public class DroneStarted implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		JMSManager m = new JMSManager();
		Integer droneId = (Integer) execution.getVariable("droneId");
		Calendar timeOfArrival = Calendar.getInstance();
		timeOfArrival.add(Calendar.MINUTE, 5);
		DroneStartedMessage message = new DroneStartedMessage();
		message.setDroneId(droneId);
		JAXBContext jaxbContext = JAXBContext.newInstance(DroneStartedMessage.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(message, stringWriter);
		m.sendMessage(stringWriter.toString(), "drone-started");
	}
}
