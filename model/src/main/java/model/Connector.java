package model;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Behavior;

public class Connector {

	
	
	

	public static void main(String[] argv){
    
	EventQueue.invokeLater(new Runnable() {
        public void run() {
	     
    	String BDD = "jpublankproject";
        String url = "jdbc:mysql://localhost:3306/" + BDD;
        String user = "root";
        String passwd = "";
        // L'essaie de connexion à votre base de donées
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
        
   switch (res.charAt(position)) {
   
   case 'D' :
	   System.out.println("Dirt");
	   break;
      
        case 'W' :
     	   System.out.println("Wall");
     	   break;
        case 'J' :
      	   System.out.println("Diamond");
      	   break;  
        case 'R' :
      	   System.out.println("Rock");
      	   break; 
        case 'A' :
      	   System.out.println("Air");
      	   break;
           
   
        }
        }
      };
      

      result.close();
      state.close();
         
    } catch (Exception e) {
      e.printStackTrace();
    } ;
        
    }
   	
        
	});
}
}