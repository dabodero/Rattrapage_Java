/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package main;
import controller.BehaviorSpritePath;
import view.Window;
import view.Screen;
import model.Diamond;
import java.util.concurrent.TimeUnit;

import controller.Behavior;
import controller.BehaviorDiamond;
import controller.KeyListner;
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
     
     BehaviorSpritePath sprites = new BehaviorSpritePath();
    
     Diamond test = new Diamond(sprites.Diamond, 10, 10);
     screen.addCharacter(test, fenetre.getWindow());
     
    
     KeyListner test45 = new KeyListner();
     test45.init_key_listner(fenetre.getWindow());
     
     int i=1;
     while(i==1)
     {
    	 System.out.println(test45.getKeyPressed());
    	 screen.update(fenetre.getWindow());
    	 
     }
    
    }
   
}