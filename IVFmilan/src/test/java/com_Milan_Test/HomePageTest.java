package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

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

public class HomePageTest extends TestBase
{
	Loginpage Loginpage;	
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	
	HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup() throws Exception
	{
		TestBase.initalization();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1,enabled=false)
	public void DatacreationTest() throws Exception
	{
		int Actualrows= HomePage.PatientDataCreation();
		int Expected = 12;
		Assert.assertEquals(Actualrows, Expected);
	}
		
@ Test(priority=2,enabled=false)
			
	public void ClickOnCmrTest() throws Exception 
	{
		EMRPage= HomePage.ClickonEMR();
		System.out.println("clicked on EMR");
		String Actual= HomePage.EMRPageTitle();
		String Expected = "EMR Dashboard";
		Assert.assertEquals(Actual, Expected);
		System.out.println( "patient click on dashboard is completed");
		
	}
@ Test(priority=3,enabled=false)

public void SearchPatientUsingCalenderTest() throws Exception 
{
	HomePage.SearchusingCalender();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	AssertJUnit.assertEquals(Actual, Expectted);
	System.out.println("search patient through Searchbox is completed");
}
@Test(priority=4)
private void SearchPatientUsingPatientTabTest() throws Exception 
{
	HomePage.searchPaient();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	System.out.println("search patient test completed");
	
}



@AfterMethod
public void teardown()
{
	driver.quit();
}
	
	
	
}
