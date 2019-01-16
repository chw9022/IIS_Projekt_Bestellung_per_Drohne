package routes;
// #######################################

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MessageToCamundaRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:messages-to-camunda");
		Endpoint destination1 = endpoint("http://localhost:8080/engine-rest/message/");
		from(source) // nl
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))// nl
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json")) // nl
				.to(destination1);
	}
}
