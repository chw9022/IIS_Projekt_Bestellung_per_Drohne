// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.webservices;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import jpa.entities.DroneStatus;
import jpa.services.DroneService;

@WebService
public class CheckDroneAvailable {

    @Inject
    DroneService droneService;
    
    @WebMethod
    public boolean checkDroneAvailable() {

        // ...
        // TODO - currently just testing
        // ...
        
        System.out.println("Hello World");
        // System.out.println( droneService.getDroneStatus(id) );
        droneService.setDroneStatus(1, DroneStatus.FLYING_TO_CLIENT);
        
        return false;
    }
}
