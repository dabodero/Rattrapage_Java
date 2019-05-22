/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package view;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import controller.Behavior;

public class Screen extends JPanel {
	
	public Dimension getPreferredSize() {
		return new Dimension(1000, 1030);
	}
	
	protected void paintComponent(Graphics g) {

		int xStart=1000/16;
		int yStart=1000/16;
		g.setColor( Color.red );
		
		while(xStart < 1000) {
		g.drawLine ( xStart, 0, xStart, 1000 );
		xStart += 1000/16;
		}
		g.setColor( Color.green );
		while(yStart < 1000) {
			g.drawLine ( 0, yStart, 1000, yStart );
			yStart += 1000/16;
			}
	}
	
	public Screen()
	{
		
	}
	
	void add(Behavior test) {}
}