package org.switchyard.quickstarts.camel.jms.binding;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://GreetingService").log(
				"Received message for 'GreetingService' : ${body}")
				.to("switchyard://RefInterface");
	}

}
