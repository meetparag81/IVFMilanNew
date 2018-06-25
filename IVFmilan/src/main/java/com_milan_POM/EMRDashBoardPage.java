package com_milan_POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class EMRDashBoardPage extends TestBase {
	private @FindBy(xpath = "//a[@id='menuField_women']") WebElement womenfield;
	private @FindBy(xpath = "//a[@id='menuField_men']") WebElement menfield;
	private @FindBy(xpath = "//*[@id='0']") WebElement visitwomen;
	private @FindBy(xpath = "//a[@class='icoLink femaleHistory'][@title='History']") WebElement Historylinkwomen;
	private @FindBy(xpath = "//a[@class='icoLink maleHistory'][@title='History']") WebElement Historylinkmen;
	private @FindBy(xpath = "//a[@class='icoLink femaleDiagnosis'][@title='Diagnosis']") WebElement FemaleDiagnosis;
	private @FindBy(xpath = "//a[@class='icoLink femaleComplaints']") WebElement Femalecomplaints;
	private @FindBy(xpath = "//a[@class='icoLink femaleVitals']") WebElement WVitals;
	private @FindBy(xpath = "(//a[@title='Diagnosis'])[2]") WebElement MaleDiagnosis;
	private @FindBy(xpath = "//input[@id='0']") WebElement visitmen;
	private static @FindBy(xpath = "//span[@class='icon-screen ng-binding']") WebElement TitleEMR;
	private static @FindBy(xpath = "//span[contains (text(), 'History')]") WebElement TitleHistory;
	private @FindBy(xpath = "//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[2]") WebElement Sexualhistory;
	private @FindBy(xpath = "(//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input[@type='checkbox'])[1]") WebElement visitw;
	private @FindBy(xpath = "/html/body/div[1]/div/div/div/table/tbody//tr/td//input[@id='0']") WebElement checkboxvisitm;
	private @FindBy(xpath = "//a[@class='icoLink femaleInvestigations'][@title='Investigations']") WebElement Investigation;
	private @FindBy(xpath = "//a[@class='active_white_color']") WebElement Cycleoption;
	private @FindBy(xpath="//span[@class='icon-screen ng-binding']")WebElement Complainttext;
	WebDriverWait wait = new WebDriverWait(driver, 50);

	public EMRDashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	public WomenHistoryPage clickOnWomenField() 
	{

		if (womenfield.isDisplayed()) {
			TestUtil.VisibleOn(driver, womenfield, 10);
			Actions act = new Actions(driver);
			act.moveToElement(womenfield).click().perform();
			// womenfield.click();
			try {
				TestUtil.VisibleOn(driver, Historylinkwomen, 20);
			} catch (TimeoutException e) {
				System.out.println("element is not seen within the time");
			}

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			// jse.executeScript("arguments[0].scrollIntoView()",
			// Historylinkwomen);
			Actions act1 = new Actions(driver);
			act1.moveToElement(Historylinkwomen).click().perform();

			// System.out.println("Womenfieldis displayed");
			List<WebElement> visitw = driver.findElements(By
					.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
			if (visitw.size() != 0) {
				// System.out.println("Visitcount" + visitw.size());
				// Thread.sleep(3000);
				TestUtil.VisibleElementsOn(driver, visitw, 30);
				visitw.get(0).click();
				System.out.println("Women visit cliked");
			} else {

				System.out.println("Visit  not available");

			}
			/*
			 * TestUtil.VisibleOn(driver, visitw,30); Historylinkwomen.click();
			 * TestUtil.VisibleOn(driver, womenfield, 30); visitw.click();
			 */
			// visitwomen.click();
			// System.out.println("Women visit cliked");
		} else {
			System.out.println("WomenHistory not foung");
		}
		return new WomenHistoryPage();

	}

	public String TitleHistoryPage() {
		TestUtil.VisibleOn(driver, TitleHistory, 20);
		String Title = TitleHistory.getText();
		return Title;

	}

	public MenHistoryPage clickOnMenField() 
	{
		try {
			TestUtil.VisibleOn(driver, menfield, 20);
		} catch (TimeoutException e) {
			System.out.println("menfield is not displayed within 20 sec");
		}
		if (menfield.isDisplayed()) {
			TestUtil.VisibleOn(driver, menfield, 20);
			menfield.click();
			TestUtil.VisibleOn(driver, Historylinkmen, 20);
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("arguments[0].scrollIntoView()", Historylinkmen);
			Historylinkmen.click();
			// System.out.println(" Clicked onMen History");
			List<WebElement> visitm = driver.findElements(By
					.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
			if (visitm.size() != 0) {
				// System.out.println("Visitcount" + visitm.size());
				TestUtil.VisibleElementsOn(driver, visitm, 30);
				visitm.get(0).click();
				System.out.println("Men visit cliked");
			} else {

				return new MenHistoryPage();

			}

		} else {
			String Title = TitleEMR.getText();
		}
		return new MenHistoryPage();

	}

	public FemaleDiagnosisPage ClickOnDiagnosis() 
	{
		TestUtil.VisibleOn(driver, womenfield, 20);
		Actions act = new Actions(driver);
		act.moveToElement(womenfield).click().perform();
		// TestUtil.VisibleOn(driver, FemaleDiagnosis, 30);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("Thread.sleep value should be decreased");
		}
		FemaleDiagnosis.click();
		List<WebElement> visitm = driver.findElements(
				By.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
		if (visitm.size() != 0) {
			// System.out.println("Visitcount" + visitm.size());
			TestUtil.VisibleElementsOn(driver, visitm, 30);
			visitm.get(0).click();
			System.out.println("Dignosis visit cliked");

		} else {

			System.out.println("diagnosis is not available");

		}
		return new FemaleDiagnosisPage();

	}

	public WComplaintsPage ClickOnComplaints()
	{
		try {
			TestUtil.VisibleOn(driver, womenfield, 10);
		} catch (TimeoutException e) {
			System.out.println("elementisnotseen within 20 sec");
		}
		Actions act = new Actions(driver);
		act.moveToElement(womenfield).click().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) 
		{
			System.out.println("Thread.sleep value should be decreased");
		}
		if(Femalecomplaints.isDisplayed())
		{
			Actions act1 = new Actions(driver);
			act1.moveToElement(Femalecomplaints).click().perform();
		}
		else
		{
		try
		{
		TestUtil.VisibleOn(driver, Femalecomplaints, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Femalecomplaints is not seen within 30 sec");
		}		
		Actions act1 = new Actions(driver);
		act1.moveToElement(Femalecomplaints).click().perform();
			
		
		List<WebElement> visitm = driver.findElements(By.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
		if (visitm.size() != 0) 
		{
			try 
			{
				TestUtil.VisibleElementsOn(driver, visitm, 10);
			} 
			catch (TimeoutException e) 
			{
				System.out.println("visitm-complaints are not seen within 10 sec");
			}
			visitm.get(1).click();
		}
		else 
		{
			return new WComplaintsPage();
		}

		
		}
		return new WComplaintsPage();
	}

	public WVitalsPage ClickOnVitals() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, womenfield, 20);
		} catch (TimeoutException e) {
			System.out.println("Element is not seen with in 20 sec");
		}
		Actions act = new Actions(driver);
		act.moveToElement(womenfield).click().perform();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Thread.sleep time should be increased");
		}
		Actions act1 = new Actions(driver);
		act1.moveToElement(WVitals).click().perform();
		List<WebElement> visitm = driver.findElements(By.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
		if (visitm.size() != 0)
		{
			System.out.println("Visitcount" + visitm.size());
			TestUtil.VisibleElementsOn(driver, visitm, 30);
			visitm.get(0).click();
			System.out.println("Vitals visit cliked");

		} 
		else 
		{

			System.out.println("Vitals visits are not available");

		}
		return new WVitalsPage();
	}

	public WInvestigationPage ClickOnInvestigation() 
	{
		try {
			TestUtil.VisibleOn(driver, womenfield, 20);
		} catch (TimeoutException e) {
			System.out.println("Element- womenfield is not seen with in 20 sec");
			
		}
		Actions act1 = new Actions(driver);
		act1.moveToElement(womenfield).click().perform();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Element-Investigation is not seen with in 20 sec");
		}
		Actions act = new Actions(driver);
		act.moveToElement(Investigation).click().perform();

		// TestUtil.VisibleOn(driver, Investigation, 20);
		// JavascriptExecutor jse = (JavascriptExecutor)driver;

		// jse.executeScript("arguments[0].scrollIntoView()", Investigation);
		// Investigation.click();
		

		return new WInvestigationPage();
	}

	public String GetEmrTitle() 
	{
		String Title = TitleEMR.getText();

		return Title;
	}

	public boolean GetEnableconditionMenfield() 
	{
		menfield.isDisplayed();

		return false;

	}

	public boolean GetGetEnableconditionWoMenfield() 
	{
		womenfield.isDisplayed();
		return false;

	}

	public CycleListPage ClickonCycle() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(Cycleoption).click().perform();
		// Cycleoption.click();
		return new CycleListPage();

	}
	public String ComplaintText()
	{
		String msg = Complainttext.getText();
		return msg;
		
	}

}
