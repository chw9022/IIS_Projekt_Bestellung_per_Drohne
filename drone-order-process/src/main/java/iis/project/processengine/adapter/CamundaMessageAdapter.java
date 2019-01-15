// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.processengine.adapter;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class CamundaMessageAdapter extends Thread {

	@Override
	public void run() {
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_BROKER_URL);
			connectionFactory.setTrustAllPackages(true);
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("messages-to-camunda");
			MessageConsumer consumer = session.createConsumer(queue);
			while (true) {
				Message message = consumer.receive();
				if (message instanceof TextMessage) {
					String messageBody = ((TextMessage) message).getText();
					this.sendTextMessageToCamunda(messageBody);
				}
				Thread.sleep(500);
			}
		} catch (InterruptedException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendTextMessageToCamunda(String jsonMessage) {
		WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:8080/engine-rest/");
		webTarget.path("message").request().post(Entity.json(jsonMessage));
	}
}
