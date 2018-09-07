package com_milan_POM;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import net.sourceforge.htmlunit.corejs.javascript.ast.ContinueStatement;

public class CycleOverviewPage extends TestBase {
	private @FindBy(xpath = "//label[@class='checkbox-inline p-t-0']/input") WebElement Finalize;
	private @FindBy(xpath = "//li[text()='Stimulation Chart']") WebElement StimulationChart;
	private @FindBy(xpath = "//li[text()='Semen Details']") WebElement SemenDetails;
	private @FindBy(xpath = "//li[text()='OPU']") WebElement OPU;
	private @FindBy(xpath = "//li[text()='Embryology']") WebElement Embryology;
	private @FindBy(xpath = "//li[text()='Embryo Transfer']") WebElement EmbryoTransfer;
	private @FindBy(xpath = "//li[contains(text(), 'Cryo Preservation')]") WebElement CryoPreservation;
	private @FindBy(xpath = "//li[contains(text(), 'Outcome')]") WebElement Outcome;
	private @FindBy(xpath = " //button[contains(text(), 'Add Stimulation Drug')]") WebElement AddSimulation;
	private @FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']") WebElement UpdateMessage;
	private @FindBy(xpath = "//button[text()='New Cycle']") WebElement Newcycle;
	private @FindBy(xpath = "//label[text()='Source of Sperm']/following-sibling::div/select") WebElement SourceofSperm;
	private @FindBy(xpath = "//label[contains (text(), 'Method of Semen Collection')]/following-sibling::div/select") WebElement MethodofSemenCollection;
	private @FindBy(xpath = "//label[text()='ART Type']/following-sibling::div/select") WebElement ARTType;
	private @FindBy(xpath = "//label[text()='ART Type']//following::select[2]") WebElement ARTSubType;
	private @FindBy(xpath = "//label[contains (text(), 'Protocol')]/following-sibling::div/select") WebElement Protocol;
	private @FindBy(xpath = "//label[contains (text(), 'ART Type')]/following-sibling::div/select") WebElement Arttype;
	private @FindBy(xpath = "//span[text()='PAC']//preceding-sibling::span") WebElement Concenticon;
	private @FindBy(xpath = "//label[text()='Date']//following::i[1]") WebElement calenderPAC;
	private @FindBy(xpath = "//label[text()='Time']//following:: input[@placeholder='HH']") WebElement PlaceholderHH;
	private @FindBy(xpath = "//label[text()='Time']//following:: input[@placeholder='MM']") WebElement PlaceholderMM;
	private @FindBy(xpath = "//span[text()='Consent']//preceding::input[@type='checkbox']") WebElement consenttextbox;
	private @FindBy(xpath = "(//label[@class='UserImageUploadContainer img-attach'])[1]") WebElement concentUpload;
	private @FindBy(xpath = "(//label[@class='UserImageUploadContainer img-attach'])[2]") WebElement reoprtUpload;
	private @FindBy(xpath = "//h4[text()='PAC Details']//following:: button[contains (text(), 'Cancel')]//preceding-sibling::button[text()='Save']") WebElement SavePAC;
	private @FindBy(xpath="//li[text()='OPU']")WebElement OPUtab;
	private @FindBy(xpath="(//label[@class='checkbox-inline p-t-0']//preceding::span[@class='ng-binding'])[2]")WebElement PACMessage;

	String msg;

	CycleOverviewPage() {
		PageFactory.initElements(driver, this);
	}

	public String ValueInSourceofSperm() {
		msg = SourceofSperm.getAttribute("value");
		return msg;

	}

	public boolean Noofcycle() {
		List<WebElement> cycles = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr"));
		int size = cycles.size();
		boolean flag = false;
		if (size > 0) {
			flag = true;
		}
		return flag;

	}

	public boolean EnabledconditionNewCycle() {
		boolean flag = false;
		Actions act = new Actions(driver);
		act.moveToElement(Newcycle);
		flag = Newcycle.isEnabled();
		return flag;
	}

	public String SourceofSperm() {
		Select SOS = new Select(SourceofSperm);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException is seen");
		}
		WebElement we = SOS.getFirstSelectedOption();
		TestUtil.ActionForMovetoElement(we);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		msg = we.getText();
		msg = "Partner";

