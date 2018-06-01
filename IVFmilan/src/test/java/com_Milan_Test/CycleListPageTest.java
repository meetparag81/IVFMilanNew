package com_Milan_Test;

import org.testng.Assert;
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
		Investigation = EMRPage.ClickOnInvestigation();
		 WOC = new WOPUCycyclePage();
		 CLP=  EMRPage.ClickonCycle();
		
	}
	@Test(priority=1)
	public void CycleListTitleTest()
	{
	String Actual=CLP.CycleListTitle();
	String Expected = 	reader.getCellData("Investigation", "CycleList", 2);
	
	}
	
	@Test(priority=2)
	public void NewCycleButtonEnableConditionTest()
	{
	boolean flag1=CLP.NewCycleButtonEnableCondition();
	
	Assert.assertTrue(flag1);
	}
	
	
	
	

}
