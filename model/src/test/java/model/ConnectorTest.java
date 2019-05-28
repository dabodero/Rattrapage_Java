package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.BehaviorSpritePath;


public class ConnectorTest  {

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
  /*
* Test to check if the identifiers are good
*/
	public void testConnectionDB() {
		
		// declaration of identifiers
        String good_url = "jdbc:mysql://localhost:3306/jpublankproject";
        String good_user = "root";
        String good_passwd ="";
    //comparison between the received identifiers and those declared above               
        assertEquals(Connector.passwd,good_passwd);
        if(Connector.passwd != good_passwd) {
        fail("False Password");
        }
        assertEquals(Connector.url,good_url);
        if(Connector.url != good_url) {
        fail("False url");
        }
        assertEquals(Connector.user,good_user);
        if(Connector.user != good_user) {
        fail("False user");
        }
		
	}
/*	@Test */
  /*
* Test to check if sprite paths are correct
*/
	/*public void testPathSprite() {
		
		 String good_unbreak_dirt = "C:\\\\Users\\\\TRAVAIL\\\\mes_projets\\\\projet_java\\\\boulder_dash\\\\games_pictures\\\\Mur\\\\unbreak_dirt.png";
		 String good_solid = "C:\\\\Users\\\\TRAVAIL\\\\mes_projets\\\\projet_java\\\\boulder_dash\\\\games_pictures\\\\Mur\\\\unbreakable_wall.png";
		 String good_broken_wall = "C:\\\\Users\\\\TRAVAIL\\\\mes_projets\\\\projet_java\\\\boulder_dash\\\\games_pictures\\\\Mur\\\\broken_wall.png";
		 String good_Diamond = "C:\\\\Users\\\\TRAVAIL\\\\mes_projets\\\\projet_java\\\\boulder_dash\\\\games_pictures\\\\Diamand\\\\Diamand.png";
		 String good_rock = "C:\\\\Users\\\\TRAVAIL\\\\mes_projets\\\\projet_java\\\\boulder_dash\\\\games_pictures\\\\rock\\\\rock.png";
		 String good_hero = "C:\\\\Users\\\\TRAVAIL\\\\mes_projets\\\\projet_java\\\\boulder_dash\\\\games_pictures\\\\Personnage\\\\Face\\\\Face1.png";
		
		 
		 //passer par une classe temporaire pour les variables (pas possibles de faire Static string là ou il est de base)
		 assertEquals(BehaviorSpritePath.unbreak_dirt,good_unbreak_dirt);
	        if(BehaviorSpritePath.unbreak_dirt != good_unbreak_dirt) {
	        fail("Path of unbreak_dirt is false");
	        }
	        assertEquals(BehaviorSpritePath.solid,good_solid);
	        if(BehaviorSpritePath.solid != good_solid) {
	        fail("Path of solid is false");
	        }
	        assertEquals(BehaviorSpritePath.broken_wall,good_broken_wall);
	        if(BehaviorSpritePath.broken_wall != good_broken_wall) {
	        fail("Path of broken_wall is false");
	        }
	        assertEquals(BehaviorSpritePath.Diamond,good_Diamond);
	        if(BehaviorSpritePath.Diamond != good_Diamond) {
	        fail("Path of Diamond is false");
	        }
	        assertEquals(BehaviorSpritePath.rock,good_rock);
	        if(BehaviorSpritePath.rock != good_rock) {
	        fail("Path of Rock is false");
	        }
	        assertEquals(BehaviorSpritePath.hero,good_hero);
	        if(BehaviorSpritePath.hero != good_hero) {
	        fail("Path of hero is false");
	        }
		 
	}
*/
}