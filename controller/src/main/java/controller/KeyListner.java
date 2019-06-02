/**
 * @author Basile Lecouturier basile.lecouturier@viacesi.fr
 * @version 1.0
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import controller.BehaviorHeros;

import javax.swing.*;

/**
 * observer key listner
 */
 public class KeyListner implements KeyListener {

    /**
     * key pressed checking
     * @param key
     * @return pressed key
     */
	 
	 char key_pressed;

    /**
     * constructor
     */
	 public KeyListner(){
		 key_pressed = '%';
	 }

    /**
     * mandatory method
     * @param e
     */
     public void keyTyped(KeyEvent e) {
    	 
     }

    /**
     * mandatory method
     * @param e
     */
     public void keyPressed(KeyEvent e) {
    	 key_pressed = e.getKeyChar();
     }

    /**
     * getter of KeyPressed
     * @return
     */
     public char getKeyPressed() {return key_pressed;}

    /**
     * mandatory method
     * @param e
     */
     public void keyReleased(KeyEvent e) {
    	 key_pressed = '%';
     }

    /**
     * initialisation of key listener
     * @param Window
     */
    public void init_key_listner(JFrame Window){
        Window.addKeyListener(this);
    }
}
