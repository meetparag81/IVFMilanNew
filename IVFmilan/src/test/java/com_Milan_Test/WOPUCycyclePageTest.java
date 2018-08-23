package com_Milan_Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
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
	CycleListPage CLP;
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	 String msg;
	WOPUCycyclePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		Investigation = EMRPage.ClickOnInvestigation();
		 WOC = new WOPUCycyclePage();
		 WOC.ClickonCycles();
		 
	}
	
	
	@Test(priority=1,groups = {"smoketest" },enabled=true)
	public void AddOneServiceAtleastMessageTest()
	{
		String act= WOC.AddOneServiceAtleastMessage();
		String exp = reader.getCellData("Investigation", "Fashmessage", 8);
		System.out.println("AddOneServiceAtleastTest is completed");
	}
	@Test(priority=2,groups = {"smoketest" },enabled=true)
	public void AleadySavedCycleTest() 
	{
		boolean flag= WOC.AlreadySavedCycle();// if there is already available cycle saved this option become true.
		if(flag==true)
		{
			String act=	WOC.AddExistionService();
			String exp = reader.getCellData("Investigation", "Fashmessage", 6);
			Assert.assertEquals(act, exp, "existingpackageadded");	
			System.out.println("AleadySavedCycleTest is completed");
		}
		else
		{
			assertFalse(flag);
			System.out.println("AleadySavedCycleTest is completed");
		}
		
	}	
	@Test(priority=3,groups = {"functional" }, enabled=true)
	public void SaveOPUsubtypeICSITest() 
	{
		System.out.println();
		boolean flag1 =WOC.AlreadySavedCycle();// if there is already available cycle saved this option become true.
		if(flag1==true)
		{
			 
			String act= WOC.AddExistionService();
			String exp = reader.getCellData("Investigation", "Fashmessage", 6);
			Assert.assertEquals(act, exp);
			
		}
		else
		{
			boolean flag= WOC.Existingcycle();
			if(flag==true)
			{
			String Actual = WOC.SaveOPUsubtypeICSI();
			String Expected = reader.getCellData("Investigation","Fashmessage",5 );
			Assert.assertEquals(Actual, Expected);
			System.out.println("SelectSubTypeCycleTest is completed");
			}
			else
			{
			String Actual = WOC.SaveOPUsubtypeICSI();
			String Expected = reader.getCellData("Investigation","Fashmessage",2 );
			Assert.assertEquals(Actual, Expected);
			System.out.println("SelectSubTypeCycleTest is completed");
			}
		}
	
	}
	
	
	@Test(priority=4,groups = {"smoketest" },enabled=true)
	public void MessageforAlreadtyavailableCycleTest() 
	{
		boolean flag1 =WOC.AlreadySavedCycle();// if there is already available cycle saved this option become true.
		boolean flag2 = WOC.Existingcycle();
		if(flag1==true&&flag2==true)
		{
			String act= WOC.MessageforAlreadtyavailableCyclebothtrue(); 
			String exp = reader.getCellData("Investigation", "Fashmessage", 4);
			Assert.assertEquals(act, exp);
			
			System.out.println("MessageforAlreadtyavailableCycleTest is completed");
		}
		else if(flag1==false&&flag2==true)
		{
		String act= WOC.MessageforAlreadtyavailableCyclebothtrue();
		String exp = reader.getCellData("Investigation", "Fashmessage",4);
		Assert.assertEquals(act, exp);
		System.out.println("MessageforAlreadtyavailableCycleTest is completed");
		
		}
	
	}
	
	@Test(priority=5,groups = {"smoketest" },enabled=true)
	public void ARTCycleAvailabilityMessageBeforeSaveTheCycleTest() throws Exception 
	{
		boolean flag1= WOC.AlreadySavedCycle();
		boolean flag2=WOC.Existingcycle();
		if(flag1==false&& flag2==false)
		{
			String act= WOC.MessageForAvaibility();
			String exp = reader.getCellData("Investigation", "Fashmessage", 7);
				Assert.assertEquals(act, exp);
		System.out.println("ARTCycleAvailabilityMessage is completed");
		}
		else if(flag1==true&&flag2==true)
		{
			String act= WOC.MessageForAvaibility();
			String exp = reader.getCellData("Investigation", "Fashmessage", 4);
				Assert.assertEquals(act, exp);
		}
		else if(flag1==false&&flag2==true)
		{
			String act= WOC.MessageForAvaibility();
			String exp = reader.getCellData("Investigation", "Fashmessage", 7);
				Assert.assertEquals(act, exp);
				System.out.println("ARTCycleAvailabilityMessage is completed");
			
		}
		else if(flag1==true&&flag2==false)
		{
			String act= WOC.MessageForAvaibility();
			String exp = reader.getCellData("Investigation", "Fashmessage", 4);
				Assert.assertEquals(act, exp);
		}
		
		}
		
	@Test(priority=6,groups = {"smoketest" },enabled=true)
	public void SearchcycleTest() throws Exception
	{
		int sct= WOC.SearchThecycles();	
		int exp= 7;
	}
	
	@Test(priority=7,groups = {"functional" },enabled=true)
	public void DeleteTheSeviceBeforeSaveThecycleTest() throws Exception
	{
		boolean flag1 =WOC.Existingcycle();
		boolean flag2 = WOC.CycleAvailability();
		if(flag1==true&&flag2==true)
		{
			String act=WOC.DeleteThePackage();
			String exp = reader.getCellData("Investigation", "Fashmessage", 9);
		
		System.out.println("DeleteTheSeviceBeforeSaveThecycleTest is completed");
		}
		else if(flag1==true&&flag2==false)
		{
			String act=WOC.DeleteThePackage();
			String exp = reader.getCellData("Investigation", "Fashmessage", 3);
			
			System.out.println("DeleteTheSeviceBeforeSaveThecycleTest is completed");
			
		}
		
	}
	
	
	
	
	@Test(priority=8,groups = {"functional" }, enabled=true)
	public void NoofCyclesTest() 
	{
		boolean flag1 =WOC.AlreadySavedCycle();// if ther is already available cycle saved this option become true.
		if(flag1==true)
		{
			
			msg = "Cycle is already available";
		}
		else
		{
			int Actual= WOC.NoofCycles();
			int Expected = 7;
			Assert.assertEquals(Actual, Expected);
			System.out.println("NoofCyclesTestis completed");
		}
		
		
	}
	@Test(priority=9,groups = {"smoketest" }, enabled=true)
	public void ClickonCycletabTest() throws Exception
	{
		boolean flag1 =WOC.AlreadySavedCycle();// if ther is already available cycle saved this option become true.
		if(flag1==true)
		{
			
			String Actual= WOC.ClickOnCycle();
			String Expected = reader.getCellData("Investigation", "Fashmessage", 11);
			Assert.assertEquals(Actual, Expected);
			System.out.println("ClickonCycletabTest is completed");
			
		}
		else
		{
		String Actual= WOC.ClickOnCycle();
		String Expected = reader.getCellData("Investigation", "Fashmessage", 11);
		Assert.assertEquals(Actual, Expected);
		}
	
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-OPUcyclePageTest ");
		}
	}
	
	
	
	
	
	

}
