package com.example.switchyard.SY_FrameSvc;

public class FrameAck {

	private boolean strike = false;
	private boolean spare = false;
	private boolean open = false;
	
	public boolean isStrike() {
		return strike;
	}
	public void setStrike(boolean strike) {
		this.strike = strike;
	}
	public boolean isSpare() {
		return spare;
	}
	public void setSpare(boolean spare) {
		this.spare = spare;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public String toString(){
		if (strike){
			return "Strike";
		}else if (spare){
			return "Spare";
		}else{
			return "Open";
		}
	}	
	
}
