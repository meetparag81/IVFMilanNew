package com_Milan_Test;

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
		// EMRPage= HomePage.ClickonEMR();
		// EMRPage=HomePage.SearchusingCalender();
		CLP=  EMRPage.ClickonCycle();
		 
		 
		
	}
	@Test(priority=1,enabled=false)
	public void ClickonNewCycleTest()
	{
		String act= CLP.ClickonNewCycle();
		String exp = reader.getCellData("CycleList", "ListTitle", 3);
		Assert.assertEquals(act, exp);
		System.out.println("ClickonNewCycleTest is completed");
		
	}
	
	
	
	@Test(priority=2,enabled=false)
	public void CycleListTitleTest()
	{
	String Actual=CLP.CycleListTitle();
	String Expected = 	reader.getCellData("CycleList", "ListTitle", 2);
	System.out.println("CycleListTitleTest completed");
	
	}
	
	@Test(priority=3,enabled=false)
	public void NewCycleButtonEnableConditionTest()
	{
	boolean flag1=CLP.NewCycleButtonEnableCondition();
	
	Assert.assertTrue(flag1);
	}
	
	@Test(priority=4,enabled=false)
	public void EnabledconditionARTTypeTest()
	{
	boolean flag2=CLP.EnabledconditionARTType();
	
	Assert.assertFalse(flag2);
	}
	@Test(priority=5,enabled=false)
	public void ARTTypeOptionTest()
	{
	String act=	CLP.ARTTypeOption();
	String exp = reader.getCellData("CycleList", "ARTtype", 2);
	Assert.assertEquals(act, exp);	
	System.out.println("ARTTypeOptionTest is completed" );
	}
	@Test(priority=6,enabled=false)
	public void NoofProtocolandselectionTest ()
	{
		int Act=CLP.NoofProtocol();
		int exp= reader.getRowCount("CycleList");
		Assert.assertEquals(Act, exp);
		System.out.println("NoofProtocolandselectionTest is completed");
	}
	@Test(priority=7)
	public void MethodofSemenCollectionTest()
	{
		int Act=CLP.MethodofSemenCollection();
		reader.getCellData("CycleList", "SiemenSize", 2);
		
	}
	@Test(priority=8)
	public void MethodSourceofspermTest()
	{
		CLP.Sourceofsperm();
	}
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
	

}
