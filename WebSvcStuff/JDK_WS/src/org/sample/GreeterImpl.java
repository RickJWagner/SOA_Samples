package org.sample;

import javax.jws.WebService;

@WebService(endpointInterface = "org.sample.Greeter")
public class GreeterImpl implements Greeter {
	
	public String greet (String who){
		return "Why hello " + who;
	}

}
