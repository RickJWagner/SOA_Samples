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

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import javax.naming.Context;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service(OrderService.class)
public class OrderServiceBean implements OrderService {
    
    @Inject @Reference
    private InventoryService _inventory;
    
    @Override
    public OrderAck submitOrder(Order order) {

	Connection con = null;
	PreparedStatement preparedStatementInsert = null;
	
	try{
		javax.naming.Context ic = new javax.naming.InitialContext();
		javax.naming.Context ctx = (javax.naming.Context) ic.lookup("java:");
		javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("jboss/datasources/MariaDBDS");
		con = ds.getConnection();
		con.setAutoCommit(false);
		String insertTableSQL = "insert into jpa_test.test_tbl (msg, msg2) values (?,?)";
		preparedStatementInsert = con.prepareStatement(insertTableSQL);
		preparedStatementInsert.setString(1, "hello");
		preparedStatementInsert.setString(2, "world");
		preparedStatementInsert.executeUpdate(); //data IS NOT commit yet	
		con.commit(); //transaction block end	
		con.close();
        }
        catch(Exception exc){
            System.out.println("### Got an Exception! " + exc.getMessage() + " ###");
        }


        // Create an order ack
        OrderAck orderAck = new OrderAck().setOrderId(order.getOrderId());
        // Check the inventory

        
        System.out.println("### OrderServiceBean runs! ###");
        try {
            Item orderItem = _inventory.lookupItem(order.getItemId());
            // Check quantity on hand and generate the ack
            if (orderItem.getQuantity() >= order.getQuantity()) {
                orderAck.setAccepted(true).setStatus("Order Accepted");
            } else {
                orderAck.setAccepted(false).setStatus("Insufficient Quantity");
            }
        } catch (ItemNotFoundException infEx) {
            orderAck.setAccepted(false).setStatus("Item Not Available");
        }
        return orderAck;
    }



}
