package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import controller.BehaviorHeros;

abstract public class KeyListner implements KeyListener {


    public void KeyPressed(KeyEvent key){

        int touche = key.getKeyCode();

        switch (touche){

            case KeyEvent.VK_UP:
                BehaviorHeros.GoUp();
                break;

            case KeyEvent.VK_LEFT:
                break;

            case KeyEvent.VK_RIGHT:
                break;

            case KeyEvent.VK_DOWN:

                break;
        }
    }
}
