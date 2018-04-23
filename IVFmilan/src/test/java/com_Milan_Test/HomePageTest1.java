package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;

public class HomePageTest1 extends TestBase
{
	
	
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	
	
	HomePageTest1()
	{
		super();
	}
	
	@ BeforeMethod
	public void Seup() throws Exception
	{
		TestBase.initalization();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	}
			
	@Test(priority=1)
	public EMRDashBoardPage SearchPaienttest() throws Exception
	{
		 
		String Actual = HomePage.EMRPageTitle();
		String Expected = "EMR Dashboard";
		Assert.assertEquals(Actual, Expected);
		return EMRPage;
		
		
		
	}
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	
	
	
}