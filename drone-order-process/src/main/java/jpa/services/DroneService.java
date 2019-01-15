// #######################################
// Author: Christian Wittmann
// #######################################
package jpa.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpa.entities.Drone;

/**
 * Session Bean implementation class DroneService
 */
@Stateless
@LocalBean
public class DroneService implements DroneServiceLocal {
    
    private static final int NOT_AVAILABLE = 0;
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public boolean isDroneAvailable(int id) {
        return em.find(Drone.class, id).isAvailable();
    }

    @Override
    public boolean isAnyDroneAvailable() {
        int idOfAvailableDrone = getIdOfAvailableDrone();
        
        if (idOfAvailableDrone == NOT_AVAILABLE) {
            return false;
        }
        else {
            setDroneAvailable(idOfAvailableDrone, false);
            return true;
        }
    }

    @Override
    public int getIdOfAvailableDrone() {
        @SuppressWarnings("unchecked")
        List<Integer> droneIds = em.createQuery("SELECT id FROM Drone d " +
                                                "WHERE d.available = TRUE")
                                                .getResultList();
        
        return droneIds.isEmpty() ? NOT_AVAILABLE : droneIds.get(0);
    }

    @Override
    public void setDroneAvailable(int id, boolean available) {
        em.find(Drone.class, id).setAvailable(available);
    }
}
