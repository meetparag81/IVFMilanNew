package com_Milan_Test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.AllergiesPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.MenHistoryPage;
import com_milan_POM.SearchPage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.FemaleDiagnosisPage;

public class EMRDashBoardPageTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	MenHistoryPage MHP;
	SearchPage SearchPage;
	AllergiesPage Allergies;
	FemaleDiagnosisPage FemaleDiagnosis;
	
	
	EMRDashBoardPageTest()
	{
		super();
	}
	
	@ BeforeMethod
	public void Seup() throws Exception
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		//EMRPage=HomePage.SearchusingCalender();
		//EMRPage= HomePage.ClickonEMR();
		
		
		
		
		
		
	}
	@Test(priority=1)
	public void ClickonWoomenPaientFieldTest() throws InterruptedException
	{
		
		WHP= EMRPage.clickOnWomenField();
		
		String Actual= EMRPage.TitleHistoryPage();
		String Expected = "History";
		Assert.assertEquals(Actual, Expected);
		System.out.println("ClickonWoomenPaientFieldTest is completed");
		
	}
	@Test(priority=2)
	public void ClickOnMenPaientHistory() throws Exception
	{
		MHP= EMRPage.clickOnMenField();
		String Actual= EMRPage.TitleHistoryPage();
		String Expected = "History";
		Assert.assertEquals(Actual, Expected);
		
		System.out.println("ClickonMenPaientFieldTest is completed");
		
	}
	
	@Test(priority=3)
	public void ClickOnDiagnosisTest() throws Exception
	{
		FemaleDiagnosis= EMRPage.ClickOnDiagnosis();
		System.out.println("ClickonMenPaientFieldTest is completed");		
	}
	
	/*@Test(priority=4)
	public void OptionSelectedOnAllergyformTest() throws Exception
	{
		EMRPage= HomePage.searchPaient();		
		Allergies.AllergiesNameonDashboard();
	}*/
	
	
	@ AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
