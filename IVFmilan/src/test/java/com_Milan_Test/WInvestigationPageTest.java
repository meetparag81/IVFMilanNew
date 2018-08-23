package com_Milan_Test;

import java.util.ArrayList;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.AddictionsPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.SearchPage;
import com_milan_POM.WInvestigationPage;
import com_milan_POM.WOPUCycyclePage;
import com_milan_POM.WomenHistoryPage;

public class WInvestigationPageTest extends TestBase 
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	AddictionsPage Addictions;
	SearchPage SearchPage;
	WInvestigationPage Investigation;
	WOPUCycyclePage WOC;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	int exp, Expected;

	public WInvestigationPageTest() 
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
		// EMRPage= HomePage.ClickonEMR();
		// EMRPage=HomePage.SearchusingCalender();
		Investigation = EMRPage.ClickOnInvestigation();
		Investigation.ClickOnProcedures();
		
		
	}
	
	//@Test(priority=1)
	
	
	//@Test(priority=2)
	public void DeleteFavoriteTest()
	{
		
		boolean flag = Investigation.ExisingProcedure();
		if(flag== true)
		{
		String act = Investigation.DeleteProcedure();
		String exp = reader.getCellData("InvestigationList", "Result", 6);
		Assert.assertEquals(act, exp);
		System.out.println("DeleteFavoriteTest is completed");
		}
		else
		{
			String act = Investigation.DeleteProcedure();
			String exp = reader.getCellData("InvestigationList", "Result", 5);
			Assert.assertEquals(act, exp);
			System.out.println("DeleteFavoriteTest is completed");
			
			
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
			System.out.println("UnreachableBrowserException is seen at-InvestigationPageTest ");
		}
	}
	
	
	
	
	
	
}
