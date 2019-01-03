// #######################################
// Author: Felix Ziegner
// #######################################
package de.thi.iis.Bestellung_per_Drohne.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelApp {
    public static final void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {
            // context.addRoutes(new Builder());
            context.start();
        } finally {
            context.stop();
        }
    }
}