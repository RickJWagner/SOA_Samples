package com.example.switchyard.SY_JMS1;

import org.switchyard.component.bean.Service;

@Service(Echo.class)
public class EchoBean implements Echo {
	
	public void echo(String str){
		System.out.println("ECHOING the msg! " + str);
	}

}
