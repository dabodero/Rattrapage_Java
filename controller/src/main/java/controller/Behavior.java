/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Behavior extends JPanel{

    /** elements around entity type*/
        protected int type; // Type of the block
        protected int type_up; // Indicates of what is composed the up block
        protected int type_down;	// Same
        protected int type_left; //Same
        protected int type_right; //Same
        protected int type_down_left;
        protected int type_down_right;
        protected String spritePath; //Same
        
        protected double updateID;
        public double getUpdateID() {return updateID;}
        public void setUpdateID(double ID) {updateID = ID;}
        
        /*
         * Type 0 = dirt
         * Type 1 = solid
         * Type 2 = Air
         * Type 3 = Diamond
         * Type 4 = Rock
         * Type 5 = Hero
         * Type 6 = up Moved
         * Type 7 = end block
         */
        
        /**
         * position
         */
        protected int X;
        protected int Y;
      
        ImageIcon icon;
		JLabel label;
		
		/**
         * The update method, update the position of the sprites.
         * @version 1.0
         */
        public void update(int X_, int Y_, JFrame window, boolean haveToRepaint) 
        {
        	X=X_-1; 
        	Y=Y_-1;
        	label.setBounds(62*X, 62*Y, 62, 62);
    		X++;
    		Y++;
    		if(haveToRepaint)
    		{
    		window.repaint();
    		}
        }

    /**
     * refresh the map
     * @param window
     * @param map
     * @param counter
     */
        public void update(JFrame window, ArrayList<Behavior> map)
        {
            type_up = getBehaviorAt(getX(), getY() -1, map).getType();
            type_down = getBehaviorAt(getX(), getY() +1, map).getType();
            type_left = getBehaviorAt(getX() -1, getY(), map).getType();
            type_right = getBehaviorAt(getX() +1, getY(), map).getType();
            type_down_left = getBehaviorAt(getX() -1, getY()+1, map).getType();
            type_down_right = getBehaviorAt(getX() +1, getY() +1, map).getType();
            
            if(this.getType() == 0)
            {
            	
            }
            else if(this.getType() == 1)
            {
            	
            }
            else if(this.getType() == 2)
            {
            	
            }
            else if(this.getType() == 3)
            {
            	this.updateDiamond(window, map);
            }
            else if(this.getType() == 4)
            {
            	this.updateRock(window, map);
            }
            else if(this.getType() == 5) // hero
            {
            	//this.updateHero(window, map);
            }
            else if(this.getType() == 7) // end block
            {
            	
            }
        }

    /**
     * constructor
     * @param spritePath_
     * @param X_
     * @param Y_
     */
    public Behavior(String spritePath_, int X_, int Y_)
    {
        X=X_; 
       	Y=Y_;
       	spritePath = spritePath_;
    }

    /**
     * gravity of the rock
     * @param window
     * @param map
     */
    public void updateRock(JFrame window, ArrayList<Behavior> map)
    {
        if(type_down == 2){
            if(type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }

            this.getBehaviorAt(X, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X, Y+1, map).changeType(4);
            this.changeType(6);
        }

        else if(type_down == 5 && type_up == 6){

            this.getBehaviorAt(X, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X, Y+1, map).changeType(4);
            this.changeType(2);
            gameover();
        }

        else if(type_down_right == 2 && type_right == 2 && (type_down == 4 || type_down == 1)){

            if (type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
            this.getBehaviorAt(X +1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X +1, Y+1, map).changeType(4);
            this.changeType(6);
        }
        else if(type_down_right == 5 && type_right == 2 && (type_down == 4 || type_down == 1)){

            this.getBehaviorAt(X +1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X +1, Y+1, map).changeType(4);
            this.changeType(2);
            this.gameover();
        }

        else if(type_down_left == 2 && type_left == 2 && (type_down == 4 || type_down == 1)){

            if (type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
            this.getBehaviorAt(X -1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X -1, Y+1, map).changeType(4);
            this.changeType(6);
        }
        else if(type_down_left == 5 && type_left == 2 && (type_down == 4 || type_down == 1)){

            this.getBehaviorAt(X -1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X -1, Y+1, map).changeType(4);
            this.changeType(2);
            this.gameover();
        }
        else{
            if(type_up == 6){

                //this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
        }
    }


    public void updateHero(JFrame window, ArrayList<Behavior> map, int X, int Y)
    {
    	this.getBehaviorAt(X, Y, map).changeType(5);
    	this.changeType(2);
    }
    
    /**
     * gravity of the Diamond
     * @param window
     * @param map
     */
    public void updateDiamond(JFrame window, ArrayList<Behavior> map)
    {
        if(type_down == 2){
            if(type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }

            this.getBehaviorAt(X, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X, Y+1, map).changeType(3);
            this.changeType(6);
        }

        else if(type_down == 5 && type_up == 6){

            this.getBehaviorAt(X, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X, Y+1, map).changeType(3);
            this.changeType(2);
            gameover();
        }

        else if(type_down_right == 2 && type_right == 2 && (type_down == 4 || type_down == 1)){

            if (type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
            this.getBehaviorAt(X +1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X +1, Y+1, map).changeType(3);
            this.changeType(6);
        }
        else if(type_down_right == 5 && type_right == 2 && (type_down == 4 || type_down == 1)){

            this.getBehaviorAt(X +1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X +1, Y+1, map).changeType(3);
            this.changeType(2);
            this.gameover();
        }

        else if(type_down_left == 2 && type_left == 2 && (type_down == 4 || type_down == 1)){

            if (type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
            this.getBehaviorAt(X -1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X -1, Y+1, map).changeType(3);
            this.changeType(6);
        }
        else if(type_down_left == 5 && type_left == 2 && (type_down == 4 || type_down == 1)){

            this.getBehaviorAt(X -1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X -1, Y+1, map).changeType(3);
            this.changeType(2);
            this.gameover();
        }
        else{
            if(type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
        }
    }


    /**
     * getters and setters
     * @return
     */
    public int getType() {return type;}
		public int getTypeUp() {return type_up;}
		public int getTypeDown() {return type_down;}
		public int getTypeLeft() {return type_left;}
		public int getTypeRight() {return type_right;}
		
		public void setType(int TYPE) {type = TYPE;}
		
		public ImageIcon getImageIcon() {return icon;}
		public JLabel getJLabel() {return label;}
		
		public void setImageIcon(ImageIcon image) {icon = image;}
		public void setJLabel(JLabel LABEL) {label = LABEL;}
		
        public int getX() {return X;}
        public int getY() {return Y;} 

        
        public String getSpritePath() {return spritePath;}

    /**
     * change sprite of an element
     * @param pathToSprite
     */
    public void changeSprite(String pathToSprite)
    {
        	spritePath = pathToSprite;
        	icon = new ImageIcon(new ImageIcon(spritePath).getImage().getScaledInstance(62,62, Image.SCALE_DEFAULT));
        	label.setIcon(icon);
    }
    /**
     * Delete the behavior
     * @param panel
     */
    public void deleteBehavior(JPanel panel)
    {
    		panel.remove(label);
    }
    /**
     * get the behavior at a specific location
     * @param X
     * @param Y
     * @param map
     */
    public Behavior getBehaviorAt(int X, int Y, ArrayList<Behavior> map)
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


 public void changeType(int newtype){

	    setType(newtype);
	    BehaviorSpritePath sprite = new BehaviorSpritePath();

        switch(newtype){
            case 0:
                changeSprite(sprite.unbreak_dirt);
                break;

            case 1:
                changeSprite(sprite.solid);
                break;

            case 2:
                changeSprite(sprite.broken_wall);
                break;

            case 3:
                changeSprite(sprite.Diamond);
                break;

            case 4:
                changeSprite(sprite.rock);
                break;

            case 5:
                changeSprite(sprite.hero);
                break;

            case 6:
                changeSprite(sprite.broken_wall);
                break;
            case 7:
            	changeSprite(sprite.endBlock);
            	break;
            default:
             
                break;
        }


    }

    protected void gameover(){
    	System.out.println("GAMEOVER");
    	System.exit(0);
    }

    protected void win(){
    	System.out.println("WIN");
    	System.exit(0);
    }
    
}



