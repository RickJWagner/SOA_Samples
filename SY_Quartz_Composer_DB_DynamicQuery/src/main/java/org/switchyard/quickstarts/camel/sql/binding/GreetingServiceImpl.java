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
package org.switchyard.quickstarts.camel.sql.binding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.ReferenceInvocation;
import org.switchyard.component.bean.ReferenceInvoker;
import org.switchyard.component.bean.Service;

/**
 * Implementation of greeting service.
 */
@Service(GreetingService.class)
public class GreetingServiceImpl implements GreetingService {

	
    @Inject @Reference("RemoveService")
    private ReferenceInvoker theReference;

    
    @Override
    public String listCustomers(List <String> params) throws Exception{
    	
    	System.out.println("Got request!");
    	for (String param : params){
    		System.out.println(param);
    	}
    	
    	System.out.println("Going to get Companies");
    	
    	
    	
    	List<String> ret = getCustomerCompanies(params);
    	
    	
    	System.out.println("Got list:" + ret.toString());
    	for (String company : ret){
    		System.out.println(company);
    	}

    	return ret.toString();
    }
    
    
    public List getCustomerCompanies(List<String> customers) throws Exception{
    	
    	int numCustomers = customers.size();
    	int numDone = 0;
    	
    	StringBuilder sb = new StringBuilder();
    	// select * from customers  where name in ('Sam','Fred');
    	sb.append("select * from customers where name in (");
    	for (String customer:customers){
    		sb.append("'" + customer + "'");
    		numDone += 1;
    		if (numDone < numCustomers){
    			sb.append(",");
    		}
        }
    	sb.append(");");
    	String theQuery = sb.toString();
    	System.out.println("Just made query:" + theQuery);
    	
    	ArrayList<String> ret = new ArrayList<String>();
    	
    	
    	  ReferenceInvocation queryResult = theReference.newInvocation("execute")
          .setProperty("CamelSqlQuery", theQuery)
          .invoke();
    	  
    	  ret.add(queryResult.getMessage().toString());
    	
    	return ret;
    }

    


 
    
}
