package org.namecleaning.impl;


import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.namecleaning.*;
import javax.jws.WebService;

@WebService(serviceName = "NameCleanup", endpointInterface = "org.namecleaning.NameCleanupPortType", targetNamespace = "http://www.text.standardization/NameCleanup/")
public class NameCleanupPortTypeImpl implements NameCleanupPortType {
	public java.lang.String nameCleanup(java.lang.String name) {
		System.out.println("###Name cleaner runs!##");
		return "Mr. " + name;
	}
}