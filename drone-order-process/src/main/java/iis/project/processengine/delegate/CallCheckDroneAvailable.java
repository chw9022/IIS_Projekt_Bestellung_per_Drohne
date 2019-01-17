// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jpa.webservices.CheckDroneAvailable;
import iis.project.jpa.webservices.CheckDroneAvailableProxy;


public class CallCheckDroneAvailable implements JavaDelegate {
 
    private static final int NOT_AVAILABLE = 0;
    
    CheckDroneAvailable webService = new CheckDroneAvailableProxy().getCheckDroneAvailable();
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
                
        int droneId = webService.getIdOfAvailableDrone();
        if (droneId != NOT_AVAILABLE) {
            execution.setVariable("droneAvailable", true);
            execution.setVariable("droneId", droneId);
        }
        else {
            execution.setVariable("droneAvailable", false);
            execution.setVariable("droneId", NOT_AVAILABLE);
        }
    }
}
