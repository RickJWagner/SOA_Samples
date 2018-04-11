package com.flyingdog;

import javax.inject.Inject;

import org.switchyard.component.bean.Service;
import org.switchyard.component.bean.Reference;

@Service(CreditingEvent.class)
public class CreditingEventBean implements CreditingEvent {
	
	@Inject @Reference
	OutgoingJMSIF outgoing;
	

	@Override
	public void send(String msg) {
		System.out.println("### CreditingEventBean gets message " + msg);
		outgoing.send(msg);
	}

}
