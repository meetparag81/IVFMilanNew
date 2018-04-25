package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;


public class LoginPageTest extends TestBase
{
	
	Loginpage Loginpage;	
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	LoginPageTest() throws Exception
	{
		super();
	}
	@ BeforeTest
	public void Seup()
	{
		TestBase.initalization();
		 Loginpage = new Loginpage();
		 
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	@ Test(priority=1)
	public void loginTest() throws Exception
	{
		HomePage= Loginpage.Verifylogin( prop.getProperty("username"),prop.getProperty("password"));
		HomePage.SearchOnPage();
	}
		
		
		
		@ Test(priority=2)
		
		private void pageTitleTest()
		{
			String Title = "Palash IVF - Login";		
			String Actual = Loginpage.Homepagetitle();
			AssertJUnit.assertEquals(Title, Actual);					
		}		

			
		
		
		@ AfterTest
		public void Teardown()
		{
			//driver.quit();
		}
		
		
	
}
