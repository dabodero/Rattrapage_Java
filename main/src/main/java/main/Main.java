/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package main;
import view.Window;
import view.Screen;
import controller.Behavior;
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
     int i = 1;
     int j = 1;
     
    while(j<=16) {
     while (i<=16)
     {
    	 Behavior test = new Behavior("C:\\\\Users\\\\leosa\\\\Downloads\\\\projet_java\\\\terre.png", i, j);
    	 screen.addCharacter(test, fenetre.getWindow());
    	 i++;
     }
     i = 0;
     j++;}
    
	 
    }
   
}
