package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Behavior;
import view.Screen;

public class Connector {

	
	
	static int  X = 0;
	static int  Y= 0;
	
	  

	
    
        public void run(Screen screen_) {
	     
    	String BDD = "jpublankproject";
        String url = "jdbc:mysql://localhost:3306/" + BDD;
        String user = "root";
        String passwd = "";
        // L'essaie de connexion à votre base de données
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
         
      //Création d'un objet Statement
      Statement state = conn.createStatement();
      //L'objet ResultSet contient le résultat de la requête SQL
      ResultSet result = state.executeQuery("SELECT content_map FROM map");
      //On récupère les MetaData
      java.sql.ResultSetMetaData resultMeta = result.getMetaData();
      
      
      ArrayList<Behavior> map = new ArrayList<Behavior>();
     
         
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
   			Dirt dirt = new Dirt("C:\\\\Users\\\\loisc\\\\Desktop\\\\PROJET\\\\GIT\\\\boulder_dash\\\\games_pictures\\\\image\\\\unbreak_dirt.png",X,Y); 
   			
   				
	  map.add (dirt);
	   
	   break;
      
        case 'W' :
        	Solid wall = new Solid("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\solid.png",X,Y);     	   
        	map.add (wall);
        	break;
        case 'J' :
        	Diamond diamond = new Diamond("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\Diamand.png",X,Y);      	   
        	map.add (diamond);
        	break;  
        case 'R' :
        	Rock rock = new Rock("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\rock.png",X,Y);      	   
        	map.add (rock);
        	break; 
        	
        case 'A' :
        	Air air = new Air("C:\\\\\\\\Users\\\\\\\\loisc\\\\\\\\Desktop\\\\\\\\PROJET\\\\\\\\GIT\\\\\\\\boulder_dash\\\\\\\\games_pictures\\\\\\\\image\\\\\\\\\\\\broken_wall.png",X,Y);      	   
        	map.add (air);	   
        	break;
           
   
        }
        }
      }
      
      screen_.setMap(map);
      

      result.close();
      state.close();
            
    } catch (Exception e) {
      e.printStackTrace();
    } ;
        
    
        
        
        
	 

}}
