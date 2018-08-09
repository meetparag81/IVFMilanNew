package com_milan_POM;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class SearchPage extends TestBase {
	@FindBy(id = "patientBtn")
	private WebElement Patient;
	@FindBy(xpath = "//input[@name = 'txtUsrName']")
	private WebElement Searchbox1;
	@FindBy(xpath = "//ul[@class='dropdown-menu ng-isolate-scope crx_mouse_visited']")
	WebElement Searchbox;
	@FindBy(xpath = "//a[@id='patientDashboard']")
	WebElement title;
	@FindBy(xpath = "//span[text()='EMR Dashboard']")
	WebElement EMRTitle;
	@FindBy(id = "patientBtn")
	WebElement Paitent;
	@FindBy(xpath = "//*[@id='patientDashboard']")
	WebElement Dashboard;
	@FindBy(xpath = "//span[contains (text(), 'EMR Dashboard')]")
	WebElement Title;
	@FindBy(xpath = "//span[text() = 'Total Count :']//following::span")
	WebElement SizeOfPaitent;
	@FindBy(xpath = "//span[text()='EMR Dashboard']")
	WebElement Dashboardtitle;
	@FindBy(xpath = "//input[@id='0']")
	WebElement checkbox;
	@FindBy(xpath = "//span[text()='Queue Management']//following::i[3]")
	WebElement calender;
	@FindBy(xpath = "//span[text()='Queue Management']//following::input[2]")
	WebElement searchpaient;
	@FindBy(xpath = "(//button[text()='Search'])[1]")
	WebElement Searchbutton;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")
	WebElement QueueManagement;
	WebDriverWait wait = new WebDriverWait(driver, 50);
	Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");

	public SearchPage() {

		PageFactory.initElements(driver, this);
	}

	public EMRDashBoardPage searchPaient() 
	{
		WebElement Patient1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='patientBtn']")));
		try
		{
		TestUtil.VisibleOn(driver, Patient1, 50);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
		// Paitent = wait.until(ExpectedConditions.visibilityOf(Patient));

		Patient1.click();
		int Rowcount = reader.getRowCount("HomePage");

		String PatientName = reader.getCellData("HomePage", "PatientName", 7);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			System.out.println("The InterruptedException is occured");
		}
		Searchbox1.sendKeys(PatientName);
		try
		{
		TestUtil.VisibleOn(driver, Searchbox1, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
		Searchbox1.sendKeys(Keys.BACK_SPACE);
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		Searchbox1.sendKeys("");
		List<WebElement> search = driver.findElements(By.xpath("//ul[@role='listbox']//li/a"));

		System.out.println("totalsearch" + search.size());
		for (int i = 0; i < search.size(); i++) 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				System.out.println("The InterruptedException is occured");
			}

			search.get(i).click();
			break;

		}
		List<WebElement> visit = driver.findElements(By.xpath("//table[@class='table table-hover table-striped selectPatient_item']//tr//input"));
		int visitsize = visit.size();
		if(visitsize!=0)
		{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try
		{
		TestUtil.VisibleOn(driver, checkbox, 20);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
		executor.executeScript("arguments[0].click();", checkbox);
		}
		else
		{
			return new EMRDashBoardPage();
		}
		return new EMRDashBoardPage();

	}

	public String Dahboardtitle() {
		WebElement Dashboard = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='EMR Dashboard']")));
		String Title = Dashboard.getText();
		return Title;
	}

	public EMRDashBoardPage SearchusingCalender()
	{
		WebElement Calender = wait.until(ExpectedConditions	.visibilityOfElementLocated(By.xpath("//span[text()='Queue Management']//following::i[3]")));
		try
		{
		TestUtil.VisibleOn(driver, Calender, 20);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
		Calender.click();
		List<WebElement> dates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//tbody//td")));

		int Total_nodes = dates.size();
		for (int i = 0; i < Total_nodes; i++) 
		{
			String date = dates.get(i).getText();
			if (date.equals("05")) 
			{
				dates.get(i).click();
				break;
			}

		}
		String Paitentname = reader.getCellData("HomePage", 0, 15);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) 
		{
			System.out.println("The InterruptedException is occured");
		}
		searchpaient.sendKeys(Paitentname);
		try
		{
		TestUtil.VisibleOn(driver, Searchbutton, 20);
		}
		catch(Exception e)
		{
		System.out.println("Element is not seen within time");
		
		}
		if(Searchbutton.isDisplayed()&&Searchbutton.isEnabled())
		{
		Searchbutton.click();
		}
		
		int k = 1;
		while (k <= 10) 
		{
			try {
				Thread.sleep(3000);
			} 
			catch (InterruptedException e1)
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
				System.out.println("Nameofpatient is not seen on dashboard within 30 secs");
			}
					
			String name1 = Nameofpatient.getText();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) 
			{
				System.out.println("The InterruptedException is occured");
			}
			if (name1.contains(Paitentname)) 
			{
				// Thread.sleep(4000);
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

	public String QueueManagementpage() {
		String Title = EMRTitle.getText();
		return Title;

	}

}