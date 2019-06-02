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
	 * @throws Exception
	 * 			exception
     */
	public BehaviorOctopus(String spritePath_, int X_, int Y_) throws Exception {
        super(spritePath_, X_, Y_);
        this.setType(8);
        if ((X_ < 0) || (X_> 16)) { 
			   throw new Exception("X out of range"); 
			  } 
			 
			  if ((Y_ < 0) || (Y_ > 16)) { 
			   throw new Exception("Y out of range"); 
			  } 
			 } 
    }

