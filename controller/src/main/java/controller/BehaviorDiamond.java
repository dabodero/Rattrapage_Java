/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * class behavior diamond son of behavior
 */
public class BehaviorDiamond extends Behavior{

	/**
	 * constructor
	 * @param spritePath_
	 * @param X_
	 * @param Y_
	 */
	public BehaviorDiamond(String spritePath_, int X_, int Y_) {
		super(spritePath_, X_, Y_);
		this.setType(3);
	}

	/**
	 * refresh
	 * @param window
	 * @param map
	 */
	public void update(JFrame window, ArrayList<Behavior> map)
	{
		super.update(window, map);


		if (type_down == 2) {
			changeType(2);
			getBehaviorAt(getX(), getY() +1, map).changeType(4);
		} else if (type_down_right == 2) {
			changeType(2);
			getBehaviorAt(getX() +1, getY() +1, map).changeType(4);
		} else if(type_down_left == 2){
			changeType(2);
			getBehaviorAt(getX() -1, getY() +1, map).changeType(4);
		}
	}
}

