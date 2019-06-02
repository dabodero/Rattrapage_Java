package model;

import controller.BehaviorButterfly;

/**
 * class Butterfly son of BehaviorButterfly
 */
class Butterfly extends BehaviorButterfly {
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
    Butterfly(String spritePath_, int X_, int Y_) throws Exception {
        super(spritePath_, X_, Y_);
    }
}
