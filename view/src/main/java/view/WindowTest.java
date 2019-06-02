package view;

import static org.junit.Assert.*;


import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.Window;

public class WindowTest {

	static JFrame window;
	int expected_Witdth = 1000;
	int expected_Height = 1020;

	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass()  {
	}

	@Before
	public void setUp()  {

		
		{
			window = new JFrame();
			window.setLocation(400, 10);
			window.pack();
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			window.setSize(1000, 1020);
		}
		
		
	}

	@After
	public void tearDown()  {
	}

	@Test
	public void test() {
// ne fonctionne pas, trouve null
		assertEquals(expected_Witdth,Window.window.getWidth());
		assertEquals(expected_Height,Window.window.getHeight());
	}

}
