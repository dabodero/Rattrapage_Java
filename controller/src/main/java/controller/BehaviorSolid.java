/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BehaviorSolid extends Behavior{

	public BehaviorSolid(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(1);
	}	
}