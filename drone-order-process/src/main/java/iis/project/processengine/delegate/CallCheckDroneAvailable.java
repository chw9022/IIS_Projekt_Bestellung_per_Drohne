// #######################################
// Author: Christian Wittmann
// #######################################
package iis.project.processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import iis.project.jpa.webservices.CheckDroneAvailable;
import iis.project.jpa.webservices.CheckDroneAvailableProxy;


public class CallCheckDroneAvailable implements JavaDelegate {
 
    CheckDroneAvailable webService = new CheckDroneAvailableProxy().getCheckDroneAvailable();
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("droneAvailable", webService.checkDroneAvailable());
    }
}
