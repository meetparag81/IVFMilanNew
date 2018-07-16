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
	
	@Test
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
			 //DriverManager.getConnection("Data Source=192.168.1.5;Initial Catalog=Genome_Dev_21DEC17;User Id=sa;Password=Rational@1;Pooling=True;Min Pool Size=25;Max Pool Size=300" );
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
	}
	
	

