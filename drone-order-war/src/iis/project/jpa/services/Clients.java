// #######################################
// Author: Felix Ziegner
// #######################################
package iis.project.jpa.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import iis.project.jpa.entities.Client;

public class Clients{
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Bestellung_per_Drohne");
	EntityManager entityManager = emFactory.createEntityManager();

	public void addClient(Client client) {
		entityManager.persist(client);
	}

	public void deleteClient(Client client) {
		entityManager.remove(client);
	}

	public Client findById(int clientId) {
		  return entityManager.find(Client.class, clientId);
	}

	public List<Client> getClients() {
		Query query = entityManager.createQuery("SELECT c from Client as c");
		return query.getResultList();
	}
}