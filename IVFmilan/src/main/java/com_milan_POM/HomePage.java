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
	WebDriverWait wait = new WebDriverWait(driver, 50);
	Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public int PatientDataCreation() throws Exception {
		int k = 1;
		int rows = 2;
		while (k <= 10) {

			//// div[@id='tableToExport']/table/tbody/tr["+ k
			//// +"]/td[4]/text()-Invalid x path is shown.
			// WebElement rowcount =
			//// driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+
			//// k +"]/td[4]/text()"));
			
			Thread.sleep(5000);
			List<WebElement> rows2 = driver
					.findElements(By.xpath("//table[@class='table table-hover table-striped']/tbody/tr/td[4]/text()"));
			WebElement rows1 = driver.findElement(
					By.xpath("//table[@class='table table-hover table-striped']/tbody/tr[" + k + "]/td[4]/text()"));
			TestUtil.VisibleOn(driver, rows1, 30);
			String name2 = rows1.getText();
			reader.setCellData("HomePage", "PatientName", rows, name2);
			k++;
			rows++;

		}
		return rows;

	}

	public String EMRPageTitle()

	{
		title = wait.until(ExpectedConditions.visibilityOf(title));
		return Title.getText();
	}

	public String Homepagetitle()
	{
		// System.out.println("========Homepagetitle testcase started======");
		String msg = driver.getTitle();
		return msg;

	}

	public EMRDashBoardPage ClickonEMR() throws Exception {
		// System.out.println("========EMR click testcase started======");
		int i = 1;
		int j = 1;
		int size = 0;

		try {
			wait.until(ExpectedConditions.visibilityOf(SizeOfPaitent));
			String s = SizeOfPaitent.getText();
			size = Integer.parseInt(s);
			System.out.println("Patient size is" + size);
		} catch (NumberFormatException e) {
			 System.out.println("String is not converted into integer number");
		} finally {
			// System. out. println( "finally block executed") ;
		}

		for (i = 1; i <= 125; i++) {
			if (j <= 10) {
				Thread.sleep(3000);
				WebElement rowcount = driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr[" + j + "]/td[4]"));
				String name1 = rowcount.getText();

				// System.out.println(name1+ i+ j);

				String PatientName = reader.getCellData("HomePage", "PatientName", 16);
				Thread.sleep(3000);
				if (name1.contains(PatientName))

				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr[" + j + "]/td[1]/a[2]")).click();
					// System.out.println("click on EMR ");
					i = 122;
					System.out.println("===========recodfound==============");
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

	public EMRDashBoardPage searchPaient() throws Exception 
	{
		try
		{			
		//WebElement Patient1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='patientBtn']")));
		TestUtil.VisibleOn(driver, Paitent, 20);
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
	
	
	WebElement buttonsname = driver.findElement(By.xpath("//*[@id='dropdown_menu']/div/div[1]/label["+i+"]"));
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
		Thread.sleep(2000);
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
		Thread.sleep(1000);
		Searchbox1.sendKeys("");
		List<WebElement> search = driver.findElements(By.xpath("//ul[@role='listbox']//li/a"));
		if(search.containsAll(search))
		{
			Searchbox1.sendKeys(Keys.BACK_SPACE);
		}

		//System.out.println("totalsearch" + search.size());
		// search.get(0).click();
		for (int i = 0; i < search.size(); i++) 
		{
			Thread.sleep(1000);
			// String name = search.get(i).getText();
			/*Actions act = new Actions(driver);
			act.moveToElement(search.get(i)).click().perform();*/
			search.get(i).click();
			break;
			
		}
		//if(checkbox.isDisplayed())
		//{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try
		{
		TestUtil.VisibleOn(driver, checkbox, 20);
		}
		catch(Exception e)
		{
			System.out.println("element not seen within20 seconds");
		}
		Actions sct = new Actions(driver);
		sct.moveToElement(checkbox).click().perform();
		//executor.executeScript("arguments[0].click();", checkbox);
		
		//}
		//else
		//{
			//return new EMRDashBoardPage();
		//}
		
		/*
		 * List<WebElement>visits
		 * =driver.findElements(By.xpath("//tbody//input[@type='checkbox']"));
		 * 
		 * System.out.println("visits Rows are" + visits.size());
		 * //input[@id='0'] if( visits.size()!=0) {
		 * 
		 * Thread.sleep(3000); visits.get(0).click();
		 * System.out.println(("clickoncheckbox"));
		 * 
		 * } else { System.out.println("no visits found");
		 */
		//System.out.println("Searchtestcompleted");
		return new EMRDashBoardPage();

	}

	public String Dahboardtitle() 
	{

		String Title = Dashboardtitle.getText();
		return Title;
	}

	public EMRDashBoardPage SearchusingCalender() throws Exception 
	{
		WebElement Calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Queue Management']//following::i[3]")));
		TestUtil.VisibleOn(driver, Calender, 40);
		Calender.click();
		List<WebElement> dates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//tbody//td")));

		int Total_nodes = dates.size();
		for (int i = 0; i < Total_nodes; i++) 
		{
			String date = dates.get(i).getText();
			if (date.equals("01")) 
			{
				dates.get(i).click();
				break;
			}

		}
		String SendPaitentname = reader.getCellData("HomePage", 0, 8);
		Thread.sleep(3000);
		searchpaient.sendKeys(SendPaitentname);
		TestUtil.VisibleOn(driver, Searchbutton, 20);
		Searchbutton.click();
		int k = 1;
		while (k <= 10) 
		{
			Thread.sleep(3000);
			WebElement Nameofpatient = driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tr[" + k + "]/td[4]"));
			TestUtil.VisibleOn(driver, Nameofpatient, 30);
			String name1 = Nameofpatient.getText();
			Thread.sleep(4000);
			String Paitentname = reader.getCellData("HomePage", 0, 15);
			if (name1.contains(Paitentname)) 
			{
				 Thread.sleep(2000);
				WebElement EMR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@id='tableToExport']/table/tbody/tr[" + k + "]/td[1]/a[2]"))));
				EMR.click();
				System.out.println("click on EMR ");

				System.out.println("===========recodfound==============");
				break;
			}
			k++;

		}
		return new EMRDashBoardPage();
	}
}
