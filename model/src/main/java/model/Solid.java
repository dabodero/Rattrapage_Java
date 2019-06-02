package model;
import controller.BehaviorSolid;

/**
 * class Solid son of BehaviorSolid
 */
class Solid extends BehaviorSolid {

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
	Solid(String spritePath_, int X_, int Y_) throws Exception {
		super(spritePath_, X_, Y_);
	}

}
