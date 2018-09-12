package com_Milan_Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
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
	Exls_Reader reader;
	float BPvalues1;
	
	

	WVitalsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		//EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		EMRPage=HomePage.searchPaient();
		WVP=EMRPage.ClickOnVitals();
		
	}
	
	/*@Test(priority=1)
	public void HRValueTest()
	{
		WVP.HRValue();	
	}*/
	
	@Test(priority=1,groups = {"Boundryvalue" },dataProvider= "getTestData")
	public void BPSystolicBundryValueTest(String Weight,String Height,String BPSystolicval,String BPDiastolic,String HR,String Temperature)
	{
		boolean message = true;
	/*driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(value);
	String BPvalues= driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value");*/
	 String BPvalues=WVP.BPSystolic(BPSystolicval);
	 try
	 {
	 BPvalues1= Float.parseFloat(BPvalues);
	 }
	 catch(NumberFormatException e)
	 {
		 System.out.println("String is not converted intofloat");
	 }
	 
	System.out.println("Values are"+BPvalues1);
	if(BPvalues1==90.0 || BPvalues1==120.0||BPvalues1==100)
	{
		/*String colour=BPSystolic.getCssValue("colour");
		String stringcolour= colour;
		System.out.println(stringcolour);*/
		System.out.println("start the test");
		message = true;
		
	}
	else
	{
		message = false;
	}
	Assert.assertTrue(message);
	System.out.println("value is in range");
	}
	
	@Test(priority=2,groups = {"smoketest" },dataProvider= "getTestData")
	public void SaveAllVitalsValuesTest(String Weight,String Height,String BPSystolicval,String BPDiastolic,String HR,String Temperature) 
	{
		String Actual = WVP.SaveAllvalues(Weight, Height, BPSystolicval, BPDiastolic, HR, Temperature);
		
	}
	@Test(priority=1,groups = {"smoketest" },dataProvider= "getTestData", enabled = true)
	public void BMITest(String Weight,String Height,String BPSystolicval,String BPDiastolic,String HR,String Temperature) 
	{
		System.out.println("started");
		Float Actual =WVP.BMIvalue(Weight, Height);
		Double Expected = WVP.ExpectedResult();
		Assert.assertEquals(Actual, Expected, Expected);		
	}
	
	@DataProvider
	public  Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]>	BPSystolic= WVitalsPage.getdatafromExcel();	
	return BPSystolic.iterator();
	}
	
	@AfterMethod
	public void TearDown()
	{
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-WViatalsSexsualHistoryPageTest");
		}
	}
	
	
	

}
