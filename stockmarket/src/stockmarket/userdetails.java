package stockmarket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class userdetails {
	Scanner obj=new Scanner(System.in);
	  String url="jdbc:mysql://127.0.0.1:3306/java";
		String username="root";
		String password="5609";
		
		public void userinsert()throws Exception{
			 try {
				
		 Connection con=DriverManager.getConnection(url,username,password);
	          System.out.println("ENTER THE NUMBER OF ROWS WOULD LIKE TO INSERT:");
	           int size=obj.nextInt();
	                    obj.nextLine();
	          String QUERY="insert into stocks.USER"+
	        	         "(USERNAME,PAN_NUMBER,TRADES_TAKEN,TOTAL_BUY_VALUE,TOTAL_SELL_VALUE,FUNDS_AVAILABLE)VALUES (?,?,?,?,?,?);";
	        	         PreparedStatement st =con.prepareStatement(QUERY);
	         
	        for(int i=0;i<size;i++)
	         {	 
	        	
	        	System.out.println("ENTER THE USERNAME: ");
	        	 String USERNAME=obj.nextLine();
	        	 st.setString(1,USERNAME);
	        	 
	        	 System.out.println("ENTER THE PAN_NUMBER: ");
	        	 String PAN_NUMBER=obj.nextLine();
	        	  st.setString(2,PAN_NUMBER);
	        	 
	        	 System.out.println("ENTER THE TRADES_TAKEN: ");
	        		int TRADES_TAKEN=obj.nextInt();
	        		 obj.nextLine();
	        		st.setInt(3,TRADES_TAKEN);
	        	 
	        	 System.out.println("ENTER THE TOTAL_BUY_VALUE:");
	        		float TOTAL_BUY_VALUE=obj.nextFloat()	;
	        	     st.setFloat(4,TOTAL_BUY_VALUE);
	        	     
	        		 
	        	System.out.println("ENTER THE TOTAL_SELL_VALUE:");
	        	float TOTAL_SELL_VALUE=obj.nextFloat();
	            st.setFloat(5,TOTAL_SELL_VALUE);
	            
	            System.out.println("ENTER THE FUNDS_AVAILABLE:");
	        	float FUNDS_AVAILABLE=obj.nextFloat();
	        	obj.nextLine()	;
	        	st.setFloat(6,FUNDS_AVAILABLE);
	        	              
	            
	            st.executeUpdate();
	 
	         }
	        System.out.println(size+" ROWS ADDED SUCCESSFULLY");
		  }
			  catch(SQLException e) {
				  e.printStackTrace();
				  
			  }}
	        public void usernameupdate()

	        {
	        	try {
	        
	         Connection con=DriverManager.getConnection(url,username,password);
			 
	         System.out.println("ENTER THE NEW USERNAME YOU WOULD LIKE TO UPDATE ");
	         String updatename=obj.nextLine();
	         
	         System.out.println("ENTER THE CORRESPONDING USERID  ");
	         int updateid=obj.nextInt();
	         
	         String QUERY="UPDATE stocks.USER set USERNAME=? where USERID=?";
	         PreparedStatement st=con.prepareStatement(QUERY);
	         st.setString(1,updatename);
	         st.setInt(2, updateid);
	         st.executeUpdate();
	 		 System.out.println("USERNAME OF USERID:"+updatename+"UPDATED SUCCESSFULLY");
	        	}
	        	catch(SQLException e) {
				  e.printStackTrace();
				  
			  }}
	        	public void getbyuserid(){
	        		try { Connection con=DriverManager.getConnection(url,username,password);
	    			
	    			System.out.println("ENTER THE USERID TO VIEW USERDETAILS");
	   	             int getbyuserid=obj.nextInt();
	   	          String QUERY="select*from stocks.USER where USERID="+getbyuserid;
	   	       Statement st=(Statement) con.createStatement();     
	    		  ResultSet rs= st.executeQuery(QUERY);
	    			 while(rs.next()) {
	    	        	 System.out.println("ID : "+rs.getInt(1));
	    	        	 System.out.println("USERNAME : "+rs.getString(2));
	    	        	 System.out.println("PAN_NUMBER : "+rs.getString(3));
	    	        	 System.out.println("TRADES_TAKEN : "+rs.getInt(4));
	    	        	 System.out.println("TOTAL_BUY_VALUE : "+rs.getFloat(5));
	    	        	 System.out.println("TOTAL_SELL_VALUE : "+rs.getFloat(6));
	    	        	 System.out.println("FUNDS_AVAILABLE : "+rs.getFloat(7));


	    	        	}}
	        		
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();
	   				  
	   			  }}
	        	public void USERTABLE(){
	        		try { Connection   con=DriverManager.getConnection(url,username,password);
	    			String QUERY="select*from stocks.USER";
	   	       Statement st=(Statement) con.createStatement();     
	    		  ResultSet rs= st.executeQuery(QUERY);
	    		  
	    		  System.out.println("ID  USERNAME   PAN_NUMBER  TRADES_TAKEN  TOTAL_BUY_VALUE  TOTAL_SELL_VALUE  FUNDS_AVAILABLE" );
	    			 while(rs.next()) {
	    	        	 System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"      "
	    	        	+rs.getString(3)+"      "+rs.getInt(4)+"          "+
	    	        +rs.getFloat(5)+"            "+rs.getFloat(6)+"            "+rs.getFloat(7));
	    	        	}}
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();
	   				  
	   			  }}
	        	
	        	
	        	public void deletebyuserid(){
	        		try { Connection con=DriverManager.getConnection(url,username,password);
	        		 Statement st=(Statement) con.createStatement();
	    			System.out.println("ENTER THE STOCKID TO DELETE FROM NIFTY50 TABLE");
	   	             int deletebyuserid=obj.nextInt();
	   	          String QUERY="Delete from stocks.USER where USERID="+deletebyuserid;
	   	           st.executeUpdate(QUERY);
	   	        System.out.println("USERID:"+deletebyuserid+" FROM USER TABLE DELETED SUCCESSFULLY");
	    		
	    	       }
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();}
	   				  

}}
