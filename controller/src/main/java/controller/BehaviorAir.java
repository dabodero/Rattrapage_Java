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
	 */
	public BehaviorAir(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(2);
		
			 }
	}	


