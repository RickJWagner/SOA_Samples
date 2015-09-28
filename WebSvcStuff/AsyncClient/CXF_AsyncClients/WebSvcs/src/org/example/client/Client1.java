package org.example.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;




public class Client1 {
	
	
	public static void main(String[] args) throws MalformedURLException{
		Client1 c1 = new Client1();
		c1.runTest();
	}
	
	public void runTest() throws MalformedURLException{
		/**
		URL wsdlURL = new URL("http://localhost:8080/WebSvcs/Uppercaser?wsdl");
		QName SERVICE_NAME = new QName("http://example.org/", "UppercaserService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		UppercaserIf client = service.getPort(UppercaserIf.class);
		String result = client.makeUpper("test");
		System.out.println("Done!  Results:" + result);
		**/
	}
}
