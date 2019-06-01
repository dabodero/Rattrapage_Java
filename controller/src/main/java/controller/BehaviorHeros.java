/**
 * @author Basile Lecouturier basile.lecouturier@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BehaviorHeros extends Behavior{

	public BehaviorHeros(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
		this.setType(5);
		if ((X_ < 0) || (X_> 16)) { 
			   throw new Exception("X out of range"); 
			  } 
			 
			  if ((Y_ < 0) || (Y_ > 16)) { 
			   throw new Exception("Y out of range"); 
			  } 
			 } 
	}	


