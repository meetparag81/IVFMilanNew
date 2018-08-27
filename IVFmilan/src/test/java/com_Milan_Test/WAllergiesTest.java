package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.remote.UnreachableBrowserException;
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
		WHP= EMRPage.clickOnWomenField();
		Allergies= WHP.ClickOnAllergies();	
	}
	@Test(priority=2,enabled= true)
	public void FoodAllergyvalidationTest()
	{
		
		boolean flag= Allergies.foodvalidation();
		Assert.assertTrue(flag);
		System.out.println("Alergy textbox is enabled");
	}
	@Test(priority=3,enabled= true)
	public void AddNewAllergiesTest() 
	{
		Allergies.AddnewAllergies();
		String Actial= Allergies.SaveMessageForNewPaient();
		String expected = reader.getCellData("Allergies", "Message", 2);
		
	}
	
	@Test(priority=4,enabled= true)
	public void AllergiesOnDashboardforNewPatientTest()
	{
	String Actual=	Allergies.AllergiesOnDashboardforPatient();
	
	String Expected= reader.getCellData("Allergies", "Message", 3);
	}
		

@Test(priority=5,enabled= true,dependsOnMethods= {"AllergySelectionTest"})
public void OptionSelectedOnAllergyCurrentStstusTest() 
{
	String Actual= Allergies.OptionSelectedinDrugAllergyCurrentstatus();
	String Expected = "Present";
	Assert.assertEquals(Actual, Expected);
	System.out.println("OptionSelectedOnAllergyCurrentStstusTest is completed");
}
@Test(priority=6,enabled= true)
public void ExistingPatientDrugAllergyTypeTest() 
{
		
	String Actual = Allergies.AllergiesNameOnDashboard();
			String Expected=reader.getCellData("Allergies", "Message", 4);
					 
			System.out.println();
		
}
@Test(priority=1,enabled= true)
public void AllergySelectionTest() 
{
	boolean flag1;
	 flag1 = Allergies.size();
	 boolean flag2;
	 flag2=Allergies.SavebuttonText();	 
	if(flag1==true&& flag2==true)// existing patienttrue and update button is true
	{
		String act= Allergies.AllergySelection();
		String exp = "Record updated successfully!";
		Assert.assertEquals(act, exp);
		System.out.println("AllergySelectionTest is completed");
		
	}
	else if(flag1==false&& flag2==false)// new patienttrue and Update  button is not true
	{
		String act= Allergies.AllergySelection();
		String exp = "Record saved successfully!";
				//reader.getCellData("Allergies", "Message", 2);
		Assert.assertEquals(act, exp);
		System.out.println("AllergySelectionTest is completed");
	
		
	}
	else if(flag1==false&& flag2==true)// new patient true but update button is true
	{
		String act= Allergies.AllergySelection();
		String exp = "Record updated successfully!";
		//		reader.getCellData("Allergies", "Message", 3);
		Assert.assertEquals(act, exp);
		System.out.println("AllergySelectionTest is completed");
		
		
	}
	else if(flag1== true && flag2==false)// existing patient true but update button is not true
	{
		String act= Allergies.AllergySelection();
		String exp = "Record updated successfully!";
		//reader.getCellData("Allergies", "Message", 3);
		Assert.assertEquals(act, exp);
		System.out.println("AllergySelectionTest is completed");
				
	}
	else if(flag1== true && flag2==true)// existing patient true and update button is  true
	{
		String act= Allergies.AllergySelection();
		String exp = "Record saved successfully!";
				//reader.getCellData("Allergies", "Message", 2);
		Assert.assertEquals(act, exp);
		System.out.println("AllergySelectionTest is completed");
		
	}
	
}

	@ AfterMethod
	public void Teardown()
	{
		TemporaryFilesystem tempFS = TemporaryFilesystem.getDefaultTmpFS();
		tempFS.deleteTemporaryFiles();
		
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-AllergiesTest ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
