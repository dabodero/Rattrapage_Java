/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package view;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.Behavior;
import controller.Counter;
import controller.KeyListner;

public class Screen extends JPanel {
	
	KeyListner key;
	
	public Dimension getPreferredSize() {
		
				
			
						  
			  return new Dimension(1000, 1030);
	}
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
	
	public Screen(JFrame window)
	{
		this.setLayout(null);
		map = new ArrayList<Behavior>();
		update_id = 0;
		key = new KeyListner();
		key.init_key_listner(window);
	}
	
	public void addCharacter(Behavior character, JFrame window)
	{
		character.setImageIcon(new ImageIcon(new ImageIcon(character.getSpritePath()).getImage().getScaledInstance(62,62, Image.SCALE_DEFAULT)));
		character.setJLabel(new JLabel(character.getImageIcon())); 
		character.getJLabel().setBounds(62*(character.getX()-1), 62*(character.getY()-1), 62, 62);
		this.add(character.getJLabel());
		
		map.add(character);
	}
	
	public ArrayList<Behavior> getMapBehavior(){return map;}
	public void setMap(ArrayList<Behavior> map_) {Collections.copy(map, map_);}
	
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

         }

         else if (screen.getBehaviorAt(last_hero_x -1, last_hero_y).getType() == 3) {
             screen.getBehaviorAt(last_hero_x - 1, last_hero_y).changeType(5);
             screen.getBehaviorAt(last_hero_x, last_hero_y).changeType(2);
             counter.addDiamond();
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
	}
	
	public Behavior getBehaviorByType(int type)
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
	
	public void setBehaviorInvisible(Behavior behavior)
	{
		behavior.getJLabel().setVisible(false);
	}
	
	public void setBehaviorVisible(Behavior behavior)
	{
		behavior.getJLabel().setVisible(true);
	}
	long update_id;
	ArrayList<Behavior> map; 
}