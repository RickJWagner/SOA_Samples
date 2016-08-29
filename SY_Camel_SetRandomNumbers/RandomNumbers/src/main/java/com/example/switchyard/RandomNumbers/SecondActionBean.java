package com.example.switchyard.RandomNumbers;

import java.util.Random;

import org.sample.SecondAction;
import org.switchyard.component.bean.Service;

@Service(SecondAction.class)
public class SecondActionBean implements SecondAction {

	@Override
	public String secondAction(String something) {
		Random rand = new Random();
		int  n = rand.nextInt(100) + 1;
		return something + " and additional random " + n;
	}

}
