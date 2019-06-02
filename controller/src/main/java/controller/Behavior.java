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
import controller.OverScreen;


public class Behavior extends JPanel{

    /** elements around entity type*/
    private int type; // Type of the block
        private int type_up; // Indicates of what is composed the up block
        private int type_down;	// Same
        private int type_left; //Same
        private int type_right; //Same
        private int type_down_left;
        private int type_down_right;
        private String spritePath; //Same
        private double updateID;
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
         * Type 8 = octopus
         * Type 9 = butterfly
         */
        
        /**
         * position
         */
        private int X;
        private int Y;
      
        private ImageIcon icon;
		private JLabel label;
		
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
     */
        public void update(JFrame window, ArrayList<Behavior> map)
        {
            type_up = getBehaviorAt(getX(), getY() -1, map).getType();
            type_down = getBehaviorAt(getX(), getY() +1, map).getType();
            type_left = getBehaviorAt(getX() -1, getY(), map).getType();
            type_right = getBehaviorAt(getX() +1, getY(), map).getType();
            type_down_left = getBehaviorAt(getX() -1, getY()+1, map).getType();
            type_down_right = getBehaviorAt(getX() +1, getY() +1, map).getType();

            switch (this.getType()){

                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    this.updateDiamond(window, map);
                    break;
                case 4:
                    this.updateRock(window, map);
                    break;
                case 5:
                    break;
                case 7:
                    break;
                case 8:
                    this.updateOctopus(window, map);
                    break;
                case 9:
                	this.updateButterfly(window, map);
                    break;
                default:
                    break;
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
     *update octopus
     * @param window
     * @param map
     */
    public void updateOctopus(JFrame window, ArrayList<Behavior> map){
    	if(this.getBehaviorAt(X+1, Y, map).getType() == 5 || this.getBehaviorAt(X-1, Y, map).getType() == 5)
    	{
    		gameover();
    	}
    	else if(this.getBehaviorAt(X-1, Y, map).getType() == 2 && this.getBehaviorAt(X+1, Y, map).getType() == 2)
    	{
    		double random = Math.round(Math.random());
    		if(random==0) {this.getBehaviorAt(X-1, Y, map).changeType(8);}
    		else if(random == 1) {this.getBehaviorAt(X+1, Y, map).changeType(8);}
    		this.getBehaviorAt(X, Y, map).changeType(2);
    	}
    	else if(this.getBehaviorAt(X-1, Y, map).getType() == 2 && this.getBehaviorAt(X+1, Y, map).getType() != 2)
    	{
    		this.getBehaviorAt(X-1, Y, map).changeType(8);
    		this.changeType(2);
    	}
    	else if(this.getBehaviorAt(X-1, Y, map).getType() != 2 && this.getBehaviorAt(X+1, Y, map).getType() == 2)
    	{
    		this.getBehaviorAt(X+1, Y, map).changeType(8);
    		this.changeType(2);
    	}
    }
    
    /**
     * Butterfly update
     * @param spritePath_
     * @param X_
     * @param Y_
     */
    public void updateButterfly(JFrame window, ArrayList<Behavior> map){
    	if(this.getBehaviorAt(X, Y+1, map).getType() == 5 || this.getBehaviorAt(X, Y-1, map).getType() == 5)
    	{
    		gameover();
    	}
    	else if(this.getBehaviorAt(X, Y-1, map).getType() == 2 && this.getBehaviorAt(X, Y+1, map).getType() == 2)
    	{
    		double random = Math.round(Math.random());
    		if(random==0) {this.getBehaviorAt(X, Y-1, map).changeType(8);}
    		else if(random == 1) {this.getBehaviorAt(X, Y+1, map).changeType(8);}
    		this.getBehaviorAt(X, Y, map).changeType(2);
    	}
    	else if(this.getBehaviorAt(X, Y-1, map).getType() == 2 && this.getBehaviorAt(X, Y+1, map).getType() != 2)
    	{
    		this.getBehaviorAt(X, Y-1, map).changeType(8);
    		this.changeType(2);
    	}
    	else if(this.getBehaviorAt(X, Y-1, map).getType() != 2 && this.getBehaviorAt(X, Y+1, map).getType() == 2)
    	{
    		this.getBehaviorAt(X, Y+1, map).changeType(8);
    		this.changeType(2);
    	}
    }

    /**
     * gravity of the rock
     * @param window
     * @param map
     */
    private void updateRock(JFrame window, ArrayList<Behavior> map)
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
            gameover();
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
            gameover();
        }
        else{
            if(type_up == 6){

                //this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
        }
    }
    
    /**
     * gravity of the Diamond
     * @param window
     * @param map
     */
    private void updateDiamond(JFrame window, ArrayList<Behavior> map)
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
            gameover();
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
            gameover();
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
		void setType(int TYPE) {type = TYPE;}
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
    private void changeSprite(String pathToSprite)
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
    private Behavior getBehaviorAt(int X, int Y, ArrayList<Behavior> map)
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
     * Change the type of the entity
     * @param newtype
     */
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
            case 8:
            	changeSprite(sprite.octopus);
            	break;
            case 9:
            	changeSprite(sprite.butterfly);
            	break;
            default:
             
                break;
        }


    }

 
 /**
  * Game over
  */
    private static void gameover(){
    	OverScreen gameover = new OverScreen("You lose, the game is over you should retry :)");
    }

    /**
     * Win
     */
    public static void win(){
    	OverScreen gameover = new OverScreen("You won congratulations ! :)");
    }
    
}



