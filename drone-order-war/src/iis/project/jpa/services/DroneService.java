// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.jpa.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iis.project.jpa.entities.Drone;

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
    public int getIdOfAvailableDrone() {
        @SuppressWarnings("unchecked")
        List<Integer> droneIds = em.createQuery("SELECT id FROM Drone d " +
                                                "WHERE d.available = TRUE")
                                                .getResultList();
        if (droneIds.isEmpty()) {
            return NOT_AVAILABLE;
        }
        else {
            int idOfAvailableDrone = droneIds.get(0);
            setDroneAvailable(idOfAvailableDrone, false);
            return idOfAvailableDrone;
        }
    }

    @Override
    public void setDroneAvailable(int id, boolean available) {
        em.find(Drone.class, id).setAvailable(available);
    }
}
