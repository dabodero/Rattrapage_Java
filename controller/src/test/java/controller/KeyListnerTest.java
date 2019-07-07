package controller;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KeyListnerTest {
	KeyListner keylistener;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		keylistener = new KeyListner();
		// creation of new window for test //
		JFrame window = new JFrame();
		window.setLocation(400, 10);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setSize(10, 10);
		keylistener.init_key_listner(window);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testKeyPressed() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    robot.delay(1000);
	    robot.keyPress(KeyEvent.VK_A); // simulate that the key a is pressed
	    try {
			Thread.sleep(1000); // stop the thread for 1s
		} catch (InterruptedException e) {
			e.printStackTrace(); // print the error
		}
		assertEquals('a', keylistener.getKeyPressed()); // check if the key pressed is the good key
		robot.keyRelease(KeyEvent.VK_A); // release the key
	}
	@Test
	public void testKeyNotPressed() {
		assertEquals('%', keylistener.getKeyPressed()); // check if the key is pressed or not
	}

}