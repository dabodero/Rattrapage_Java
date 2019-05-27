/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package main;
import controller.BehaviorSpritePath;
import view.Window;
import view.Screen;
import model.Diamond;
import model.Dirt;

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
     
     int i=1;
     int j=1;
     
     while(j <= 16) {
     while(i <= 16) 
     {
     Dirt test = new Dirt(sprites.unbreak_dirt, i, j);
     screen.addCharacter(test, fenetre.getWindow()); 
     i++;
     }i=0; j++;}
     
     KeyListner test45 = new KeyListner();
     test45.init_key_listner(fenetre.getWindow());
     
     Behavior air = screen.getBehaviorAt(5, 5);
     air.changeType(2);
     Behavior air2 = screen.getBehaviorAt(5, 6);
     air2.changeType(2);
     Behavior air3 = screen.getBehaviorAt(5, 7);
     air3.changeType(2);
     Behavior air4 = screen.getBehaviorAt(5, 8);
     air4.changeType(2);
     
     Behavior diamant = screen.getBehaviorAt(5, 5);
     diamant.changeType(3);
     
     fenetre.repaint();
     
     int i2=1;
     while(i2==1)
     { 	 
    	
    	 screen.update(fenetre.getWindow());
    	
     }
    }
   
}