/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Behavior extends JPanel{

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
    		if(haveToRepaint) {
    		window.repaint();}
        }
        
        public Behavior(String spritePath_, int X_, int Y_) 
        {
        	X=X_; 
        	Y=Y_;
        	spritePath = spritePath_;
        }
        
        protected int type_up; // Indicates of what is composed the up block
        protected int type_down;	// Same
        protected int type_left; //Same
        protected int type_right; //Same
        protected String spritePath; //Same
        
        protected int X;
        protected int Y;
        
        ImageIcon icon;
		JLabel label;
		
		public ImageIcon getImageIcon() {return icon;}
		public JLabel getJLabel() {return label;}
		public void setImageIcon(ImageIcon image) {icon = image;}
		public void setJLabel(JLabel LABEL) {label = LABEL;}
        
        public int getX() {return X;}
        public int getY() {return Y;}
        

        protected void GoUp(){

        }  // method to move element above

        protected void GoDown(){

        }	// method to move element below

        protected void GoRight(){

        }	// method to move element on right

        protected void GoLeft(){

        }	// method to move element on left
        
        public String getSpritePath() {return spritePath;}
        
        public void changeSprite(String pathToSprite, JFrame window, boolean haveToRepaint, JPanel screen)
        {
        	
        	spritePath = pathToSprite;
        	icon = new ImageIcon(new ImageIcon(spritePath).getImage().getScaledInstance(62,62, Image.SCALE_DEFAULT));
        	label.setIcon(icon);
        	window.pack();
       	 	window.repaint();
        }
      
}
