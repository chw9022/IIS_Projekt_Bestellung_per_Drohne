package routes;
//Author: Quirin Stoll

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MessageToOrderWebserviceRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		Endpoint source = endpoint("jms:queue:order_webservice");
		Endpoint destination1 = endpoint("http://localhost:8080/AccountWebService/orders/createorder");
		from(source) // nl
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))		
				.to(destination1).setHeader(Exchange.CONTENT_TYPE, constant("text/xml")).to("jms:queue:order_replay");
	}
}
