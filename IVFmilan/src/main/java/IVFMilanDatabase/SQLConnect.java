package IVFMilanDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnect 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:sqlserver://http://192.168.1.202:1000;DatabaseName=emp";
        //for referenceonly   //jdbc:sqlserver://server:port;DatabaseName=dbname 

		//Database Username		
		String username = "Administrator";	
        
		//Database Password		
		String password = "Rational@1 ";				

		//Query to Execute		
		String query = "select *  from employee;";	
        
 	    //Load mysql jdbc driver	
		try
		{
   	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException is seen");
		}
	
   	 
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl, username, password);
    	
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String myName = rs.getString(1);								        
                    String myAge = rs.getString(2);					                               
                    System. out.println(myName+"  "+myAge);		
            }		
			 // closing DB Connection		
			con.close();			
}

	


}


