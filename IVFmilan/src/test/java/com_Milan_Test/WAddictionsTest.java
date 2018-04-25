package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.AddictionsPage;
import com_milan_POM.SearchPage;

public class WAddictionsTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	AddictionsPage Addictions;
	SearchPage SearchPage;
	
	
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
		//EMRPage=HomePage.SearchusingCalender();
		EMRPage= HomePage.ClickonEMR();
		//SearchPage= new SearchPage();
		//EMRPage = SearchPage.searchPaient();
		WHP= EMRPage.clickOnWomenField();
		Addictions= WHP.ClickOnAddictions();
}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1,enabled= false)
	public void CurrentStatusEnableConditionSmokeTest()
	{
		boolean flag= Addictions.CurrentStatusEnableForSmoke();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=2,enabled= false)
	public void CurrentStatusEnableConditionAlkoholTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForAlcohol();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=3,enabled= false)
	public void CurrentStatusEnableConditionTobacoTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForTobaco();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority=4,enabled= false)
	public void CurrentStatusEnableConditionAdictionTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForDrugAdiction();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority=5,enabled= false)
	public void CurrentStatusEnableConditionCaffeineAddictionTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForCaffeineAddiction();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=6,enabled= false)
	public void SenceWhenEnableconditionSinceWhenYearSmokeTest()
	{
		boolean flag= Addictions.EnableConditionSinceWhenForSmoke();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=7,enabled= false)
	public void SenceWhenEnableconditionSinceWhenYearAlkoholTest()
	{
		boolean flag= Addictions.EnableConditionSinceWhenForAlkohol();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=8,enabled= false)
	public void SenceWhenEnableconditionSinceWhenYearTobacoTest()
	{
		boolean flag= Addictions.EnableConditionSinceWhenForTobaco();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority=9,enabled= false)
	public void SenceWhenEnableconditionSinceWhenDrugAddictionYearTest()
	{
		boolean flag= Addictions.EnableConditionForSinceWhenDrugAdiction();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority=10,enabled= false)
	public void SinceWhenEnableconditionSinceWhenCaffeineAddictionTest()
	{
		boolean flag= Addictions.CurrentStatusEnableConditionForCaffeineAddiction();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=11)
	public void SinceWhenEnableconditionSinceWhenMonthSmokeTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForSmoke();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=12)
	public void SinceWhenEnableconditionSinceWhenMonthAlkoholTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForAlkohol();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=13)
	public void SinceWhenEnableconditionSinceWhenMonthTobocoTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForTobaco();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=14)
	public void SinceWhenEnableconditionSinceWhenMonthForDrugAdictionTest()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForDrugAdiction();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority=15)
	public void SinceWhenEnableconditionSinceWhenMonthForCaffeineAddiction()
	{
		boolean flag= Addictions.EnableconditionSinceWhenMonthForCaffeineAddiction();
		AssertJUnit.assertTrue(flag);
	}
	
	
	
}
