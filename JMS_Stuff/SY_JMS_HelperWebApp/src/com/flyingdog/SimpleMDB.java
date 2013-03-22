package com.flyingdog;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


// was using queue 'fdq1', but changed to 'test' so SY could consume fdq1
@MessageDriven(name = "SimpleMDB", activationConfig = {
		 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
		 @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })

public class SimpleMDB implements MessageListener {

	public void onMessage(Message message) {
	     TextMessage tm = (TextMessage) message;
	       try {
	         System.out.println("Received message "+tm.getText());
	       } catch (JMSException e) {
	        e.printStackTrace();
	       }
	 

	   }
}
