package controller;

/**
 * class behavior diamond son of behavior
 */
public class BehaviorDiamond extends Behavior{

	/**
	 * constructor
	 * @param spritePath_
	 * 			path of sprites
	 * @param X_
	 * 			X position
	 * @param Y_
	 * 			Y position
	 */
	public BehaviorDiamond(String spritePath_, int X_, int Y_)  {
		super(spritePath_, X_, Y_);
		this.setType(3);
		
			 
	}

}

