package model;

/** declaration of hero class*/
public class Hero extends character{
    static String letter = "H";


    /** constructor*/
    public Hero(){
        super();
    }

    /**
     * singleton try
     */
   /* essai de ingletonprivate Hero(){
    }

    private static class SingletonHolder{

        private final static Hero instance = new Hero();
    }

    public static Hero getInstance(){

        return SingletonHolder.instance;
    }*/

}


