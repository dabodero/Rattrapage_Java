package controller;

/**
 * class BehaviorAir son of Behavior
 */
public class BehaviorAir extends Behavior{

	/**
	 * constructor
	 * @param spritePath_
	 * 			path of sprites
	 * @param X_
	 * 			X position
	 * @param Y_
	 * 			Y position
	 * @throws Exception
	 * 			exception
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


