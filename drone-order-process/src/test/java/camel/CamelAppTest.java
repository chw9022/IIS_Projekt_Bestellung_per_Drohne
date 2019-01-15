// #######################################
// Author: Felix Ziegner
// #######################################
package camel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import iis.project.camel.CamelApp;
import iis.project.camel.routes.OrderArchiveRouteBuilder;

public class CamelAppTest {

	static {
		LogFactory.useSlf4jLogging();
	}

	@Before
	public void setup() throws Exception {

	}

	@Test
	public void runCamelApp() throws Exception {
		CamelApp camelApp = new CamelApp();
		assertFalse(camelApp.isStarted());
		camelApp.start();
		assertTrue(camelApp.isStarted());
		camelApp.stop();
		assertFalse(camelApp.isStarted());
	}

	@Test
	public void checkContainsOrderArchiveRouteBuilder() throws Exception {
		CamelApp camelApp = new CamelApp();
		assertTrue(listContainsObjectWithClass(camelApp.getRouteBuilders(), OrderArchiveRouteBuilder.class));
	}

	private boolean listContainsObjectWithClass(List<?> objectList, Class objectClass) {
		return objectList.stream().anyMatch(item -> item.getClass() == objectClass);
	}
}
