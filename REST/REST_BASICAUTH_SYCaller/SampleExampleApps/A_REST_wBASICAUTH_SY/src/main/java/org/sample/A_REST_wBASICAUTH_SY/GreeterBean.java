package org.sample.A_REST_wBASICAUTH_SY;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(Greeter.class)
public class GreeterBean implements Greeter {
	
	@Reference
	@Inject
	private ExternalSvcCallerResource svcCaller;

	@Override
	public void greet() {
		System.out.println("### Greeting starts! ###");
		String svcRet = svcCaller.callExternalSvc("John Doe");
		System.out.println("### Greeting back. Got response: " + svcRet + " ###");
		
		
		
	}

}
