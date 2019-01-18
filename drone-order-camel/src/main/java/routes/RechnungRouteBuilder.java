//Author: Alexander Perlatov

package routes;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import aggregator.*;

public class RechnungRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        Endpoint source = endpoint("jms:queue:kunde");
        Endpoint destination1 = endpoint("file:/home/lars/Rechnungen");
        Endpoint destination2 = endpoint("jms:queue:rechnungAggregator");

        from(source) 
                .aggregate(body(), new RechnungAggregationStrategy())
                .completionSize(2)
                .to(destination1)
                .to(destination2);
    }
}
