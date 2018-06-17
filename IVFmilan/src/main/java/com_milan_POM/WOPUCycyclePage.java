package com_milan_POM;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WOPUCycyclePage extends TestBase 
{
	@FindBy(xpath = "//li[text()='Cycles']")WebElement Cycles;
	@FindBy(xpath = "//h5[text() ='Procedures']//following::input[@id='txtServiceName']") WebElement Searchbox;
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
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement Existingcyclemsg;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement Alreadyexistflashmsg;
	@FindBy(xpath="(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[2]")WebElement checboxpreviousprocedure;
	@FindBy(xpath="//button[@id='btnAddPrePro'][@value='Save']")WebElement Add;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement msgSaveafteradd;
	
	
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	 String msg;
	 int count2;
	//WOPUCycyclePage WOC = new WOPUCycyclePage();
	 

	public WOPUCycyclePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public int SearchThecycles() throws Exception
	{
		System.out.println("Cycles button is displayed" +Cycles.isDisplayed()+"Cycles button is enabled"+Cycles.isEnabled());
		Actions action = new Actions(driver);
		action.moveToElement(Cycles).click().perform();
				//Cycles.click();
		String Name = reader.getCellData("Investigation", "Search", 2);
		TestUtil.VisibleOn(driver, Searchbox, 20);
		Actions act = new Actions(driver);
		act.moveToElement(Searchbox);
		act.click();
		act.sendKeys(Name);
		act.build().perform();
		Thread.sleep(1000);
		Searchbox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Searchbox.sendKeys("f");
		int i = 1;
		int rows = 2;
		
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		String cyclename = reader.getCellData("Investigation", "Searchresult", rows);
		String ARTName = searchlist.get(i).getText();
		String namecycle = searchlist.get(i).getText();
		if (namecycle.equals(ARTName)) 
		{
			searchlist.get(i).click();
			
		}
		return searchlist.size();
		
		
	}
	
	
	
	public  int NoofCycles() throws Exception
	{
		Actions act = new Actions(driver);
		act.moveToElement(Cycles).click().perform();
		String Name = reader.getCellData("Investigation", "Search", 2);
		Searchbox.sendKeys(Name);
		Thread.sleep(1000);
		Searchbox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Searchbox.sendKeys("f");
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
		String subnames = reader.getCellData("Investigation", "OPU", 4);
		ARTSubtype1.selectByVisibleText(subnames);
		Calender.click();
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//td"));
		for (int k = 0; k <= dates.size(); k++) 
		{
			String datevalue = dates.get(k).getText();
			if (datevalue.equals("04")) 
			{
				dates.get(k).click();
				//flag1 = true;
				break;
			}
		/*List<WebElement> Subtypes = ARTSubtype1.getOptions();
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
							//flag1 = true;
							break;

						}

					}

				} 
				else 
				{
					System.out.println("subtype is not matched");
				}
			}*/
		}
		
	
	}
		
	public  String SaveOPUsubtypeICSI() throws Exception 
	{
	List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
	int Rowssize =Availrow.size();
	if(Existingcycle()==true)
	{
		
		msg="Cycle Already available";
		
	
	}
	else
	{
	SearchThecycles();
	subtypedataentry();
	Save.click();
	msg = saveflashmessage.getText();
	 
	}
	return msg;
}
		
		
	
	public   String ARTCycleAvailabilityMessageBeforeSave() throws Exception
	{
			String Name = reader.getCellData("Investigation", "Search", 2);
			Searchbox.sendKeys(Name);
			Thread.sleep(1000);
			Searchbox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			Searchbox.sendKeys("f");
			int i = 1;
			int rows = 2;
			List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
			String cyclename = reader.getCellData("Investigation", "Searchresult", rows);
			String ARTName = searchlist.get(i).getText();
			List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
			int Availrowsize = Availrow.size();
			String namecycle = searchlist.get(i).getText();
			
			
			
			if (Availrowsize>0) 
			{
				searchlist.get(i).click();
				Thread.sleep(1000);
				msg = Availabilitymessage.getText();
			}
			else
			{
				msg = "cyclenotfound";
			
			}
			return msg;
			
			
		}
		
		
		

	public  String ClickOnCycle() throws Exception 
	{
		boolean flag = AlreadySavedCycle();
		if(flag)
		{
			Cycleoption.click();
			msg= CyclelistTitle.getText();
		}
		else
		{
		SaveOPUsubtypeICSI();
		 Cycleoption.click();
		 msg= CyclelistTitle.getText();
		return msg;
		}
		return msg;
		
	}
	
	public boolean Existingcycle()
	{
		try
		{
		TestUtil.VisibleOn(driver, Cycles, 20);
		}
		catch(Exception e)
		{
			System.out.println("element is not seen with in 20 seconds");
		}
		Actions act = new Actions(driver);
		act.moveToElement(Cycles).click().perform();
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		boolean flag= false;
		int Rowssize =Availrow.size();
		
		if(Rowssize>0)
		{
			flag=true;
		}
		else
		{
			
			flag= false;	
		}
		
		
		
		
		return flag;
		
	}
	
	
	
	public  String DeleteTheSeviceBeforeSave()
	{
		
		List<WebElement> Availrow = driver.findElements(By.xpath("//table/tbody[3]/tr/td[4]"));
		int Rowssize =Availrow.size();
		String msg="";
		if(Rowssize>0)
		{
			Delete.click();			
			Deletetext.sendKeys("NA");
			SaveDeletediailog.click();
			msg= DeleteMessage.getText();
		}
		else
		{
			
			msg ="cyclenotfound";
		}
		
		return msg;
	}
	
	
	public boolean AlreadySavedCycle() throws Exception 
	{	
		
		Actions act = new Actions(driver);
		act.moveToElement(Cycles).click().perform();
		List<WebElement>rows = driver.findElements(By.xpath("//h5[text()='Previous Procedures']//following::table[1]//tbody//tr"));
		int rowsize= rows.size();
		boolean flag= false;
		if(rowsize>0)
		{			
			
			flag=true;
		}
		else
		{
			flag=false;
			
		}
		
		
		return flag;
	}
	public String AddExistionService()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		try
		{
			TestUtil.VisibleOn(driver, checboxpreviousprocedure, 30);
		}
		catch(Exception e)
		{
			System.out.println("checboxpreviousprocedure is not displayed with in30 seconds");
		}
		System.out.println("checkbox is displayed" + checboxpreviousprocedure.isDisplayed()+"and enabled" +  checboxpreviousprocedure.isEnabled());
		Actions act = new Actions(driver);
		act.moveToElement(checboxpreviousprocedure).click().perform();
		act.moveToElement(Add).click().perform();
		Save.click();
		msg = msgSaveafteradd.getText();
		
		
		return msg;
		
	}
	public boolean DeleteTheservice()
	{
		System.out.println();
		boolean flag=true;
				if(flag=true)
				{
					Delete.click();
					flag= true;
				}
				else
				{
					flag=false;
							
				}
		
		return flag;
	}
	
	
	
	public String MessageforAlreadtyavailableCycle() throws Exception
	{
		if(AlreadySavedCycle() ==true)
		{
			SearchThecycles();
			Thread.sleep(2000);
			try{
				Existingcyclemsg.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element is not found");
			}
			finally
			{
				msg = "Close existing cycle first.";
			}
			
		}
		else
		{
			
			msg= "cyclenotfound";
		}
		
		
		
		return msg;
		
	}

		
	

 }

