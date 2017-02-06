package org.jboss.as.quickstarts.rshelloworld;

import javax.ejb.Stateful;

@Stateful
public class GreeterEJB {

	public String sayHello(String name) {
		System.out.println("### EJB method 'sayHello' called ###");
        return "Hello " + name;
    }
}
