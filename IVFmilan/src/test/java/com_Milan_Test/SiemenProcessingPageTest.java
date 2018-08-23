package com_Milan_Test;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.MenHistoryPage;
import com_milan_POM.SearchPage;
import com_milan_POM.SiemenProcessingPage;
import com_milan_POM.WomenHistoryPage;

public class SiemenProcessingPageTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	MenHistoryPage MHP;
	SearchPage SearchPage;
	SiemenProcessingPage SiemensProcessing;
	
	SiemenProcessingPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup()
	{
		TestBase.initalization();
		Loginpage = new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		SiemensProcessing=EMRPage.ClickOnSiemenProcessing();
				
	}
	@Test(priority=1)
	public void PreparationAssessmentTest() 
	{
		SiemensProcessing.ClickOnPreliminaryDetails();
	}
	@Test(priority=2)
	public void SiemensProcessingTesting() 
	{
		SiemensProcessing.ClickOnSemenPreparationDetails();
	}
	
	
	
	
	
	@ AfterMethod
	public void teardown()
	{
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-SiemenProcessingTest ");
		}
	}

}
