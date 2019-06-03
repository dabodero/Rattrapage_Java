package view;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;

/**
 * class window
 */
public class Window{
	private static JFrame window;

	/**
	 * constructor
	 *
	 * @param text
	 * 			some text
	 */
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

	/**
	 * getter
	 *
	 * @return
	 * 		the window
	 */
	public JFrame getWindow() {return window;}


	/**
	 * addScreen methos
	 * @param screen
	 * 			screen
	 */
	public void addScreen(Screen screen) {
		screen.setPreferredSize(new Dimension(950, 1000));
		screen.setBackground(Color.BLACK);
		window.setContentPane(screen);
	}

	/**
	 * refresh method
	 */
	public void repaint() {window.repaint();}
	
}