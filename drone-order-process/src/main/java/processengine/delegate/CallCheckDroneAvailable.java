// #######################################
// Author: Christian Wittmann
// #######################################
package processengine.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import jpa.webservices.artefacts.CheckDroneAvailable;
import jpa.webservices.artefacts.CheckDroneAvailableProxy;


public class CallCheckDroneAvailable implements JavaDelegate {
 
    CheckDroneAvailable webService = new CheckDroneAvailableProxy().getCheckDroneAvailable();
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("droneAvailable", webService.checkDroneAvailable());
    }
}
