/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import controller.BehaviorSpritePath;
import java.awt.Image;
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
        protected String spritePath; //Same
        /*
         * Type 0 = dirt
         * Type 1 = solid
         * Type 2 = Air
         * Type 3 = Diamond
         * Type 4 = Rock
         * Type 5 = Hero
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
     */
        public void update(JFrame window, ArrayList<Behavior> map)
        {
            type_up = getBehaviorAt(getX(), getY() +1, map).getType();
            type_down = getBehaviorAt(getX(), getY() -1, map).getType();
            type_left = getBehaviorAt(getX() -1, getY(), map).getType();
            type_right = getBehaviorAt(getX() +1, getY(), map).getType();

            window.repaint();
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

    /**
     * moving methode which move an element
     * of position
     */
    public void GoUp(){

        }  // method to move element above

        public void GoDown(){

        }	// method to move element below

        public void GoRight(){

        }	// method to move element on right

        public void GoLeft(){

        }	// method to move element on left
        
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


 void changeType(int newtype){

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

            default:
                System.out.println("bad value");
                break;
        }


    }
}