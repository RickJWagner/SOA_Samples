package org.switchyard.quickstarts.camel.sql.binding;

import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;

public class GreetingServiceRoute extends RouteBuilder {

	String message1 = "A first message";
	String message2 = "A second message";
	
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://GreetingService")
		.log("Received message for 'GreetingService' : ${body}")
		.to("bean:headersetter")
		.to("bean:querysetter")
		.to("switchyard://StoreService")
		.log("Done!");
	}

}
