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
import com_milan_POM.SearchPage;

public class SearchPageTest extends TestBase
{
	Loginpage Loginpage;	
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	SearchPage SearchPage;
	

	 public SearchPageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		 SearchPage = new SearchPage();	 
	}
	
	
		@Test(priority=1)
		private void SearchPatientUsingCalenderTest() 
		{
			SearchPage.SearchusingCalender();
			
			String Actual=	SearchPage.QueueManagementpage();
			
			String Expectted = "EMR Dashboard";
			Assert.assertEquals(Actual, Expectted);
			System.out.println("SearchPatientUsingCalenderTest is completed");
			
		}
		@Test(priority=2)
		private void SearchPatientUsingPatientTabTest() 
		{
			SearchPage.searchPaient();
			String Actual=	SearchPage.Dahboardtitle();
			String Expectted = "EMR Dashboard";
			Assert.assertEquals(Actual, Expectted);
			System.out.println("SearchPatientUsingPatientTabTest is completed");
			
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
			System.out.println("UnreachableBrowserException is seen at-SearchPageTest ");
		}
	}
	
	
	
	
	

}
