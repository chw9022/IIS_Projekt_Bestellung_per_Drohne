// #######################################
// Author: Felix Ziegner
// #######################################
package de.thi.iis.Bestellung_per_Drohne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entities.Order;

public class Orders {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Bestellung_per_Drohne");
	EntityManager entityManager = emFactory.createEntityManager();

	public Order findById(int orderId) {
		return entityManager.find(Order.class, orderId);
	}

}