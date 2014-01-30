package org.switchyard.quickstarts.camel.jms.binding;

import org.switchyard.component.bean.Service;

@Service(NameEnhancer.class)
public class NameEnhancerBean implements NameEnhancer {

	@Override
	public String enhanceName(String name) {
		String ret = "The Honorable " + name;
		System.out.println("#### About to return: " + ret + "####");
		return ret;
	}

}
