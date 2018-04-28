package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.Loginpage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.FemaleDiagnosisPage;
import com_milan_POM.HomePage;

public class FemaleDiagnosisTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	FemaleDiagnosisPage FDP;
	
	
	
	
	public FemaleDiagnosisTest()
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
		EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		FDP=EMRPage.ClickOnDiagnosis();
				
	}
	
	@Test(priority=1)
	public void ClickOnOtherDiagnosisTest() throws Exception
	{
		FDP.ClickOnOtherDiagnosis();	
	}
	
	@Test(priority=2)
	public void CodevalueTest()
	{
		String Actual= FDP.Codevalue();
		String Expeted = "004";
		Assert.assertEquals(Actual, Expeted);
	}
	
	
	
	
	
	
	
	

}
