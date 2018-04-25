package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
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
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
		
@ Test(priority=1)
			
	public void ClickOnCmrTest() throws Exception 
	{
		EMRPage= HomePage.ClickonEMR();
		System.out.println("clicked on EMR");
		String Actual= HomePage.EMRPageTitle();
		String Expected = "EMR Dashboard";
		AssertJUnit.assertEquals(Actual, Expected);
		
	}
@ Test(priority=2)

public void SearchPatientUsingCalenderTest() throws Exception 
{
	HomePage.SearchusingCalender();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	AssertJUnit.assertEquals(Actual, Expectted);	
}
@Test(priority=3)
private void SearchPatientUsingPatientTabTest() throws Exception 
{
	HomePage.searchPaient();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	
}

@AfterMethod
public void teardown()
{
	driver.quit();
}
	
	
	
}
