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
     * constructor
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
        frame.setSize(500, 80);  
        frame.setLocationRelativeTo(null); 
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);  
        
        BufferedImage img = null;
        if(win) {
		try {
			img = ImageIO.read(new File(path.overGameWin));
		} catch (IOException e) {e.printStackTrace();}}
        else
        {
        	try {
    			img = ImageIO.read(new File(path.overGameLose));
    		} catch (IOException e) {e.printStackTrace();}
        }
        
        ImageIcon icon=new ImageIcon(img);
        
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
	}

}
