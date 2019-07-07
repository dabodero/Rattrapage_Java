package model;

import static org.junit.Assert.*;


import java.sql.DriverManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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
	public void DBConnection() {
		    try {		     
		      DriverManager.getConnection(Connector.url, Connector.user, Connector.passwd); // try a connection to Database
		    } catch (Exception e){
		        e.printStackTrace(); //print the error
		        fail("Not yet implemented");
		        System.exit(0);
		        
		        }
		 
		    }

}