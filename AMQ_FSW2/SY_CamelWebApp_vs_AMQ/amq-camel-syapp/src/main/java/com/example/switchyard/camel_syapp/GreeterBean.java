package com.example.switchyard.camel_syapp;

import org.switchyard.component.bean.Service;

@Service(Greeter.class)
public class GreeterBean implements Greeter {

	@Override
	public String greet(String msg) {
		System.out.println("GreeterBean runs!" + msg);
		return "Hello " + msg;
	}

}
