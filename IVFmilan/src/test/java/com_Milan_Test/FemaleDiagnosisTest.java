package com_Milan_Test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com_Milan_Base.TestBase;
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
	
	
	
	
	public FemaleDiagnosisTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		//EMRPage=HomePage.searchPaient();
		FDP=EMRPage.ClickOnDiagnosis();
				
	}
	
	@Test(priority=1)
	public void ClickOnOtherDiagnosisTest() throws Exception
	{
		FDP.ClickOnOtherDiagbosisForNewPaitent();
		String Actual = FDP.CodeUpdatedMessage();
		SoftAssert softAssertion= new SoftAssert();
		System.out.println(Actual);
		String Expected = "Palash IVF"
		+ "Record saved successfully!";
		softAssertion.assertEquals(Actual, Expected, "Message doesn't matched");
		softAssertion.assertAll();
		
	}
	
	@Test(priority=2)
	public void CodevalueTest()
	{
		String Actual= FDP.Codevalue();
		String Expeted = "delete1289";
		Assert.assertEquals(Actual, Expeted,"Codevalue doesn't matched");
	}
	@Test(priority=3)
	public void AddFavoriteFromListTest() throws Exception
	{
		
		String Actual= FDP.ClickonFavoriteIcon();
		String Expected = "Diagnosis is added in the Favourite List";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Favorite is added in List");
		
	}	
	@Test(priority=4)
	public void UnFavoriteTheFavioriteTest() throws Exception
	{
		String Actual= FDP.UnFavoriteTheFaviorite();
		String Expected= "Diagnosis is removed from the Favourite List";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Favorite is removed from List");
		
	}
	
	
	
	@Test(priority=5,enabled=false)
	public void TypeSelectionboxEnableconditionForOtherfavorireTest()
	{
		boolean flag= FDP.TypeSelectionboxEnablecondition();
		assertTrue(flag);
	}
	@Test(priority=6,enabled=false)
	public void DeleteFromFavoriteTest() throws Exception
	{
	String Actual=	FDP.DeleteFromFavorite();
	System.out.println(Actual);
	String Expected = "Favourite Diagnosis Deleted Successfuly";
	System.out.println("Favorite is deleted from favorite section");
	}
	@Test(priority=7,enabled=true)
	public void checkboxclickTest() throws Exception
	{
	boolean flag=	FDP.checkboxclick();
	
	Assert.assertTrue(flag);
	System.out.println("All options under Type are enabled");
	
	
	}
				
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
