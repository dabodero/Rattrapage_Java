package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import controller.SpritePath;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * class overScreen
 */
class OverScreen {
	
	SpritePath path;

    /**
     * Create the window, depends on if it is a win or a lost
     * @param win
     */
    OverScreen(boolean win)
	{
    	path = new SpritePath();
		JFrame frame = new JFrame("Game is over !");  
        JPanel panel = new JPanel(); 
        JLabel label;
        if(!win) 
        {
        label = new JLabel("You lose, the game is over you should retry :)");
        }
        else
        {
        	label = new JLabel("You won congratulations ! :)");
        }
        panel.add(label);  
        frame.add(panel);  
        frame.setSize(500, 300);  
        frame.setLocationRelativeTo(null); 
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);  
        
        BufferedImage img = null;
        if(win) {
        	JLabel jLabelObject = new JLabel();
        	jLabelObject.setIcon(new ImageIcon(path.overGameWin));
        	panel.add(jLabelObject);
		}
        else
        {
        	JLabel jLabelObject = new JLabel();
        	jLabelObject.setIcon(new ImageIcon(path.overGameLose));
        	panel.add(jLabelObject);
        }
        
        ImageIcon icon=new ImageIcon(img);
        
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
	}

}
