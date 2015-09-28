package org.example.secondnamespace;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface GetTwoIf {
	
	@WebMethod
	public String getTwo();

}
