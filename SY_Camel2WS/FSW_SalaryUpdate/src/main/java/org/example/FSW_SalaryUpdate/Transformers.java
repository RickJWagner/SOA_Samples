package org.example.FSW_SalaryUpdate;

import java.io.StringReader;

import javax.inject.Named;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class Transformers {
	@Named("Transformers")
	
	    private static final String NAME = "name";
	    private static final String YEARS_SERVICE = "service";
	    private static final String SALARY = "salary";

	    /**
	     * Transform from a DOM element to an Associate instance.
	     */
	    @Transformer(from = "{http://www.example.org/SalaryReview/}SalaryReviewRequest")
	    public Associate transform(Element from) {
	       Associate ret = new Associate();
	       ret.setName(getElementValue(from, NAME));
	       ret.setSalary(Integer.getInteger(getElementValue(from, SALARY)).intValue());
	       ret.setYearsOfService(Integer.getInteger(getElementValue(from, YEARS_SERVICE)).intValue());
	       return ret;
	    }

	    //@Transformer(to = "{http://www.example.org/SalaryReview/}SalaryReviewResponse")
	    @Transformer(to = "java:org.w3c.dom.Node")
	    public Node transform(Associate associate) {    	
	    	System.out.println("output xform begins!");
	        StringBuffer ackXml = new StringBuffer()
	        
	        .append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
	        .append("<soap:Body>")
	        .append("<ns2:SalaryReviewResponse xmlns:ns2=\"http://www.example.org/SalaryReview/\">")
	        .append("<name>Rick</name>")
	        .append("<salary>100000</salary>")
	        .append("</ns2:SalaryReviewResponse>")
	        .append("</soap:Body>")
	        .append("</soap:Envelope>");
	        
	        return (Node) toElement(ackXml.toString());
	    }
	    
	   
	    @Transformer(to = "java:org.w3c.dom.Node")
	    public Node transform(NameClean nameclean) {    	
	    	System.out.println("output xform begins!");
	        StringBuffer ackXml = new StringBuffer()
            .append("<nam:NameCleanup xmlns:nam=\"http://www.text.standardization/NameCleanup/\" >")
            .append("<name>" + nameclean.getName() + "</name>")
            .append("</nam:NameCleanup>");

	        return (Node) toElement(ackXml.toString());
	    }	    
	    
	    @Transformer(to = "java:org.w3c.dom.Node")
	    public Node transform(SalaryHolder salaryHolder) {    	
	    	System.out.println("output xform for salaryHolder begins!");
	        StringBuffer ackXml = new StringBuffer()
            .append("<sal:IncrementSalary xmlns:sal=\"http://sample.org/SalaryIncrement/\" >")
            .append("<insalary>1000</insalary>")
            .append("</sal:IncrementSalary>");
	        return (Node) toElement(ackXml.toString());
	    }	    

	    
	    
	    /**
	     * Returns the text value of a child node of parent.
	     */
	    private String getElementValue(Element parent, String elementName) {
	        String value = null;
	        NodeList nodes = parent.getElementsByTagName(elementName);
	        if (nodes.getLength() > 0) {
	            value = nodes.item(0).getChildNodes().item(0).getNodeValue();
	        }
	        return value;
	    }

	    private Element toElement(String xml) {
	        DOMResult dom = new DOMResult();
	        try {
	            TransformerFactory.newInstance().newTransformer().transform(
	                    new StreamSource(new StringReader(xml)), dom);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        return ((Document)dom.getNode()).getDocumentElement();
	    }
	}