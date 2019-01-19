package stoll.quirin.beans;
//Author: Quirin Stoll
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import stoll.quirin.model.Client;

/**
 * Session Bean implementation class ClientHibernateBean
 */
@Stateless
@LocalBean
public class ClientHibernateBean implements ClientHibernateBeanLocal {
    @PersistenceContext
    EntityManager em;
    /**
     * Default constructor. 
     */
    public ClientHibernateBean() {
        // TODO Auto-generated constructor stub
    }
    public Client findClient(int id){
        return em.find(Client.class, id);
    }
}
