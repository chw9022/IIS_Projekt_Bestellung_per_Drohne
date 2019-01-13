package de.thi.iis.Bestellung_per_Drohne;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

import jpa.entities.Article;
import jpa.entities.Client;
import jpa.entities.ClientType;
import jpa.entities.Order;
import jpa.entities.OrderPosition;

/**
 * Process Application exposing this application's resources the process engine.
 */
@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication {

	private static final String PROCESS_DEFINITION_KEY = "Process_Order_per_Drone";

	/**
	 * In a @PostDeploy Hook you can interact with the process engine and access the
	 * processes the application has deployed.
	 */
	@PostDeploy
	public void onDeploymentFinished(ProcessEngine processEngine) {

		// start an initial process instance
		Map<String, Object> variables = new HashMap<String, Object>();
		Order o = new Order();
		o.setOrderdate(new Date());
		Client c = new Client();
		c.setClienttype(ClientType.PREMIUM);
		o.setClient(c);
		OrderPosition op1 = new OrderPosition();
		Article a1 = new Article();
		a1.setPrice(2.2);
		op1.setArticle(a1);
		op1.setAmount(1);
		op1.setOrder(o);
		o.addOrderPosition(op1);
		OrderPosition op2 = new OrderPosition();
		Article a2 = new Article();
		a2.setPrice(2.2);
		op2.setArticle(a1);
		op2.setAmount(1);
		op2.setOrder(o);
		o.addOrderPosition(op2);
		variables.put("order", o);
		processEngine.getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
	}
}
