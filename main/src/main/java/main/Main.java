/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package main;
import controller.*;
import view.Window;
import view.Screen;
import model.Connector;
import model.Dirt;
import model.EndBlock;

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
     * @throws Exception 
     */
    public static void main(final String[] args) throws Exception {
    	
     Window fenetre = new Window("Boulder Dash");
     
     Screen screen = new Screen(fenetre.getWindow());
     fenetre.addScreen(screen);

     Connector test = new Connector();
     test.run(screen, fenetre.getWindow(), 2);
     
     fenetre.repaint();
     Counter counter = new Counter();
     
     screen.getBehaviorAt(10, 11).changeType(7);
     screen.getBehaviorAt(9, 11).changeType(2);
     screen.getBehaviorAt(11, 11).changeType(2);
     screen.getBehaviorAt(12, 11).changeType(2);
    
     
     int boucle=1;
     while(boucle==1)
     { 	 
    	 screen.delay();
    	 screen.updateHeroOnMap(screen, counter);
    	 screen.update(fenetre.getWindow());
     }
    }
}