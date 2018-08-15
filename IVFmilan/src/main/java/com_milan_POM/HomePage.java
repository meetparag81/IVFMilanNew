package com_milan_POM;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;


public class HomePage extends TestBase {
	private @FindBy (xpath="//a[@id='patientBtn']")WebElement Patient;
	private @FindBy(xpath = "//input[@id='txtfullName']") WebElement Searchbox1;
	private @FindBy(xpath = "//ul[@class='dropdown-menu ng-isolate-scope crx_mouse_visited']") WebElement Searchbox;
	private @FindBy(xpath = "//h5[text()='Prescription']") WebElement title;
	private @FindBy(xpath = "//span[text()='EMR Dashboard']") WebElement EMRTitle;
	private @FindBy(id = "patientBtn") WebElement Paitent;
	private @FindBy(xpath = "//*[@id='patientDashboard']") WebElement Dashboard;
	private @FindBy(xpath = "//span[contains (text(), 'EMR Dashboard')]") WebElement Title;
	private @FindBy(xpath = "//span[text() = 'Total Count :']//following::span") WebElement SizeOfPaitent;
	private @FindBy(xpath = "(//input[@type='checkbox'])[1]") WebElement checkbox;
	private @FindBy(xpath = "//span[text()='EMR Dashboard']") WebElement Dashboardtitle;
	private @FindBy(xpath = "//span[text()='Queue Management']//following::i[3]") WebElement calender;
	private @FindBy(xpath = "//span[text()='Queue Management']//following::input[2]") WebElement searchpaient;
	private @FindBy(xpath = "//button[text()='Search'][@ class='btn btn-primary']") WebElement Searchbutton;
	private @FindBy(xpath="//li[@class='navCycles ng-scope active']")WebElement Queue;
	private @FindBy(xpath = "//a[@class='dropdown-toggle'][text()='Registration']" )WebElement Registration;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	boolean flag;	

	public HomePage() 
	{

		PageFactory.initElements(driver, this);
	}

