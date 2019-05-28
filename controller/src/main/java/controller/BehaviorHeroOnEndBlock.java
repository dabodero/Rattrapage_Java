package controller;

public class BehaviorHeroOnEndBlock extends Behavior{
    /**
     * constructor
     *
     * @param spritePath_
     * @param X_
     * @param Y_
     */
    public BehaviorHeroOnEndBlock(String spritePath_, int X_, int Y_) {
        super(spritePath_, X_, Y_);
        this.setType(8);
    }
}
