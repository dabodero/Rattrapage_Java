package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.Behavior;
import controller.BehaviorSpritePath;
import view.Screen;

public class Connector {

/**
*     Variable for position
*/	
	
	static int  X = 1;
	static int  Y= 0;
	
	
/**
*	identifiers for connection to DB
*/  
	final static String url = "jdbc:mysql://localhost:3306/jpublankproject";
    final static String user = "root";
    final static String passwd = "";
    
	public void run(Screen screen_, JFrame window, int map) {
        /*
        *Try to connect to the database
        */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
         
      //Creation of Statement object
      Statement state = conn.createStatement();
      //The ResultSet object contains the result of the SQL query
      ResultSet result = null;
      
      if(map == 1) {
      result = state.executeQuery("CALL Show_Map_One"); //Change for the differents maps
      }
      else if(map == 2)
      {
    	result = state.executeQuery("CALL Show_Map_Two"); //Change for the differents maps
      }
      else if(map == 3)
      {
    	  result = state.executeQuery("CALL Show_Map_Three"); //Change for the differents maps
      }
      else if(map == 4)
      {
    	result = state.executeQuery("CALL Show_Map_Four"); //Change for the differents maps
      }
      else if(map == 5)
      {
    	  result = state.executeQuery("CALL Show_Map_Five"); //Change for the differents maps
      }
      //metadata recoveries
      java.sql.ResultSetMetaData resultMeta = result.getMetaData();
      
     
      //assigning the position of each character in the table   
      String res = null ;
      while(result.next()){
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
      res = result.getObject(i).toString();
      for(int position = 1; position <=257; position++) {
          if(Y<16) {

              Y++;
          }
          else {
             X++;
              Y=1;
          }
    	char resultat = res.charAt(position);

    	switch (resultat) {

        case 'D' : 
            Dirt dirt = new Dirt(new BehaviorSpritePath().unbreak_dirt,X,Y); //New Object (path,X,Y) 
            screen_.addCharacter(dirt, window);

    break;

     case 'W' :
         Solid wall = new Solid(new BehaviorSpritePath().solid,X,Y);  //New Object (path,X,Y)
         screen_.addCharacter(wall, window);
         break;
     case 'J' :
         Diamond diamond = new Diamond(new BehaviorSpritePath().Diamond,X,Y);  //New Object (path,X,Y)
         screen_.addCharacter(diamond, window);
         break;
     case 'R' :
         Rock rock = new Rock(new BehaviorSpritePath().rock,X,Y);    //New Object (path,X,Y)
         screen_.addCharacter(rock, window);
         break; 

     case 'A' :
         Air air = new Air(new BehaviorSpritePath().broken_wall,X,Y);  //New Object (path,X,Y)
         screen_.addCharacter(air, window);
         break;

     case 'E' :
       EndBlock exit = new EndBlock(new BehaviorSpritePath().endBlock,X,Y);  //New Object (path,X,Y)
       screen_.addCharacter(exit, window);
       break;
     case 'H' :
       Hero hero = new Hero(new BehaviorSpritePath().hero,X,Y);  //New Object (path,X,Y)
       screen_.addCharacter(hero, window);
        break;
     case 'O' :
        Octopus octopus= new Octopus (new BehaviorSpritePath().octopus,X,Y);
        screen_.addCharacter(octopus,window);
        break;
     case 'B' :
         Butterfly butterfly = new Butterfly (new BehaviorSpritePath().butterfly,X,Y);
         screen_.addCharacter(butterfly, window);
         break;
         
     default :
    	 
    	 System.out.println("False Char");

    	}
    	
    	}
      }

      
//release memory
      result.close(); 
      state.close();
            
    } catch (Exception e) {
      e.printStackTrace();
    } ;
        
    
        
        
        
	 

}}
 