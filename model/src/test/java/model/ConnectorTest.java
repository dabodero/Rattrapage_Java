package model;

import static org.junit.Assert.*;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.Connection;

import controller.BehaviorDiamond;
import controller.BehaviorRock;
import controller.BehaviorSpritePath;
import model.Connector;
public class ConnectorTest {

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
	public void test1() {
		
		
			
		    try {		     
		      DriverManager.getConnection(Connector.url, Connector.user, Connector.passwd);
		    } catch (Exception e){
		        e.printStackTrace();
		        fail("Not yet implemented");
		        System.exit(0);
		        
		        }
		 
		    }
		 

	


@Test
public void test2() throws Exception {
	
					    		
		try {
			BehaviorRock rock = new controller.BehaviorRock(new BehaviorSpritePath().rock, 15, 15);
			BehaviorDiamond diamond = new controller.BehaviorDiamond(new BehaviorSpritePath().Diamond, 16, 16);
				
			assertNotSame(rock,diamond);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		}
	}




