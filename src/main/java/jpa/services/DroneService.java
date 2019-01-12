// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpa.entities.DroneStatus;
import jpa.entities.Drone;

/**
 * Session Bean implementation class DroneService
 */
@Stateless
@LocalBean
public class DroneService implements DroneServiceLocal {

    private static final int NOT_AVAILABLE = -1;
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public DroneStatus getDroneStatus(int id) {
        return em.find(Drone.class, id).getStatus();
    }

    @Override
    public void setDroneStatus(int id, DroneStatus status) {
        em.find(Drone.class, id).setStatus(status);
    }

    @Override
    public boolean checkDroneAvailable() {
        return getIdOfAvailableDrone() == NOT_AVAILABLE ? false : true;
    }

    @Override
    public int getIdOfAvailableDrone() {
        List<Integer> droneIds = em.createQuery("SELECT id FROM Drone d " +
                                                "WHERE d.status LIKE :READY_TO_START", Integer.class)
                                                .setParameter("READY_TO_START", DroneStatus.READY_TO_START)
                                                .getResultList();
        
        return droneIds.isEmpty() ? NOT_AVAILABLE : droneIds.get(0);
    }

}
