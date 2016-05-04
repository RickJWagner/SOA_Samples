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

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.Exchange;
import org.switchyard.component.bean.Service;

@Service(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    private final Map<String, Item> _inventory = new HashMap<String, Item>();
    
    @Inject
    private Exchange exchange;
    
    @Inject
    private Context context;
    
    public InventoryServiceBean() {
        Item butter = new Item()
            .setItemId("BUTTER")
            .setName("Not Parkay")
            .setQuantity(1000);
        _inventory.put(butter.getItemId(), butter);
    }

    @Override
    public Item lookupItem(String itemId) throws ItemNotFoundException {
    	
    	if(exchange != null)
    	{
    		try {
    			System.out.println("value retrieved from exchange:"+exchange.getMessage().getContext().getProperty("Property_A").getValue());
    			//System.out.println("value retrieved from exchange property b"+exchange.getMessage().getContext().getProperty("Property_B").getValue());
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	if(context != null)
    	{
    		try {
    			System.out.println("value retrieved from context:"+context.getProperty("Property_A").getValue());
    			//System.out.println("value retrieved from context property b :"+context.getProperty("Property_B").getValue());
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
        Item item = _inventory.get(itemId);
        if (item == null) {
            throw new ItemNotFoundException("We don't got any " + itemId);
        }
        
        return item;
    }
}
