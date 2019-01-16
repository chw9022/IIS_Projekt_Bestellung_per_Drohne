// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import iis.project.jpa.entities.Order;

public class Orders {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Bestellung_per_Drohne");
	EntityManager entityManager = emFactory.createEntityManager();

	public Order findById(int orderId) {
		return entityManager.find(Order.class, orderId);
	}

}