// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jpa.entities.Order;
import iis.project.jpa.webservices.CheckDroneAvailable;
import iis.project.jpa.webservices.CheckDroneAvailableProxy;


public class CallCheckDroneAvailable implements JavaDelegate {
 
    private static final int NOT_AVAILABLE = 0;
    private static final String ORDER_VARIABLE = "order";
    private static final String DRONE_AVAILABLE_VARIABLE = "droneAvailable";
    
    CheckDroneAvailable webService = new CheckDroneAvailableProxy().getCheckDroneAvailable();    
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
                
        int droneId = webService.getIdOfAvailableDrone(); // returns 0 if no drone available
        Order order = (Order) execution.getVariable(ORDER_VARIABLE);
        
        order.setDroneId(droneId); 
        
        if (droneId != NOT_AVAILABLE) {
            execution.setVariable(DRONE_AVAILABLE_VARIABLE, true);
        }
        else {
            execution.setVariable(DRONE_AVAILABLE_VARIABLE, false);
        }
    }
}
