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
import com_Milan_Excelutility.Exls_Reader;
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
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	WObstetricHistoryPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.searchPaient();
		WHP= EMRPage.clickOnWomenField();
		OHP= WHP.ClickonObstetricHistory(); 
		
		
	}
		
	@Test(priority=1,enabled=true)
	public void BirthWeightValueTextTest()
	{
		double Actual=OHP.BirthWeightText();
		double Expected = 1.0;
		Assert.assertEquals(Actual, Expected, Actual);
	}
	@Test(priority=2,enabled=true)
	public void BirthWeightEnableConditionTest()
	{
		boolean flag1=OHP.BirthWeightEnabled();
		Assert.assertTrue(flag1);
	}
	
	@Test(priority=3,enabled=false)
	public void ValueInAbortiontionTest() 
	{
	
		String Actual= OHP.AbortionOptionValue();
		String Expected = reader.getCellData("ObstetricHistory", "count", 2);
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=4,enabled=false)
	public void ValueInLivebirthoptionTest() 
	{
	
		String Actual= OHP.OutcomeIsLiveBirth();
		String Expected = reader.getCellData("ObstetricHistory", "count", 4);
		Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=5,enabled=false)
	public void ValueInEctopicTest() 
	{
	
		String Actual= OHP.EctopicOptionValue();
		String Expected = reader.getCellData("ObstetricHistory", "count", 3);
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority=6,enabled=true)
	public void DeliveryTypeEnableconditionTest() 
	{
		boolean flag= OHP.DileveryTypeEnabledcondition();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=7,enabled=true)	
	public void LiveBirthEnableTest()
	{
	boolean flag=OHP.LivebirthEnableConditition();
	Assert.assertFalse(flag);
	}
	@Test(priority=8,enabled=true)	
	public void RowGridEnableTest()
	{
	boolean flag=OHP.RowGridEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=9,enabled=true)	
	public void StillBornEnableTest()
	{
	boolean flag=OHP.StillbornGridEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=10,enabled=true)	
	public void EctopiccEnableCondititionTest()
	{
	boolean flag=OHP.EctopiccEnableConditition();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=11,enabled=true)	
	public void AbortionEnableCondititionTest()
	{
	boolean flag=OHP.AbortionEnableConditition();
	Assert.assertFalse(flag);
	}
	@Test(priority=12,enabled=true)	
	public void DeliveryEnableCondititionTest()
	{
	boolean flag=OHP.DeliveroptionEnableConditition();
	Assert.assertTrue(flag);
	}
	@Test(priority=13,enabled=true)	
	public void ComplicationsEnableCondititionTest()
	{
	boolean flag=OHP.ComplicationsEnableConditition();
	Assert.assertTrue(flag);
	}
	@Test(priority=14,enabled=true)	
	public void CongenitalAnamolyEnableCondititionTest()
	{
	boolean flag=OHP.CongenitalAnamolyEnableCondition();
			Assert.assertTrue(flag);
	}
	@Test(priority=15,enabled=true)	
	public void LiveBirthPretermconditionTest()
	{
	String Actual=OHP.LiveBirthPretermcondition();
	String Expected = "Preterm";
	Assert.assertEquals(Actual, Expected);
	}
	@Test(priority=16,enabled=true)
	public void LiveBirthFullTermconditionTest()
	{
		
	String Actual =OHP.LiveBirthFullTermcondition();
	String Expected ="Full Term";
	Assert.assertEquals(Actual, Expected);
		
	}
	@Test(priority=17,enabled=true)
	public void LiveBirthAbovePostTermconditionTest()
	{
	String Actual =OHP.LiveBirthAbovePostTermcondition();
	String Expected ="Post Term";
	Assert.assertEquals(Actual, Expected);
		
	}
	@Test(priority=18)
	public void SaveOutcometypesTest() 
	{
		boolean flag1= OHP.ButtonText();
		boolean flag2=OHP.NoOfRows();
		if(flag1==true&&flag2==false)//Save button and New patient
		{
			String Act = OHP.SaveObstetricHistory();
			String Exp= "Record saved successfully!";
			Assert.assertEquals(Act, Exp);
			System.out.println("SaveOutcometypesTest is completed");
		}
		else if(flag1==false&&flag2==true)//update button and existingpatient
		{
			String Act = OHP.SaveObstetricHistory();
			String Exp= "Record updated successfully!";
			Assert.assertEquals(Act, Exp);
			System.out.println("SaveOutcometypesTest is completed");
		}
		else if(flag1==true&&flag2==true)//Save button and Existing Patient
		{
			
			String Act = OHP.SaveObstetricHistory();
			String Exp= "Record updated successfully!";
			Assert.assertEquals(Act, Exp);
			System.out.println("SaveOutcometypesTest is completed");
			
		}
		else if (flag1==false&&flag2==false)//UpdateButton and NewPatient
		{
			
			String Act = OHP.SaveObstetricHistory();
			String Exp= "Record saved successfully!";
			Assert.assertEquals(Act, Exp);
			System.out.println("SaveOutcometypesTest is completed");
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
			System.out.println("UnreachableBrowserException is seen at-ObsetricHistoryPageTest ");
		}
	}
	

}
