package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "org.example.GetOneIf")
public class GetOne {
	
	@WebMethod
	public String getOne(){
		try{
			System.out.println("getOne sleeps");
			Thread.sleep(500);
		}catch(Exception e){}
		return "One";
	}

}
