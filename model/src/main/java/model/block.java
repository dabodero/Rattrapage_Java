package model;
import java.util.Random;


/** declaration of block class*/
public class block {

    /** position attribute*/
    protected int X;
    protected int Y;

    /** constructor*/
    protected block(){

        Random rand  = new Random();
        X = rand.nextInt(100);
        Y = rand.nextInt(100);
    }


    /** getters and setters*/
    protected int getX() {
        return X;
    }

    protected int getY() {
        return Y;
    }

    protected void setX(int x) {
        X = x;
    }

    protected void setY(int y) {
        Y = y;
    }
}
