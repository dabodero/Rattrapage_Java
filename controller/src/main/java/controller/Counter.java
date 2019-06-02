package controller;

/**
 * class counter witch count how many Diamond the hero catch
 */
public class Counter {

    /**
     * number of diamond
     */
    private static int nbDiamond = 0;

    /**
     * constructor
     */
    public Counter() {

    }

    /**
     * getter
     * @return
     *      nbDiamond
     */
    public int getNbDiamond() {
        return nbDiamond;
    }

    /**
     * add a diamond to nbDiamond
     */
    public static void addDiamond(){
        nbDiamond = nbDiamond +1;
    }
}
