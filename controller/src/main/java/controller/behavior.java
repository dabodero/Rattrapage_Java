/**
 * @author Basile Lecouturier 
 * @version 1.0
 */
package controller;

public abstract class behavior {
	/**
     * The update method, update the position of the sprites.
     * @version 1.0     
     */
	protected void update() {}
	protected int type_up; // Indicates of what is composed the up block
	protected int type_down;	// Same
	protected int type_left; //Same
	protected int type_right; //Same
	protected String spritePath; //Same
}
