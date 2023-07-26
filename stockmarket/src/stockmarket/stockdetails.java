package stockmarket;
import java.sql.*;
import java.util.Scanner;

public class stockdetails{
	Scanner obj=new Scanner(System.in);
	  String url="jdbc:mysql://127.0.0.1:3306/java";
		String username="root";
		String password="5609";
		
		public void stockinsert()throws Exception{
			 try {
				
		 Connection con=DriverManager.getConnection(url,username,password);
	          System.out.println("ENTER THE NUMBER OF ROWS WOULD LIKE TO INSERT:");
	           int size=obj.nextInt();
	                    obj.nextLine();
	          String QUERY="insert into stocks.NIFTY50"+
	        	         "(STOCKNAME,CLOSINGPRICE,OPENINGPRICE,DAYHIGH,DAYLOW)VALUES (?,?,?,?,?);";
	        	         PreparedStatement st =con.prepareStatement(QUERY);
	         
	        for(int i=0;i<size;i++)
	         {	 
	        	
	        	System.out.println("ENTER THE STOCKNAME: ");
	        	 String STOCKNAME=obj.nextLine();
	        	 st.setString(1,STOCKNAME);
	        	 
	        	 System.out.println("ENTER THE CLOSINGPRICE: ");
	        	 float CLOSINGPRICE=obj.nextFloat()	;
	        	   st.setFloat(2,CLOSINGPRICE);
	        	 
	        	 System.out.println("ENTER THE OPENINGPRICE: ");
	        		float OPENINGPRICE=obj.nextFloat();
	        	 st.setFloat(3,OPENINGPRICE);
	        	 
	        	 System.out.println("ENTER THE DAYHIGH:");
	        		float DAYHIGH=obj.nextFloat()	;
	        	     st.setFloat(4,DAYHIGH);
	        	     
	        		 
	        	System.out.println("ENTER THE DAYLOW:");
	        	float DAYLOW=obj.nextFloat();
	        	             obj.nextLine();
	            st.setFloat(5,DAYLOW);
	            
	            st.executeUpdate();
	 
	         }
	        System.out.println(size+" ROWS ADDED SUCCESSFULLY");
		  }
			  catch(SQLException e) {
				  e.printStackTrace();
				  
			  }}
	        public void stocknameupdate()

	        {
	        	try {
	        
	         Connection con=DriverManager.getConnection(url,username,password);
			 
	         System.out.println("ENTER THE NEW STOCKNAME YOU WOULD LIKE TO UPDATE ");
	         String updatename=obj.nextLine();
	         
	         System.out.println("ENTER THE CORRESPONDING STOCKID  ");
	         int updateid=obj.nextInt();
	         
	         String QUERY="UPDATE stocks.NIFTY50 set STOCKNAME=? where STOCKID=?";
	         PreparedStatement st=con.prepareStatement(QUERY);
	         st.setString(1,updatename);
	         st.setInt(2, updateid);
	         st.executeUpdate();
	 		 System.out.println("STOCKNAME OF STOCKID:"+updatename+"UPDATED SUCCESSFULLY");
	        	}
	        	catch(SQLException e) {
				  e.printStackTrace();
				  
			  }}
	        	public void getbystockid(){
	        		try { Connection con=DriverManager.getConnection(url,username,password);
	    			
	    			System.out.println("ENTER THE STOCKID TO VIEW STOCKDETAILS");
	   	             int getbystockid=obj.nextInt();
	   	          String QUERY="select*from stocks.NIFTY50 where STOCKID="+getbystockid;
	   	       Statement st=(Statement) con.createStatement();     
	    		  ResultSet rs= st.executeQuery(QUERY);
	    			 while(rs.next()) {
	    	        	 System.out.println("ID : "+rs.getInt(1));
	    	        	 System.out.println("STOCKNAME : "+rs.getString(2));
	    	        	 System.out.println("CLOSINGPRICE : "+rs.getFloat(3));
	    	        	 System.out.println("OPENINGPRICE : "+rs.getFloat(4));
	    	        	 System.out.println("DAYHIGH : "+rs.getFloat(5));
	    	        	 System.out.println("DAYLOW : "+rs.getFloat(6));
	    	        	}}
	        		
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();
	   				  
	   			  }}
	        	public void STOCKSTABLE(){
	        		try { Connection   con=DriverManager.getConnection(url,username,password);
	    			
	    		
	   	          String QUERY="select*from stocks.NIFTY50";
	   	       Statement st=(Statement) con.createStatement();     
	    		  ResultSet rs= st.executeQuery(QUERY);
	    		  System.out.println("ID  STOCKNAME  CLOSEPRICE  OPENPRICE DAYHIGH  DAYLOW" );
	    			 while(rs.next()) {
	    	        	 System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"      "
	    	        	+rs.getFloat(3)+"      "+rs.getFloat(4)+"      "+
	    	        +rs.getFloat(5)+"      "+rs.getFloat(6));
	    	        	}}
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();
	   				  
	   			  }}
	        	
	        	
	        	public void deletebystockid(){
	        		try { Connection con=DriverManager.getConnection(url,username,password);
	        		 Statement st=(Statement) con.createStatement();
	    			System.out.println("ENTER THE STOCKID TO DELETE FROM NIFTY50 TABLE");
	   	             int deletebystockid=obj.nextInt();
	   	          String QUERY="Delete from stocks.nifty50 where STOCKID="+deletebystockid;
	   	           st.executeUpdate(QUERY);
	   	        System.out.println("STOCKID:"+deletebystockid+" FROM NIFTY50 TABLE DELETED SUCCESSFULLY");
	    		
	    	       }
	    	         
	    	         catch(SQLException e) {
	   				  e.printStackTrace();
	   				  
	   			  }}
	      }
