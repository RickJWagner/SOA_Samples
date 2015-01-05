package org.switchyard.quickstarts.camel.sql.binding;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.namespace.QName;

import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.common.xml.QNameUtil;
import org.switchyard.component.camel.common.composer.CamelBindingData;
import org.switchyard.component.common.composer.BaseMessageComposer;
import org.switchyard.component.common.composer.ContextMapper;
import org.switchyard.component.common.composer.MessageComposer;

public class SimpleComposer extends BaseMessageComposer<CamelBindingData> {
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Message compose(CamelBindingData source, Exchange exchange) throws Exception {
        Message message = exchange.createMessage();
        
        org.apache.camel.Message sourceMessage = source.getMessage();
        
        
        
        Random rand = new Random();
        int  n = rand.nextInt(5) + 1;
        
        ArrayList<String> al = new ArrayList<String>();
        if (1 == n){
        	al.add("Sam");	
        }else if (2 == n){
        	al.add("Sam");
        	al.add("Larry");
        }else if (3 == n){
        	al.add("Larry");
        	al.add("Richard");
        }
        else if (4 == n){
        	al.add("Larry");
        	al.add("Richard");
            al.add("Sam");        	
        }else{
        	al.add("Bill");
        }
        
        message.setContent(al);
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CamelBindingData decompose(Exchange exchange, CamelBindingData target) throws Exception {
        return null;
    }
    
}
