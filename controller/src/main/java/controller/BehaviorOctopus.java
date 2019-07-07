package controller;

/**
 * class BehaviorOctopus son of Behavior
 */
public class BehaviorOctopus extends Behavior{
    /**
     * constructor
	 * @param spritePath_
	 * 			path of sprites
	 * @param X_
	 * 			X position
	 * @param Y_
	 * 			Y position
     */
	public BehaviorOctopus(String spritePath_, int X_, int Y_)  {
        super(spritePath_, X_, Y_);
        this.setType(8);
        
			 } 
    }

