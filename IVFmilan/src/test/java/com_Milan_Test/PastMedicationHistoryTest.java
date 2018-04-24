package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.pastMedicationHistoryPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;

public class PastMedicationHistoryTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	pastMedicationHistoryPage PMHP;
	
	
	PastMedicationHistoryTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup() throws Exception
	{
	TestBase.initalization();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	Loginpage= new Loginpage();
	HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	//EMRPage=HomePage.SearchusingCalender();
	EMRPage= HomePage.ClickonEMR();
	WHP= EMRPage.clickOnWomenField();
	PMHP=WHP.ClickOnpastMedicationHistory();
	}
	
	@Test(priority=1)
	public void DrugNameTest()
	{
		//PMHP.DrugName();
		String Actual = PMHP.DrugName();
		String Expected = "ADAPALENE";
		Assert.assertEquals(Actual, Expected, "Stringdoen't matched");
		}
	@Test(priority=2)
	public void DrugNameFieldEnablecondition()
	{
		PMHP.DrugName();
		boolean flag = PMHP.DrugNameFieldEnablecondition();
		Assert.assertFalse(flag);
	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
