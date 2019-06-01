package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BehaviorAllTest {


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
		
		try {
			new BehaviorRock("C:\\Users\\loisc\\Desktop\\PROJET\\GIT\\boulder_dash\\games_pictures\\image\\\\rock.png", 15, 15);
			fail("Should throw exception");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
			}

}


