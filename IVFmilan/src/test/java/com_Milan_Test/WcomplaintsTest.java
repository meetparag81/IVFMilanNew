package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
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
	WcomplaintsTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup() throws Exception
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		//EMRPage=HomePage.searchPaient();
		WCP=EMRPage.ClickOnComplaints();
	
	
	
	
	
	
	
	
	
	
	
	

}
	@Test(priority=1,enabled= true)
	public  void NewPatientPresentingComplaintsTest() throws Exception 
	{
		
		int Actual = WCP.NewPatientPresentingComplaints();
		int Expected = 4;
		Assert.assertEquals(Actual, Expected);
		System.out.println("NewPatientPresentingComplaintsTest is passed");
		
				
	}
	@Test(priority=2,enabled= true)
	public void SaveTheComplaintsTest() throws Exception
	{
		WCP.NewPatientPresentingComplaints();
		String Actual= WCP.SaveTheComplaints();
		String expected = "Modality is mandatory field";
		Assert.assertEquals(Actual, expected);
	}
	@Test(priority=3)
	public void NextFollowUpTest() throws Exception
	{
	boolean flag=WCP.NextFollowUp();
	
	Assert.assertFalse(flag);
	System.out.println("Can't select past date");
		
	}
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
}
