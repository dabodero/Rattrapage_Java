package model;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.Connection;

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
	public void test() {
		
		try {
			
		    try {
		        
		      DriverManager.getConnection(Connector.url, Connector.user, Connector.passwd);
		    } catch (Exception e){
		        e.printStackTrace();
		        fail("Not yet implemented");
		        System.exit(0);
		        
		        }
		 
		    }
		   finally {
       	}
}
	}