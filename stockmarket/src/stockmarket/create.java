package stockmarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class create {
	Scanner obj=new Scanner(System.in);
	  String url="jdbc:mysql://127.0.0.1:3306/java";
		String username="root";
		String password="5609";
		
	public void createdatabase()

	  {
		  try { 
			
				Connection con=DriverManager.getConnection(url,username,password);
	        String QUERY="create database stocks";
         Statement st=(Statement) con.createStatement();      
          st.executeUpdate(QUERY);
        System.out.println("Created new DATABASE:STOCKS"); 	}
		  catch(SQLException e) {
			  e.printStackTrace();
			  
		  }}
        
        
		  public void createtable() {
			  try {Connection con=DriverManager.getConnection(url,username,password);
				  Statement st=(Statement) con.createStatement();     
        String QUERY="create table stocks.NIFTY50"+
               "(STOCKID integer primary key auto_increment,"+
               "STOCKNAME VARCHAR(50)UNIQUE,"+
               "CLOSINGPRICE FLOAT,"+
               "OPENINGPRICE FLOAT,"+
               "DAYHIGH FLOAT,"+
              "DAYLOW FLOAT)";
    st.executeUpdate(QUERY);
    System.out.println("Created table NIFTY50");
    
    
    String QUERY1="create table stocks.USER"+
  		    "(USERID int PRIMARY KEY auto_increment,"+
              "USERNAME VARCHAR(50),"+
              "PAN_NUMBER INTEGER UNIQUE,"+
              "TRADES_TAKEN INTEGER,"+
              "TOTAL_BUY_VALUE FLOAT,"+
              "TOTAL_SELL_VALUE FLOAT,"+
              "FUNDS_AVAILABLE FLOAT)";
    st.executeUpdate(QUERY1);
    System.out.println("Created table USER");}
	  catch(SQLException e) {
		  e.printStackTrace();
		  
	  }}
	  
}
