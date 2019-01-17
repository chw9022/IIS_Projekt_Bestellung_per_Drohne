// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jpa.webservices.UpdateStockAmountProxy;
import iis.project.jpa.webservices.UpdateStockAmount;

public class CallUpdateStockAmount implements JavaDelegate {

    UpdateStockAmount webService = new UpdateStockAmountProxy().getUpdateStockAmount();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        
        // TODO: 
        // Has to be handled as soon as variables 
        // are available in Camunda-Context
        final int articleId = 1;
        final int amount = 10;
        webService.updateStockAmount(articleId, amount);
    }

}
