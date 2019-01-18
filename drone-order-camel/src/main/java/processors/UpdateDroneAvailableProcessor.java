// #######################################
// Author: Christian Wittmann
// #######################################
package processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import iis.project.processengine.message.DroneLandedMessage;

public class UpdateDroneAvailableProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        
        DroneLandedMessage m = exchange.getIn().getBody(DroneLandedMessage.class);
        exchange.getIn().setBody("UPDATE drone SET available=1 where id=" + m.getDroneId());
    }
}
