package com_Milan_Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.CycleListPage;
import com_milan_POM.CycleOverviewPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.WInvestigationPage;
import com_milan_POM.WOPUCycyclePage;
import com_milan_POM.StimulationChartPage;
public class SimulationChartPageTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WInvestigationPage Investigation;
	WOPUCycyclePage WOC;
	CycleListPage CLP;
	CycleOverviewPage COP;
	StimulationChartPage SCP;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	@BeforeMethod
	public  void Setup()
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		Investigation = EMRPage.ClickOnInvestigation();
		WOC = new WOPUCycyclePage();
		WOC.ClickonCycles();
				boolean flag = WOC.AlreadySavedCycle();
		if(flag==true)
		{
			WOC.AddExistionService();
		}
		else
		{
		 boolean flag1= WOC.Existingcycle();
			 if(flag1==true)
			 {
				 System.out.println("Package already exist");

			 }
			 else
			 {
				 WOC.SaveOPUsubtypeICSI();
				 
			 }
		}		
		CLP= WOC.ClickonCycleOption();
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
		if(flag1==false&&flag2==true)
		{
			COP = CLP.ClickOnCycleCode();
			
		}
		else
		{
			CLP.ClickonNewCycle();
			CLP.NewPatientSaveTheCycle();
			COP = CLP.ClickOnCycleCode();
			
		}
		
		SCP =COP.StimulationChartPageClickOnOverview();
		
		
	}
	
	@Test(priority=1,enabled=false)
	public void AddDrugNames()
	{
		SCP.AddStimulationdrug();
	}
	
	@Test(priority=2,enabled=false)
	public void EnableconditionAddSimulationDrugTest()
	{
		boolean flag= SCP.EnableconditionAddSimulationDrug();
		
		if(flag==true)
		{
			assertTrue(flag);
			System.out.println("EnableconditionAddSimulationDrugTest is true");	
		}
		else
		{
			assertFalse(flag);
			System.out.println("EnableconditionAddSimulationDrugTest is false");
		}
	
	}
	@Test(priority=3,enabled=true)
	public void SaveSimulationTest()
	{
		System.out.println();
		String act= SCP.SaveSimulation();
		String exp = reader.getCellData("Stimulationchart", "Message", 4);
		Assert.assertEquals(act, exp);
		System.out.println("SaveSimulationTest is completed");
	}
	@Test(priority=4,enabled=true)
	public void SimulationDrugValidationTest()
	{
		int row=2;
		String act= SCP.SimulationDrugValidation();
		row++;
		String exp= reader.getCellData("Stimulationchart", "DrugName", row);
		Assert.assertEquals(act, exp);
		System.out.println("SimulationDrugValidationTest is completed");
	}
	@Test(priority=5,enabled=true)
	public void InvalidDateTest()
	{
		String act= SCP.InvalidDate();
		String exp= reader.getCellData("Stimulationchart", "Message", 3);
		Assert.assertEquals(act, exp);
		System.out.println("InvalidDateTest is completed");
	}
	
	@Test(priority=6,enabled=true)
	public void MessageonOPUPageTest()
	{
		String act= SCP.MessageonOPUPage();
		String exp= reader.getCellData("Stimulationchart", "Message", 5);
		Assert.assertEquals(act, exp);
		System.out.println("MessageonOPUPageTest is completed");
	}
	
	@AfterMethod
	public void Teardown()
	{
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-SiemenProcessingTest ");
		}
	}
	
	
	
	
}
