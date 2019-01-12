// #######################################
// Author: Felix Ziegner
// #######################################
package processengine.delegate;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import jms.JMSManager;
import jpa.entities.Order;

public class ArchiveOrder implements JavaDelegate {
	private static String ORDER_VARIABLE = "order";
	public static String QUEUE_ORDER_ARCHIVE = "order-archive";

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		JMSManager jmsManager = new JMSManager();
		Order orderToArchive = (Order) execution.getVariable(ORDER_VARIABLE);
		orderToArchive.closeOrder();
		StringWriter stringWriter = new StringWriter();
		JAXBContext JaxbContext = JAXBContext.newInstance(Order.class);
		Marshaller marshaller = JaxbContext.createMarshaller();
		marshaller.marshal(orderToArchive, stringWriter);
		jmsManager.sendMessage(stringWriter.toString(), "order-archive");
		execution.setVariable(ORDER_VARIABLE, orderToArchive);
	}
}
