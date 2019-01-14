// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.services;

import javax.ejb.Local;

@Local
public interface DroneServiceLocal {
    
    // Getter
    boolean isDroneAvailable(int id);
    boolean isAnyDroneAvailable();
    int getIdOfAvailableDrone();
    
    // Setter
    void setDroneAvailable(int id, boolean available);
}
