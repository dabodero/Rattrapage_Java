package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * observer key listener
 */
 public class KeyListner implements KeyListener {

    /**
     * key witch is pressed
     */
    private char key_pressed;

    /**
     * constructor
     */
	 public KeyListner(){
		 key_pressed = '%';
	 }

    /**
     * mandatory method
     * @param e
     *         event
     */
     public void keyTyped(KeyEvent e) {
    	 
     }

    /**
     * mandatory method
     * @param e
     *          event
     */
     public void keyPressed(KeyEvent e) {
    	 key_pressed = e.getKeyChar();
     }

    /**
     * getter of KeyPressed
     * @return
     *          key_pressed
     */
     public char getKeyPressed() {return key_pressed;}

    /**
     * mandatory method
     * @param e
     *          event
     */
     public void keyReleased(KeyEvent e) {
    	 key_pressed = '%';
     }

    /**
     * initialisation of key listener
     * @param Window
     *              window
     */
    public void init_key_listner(JFrame Window){
        Window.addKeyListener(this);
    }
}
