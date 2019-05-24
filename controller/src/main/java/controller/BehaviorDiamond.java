/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BehaviorDiamond extends Behavior{
	
	public BehaviorDiamond(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(3);
	}
	
    public void update(JFrame window, List<Behavior> map) 
    {
    	this.update(this.getX(), this.getY(), window, false);
    	window.repaint();
    }
	
}
