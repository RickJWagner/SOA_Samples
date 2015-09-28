package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface GetOneIf {
	
	@WebMethod
	public String getOne();

}
