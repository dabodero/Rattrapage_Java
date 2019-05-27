/**
 * @author Basile Lecouturier basile.lecouturier@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * rock displacement class
 */
public class BehaviorRock extends Behavior{

	/**
	 * constructor
	 * @param spritePath_
	 * @param X_
	 * @param Y_
	 */
	public BehaviorRock(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(4);
	}
	/**
	 * refresh
	 * @param window
	 * @param map
	 */
	public void update(JFrame window, ArrayList<Behavior> map) 
    {
    	super.update(window, map);
    }


}
