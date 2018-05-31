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
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.AllergiesPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.MenHistoryPage;
import com_milan_POM.SearchPage;
import com_milan_POM.WInvestigationPage;
import com_milan_POM.WVitalsPage;
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
	WInvestigationPage Investigation;
	WVitalsPage Vitals;
	String Actual1, Expected1;
	int count=0;
	int row=2;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
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
	@Test(priority=1,enabled=false)
	public void ClickonWoomenPaientFieldTest() throws InterruptedException
	{
		MHP= EMRPage.clickOnMenField();
		boolean flag = EMRPage.GetGetEnableconditionWoMenfield();
		if(flag==false)
		{
			 Actual1=EMRPage.GetEmrTitle();
			 count++;
		}
		else
		{
			Actual1= EMRPage.TitleHistoryPage();
		}
		String Actual= Actual1;
		
		
		WHP= EMRPage.clickOnWomenField();
		boolean flag1 = EMRPage.GetEnableconditionMenfield();
		if(flag==false)
		{
			 Actual1=EMRPage.GetEmrTitle();
			 count++;
		}
		else
		{
			EMRPage.TitleHistoryPage();
		}
		String Actual2= Actual1;
		if(count>0)
		{
			row++;
			 Expected1 = reader.getCellData("EMRPage", "Message", row);
		}
		else
		{
			Expected1=reader.getCellData("EMRPage", "Message", row);
		}
		String Expected = Expected1;
		Assert.assertEquals(Actual2, Expected);
				
		System.out.println("ClickonWoomenPaientFieldTest is completed");
		
	}
	@Test(priority=2,enabled=false)
	public void ClickOnMenPaientHistory() throws Exception
	{
		MHP= EMRPage.clickOnMenField();
		boolean flag = EMRPage.GetEnableconditionMenfield();
		if(flag==false)
		{
			 Actual1=EMRPage.GetEmrTitle();
			 count++;
		}
		else
		{
			EMRPage.TitleHistoryPage();
		}
		String Actual= Actual1;
		if(count>0)
		{
			row++;
			 Expected1 = reader.getCellData("EMRPage", "Message", row);
		}
		else
		{
			Expected1=reader.getCellData("EMRPage", "Message", row);
		}
		String Expected = Expected1;
		Assert.assertEquals(Actual, Expected);
		
		System.out.println("ClickonMenPaientFieldTest is completed");
		
	}
	
	@Test(priority=3,enabled=false)
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
	@Test(priority=4)
	public void ClickOnInvestigationTest() throws Exception
	{
		Investigation= EMRPage.ClickOnInvestigation();
		
		
	}
	@Test(priority=5)
	public void ClickOnVitalTest() throws Exception
	{
		EMRPage.ClickOnVitals();
	}
	
	
	
	
	@ AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
