/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;


public class BehaviorAir extends Behavior{

	/**
	 * Behavior of Air
	 * @param spritePath_
	 * @param X_
	 * @param Y_
	 * @throws Exception
	 */
	public BehaviorAir(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
		this.setType(2);
		if ((X_ < 0) || (X_> 16)) { 
			   throw new Exception("X out of range"); 
			  } 
			 
			  if ((Y_ < 0) || (Y_ > 16)) { 
			   throw new Exception("Y out of range"); 
			  } 
			 }
	}	


