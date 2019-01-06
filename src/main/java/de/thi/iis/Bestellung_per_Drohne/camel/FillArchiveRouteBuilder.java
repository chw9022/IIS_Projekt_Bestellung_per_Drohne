package de.thi.iis.Bestellung_per_Drohne.camel;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;

public class FillArchiveRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("file:/home/lars/Downloads/xml_elements?noop=true");
		Endpoint destination = endpoint("jms:queue:toarchive");
		from(source).to(destination);
	}
}
