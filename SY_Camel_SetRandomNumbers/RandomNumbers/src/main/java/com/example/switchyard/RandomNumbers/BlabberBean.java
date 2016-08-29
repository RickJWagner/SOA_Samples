package com.example.switchyard.RandomNumbers;

import javax.inject.Inject;

import org.sample.Blabber;
import org.switchyard.component.bean.Service;

@Service(Blabber.class)
public class BlabberBean implements Blabber {
	
	@Inject org.sample.SecondAction secondAction;

	@Override
	public void blabber(String something) {
		System.out.println("### Hey, I was given " + something );
		String newSomething = secondAction.secondAction(something);
		System.out.println("And now I have: " + newSomething);
		
	}

}
