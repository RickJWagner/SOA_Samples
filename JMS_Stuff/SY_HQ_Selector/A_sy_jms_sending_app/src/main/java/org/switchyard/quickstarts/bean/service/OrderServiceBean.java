/*
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.switchyard.quickstarts.bean.service;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.Exchange;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.ReferenceInvocation;
import org.switchyard.component.bean.ReferenceInvoker;
import org.switchyard.component.bean.Service;

@Service(OrderService.class)
public class OrderServiceBean implements OrderService {
    
    /*@Inject @Reference
    private InventoryService _inventory;*/    
    
    @Inject
    @Reference("InventoryService")
    private ReferenceInvoker _inventory;
    
    @Inject
    @Reference("AORJMSOUTInterface")
    private ReferenceInvoker jmsOutReference;
    
    @Inject
    private Exchange exchange;
    
    
    /*@Inject 
    @Reference("AORJMSOUTInterface")
    private AORJMSOUTInterface referenceInvoker;*/
    
    @Override
    public OrderAck submitOrder(Order order) {
    	
    	pushMessageToQueue("ABCD");    	
    	
        // Create an order ack
        OrderAck orderAck = new OrderAck().setOrderId(order.getOrderId());
        // Check the inventory
        try {        	
            //Item orderItem = _inventory.lookupItem(order.getItemId());        	
        	
        	ReferenceInvocation refInv = _inventory.newInvocation("lookupItem").setProperty("Property_A", "value_A").invoke(order.getItemId());
        	Item orderItem = (Item) refInv.getMessage().getContent();
            // Check quantity on hand and generate the ack
            if (orderItem.getQuantity() >= order.getQuantity()) {
                orderAck.setAccepted(true).setStatus("Order Accepted");
            } else {
                orderAck.setAccepted(false).setStatus("Insufficient Quantity");
            }
        } catch (ItemNotFoundException infEx) {
            orderAck.setAccepted(false).setStatus("Item Not Available");
        }	catch(Exception e)
        {
        	e.printStackTrace();
        }
        return orderAck;
    }
    
    private void pushMessageToQueue(String message) {
    	try {
    		jmsOutReference.newInvocation("sendEvent").setProperty("LABEL", "ME").invoke(message);    		
    		//jmsOutReference.sendEvent(message);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
