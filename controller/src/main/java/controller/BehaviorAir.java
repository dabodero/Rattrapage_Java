/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BehaviorAir extends Behavior{

	public BehaviorAir(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(2);
	}	

}