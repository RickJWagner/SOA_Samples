/* @AORJMSInterface.java         Apr 11, 2015
 *
 * Copyright 2013 Alcatel-Lucent. All rights reserved.
 * Use is subject to license terms.
 * 
 * This program contains proprietary information which is a trade secret
 * of ALCATEL-LUCENT IPP R&D and also is protected under the applicable copyright law. 
 * Recipient is to retain this program in confidence and is not permitted to use 
 * or make any copy thereof other than as permitted under a written agreement with 
 * ALCATEL-LUCENT.
 * 
 * PROJECT: Automated Operations & Recovery (AOR)
 *
 * EDIT HISTORY:
 * Date                Author               Changes/Comments
 * --------------------------------------------------------------------
 * Apr 11, 2015             bhaskar               Initial Version
 * --------------------------------------------------------------------*/
package org.switchyard.quickstarts.bean.service;

/**
 * AORJMSInterface 
 * @author bhaskar  @version 1.0
 * TODO: Update the purpose of the class/interface
 */
public interface AORJMSOUTInterface {
	public void sendEvent(String message);
} 
