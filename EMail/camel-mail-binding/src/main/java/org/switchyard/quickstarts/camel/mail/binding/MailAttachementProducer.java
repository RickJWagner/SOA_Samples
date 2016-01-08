package org.switchyard.quickstarts.camel.mail.binding;

import javax.activation.DataHandler;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

@Named("mailAttachementProducer")
@ApplicationScoped

public class MailAttachementProducer implements Processor {


    @Override
    public void process(final Exchange exchange) {
        final Message in = exchange.getIn();
        final byte[] file = in.getBody(byte[].class);
        in.setBody("You'll find data you requested attached!");
        in.addAttachment("body_as_attachment.txt", new DataHandler(file, "plain/text"));
        System.out.println("MailAttachementProducer has used DataHandler");
    }

 

}
