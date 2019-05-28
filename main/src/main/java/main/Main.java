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
import model.Hero;

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
     
    i=1;
    j=1;
     while(j <= 6) {
         while(i <= 6) 
         {
        	 Behavior air = screen.getBehaviorAt(i, j);
             air.changeType(2); 
         i++;
         }i=0; j++;}
     
     Behavior hero = screen.getBehaviorAt(3, 6);
     hero.changeType(5);
     
     Behavior diam = screen.getBehaviorAt(1, 1);
     diam.changeType(3);
     
     Behavior rock = screen.getBehaviorAt(2, 6);
     rock.changeType(4);

     Behavior rock1 = screen.getBehaviorAt(2, 4);
     rock1.changeType(4);
     
     fenetre.repaint();
     
     int i2=1;
     while(i2==1)
     { 	 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
    	 screen.update(fenetre.getWindow());
     }
    }
   
}