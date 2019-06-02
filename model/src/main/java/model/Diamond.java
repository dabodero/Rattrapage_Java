package model;
import controller.BehaviorDiamond;

/**
 * class Diamond son of BehaviorDiamond
 */
class Diamond extends BehaviorDiamond {

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
	Diamond(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
	}

}
