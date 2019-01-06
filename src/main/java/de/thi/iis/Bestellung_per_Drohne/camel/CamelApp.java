// #######################################
// Author: Felix Ziegner
// #######################################
package de.thi.iis.Bestellung_per_Drohne.camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.main.Main;

public class CamelApp {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		main.bind("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		main.addRouteBuilder(new FillArchiveRouteBuilder());
		main.addRouteBuilder(new ArchiveRouteBuilder());
		main.run(args);
	}
}