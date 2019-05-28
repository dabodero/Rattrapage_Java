package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BehaviorFall extends Behavior{

    public BehaviorFall (String spritePath_, int X_, int Y_) {
        super(spritePath_, X_, Y_);
        this.setType(6);
    }

}
