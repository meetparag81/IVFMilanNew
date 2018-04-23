package com_milan_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class AddictionsPage extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	TestUtil Testutl;
	
	@FindBy(xpath="(//input[@type='checkbox'])[6]")WebElement smoke;
	@FindBy(xpath="(//input[@type='checkbox'])[7]")WebElement Alkohol;
	@FindBy(xpath="(//input[@type='checkbox'])[8]")WebElement Tobaco;
	@FindBy(xpath="(//input[@type='checkbox'])[9]")WebElement DrugAdiction;
	@FindBy(xpath="(//input[@type='checkbox'])[10]")WebElement CaffeineAddiction;
	
	@FindBy(xpath="(//select[@id='ddlCurrentStatus'])[1]")WebElement currentstatusSmoke;
	@FindBy(xpath="(//select[@id='ddlCurrentStatus'])[2]")WebElement currentstatusAlcohol;
	@FindBy(xpath="(//select[@id='ddlCurrentStatus'])[3]")WebElement currentstatusTobaco;
	@FindBy(xpath="(//select[@id='ddlCurrentStatus'])[4]")WebElement currentstatusDrugAdiction;
	@FindBy(xpath="(//select[@id='ddlCurrentStatus'])[4]")WebElement currentstatusCaffeineAddiction;
	@FindBy(xpath="(//label[text()='Since When'])[7]//following::select")WebElement SinceWhenYearSmoke;
	@FindBy(xpath="(//label[text()='Since When'])[8]//following::select")WebElement SinceWhenYearAlcohol;
	@FindBy(xpath="(//label[text()='Since When'])[9]//following::select")WebElement SinceWhenYearTobaco;
	@FindBy(xpath="(//label[text()='Since When'])[10]//following::select")WebElement SinceWhenDrugYearAdiction;
	@FindBy(xpath="(//label[text()='Since When'])[11]//following::select")WebElement SinceWhenYearCaffeineAddiction;
	@FindBy(xpath="(//label[text()='Since When'])[7]//following::select[2]")WebElement SenceWhenMonthSmioke;
	@FindBy(xpath="(//label[text()='Since When'])[8]//following::select[2]")WebElement SinceWhenMonthAlkohol;
	@FindBy(xpath="(//label[text()='Since When'])[9]//following::select[2]")WebElement SinceWhenMonthTobaco;
	@FindBy(xpath="(//label[text()='Since When'])[10]//following::select[2]")WebElement SinceWhenMonthDrugAdiction;
	@FindBy(xpath="(//label[text()='Since When'])[11]//following::select[2]")WebElement SinceWhenMonthCaffeineAddiction;
	AddictionsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean CurrentStatusEnableForSmoke()
	{
		TestUtil.ClickOn(driver, smoke, 20);
		if(smoke.isDisplayed())
		{
			smoke.click();
		}
		currentstatusSmoke.isDisplayed();
		return true;
		
	}
	
	public boolean CurrentStatusEnableConditionForAlcohol()
	{
		TestUtil.ClickOn(driver, Alkohol, 20);
		if(Alkohol.isDisplayed())
		{
			Alkohol.click();
		}
		currentstatusAlcohol.isDisplayed();
		return true;
		}
		
		public boolean CurrentStatusEnableConditionForTobaco()
		{
			TestUtil.ClickOn(driver, Tobaco, 20);
			if(Alkohol.isDisplayed())
			{
				Alkohol.click();
			}
			currentstatusTobaco.isDisplayed();
			return true;
		}
		
		public boolean CurrentStatusEnableConditionForDrugAdiction()
		{
			TestUtil.ClickOn(driver, DrugAdiction, 20);
			if(DrugAdiction.isDisplayed())
			{
				DrugAdiction.click();
			}
			currentstatusDrugAdiction.isDisplayed();
			return true;
		}
		public boolean CurrentStatusEnableConditionForCaffeineAddiction()
		{
			TestUtil.ClickOn(driver, CaffeineAddiction, 20);
			if(CaffeineAddiction.isDisplayed())
			{
				CaffeineAddiction.click();
			}
			currentstatusCaffeineAddiction.isDisplayed();
			return true;
		}
		
		public boolean EnableConditionForSinceWhenDrugAdiction()
		{
			TestUtil.ClickOn(driver, DrugAdiction, 20);
			if(DrugAdiction.isDisplayed())
			{
				DrugAdiction.click();
			}
			SinceWhenDrugYearAdiction.isDisplayed();
			return true;
		}
		public boolean EnableConditionSinceWhenForAlkohol()
		{
			TestUtil.ClickOn(driver, Alkohol, 20);
			if(Alkohol.isDisplayed())
			{
				Alkohol.click();
			}
			SinceWhenYearAlcohol.isDisplayed();
			return true;
		}
		public boolean EnableConditionSinceWhenForTobaco()
		{
			TestUtil.ClickOn(driver, Tobaco, 20);
			if(Tobaco.isDisplayed())
			{
				Tobaco.click();
			}
			SinceWhenYearTobaco.isDisplayed();
			return true;
		}
		public boolean EnableConditionSinceWhenForSmoke()
		{
			TestUtil.ClickOn(driver, Tobaco, 20);
			if(smoke.isDisplayed())
			{
				smoke.click();
			}
			SinceWhenYearSmoke.isDisplayed();
			return true;
		}
		public boolean EnableConditionSinceWhenYearFor()
		{
			TestUtil.ClickOn(driver, Tobaco, 20);
			if(smoke.isDisplayed())
			{
				smoke.click();
			}
			SenceWhenMonthSmioke.isDisplayed();
			return true;
		}
		
		public boolean EnableconditionSinceWhenMonthForSmoke()
		{
			smoke.click();			  
			SinceWhenMonthTobaco.isDisplayed();
			return true;
		}
			
			public boolean EnableconditionSinceWhenMonthForAlkohol()
			{
				Alkohol.click();
				SinceWhenMonthAlkohol.click();
				return true;
			}
			public boolean EnableconditionSinceWhenMonthForTobaco()
			{
				Tobaco.click();
				SinceWhenMonthTobaco.isDisplayed();
				return true;
			}
			
			public boolean EnableconditionSinceWhenMonthForDrugAdiction()
			{
				DrugAdiction.click();
				SinceWhenMonthDrugAdiction.isDisplayed();
				return true;
			}
			public boolean EnableconditionSinceWhenMonthForCaffeineAddiction()
			{
				CaffeineAddiction.click();
				SinceWhenMonthCaffeineAddiction.isDisplayed();
				return true;
			}
		}
		
	


