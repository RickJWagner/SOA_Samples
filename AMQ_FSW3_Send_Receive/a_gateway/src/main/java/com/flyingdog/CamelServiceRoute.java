package com.flyingdog;

import org.apache.camel.builder.RouteBuilder;
import javax.inject.Inject;



public class CamelServiceRoute extends RouteBuilder {


	/**
	 * The Camel route is configured via this method.  The from:
	 * endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://Blabber")
		  .log("### Gateway Got message ${body}")
		  .to("switchyard://OutgoingJMSIF?operationName=send");
		}

		

}
