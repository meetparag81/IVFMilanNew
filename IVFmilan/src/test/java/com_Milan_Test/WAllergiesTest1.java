package com_Milan_Test;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.AllergiesPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.SearchPage;
import com_milan_POM.WomenHistoryPage;


public class WAllergiesTest1 extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	AllergiesPage Allergies;
	SearchPage SP;
	
	WAllergiesTest1()
	{
		super();
	}
	@ BeforeMethod
	public void Seup() throws Throwable
	{
		TestBase.initalization();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.ClickonEMR();
		//SearchPage SP = new SearchPage();
		//EMRPage= HomePage.SearchusingCalender();
		WHP= EMRPage.clickOnWomenField();
		Allergies= WHP.ClickOnAllergies();	
	}
	@Test(priority=2,enabled= false)
	public void FoodAllergyvalidationTest()
	{
		
		boolean flag= Allergies.foodvalidation();
		AssertJUnit.assertTrue(flag);
		System.out.println("Alergy textbox is enabled");
	}
	@Test(priority=1)
	public void AddNewAllergiesTest() throws InterruptedException
	{
		String Actial= Allergies.AllergiesNameonDashboard();
		String Expected= ",17 BETAESTRADIOL,foodAllergy,SkinAllergy,smokeAllergy";
	}
		

@Test(priority=3,enabled= false)
public void OptionSelectedOnAllergyCurrentStstusTest() throws Exception
{
	String Actual= Allergies.OptionSelectedinDrugAllergyCurrentstatus();
	String Expected = "Present";
	AssertJUnit.assertEquals(Actual, Expected);
}
@Test(priority=4)
public void ExistingPatientDrugAllergyTypeTest() throws Exception
{
	EMRPage= HomePage.SearchusingCalender();	
	String Actual = Allergies.AllergiesNameonDashboard();
			String Expected="17 BETAESTRADIOL";
			System.out.println();
}
	
	
	

	
	@ AfterMethod
	public void Teardown()
	{
		TemporaryFilesystem tempFS = TemporaryFilesystem.getDefaultTmpFS();
		tempFS.deleteTemporaryFiles();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
