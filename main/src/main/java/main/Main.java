/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package main;
import view.Window;
import view.Screen;
import model.Diamond;
import java.util.concurrent.TimeUnit;

import controller.Behavior;
import controller.BehaviorDiamond;
/**
 * The Class Main.
 *
 * @author Léo Sanchez
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
     Window fenetre = new Window("Boulder Dash");
     Screen screen = new Screen();
     fenetre.addScreen(screen);
     
     Behavior test = new Behavior("C:\\\\Users\\\\leosa\\\\Downloads\\\\projet_java\\\\Diamand.png", 1, 1); 
     screen.addCharacter(test, fenetre.getWindow());
     
     BehaviorDiamond test2 = new BehaviorDiamond("C:\\\\\\\\Users\\\\\\\\leosa\\\\\\\\Downloads\\\\\\\\projet_java\\\\\\\\Diamand.png", 2, 1);
     screen.addCharacter(test2, fenetre.getWindow());
     
     Behavior test3 = new Behavior("C:\\\\Users\\\\leosa\\\\Downloads\\\\projet_java\\\\Diamand.png", 5, 1); 
     screen.addCharacter(test3, fenetre.getWindow());
     
     Behavior test4 = new Behavior("C:\\\\Users\\\\leosa\\\\Downloads\\\\projet_java\\\\Diamand.png", 10, 1); 
     screen.addCharacter(test4, fenetre.getWindow());
     
     Behavior test5 = new Behavior("C:\\\\Users\\\\leosa\\\\Downloads\\\\projet_java\\\\Diamand.png", 4, 2); 
     screen.addCharacter(test5, fenetre.getWindow());
     
     Diamond test6 = new Diamond("C:\\\\\\\\Users\\\\\\\\leosa\\\\\\\\Downloads\\\\\\\\projet_java\\\\\\\\Diamand.png", 10, 10);
     screen.addCharacter(test6, fenetre.getWindow());
     
     Behavior final_ = screen.getBehaviorAt(10, 10);
     screen.setBehaviorInvisible(final_);
     
     int i=1;
     while(i==1)
     {
    	 screen.update(fenetre.getWindow());
     }
    
    }
   
}