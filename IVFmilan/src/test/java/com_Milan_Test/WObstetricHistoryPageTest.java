package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.ObstetricHistoryPage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;

public class WObstetricHistoryPageTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	ObstetricHistoryPage OHP;
	
	WObstetricHistoryPageTest()
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
		//EMRPage= HomePage.ClickonEMR();
		EMRPage= HomePage.searchPaient();
		WHP= EMRPage.clickOnWomenField();
		OHP= WHP.ClickonObstetricHistory(); 
		
		
	}
		
	@Test(priority=1,enabled=false)
	public void BirthWeightValueTextTest()
	{
		double Actual=OHP.BirthWeightText();
		double Expected = 1.234;
		Assert.assertEquals(Actual, Expected, Actual);
	}
	@Test(priority=2,enabled=false)
	public void BirthWeightEnableConditionTest()
	{
		boolean flag1=OHP.BirthWeightEnabled();
		Assert.assertTrue(flag1);
	}
	
	@Test(priority=3,enabled=false)
	public void ValueInAbortiontionTest() 
	{
	
		String Actual= OHP.AbortionOptionValue();
		String Expected = "1";
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=4,enabled=false)
	public void ValueInLivebirthoptionTest() 
	{
	
		String Actual= OHP.OutcomeIsLiveBirth();
		String Expected = "1";
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=5,enabled=false)
	public void ValueInEctopicTest() 
	{
	
		String Actual= OHP.EctopicOptionValue();
		String Expected = "1";
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority=6,enabled=false)
	public void DeliveryTypeEnableconditionTest() 
	{
		boolean flag= OHP.DileveryTypeEnabledcondition();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=7,enabled=false)	
	public void LiveBirthEnableTest()
	{
	boolean flag=OHP.LivebirthEnableConditition();
	Assert.assertFalse(flag);
	}
	@Test(priority=8,enabled=false)	
	public void RowGridEnableTest()
	{
	boolean flag=OHP.RowGridEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=9,enabled=false)	
	public void StillBornEnableTest()
	{
	boolean flag=OHP.StillbornGridEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=10,enabled=false)	
	public void EctopiccEnableCondititionTest()
	{
	boolean flag=OHP.EctopiccEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=11,enabled=false)	
	public void AbortionEnableCondititionTest()
	{
	boolean flag=OHP.AbortionEnableConditition();
	Assert.assertFalse(flag);
	}
	@Test(priority=12,enabled=false)	
	public void DeliveryEnableCondititionTest()
	{
	boolean flag=OHP.DeliveroptionEnableConditition();
	Assert.assertTrue(flag);
	}
	@Test(priority=13,enabled=false)	
	public void ComplicationsEnableCondititionTest()
	{
	boolean flag=OHP.ComplicationsEnableConditition();
	Assert.assertTrue(flag);
	}
	@Test(priority=14,enabled=false)	
	public void CongenitalAnamolyEnableCondititionTest()
	{
	boolean flag=OHP.CongenitalAnamolyEnableCondition();
			Assert.assertTrue(flag);
	}
	@Test(priority=15,enabled=false)	
	public void LiveBirthPretermconditionTest()
	{
	String Actual=OHP.LiveBirthPretermcondition();
	String Expected = "Preterm";
	Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=16,enabled=false)
	public void LiveBirthFullTermconditionTest()
	{
		
	String Actual =OHP.LiveBirthFullTermcondition();
	String Expected ="Full Term";
	Assert.assertEquals(Actual, Expected);
		
	}
	@Test(priority=17,enabled=false)
	public void LiveBirthAbovePostTermconditionTest()
	{
	String Actual =OHP.LiveBirthAbovePostTermcondition();
	String Expected ="Post Term";
	Assert.assertEquals(Actual, Expected);
		
	}
	@Test(priority=18)
	public void SaveOutcometypesTest() throws InterruptedException
	{
	int numberofRows=OHP.SaveOutcometypes();
	int ExpectedRows= 5;
	}
	
	
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	

}
