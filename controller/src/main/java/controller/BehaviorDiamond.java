/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * class behavior diamond son of behavior
 */
public class BehaviorDiamond extends Behavior{

	/**
	 * constructor
	 * @param spritePath_
	 * @param X_
	 * @param Y_
	 */
	public BehaviorDiamond(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
		this.setType(3);
		if ((X_ < 0) || (X_> 16)) { 
			   throw new Exception("X out of range"); 
			  } 
			 
			  if ((Y_ < 0) || (Y_ > 16)) { 
			   throw new Exception("Y out of range"); 
			  } 
			 
	}

}

