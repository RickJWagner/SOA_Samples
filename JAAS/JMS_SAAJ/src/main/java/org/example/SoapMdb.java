package org.example;

import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import java.util.Iterator;
import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;


@MessageDriven(name = "SoapMdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/SAAJQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class SoapMdb implements MessageListener {

    private final static Logger LOGGER = Logger.getLogger(SoapMdb.class.toString());
    public void onMessage(Message rcvMessage) {

        // In this example, we are getting a TextMessage that represents the SOAPMessage.  
        // If the Integration Layer is putting an ObjectMessage (i.e. it's a 'real' SOAPMessage already) we can skip this step.

        TextMessage msg = null;
        try {
            if (rcvMessage instanceof TextMessage) {
                msg = (TextMessage) rcvMessage;
                LOGGER.info("Received Message from queue: " + msg.getText());
            } else {
                LOGGER.warning("Message of wrong type: " + rcvMessage.getClass().getName());
            }



            SOAPMessage soapmessage = getSoapMessageFromString(msg.getText());

            // Ok, so now we have a SOAPMessage.  Let's parse it to demonstrate our MDB can work with the SOAP without CXF involved.

            parseSOAP(soapmessage);

        } catch (Exception e) {
            System.out.println("### Got an Exception:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private SOAPMessage getSoapMessageFromString(String xml) throws Exception {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }


    // this method navigates right to the Line Number in the message we sent.
    // If we want more navigational control, The SOAPMessage can easily be made into
    // an XML 'Document' for easier navigation.

    // If we have multiple message formats to work with, we could easily have a 'switch' based on some indicator, maybe a JMS property or
    //  part of the SOAPMessage itself.
    private void parseSOAP(SOAPMessage soapmessage) throws Exception
    {
        SOAPEnvelope envelope = soapmessage.getSOAPPart().getEnvelope();
        SOAPBody body = envelope.getBody();
        Iterator iter = body.getChildElements();
        SOAPElement response = (SOAPElement) iter.next();
        iter = response.getChildElements();
        SOAPElement result = (SOAPElement) iter.next();
        System.out.println("The machine's line Number is:" + result.getValue());
    }


    
}
