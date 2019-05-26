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
 public abstract class KeyListner implements KeyListener {

    /**
     * key pressed checking
     * @param key
     * @return pressed key
     */
    public String KeyPressed(KeyEvent key){

        int touche = key.getKeyCode();

        switch (touche){

            case KeyEvent.VK_UP:
                //BehaviorHeros.GoUp();
                System.out.println("UP");
                return "UP";

            case KeyEvent.VK_LEFT:
                //Behavior.GoLeft();
                System.out.println("LEFT");
                return "LEFT";

            case KeyEvent.VK_RIGHT:
                //Behavior.GoRight();
                System.out.println("RIGHT");
                return "RIGHT";

            case KeyEvent.VK_DOWN:
                //Behavior.GoDown();
                System.out.println("DOWN");
                return "DOWN";

            default:
                return "AN OTHER PRESS";
        }
    }

    public void keyReleased(KeyEvent key) {
    }

    public void keyTyped(KeyEvent key) {
    }


    public void init_key_listner(JFrame Window){
        Window.addKeyListener(this);
    }
}
