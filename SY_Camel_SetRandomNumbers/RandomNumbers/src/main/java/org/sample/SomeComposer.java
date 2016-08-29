package org.sample;

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

public class SomeComposer extends BaseMessageComposer<CamelBindingData> {
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Message compose(CamelBindingData source, Exchange exchange) throws Exception {
        Message message = exchange.createMessage();
        
        org.apache.camel.Message sourceMessage = source.getMessage();
        
        
        
        Random rand = new Random();
        int  n = rand.nextInt(100) + 1;
        String text = "This is the current random number:" + n;

        message.setContent(text);
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