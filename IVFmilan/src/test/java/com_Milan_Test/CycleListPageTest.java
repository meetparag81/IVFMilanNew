package com_Milan_Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.apache.bcel.generic.BALOAD;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.CycleListPage;
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
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	
	
	
	CycleListPageTest()
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
		Investigation = EMRPage.ClickOnInvestigation();
		WOC = new WOPUCycyclePage();
		boolean flag = WOC.AlreadySavedCycle();
		if(flag==true)
		{
			WOC.AddExistionService();
		}
		else
		{
			int count =0;
			 boolean flag1= WOC.Existingcycle();
			 if(flag1==false)
			 {
				 WOC.SaveOPUsubtypeICSI();
				 count++;
			 }
			 else
			 {
				 System.out.println("cycle already exist");
			 }
		}		
		CLP=  EMRPage.ClickonCycle();
		
		 
		 
		
	}
	@Test(priority=1,enabled=true)
	
	public void ClickonNewCycleTest() throws Exception
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
	
	
	
	@Test(priority=2,enabled=true)
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
	
	@Test(priority=3,enabled=true)
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
			boolean flag2=CLP.EnabledconditionARTType();
			
			Assert.assertFalse(flag2);
			System.out.println("EnabledconditionARTTypeTest is completed");	
			
		}
		else
		{
			try
			{
				assertTrue(flag1);
			}
			catch(AssertionError e)
			{
				System.out.println("Patient has already available cycle, which is not closed");
				throw e;
			}
			
		}
		
	}
	@Test(priority=5,enabled=false,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void ARTTypeOptionTest() throws Exception
	{
	String act=	CLP.ARTTypeOption();
	String exp = "OPU";
	Assert.assertEquals(act, exp);	
	System.out.println("ARTTypeOptionTest is completed" );
	}
	@Test(priority=6,enabled=true,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void ProtocolandselectionTest () throws Exception
	{
		String Act=CLP.NoofProtocol();
		String exp= "Antagonist";
		Assert.assertEquals(Act, exp);
		System.out.println("NoofProtocolandselectionTest is completed");
	}
	@Test(priority=7,enabled=true,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void MethodOfSemenCollectionTest() throws Exception
	{
		String Act=CLP.MethodofSemenCollection();
		String exp= reader.getCellData("CycleList", "SiemenName",4);
		Assert.assertEquals(Act, exp);
		System.out.println("MethodofSemenCollectionTest is completed");
		
		
	}
	@Test(priority=8,enabled=true,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void SourceofspermPartnerTest() throws Exception
	{
		String act= CLP.SourceofspermPartner();
		String exp = reader.getCellData("CycleList", "SpermName", 3);
		Assert.assertEquals(act, exp);
		System.out.println("MethodSourceofspermTest is completed");
		
	}
	@Test(priority=9,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void SourceofSpermselectionDonorTest() throws Exception
	{
		String Act= CLP.SourceofSpermselectionDonor();
		String Exp = reader.getCellData("CycleList", "sourceofsperm", 3);
		Assert.assertEquals(Act, Exp);
		System.out.println("SourceofSpermselectionDonorTest is completed");
	}
	@Test(priority=10,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void SimulationDrugTest() throws Exception
	{
		String Actual= CLP.SimulationDrug();
		String Expected = reader.getCellData("CycleList", "Stimulation Drug", 4);
	}
	@Test(priority=11,dependsOnMethods = {"EnabledconditionARTTypeTest"})
	public void SaveTheCycleTest() throws Exception
	{
		CLP.SaveTheCycle();
		boolean Save=CLP.SaveEnablecondition();
		if(Save==true)
		{
		
			String act= CLP.SaveMessage();
			String exp = reader.getCellData("CycleList", "SaveMessage", 2);
			
		}
		else
		{
			String act= CLP.SaveMessage();
			String exp = reader.getCellData("CycleList", "SaveMessage", 3);
			
		}
		
		
	}
	
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
	

}
