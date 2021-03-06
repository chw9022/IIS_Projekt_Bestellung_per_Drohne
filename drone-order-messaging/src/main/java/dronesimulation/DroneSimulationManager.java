package dronesimulation;

// #######################################
// Author: Felix Ziegner
// #######################################
import java.io.StringReader;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.espertech.esper.client.EPServiceProvider;

import iis.project.processengine.message.DroneStartedMessage;

public class DroneSimulationManager implements Runnable {
	private EPServiceProvider epsServiceProvider;

	public DroneSimulationManager(EPServiceProvider epsServiceProvider) {
		super();
		this.epsServiceProvider = epsServiceProvider;
	}

	public void run() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_BROKER_URL);
		// connectionFactory.setTrustAllPackages(true);
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("drone-started");
			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();
			System.out.println("listen messages");
			while (true) {
				Message message = consumer.receive();
				if (message instanceof TextMessage) {
					String messageBody = ((TextMessage) message).getText();
					JAXBContext jaxbContext = JAXBContext.newInstance(DroneStartedMessage.class);
					Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
					StringReader reader = new StringReader(messageBody);
					System.out.println("message received: " + messageBody);
					DroneStartedMessage droneStartedMessage = (DroneStartedMessage) unmarshaller.unmarshal(reader);
					System.out.println("start simulation drone id: " + droneStartedMessage.getDroneId());
					this.startSimulation(droneStartedMessage.getDroneId());
				}
				else {
					System.out.println("message type: "+ message.getClass());
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startSimulation(int droneId) {
		DroneSimulation droneSimulation = new DroneSimulation(epsServiceProvider, droneId);
		droneSimulation.run();
	}
}
