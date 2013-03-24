package com.example.switchyard.SY_FrameSvc;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;



@Named ("frame")
@RequestScoped
public class Frame implements Serializable {
	 
@Inject @Named("frameSvcBean") private FrameSvc frameSvc;
	 

private String gameId;
private String frameId;
private int pinCountOne;
private int pinCountTwo;




public String getGameId() {
	return gameId;
}



public void setGameId(String gameId) {
	this.gameId = gameId;
}



public String getFrameId() {
	return frameId;
}



public void setFrameId(String frameId) {
	this.frameId = frameId;
}



public int getPinCountOne() {
	return pinCountOne;
}



public void setPinCountOne(int pinCountOne) {
	this.pinCountOne = pinCountOne;
}



public int getPinCountTwo() {
	return pinCountTwo;
}



public void setPinCountTwo(int pinCountTwo) {
	this.pinCountTwo = pinCountTwo;
}



		public void create() {
	    	
	        FrameAck frameAck = frameSvc.addFrame(this);
	        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(frameAck.toString()));
	    }
}	
	