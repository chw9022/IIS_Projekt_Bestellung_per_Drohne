package routes;
//Author: Quirin Stoll

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MessageToCamundaStartRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:webshop_orders");
		Endpoint destination1 = endpoint("http://localhost:8080/engine-rest/message");
		from(source) // nl
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
				.to(destination1);
	}
}
