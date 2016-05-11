package org.switchyard.quickstarts.camel.sql.binding;

import javax.inject.Named;

import org.apache.camel.Message;

@Named("headersetter")
public class HeaderSetter {
	  
        public void foo(Message message) {   
        	message.setHeader("message1", "A first message");
        	message.setHeader("message2", "A second message");
        }  
}  	
