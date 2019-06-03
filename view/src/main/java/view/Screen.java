package view;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import controller.Behavior;
import controller.Counter;
import controller.KeyListner;

public class Screen extends JPanel {
	
	private KeyListner key;
	
	/**
	 * Get the appropriate size
	 *
	 */
	public Dimension getPreferredSize() {
		return new Dimension(1000, 1030);
	}
	
	/**
	 * Make a sleep
	 */
	public void delay()
	{
		try{Thread.sleep(200);}catch(InterruptedException e){System.out.println(e);} 
	}
	
	protected void paintComponent(Graphics g) {
		int xStart=1000/16;
		int yStart=1000/16;
		g.setColor( Color.red );
		while(xStart < 1000) {
		g.drawLine ( xStart, 0, xStart, 1000 );
		xStart += 1000/16;
		}
		g.setColor( Color.green );
		while(yStart < 1000) {
			g.drawLine ( 0, yStart, 1000, yStart );
			yStart += 1000/16;
			}
	}
	
	/**
	 * constructor
	 *
	 * @param window
	 */
	public Screen(JFrame window)
	{
		this.setLayout(null);
		map = new ArrayList<Behavior>();
		update_id = 0;
		key = new KeyListner();
		key.init_key_listner(window);
	}
	
	/**
	 * Add a character to the screen
	 * @param character
	 * @param window
	 */
	public void addCharacter(Behavior character, JFrame window)
	{
		character.setImageIcon(new ImageIcon(new ImageIcon(character.getSpritePath()).getImage().getScaledInstance(62,62, Image.SCALE_DEFAULT)));
		character.setJLabel(new JLabel(character.getImageIcon())); 
		character.getJLabel().setBounds(62*(character.getX()-1), 62*(character.getY()-1), 62, 62);
		this.add(character.getJLabel());
		
		map.add(character);
	}
	
	/**
	 * Get the map
	 */
	public ArrayList<Behavior> getMapBehavior(){return map;}
	/**
	 * Set the map to another
	 *
	 * @param map
	 */
	public void setMap(ArrayList<Behavior> map_) {Collections.copy(map, map_);}
	
	/**
	 * Get behavior at specific location
	 *
	 * @param X
	 * @param Y
	 */
	public Behavior getBehaviorAt(int X, int Y)
	{
		int i = 0;
		int max = map.size();
		if(max > 0) {
			while (i != max)
			{
				if(map.get(i).getX() == X && map.get(i).getY() == Y)
				{
					return map.get(i);
				}
				i++;
			}
		}
		
		return new Behavior("", 1, 1); // Default
	}
	
	/**
	 * Update hero on map
	 *
	 * @param screen
	 * @param counter
	 */
	public void updateHeroOnMap(Screen screen, Counter counter)
	{
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
                Counter.addDiamond();
                System.out.println(counter.getNbDiamond());
            }

            else if (screen.getBehaviorAt(last_hero_x, last_hero_y-1).getType() == 7){
           	 System.out.println("Tried to escape with "+counter.getNbDiamond());
           	if(counter.getNbDiamond() == 10) {
                screen.getBehaviorAt(last_hero_x, last_hero_y-1).changeType(5);
                screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
                Behavior.win();}
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
             Counter.addDiamond();
         }
         else if (screen.getBehaviorAt(last_hero_x, last_hero_y+1).getType() == 7){
        	 System.out.println("Tried to escape with "+counter.getNbDiamond());
        	if(counter.getNbDiamond() == 10) {
             screen.getBehaviorAt(last_hero_x, last_hero_y+1).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Behavior.win();}
         }
     }
     
     if(key.getKeyPressed() == 'q') {
         int last_hero_x = screen.getBehaviorByType(5).getX();
         int last_hero_y = screen.getBehaviorByType(5).getY();

         if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 2 || screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 0) {
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);

         }

         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 3) {
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Counter.addDiamond();
         }

         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 4 && screen.getBehaviorAt(last_hero_x -2, last_hero_y).getType() == 2){
             screen.getBehaviorAt(last_hero_x -2,last_hero_y).changeType(4);
             screen.getBehaviorAt(last_hero_x -1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
         }
         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 7){
        	 System.out.println("Tried to escape with "+counter.getNbDiamond());
        	if(counter.getNbDiamond() == 10) {
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Behavior.win();}
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
             Counter.addDiamond();

         }

         else if (screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 4 && screen.getBehaviorAt(last_hero_x +2, last_hero_y).getType() == 2){
             screen.getBehaviorAt(last_hero_x +2,last_hero_y).changeType(4);
             screen.getBehaviorAt(last_hero_x +1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
         }
         else if (screen.getBehaviorAt(last_hero_x +1, last_hero_y).getType() == 7){
        	 System.out.println("Tried to escape with "+counter.getNbDiamond());
        	if(counter.getNbDiamond() == 10) {
             screen.getBehaviorAt(last_hero_x + 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             Behavior.win();}
         }
 	 }
	}
	
	/**
	 * getBehavior by it's type
	 *
	 * @param type
	 */
	private Behavior getBehaviorByType(int type)
	{
		int i = 0;
		int max = map.size();
		if(max > 0) {
			while (i != max)
			{
				if(map.get(i).getType() == type)
				{
					return map.get(i);
				}
				i++;
			}
		}
		
		return new Behavior("", 1, 1); // Default
	}
	
	/**
	 * update all the behavior
	 *
	 * @param window
	 */
	public void update(JFrame window) {
		int i = 0;
		int max = map.size();
		if(max > 0) {
			double updateID =  (Math.random() * ( 1000 - 100 ));
			while (i != max)
			{
				if(map.get(i).getUpdateID() != updateID) 
				{
					map.get(i).setUpdateID(updateID);
					map.get(i).update(window, map);
				}
				
				i++;
			}
		}
	}
	
	/**
	 * Set a behavior invisible
	 * @param behavior
	 */
	public void setBehaviorInvisible(Behavior behavior)
	{
		behavior.getJLabel().setVisible(false);
	}
	
	/**
	 * Set a behavior visible
	 * @param behavior
	 */
	public void setBehaviorVisible(Behavior behavior)
	{
		behavior.getJLabel().setVisible(true);
	}
	private long update_id;
	private ArrayList<Behavior> map;
}