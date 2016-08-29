package org.sample;

import java.util.Random;

import javax.inject.Named;

@Named
public class SomeClass {
	
	public String onlyMethod(){
		Random rand = new Random();
		int  n = rand.nextInt(100) + 1;
		String aRandom = Integer.toString(n);
		return aRandom;
	}

}
