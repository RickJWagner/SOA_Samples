package org.example.FSW_SalaryUpdate;

import java.io.StringReader;
import java.util.HashMap;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SalaryUpdateRoute extends RouteBuilder {
	
	// Not production strength, need to manage concurrency
	// i.e. could keep a HashMap keyed by ExchangeId
	
	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://AnnualReview")
		.log("Received message for 'AnnualReview' : ${body}")
		// Input has arrived in the form of an XML blob.  Need a different blob for name cleaner web service
		.process(new Processor() {  
                    @Override  
                    public void process(Exchange exchange) throws Exception {  
                        //System.out.println("Type of input is now:" + exchange.getIn().getBody().getClass().getName());  
                        Element theInput = (Element)exchange.getIn().getBody();
            	        NodeList nodes = theInput.getElementsByTagName("name");
            	        String theName = "Not Found";
            	        if (nodes.getLength() > 0) {
            	            theName = nodes.item(0).getChildNodes().item(0).getNodeValue();
            	        }
                        System.out.println("theName" + theName);
                        // Make a NameClean so SwitchYard will be happy transforming something it recognizes
                        NameClean nameclean = new NameClean();
                        nameclean.setName(theName);
                        exchange.getOut().setBody(nameclean);
                    }   
                    })
		.to("switchyard://NameCleanupPortType")
		// extract payload from NameCleaning
		.process(new Processor() {  
                    @Override  
                    public void process(Exchange exchange) throws Exception {  
                    	Element theInput = (Element)exchange.getIn().getBody();
            	        NodeList nodes = theInput.getElementsByTagName("cleanedName");
            	        String theName = "Not Found";
            	        if (nodes.getLength() > 0) {
            	            theName = nodes.item(0).getChildNodes().item(0).getNodeValue();
            	        }
                    	//NameClean theOutput = (NameClean)exchange.getIn().getBody();
                        System.out.println("theName after cleanup" + theName);
                    }   
                    })

		
		// setup Salary increment  payload is still output of name cleaning 

		.process(new Processor() {  
                    @Override  
                    public void process(Exchange exchange) throws Exception {  
                        System.out.println("Type of input is now:" + exchange.getIn().getBody().getClass().getName());  
                        // Make a SalaryHolder so SwitchYard will be happy transforming something it recognizes
                        SalaryHolder salaryHolder = new SalaryHolder();
                        salaryHolder.setSalary(1000);
                        exchange.getOut().setBody(salaryHolder);
                    }   
                    })    
      .to("switchyard://SalaryIncrementPortType")                             
        // extract payload from Salary increment
      		.process(new Processor() {  
                    @Override  
                    public void process(Exchange exchange) throws Exception {  
                    	System.out.println("starting retreive output from salary increment");
                    	Element theInput = (Element)exchange.getIn().getBody();
            	        NodeList nodes = theInput.getElementsByTagName("updatedsalary");
            	        String theSalary = "Not Found";
            	        if (nodes.getLength() > 0) {
            	            theSalary = nodes.item(0).getChildNodes().item(0).getNodeValue();
            	        }
                        System.out.println("the Salary after cleanup" + theSalary);
                    }   
                    })

		
		
		
		
		// Provide final output
		.process(new Processor() {  
                    @Override  
                    public void process(Exchange exchange) throws Exception {  
                        //Message in = exchange.getIn();
                        Associate ret = new Associate();
                        ret.setName("Rick");
                        ret.setSalary(500);
                        ret.setYearsOfService(5);
                        exchange.getOut().setBody(ret);
                    }   
                     })
         .log("Done");
	}
}



