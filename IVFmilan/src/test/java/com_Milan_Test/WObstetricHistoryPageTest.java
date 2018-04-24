package com_Milan_Test;

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
		EMRPage= HomePage.ClickonEMR();
		WHP= EMRPage.clickOnWomenField();
		OHP= WHP.ClickonObstetricHistory(); 
		//EMRPage= HomePage.searchPaient();
		
	}
		
	@Test(priority=1)
	public void BirthWeightValueTextTest()
	{
		double Actual=OHP.BirthWeightText();
		double Expected = 1.234;
		Assert.assertEquals(Actual, Expected, Actual);
	}
	@Test(priority=2)
	public void BirthWeightEnableConditionTest()
	{
		boolean flag1=OHP.BirthWeightEnabled();
		Assert.assertTrue(flag1);
	}
	
	@Test(priority=4)
	public void ValueInAbortiontionTest() 
	{
	
		String Actual= OHP.AbortionOptionValue();
		String Expected = "1";
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=5,enabled=false)
	public void ValueInLivebirthoptionTest() 
	{
	
		String Actual= OHP.OutcomeIsLiveBirth();
		String Expected = "1";
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=6)
	public void ValueInEctopicTest() 
	{
	
		String Actual= OHP.EctopicOptionValue();
		String Expected = "1";
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority=7)
	public void DeliveryTypeEnableconditionTest() 
	{
		boolean flag= OHP.DileveryTypeEnabledcondition();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=8)	
	public void LiveBirthEnableTest()
	{
	boolean flag=OHP.LivebirthEnableConditition();
	Assert.assertFalse(flag);
	}
	@Test(priority=9)	
	public void RowGridEnableTest()
	{
	boolean flag=OHP.RowGridEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=10)	
	public void StillBornEnableTest()
	{
	boolean flag=OHP.StillbornGridEnableConditition();
			Assert.assertFalse(flag);
	}
	
	@Test(priority=11)	
	public void EctopiccEnableCondititionTest()
	{
	boolean flag=OHP.EctopiccEnableConditition();
			Assert.assertFalse(flag);
	}
	
	@Test(priority=12)	
	public void AbortionEnableCondititionTest()
	{
	boolean flag=OHP.AbortionEnableConditition();
			Assert.assertFalse(flag);
	}
	@Test(priority=13)	
	public void DeliveryEnableCondititionTest()
	{
	boolean flag=OHP.DeliveroptionEnableConditition();
			Assert.assertTrue(flag);
	}
	@Test(priority=13)	
	public void ComplicationsEnableCondititionTest()
	{
	boolean flag=OHP.ComplicationsEnableConditition();
			Assert.assertTrue(flag);
	}
	@Test(priority=14)	
	public void CongenitalAnamolyEnableCondititionTest()
	{
	boolean flag=OHP.CongenitalAnamolyEnableCondition();
			Assert.assertTrue(flag);
	}
	@Test(priority=15)	
	public void LiveBirthPretermconditionTest()
	{
	String Actual=OHP.LiveBirthPretermcondition();
	String Expected = "Preterm";
			Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=16)
	public void LiveBirthFullTermconditionTest()
	{
		
	String Actual =OHP.LiveBirthFullTermcondition();
	String Expected ="Full Term";
	Assert.assertEquals(Actual, Expected);
		
	}
	@Test(priority=17)
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
