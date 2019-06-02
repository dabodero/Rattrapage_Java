/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

/**
 * class BehaviorDirt son of Behavior
 */
public class BehaviorDirt extends Behavior{
	/**
	 * constructor
	 * @param spritePath_
	 * @param X_
	 * @param Y_
	 * @throws Exception
	 */
	public BehaviorDirt(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
		this.setType(0);
		if ((X_ < 0) || (X_> 16)) { 
			   throw new Exception("X out of range"); 
			  } 
			 
			  if ((Y_ < 0) || (Y_ > 16)) { 
			   throw new Exception("Y out of range"); 
			  } 
			 }
	}
