// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jpa.webservices.UpdateStockAmountProxy;
import iis.project.jpa.entities.Article;
import iis.project.jpa.entities.Order;
import iis.project.jpa.entities.OrderPosition;
import iis.project.jpa.webservices.UpdateStockAmount;

public class CallUpdateStockAmount implements JavaDelegate {
    
    private static final String ORDER_VARIABLE = "order";

    UpdateStockAmount webService = new UpdateStockAmountProxy().getUpdateStockAmount();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        
        Order order = (Order) execution.getVariable(ORDER_VARIABLE);

        for (OrderPosition orderPosition : order.getOrderPositions())
        {
            webService.updateStockAmount(orderPosition.getArticle().getId(), 
                                         orderPosition.getAmount());            
        }
    }

}
