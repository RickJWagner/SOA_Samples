package org.sample;

import javax.xml.ws.Endpoint;

public class EndpointPublisher {
	
	public static void main(String[] args){
		Endpoint.publish("http://localhost:9090/ws/hello", new GreeterImpl());
	}

}
