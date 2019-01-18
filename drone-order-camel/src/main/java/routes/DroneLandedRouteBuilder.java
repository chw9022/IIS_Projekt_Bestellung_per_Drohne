// #######################################
// Author: Christian Wittmann
// #######################################
package routes;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import iis.project.processengine.message.DroneLandedMessage;
import processors.UpdateDroneAvailableProcessor;

public class DroneLandedRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        
        JAXBContext jaxbContext = JAXBContext.newInstance(DroneLandedMessage.class);
        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
        
        from("jms:queue:drone-landed")
            .unmarshal(jaxbDataFormat)
            .process(new UpdateDroneAvailableProcessor())
            .to("jdbc:groceryshopDataSource");
    }
}
