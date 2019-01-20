package iis.project.processengine.delegate;

import java.util.Date;
import java.util.Random;

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
	    int userid = (int) execution.getVariable("user");
	    String product = (String) execution.getVariable("product");
	    int article_id = (int) execution.getVariable("article_id");
	    int amount = (int) execution.getVariable("amount");
	    Order o = new Order();
		o.setOrderdate(new Date());
		Random r = new Random();
        int number = r.nextInt(1000);
        o.setId(number);
		Client c = new Client();
		c.setId(userid);		
		c.setFirstname("Hans");
		c.setLastname("Schmidt");
		c.setStreet("Erlangerstr. 1a");
		c.setPlace("Erlangen");
		c.setClienttype(ClientType.PREMIUM);

        Article a1 = new Article();
        a1.setId(article_id);
        a1.setName(product);
        a1.setWeightInKg(0.500);
        a1.setPrice(10.50);
        
		OrderPosition op1 = new OrderPosition();
        op1.setArticle(a1);
        op1.setAmount(amount);
        op1.setOrder(o);      

        o.setClient(c);
		o.addOrderPosition(op1);
		
		execution.setVariable("order", o);
		execution.setVariable("orderId", o.getId());
	}

}
