package model;
import controller.BehaviorRock;

/**
 * class Rock son of BehaviorRock
 */
class Rock extends BehaviorRock {

	/**
	 * constructor
	 *
	 * @param spritePath_
	 * 			path of sprites
	 * @param X_
	 * 			X position
	 * @param Y_
	 * 			Y position
	 * @throws Exception
	 * 			exception
	 */
	Rock(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
	}

}
