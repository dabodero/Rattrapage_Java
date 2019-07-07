package controller;

import static org.junit.Assert.*;	

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BehaviorTest {

// Variables for tests //
	Behavior test;
	 int expected_x = 1;
	 int expected_y = 1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX()  {
		
   
try {
	test = new BehaviorAir(null,1,1);
	assertEquals(expected_x, test.getX()); // Check if the method getX() work
} catch (Exception e) {
	e.printStackTrace(); // print the error
}
   
	}
	
	@Test
	public void testGetY()  {
		
try {
	test = new BehaviorAir(null,1,1);
	assertEquals(expected_y, test.getY()); // Check if the method getY() work
} catch (Exception e) {
	e.printStackTrace(); // print the error
}
	}
	
	@Test
	
	public void checkType() {
		
		try {
			test = new BehaviorAir(null,1,1);
			 assertTrue(0 <= test.getType() && test.getType() <= 9); // check if the method GetType() choose an existing type
		}catch (Exception e) {
			e.printStackTrace(); // print the error
		}
		
	}
@Test
	
	public void TestLimitsGetX() {		
		try {
			test = new BehaviorAir(null,255,1);
			 assertTrue(0 <= test.getX() && test.getX() <= 16); // check if the method getX() can return an X < 0 or an X > 16
		}catch (Exception e) {
			e.printStackTrace(); // print the error
		}
		
	}
@Test

public void TestLimitsGetY() {	
	try {
		test = new BehaviorAir(null,123,1);
		 assertTrue(0 <= test.getY() && test.getY() <= 16); // check if the method getY() can return an Y < 0 or an Y > 16
	}catch (Exception e) {
		e.printStackTrace(); // print the error
	}
	
}

@Test

public void TestArrayList() {
	ArrayList<Behavior> map = new ArrayList<Behavior>(); 
	Behavior.getBehaviorAt(0, 0, map); 
	assertFalse( map == null); // check if the map is empty
	
}
}
