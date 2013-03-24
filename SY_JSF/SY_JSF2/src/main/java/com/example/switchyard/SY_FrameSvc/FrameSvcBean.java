package com.example.switchyard.SY_FrameSvc;



import javax.enterprise.context.ApplicationScoped;

import org.switchyard.component.bean.Service;
import javax.inject.Named;


@Named
@Service(FrameSvc.class)
@ApplicationScoped
public class FrameSvcBean implements FrameSvc {

	@Override
	public FrameAck addFrame(Frame f) {
		System.out.println("Got Frame");
		FrameAck frameAck = new FrameAck();
		if (f.getPinCountOne() == 10){
			frameAck.setStrike(true);
		}else if (10 == (f.getPinCountOne() + f.getPinCountTwo())){
			frameAck.setSpare(true);
		}else{
			frameAck.setOpen(true);
		}
		return frameAck;
	}

}