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

    protected int getX(){
        return X;
    }

    protected int getY(){
        return Y;
    }

    protected boolean getalive(){
        return alive;
    }

    protected void setX(int Xvalue){
        X = Xvalue;
    }

    protected void setY(int Yvalue){
        Y = Yvalue;
    }

    protected void setAlive(boolean aliveValue){
        alive = aliveValue;
    }

}
