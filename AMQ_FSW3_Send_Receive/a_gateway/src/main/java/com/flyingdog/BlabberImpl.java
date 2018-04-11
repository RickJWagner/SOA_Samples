package com.flyingdog;

import org.switchyard.component.bean.Service;

@Service(Blabber.class)
public class BlabberImpl implements Blabber {

	@Override
	public String blabber(String str) {
		System.out.println("BLABBERING " + str);
		return str + " Has been BLABBERED";
	}

}
