// #######################################
// Author: Felix Ziegner
// Kopiert von: https://skills421.com/2014/05/07/send-jms-object-message-to-activemq/
// #######################################

package jms;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSManager {
	public void sendMessage(final Serializable message, final String queueName) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("example-queue");
		MessageProducer producer = session.createProducer(queue);
		connection.start();
		ObjectMessage m1 = session.createObjectMessage();
		m1.setObject(message);
		producer.send(m1);
		connection.close();
	}
}