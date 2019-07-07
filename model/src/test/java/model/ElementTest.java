package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.SpritePath;


public class ElementTest { 
	// variables for the test // 

	
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
	public void Butterfly() {
		try {
			new model.Butterfly(new SpritePath().butterfly, 15, 15); // create an element
		} catch (final Exception e) {
		fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error
			
		}
	}
	
	@Test
	public void Diamond() {
		try {
			new model.Diamond(new SpritePath().Diamond, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error 
		}
		
	}
	@Test
	public void Dirt() {
		try {
			new model.Dirt(new SpritePath().unbreak_dirt, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error 
		}
	}
	@Test
	public void EndBlock() {
		try {
			new model.EndBlock(new SpritePath().endBlock, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error 
		}
	}
	@Test
	public void Hero() {
		try {
			new model.Hero(new SpritePath().hero, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error 
		}
	}
	@Test
	public void Octopus() {
		try {
			new model.Octopus(new SpritePath().octopus, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error 
		}
	}
	@Test
	public void Rock() {
		try {
			new model.Rock(new SpritePath().rock, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error 
		}
	}
	@Test
	public void Wall() {
		try {
			new model.Solid(new SpritePath().solid, 15, 15); // create an element

			} catch (final Exception e) {	
				fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error
		}
	}
	@Test
	public void Air() {
		try {
			new model.Air(new SpritePath().broken_wall, 15, 15); // create an element
			} catch (final Exception e) {
			fail("Should throw exception when X < 0 or X > 16 and when Y < 0 or Y > 16 "); // print the error
		}
	}
	
}