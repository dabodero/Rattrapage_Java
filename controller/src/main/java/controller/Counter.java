package controller;

public class Counter {

    int nbDiamond = 0;

    public Counter() {

    }

    public void setNbDiamond(int val){
        nbDiamond = val;
    }

    public int getNbDiamond() {
        return nbDiamond;
    }

    public void addDiamond(){
        nbDiamond = nbDiamond +1;
    }
}
