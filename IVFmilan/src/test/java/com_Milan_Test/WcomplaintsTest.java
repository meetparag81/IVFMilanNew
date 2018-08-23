package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;
import com_milan_POM.WComplaintsPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.WComplaintsPage;

public class WcomplaintsTest extends TestBase 
{	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WComplaintsPage WCP;
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	WcomplaintsTest()
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
		WCP=EMRPage.ClickOnComplaints();
	

}
	@Test(priority=1,groups = {"smoketest" },enabled= true)
	public  void NumberOfComplaintsTest() 
	{
		
		int Actual = WCP.NumberOfComplaints();
		int Expected = 38;
		Assert.assertEquals(Actual, Expected);
		System.out.println("NumberOfComplaintsTest is completed");
		
				
	}
	@Test(priority=2,groups = {"functional" },enabled= true)
	public void SaveTheComplaintsTest() 
	{
		
		 WCP.SaveTheComplaints();
		if(WCP.complaints()== true)
		{
		String Actual = WCP.MessageforPaitent();
		String expected = reader.getCellData("Complaints", "Message", 2);
		Assert.assertEquals(Actual, expected);
		System.out.println("SaveTheComplaintsTest is completed");
		}
		else
		{
			String act = WCP.MessageforPaitent();
			String expected = reader.getCellData("Complaints", "Message", 3);
			Assert.assertEquals(act, expected);
			System.out.println("SaveTheComplaintsTest is completed");
		}
	}
	@Test(priority=3,groups = {"smoketest" })
	public void NextFollowUpTest() 
	{
		System.out.println();
	boolean flag=WCP.NextFollowUp();
	
	Assert.assertTrue(flag);
	System.out.println("Can't select past date");
		
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
			System.out.println("UnreachableBrowserException is seen at-ComplaintsTest ");
		}
	}
	
}
