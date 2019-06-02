package model;

import controller.BehaviorOctopus;

/**
 * class ocopus son of BehaviorOctopus
 */
class Octopus extends BehaviorOctopus {

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
    Octopus(String spritePath_, int X_, int Y_) throws Exception {
        super(spritePath_, X_, Y_);
    }
}
