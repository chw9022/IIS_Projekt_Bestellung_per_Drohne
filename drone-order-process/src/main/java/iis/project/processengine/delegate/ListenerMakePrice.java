//Author: Alexander Perlatov
package iis.project.processengine.delegate;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import iis.project.jpa.entities.ClientType;
import iis.project.jpa.entities.Order;
import iis.project.jpa.entities.OrderPosition;

public class ListenerMakePrice implements JavaDelegate {

	private static String ORDER_VARIABLE = "order";

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		Map<String, Object> variables = execution.getVariables();
		Order order = (Order) variables.get(ORDER_VARIABLE);

		double totalPrice = getTotalPrice(order);
		ClientType clientType = order.getClient().getClienttype();
		String client = String.valueOf(clientType);

		VariableMap rabattInputs = Variables.createVariables();
		rabattInputs.putValue("rabatt_clienttype", client);
		rabattInputs.putValue("rabatt_price", totalPrice);
		execution.setVariables(rabattInputs);

	}

	private double getTotalPrice(Order order) {
		List<OrderPosition> positions = order.getOrderPositions();

		double totalPrice = 0.0;

		for (OrderPosition orderPosition : positions) {
			totalPrice += orderPosition.getArticle().getPrice() * orderPosition.getAmount();
		}

		return totalPrice;
	}

}
