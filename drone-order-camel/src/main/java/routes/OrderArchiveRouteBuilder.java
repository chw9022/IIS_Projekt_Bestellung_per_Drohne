package routes;
// #######################################
// Author: Felix Ziegner
// #######################################

import javax.xml.bind.JAXBContext;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import iis.project.jpa.entities.Order;

public class OrderArchiveRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:archive-order");
		Endpoint destination1 = endpoint("file:/home/lars/Downloads");
		Endpoint destination2 = endpoint("jms:queue:order-archive-external");

		JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
		from(source) // from XML source
				.unmarshal(jaxbDataFormat) // XML to POJO
				.marshal(jaxbDataFormat) // POJO to XML
				.to(destination1) // to filesystem
				.to(destination2); // to queue
	}
}
