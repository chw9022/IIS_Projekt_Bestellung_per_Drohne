//Author: Alexander Perlatov

package aggregator;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class RechnungAggregationStrategy implements AggregationStrategy {
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        Date date = new Date();

        if (oldExchange == null) {
            String body = newExchange.getIn().getBody(String.class);
            newExchange.getIn().setBody("\n****\n" + date.toString() + "\n****\n\n" + body + "\n");
            return newExchange;
        } else {
            String oldbody = oldExchange.getIn().getBody(String.class);
            String newbody = newExchange.getIn().getBody(String.class);
            String body = oldbody + "\n****\n" + date.toString() + "\n****\n\n" + newbody + "\n";
            oldExchange.getIn().setBody(body);
            return oldExchange;
        }
    }
}