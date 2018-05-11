package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.WPastMedicationHistoryPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;

public class WPastMedicationHistoryTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	WPastMedicationHistoryPage PMHP;
	
	
	WPastMedicationHistoryTest()
	{
		super();	}
	@BeforeMethod
	public void Setup() throws Exception
	{
	TestBase.initalization();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	Loginpage= new Loginpage();
	HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	//EMRPage=HomePage.SearchusingCalender();
	//EMRPage= HomePage.ClickonEMR();
	EMRPage = HomePage.searchPaient();
	WHP= EMRPage.clickOnWomenField();
	PMHP=WHP.ClickOnpastMedicationHistory();
	}
	
	@Test(priority=1,enabled=false)
	public void DrugNameTest() throws InterruptedException
	{
		//PMHP.DrugName();
		String Actual = PMHP.DrugName();
		String Expected = "ADAPALENE";
		Assert.assertEquals(Actual, Expected, "Stringdoen't matched");
		System.out.println("testcase DrugNameTest is completed");
	}
	@Test(priority=2,enabled=false)
	public void DrugNameFieldEnableconditionTest() throws InterruptedException
	{
		PMHP.DrugName();
		boolean flag = PMHP.DrugNameFieldEnablecondition();
		Assert.assertFalse(flag);
		System.out.println("DrugNameFieldEnableconditionTest is completed");
		
	}
	@Test(priority=3)
	public void pastMedicationHistorysetdataTest() throws Exception
	{
		PMHP.pastMedicationHistorysetdata();
		
	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
