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
	static
	WebElement Cycles;
	@FindBy(xpath = "(//input[@name='txtServiceName'])[2]")
	static
	WebElement Search;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")
	WebElement InvestigationPageTitle;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")WebElement fornegetiveflashmsg;
	@FindBy(xpath="//div[@class='close-button ng-scope']")WebElement closeflash;
@FindBy(xpath="//*[@class='toast-text ng-scope']//span//following::span")WebElement saveflashmessage;
@FindBy(xpath="(//button[@class='btn btn-primary'])[3]") WebElement Save;
	

	static Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	int count = 0;
	static int rows = 1;
	static int rows1=1;
	int count1 = 0;
	int count2;
	String subtypname;
	int sizeofsubtype;
	String subsize = null;

	WInvestigationPage() 
	{
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

	public int REFIVFPACKAGEARTCycleCount() throws Exception 
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
			String sizeoptions = Integer.toString(size1);
			reader.setCellData("Investigation", "IVF PACKAG Count", 2, sizeoptions);
			int rows3=2;
			int count1 = 0;
			for(int j=1;j<size1;j++)
			{
				String arr1;
			String OptionNames =  selectoptions.get(j).getText();
			//System.out.println(OptionNames);

			
			
			String namesoptions =  reader.getCellData("Investigation", "IVF PACKAGE", rows3);
			
			 rows3++;
			if(OptionNames.equals(namesoptions))
			{
				//Select ArtTypename= new Select(ArtType);
				//ArtTypename.selectByVisibleText(OptionNames);
				
				
				count1++;
				
								
			}	
			else
			{
				InvestigationPageTitle.getText();
				
			}
			
			
			count2= count;
	}
	return count2;
}
	
	
	
	
	
	
	public  int OUIARTSubTypes() throws Exception
	{
		
		REFIVFPACKAGEARTCycleCount();
		WebElement ArtType = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[1]"));
		String namesoptions =  reader.getCellData("Investigation", "IVF PACKAGE", 2);
		Select ArtTypename= new Select(ArtType);
		ArtTypename.selectByVisibleText(namesoptions);
		WebElement ARTSubtype = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[2]"));
		Select ARTSubtype1= new Select(ARTSubtype);
		List<WebElement> Subtypes = ARTSubtype1.getOptions();
		int subtypesize= Subtypes.size();
		
		try
		{
		  subsize = Integer.toString(subtypesize);
		}
		catch(NumberFormatException e)
		{
			System.out.println("not convertedinto aatring");
		}
		
		String subsize1= subsize;
		reader.setCellData("Investigation", "ARTSubTypecount", 2, subsize1);
		int rows2=2;
		for(int j=1;j<subtypesize;j++)
		{
		String subtypenames= Subtypes.get(j).getText();
		String subnames = reader.getCellData("Investigation", "OPU", rows2);
			Select subtype= new Select(ARTSubtype);
			rows2++;
			if(subtypenames.equals(subnames))
			{
				ARTSubtype1.selectByVisibleText(subtypenames);
			WebElement subtypeele= ARTSubtype1.getFirstSelectedOption();
			String subtypname= subtypeele.getText();
			count++;
						
		}
		  
		
		
				
		}
		return count;
		 
		
		
		
	}
	public String OPUCycle() throws Exception
	{
		REFIVFPACKAGEARTCycleCount();
		WebElement ArtType = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[1]"));
		String namesoptions =  reader.getCellData("Investigation", "IVF PACKAGE", 2);
		Select ArtTypename= new Select(ArtType);
		ArtTypename.selectByVisibleText(namesoptions);
		WebElement ARTSubtype = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[2]"));
		Select ARTSubtype1= new Select(ARTSubtype);
		List<WebElement> Subtypes = ARTSubtype1.getOptions();
		int subtypesize= Subtypes.size();
				
		int rows2=2;
		for(int j=1;j<subtypesize;j++)
		{
		String subtypenames= Subtypes.get(j).getText();
		String subnames = reader.getCellData("Investigation", "OPU", rows2);
			Select subtype= new Select(ARTSubtype);
			rows2++;
			if(subtypenames.equals(subnames))
			{
				ARTSubtype1.selectByVisibleText(subtypenames);
				Save.click();
				break;					
			}
			else
			{
				InvestigationPageTitle.getText();
			}
		}
		return namesoptions;
	}
		  
		
		
				
		
		
		
		
		
		
		
	
	
	
		



	
	

	@AfterMethod
	public void Teardown() 
	{
		driver.close();
	}

}
