/**
 * @author Léo Sanchez leo.sanchez@viacesi.fr
 * @version 1.0
 */
package view;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

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
		this.setLayout(null);
		map = new ArrayList<Behavior>();
	}
	
	public void addCharacter(Behavior character, JFrame window)
	{
		character.setImageIcon(new ImageIcon(new ImageIcon(character.getSpritePath()).getImage().getScaledInstance(62,62, Image.SCALE_DEFAULT)));
		character.setJLabel(new JLabel(character.getImageIcon())); 
		character.getJLabel().setBounds(62*(character.getX()-1), 62*(character.getY()-1), 62, 62);
		this.add(character.getJLabel());
		window.pack();
		window.repaint();
		
		map.add(character);
	}
	
	public List<Behavior> getMapBehavior(){return map;}
	
	public Behavior getBehaviorAt(int X, int Y)
	{
		//TDTDTTTTDTTDD
		//TDTDTTTTDDDDT
		//DDTDTDTDTTTDD
		return map.get((X-1)+(16*(Y-1)));
	}
	
	List<Behavior> map; 
}