package com_milan_POM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class StimulationChartPage extends TestBase {
	private @FindBy(xpath = "//label[@class='checkbox-inline p-t-0']/input") WebElement Finalize;
	private @FindBy(xpath = "//li[text()='Stimulation Chart']") WebElement StimulationChart;
	private @FindBy(xpath = " //button[contains(text(), 'Add Stimulation Drug')]") WebElement AddSimulation;
	private @FindBy(xpath = "//table[@class='table table-bordered timeTableGrid']//tr[32]/td[contains(text(), ' Endometrium')]") WebElement Endometrium;
	private @FindBy(xpath = "//table[@class='table table-striped']//tbody//td/select[1]") WebElement DrugName;
	private @FindBy(xpath = "//table[@class='table table-striped']//thead//th[text()='#Days']//following::select[2]") WebElement Days;
	private @FindBy(xpath = "//table[@class='table table-striped']//tbody/tr//following-sibling::span/i") WebElement calender;
	private @FindBy(xpath = "//table[@class='table table-striped']//tbody/tr//following-sibling::td[@class='form-group uib-time hours']/input") WebElement HH;
	private @FindBy(xpath = "//table[@class='table table-striped']//tbody/tr//following-sibling::td[@class='form-group uib-time minutes']/input") WebElement MM;
	private @FindBy(xpath = "//table[@class='table table-striped']//tbody/tr//following-sibling::input[@name='SCDose']") WebElement Dose;
	private @FindBy(xpath = "//table[@class='table table-bordered timeTableGrid']//tbody/tr[38]/td[1]") WebElement colDrugName;
	private @FindBy(xpath = "(//button[@class='btn btn-primary m-b-0'])[1]") WebElement Save;
	private @FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']") WebElement Mandetoryfield;
	private @FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']") WebElement InvalidDate;
	private @FindBy(xpath = "(//h4[@id='myModalLabel'])[4]/following::select[1]") WebElement drugNametrigger;
	private @FindBy(xpath = "(//h4[@id='myModalLabel'])[4]/following::i[@class='fa fa-calendar'][1]") WebElement calendertrigger;
	private @FindBy(xpath = "(//h4[@id='myModalLabel'])[4]/following::input[@placeholder='HH']") WebElement HHT;
	private @FindBy(xpath = "(//h4[@id='myModalLabel'])[4]/following::input[@placeholder='MM']") WebElement MMT;
	private @FindBy(xpath = "(//h4[@id='myModalLabel'])[4]/following::input[@name='SCDose'][1]") WebElement DoseT;
	private @FindBy(xpath = "(//h4[@id='myModalLabel'])[4]/following::button[text()='Save'][1]") WebElement SaveT;
	private @FindBy(xpath="//li[contains(text() , 'OPU')]")WebElement OPUOption;
	private @FindBy(xpath="//span[contains (text(),'Finalize stimulation to save OPU.')]")WebElement MessageOPU;
	private @FindBy(xpath = "//span[@class='icon-screen ng-binding']") WebElement Cycleoverview;
	Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	WebDriverWait wait = new WebDriverWait(driver, 30);
	String msg;
	String names;
	int i = 1;

	StimulationChartPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean EnableconditionAddSimulationDrug()
	{
		Actions act = new Actions(driver);
		act.moveToElement(StimulationChart).click().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 250);");
		boolean flag = true;
		act.moveToElement(Finalize);

		boolean Flag1 = Finalize.isSelected();
		if (Flag1 == true) {
			flag = AddSimulation.isEnabled();
			return flag;

		} 
		else 
		{
			flag = AddSimulation.isEnabled();
		}
		return flag;

	}
	public void MoveToOPUOPtion()
	{
		
		
		try
		{
			TestUtil.VisibleOn(driver, OPUOption, 30);
			TestUtil.ActionForMovetoElement(OPUOption);
		}
		catch(Exception e)
		{
			System.out.println("OPUOption is not seen with in 30 sec");
		}
		OPUOption.click();
		
		
	}
	

	public String SaveSimulation() 
	{
		int rows = 3;// startedfrom 1 because at 2nd row 'select' option is
						// avail.

		for (i = 1; i <= 5; i++)// startedfrom 1 because at oth location
								// select option is avail.
		{
			TestUtil.ActionForMovetoElement(AddSimulation);
			AddSimulation.click();
			int sizedrug = reader.getRowCount("Stimulationchart");

			try {
				TestUtil.VisibleOn(driver, DrugName, 30);
				TestUtil.ActionForMovetoElement(DrugName);
			} catch (Exception e) {
				System.out.println("Element - DrugName is not seen with in 30 sec");
			}
			// DrugName.click();
			Select DN = new Select(DrugName);
			names = reader.getCellData("Stimulationchart", "DrugName", rows);
			try {
				DN.selectByVisibleText(names);
			} catch (Exception e) {
				System.out.println("ElementNotVisibleException seen");
			}
			rows++;
			List<WebElement> we = DN.getOptions();
			String name = we.get(i).getText();
			TestUtil.ActionForMovetoElement(calender);
			calender.click();
			TestUtil.Date();
			List<WebElement> Dates = driver
					.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
			int rows1 = 2;
			for (int i = 1; i < Dates.size(); i++) 
			{
			String Datetext = Dates.get(i).getText();
			WebElement Monthtextele = driver
					.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
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
			TestUtil.ActionForMovetoElement(HH);
			HH.click();
			HH.sendKeys("10");
			HH.sendKeys(Keys.TAB);
			// act.moveToElement(MM).click();
			MM.sendKeys("05");
			TestUtil.ActionForMovetoElement(Days);
			Select day1 = new Select(Days);
			day1.selectByVisibleText("2");
			TestUtil.ActionForMovetoElement(Dose);
			Dose.sendKeys("1");
			if (name.equals(names))
			{
				TestUtil.ActionForMovetoElement(Save);
				Save.click();
				try {
					Thread.sleep(3000);

					TestUtil.ActionForMovetoElement(Cycleoverview);
				} catch (InterruptedException e) {
					System.out.println("Element- InterruptedException is  seen");
				}
				msg = Cycleoverview.getText();
				break;
			} else 
			{
				msg = "SaveSimulation is not completed";
			}

		}
		return msg;
	}

	public String SimulationDrugValidation() 
	{
		SaveSimulation();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		TestUtil.ActionForMovetoElement(Endometrium);
		Endometrium.click();
		WebElement element = driver
				.findElement(By.xpath("//table[@class='table table-bordered timeTableGrid']/tbody/tr[37]/td[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		int k = 37 + i;
		WebElement drugName = driver
				.findElement(By.xpath("//table[@class='table table-bordered timeTableGrid']/tbody/tr[38]/td[1]"));
		TestUtil.ActionForMovetoElement(drugName);
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			System.out.println("InterruptedException is seen");
		}
		msg = drugName.getText();

		return msg;
	}

	public boolean ValidationForSimulationDrugAdded() 
	{

		TestUtil.ActionForMovetoElement(Endometrium);
		Endometrium.click();
		List<WebElement> button = driver.findElements(By.xpath(
				"//table[@class='table table-bordered timeTableGrid']/tbody/tr[40]//button//preceding::button[@class='btn btn_edit inline-block']"));
		int size = button.size();

		boolean flag2;
		if (size > 0) {
			flag2 = false;
		} else {
			flag2 = true;
		}
		return flag2;

	}

	public String InvalidDate() 
	{
		boolean flag3 = ValidationForSimulationDrugAdded();

		if (flag3 == false) 
		{
			msg = Triggerdrug();
		} 
		else 
		{
			SaveSimulation();
			try {
				Thread.sleep(3000);
			} 
			catch (InterruptedException e)
			{
				System.out.println("InterruptedException is seen");
			}
			msg = Triggerdrug();

		}
		return msg;

	}

	public String MessageonOPUPage() 
	{
		MoveToOPUOPtion();
		JavascriptExecutor js = null;
		TestUtil.ScrollthePage(js, driver);
		TestUtil.ActionForMovetoElement(MessageOPU);
		msg= MessageOPU.getText();

		return msg;

	}

	public String Triggerdrug() 
	{

		// act.moveToElement(Endometrium).click().perform();
		WebElement Triggerbutton = driver.findElement(By.xpath(
				"//table[@class='table table-bordered timeTableGrid']/tbody/tr/td[contains (text(), 'Remarks')]//preceding::button[@class='btn btn_edit inline-block m-l-10']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Triggerbutton);
		try {
			TestUtil.VisibleOn(driver, Triggerbutton, 20);
		} catch (TimeoutException e) {
			System.out.println("Element- remarks is not seen within 20 sec");
		}

		try {
			TestUtil.ActionForMovetoElement(Triggerbutton);
			Triggerbutton.click();
		} catch (Exception e) {
			System.out.println("Webdriverexception occured");
		}

		Select drugNameT = new Select(drugNametrigger);
		List<WebElement> DrugeleT = drugNameT.getOptions();
		int size = DrugeleT.size();
		int rows = 2;
		int count = 0;
		for (int i = 0; i < size; i++) {
			String drugNameTName = DrugeleT.get(i).getText();
			// reader.setCellData("Stimulationchart", "DrugNameTrigger", rows,
			// drugNameTName);
			rows++;
			count++;
			if (count == 5) {
				String name = reader.getCellData("Stimulationchart", "DrugNameTrigger", 5);
				drugNameT.selectByVisibleText(name);
				break;
			}

		}
		calendertrigger.click();
		List<WebElement> Dates = driver
				.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
		int rows1 = 2;
		for (int i = 1; i < Dates.size(); i++) {
			String Datetext = Dates.get(i).getText();
			WebElement Monthtextele = driver
					.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
			String text = Monthtextele.getText();
			String Arr[] = text.split(" ");
			String Monthtext = Arr[0];

			String CyrrentDate = TestUtil.Date();
			String[] Arr1 = CyrrentDate.split(",");
			String day = Arr1[0];
			String Month = Arr1[1];

			boolean flag1 = Dates.get(i).isEnabled();
			rows1++;

			if (day.equals(Datetext) && flag1 == true && Monthtext.equals(Month)) {
				Dates.get(i).click();
				break;
			}

		}
		HHT.click();
		HHT.sendKeys("10");
		HHT.sendKeys(Keys.TAB);
		MMT.sendKeys("05");
		DoseT.sendKeys("1");
		TestUtil.ActionForMovetoElement(SaveT);
		SaveT.click();

		try {
			TestUtil.VisibleOn(driver, InvalidDate, 30);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[@class='toast-msg ng-binding ng-scope']")));
		} catch (Exception e) {
			System.out.println("Element- InvalidDate is not seen with in 30 sec");
		}
		msg = InvalidDate.getText();

		return msg;
	}

	public String calenderfill(String date) 
	{

		return msg;

	}

	public LinkedList<String> AddStimulationdrug() 
	{

		Actions act = new Actions(driver);
		act.moveToElement(AddSimulation).click().perform();
		act.moveToElement(DrugName);
		Select DN = new Select(DrugName);
		List<WebElement> we = DN.getOptions();
		int size = we.size();
		int rows = 2;
		int count = 0;
		for (int i = 0; i <= size; i++) {

			String DrugName = we.get(i).getText();
			reader.setCellData("Stimulationchart", "DrugName", rows, DrugName);
			rows++;
			count++;
			LinkedList<String> Drugs = new LinkedList<String>();
			Drugs.add(DrugName);
			if (count == size) {
				break;
			}

		}
		return new LinkedList<String>();

	}

	public boolean SimulationDrugAvailability() 
	{
		String simulationdrug = SimulationDrugValidation();
		String name = reader.getCellData("Stimulationchart", "DrugName", 3);
		boolean flag = false;
		if (simulationdrug.equals(name)) 
		{
			flag = true;
		}
		else 
		{
			flag = false;
		}
		return flag;

	}

}
