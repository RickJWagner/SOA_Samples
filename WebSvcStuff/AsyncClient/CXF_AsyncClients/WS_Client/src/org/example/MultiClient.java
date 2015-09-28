package org.example;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;

public class MultiClient {
	
	private final String GET_ONE_WSDL = "http://localhost:8080/WebSvcs/GetOne?wsdl";
	private final String GET_ONE_URI = "http://example.org/";
	
	private final String GET_TWO_WSDL = "http://localhost:8080/WebSvcs/GetTwo?wsdl";
	private final String GET_TWO_URI = "http://secondnamespace.example.org/";
	
	
	public static void main(String[] args){
		
			MultiClient mc = new MultiClient();
			try {
				mc.runWebServiceCalls();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} 
			
	}

	public SOAPMessage makeGetOneRequest() throws MalformedURLException, SOAPException{
		MessageFactory mf = MessageFactory.newInstance();
	    SOAPMessage soapRequest = mf.createMessage();
	    final SOAPPart soapPart = soapRequest.getSOAPPart();
	    final SOAPEnvelope envelope = soapPart.getEnvelope();
	    
	    // Start manipulating request
	    envelope.addNamespaceDeclaration("exam", GET_ONE_URI);
	    
	    QName getOneQName = new QName(GET_ONE_URI, "getOne");
	    
	    SOAPElement getOneResp = soapRequest.getSOAPBody().addChildElement(getOneQName);
	    soapRequest.saveChanges();	
	    /* Print the request message */
	    //System.out.print("Request SOAP Message = ");
	    //soapRequest.writeTo(System.out);
	    //System.out.println();
	    return soapRequest;
	}

	public SOAPMessage makeGetTwoRequest() throws MalformedURLException, SOAPException{
		MessageFactory mf = MessageFactory.newInstance();
	    SOAPMessage soapRequest = mf.createMessage();
	    final SOAPPart soapPart = soapRequest.getSOAPPart();
	    final SOAPEnvelope envelope = soapPart.getEnvelope();
	    
	    // Start manipulating request
	    envelope.addNamespaceDeclaration("exam", GET_TWO_URI);
	    
	    QName getTwoQName = new QName(GET_TWO_URI, "getTwo");
	    
	    SOAPElement theElement = soapRequest.getSOAPBody().addChildElement(getTwoQName);
	    soapRequest.saveChanges();	
	    return soapRequest;
	}
	
/** *************************************************************************************** **/	
	
	
	
	public Dispatch<SOAPMessage> makeGetOneDispatch() throws MalformedURLException{
	    QName domProvider = new QName(GET_ONE_URI, "GetOneService");
	    QName portName = new QName(GET_ONE_URI, "GetOnePort");
	
	    URL wsdlUrl = new URL(GET_ONE_WSDL);
	    Service service = Service.create(wsdlUrl, domProvider);  
	    Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
	    return dispatch;
	}
	
	public Dispatch<SOAPMessage> makeGetTwoDispatch() throws MalformedURLException{
	    QName domProvider = new QName(GET_TWO_URI, "GetTwoService");
	    QName portName = new QName(GET_TWO_URI, "GetTwoPort");
	
	    URL wsdlUrl = new URL(GET_TWO_WSDL);
	    Service service = Service.create(wsdlUrl, domProvider);  
	    Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
	    return dispatch;
	}
	
/** ******************************************************************************************* **/

	
	
	
	public void runWebServiceCalls() throws SOAPException, IOException, InterruptedException, ExecutionException{
	
		SOAPMessage getOneRequest = makeGetOneRequest();
	    Dispatch<SOAPMessage> getOneDispatch = makeGetOneDispatch();
	    
		SOAPMessage getTwoRequest = makeGetTwoRequest();
	    Dispatch<SOAPMessage> getTwoDispatch = makeGetTwoDispatch();

		String origDump = generateThreadDump();
		System.out.println(origDump);
		System.out.println("********** End original thread dump ***********");
	    
	    
		// Send the requests
		Response<SOAPMessage> domResponseMsgOne = getOneDispatch.invokeAsync(getOneRequest);
		Response<SOAPMessage> domResponseMsgTwo = getTwoDispatch.invokeAsync(getTwoRequest);
		
		String secondDump = generateThreadDump();
		System.out.println(secondDump);
		System.out.println("********** End second thread dump ***********");

		
		while ( (!domResponseMsgOne.isDone()) && (!domResponseMsgTwo.isDone())){
			//System.out.println("Waiting!");
			
		}
		domResponseMsgOne.get().writeTo(System.out);
		System.out.println("");
		domResponseMsgTwo.get().writeTo(System.out);
	    
	}
	
    public static String generateThreadDump() {
        final StringBuilder dump = new StringBuilder();
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
        for (ThreadInfo threadInfo : threadInfos) {
            dump.append('"');
            dump.append(threadInfo.getThreadName());
            dump.append("\" ");
            final Thread.State state = threadInfo.getThreadState();
            dump.append("\n   java.lang.Thread.State: ");
            dump.append(state);
            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
            for (final StackTraceElement stackTraceElement : stackTraceElements) {
                dump.append("\n        at ");
                dump.append(stackTraceElement);
            }
            dump.append("\n\n");
        }
        return dump.toString();
    }	




	


}
