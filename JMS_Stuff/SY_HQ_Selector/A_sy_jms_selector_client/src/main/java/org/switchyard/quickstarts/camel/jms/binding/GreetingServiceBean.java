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

package org.switchyard.quickstarts.camel.jms.binding;

import org.switchyard.component.bean.Service;

/**
 * A POJO Service implementation.
 *
 * @author Daniel Bevenius
 *
 */
@Service(GreetingService.class)
public class GreetingServiceBean
    implements org.switchyard.quickstarts.camel.jms.binding.GreetingService {

    @Override
    public final void greet(final String name) throws Exception{
    	System.out.println("Hello there " + name + " :-) ");
    	try {
    		Thread.sleep(300);
    	}catch(Exception e) {
    		System.out.println("Got exception while sleep :"+e.getMessage());
    	}
    	System.out.println("Sleep Ended");
    	//throw new Exception();        
    }
}
