// #######################################
// Author: Felix Ziegner
// #######################################
package camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.main.Main;

import camel.routes.OrderArchiveRouteBuilder;

public class CamelApp {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		main.bind("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		main.addRouteBuilder(new OrderArchiveRouteBuilder());
		main.run(args);
	}
}