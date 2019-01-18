
// #######################################
// Author: Felix Ziegner
// #######################################

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.main.Main;
import org.apache.commons.dbcp2.BasicDataSource;

import routes.DroneLandedRouteBuilder;
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
		this.bind("groceryshopDataSource", getGroceryshopDataSource());
	}

	private void addRouteBuilders() {
		this.addRouteBuilder(new OrderArchiveRouteBuilder());
		this.addRouteBuilder(new MessageToCamundaRouteBuilder());
		this.addRouteBuilder(new DroneLandedRouteBuilder());
	}
	
	private DataSource getGroceryshopDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("master42");
        ds.setUrl("jdbc:mysql://localhost:3306/groceryshop");
        return ds;
	}
}