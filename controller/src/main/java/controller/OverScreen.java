package controller;

import javax.swing.*;

public class OverScreen {
	public OverScreen(String msg)
	{
		JFrame frame = new JFrame("Game is over !");  
        JPanel panel = new JPanel();  
        JLabel label = new JLabel(msg);  
        panel.add(label);  
        frame.add(panel);  
        frame.setSize(500, 80);  
        frame.setLocationRelativeTo(null); 
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);  
	}

}