	public int PatientDataCreation() 
	{
		int k = 1;
		int rows = 2;
		while (k <= 10) {

			//// div[@id='tableToExport']/table/tbody/tr["+ k
			//// +"]/td[4]/text()-Invalid x path is shown.
			// WebElement rowcount =
			//// driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+
			//// k +"]/td[4]/text()"));
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				System.out.println("The thread.sleep value should be increased");
			}
			List<WebElement> rows2 = driver
					.findElements(By.xpath("//table[@class='table table-hover table-striped']/tbody/tr/td[4]/text()"));
			WebElement rows1 = driver.findElement(
					By.xpath("//table[@class='table table-hover table-striped']/tbody/tr[" + k + "]/td[4]/text()"));
			try
			{
			TestUtil.VisibleOn(driver, rows1, 30);
			}
			catch(Exception e)
			{
				System.out.println("TimeoutExceptionseen");
			}
			String name2 = rows1.getText();
			reader.setCellData("HomePage", "PatientName", rows, name2);
			k++;
			rows++;

		}
		return rows;

	}

	public String EMRPageTitle()

	{
		title = driver.findElement(By.xpath("//h5[text()='Prescription']"));
		try
		{
			TestUtil.VisibleOn(driver, title, 20);
		}
		catch(Exception e)
		{
			System.out.println("Element-title is not seen within 20 sec");
		}
		return Title.getText();
	}

	public String Homepagetitle()
	{
		// System.out.println("========Homepagetitle testcase started======");
		String msg = driver.getTitle();
		return msg;

	}

	public EMRDashBoardPage ClickonEMR() 
	{
		// System.out.println("========EMR click testcase started======");
		int i = 1;
		int j = 1;
		int size = 0;

		try {
			TestUtil.VisibleOn(driver, SizeOfPaitent, 20);
		}
		catch(Exception e)
		{
			System.out.println("Element-SizeOfPaitent is not seen with in 20 sec");
		}
		String s = SizeOfPaitent.getText();
		try
		{
		size = Integer.parseInt(s);
		}
		catch (NumberFormatException e) 
		{
			 System.out.println("String is not converted into integer number");
		System.out.println("Patient size is" + size);
		
		} 
		finally
		{
			
		}

		for (i = 1; i <= 125; i++) {
			if (j <= 10) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) 
				{
					System.out.println("The thread.sleep value should be increased");
				}
				WebElement rowcount = driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr[" + j + "]/td[4]"));
				String name1 = rowcount.getText();

				// System.out.println(name1+ i+ j);

				String PatientName = reader.getCellData("HomePage", "PatientName", 17);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) 
				{
					System.out.println("The thread.sleep value should be increased");
				}
				if (name1.contains(PatientName))

				{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) 
					{
						System.out.println("The thread.sleep value should be increased");
					}
					driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr[" + j + "]/td[1]/a[2]")).click();
					// System.out.println("click on EMR ");
					i = 122;
					//System.out.println("===========recodfound==============");
					break;

				}

				j++;
			} else {
				j = 1;

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				// jse.executeScript("scroll(0, 250)");
				WebElement element = driver.findElement(By.xpath("//a[contains (text(), 'Next')]"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				System.out.println("=============clicked on next==========");

			}
		}

		return new EMRDashBoardPage();
	}
	
	public void Searchinput()
	{
		
		
	}

	public EMRDashBoardPage searchPaient()
	{
	
		try
		{			
		TestUtil.VisibleOn(driver, Paitent, 20);
		TestUtil.ActionForMovetoElement(Paitent);
		}
		catch(Exception e)
		{
			System.out.println("element is not seen within time");
		}
		Paitent.click();
		
		int Rowcount = reader.getRowCount("HomePage");
		String PatientName = reader.getCellData("HomePage", "PatientName", 7);
List<WebElement>Radiobutton=driver.findElements(By.xpath("//input[@type='radio']"));
int radiobuttons= Radiobutton.size();
int rows=2;
for(int i=1;i<radiobuttons;i++)
{
	
	
	WebElement buttonsname = driver.findElement(By.xpath("//div[@id='dropdown_menu']/div/div[1]/label["+i+"]"));
	String name= buttonsname.getText();
	
	String radionames=reader.getCellData("HomePage", "RadioButtons",rows);
	rows++;
	if(name.equals(radionames))
		{
			Radiobutton.get(i).click();
			break;
						
		}
	else
	{
		Radiobutton.get(2).click();
		break;
	}		
		
		
	}
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e1) 
		{
		System.out.println("Element-Searchbox1 is not ssen within20 secs");	
		}
		Searchbox1.sendKeys(PatientName);
		try
		{
		TestUtil.VisibleOn(driver, Searchbox1, 20);
		}
		catch(Exception e)
		{
			System.out.println("Element not seen with in 20 sec");
		}
		Searchbox1.sendKeys(Keys.BACK_SPACE);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1)
		{
			System.out.println("InterruptedException is seen");
		}
		Searchbox1.sendKeys("");
		List<WebElement> search = driver.findElements(By.xpath("//ul[@role='listbox']//li/a"));
		if(search.size()<=0)
		{
			
			Searchbox1.clear();
			Searchbox1.sendKeys(PatientName);
			Searchbox1.sendKeys(Keys.BACK_SPACE);
			
		}
		else
		{
			Searchbox1.sendKeys(Keys.BACK_SPACE);
		}

		
		for (int i =0; i < search.size();) 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				System.out.println("Thread.sleep value should be reduced");
			}
			String name = search.get(i).getText();
			if(PatientName.equals(name))
			{
			Actions act = new Actions(driver);
			act.moveToElement(search.get(i)).click().perform();
			break;
			}
			 else 
			 {
				 search.get(i).click();
				 break;
			 }
		
		}
		try
		{
			 flag=checkbox.isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("Element- checkbox is not displayed");
		}
		if(flag==true)
		{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try
		{
		TestUtil.VisibleOn(driver, checkbox, 20);
		}
		catch(Exception e)
		{
			System.out.println("element-checkbox not seen within 20 seconds");
		}
		TestUtil.ActionForMovetoElement(checkbox);
		checkbox.click();
		
		}
		else
		{
			return new EMRDashBoardPage();
		}
		return new EMRDashBoardPage();
		
		

	}

	public String Dahboardtitle() 
	{

		String Title = Dashboardtitle.getText();
		return Title;
	}

	public EMRDashBoardPage SearchusingCalender()  
	{
		WebElement Calender = driver.findElement(By.xpath("//span[text()='Queue Management']//following::i[3]"));
		try
		{
		TestUtil.VisibleOn(driver, Calender, 40);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
		Calender.click();
		List<WebElement> dates = driver.findElements(By.xpath("//table[@role='grid']//tbody//td"));
		try
		{
			TestUtil.VisibleElementsOn(driver, dates, 20);
		}
		catch(Exception e)
		{
			System.out.println("Element-Dates is not seen within 20 sec");
		}

		int Total_nodes = dates.size();
		for (int i = 0; i < Total_nodes; i++) 
		{
			String date = dates.get(i).getText();
			if (date.equals("08")) 
			{
				dates.get(i).click();
				break;
			}

		}
		String SendPaitentname = reader.getCellData("HomePage", 0, 8);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		searchpaient.sendKeys(SendPaitentname);
		try
		{
		TestUtil.VisibleOn(driver, Searchbutton, 20);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
		Searchbutton.click();
		int k = 1;
		while (k <= 10) 
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) 
			{
				System.out.println("The InterruptedException is occured");
			}
			WebElement Nameofpatient = driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tr[" + k + "]/td[4]"));
			try
			{
			TestUtil.VisibleOn(driver, Nameofpatient, 30);
			}
			catch(Exception e)
			{
				System.out.println("TimeoutExceptionseen");
			}
			String name1 = Nameofpatient.getText();
			String name2= name1.substring(0,10);
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) 
			{
				System.out.println("The InterruptedException is occured");
			}
			String Paitentname = reader.getCellData("HomePage", 0, 16);
			if (name2.contains(Paitentname)) 
			{
				 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) 
				 {
					System.out.println("The InterruptedException is occured");
				}
				WebElement EMR = driver.findElement(By.xpath(("//div[@id='tableToExport']/table/tbody/tr[" + k + "]/td[1]/a[2]")));
				try
				{
					TestUtil.VisibleOn(driver, EMR, 20);
				}
				catch(Exception e)
				{
					System.out.println("Element-EMR is not seen within 20 sec");
				}
				EMR.click();
				/*System.out.println("click on EMR ");

				System.out.println("===========recodfound==============");*/
				break;
			}
			k++;

		}
		return new EMRDashBoardPage();
	}
}
