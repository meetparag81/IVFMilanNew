package IVFMilanDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com_Milan_Base.TestBase;

public class ConnectToSQL extends TestBase
{
	
	@Test (priority=2)
	public void TestDB() throws SQLException 
	{
	try {
		
		Class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
	}
	catch (ClassNotFoundException e) 
	{
	System.out.println("ClassNotFoundException");
	}
	System.out.println("Driver is loaded");
	 
	 System.out.println("Connect to DB");
	 
	 Connection con = DriverManager.getConnection("jdbc:odbc:Login_DB");
			 
	System.out.println("Connected to my sqldb");
	 
	Statement stm = con.createStatement();
	
	ResultSet rs = stm.executeQuery("select* from dbo.T_UserRole");
	
		while(rs.next());
		System.out.println("SQLException is seen");
	
	String userid = null;
	try 
	{
		userid = rs.getString("UserID");
	} 
	catch (SQLException e) 
	{
		
	}
	
	System.out.println(userid);
	}
	@Test (priority=1)
	public void CheckConnection()
	{
		try 
	    {
			System.out.println();
			
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            System.out.println("Driver is loaded");
	           Connection con = DriverManager.getConnection("http://192.168.1.202", "sa", "Rational@1");
	            if (con != null) 
	            {
	                System.out.println("Connection Successful!");
	            }
	}
	 catch (Exception e) 
	{
	    e.printStackTrace();
	    System.out.println("Error Trace in getConnection() : " + e.getMessage());
	}
	
	
	
	}
}
	
	

