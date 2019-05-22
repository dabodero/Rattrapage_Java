/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package view;
import view.Screen;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Color;
public class Window {
	private JFrame window;
	public Window(String text)
	{
		window = new JFrame();
		window.setTitle(text);
		window.setLocation(400, 10);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000, 1030);
	}
	
	public void addScreen(Screen screen) {
		screen.setPreferredSize(new Dimension(1000, 1030));
		screen.setBackground(Color.BLACK);
		window.setContentPane(screen);
	}
	
}