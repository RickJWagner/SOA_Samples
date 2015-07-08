package org.sample.impl;


import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.sample.*;
import javax.jws.WebService;

@WebService(serviceName = "SalaryIncrement", endpointInterface = "org.sample.SalaryIncrementPortType", targetNamespace = "http://sample.org/SalaryIncrement/")
public class SalaryIncrementPortTypeImpl implements SalaryIncrementPortType {
	public int incrementSalary(int insalary) {
		System.out.println("*** Salary Increment runs! ***");
		// watch out it's an out param
		insalary = insalary + 2;
		return insalary;
	}
}