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
	protected void update();
	protected int type_haut; // Indicates of what is composed the up block
	protected int type_bas;	// Same
	protected int type_gauche; //Same
	protected int type_droite; //Same
	protected String spritePath; //Same
}
