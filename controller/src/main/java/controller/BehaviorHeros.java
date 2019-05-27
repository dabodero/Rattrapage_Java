/**
 * @author Basile Lecouturier basile.lecouturier@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BehaviorHeros extends Behavior{

	public BehaviorHeros(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(5);
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
