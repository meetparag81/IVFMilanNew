package com_Milan_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.Loginpage;
import com_milan_POM.HomePage;
import com_milan_POM.CycleListPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.WInvestigationPage;
import com_milan_POM.WOPUCycyclePage;


public class WOPUCycyclePageTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WInvestigationPage Investigation;
	WOPUCycyclePage WOC;
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	WOPUCycyclePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void Setup() throws Exception
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		// EMRPage= HomePage.ClickonEMR();
		// EMRPage=HomePage.SearchusingCalender();
		Investigation = EMRPage.ClickOnInvestigation();
		 WOC = new WOPUCycyclePage();
	}
	
	@Test(priority=5,groups = {"functional" },enabled=true)
	public void DeleteARTCycleTest() throws Exception
	{		
	String Actual=	WOC.DeleteTheSevice();
	String Expected = reader.getCellData("Investigation", "Fashmessage", 3);
	System.out.println("cycle is deleted sucessfully");
	}
	
	@Test(priority=3,groups = {"functional" },enabled=true)
	public void OPUsubtypeICSITest() throws Exception
	{
		
		String Actual = WOC.OPUsubtypeICSI();
		String Expected = reader.getCellData("Investigation","Fashmessage", 2);
		Assert.assertEquals(Actual, Expected);
		System.out.println("SelectSubTypeCycleTest is completed");
		
	}
	@Test(priority=4,groups = {"smoketest" },enabled=true)
	public void ARTCycleAvailabilityMessageTest() throws Exception 
	{
		String Actual = WOC.ARTCycleAvailabilityMessage();
		String Expected = reader.getCellData("Investigation","Fashmessage", 3);
		Assert.assertEquals(Actual, Expected);
		System.out.println("ARTCycleAvailabilityMessage is completed");
		
	}
	@Test(priority=2,groups = {"functional" },enabled=true)
	public void NoofCyclesTest() throws Exception 
	{
		int Actual= WOC.NoofCycles();
		int Expected = 7;
		Assert.assertEquals(Actual, Expected);		
	}
	@Test(priority=6,groups = {"smoketest" },enabled=true)
	public void ClickonCycletabTest() throws Exception
	{
		String Actual= WOC.ClickOnCycle();
		

			
	}
	@Test(priority=1,groups = {"smoketest" },enabled=true)
	public void SearchcycleTest() throws Exception
	{
		 WOC.SearchThecycles();

			
	}
	
	
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
