
// #######################################
// Author: Felix Ziegner
// #######################################

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.main.Main;

import routes.MessageToCamundaRouteBuilder;
import routes.OrderArchiveRouteBuilder;

public class CamelApp extends Main {

	public static void main(String[] args) throws Exception {
		CamelApp ca = new CamelApp();
		ca.start();
	}

	public CamelApp() {
		super();
		this.initialize();
		this.addRouteBuilders();
	}

	private void initialize() {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		this.bind("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
	}

	private void addRouteBuilders() {
		this.addRouteBuilder(new OrderArchiveRouteBuilder());
		this.addRouteBuilder(new MessageToCamundaRouteBuilder());
	}
}