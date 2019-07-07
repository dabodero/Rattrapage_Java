package view;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.Window;

public class WindowTest {

// Creation of new window //
	Window window = new Window("text");
	
// variables for  all the test //

	int expected_Witdth = 1000;
	int expected_Height = 1020;
	String expected_Title = "text";
	int expected_Width_location = 400;
	int expected_Height_location = 10;
	boolean expected_Visibility = true;
	boolean expected_setResizable = false;
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
	
	}

	@AfterClass
	public static void tearDownAfterClass()  {
	}

	@Before
	public void setUp()  {
		
	}

	@After
	public void tearDown()  {
	}

	
	@Test
	public void testHeight() {	
			assertEquals(expected_Witdth,window.getWindow().getWidth()); // Check if the Width of the Window is good
	}
		@Test
			public void testWidth() {
			assertEquals(expected_Height,window.getWindow().getHeight()); // Check if the Height of the Window is good
		}
		@Test
		public void testTitle() {
		assertEquals(expected_Title,window.getWindow().getTitle());	// Check if the Title of the Window is good

	}
		@Test
		public void testVisibility() {
			assertEquals(expected_Visibility,window.getWindow().isVisible()); // Check if the Window is visible

	}
		@Test
		public void testResizable() {
			assertEquals(expected_setResizable, window.getWindow().isResizable()); // Check if the Window is resizable

	}
		
}

