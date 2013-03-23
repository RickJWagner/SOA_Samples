package com.example.switchyard.SY_JMS1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class EchoTest {

	@ServiceOperation("Echo")
	private Invoker service;

	@Test
	public void testEcho() throws Exception {
		String message = "Hello!!!";
		service.operation("echo").sendInOnly(message);

		// validate the results
		Assert.assertTrue("Implement me", true);
	}

}
