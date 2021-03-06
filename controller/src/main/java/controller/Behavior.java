package controller;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * class Behavior mother of all element's Behavior
 */
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
     * refresh the map
     * @param map
     *          the map
     */
        public void update(ArrayList<Behavior> map)
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
                    this.updateDiamond(map);
                    break;
                case 4:
                    this.updateRock(map);
                    break;
                case 5:
                    break;
                case 7:
                    break;
                case 8:
                    this.updateOctopus(map);
                    break;
                case 9:
                	this.updateButterfly(map);
                    break;
                default:
                    break;
            }
        }

    /**
     * constructor
     * @param spritePath_
     *          path of sprites
     * @param X_
     *          X position
     * @param Y_
     *          Y position
     */
    public Behavior(String spritePath_, int X_, int Y_)
    {
        X=X_; 
       	Y=Y_;
       	spritePath = spritePath_;
    }

    /**
     *updates the position of the octopus according to the elements around it
     * @param map
     *          the map
     */
    private void updateOctopus(ArrayList<Behavior> map){
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
     * update updates the position of the octopus according to the elements around it
     * @param map
     *          the map
     */
    private void updateButterfly(ArrayList<Behavior> map){
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
     * add gravity for Rock according to the elements around it
     * @param map
     *          the map
     */
    private void updateRock(ArrayList<Behavior> map)
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
     * add gravity for Diamond according to the elements around it
     *@param map
     *          the map
     */
    private void updateDiamond(ArrayList<Behavior> map)
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

        else if(type_down_right == 2 && type_right == 2 && (type_down == 4 || type_down == 1 || type_down == 3)){

            if (type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
            this.getBehaviorAt(X +1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X +1, Y+1, map).changeType(3);
            this.changeType(6);
        }
        else if(type_down_right == 5 && type_right == 2 && (type_down == 4 || type_down == 1 || type_down == 3)){

            this.getBehaviorAt(X +1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X +1, Y+1, map).changeType(3);
            this.changeType(2);
            gameover();
        }

        else if(type_down_left == 2 && type_left == 2 && (type_down == 4 || type_down == 1 || type_down == 3)){

            if (type_up == 6){
                this.getBehaviorAt(X, Y -1, map).setUpdateID(this.getUpdateID());
                this.getBehaviorAt(X, Y -1, map).changeType(2);
            }
            this.getBehaviorAt(X -1, Y+1, map).setUpdateID(this.getUpdateID());
            this.getBehaviorAt(X -1, Y+1, map).changeType(3);
            this.changeType(6);
        }
        else if(type_down_left == 5 && type_left == 2 && (type_down == 4 || type_down == 1 || type_down == 3)){

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
     *        type of each type around
     */
    public int getType() {return type;}

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
     *              path of sprites
     */
    private void changeSprite(String pathToSprite)
    {
        	spritePath = pathToSprite;
        	icon = new ImageIcon(new ImageIcon(spritePath).getImage().getScaledInstance(62,62, Image.SCALE_DEFAULT));
        	label.setIcon(icon);
    }

    /**
     * get the behavior at a specific location
     * @param X
     *          X position
     * @param Y
     *          Y position
     * @param map
     *          map
     * @return
     * 			Behavior by default
     */
    static Behavior getBehaviorAt(int X, int Y, ArrayList<Behavior> map)
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
     *          new type
     */
 public void changeType(int newtype){

	    setType(newtype);
	    SpritePath sprite = new SpritePath();

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
    	OverScreen gameover = new OverScreen(false);
    }

    /**
     * Win
     */
    public static void win(){
    	OverScreen gameover = new OverScreen(true);
    }
    
}



