package controller;

public class BehaviorOctopus extends Behavior{
    /**
     * constructor
     *
     * @param spritePath_
     * @param X_
     * @param Y_
     */
    public BehaviorOctopus(String spritePath_, int X_, int Y_) {
        super(spritePath_, X_, Y_);
        this.setType(8);
    }

}
