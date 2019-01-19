// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.webservices;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import iis.project.jpa.services.DroneService;

@WebService
public class CheckDroneAvailable {

    @Inject
    DroneService droneService;
    
    @WebMethod
    public synchronized int getIdOfAvailableDrone() {
        return droneService.getIdOfAvailableDrone();
    }
}
