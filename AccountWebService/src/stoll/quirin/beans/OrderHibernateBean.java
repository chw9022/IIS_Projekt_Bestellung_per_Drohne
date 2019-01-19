package stoll.quirin.beans;
//Author: Quirin Stoll
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import stoll.quirin.model.Order;
import stoll.quirin.model.OrdersPosition;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class OrderHibernateBean implements OrderHibernateBeanLocal {
    @PersistenceContext
    EntityManager em;
    /**
     * Default constructor. 
     */
    public OrderHibernateBean() {
        // TODO Auto-generated constructor stub
    }
    public void updateOrder(Order c){
        em.merge(c);
    }
    public Order insertOrder(Order order){
        em.persist(order);
        return order;
    }
    public void deleteOrder(Order order){
        em.remove(order);
    }
    public Order findOrder(int id){
        return em.find(Order.class, id);
    }
    public OrdersPosition insertOrdersPosition(OrdersPosition op){
        em.persist(op);
        return op;
    }
}
