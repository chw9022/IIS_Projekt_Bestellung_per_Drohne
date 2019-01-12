
import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.init;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.processEngine;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import camel.CamelApp;
import jpa.entities.Order;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class BPMNTest {

	@ClassRule
	@Rule
	public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

	private static final String PROCESS_DEFINITION_KEY = "Process_0epxfrx";

	static {
		LogFactory.useSlf4jLogging(); // MyBatis
	}

	@Before
	public void setup() {
		init(rule.getProcessEngine());
	}

	@Test
	@Deployment(resources = "process.bpmn")
	public void testBpmnModelValidity() {

	}

	@Test
	@Deployment(resources = "process.bpmn")
	public void testBestellungArchivieren() throws Exception {
		CamelApp camelApp = new CamelApp();
		camelApp.start();
		ProcessInstance processInstance = processEngine().getRuntimeService()
				.createProcessInstanceByKey(PROCESS_DEFINITION_KEY).startBeforeActivity("bestellung_archivieren")
				.setVariable("order", new Order()).execute();
		assertThat(processInstance).isEnded();
		Thread.sleep(3000);
		camelApp.stop();
	}
}
