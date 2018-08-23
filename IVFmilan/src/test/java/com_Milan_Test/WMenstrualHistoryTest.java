package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.MenstrualHistoryPage;
import com_milan_POM.WomenHistoryPage;

public class WMenstrualHistoryTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	MenstrualHistoryPage MHP;

	
		
	public WMenstrualHistoryTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage=HomePage.searchPaient();
		WHP= EMRPage.clickOnWomenField();
		MHP=WHP.ClickOnMenstrualHistory();
	}
	@Test(priority=1, enabled=true)
	public  void AgeOfMenarcheRangeSartTest() 
	{
		String Actual= MHP.AgeOfMenarcheFirst();
		String Expected= "8";
		Assert.assertEquals(Actual, Expected, "First range value is incorrect");
		System.out.println("AgeOfMenarcheFirst completed");
				
	}
	
	@Test(priority=2,enabled=true)
	public  void MenarcheRangeEndTest() 
	{
		
		String Actual= MHP.AgeOfMenarcheLast();
		String Expected= "18";
		Assert.assertEquals(Actual, Expected, "Last range value is incorrect");
		System.out.println("MenarcheRangeEndTest completed");
	}
	@Test(priority=3,enabled=true)
	public  void LMPcalenderdateSelectionTest() 
	{
		boolean flag1=MHP.DatePicker();
		
		Assert.assertTrue(flag1);
		System.out.println("LMPcalenderdateSelectionTest completed");
	}
	
	
	@Test(priority=4,enabled=true)
	public  void AmenorrheaTypeTest() 
	{
		boolean flag2=MHP.AmenorrheaType();
		
		Assert.assertEquals(false, flag2);
		System.out.println("AmenorrheaTypeTest completed");
	}
	@Test(priority=5,enabled=true)
	public void SavevaluesTest()
	{
		MHP.SaveValuesInDurations();
	}
	
	@Test(priority=6,enabled=true)
	public  void CycleDurationTest() 
	{
		String Actual = MHP.GetCycleDurationvalue();
		String Expected= "20";
		Assert.assertEquals(Actual, Expected);
		System.out.println("CycleDurationTest completed");
	}
	@Test(priority=7,enabled=true)
	public  void MenstruationTest1() 
	{
		String Actual = MHP.GetMenstruationvalue();
		String  Expected= "10";
		Assert.assertEquals(Actual, Expected);
		System.out.println("CycleDurationTest completed");
	}
	
	@Test (priority=8,enabled=true)
	public void MenstrualFlowtextTest()
	{
		Boolean flag=MHP.MenstrualFlowText();
		Assert.assertTrue(flag);
		System.out.println("MenstrualFlowTesttest is passed");
	}
	
	@Test (priority=9,enabled=true)
	public void MenstrualFlowTextTest()
	{
		Boolean flag=MHP.MenstrualFlowText();
		Assert.assertTrue(flag);
		System.out.println("MenstrualFlowTesttest is passed");
	}
	
	@Test (priority=10,enabled= true)
	public void SaveWMenstrualHistoryTest()
	{
		boolean flag= MHP.SaveButton();
		if(flag==false)
		{
		String act= MHP.SaveTheForm();
		String exp = "Record updated successfully!";
		Assert.assertEquals(act, exp);
		System.out.println("SaveThe SaveWMenstrualHistoryTest is completed");
			
			
			
		}
		else
		{
			String act= MHP.SaveTheForm();
			String exp = "Record saved successfully!";
			Assert.assertEquals(act, exp);
			System.out.println("SaveThe SaveWMenstrualHistoryTest is completed"); 
		}
	 
		
	}
	
	
		
	
	@AfterMethod
	public void Teardown()
	{
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-MenstructrualHistoryPageTest ");
		}
	}
	
		
}
	
	
	

