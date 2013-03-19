package com.flyingdog;

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
public class BlabberTest {

	@ServiceOperation("Blabber")
	private Invoker service;

	@Test
	public void testBlabber() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String message = "FOO";
		String result = service.operation("blabber").sendInOut(message)
				.getContent(String.class);

		// validate the results
		Assert.assertEquals("FOO Has been BLABBERED", result);
		
	}

}
