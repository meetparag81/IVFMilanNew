package com_Milan_Test;

import java.util.concurrent.TimeUnit;

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
	public void Setup() throws Exception
	{
		TestBase.initalization();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage=HomePage.SearchusingCalender();
		//EMRPage= HomePage.ClickonEMR();
		WHP= EMRPage.clickOnWomenField();
		MHP=WHP.ClickOnMenstrualHistory();
	}
	@Test(priority=1, enabled=false)
	public  void AgeOfMenarcheRangeSartTest() 
	{
		String Actual= MHP.AgeOfMenarcheFirst();
		String Expected= "8";
		Assert.assertEquals(Actual, Expected, "First range value is incorrect");
		System.out.println("AgeOfMenarcheFirst completed");
				
	}
	
	@Test(priority=2,enabled=false)
	public  void MenarcheRangeEndTest() 
	{
		
		String Actual= MHP.AgeOfMenarcheLast();
		String Expected= "18";
		Assert.assertEquals(Actual, Expected, "Last range value is incorrect");
		System.out.println("MenarcheRangeEndTest completed");
	}
	@Test(priority=3,enabled=false)
	public  void LMPcalenderdateSelectionTest() 
	{
		boolean flag1=MHP.DatePicker();
		
		Assert.assertEquals(false, flag1);
		System.out.println("LMPcalenderdateSelectionTest completed");
	}
	
	
	@Test(priority=4,enabled=false)
	public  void AmenorrheaTypeTest() 
	{
		boolean flag2=MHP.AmenorrheaType();
		
		Assert.assertEquals(false, flag2);
		System.out.println("AmenorrheaTypeTest completed");
	}
	@Test(priority=6)
	public void SavevaluesTest()
	{
		MHP.Savevaluesindurations();
	}
	
	@Test(priority=5)
	public  void CycleDurationTest() throws Exception 
	{
		String Actual = MHP.GetCycleDurationvalue();
		String Expected= "20";
		Assert.assertEquals(Actual, Expected);
		System.out.println("CycleDurationTest completed");
	}
	@Test(priority=7)
	public  void MenstruationTest1() throws Exception 
	{
		String Actual = MHP.GetMenstruationvalue();
		String  Expected= "10";
		Assert.assertEquals(Actual, Expected);
		System.out.println("CycleDurationTest completed");
	}
	
	@Test (priority=8)
	public void MenstrualFlowtextTest()
	{
		Boolean flag=MHP.MenstrualFlowText();
		Assert.assertTrue(flag);
		System.out.println("MenstrualFlowTesttest is passed");
	}
	
		
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
		
}
	
	
	

