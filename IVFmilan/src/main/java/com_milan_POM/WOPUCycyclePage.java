package com_milan_POM;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WOPUCycyclePage extends TestBase 
{
	@FindBy(xpath = "//li[text()='Cycles']")
	 WebElement Cycles;
	@FindBy(xpath = "(//input[@name='txtServiceName'])[2]")
	 WebElement Search;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']") static WebElement saveflashmessage;
	@FindBy(xpath = "//i[@class='fa fa-calendar']")
	 WebElement Calender;
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
	 WebElement Save;
	@FindBy(xpath = "//a[@class='active_white_color']")
	 WebElement Cycleoption;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")
	 WebElement Availabilitymessage;
	@FindBy(xpath="//table/tbody[3]/tr/td[1]/span[@class='btn_delete']")
	 WebElement Delete;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")
	 WebElement DeleteMessage;
	@FindBy(xpath="//h4[text()='Reason']//following::textarea")
	 WebElement Deletetext;
	@FindBy(xpath="(//h4[text()='Reason']//following::button[text()=' Save'])[1]")
	 WebElement SaveDeletediailog;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement AddserviceMessage;
	@FindBy(xpath="(//button[@class='btn btn-default'])[2]")
	 WebElement Cancel;
	@ FindBy(xpath="//span[text()='Cycle List']")WebElement CyclelistTitle;
	
	
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	 String msg;
	 int count2;
	//WOPUCycyclePage WOC = new WOPUCycyclePage();

	public WOPUCycyclePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void SearchThecycles() throws Exception
	{
		String Name = reader.getCellData("Investigation", "Search", 2);
		Search.sendKeys(Name);
		Thread.sleep(1000);
		Search.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Search.sendKeys("f");
		int i = 1;
		int rows = 2;
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		String cyclename = reader.getCellData("Investigation", "Searchresult", rows);
		String ARTName = searchlist.get(i).getText();
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		int Availrowsize = Availrow.size();
		String namecycle = searchlist.get(i).getText();
		if (Availrowsize == 0 && namecycle.equals(ARTName)) 
		{
			searchlist.get(i).click();
		}
		else
		{
			System.out.println("ARTCycle is already available");		
		}
		
	}
	
	
	
	public  int NoofCycles() throws Exception
	{
		TestUtil.VisibleOn(driver, Cycles, 20);
		Cycles.click();
		String Name = reader.getCellData("Investigation", "Search", 2);
		Search.sendKeys(Name);
		Thread.sleep(1000);
		Search.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Search.sendKeys("f");
		int i = 1;
		int rows = 2;
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		String cyclename = reader.getCellData("Investigation", "Searchresult", rows);
		String ARTName = searchlist.get(i).getText();
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		int Availrowsize = Availrow.size();
		String namecycle = searchlist.get(i).getText();
		if (Availrowsize == 0 && namecycle.equals(ARTName)) 
		{
			searchlist.get(i).click();
		}
		else
		{
			System.out.println("ARTCycle is already available");		
		}
		Thread.sleep(2000);
		WebElement ArtType = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[1]"));
		Select ArtType1 = new Select(ArtType);
		List<WebElement>selectoptions=ArtType1.getOptions();
		int Arttypesize= selectoptions.size();
		String sizeoptions = Integer.toString(Arttypesize);
		
		reader.setCellData("Investigation", "IVF PACKAG Count", 2, sizeoptions);
		
		int rows3=2;
		int count1 = 0;
		for(int j=1;j<Arttypesize;j++)
		{
			
		String OptionNames =  selectoptions.get(j).getText();
		
		String namesoptions =  reader.getCellData("Investigation", "IVF PACKAGE", rows3);
		
		 rows3++;
		if(OptionNames.equals(namesoptions))
		{			
			count1++;	
							
		}	
		else
		{
			Availabilitymessage.getText();
			
		}
		
		
		count2= count1;
}
return count2;
	}
	
	public void subtypedataentry()
	{
		WebElement ArtType = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[1]"));
		String namesoptions = reader.getCellData("Investigation", "IVF PACKAGE", 2);
		Select ArtTypename = new Select(ArtType);
		ArtTypename.selectByVisibleText(namesoptions);
		WebElement ARTSubtype = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[2]"));
		Select ARTSubtype1 = new Select(ARTSubtype);
		List<WebElement> Subtypes = ARTSubtype1.getOptions();
		int subtypesize = Subtypes.size();
		int subtypesize1 = Subtypes.size();
		int rows2 = 4;
		boolean flag1 = false;
		for (int j = 1; j < subtypesize1; j++) 
		{
			if (flag1 == false) 
			{

				String subtypenames = Subtypes.get(j).getText();
				String subnames = reader.getCellData("Investigation", "OPU", rows2);

				if (subtypenames.equals(subnames)) 
				{
					ARTSubtype1.selectByVisibleText(subtypenames);
					Calender.click();
					List<WebElement> dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//td"));
					for (int k = 0; k <= dates.size(); k++) 
					{
						String datevalue = dates.get(k).getText();
						if (datevalue.equals("04")) 
						{
							dates.get(k).click();
							flag1 = true;
							break;

						}

					}

				} 
				else 
				{
					System.out.println("subtype is not matched");
				}
			}
		}
		
		
		
		
		
		
		
	}
		
	public  String OPUsubtypeICSI() throws Exception 
	{
		TestUtil.VisibleOn(driver, Cycles, 20);
		Cycles.click();
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		int Rowssize =Availrow.size();
		if(Rowssize>0)
		{
			
			Delete.click();
			
			Deletetext.sendKeys("NA");
			SaveDeletediailog.click();
			SearchThecycles();
			subtypedataentry();
			
			
			
		}
		else
		{
		SearchThecycles();
		WebElement ArtType = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[1]"));
		String namesoptions = reader.getCellData("Investigation", "IVF PACKAGE", 2);
		Select ArtTypename = new Select(ArtType);
		ArtTypename.selectByVisibleText(namesoptions);
		WebElement ARTSubtype = driver.findElement(By.xpath("(//th[text()='ART Type']//following::select)[2]"));
		Select ARTSubtype1 = new Select(ARTSubtype);
		List<WebElement> Subtypes = ARTSubtype1.getOptions();
		int subtypesize = Subtypes.size();
		int subtypesize1 = Subtypes.size();
		int rows2 = 4;
		boolean flag1 = false;
		for (int j = 1; j < subtypesize1; j++) 
		{
			if (flag1 == false) 
			{

				String subtypenames = Subtypes.get(j).getText();
				String subnames = reader.getCellData("Investigation", "OPU", rows2);

				if (subtypenames.equals(subnames)) 
				{
					ARTSubtype1.selectByVisibleText(subtypenames);
					Calender.click();
					List<WebElement> dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//td"));
					for (int k = 0; k <= dates.size(); k++) 
					{
						String datevalue = dates.get(k).getText();
						if (datevalue.equals("04")) 
						{
							dates.get(k).click();
							flag1 = true;
							break;

						}

					}

				} 
				else 
				{
					System.out.println("subtype is not matched");
				}
			}

		}
		}
		
		Save.click();
		String msg1 = saveflashmessage.getText();
		return msg1;

	}

	public   String ARTCycleAvailabilityMessage() throws Exception
	{
		TestUtil.VisibleOn(driver, Cycles, 20);
		Cycles.click();
		String Name = reader.getCellData("Investigation", "Search", 2);
		Search.sendKeys(Name);
		Thread.sleep(1000);
		Search.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Search.sendKeys("f");
		int i = 1;
		int rows = 2;
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		String cyclename = reader.getCellData("Investigation", "Searchresult", rows);
		String ARTName = searchlist.get(i).getText();
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		int Availrowsize = Availrow.size();
		String namecycle = searchlist.get(i).getText();
		if ( namecycle.equals(ARTName)) 
		{
			searchlist.get(i).click();
		}
		else
		{
			System.out.println("ARTCycle is already available");
			
			
			
			
		}
		msg = Availabilitymessage.getText();		
		System.out.println(msg);
				
		return msg;		

	}


	public  CycleListPage ClickOnCycle() throws Exception 
	{	
		OPUsubtypeICSI();
		Cycleoption.click();
		return new CycleListPage();
	}
	
	public  String DeleteTheSevice()
	{
		
		TestUtil.VisibleOn(driver, Cycles, 20);
		Cycles.click();
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		int Rowssize =Availrow.size();
		if(Rowssize!=0)
		{
			Delete.click();
		}
		else
		{
			Cancel.click();
		}
		Deletetext.sendKeys("NA");
		SaveDeletediailog.click();
		
		
		String msg= DeleteMessage.getText();
		return msg;
	}

		
	

 }
