package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;


public class LoginPageTest extends TestBase
{
	
	Loginpage Loginpage;	
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	LoginPageTest() throws Exception
	{
		super();
	}
	@ BeforeMethod
	public void Seup()
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		 
	
	}
	@Test(priority=1)
	public void InvalidusernameTest() 
	{
		String username = reader.getCellData("LoginPage", 0, 2);	
		String Actual= Loginpage.Invalidusername(username);
		String Msg= reader.getCellData("LoginPage", 2, 2);
		String Expected= Msg;
		Assert.assertEquals(Actual, Expected);
		System.out.println("InvalidusernameTest is completed");
	}
	
	@Test(priority=2)
	public void InvalidPasswordTest() 
	{
		String username = reader.getCellData("LoginPage", 0, 3);
		String password = reader.getCellData("LoginPage", 1, 3);
		String Actual= Loginpage.Invaliduserpassword(username, password);
		String Msg= reader.getCellData("LoginPage", 2, 3);
		String Expected= Msg;
		Assert.assertEquals(Actual, Expected);
		System.out.println("InvalidpasswordTest is completed");
	}
	
	@Test(priority=3)
	public void ButtonEnableConditionTest()
	{
		
		boolean flag1=Loginpage.ButtonEnableCondition(prop.getProperty("username"));
		Assert.assertFalse(flag1);
	}
		
	@ Test(priority=4)
	public void LoginTest() 
	{
		HomePage= Loginpage.Verifylogin( prop.getProperty("username"),prop.getProperty("password"));
		String Title = "Palash IVF - Login";		
		String Actual = Loginpage.Homepagetitle();
		Assert.assertEquals(Title, Actual);
	}	
		
		
		

			
		
		
		@ AfterMethod
		public void Teardown()
		{
			try
			{
			driver.quit();
			}
			catch(UnreachableBrowserException e)
			{
				System.out.println("UnreachableBrowserException is seen at-LoginPageTest ");
			}
		}
		
		
	
}
