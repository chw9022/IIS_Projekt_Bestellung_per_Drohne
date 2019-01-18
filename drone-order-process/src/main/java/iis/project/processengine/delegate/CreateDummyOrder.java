package iis.project.processengine.delegate;

import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import iis.project.jpa.entities.Article;
import iis.project.jpa.entities.Client;
import iis.project.jpa.entities.ClientType;
import iis.project.jpa.entities.Order;
import iis.project.jpa.entities.OrderPosition;

public class CreateDummyOrder implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
	    
		Order o = new Order();
		o.setOrderdate(new Date());
		
		Client c = new Client();
		c.setClienttype(ClientType.PREMIUM);

        Article a1 = new Article();
        a1.setId(1); // Tomaten

        Article a2 = new Article();
        a2.setId(2); // Bananen
        
		OrderPosition op1 = new OrderPosition();
        op1.setArticle(a1);
        op1.setAmount(5);
        op1.setOrder(o);
        OrderPosition op2 = new OrderPosition();
        op2.setArticle(a2);
        op2.setAmount(2);
        op2.setOrder(o);        

        o.setClient(c);
		o.addOrderPosition(op1);
		o.addOrderPosition(op2);
		
		execution.setVariable("order", o);
		execution.setVariable("orderId", o.getId());
	}

}
