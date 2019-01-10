// #######################################
// Author: Felix Ziegner
// #######################################
package camel.routes;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import jpa.entities.Article;
import servicetasks.ArchiveOrder;

public class OrderArchiveRouteBuilder extends RouteBuilder {
	private static String directory_archive = "file:/home/lars/Downloads";
	private static String external_archive = "jms:queue:order-archive-external";

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:" + ArchiveOrder.QUEUE_ORDER_ARCHIVE);
		Endpoint destination1 = endpoint(directory_archive);
		Endpoint destination2 = endpoint(external_archive);

		JAXBContext jaxbContext = JAXBContext.newInstance(Article.class);
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);

		from(source) // from XML source
				.unmarshal(jaxbDataFormat) // XML to POJO
				.marshal().json(JsonLibrary.Jackson, Article.class) // POJO to JSON
				.to(destination1).to(destination2);
	}
}
