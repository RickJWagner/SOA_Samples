
package org.sample;


import org.apache.camel.builder.RouteBuilder;

public class CorrelationReadingRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("activemq:queue:someapp.matching.DoneMWEvent")
		.log("*********Received response from matcher service >> ${body}")
		.to("file:/home/rick/Junk/Camel/outFromCorrelationReadingRouteBuilder")
		.to("direct:EndService");
	}
	
	//	from("activemq:{{matcher.out.queue}}?selector=JMSCorrelationID LIKE'CREDITING%'")
	
	
	

}
