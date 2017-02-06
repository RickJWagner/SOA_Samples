/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated 
 * by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors. 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 * 
 * (C) 2005-2006,
 * @author JBoss Inc.
 */
package org.jboss.soa.esb.samples.quickstart.scheduler;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.actions.ActionProcessingException;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyBasicAction extends AbstractActionLifecycle
{
    
  protected ConfigTree	_config;
	  
  public MyBasicAction(ConfigTree config) { _config = config; } 
  
  public Message noOperation(Message message) { return message; } 

  public Message process(Message message) {
	  System.out.println("The default method called");
	  return message;	 
	  
  }
  /*
  public Message displayMessage(Message message) throws ActionProcessingException {		
		  String content =  (String) message.getBody().get();
		  HashMap myMap = (HashMap) message.getBody().get("MyStuff");
		  Object x = message.getBody().get();
		  logHeader();
		  System.out.println(myMap);
		  System.out.println("Body: " + content);
		  System.out.println(x.getClass().getName());
		  HashMap anotherMap = (HashMap) x;
		  System.out.println(anotherMap.get("Key1"));
		  logFooter();
		  message.getBody().setByteArray(new String(content + " " + new java.util.Date()).getBytes());
		  return message;         	
	}
  */
  public Message displayMessage2(Message message) throws Exception {
	  System.out.println("### ESB Action running! ###");	
	   URL url = new URL("http://localhost:8080/jboss-helloworld-rs/rest/json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("### Output from Server ....### \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		conn.disconnect();



	 String content =  (String) message.getBody().get();
	  logHeader();
	  System.out.println("Body: " + content);
	  logFooter();
	  message.getBody().add(content + " " + new java.util.Date());
	  return message;
}
   
   public Message causesException(Message message) throws ActionProcessingException {
   		throw new ActionProcessingException("BAD STUFF HAPPENED");
   }
   
   public void exceptionHandler(Message message, Throwable exception) {
	   logHeader();
	   System.out.println("!ERROR!");
	   System.out.println(exception.getMessage());
	   System.out.println("For Message: ");
	   System.out.println(message.getBody().get());
	   logFooter();
   }
	

   // This makes it easier to read on the console
   private void logHeader() {
	   System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
   }
   private void logFooter() {
	   System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
   }
    
	
}