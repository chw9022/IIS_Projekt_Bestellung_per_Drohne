package iis.project.drone_order_process;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Process Application exposing this application's resources the process engine.
 */
@ProcessApplication
public class CamundaBpmProcessApplication extends ServletProcessApplication {

	private static final String PROCESS_DEFINITION_KEY = "Process_Order_per_Drone";

	/**
	 * In a @PostDeploy Hook you can interact with the process engine and access the
	 * processes the application has deployed.
	 * 
	 */
	@PostDeploy
	public void onDeploymentFinished(ProcessEngine processEngine) throws JsonProcessingException {
	}
}
