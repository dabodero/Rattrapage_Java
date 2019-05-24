package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import controller.BehaviorHeros;

abstract public class KeyListner implements KeyListener {


    public String KeyPressed(KeyEvent key){

        int touche = key.getKeyCode();

        switch (touche){

            case KeyEvent.VK_UP:
                //BehaviorHeros.GoUp();
                System.out.println("UP");
                return "UP";
                break;

            case KeyEvent.VK_LEFT:
                //Behavior.GoLeft();
                System.out.println("LEFT");
                return "LEFT";

            break;

            case KeyEvent.VK_RIGHT:
                //Behavior.GoRight();
                System.out.println("RIGHT");
                return "RIGHT";

            break;

            case KeyEvent.VK_DOWN:
                //Behavior.GoDown();
                System.out.println("DOWN");
                return "DOWN";
                break;

            default:
                return "AN OTHER PRESS";
        }
    }
}
