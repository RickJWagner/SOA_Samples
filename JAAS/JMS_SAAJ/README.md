This project contains a servlet that uses SAAJ to make a SOAPMessage, then it puts the SOAPMessage as a String to a JMS queue.

The message is received by an MDB, which shows how to use SAAJ to parse a SOAPMessage.

Both parts run on EAP 7.

Before running, add SAAJQueue to EAP 7 with CLI:  jms-queue add --queue-address=SAAJQueue --entries=queue/SAAJQueue

Run the demonstration by browsing to "http://localhost:8080/jboss-servlet-async/ProducerServlet"
