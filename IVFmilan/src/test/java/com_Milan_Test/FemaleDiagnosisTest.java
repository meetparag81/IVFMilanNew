package com_Milan_Test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.FemaleDiagnosisPage;
import com_milan_POM.HomePage;

public class FemaleDiagnosisTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	FemaleDiagnosisPage FDP;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	
	
	public FemaleDiagnosisTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		//EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		EMRPage=HomePage.searchPaient();
		FDP=EMRPage.ClickOnDiagnosis();
				
	}
	
	@Test(priority=1,enabled=true)
	public void ClickOnOtherDiagnosisTest() 
	{
		FDP.ClickOnOtherDiagbosisForNewPaitent();
		String Actual = FDP.CodeUpdatedMessage();
		SoftAssert softAssertion= new SoftAssert();
		/*System.out.println(Actual);
		String Expected = reader.getCellData("Diagnosis", "Expected Result", 3);
		softAssertion.assertEquals(Actual, Expected, "Message doesn't matched");
		softAssertion.assertAll();
		*/
	}
	
	@Test(priority=2,enabled=true)
	public void CodevalueTest()
	{
		/*String Actual= FDP.AddCodevalue();
		String Expeted = reader.getCellData("Diagnosis", "Codevalue", 2);
		Assert.assertEquals(Actual, Expeted,"Codevalue doesn't matched");*/
	}
	@Test(priority=3,enabled=true)
	public void AddFavoriteFromListTest() 
	{
		
		String Actual= FDP.ClickonFavoriteIcon();
		String Expected = "Diagnosis is added in the Favourite List";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Favorite is added in List");
		
	}	
	@Test(priority=4,enabled=true)
	public void UnFavoriteTheFavioriteTest() 
	{
		String Actual= FDP.UnFavoriteTheFaviorite();
		String Expected= "Diagnosis is removed from the Favourite List";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Favorite is removed from List");
		
	}
	
	
	
	@Test(priority=5,groups = {"smoketest" },enabled=true)
	public void TypeSelectionboxEnableconditionForOtherfavorireTest()
	{
		boolean flag= FDP.TypeSelectionboxEnablecondition();
		assertTrue(flag);
	}
	@Test(priority=6,groups = {"smoketest" },enabled=false)
	public void DeleteFromFavoriteTest() 
	{
		
	String Actual=	FDP.DeleteFromFavorite();// need to verify
	System.out.println(Actual);
	String Expected = reader.getCellData("Diagnosis", "Expected Result", 2);
	System.out.println("Favorite is deleted from favorite section");
	}
	@Test(priority=7,groups = {"smoketest" },enabled=true)
	public void checkboxclickTest() 
	{
	boolean flag=	FDP.checkboxclick();
	
	Assert.assertTrue(flag);
	System.out.println("All options under Type are enabled");
	
	
	}
				
	
	@AfterMethod
	public void TearDown()
	{
		
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-FemaleDiagnosisTest ");
		}
	}
	
	
	
	
	
	

}
