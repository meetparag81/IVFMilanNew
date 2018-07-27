package com_milan_POM;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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
	@FindBy(xpath = "//i[@class='fa fa-calendar']")WebElement Calender;
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")WebElement Save;
	@FindBy(xpath = "//a[@class='active_white_color']")WebElement Cycleoption;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")WebElement Availabilitymessage;
	@FindBy(xpath="//table/tbody[3]/tr/td[1]/span[@class='btn_delete']")WebElement Delete;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement DeleteMessage;
	@FindBy(xpath="//h4[text()='Reason']//following::textarea")WebElement Deletetext;
	@FindBy(xpath="(//h4[text()='Reason']//following::button[text()=' Save'])[1]")WebElement SaveDeletediailog;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement AddserviceMessage;
	@FindBy(xpath="(//button[@class='btn btn-default'])[2]")WebElement Cancel;
	@ FindBy(xpath="//span[text()='Cycle List']")WebElement CyclelistTitle;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement Existingcyclemsg;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement Alreadyexistflashmsg;
	@FindBy(xpath="(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[2]")WebElement checboxpreviousprocedure;
	@FindBy(xpath="//button[@id='btnAddPrePro'][@value='Save']")WebElement Add;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement msgSaveafteradd;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']") WebElement Addservice;
	@FindBy(xpath="//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a") WebElement cyclecode;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")WebElement msgagainstcycle;
	@FindBy (xpath="//input[@name='dtplannedDate']")WebElement Calenderinput;
	@FindBy(xpath = "//label[text()='LMP']//following-sibling::div//input[@id='Date']")WebElement Datetext;
	@FindBy(xpath = "//input[@name='txtInstruction']")WebElement Instruction;
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	 
	 String msg;
	 int count2;
	 boolean flag;
	 
	 boolean flag3;
		String thismonth;
	//WOPUCycyclePage WOC = new WOPUCycyclePage();
	 

	public WOPUCycyclePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public int SearchThecycles() 
	{
		//System.out.println("Cycles button is displayed" +Cycles.isDisplayed()+"Cycles button is enabled"+Cycles.isEnabled());
		try
		{
			TestUtil.VisibleOn(driver, Cycles, 30);
			TestUtil.ActionForMovetoElement(Cycles);
		}
		catch(Exception e)
		{
			System.out.println("Element-Cycles is not seen within 30 sec");
		}
		System.out.println();
		
				//Cycles.click();
		String Name = reader.getCellData("Investigation", "Search", 2);
		try
		{
		TestUtil.VisibleOn(driver, Searchbox, 40);
		
		}
		catch(Exception e)
		{
			System.out.println("Timeoutexceptionseen");
		}
		TestUtil.ActionForMovetoElement(Searchbox);
		Searchbox.click();
		Searchbox.sendKeys(Name);
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			System.out.println("InterruptedException seen");
		}
		Searchbox.sendKeys(Keys.BACK_SPACE);
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("thread.sleep value should be reduced ");
		}
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
	
	
	
	public  int NoofCycles() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(Cycles).click().perform();
		String Name = reader.getCellData("Investigation", "Search", 2);
		Searchbox.sendKeys(Name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1)
		{
			System.out.println("The InterruptedException is occured");
		}
		Searchbox.sendKeys(Keys.BACK_SPACE);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1)
		{
			System.out.println("The InterruptedException is occured");
		}
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
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
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
	
	public boolean DatePicker() 
	{
	System.out.println();
		boolean flag = false;
		Calender.click();
		String currentdate = TestUtil.Date();
		String arr[] = currentdate.split(",");
		String day = arr[0];
		String month = arr[1];
		String year = arr[2];

		/*TestUtil.ActionForMovetoElement(Datetext);
		Datetext.clear();*/
		WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
		String monthtext = Monthtextele.getText();
		String montharr[] = monthtext.split(" ");
		String Currentmonth = montharr[0];
		String Currentyear = montharr[1];
		if (Currentmonth.equals(month)) 
		{
			List<WebElement> datenodes = driver.findElements(By.xpath("//table[@role='grid']//tbody//td/button"));
			try 
			{
				TestUtil.VisibleElementsOn(driver, datenodes, 30);
			} 
			catch (Exception e)
			{
				System.out.println("TimeoutExceptionseen");
			}
			int Totalnodes = datenodes.size();
			for (int i = 0; i < Totalnodes; i++) 
			{
				String date = datenodes.get(i).getText();
				boolean flag1 = datenodes.get(i).isEnabled();
				flag3 = flag1;
				if (date.equals("15") && month.equals(Currentmonth))
				{

					datenodes.get(i).click();

					break;
				}
			}

		} else {
			Monthtextele.click();
			List<WebElement> Monthnodes = driver.findElements(By.xpath("//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']//div//table//tbody//td"));
			for (WebElement month1 : Monthnodes) 
			{
				thismonth = month1.getText();
				boolean flag2 = month1.isEnabled();
				if (thismonth.equals(month) && flag2 == true) 
				{
					month1.click();
					break;
				}

			}
			List<WebElement> datenodes = driver.findElements(By.xpath("//table[@role='grid']//tbody//td/button"));
			try {
				TestUtil.VisibleElementsOn(driver, datenodes, 30);
			} catch (Exception e) {
				System.out.println("TimeoutExceptionseen");
			}
			int Totalnodes = datenodes.size();
			for (int i = 0; i < Totalnodes; i++) 
			{
				String date = datenodes.get(i).getText();

				boolean flag1 = datenodes.get(i).isEnabled();
				flag3 = flag1;
				if (date.equals("15") && flag1 == true && thismonth.equals(month)) 
				{
					try 
					{
						Thread.sleep(2000);
					}
					catch (InterruptedException e) 
					{
						System.out.println("InterruptedException is seen");
					}
					flag = datenodes.get(i).isEnabled();
					datenodes.get(i).click();
					break;
				}
				
				
					
					
				}
					
					
					
						
					}
		return flag3;
					
		}
		
		
		
	



		
	
		
	

	public void Instruction() 
	{
		TestUtil.ActionForMovetoElement(Instruction);
		Instruction.sendKeys("NA");

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
		
		DatePicker();
		//Instruction();
		/*String date1 = reader.getCellData("Stimulationchart", "OPUDate", 2);
		 * Calender.click();
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//td/button"));
		for (int i = 1; i < dates.size(); i++) 
		{
			String date2 = reader.getCellData("CycleList", "Date", 2);
			String Datetext = dates.get(i).getText();
			boolean flag =  dates.get(i).isEnabled();
			String arr[] = date1.split("-");
			String day = arr[0];
			
			WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
			String text= Monthtextele.getText();
			String Arr[]=text.split(" ");
			String Monthtext = Arr[0]; 
			
			String CyrrentDate=TestUtil.Date();
			String[] Arr1= CyrrentDate.split(",");
			String day1= Arr1[0];
			String Month = Arr1[1];
			
		
			boolean flag1= dates.get(i).isEnabled();
			int rows1 = 0;
			rows1++;
			
			if(day1.equals(Datetext)&&flag1==true&&Monthtext.equals(Month))
			{
				dates.get(i).click();
				break;
			}
				
				
				
			}*/
		
		
	
	}
		
	public  String SaveOPUsubtypeICSI() 
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
		
		
	
	public   String ARTCycleAvailabilityMessageBeforeSave() 
	{
			String Name = reader.getCellData("Investigation", "Search", 2);
			Searchbox.sendKeys(Name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) 
			{
				System.out.println("The InterruptedException is occured");
			}
			Searchbox.sendKeys(Keys.BACK_SPACE);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1)
			{
				System.out.println("The InterruptedException is occured");
			}
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
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					System.out.println("The InterruptedException is occured");
				}
				msg = Availabilitymessage.getText();
			}
			else
			{
				msg = "cyclenotfound";
			
			}
			return msg;
			
			
		}
		
		
		

	public  String ClickOnCycle() 
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
		
		}
		return msg;
		
		
		
	}
	public CycleListPage ClickonCycleOption()
	{
		Actions act = new Actions(driver);
		act.moveToElement(Cycleoption).click().perform();
		return new CycleListPage();
	}
	
	
	
	
	public boolean CycleCodeAvaibility()
	{
		List<WebElement>cyclecode1 =  driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a"));
		int size = cyclecode1.size();
		boolean flag=false;
		if(size<0)
		{
			flag=true;
		}
		else
		{
			flag= false;
		}
		return flag;
	}
	
	
	
	public boolean CycleAvailability()
	{
		
		ClickonCycleOption();
		boolean flag = CycleCodeAvaibility();

	if(flag==true)
	{
		
		EMRDashBoardPage EMRPage = new EMRDashBoardPage();
		 EMRPage.ClickOnInvestigation();
		TestUtil.ActionForMovetoElement(Cycles);
		Cycles.click();
		
	}
	else
	{
		
		// flag= cyclecode.isDisplayed();
		EMRDashBoardPage EMRPage = new EMRDashBoardPage();
		 EMRPage.ClickOnInvestigation();
		 TestUtil.ActionForMovetoElement(Cycles);
			Cycles.click();
	}
		
		
		
		return flag;
		
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
		//act.moveToElement(Cycles).click().perform();
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
	
	public String DeleteThePackage()
	{
		boolean existingpackage =Existingcycle();// if there is already available cycle saved this option become true.
		boolean cycleavaiability = CycleAvailability();
		if(existingpackage==true&&cycleavaiability==true)
		{
			Delete.click();
			Deletetext.sendKeys("NA");
			SaveDeletediailog.click();
					
			try 
			{
				Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				System.out.println("The InterruptedException is occured");
			}
			try{
				msg = msgagainstcycle.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Alreadyexistflashmsg is not seen within 20 sec");
			}
			msg = "Cycle is created against this package,You can not delete package.";
		
		}
		else if(existingpackage==true&&cycleavaiability==false)
		{
			Delete.click();
			Deletetext.sendKeys("NA");
			SaveDeletediailog.click();
			msg= DeleteMessage.getText();
			
		}
		return msg;
	
	}
	
	public void ClickonCycles()
	{
		try
		{
		TestUtil.VisibleOn(driver, Cycles, 30);
		TestUtil.ActionForMovetoElement(Cycles);
		}
		catch (Exception e)
		{
			System.out.println("Timeout exception seen");
		}
		Cycles.click();
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
	
	
	public boolean AlreadySavedCycle() 
	{	
		try
		{
			TestUtil.VisibleOn(driver, Cycles, 30);
		TestUtil.ActionForMovetoElement(Cycles);
		}
		catch(Exception e)
		{
			System.out.println("Element-Cycles is not seen within 30 sec");
		}
		//Cycles.click();
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", Cycles);*/
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
		//System.out.println("checkbox is displayed" + checboxpreviousprocedure.isDisplayed()+"and enabled" +  checboxpreviousprocedure.isEnabled());
		Actions act = new Actions(driver);
		act.moveToElement(checboxpreviousprocedure).click().perform();
		act.moveToElement(Add).click().perform();
		Save.click();
		msg = msgSaveafteradd.getText();
		
		
		return msg;
		
	}
	public boolean DeleteTheservice()
	{
		Delete.click();
		
		
		boolean flag=true;
				
		
		return flag;
	}
	
	
	
	public String MessageforAlreadtyavailableCyclebothtrue() 
	{
		boolean flag1= AlreadySavedCycle();
		boolean flag2= Existingcycle();
		if(flag1==true&&flag2==true)
		{
			SearchThecycles();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				System.out.println("The InterruptedException is occured");
			}
			try
			{
				Existingcyclemsg.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Existingcyclemsg is not found");
			}
			finally
			{
				msg = "Close existing cycle first.";
			}
			
		}
		else if(flag2==true&&flag1 ==false)
		{
			SearchThecycles();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				System.out.println("The InterruptedException is occured");
			}
			try{
				Existingcyclemsg.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element is not found");
			}
			msg = "Close existing cycle first.";
			
		}
			
		return msg;
		
	}
	
	public String MessageForAvaibility()
	{
		boolean flag1= AlreadySavedCycle();
		boolean flag2= Existingcycle();
		if(flag1==false&& flag2==false)
		{
			Save.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				System.out.println("The InterruptedException is occured");
			}
			try{
				msg = Addservice.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Alreadyexistflashmsg is not seen within 20 sec");
			}
			msg = "Add atleast 1 service.";
			
		
		}
		else if(flag1==true&&flag2==true)
		{
			SearchThecycles();
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e1)
			{
				System.out.println("Element-Alreadyexistflashmsg is not seen within 20 sec");
			}
			try
			{
				Existingcyclemsg.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Existingcyclemsg is not found");
			}
			msg = "Close existing cycle first.";
			
			
		}
		else if(flag1==false&&flag2==true)
		{
			SearchThecycles();
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e1)
			{
				System.out.println("Element-Alreadyexistflashmsg is not seen within 20 sec");
			}
			try
			{
				Alreadyexistflashmsg.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Alreadyexistflashmsg is not found");
			}
			msg = "You can add only one cycle for same visit.";
			
		}
		else if(flag1==true&&flag2==false)
		{
			SearchThecycles();
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e1)
			{
				System.out.println("Element-Alreadyexistflashmsg is not seen within 20 sec");
			}
			try
			{
				Existingcyclemsg.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Existingcyclemsg is not found");
			}
			msg = "Close existing cycle first.";
		}
		return msg;
		
	}
	public String AddOneServiceAtleastMessage()
	{
		Actions act = new Actions(driver);
		act.moveToElement(Cycles).click().perform();
		Save.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				System.out.println("The InterruptedException is occured");
			}
			try{
				msg = Addservice.getText();
			}
			catch( Exception e)
			{
				System.out.println("Element-Alreadyexistflashmsg is not seen within 20 sec");
			}
			msg = "Add atleast 1 service.";
		return msg;
		
	}
	

		
	

 }

