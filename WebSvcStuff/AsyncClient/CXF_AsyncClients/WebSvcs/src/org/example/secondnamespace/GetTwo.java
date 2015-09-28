package org.example.secondnamespace;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "org.example.secondnamespace.GetTwoIf")
public class GetTwo {
	
	@WebMethod
	public String getTwo(){
		try{
			System.out.println("getTwo sleeps");
			Thread.sleep(500);
		}catch(Exception e){}
		
		return "Two";
	}

}
