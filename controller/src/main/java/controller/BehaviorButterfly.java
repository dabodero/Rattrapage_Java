package controller;

public class BehaviorButterfly extends Behavior{
    /**
     * constructor
     *
     * @param spritePath_
     * @param X_
     * @param Y_
     */
    public BehaviorButterfly(String spritePath_, int X_, int Y_) throws Exception {
        super(spritePath_, X_, Y_);
        this.setType(9);
        if ((X_ < 0) || (X_> 16)) { 
			   throw new Exception("X out of range"); 
			  } 
			 
			  if ((Y_ < 0) || (Y_ > 16)) { 
			   throw new Exception("Y out of range"); 
			  } 
			 
    }
}
