package com_Milan_Test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.AddictionsPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.SearchPage;
import com_milan_POM.WInvestigationPage;
import com_milan_POM.WomenHistoryPage;

public class WInvestigationPageTest extends TestBase 
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	AddictionsPage Addictions;
	SearchPage SearchPage;
	WInvestigationPage Investigation;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	int exp, Expected;

	public WInvestigationPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		// EMRPage= HomePage.ClickonEMR();
		// EMRPage=HomePage.SearchusingCalender();
		Investigation = EMRPage.ClickOnInvestigation();

	}

	@Test(priority=1,groups = {"smoketest" },enabled=false)
	public void CycleCreationTest() 
	{
		int Actual = Investigation.Setsearchvalue();
		int Expected = reader.getRowCount("Investigation");
		Assert.assertEquals(Actual, Expected);
	}
	
	
	@Test(priority=2,groups = {"smoketest" },enabled=true)
	public void IVFPACKAGEARTCyclecountTest() 
	{
	int Actual =WInvestigationPage.REFIVFPACKAGEARTCycleCount();
	int expected = 7;
	
	Assert.assertEquals(Actual, expected);	
	System.out.println("IVFPACKAGEARTCyclecountTest is completed");
	}
	@Test(priority=3,groups = {"smoketest" },enabled=true)
	public void OUIARTSubTypesTest() 
	{
		int Actual =Investigation.OUIARTSubTypes();
		int expected = 4;
		
		Assert.assertEquals(Actual, expected);	
		
	}
	
	@Test(priority=4,groups = {"smoketest" },enabled=false)
	public void OPUCycleTest() 
	{
		Investigation.OPUCycle();
		String Actual =Investigation.SaveMessage();
		String Expected = reader.getCellData("Investigation", "Fash message", 2);
		
	}
	
	
	@AfterMethod
	public void Teardown() 
	{
		driver.quit();
	}
	
	
	
	
	
	
}
