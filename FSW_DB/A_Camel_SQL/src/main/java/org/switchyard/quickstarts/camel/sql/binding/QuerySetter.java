package org.switchyard.quickstarts.camel.sql.binding;

import javax.inject.Named;

import org.apache.camel.Message;

@Named("querysetter")
public class QuerySetter {
	  
        public void foo(Message message) {   
        	String msg1 = (String) message.getHeader("message1");
        	String msg2 = (String) message.getHeader("message2");
        	String theQuery = "insert into jpa_test.test_tbl (msg, msg2) values (" + "\"" + msg1 + "\""  + ","  + "\""  + msg2  + "\"" + ")";
        	System.out.println("The query:" + theQuery);
        	message.setHeader("CamelSqlQuery", theQuery);
        }  
}  	
