// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.webservices;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import jpa.services.DroneService;

@WebService
public class CheckDroneAvailable {

    @Inject
    DroneService droneService;
    
    @WebMethod
    public boolean checkDroneAvailable() {
        return droneService.checkDroneAvailable();
    }
}
