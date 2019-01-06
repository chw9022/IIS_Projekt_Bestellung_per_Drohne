// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.entities;

public enum DroneStatus {
    NONE,
    READY_TO_START,
    FLYING_TO_CLIENT,
    FLYING_FROM_CLIENT,
    CHARGING,
    ERROR
}
