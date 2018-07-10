package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WPastMedicationHistoryPage extends TestBase
{
	@FindBy(css="#txtItemName")WebElement IB;
	@FindBy(xpath="//input[@id='txtItemName1']")WebElement InputsearchboxGeneric;
	@FindBy(xpath="//input[@id='txtItemName']")WebElement InputsearchboxBrandName;
	@FindBy(xpath="(//ul[@role='listbox'])[2]")WebElement Searchbox; 
	@FindBy(xpath="(//input[@name='inlineRadioOptions2'])[2]")WebElement GenericName;
	@FindBy(xpath="(//table[@id='profile_table'])[2]//tbody//td/div/input[@ng-model='Item.DrugeName']")WebElement DrugName;
	@FindBy(xpath="//th[text()='Time Period']//following::select")WebElement TimePeriod;
	@FindBy(xpath="//th[text()='Status']//following::select[2]")WebElement DrugStatus;
	@FindBy(xpath="//button[text()=' Save'][@class='btn btn-primary ng-binding']")WebElement Save;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	String drug1,Name2,Name;
	WPastMedicationHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean DrugNameFieldEnablecondition()
	{	
	DrugName.isDisplayed();	
		
		return false;
		
	}
	public String DrugName() 
	{	
		try
		{
			TestUtil.VisibleOn(driver, GenericName,30);
		}
		catch(Exception e)
		{
			System.out.println("Element- GenericName is not seen within 30 sec");
		}		
		GenericName.click();
		try
		{
			TestUtil.VisibleOn(driver, InputsearchboxGeneric, 60);
		}
		catch(Exception e)
		{
			System.out.println("Element- InputsearchboxGeneric is not seen within 60 sec");
		}
		
		System.out.println("searchbox is displayed"+ InputsearchboxGeneric.isDisplayed());
		InputsearchboxGeneric.sendKeys("ADA");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		InputsearchboxGeneric.sendKeys(Keys.BACK_SPACE);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			System.out.println("The InterruptedException is occured");
		}
		//InputsearchboxGeneric.sendKeys("A");
		//TestUtil.VisibleOn(driver, Searchbox, 50);
				
				List<WebElement>searchbox1= driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a"));
				try
				{
				TestUtil.VisibleElementsOn(driver, driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a")),20);
				}
				catch(Exception e)
				{
					System.out.println("Timeoutexception seen");
				}
		for(int i=0;i<=searchbox1.size();i++)
		{
			
			if(searchbox1.get(i).getText().contains("ADAPALENE"))
			{
			try
			{
			TestUtil.VisibleElementsOn(driver, searchbox1, 20);
			}
			catch(Exception e)
			{
				System.out.println("timeout exception seen");
			}
			searchbox1.get(i).click();
			break;
			}		
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		
		//String Name= DrugName.getAttribute("value");
		
		List<WebElement>rugrow = driver.findElements(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr"));
		 int Drugrowcount = rugrow.size();
		 for(int j=1;j<=Drugrowcount;j++)
		 {
			 WebElement DrugName1 = driver.findElement(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr["+j+"]/td[1]/div/input"));
			  Name= DrugName1.getAttribute("value");
			 if(Name.contains("ADAPALENE"))
			 {
				 System.out.println("patient already has previous Medication added");
				 
				  WebElement Timedays = driver.findElement(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr["+j+"]/td[3]//div[2]/select"));
				 Select TimePerioddays= new Select(Timedays);
				 TimePerioddays.selectByVisibleText("Days");
				 WebElement Dose= driver.findElement(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr["+j+"]/td[2]//input"));
				 Dose.sendKeys("1");
				 WebElement Timeperiodvalue= driver.findElement(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr["+j+"]/td[3]//input"));
				 Timeperiodvalue.sendKeys("2");
				 WebElement Remarks = driver.findElement(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr["+j+"]/td[4]//input"));
				 Remarks.sendKeys("Added dose i time for2 days");
				 WebElement statusdrug = driver.findElement(By.xpath("(//table[@id='profile_table'])[2]//tbody/tr["+j+"]/td[5]//select"));
					Select Status = new Select(statusdrug);
					Status.selectByVisibleText("Withdrawn");
					break;
					 
				 
			 }
			 
			 
		 }
		 Name2= Name;
		 
		
		
		//wait.until(ExpectedConditions.textToBePresentInElementValue(DrugName, "ADAPALENE"));
		/*String value =  (String)((JavascriptExecutor) driver).executeAsyncScript("return document.getElementById('pastMedicationHistory').value");
		System.out.println(value);*/
		
				
		
		
		return Name2;
		
	}
	
	public int pastMedicationHistorysetdata()
	{
		String Search1 = null,Search = null;
		int rows=2;
		try
		{
		TestUtil.VisibleOn(driver, GenericName,30);
		}
		catch(Exception e)
		{
			System.out.println("Timeout exception seen");
		}
		GenericName.click();
		try
		{
		TestUtil.VisibleOn(driver, InputsearchboxGeneric, 30);
		}
		catch(Exception e)
		{
			System.out.println("Timeoutexception seen");
		}
		
		String search= reader.getCellData("SearchBYA", 0, 2);
		InputsearchboxGeneric.sendKeys("ADA");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				System.out.println("The InterruptedException is occured");
			}
			InputsearchboxGeneric.sendKeys(Keys.BACK_SPACE);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				System.out.println("The InterruptedException is occured");
			}
			//InputsearchboxGeneric.sendKeys("A");
			//TestUtil.VisibleOn(driver, Searchbox, 50);
					
					List<WebElement>searchbox1= driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a"));
					try
					{
					TestUtil.VisibleElementsOn(driver, driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a")),20);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					int count=0;
			for(int i=0;i<searchbox1.size();i++)
			{
				 Search1 = searchbox1.get(i).getText();
				 
				 if(count<searchbox1.size())
				 {
					 reader.setCellData("pastMedicationHistory", "SearchBYA",rows , Search1);
					 count++;
					 rows++;
				 }
				
					
				
			}
			
			return count;
			
		
	}
	
	public String drugexpected()
	{
		String drugexpected = null;
		int count=reader.getRowCount("pastMedicationHistory");
		for(int rows=2;rows<=count;rows++)
		{
		 drugexpected=reader.getCellData("pastMedicationHistory", 0, rows);
		 count++;
		 if(drugexpected.contains("ADAPALENE"))
		 {
			 String drug1= drugexpected; 
		 }	}
		String drug= drug1;
		System.out.println("Drug is placed at"+count);
		return drug;
		
		
	}
	public int DeleteExisingRows()
	{
		List<WebElement>Existingdrug= driver.findElements(By.xpath("//table[@class='table table-striped table-hover table-bordered']//tr"));
		int count= Existingdrug.size();
		
		
		
		
		
		
		return 0;
		
	}
	
	
	
	
	
	
}
