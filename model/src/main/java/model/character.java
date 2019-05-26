package model;

abstract public class character {
    protected int X;
    protected int Y;
    protected boolean alive;


    protected character(){
        X = 2;
        Y = 2;
        alive = true;
    }
    protected int XPositionGetter(){
        return X;
    }

    protected int YPositionGetter(){
        return Y;
    }

    protected boolean aliveGetter(){
        return alive;
    }


}
