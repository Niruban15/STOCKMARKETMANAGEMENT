package stockmarket;
import java.util.Scanner;

public class mainclass {

	  public static void main(String[] args)throws Exception{
          stockdetails obj=new stockdetails();
          userdetails obj1=new userdetails();
          Scanner sc=new Scanner(System.in);
           create cr=new create();
           System.out.println("ENTER THE RESPECTIVE NUMBER TO PERFORM OPERATION"
           		+ "\n                 1)CREATION OF NEW DATABASE AND TABLES"
           		+ "\n                 2)STOCKDETAILS"
           		+ "\n                 3)USERDETAILS");
           
           int userselection=sc.nextInt();
           
           switch(userselection)
           {
           case 1: 
        	   cr.createdatabase();
               cr.createstocktable();
               cr.createusertable();
               
        	   
        	   System.out.println("NEW DATABASE AND TABLE FOR USER AND STOCKS CREATED");
        	   break;
        	   
           case 2:
        	   System.out.println("ENTER THE RESPECTIVE NUMBER TO MANAGE STOCKDETAILS TABLE"
        	   		+ " \n                   1)INSERT A NEW STOCK DETAILS"
        	   		+ " \n                   2)TO UPDATE STOCKNAME"
        	   		+ " \n                   3)TO GET A STOCK DETAILS"
        	   		+ " \n                   4)TO GET ENTIRE STOCK DETAILS"
        	   		+ " \n                   5)TO DELETE A STOCK DETAILS"
        			   );
        	   int stocktable=sc.nextInt();
              switch(stocktable) {
              case 1:obj.stockinsert();
                             break;
              case 2:obj.stocknameupdate();
            	             break;
              case 3:obj.getbystockid();
            	              break;
              case 4:obj.STOCKSTABLE();
            	               break;
              case 5:obj.deletebystockid();
            	               break;
              }
                               break;
           case 3:
        	   System.out.println("ENTER THE RESPECTIVE NUMBER TO MANAGE USERDETAILS TABLE"
        	   		+ "    \n                1)INSERT A NEW USER DETAILS"
        	   		+ "    \n                2)TO UPDATE USERNAME"
        	   		+ "    \n                3)TO GET A USER DETAILS"
        	   		+ "    \n                4)TO GET ENTIRE USER DETAILS"
        	   		+ "    \n                5)TO DELETE A USER DETAILS"
        			   );
        	   int usertable=sc.nextInt();
              switch(usertable) {
              case 1:obj1.userinsert();
                             break;
              case 2:obj1.usernameupdate();
            	             break;
              case 3:obj1.getbyuserid();
            	              break;
              case 4:obj1.USERTABLE();
            	               break;
              case 5:obj1.deletebyuserid();
            	               break;
              }
           
           }
               

         sc.close();
         
         
          

}

	}


