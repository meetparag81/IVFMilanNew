package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class pastMedicationHistoryPage extends TestBase
{
	@FindBy(css="#txtItemName")WebElement IB;
	@FindBy(xpath="//input[@id='txtItemName1']")WebElement InputsearchboxGeneric;
	@FindBy(xpath="//input[@id='txtItemName']")WebElement InputsearchboxBrandName;
	@FindBy(xpath="(//ul[@role='listbox'])[2]")WebElement Searchbox; 
	@FindBy(xpath="(//input[@name='inlineRadioOptions2'])[2]")WebElement GenericName;
	@FindBy(xpath="(//table[@id='profile_table']/tbody)[2]//input")WebElement DrugName;
	@FindBy(xpath="//th[text()='Time Period']//following::select")WebElement TimePeriod;
	@FindBy(xpath="//th[text()='Status']//following::select[2]")WebElement DrugStatus;
	@FindBy(xpath="//button[text()=' Save'][@class='btn btn-primary ng-binding']")WebElement Save;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	
	pastMedicationHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean DrugNameFieldEnablecondition()
	{	
		
		/*TestUtil.VisibleOn(driver, GenericName,30);
		GenericName.click();
		TestUtil.VisibleOn(driver, InputsearchboxGeneric, 60);
		System.out.println("searchbox is displayed"+ InputsearchboxGeneric.isDisplayed());
		InputsearchboxGeneric.sendKeys("ADAP");
		InputsearchboxGeneric.sendKeys(Keys.BACK_SPACE);		
		List<WebElement>searchbox1= driver.findElements(By.xpath("//ul[@role='listbox'][@class='dropdown-menu ng-isolate-scope']//a"));
		TestUtil.VisibleElementsOn(driver, driver.findElements(By.xpath("//ul[@role='listbox'][@class='dropdown-menu ng-isolate-scope']//a")),40);
		for(int i=0;i<=searchbox1.size();i++)
		{
			if(searchbox1.get(i).getText().contains("TADALAFIL"))
			
			TestUtil.VisibleElementsOn(driver, searchbox1, 40);
			searchbox1.get(i).click();
			break;
			
			
			
		}*/
		DrugName.isDisplayed();	
		
		return false;
		
	}
	public String DrugName() throws InterruptedException
	{	
		TestUtil.VisibleOn(driver, GenericName,30);
		GenericName.click();
		TestUtil.VisibleOn(driver, InputsearchboxGeneric, 60);
		System.out.println("searchbox is displayed"+ InputsearchboxGeneric.isDisplayed());
		InputsearchboxGeneric.sendKeys("ADA");
		Thread.sleep(1000);
		InputsearchboxGeneric.sendKeys(Keys.BACK_SPACE);
		InputsearchboxGeneric.sendKeys("A");
		//TestUtil.VisibleOn(driver, Searchbox, 50);
				
				List<WebElement>searchbox1= driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a"));
				TestUtil.VisibleElementsOn(driver, driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a")),20);
		for(int i=0;i<=searchbox1.size();i++)
		{
			if(searchbox1.get(i).getText().contains("ADAPALENE"))
			{
			TestUtil.VisibleElementsOn(driver, searchbox1, 20);
			searchbox1.get(i).click();
			break;
			}		
		}
		Thread.sleep(2000);
		String Name= DrugName.getAttribute("value");
		Select TimePeriod1= new Select(TimePeriod);
		TimePeriod1.selectByVisibleText("Days");
		
		List<WebElement>Rowstable= driver.findElements(By.xpath("(//table[@id='profile_table']/tbody)[2]"));
		Select Status = new Select(DrugStatus);
		Status.selectByVisibleText("Withdrawn");
		//wait.until(ExpectedConditions.textToBePresentInElementValue(DrugName, "ADAPALENE"));
		/*String value =  (String)((JavascriptExecutor) driver).executeAsyncScript("return document.getElementById('pastMedicationHistory').value");
		System.out.println(value);*/
		
				
		
		
		return Name;
		
	}
	
	
	
	
}
