
import static org.junit.Assert.*;


import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import view.Window;


public class ScreenTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		JFrame window_bis;
		{
			window_bis = new JFrame();
			window_bis.setLocation(400, 10);
			window_bis.pack();
			window_bis.setVisible(true);
			window_bis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window_bis.setResizable(false);
			window_bis.setSize(1000, 1020);
		}
		}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWindows() {
		
		Window window_bis;
		window_bis = new Window("Boulder Dash");
		
		
		assertTrue(Window.window == window_bis.window);
	}

	

}
