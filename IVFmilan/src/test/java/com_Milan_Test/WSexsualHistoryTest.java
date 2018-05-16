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
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		//EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		EMRPage = HomePage.searchPaient();
		WHP= EMRPage.clickOnWomenField();
		SHP= WHP.ClickonSexsuslHistory(); 
	}
		
		
		
		
		
		
		
		
		
		
		@Test(priority=1,enabled=true)
		public void InrelationshipsinceYearsTest()
		{
			int Actual= SHP.relationshipyears();
			int Expected = 26;
			AssertJUnit.assertEquals(Expected, Actual);
			System.out.println("InrelationshipsinceYearsTest is passed");			
		}
		@Test(priority=2,enabled=true)
		public void testRelationtlists() throws Exception
		{
			boolean flag1 = SHP.validateRelstionship();
			AssertJUnit.assertTrue(flag1);
		}
		@Test(priority=3,enabled=true)
		public void textboxSexualDysfunctionTest() throws Exception
		{
			boolean flag= SHP.textboxSexualDysfunction();
		
			AssertJUnit.assertTrue(flag);
		}
		@Test(priority=4,enabled=true)
		public void FillSexsuslHistorytest() throws Exception 
		{
			
		SHP.formfilling();
		String Actual = SHP.SexsualHistoryTitle();
		String Expected = "History";
		Assert.assertEquals(Actual, Expected);
		
		}
		@Test(priority=5,enabled=true)
		public void SexInrelationshipsinceMonthsTest() throws Exception 
		{
		SHP.formfilling();
		int Actual = SHP.relationshipmonths();
		int Expected = 11;
		
		}
		@Test(priority=6,enabled=true)
		public void numberofcharacterexualDysfunctionTest() throws Exception 
		{
		 String Actual = SHP.SexualDysfunctioncharacters();	
		 String Expected = "246";
		 Assert.assertEquals(Actual, Expected);
		}
		
		@Test(priority=7,enabled=true)
		public void DyspareuniatextTest() throws Exception 
		{
		 boolean Actual = SHP.DyspareuniaText();	
		 Assert.assertTrue(Actual);
		}
		
		@Test(priority=8,enabled=true)
		public void Lubricationusedtext() throws Exception 
		{
		 boolean Actual = SHP.Lubricationusedtext();	
		 Assert.assertTrue(Actual);
		}
		
		@Test(priority=9,enabled=true)
		public void Remarktexttest() throws Exception 
		{
			String Actual = SHP.Remarktext();
			String Expected = "0";
		}
		@Test(priority=10,enabled=true)
		public void TryingToConcieveSinceYearTest()
		{
			
			double Actual = SHP.TryingToConcieveSinceYear();
			double Expected = 12.0;
			
		}
		@Test(priority=11,enabled=true)
		public void TryingToConcieveSinceMonthTest()
		{
			
			double Actual = SHP.TryingToConcieveSinceMonth();
			double Expected = 5.0;
			
		}
		
		@ AfterMethod
		public void Teardown()
		{
			driver.quit();
		}
}
