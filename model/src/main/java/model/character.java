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
    protected int getXPosition(){
        return X;
    }

    protected int getYPosition(){
        return Y;
    }

    protected boolean getalive(){
        return alive;
    }


}
