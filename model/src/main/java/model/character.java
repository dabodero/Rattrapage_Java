/**
 * @author Basile Lecouturier basile.lecouturier@viacesi.fr
 * @version 1.0
 */
package model;

/** declaration of character class*/
abstract public class character {

    /** position attribute*/
    protected int X;
    protected int Y;

    /** alive statement*/
    protected boolean alive;

    /** constructor*/
    protected character(){
        X = 2;
        Y = 2;
        alive = true;
    }

    /** getters and setters*/
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
