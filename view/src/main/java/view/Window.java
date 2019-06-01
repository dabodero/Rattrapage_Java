/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package view;
import view.Screen;
import controller.Behavior;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.awt.Color;
public class Window{
	public JFrame window;
	public Window(String text)
	{
		window = new JFrame();
		window.setTitle(text);
		window.setLocation(400, 10);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setSize(1000, 1020);
	}
	public JFrame getWindow() {return window;}
	
	public void addScreen(Screen screen) {
		screen.setPreferredSize(new Dimension(950, 1000));
		screen.setBackground(Color.BLACK);
		window.setContentPane(screen);
	}
	
	public void repaint() {window.repaint();}
	
}