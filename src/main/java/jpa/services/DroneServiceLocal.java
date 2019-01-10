// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.services;

import jpa.entities.DroneStatus;
import javax.ejb.Local;

@Local
public interface DroneServiceLocal {
    boolean checkDroneAvailable();
    int getIdOfAvailableDrone();
    DroneStatus getDroneStatus(int id);
    void setDroneStatus(int id, DroneStatus status);
}
