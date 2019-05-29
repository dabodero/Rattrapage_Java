package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Behavior;
import controller.Octopus;
import view.Screen;

public class Connector {

/**
*     Variable for position
*/	
	
	static int  X = 0;
	static int  Y= 0;
	
/**
*	identifiers for connection to DB
*/  

	final static String url = "jdbc:mysql://localhost:3306/jpublankproject";
    final static String user = "root";
    final static String passwd = "";
    
    

	public void run(Screen screen_) {

    	
        
        /*
        *Try to connect to the database
        */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
         
      //Creation of Statement object
      Statement state = conn.createStatement();
      //The ResultSet object contains the result of the SQL query
      ResultSet result = state.executeQuery("CALL Show_Map_One"); //Change for the differents maps
      //metadata recoveries
      java.sql.ResultSetMetaData resultMeta = result.getMetaData();
      
      
      ArrayList<Behavior> map = new ArrayList<Behavior>();
     
      //assigning the position of each character in the table   
     String res = null ;
      while(result.next()){         
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
      res = result.getObject(i).toString();
      for(int position = 1; position <=256; position++) {
       
    	  if(Y<16) {
    		      		  
    		  Y++;
    	  }
    	  else {
    		 X++;
    		  Y=1;
    	  }
    	  	
    	 
    	 
   switch (res.charAt(position)) {
   
   		case 'D' : 
   			Dirt dirt = new Dirt("C:\\\\Users\\\\loisc\\\\Desktop\\\\PROJET\\\\GIT\\\\boulder_dash\\\\games_pictures\\\\image\\\\unbreak_dirt.png",X,Y); //New Object (path,X,Y) 
   			
   				
	  map.add (dirt); // method to add a sprite and his behavior in the case
	   
	   break;
      
        case 'W' :
        	Solid wall = new Solid("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\solid.png",X,Y);  //New Object (path,X,Y)
        	map.add (wall); // method to add a sprite and his behavior in the case
        	break;
        case 'J' :
        	Diamond diamond = new Diamond("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\Diamand.png",X,Y);  //New Object (path,X,Y)    	   
        	map.add (diamond);// method to add a sprite and his behavior in the case
        	break;  
        case 'R' :
        	Rock rock = new Rock("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\rock.png",X,Y);    //New Object (path,X,Y)  	   
        	map.add (rock);// method to add a sprite and his behavior in the case
        	break; 
        	
        case 'A' :
        	Air air = new Air("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\broken_wall.png",X,Y);  //New Object (path,X,Y)    	   
        	map.add (air);	// method to add a sprite and his behavior in the case   
        	break;
        
        case 'E' :
          EndBlock exit = new EndBlock("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\door.png",X,Y);  //New Object (path,X,Y)
          map.add (exit); // method to add a sprite and his behavior in the case
          break;
        case 'H' :
          Hero hero = new Hero("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\Face1.png",X,Y);  //New Object (path,X,Y)       
          map.add (hero); // method to add a sprite and his behavior in the case
          break;

       case 'B' :
           Butterfly butterfly = new Butterfly("frfr00", X, Y);
           map.add (butterfly);
           break;

       case 'O' :
           Octopus octopus = new Octopus("frfr00", X, Y);
           map.add (octopus);
           break;
        }
        }
      }
      
      screen_.setMap(map);
      
//release memory
      result.close(); 
      state.close();
            
    } catch (Exception e) {
      e.printStackTrace();
    } ;
        
    
        
        
        
	 

}}
 