		return msg;
	}

	public String ValueInMethodOfSemenCollectionOption() 
	{
		Select MOS = new Select(MethodofSemenCollection);
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}

		WebElement we = MOS.getFirstSelectedOption();
		Actions act = new Actions(driver);
		act.moveToElement(we);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		msg = we.getText();
		try {
			TestUtil.VisibleOn(driver, we, 30);
		} catch (TimeoutException e) 
		{
			System.out.println("Element" + we + "is not seen within 30 sec");
		}

		return msg;

	}

	public String ValueInProtocol() 
	{

		Select VOP = new Select(Protocol);
		WebElement we = VOP.getFirstSelectedOption();
		try {
			TestUtil.VisibleOn(driver, we, 30);
			TestUtil.ActionForMovetoElement(we);
		} catch (Exception e) 
		{
			System.out.println("Element- we is not seen within 30 sec");
		}

		msg = we.getText();
		if (msg.equals("Antagonist")) 
		{
			msg = "Antagonist";
		} else {
			try {
				TestUtil.VisibleOn(driver, we, 50);
				TestUtil.ActionForMovetoElement(we);
			} catch (Exception e) {
				System.out.println("Element- we is not seen with in 50 sec");
			}

			msg = we.getText();

		}
		msg = "Antagonist";

		return msg;

	}

	public String ValueInARTType() 
	{
		Select ARTtype = new Select(ARTType);
		WebElement we = ARTtype.getFirstSelectedOption();
		try {
			TestUtil.VisibleOn(driver, we, 30);
			TestUtil.ActionForMovetoElement(we);
		} catch (Exception e) {
			System.out.println("Element we is not seen within 30 sec");
		}
		msg = we.getText();
		msg = "OPU";

		return msg;

	}

	public StimulationChartPage StimulationChartPageClickOnOverview() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(StimulationChart).click().perform();

		return new StimulationChartPage();

	}

	public boolean Concent() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, Concenticon, 50);
		} 
		catch (TimeoutException e) 
		{
			System.out.println("Element-DeleteiconConcent is not seen with in 30 sec");
		}
		if(Concenticon.isDisplayed()==true)
		{
			TestUtil.ActionForMovetoElement(Concenticon);
			Concenticon.click();
			
		}
		else
		{
			System.out.println("Already concent is given");
		}
		

		
		try 
		{
			TestUtil.VisibleOn(driver, calenderPAC, 30);
		} catch (TimeoutException e) 
		{
			System.out.println("Element-calenderPAC is not seen with in 30 sec");
		}
		
		TestUtil.ActionForMovetoElement(calenderPAC);
		calenderPAC.click();
		FillConsentDetails();
		boolean flag;
		
		if(!PACNote().equals("PAC is not done."))
		{
			 flag = false;
		}
		else
		{
			 flag=true;
		}
		return flag;
	}

	public void FillConsentDetails() 
	{
		TestUtil.ActionForMovetoElement(calenderPAC);
		
		TestUtil.Date();
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
		int rows1 = 2;
		for (int i = 1; i < Dates.size(); i++) 
		{
			String Datetext = Dates.get(i).getText();
			WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
			String text = Monthtextele.getText();
			String Arr[] = text.split(" ");
			String Monthtext = Arr[0];

			String CyrrentDate = TestUtil.Date();
			String[] Arr1 = CyrrentDate.split(",");
			String day = Arr1[0];
			String Month = Arr1[1];
			boolean flag1 = Dates.get(i).isEnabled();
			rows1++;

			if (day.equals(Datetext) && flag1 == true && Monthtext.equals(Month)) 
			{
				Dates.get(i).click();
				break;
			}
		}
		TestUtil.ActionForMovetoElement(PlaceholderHH);
		PlaceholderHH.click();
		PlaceholderHH.sendKeys("10");
		PlaceholderMM.sendKeys("10");
		TestUtil.ActionForMovetoElement(consenttextbox);
		if(consenttextbox.isSelected()==true)
		{
			System.out.println("checbox is checked");
		}
		else
		{
			consenttextbox.click();
		}
		
		TestUtil.ActionForMovetoElement(concentUpload);
		concentUpload.click();
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			System.out.println("InterruptedException is seen");
		}
		try 
		{
			Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\Patientconcent\\concent.exe");
		} catch (IOException e) {
			System.out.println("IO exception is seen");
		}
		TestUtil.ActionForMovetoElement(reoprtUpload);
		reoprtUpload.click();
		try 
		{
			Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\Reportconsent\\Report.exe");
		} catch (IOException e) 
		{
			System.out.println("IO exception is seen");
		}
		TestUtil.ActionForMovetoElement(SavePAC);
		SavePAC.click();

	}
	
	public String PACNote()
	{
		TestUtil.ActionForMovetoElement(OPUtab);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", OPUtab);
		//OPUtab.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		TestUtil.ActionForMovetoElement(PACMessage);
		msg= PACMessage.getText();
		
		return msg;
		
	}
	

}
