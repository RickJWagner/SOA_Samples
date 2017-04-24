package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.ByteArrayOutputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;


@WebServlet("/ProducerServlet")
public class ProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
// Before running, add SAAJQueue to EAP 7 with CLI:  jms-queue add --queue-address=SAAJQueue --entries=queue/SAAJQueue

// Run the demonstration by browsing to "http://localhost:8080/jboss-servlet-async/ProducerServlet"


	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String destinationName = "queue/SAAJQueue";
	     PrintWriter out = response.getWriter();
	     Context ic = null;
	     ConnectionFactory cf = null;
	     Connection connection =  null;
	     

	     try {         

         // This code mimics the Integration Layer for this demonstration.   It makes a SOAPMessage, then puts it in a JMS TextMessage.
         // If the IntegrationLayer is really sending something else (like an ObjectMessage) we just need to align the code in 
         // SoapMdb to reflect this.  (It's actually easier if we get a SOAPMessage instead of text)

           SOAPMessage soapmessage = createSOAPRequest();

           ByteArrayOutputStream outstream = new ByteArrayOutputStream();
           soapmessage.writeTo(outstream);
           String strMsg = new String(outstream.toByteArray());
           // Let's see it!
           System.out.println(strMsg);

	       ic = new InitialContext();

	       cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");
	       Queue queue = (Queue)ic.lookup(destinationName);

	       connection = cf.createConnection();
	       Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	       MessageProducer publisher = session.createProducer(queue);
	 
	       connection.start();

	       TextMessage message = session.createTextMessage(strMsg);
           
	       
	       publisher.send(message);

	       System.out.println("Message sento to the JMS Provider");
           out.println("Message sento to the JMS Provider");

	    }
	     catch (Exception exc) {
	       exc.printStackTrace();
           System.out.println(exc.getMessage());
	     }
	    finally {         


	      if (connection != null)   {
	        try {
	           connection.close();
	        } catch (JMSException e) {                    
	          e.printStackTrace();
	        }
	    } 
	  }
	 }

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     doGet(request, response);
	   }

        private SOAPMessage createSOAPRequest() throws Exception
        {
                MessageFactory messageFactory = MessageFactory.newInstance();
                SOAPMessage soapMessage = messageFactory.createMessage();
                SOAPPart soapPart = soapMessage.getSOAPPart();
               
                // Here's our SOAP message we're working with.  Just one attribute to make things easy to demonstrate.
                /*
                Construct SOAP Request Message:
                <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope"
                        xmlns:sam="http://samples.saaj.jms">
                   <soap:Header/>
                   <soap:Body>
                      <sam:getMachineName>
                         <!--Optional:-->
                         <sam:lineNumber>7</sam:lineNumber>
                      </sam:getMachineName>
                   </soap:Body>
                </soap:Envelope>
                 */

                // SOAP Envelope
                SOAPEnvelope envelope = soapPart.getEnvelope();
                envelope.addNamespaceDeclaration("sam", "http://samples.saaj.jms");

                // SOAP Body
                SOAPBody soapBody = envelope.getBody();
                SOAPElement soapBodyElem = soapBody.addChildElement("getMachineName", "sam");
                SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("lineNumber", "sam");
                soapBodyElem1.addTextNode("7");

                soapMessage.saveChanges();

                // Check the input
                System.out.println("Request SOAP Message = ");
                soapMessage.writeTo(System.out);
                System.out.println();
                return soapMessage;
        }
}
