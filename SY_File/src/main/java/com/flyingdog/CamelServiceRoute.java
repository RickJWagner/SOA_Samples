package com.flyingdog;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from:
	 * endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://Blabber").choice()
		  .when(body().contains("GOLD"))
		  .log("Gold customer! ${body}")
		  .otherwise()
		  .log("Not gold   + ${body}");
		}

}
