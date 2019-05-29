/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package main;
import controller.*;
import view.Window;
import view.Screen;
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
     
     Behavior door = screen.getBehaviorAt(2, 5);
     door.changeType(7);

     
     fenetre.repaint();
     
     Counter counter = new Counter();
     
     KeyListner key = new KeyListner();
     key.init_key_listner(fenetre.getWindow());
    
     int i2=1;
     while(i2==1)
     { 	 try{Thread.sleep(200);}catch(InterruptedException e){System.out.println(e);} 
     if(key.getKeyPressed() == 'z') {
            int last_hero_x = screen.getBehaviorByType(5).getX();
    	    int last_hero_y = screen.getBehaviorByType(5).getY();

    	    if (screen.getBehaviorAt(last_hero_x, last_hero_y -1).getType() == 2 || screen.getBehaviorAt(last_hero_x, last_hero_y -1).getType() == 0){
                screen.getBehaviorAt(last_hero_x, last_hero_y-1).changeType(5);
                screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);

            }

            else if (screen.getBehaviorAt(last_hero_x, last_hero_y -1).getType() == 3){
                screen.getBehaviorAt(last_hero_x, last_hero_y-1).changeType(5);
                screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
                counter.addDiamond();
                System.out.println(counter.getNbDiamond());
            }

    	    else if(screen.getBehaviorAt(last_hero_x, last_hero_y -1).getType() == 7 && counter.getNbDiamond() == 10){
                screen.getBehaviorAt(last_hero_x, last_hero_y-1).changeType(5);
                screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
                Behavior.win();
    	    }
    	 }

     if(key.getKeyPressed() == 's') {
         int last_hero_x = screen.getBehaviorByType(5).getX();
         int last_hero_y = screen.getBehaviorByType(5).getY();

         if (screen.getBehaviorAt(last_hero_x, last_hero_y +1).getType() == 2 || screen.getBehaviorAt(last_hero_x, last_hero_y +1).getType() == 0){
             screen.getBehaviorAt(last_hero_x, last_hero_y +1).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
         }

         if (screen.getBehaviorAt(last_hero_x, last_hero_y +1).getType() == 3){
             screen.getBehaviorAt(last_hero_x, last_hero_y +1).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             counter.addDiamond();
         }
         else if(screen.getBehaviorAt(last_hero_x, last_hero_y +1).getType() == 7 && counter.getNbDiamond() == 10){
             screen.getBehaviorAt(last_hero_x, last_hero_y +1).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Behavior.win();
         }
     }
     if(key.getKeyPressed() == 'q') {
         int last_hero_x = screen.getBehaviorByType(5).getX();
         int last_hero_y = screen.getBehaviorByType(5).getY();

         if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 2 || screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 0) {
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             System.out.println("ca passse?");

         }

         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 3) {
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             counter.addDiamond();
             System.out.println(counter.getNbDiamond());
         }

         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 4 && screen.getBehaviorAt(last_hero_x -2, last_hero_y).getType() == 2){
             screen.getBehaviorAt(last_hero_x -2,last_hero_y).changeType(4);
             screen.getBehaviorAt(last_hero_x -1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
         }
         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 7 && counter.getNbDiamond() == 10){
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Behavior.win();
         }
 	 }
     if(key.getKeyPressed() == 'd') {
         int last_hero_x = screen.getBehaviorByType(5).getX();
         int last_hero_y = screen.getBehaviorByType(5).getY();

         if (screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 2 || screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 0) {
             screen.getBehaviorAt(last_hero_x + 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
         }

         if (screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 3) {
             screen.getBehaviorAt(last_hero_x + 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             counter.addDiamond();
             System.out.println(counter.getNbDiamond());

         }

         else if (screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 4 && screen.getBehaviorAt(last_hero_x +2, last_hero_y).getType() == 2){
             screen.getBehaviorAt(last_hero_x +2,last_hero_y).changeType(4);
             screen.getBehaviorAt(last_hero_x +1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
         }
         else if (screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 7 && counter.getNbDiamond() == 10){
             screen.getBehaviorAt(last_hero_x + 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Behavior.win();
         }
 	 }
    	 screen.update(fenetre.getWindow());
     }
    }
   
}