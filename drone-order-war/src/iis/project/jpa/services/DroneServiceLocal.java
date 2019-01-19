// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.services;

import javax.ejb.Local;

@Local
public interface DroneServiceLocal {    
    int getIdOfAvailableDrone();
    void setDroneAvailable(int id, boolean available);
}
