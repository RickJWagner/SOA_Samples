package org.sample;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
//@SOAPBinding(style = Style.RPC)
public interface Greeter {
	
		@WebMethod String greet(String name);

}
