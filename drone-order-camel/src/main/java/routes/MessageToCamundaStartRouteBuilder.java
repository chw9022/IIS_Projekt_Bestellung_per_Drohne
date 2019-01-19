package routes;
// #######################################

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MessageToCamundaStartRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:webshop_orders");
		Endpoint destination1 = endpoint(" /process-definition/key/Process_Order_per_Drone/start");
		from(source) // nl
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))// nl
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json")) // nl
				.to(destination1);
	}
}
