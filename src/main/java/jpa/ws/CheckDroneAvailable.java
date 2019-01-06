// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import jpa.services.DroneService;

@WebService
public class CheckDroneAvailable {

    @Inject
    DroneService droneService;
    
    @WebMethod
    public void checkDroneAvailable(int id) {
        
        // ...
        // TODO - currently just testing
        // ...
        
        System.out.println("Hello World");
        System.out.println( droneService.getDroneStatus(id) );
    }
}
