package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WInvestigationPage extends TestBase {
	@FindBy(xpath = "//li[text()='Cycles']")
	WebElement Cycles;
	@FindBy(xpath = "(//input[@name='txtServiceName'])[2]")
	WebElement Search;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")
	WebElement InvestigationPageTitle;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")WebElement fornegetiveflashmsg;
	@FindBy(xpath="//div[@class='close-button ng-scope']")WebElement closeflash;
@FindBy(xpath="//*[@class='toast-text ng-scope']//span//following::span")WebElement saveflashmessage;
	

	Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	int count = 0;
	int rows = 1;
	int rows1=2;
	int count1 = 0;
	int count2;

	WInvestigationPage() {
		PageFactory.initElements(driver, this);
	}

	public int Setsearchvalue() throws Exception 
	{

		Cycles.click();
		String Name = reader.getCellData("Investigation", "Search", 2);
		Search.sendKeys(Name);
		Thread.sleep(1000);
		Search.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Search.sendKeys("f");
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		int size = searchlist.size();

		for (int i = 0; i <= 8; i++) {
			rows++;
			if (rows == 8) {
				break;
			} else {
				String resultnames = searchlist.get(i).getText();

				while (rows <= size) 
				{

					reader.setCellData("Investigation", "Searchresult", rows, resultnames);

					break;
				}

			}
		}
		return size;
	}

	public int REFIVFPACKAGEARTCycle() throws Exception 
	{
		Cycles.click();
		String Name = reader.getCellData("Investigation", "Search", 2);
		Search.sendKeys(Name);
		Thread.sleep(1000);
		Search.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Search.sendKeys("f");
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		int size = searchlist.size();

		int i = 1; rows=2;
		/*while (i <= size) 
		{*/
			
			String cyclename = reader.getCellData("Investigation", "Searchresult", 3);
			String ARTName = searchlist.get(i).getText();
			if (cyclename.equals(ARTName)) 
			{
				searchlist.get(i).click();
				
			}
			Thread.sleep(2000);
			WebElement ArtType = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[1]"));
			String ARTTypechar = reader.getCellData("Investigation", "REF. IVF PACKAGE", 5);
			Select ArtType1 = new Select(ArtType);
			List<WebElement>selectoptions=ArtType1.getOptions();
			int size1= selectoptions.size();
			for(int j=1;j<size1;j++)
			{
				String arr1;
			String OptionNames =  selectoptions.get(j).getText();

			
			String namesoptions =  reader.getCellData("Investigation", "REF. IVF PACKAGE", rows1);
			rows1++;
			if(OptionNames.equals(namesoptions))
			{
				count++;
				
			}
			count2= count;
			
			

			}
			

		return count2;
		}
		



	
	

	@AfterMethod
	public void Teardown() 
	{
		driver.close();
	}

}
