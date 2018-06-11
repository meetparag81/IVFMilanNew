package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;

public class HomePageTest extends TestBase
{
	Loginpage Loginpage;	
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
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
	
	@Test(priority=1,enabled=false)
	public void DatacreationTest() throws Exception
	{
		int Actualrows= HomePage.PatientDataCreation();
		int Expected = reader.getRowCount("HomePage");
		Assert.assertEquals(Actualrows, Expected);
	}
		
@ Test(priority=4)
			
	public void ClickOnCmrTest() throws Exception 
	{
		EMRPage= HomePage.ClickonEMR();
		String Actual= HomePage.EMRPageTitle();
		String Expected = "EMR Dashboard";
		Assert.assertEquals(Actual, Expected);
		System.out.println( "patient ClickOnCmrTest is completed");
		
	}
@ Test(priority=3)

public void SearchPatientUsingCalenderTest() throws Exception 
{
	HomePage.SearchusingCalender();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	Assert.assertEquals(Actual, Expectted);
	System.out.println("search patient through Searchbox is completed");
}
@Test(priority=2)
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
