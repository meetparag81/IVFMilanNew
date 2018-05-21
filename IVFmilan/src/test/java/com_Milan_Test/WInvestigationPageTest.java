package com_Milan_Test;

import org.testng.Assert;
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
	Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	int exp, Expected;

	public WInvestigationPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws Exception 
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		// EMRPage= HomePage.ClickonEMR();
		// EMRPage=HomePage.SearchusingCalender();
		Investigation = EMRPage.ClickOnInvestigation();

	}

	@Test(priority=1,enabled=false)
	public void CycleCreationTest() throws Exception 
	{
		int Actual = Investigation.Setsearchvalue();
		int Expected = reader.getRowCount("Investigation");
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority=2)
	public void REFIVFPACKAGEARTCycleTest() throws Exception
	{
	int Actual =Investigation.REFIVFPACKAGEARTCycle();
	int Expected = 6;
	Assert.assertEquals(Actual, Expected);
	
		
	}
}
