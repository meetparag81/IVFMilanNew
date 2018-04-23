package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.FamilyHistoryPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.SexualHistoryPage;
import com_milan_POM.WomenHistoryPage;

public class WSexsualHistoryTest extends TestBase
{
	
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	FamilyHistoryPage FHP;
	SexualHistoryPage SHP;


	
	WSexsualHistoryTest()
	{
		super();
	}
		@ BeforeMethod
	public void Seup() throws Exception
	{
		TestBase.initalization();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		WHP= EMRPage.clickOnWomenField();
		SHP= WHP.ClickonSexsuslHistory(); 
	}
		
		
		
		
		
		
		
		
		
		
		@Test(priority=1, enabled = false)
		public void InrelationshipsinceYearsTest()
		{
			int Actual= SHP.relationshipyears();
			int Expected = 26;
			Assert.assertEquals(Actual, Expected, "years are not matching");
			System.out.println("InrelationshipsinceYearsTest is passed");			
		}
		@Test(priority=2,enabled = false)
		public void testRelationtlists() throws Exception
		{
			boolean flag1 = SHP.validateRelstionship();
			Assert.assertTrue(flag1);
		}
		@Test(priority=3, enabled=false)
		public void textboxSexualDysfunctionTest() throws Exception
		{
			boolean flag= SHP.textboxSexualDysfunction();
		
			Assert.assertTrue(flag);
		}
		@Test(priority=4,enabled = false)
		public void FillSexsuslHistorytest() throws Exception 
		{
			
		SHP.formfilling();
		String Actual = SHP.SexsualHistoryTitle();
		String Expected = "History";
		Assert.assertEquals(Actual, Expected);
		
		}
		@Test(priority=5,enabled = false)
		public void SexInrelationshipsinceMonthsTest() throws Exception 
		{
		SHP.formfilling();
		int Actual = SHP.relationshipmonths();
		int Expected = 11;
		
		}
		@Test(priority=6,enabled = false)
		public void numberofcharacterexualDysfunctionTest() throws Exception 
		{
		 String Actual = SHP.SexualDysfunctioncharacters();	
		 String Expected = "246";
		 Assert.assertEquals(Actual, Expected);
		}
		
		@Test(priority=7,enabled = false)
		public void DyspareuniatextTest() throws Exception 
		{
		 boolean Actual = SHP.DyspareuniaText();	
		 Assert.assertTrue(Actual);
		}
		
		@Test(priority=8,enabled = false)
		public void Lubricationusedtext() throws Exception 
		{
		 boolean Actual = SHP.Lubricationusedtext();	
		 Assert.assertTrue(Actual);
		}
		
		@Test(priority=9)
		public void Remarktexttest() throws Exception 
		{
			String Actual = SHP.Remarktext();
			String Expected = "0";
		}
		@ AfterMethod
		public void Teardown()
		{
			driver.quit();
		}
}
