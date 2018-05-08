package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.WComplaintsPage;
import com_milan_POM.WVitalsPage;

public class WVitalsTest extends TestBase 
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WVitalsPage WVP;
	

	WVitalsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		TestBase.initalization();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		//EMRPage=HomePage.searchPaient();
		WVP=EMRPage.ClickOnVitals();
		
	}
	
	@Test(priority=1)
	public void HRValueTest()
	{
		WVP.HRValue();	
	}
	
	

}
