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
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.AllergiesPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.SearchPage;
import com_milan_POM.WomenHistoryPage;


public class WAllergiesTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	AllergiesPage Allergies;
	SearchPage SP;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	WAllergiesTest()
	{
		super();
	}
	@ BeforeMethod
	public void Seup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		//EMRPage= HomePage.ClickonEMR();
		//SearchPage SP = new SearchPage();
		//EMRPage= HomePage.SearchusingCalender();
		WHP= EMRPage.clickOnWomenField();
		Allergies= WHP.ClickOnAllergies();	
	}
	@Test(priority=1,enabled= true)
	public void FoodAllergyvalidationTest()
	{
		
		boolean flag= Allergies.foodvalidation();
		Assert.assertTrue(flag);
		System.out.println("Alergy textbox is enabled");
	}
	@Test(priority=2,enabled= true)
	public void AddNewAllergiesTest() 
	{
		AllergiesPage.AddnewAllergies();
		String Actial= Allergies.SaveMessageForNewPaient();
		String expected = reader.getCellData("Allergies", "Message", 2);
		
	}
	
	@Test(priority=3,enabled= true)
	public void SaveMessage()
	{
	String Actual=	Allergies.AllergiesOnDashboardforNewPatient();
	
	String Expected= reader.getCellData("Allergies", "Message", 3);
	}
		

@Test(priority=4,enabled= true)
public void OptionSelectedOnAllergyCurrentStstusTest() 
{
	String Actual= Allergies.OptionSelectedinDrugAllergyCurrentstatus();
	String Expected = "Present";
	Assert.assertEquals(Actual, Expected);
	System.out.println("OptionSelectedOnAllergyCurrentStstusTest is completed");
}
@Test(priority=5,enabled= true)
public void ExistingPatientDrugAllergyTypeTest() 
{
		
	String Actual = Allergies.AllergiesNameOnDashboard();
			String Expected=reader.getCellData("Allergies", "Message", 4);
					 
			System.out.println();
		
}
@Test(priority=6,enabled= true)
public void AllergySelectionTest() 
{
	boolean flag=Allergies.size();
	if(flag==true)
	{
		Allergies.AllergySelection();
		String act = Allergies.SaveMessage();
		String exp = reader.getCellData("Allergies", "Message", 2);
		System.out.println("AllergySelectionTest is completed");
		
	}
	else
	{
		String act = Allergies.SaveMessage();
		String exp = reader.getCellData("Allergies", "Message", 3);
		System.out.println("AllergySelectionTest is completed");
		
	}
	
	
	
}
	
	
	

	
	@ AfterMethod
	public void Teardown()
	{
		TemporaryFilesystem tempFS = TemporaryFilesystem.getDefaultTmpFS();
		tempFS.deleteTemporaryFiles();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
