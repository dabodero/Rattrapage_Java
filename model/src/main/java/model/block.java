package model;
import java.util.*;

public class block {

    protected int X;
    protected int Y;


    protected block(){

        Random rand  = new Random();
        X = rand.nextInt(100);
        Y = rand.nextInt(100);
    }

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
