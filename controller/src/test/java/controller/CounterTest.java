package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CounterTest {

// variables for test //
	int expected_nb_diamond = 1; 
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
	public void test() {
		
		new Counter(); // create new counter
		Counter.addDiamond(); // add a diamond in the counter
		assertTrue(Counter.nbDiamond == expected_nb_diamond); // check if the Counter is updated
	}

}