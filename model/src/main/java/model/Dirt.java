package model;
import controller.BehaviorDirt;

/**
 * class Dirt son of BehaviorDirt
 */
class Dirt extends BehaviorDirt {

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
	Dirt(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
		if ((X_ < 0) || (X_> 16) || (Y_ < 0) || (Y_ > 16)) {
			
			
			   throw new Exception("X or Y out of range"); 
			  } 
	}

}
