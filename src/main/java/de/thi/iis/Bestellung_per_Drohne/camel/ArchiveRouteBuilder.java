package de.thi.iis.Bestellung_per_Drohne.camel;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import de.thi.iis.Bestellung_per_Drohne.Article;

public class ArchiveRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:toarchive");
		Endpoint destination1 = endpoint("jms:queue:archivedb");
		Endpoint destination2 = endpoint("file:/home/lars/Downloads/xml_elements/destination");
		JAXBContext jaxbContext = JAXBContext.newInstance(Article.class);
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
		from(source).unmarshal(jaxbDataFormat)
		.marshal().json(JsonLibrary.Jackson, Article.class)
		.to(destination1)
		.to(destination2);
	}
}
