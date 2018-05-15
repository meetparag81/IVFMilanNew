package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.AddictionsPage;
import com_milan_POM.SearchPage;
import com_milan_POM.WVitalsPage;

public class WAddictionsTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	AddictionsPage Addictions;
	SearchPage SearchPage;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	String Expected,Expectednew, Expectedold,Expected1;
	int count1=0;
	
	public WAddictionsTest()
	{
		super();
	}

	@BeforeMethod
public void Setup() throws Exception
{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage = HomePage.searchPaient();
		//EMRPage= HomePage.ClickonEMR();
		//EMRPage=HomePage.SearchusingCalender();
		WHP= EMRPage.clickOnWomenField();
		Addictions= WHP.ClickOnAddictions();
}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1,groups = {"smoketest" },enabled=false)
	public void CurrentStatusEnableConditionSmokeTest()
	{
		boolean flag= Addictions.CurrentStatusEnableForSmoke();
		Assert.assertTrue(flag);
	}
	@Test(priority=2,groups = {"smoketest" },enabled=false)
	public void CurrentStatusEnableConditionAlkoholTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForAlcohol();
		Assert.assertTrue(flag);
	}
	@Test(priority=3,groups = {"smoketest" },enabled=false)
	public void CurrentStatusEnableConditionTobacoTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForTobaco();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4,groups = {"smoketest" },enabled=false)
	public void CurrentStatusEnableConditionAdictionTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForDrugAdiction();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=5,groups = {"smoketest" },enabled=false)
	public void CurrentStatusEnableConditionCaffeineAddictionTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForCaffeineAddiction();
		Assert.assertTrue(flag);
	}
	@Test(priority=6,groups = {"smoketest" },enabled=false)
	public void SenceWhenEnableconditionSinceWhenYearSmokeTest()
	{
		boolean flag= Addictions.EnableConditionSinceWhenForSmoke();
		Assert.assertTrue(flag);
	}
	@Test(priority=7,groups = {"smoketest" },enabled=false)
	public void SenceWhenEnableconditionSinceWhenYearAlkoholTest()
	{
		boolean flag= Addictions.EnableConditionSinceWhenForAlkohol();
		Assert.assertTrue(flag);
	}
	@Test(priority=8,groups = {"smoketest" },enabled=false)
	public void SenceWhenEnableconditionSinceWhenYearTobacoTest()
	{
		boolean flag= Addictions.EnableConditionSinceWhenForTobaco();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=9,groups = {"smoketest" },enabled=false)
	public void SenceWhenEnableconditionSinceWhenDrugAddictionYearTest()
	{
		boolean flag= Addictions.EnableConditionForSinceWhenDrugAdiction();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=10,groups = {"smoketest" },enabled=false)
	public void SinceWhenEnableconditionSinceWhenCaffeineAddictionTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForCaffeineAddiction();
		Assert.assertTrue(flag);
	}
	@Test(priority=11,groups = {"smoketest" },enabled=false)
	public void SinceWhenEnableconditionSinceWhenMonthSmokeTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForSmoke();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=12,groups = {"smoketest" },enabled=false)
	public void SinceWhenEnableconditionSinceWhenMonthAlkoholTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForAlkohol();
		Assert.assertTrue(flag);
	}
	@Test(priority=13,groups = {"smoketest" },enabled=false)
	public void SinceWhenEnableconditionSinceWhenMonthTobocoTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForTobaco();
		Assert.assertTrue(flag);
	}
	@Test(priority=14,groups = {"smoketest" },enabled=false)
	public void SinceWhenEnableconditionSinceWhenMonthForDrugAdictionTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForDrugAdiction();
		Assert.assertTrue(flag);
	}
	@Test(priority=15,groups = {"smoketest" },enabled=false)
	public void SinceWhenEnableconditionSinceWhenMonthForCaffeineAddiction()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForCaffeineAddiction();
		Assert.assertTrue(flag);
	}
	@Test(priority=16,groups = {"smoketest" },dataProvider= "getTestData")
	public void saveAdictions(String Addiction, String CurrentStatus, String SinceWhenM, String SinceWhenY,
			String Frequency, String Quantity) throws Exception
	{
		Addictions.SaveAllAddictions(Addiction, CurrentStatus, SinceWhenM, SinceWhenY, Frequency, Quantity);
		String count= reader.getCellData("Addictions", 7, 2);
		try{
			 
			count1 = Integer.parseInt(count);
			 
		}
		catch(NumberFormatException e)
		{
			System.out.println("String is not converted into number");
		}
		finally
		{
			System.out.println("finally block executed");
		}
		if(count1 >0)
		{
			 String Expectedold = reader.getCellData("Addictions", "Message", 3);
			 Expected1 = Expectedold;			
		}
		else
		{
			
			 String Expectednew	= reader.getCellData("Addictions", "Message", 2);
			 Expected1= Expectednew;
		}
		Expected = Expected1;
		String Actual= Addictions.FlashMessage();
		 
		Assert.assertEquals(Actual, Expected);
		System.out.println("AddictionSaveTest is Passed");
	}
	@DataProvider
	public  Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]>	Addictions= AddictionsPage.getdatafromExcel();	
	return Addictions.iterator();
	}
	
	
}
