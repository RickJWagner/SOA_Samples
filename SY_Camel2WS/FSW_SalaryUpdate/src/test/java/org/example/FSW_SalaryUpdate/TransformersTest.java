package org.example.FSW_SalaryUpdate;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.Assert;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class)
public class TransformersTest {
	
/**

    @ServiceOperation("AnnualReview.incrementSalary")
    private Invoker incrementSalary;

    final String INPUT = "xml/input.xml";
    final String OUTPUT = "xml/output.xml";

    @Test
    public void testTransformXMLtoJava() throws Exception {

        OrderAck orderAck = submitOrder
            .inputType(QName.valueOf("{urn:switchyard-quickstart:bean-service:1.0}submitOrder"))
            .sendInOut(loadXML(ORDER_XML).getDocumentElement())
            .getContent(OrderAck.class);

        Assert.assertTrue(orderAck.isAccepted());

    }

    @Test
    public void testTransformJavaToXML() throws Exception {
    	
    	Associate inputAssociate = new Association();
    	inputAssociate.setName("Rick");
    	inputAssociate.setSalary(100000);
    	inputAssociate.setYearsOfService(5);

        Element result = incrementSalary
            .expectedOutputType(QName.valueOf("{urn:switchyard-quickstart:bean-service:1.0}submitOrderResponse"))
            .sendInOut(testOrder)
            .getContent(Element.class);
        XMLUnit.setIgnoreWhitespace(true);
        XMLAssert.assertXMLEqual(loadXML(ORDER_ACK_XML), result.getOwnerDocument());
    }

    private Document loadXML(String path) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.parse(getClass().getClassLoader().getResourceAsStream(path));
    }
**/
}