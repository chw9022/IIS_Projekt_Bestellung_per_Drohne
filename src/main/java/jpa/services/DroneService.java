// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpa.entities.DroneStatus;
import jpa.entities.Drones;

/**
 * Session Bean implementation class DroneService
 */
@Stateless
@LocalBean
public class DroneService implements DroneServiceLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public DroneStatus getDroneStatus(int id) {
        return em.find(Drones.class, id).getStatus();
    }

    @Override
    public void setDroneStatus(DroneStatus status) {
        // TODO Auto-generated method stub

    }

}
