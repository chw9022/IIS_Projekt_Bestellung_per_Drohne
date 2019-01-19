package stoll.quirin.beans;
//Author: Quirin Stoll
import javax.ejb.Local;

import stoll.quirin.model.Order;

@Local
public interface OrderHibernateBeanLocal {
    
    public void updateOrder(Order c);
    public Order insertOrder(Order order);
    public void deleteOrder(Order order);
    public Order findOrder(int id);
}
