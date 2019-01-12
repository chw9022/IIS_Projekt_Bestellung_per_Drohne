// #######################################
// Author: Felix Ziegner
// #######################################
package camel.routes;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import jpa.entities.Order;
import processengine.delegate.ArchiveOrder;

public class OrderArchiveRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:" + ArchiveOrder.QUEUE_ORDER_ARCHIVE);
		Endpoint destination1 = endpoint("file:/home/lars/Downloads");
		Endpoint destination2 = endpoint("jms:queue:order-archive-external");

		JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
		from(source) // from XML source
				.unmarshal(jaxbDataFormat) // XML to POJO
				.marshal(jaxbDataFormat) // POJO to XML
				.to(destination1) // to filesystem
				.marshal().json(JsonLibrary.Jackson, Order.class) // POJO to JSON
				.to(destination2); // to queue
	}
}
