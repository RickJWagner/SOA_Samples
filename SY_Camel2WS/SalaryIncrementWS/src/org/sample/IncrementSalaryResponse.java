
package org.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updatedsalary" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "updatedsalary"
})
@XmlRootElement(name = "IncrementSalaryResponse")
public class IncrementSalaryResponse {

    protected int updatedsalary;

    /**
     * Gets the value of the updatedsalary property.
     * 
     */
    public int getUpdatedsalary() {
        return updatedsalary;
    }

    /**
     * Sets the value of the updatedsalary property.
     * 
     */
    public void setUpdatedsalary(int value) {
        this.updatedsalary = value;
    }

}
