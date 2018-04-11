package com.flyingdog;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(Event.class)
public class EventBean implements Event {
	
	@Inject @Reference
	OutgoingJMSIF outgoing;

	@Override
	public void send(String msg) {
		System.out.println("### EventBean gets message " + msg);
		outgoing.send(msg);	
	}
	
	

}
