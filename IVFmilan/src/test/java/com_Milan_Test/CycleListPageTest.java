package com_Milan_Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.apache.bcel.generic.BALOAD;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.CycleListPage;
import com_milan_POM.CycleOverviewPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.WInvestigationPage;
import com_milan_POM.WOPUCycyclePage;

public class CycleListPageTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WInvestigationPage Investigation;
	WOPUCycyclePage WOC;
	CycleListPage CLP;
	CycleOverviewPage COP;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	
	
	
	CycleListPageTest()
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
		Investigation= Investigation.ClickOnCycles();
		WOC = new WOPUCycyclePage();
		
		boolean flag = WOC.AlreadySavedCycle();
		if(flag==true)
		{
			WOC.AddExistionService();
		}
		else
		{

			 boolean flag1= WOC.Existingcycle();
			 if(flag1==false)
			 {
				 WOC.SaveOPUsubtypeICSI();

			 }
			 else
			 {
				 System.out.println("cycle already exist");
			 }
		}		
		CLP= WOC.ClickonCycleOption();
		
	}
	@Test(priority=3,enabled=true)
	
	public void ClickonNewCycleTest() 
	{
		boolean flag = CLP.NewCycleButtonEnableCondition();
		if(flag)
		{
			String Act= CLP.ClickonNewCycle();
			String exp = reader.getCellData("CycleList", "ListTitle",2);
			Assert.assertEquals(Act, exp);
			System.out.println("ClickonNewCycleTest is completed");
		}
		else
		{
			assertFalse(flag);
			System.out.println("ClickonNewCycleTest is completed");
		}
		
	}
	
	
	
	@Test(priority=2,enabled=true)//done
	public void CycleListTitleTest()
	{
		boolean flag = CLP.NewCycleButtonEnableCondition();
		if(flag)
		{
			String Actual=CLP.CycleListTitle();
			String Expected = reader.getCellData("CycleList", "ListTitle", 2);
			System.out.println("CycleListTitleTest completed");
			
		}
		else
		{
			String Actual=CLP.CycleListTitle();
			String Expected = reader.getCellData("CycleList", "ListTitle", 2);
			System.out.println("CycleListTitleTest completed");
		}
		
	
	
	}
	
	@Test(priority=1,enabled=true)
	public void NewCycleButtonEnableConditionTest()
	{
		
		boolean flag = CLP.NewCycleButtonEnableCondition();
	if(flag==true)
	{
		Assert.assertTrue(flag);
		System.out.println("NewCycleButtonEnableConditionTest is completed");
	}
	else
	{
		Assert.assertFalse(flag);
		System.out.println("NewCycleButtonEnableConditionTest is completed");
	}
	
	}
	
	@Test(priority=4,enabled=true)
	public void EnabledconditionARTTypeTest() throws Exception
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		if(flag1==true)
		{
			CLP.ClickonNewCycle();
			boolean flag2=CLP.EnabledconditionARTType();
			
			Assert.assertFalse(flag2);
			System.out.println("EnabledconditionARTTypeTest is completed");	
			
		}
		else
		{
			
			{
				assertFalse(flag1);
				Assert.assertFalse(flag1);
				System.out.println("EnabledconditionARTTypeTest is completed");	
			}
			
			
		}
		
	}
	@Test(priority=5,enabled=true)
	public void ARTTypeOptionTest() 
	{
		
		boolean flag= CLP.CycleCodeAvaibility();
		if(flag= true)
		{
			COP = CLP.ClickOnCycleCode();
			String act=	CLP.ARTTypeOption();
			String exp = "OPU";
			Assert.assertEquals(act, exp);	
			System.out.println("ARTTypeOptionTest is completed" );
		}
		else
		{
			CLP.ClickonNewCycle();
			String act=	CLP.ARTTypeOption();
			String exp = "OPU";
			Assert.assertEquals(act, exp);	
			System.out.println("ARTTypeOptionTest is completed" );
			
		}
	
	}
	@Test(priority=6,enabled=true)// need to test
	public void ProtocolandselectionTest()
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
	
		if(flag1==false&&flag2==true)
		{
		COP = CLP.ClickOnCycleCode();
		 String Act = CLP.NoofProtocol();
		String exp= "Antagonist";
		Assert.assertEquals(Act, exp);
		System.out.println("NoofProtocolandselectionTest is completed");
		}
		else
		{
			CLP.ClickonNewCycle();
			 String Act = CLP.NoofProtocol();
			String exp= "Antagonist";
			Assert.assertEquals(Act, exp);
			System.out.println("NoofProtocolandselectionTest is completed");
			
		}
	}
	@Test(priority=7,enabled=true)
	public void MethodOfSemenCollectionTest() 
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
	
		if(flag1==false&&flag2==true)
		{
			COP = CLP.ClickOnCycleCode();
			String Act = CLP.MethodofSemenCollection();
			String exp= reader.getCellData("CycleList", "SiemenName",4);
			Assert.assertEquals(Act, exp);
			System.out.println("MethodofSemenCollectionTest is completed");
		}
		else
		{
			CLP.ClickonNewCycle();
			String Act = CLP.MethodofSemenCollection();
			String exp= reader.getCellData("CycleList", "SiemenName",4);
			Assert.assertEquals(Act, exp);
			System.out.println("MethodofSemenCollectionTest is completed");
			
		}
		
	}
	@Test(priority=8,enabled=true)
	public void SourceofspermPartnerTest() 
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
	
		if(flag1==false&&flag2==true)
		{
			COP = CLP.ClickOnCycleCode();
			String act= CLP.SourceofspermPartner();
			String exp = reader.getCellData("CycleList", "SpermName", 3);
			Assert.assertEquals(act, exp);
			System.out.println("MethodSourceofspermTest is completed");
		}
		else
		{
			CLP.ClickonNewCycle();
			String act= CLP.SourceofspermPartner();
			String exp = reader.getCellData("CycleList", "SpermName", 3);
			Assert.assertEquals(act, exp);
			System.out.println("MethodSourceofspermTest is completed");
		}
			
	}
		
	
	@Test(priority=9, enabled=true)
	public void SourceofSpermselectionDonorTest()
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
		
		if(flag1==false&&flag2==true)
		{
			COP = CLP.ClickOnCycleCode();
			String Act= CLP.SourceofSpermselectionDonor();
			String Exp = reader.getCellData("CycleList", "sourceofsperm", 3);
			Assert.assertEquals(Act, Exp);
			System.out.println("SourceofSpermselectionDonorTest is completed");
			
		}
		else
		{
			
		CLP.ClickonNewCycle();
		String Act= CLP.SourceofSpermselectionDonor();
		String Exp = reader.getCellData("CycleList", "sourceofsperm", 3);
		Assert.assertEquals(Act, Exp);
		System.out.println("SourceofSpermselectionDonorTest is completed");
		}
	}
	@Test(priority=10,enabled=true)
	public void SimulationDrugTest() 
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
		
		if(flag1==false&&flag2==true)
		{
			COP = CLP.ClickOnCycleCode();
			String Actual= CLP.SimulationDrug();
			String Expected = reader.getCellData("CycleList", "Stimulation Drug", 20);
			Assert.assertEquals(Actual, Expected);
			System.out.println("SimulationDrugTest is completed");
		}
		else
		{
			CLP.ClickonNewCycle();
			String Actual= CLP.SimulationDrug();
			String Expected = reader.getCellData("CycleList", "Stimulation Drug", 20);
			Assert.assertEquals(Actual, Expected);
			System.out.println("SimulationDrugTest is completed");
			
		}
		
		
	}
	@Test(priority=11,enabled=true)// need to test
	public void LMPDateTest()
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
		
		if(flag1==false&&flag2==true)
		{	
		COP = CLP.ClickOnCycleCode();
		String act= CLP.LMPDateForSave();
		String exp=  reader.getCellData("CycleList", "LMPDate", 2);
		Assert.assertEquals(act, exp);
		System.out.println("LMPDateTest is completed");
			
		}
		else
		{
		CLP.ClickonNewCycle();
		String act= CLP.LMPDate();
		String exp=  TestUtil.CurrentDate();
		Assert.assertEquals(act, exp);
		System.out.println("LMPDateTest is completed");
			
		}
		
		
	}
	
	
	
	@Test(priority=12,enabled=true)
	public void SaveTheCycleTest()
	{
		boolean flag1 = CLP.NewCycleButtonEnableCondition();
		boolean flag2 = CLP.CycleCodeAvaibility();
		
		if(flag1==false&&flag2==true)
		{
			COP = CLP.ClickOnCycleCode();
			CLP.SaveTheCycle();
			String act= CLP.SaveMessage();
			String exp = reader.getCellData("CycleList", "SaveMessage", 5);
			Assert.assertEquals(act, exp);
			System.out.println("SaveTheCycleTest is completed");
			
		}
		else
		{
			
			CLP.NewPatientSaveTheCycle();
			String act= CLP.SaveMessage();
			String exp = reader.getCellData("CycleList", "SaveMessage", 2);
			Assert.assertEquals(act, exp);
			System.out.println("SaveTheCycleTest is completed");
			
		}
		
		
	}
	@Test(priority=13,enabled=false)
	public void LMPDateTest1()
	{
		
		CLP.ClickonNewCycle();
		CLP.LMPDate();	
		
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
			System.out.println("UnreachableBrowserException is seen at-CycleListPageTest ");
		}
	}
	
	
	
	

}
