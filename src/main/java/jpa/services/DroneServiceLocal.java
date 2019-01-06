// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.services;

import jpa.entities.DroneStatus;
import javax.ejb.Local;

@Local
public interface DroneServiceLocal {
    DroneStatus getDroneStatus(int id);
    void setDroneStatus(DroneStatus status);
}
