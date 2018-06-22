package com_Milan_Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.BeforeClass;
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

public class CycleOverviewPageTest extends TestBase 
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WInvestigationPage Investigation;
	WOPUCycyclePage WOC;
	CycleListPage CLP;
	CycleOverviewPage COP;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	
	
	
	
	
	
	CycleOverviewPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		Investigation = EMRPage.ClickOnInvestigation();
		WOC = new WOPUCycyclePage();
		
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
				 WOC.SaveOPUsubtypeICSI();

			 }
			 else
			 {
				 System.out.println("cycle already exist");
			 }
		}		
		CLP= WOC.ClickonCycleOption();
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		if(flag1==true)
		{
			CLP.ClickonNewCycle();
			CLP.SaveTheCycle();	
		}
		else
		{
			System.out.println("User has already saved cycle");
		}
		COP = CLP.ClickOnCycleCode();
	}
	
	

	
	@Test(priority=1,enabled=true)
	public void ValueInSourceofSpermOptionTest() throws Exception
	{
		String act= COP.SourceofSperm();
		String exp = CLP.SourceofspermPartner();
		Assert.assertEquals(act, exp);
		System.out.println("ValueInSourceofSpermOptionTest is compleed");
	}
		
		@Test(priority=2,enabled=true)
		public void ValueInMethodOfSemenCollectionOptionTest() throws Exception
		{
			String act= COP.ValueInMethodOfSemenCollectionOption();
			String exp = CLP.MethodofSemenCollection();
			Assert.assertEquals(act, exp);
			System.out.println("ValueInMethodOfSemenCollectionOptionTest is completed");
		}
		@Test(priority=3,enabled=true)
		public void ValueInProtocolTest() throws Exception
		{
			String act= COP.ValueInProtocol();
			String exp = CLP.NoofProtocol();
			Assert.assertEquals(act, exp);
			System.out.println("ValueInProtocoltest is completed");
		}
		@Test(priority=4,enabled=true)
		public void ValueInARTTypeTest() throws Exception 
		{
			String act= COP.ValueInARTType();
			String exp = CLP.ARTTypeOption();
			Assert.assertEquals(act, exp);
			System.out.println("ValueInARTTypeTest is completed");
		}
		@Test(priority=5,enabled=true)
		public void EnableconditionAddSimulationDrugTest()
		{
			boolean flag= COP.EnableconditionAddSimulationDrug();
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
		
		
		
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
}
