//Author: Alexander Perlatov
package iis.project.processengine.delegate;

import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jms.JMSManager;
import iis.project.jpa.entities.Order;

public class SendRechnung implements JavaDelegate {

	public static String QUEUE_KUNDE = "kunde";

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Ich bin der Sender!");

		Map<String, Object> SendOrder = execution.getVariables();
		String msg = (String) SendOrder.get("msg");
		Order order = (Order) execution.getVariable("order");
		JMSManager jmsKunde = new JMSManager();
		jmsKunde.sendTextMessage(msg, QUEUE_KUNDE, "clientId", Integer.toString(order.getClient().getId()));
	}
}
