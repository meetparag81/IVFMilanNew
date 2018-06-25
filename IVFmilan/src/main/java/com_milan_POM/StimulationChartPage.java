package com_milan_POM;

import java.util.LinkedList;
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
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class StimulationChartPage extends TestBase 
{
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
	private @FindBy(xpath="//table[@class='table table-bordered timeTableGrid']//tbody/tr[38]/td[1]")WebElement colDrugName; 
	private @FindBy(xpath = "(//button[@class='btn btn-primary m-b-0'])[1]") WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement Mandetoryfield;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement InvalidDate;
	private @FindBy(xpath="(//h4[@id='myModalLabel'])[4]/following::select[1]")WebElement drugNametrigger;
	private @FindBy(xpath="(//h4[@id='myModalLabel'])[4]/following::i[@class='fa fa-calendar'][1]")WebElement calendertrigger;
	private @FindBy(xpath="(//h4[@id='myModalLabel'])[4]/following::input[@placeholder='HH']")WebElement HHT;
	private @FindBy(xpath="(//h4[@id='myModalLabel'])[4]/following::input[@placeholder='MM']")WebElement MMT;
	private @FindBy(xpath="(//h4[@id='myModalLabel'])[4]/following::input[@name='SCDose'][1]")WebElement DoseT;
	private @FindBy(xpath="(//h4[@id='myModalLabel'])[4]/following::button[text()='Save'][1]") WebElement SaveT;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	String msg;
	

	StimulationChartPage() {
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

		} else {
			flag = AddSimulation.isEnabled();
		}
		return flag;

	}

	public void SaveSimulation() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(AddSimulation).click().perform();
		act.moveToElement(DrugName);
		Select DN = new Select(DrugName);
		DN.selectByVisibleText("INJ. SUCOL");
		act.moveToElement(calender).click().perform();
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td"));
		for (int i = 1; i <= Dates.size(); i++) 
		{
			String Datetext = Dates.get(i).getText();
			String date = reader.getCellData("CycleList", "Date", 2);
			String arr[] = date.split("/");
			String day = arr[0];
		if (Datetext.equals(day)) 
			{
				Dates.get(i).click();
				break;	
			}
		}
		act.moveToElement(HH).click();
		HH.sendKeys("10");
		HH.sendKeys(Keys.TAB);
		//act.moveToElement(MM).click();
		MM.sendKeys("05");
		act.moveToElement(Days);
		Select day1 = new Select(Days);
		day1.selectByVisibleText("2");
		act.moveToElement(Dose).click();
		Dose.sendKeys("1");
		act.moveToElement(Save).click().perform();
	}
	
	public String SimulationDrugValidation()
	{
		
		SaveSimulation();
		Actions act = new Actions(driver);
		act.moveToElement(Endometrium).click().perform();
		WebElement element = driver.findElement(By.xpath("//table[@class='table table-bordered timeTableGrid']/tbody/tr[39]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		msg= colDrugName.getText();
		
		
		return msg;
	}
	public boolean SimulationDrugAvailability()
	{
		String simulationdrug = SimulationDrugValidation();
		String name= reader.getCellData("Stimulationchart", "DrugName", 3);
		boolean flag = false;
		if(simulationdrug.equals(name))
		{
			flag= true;
		}
		else
		{
			flag=false;
		}
		return flag;
		
	}
	
	public String InvalidDate()
	{
		boolean flag2 =  SimulationDrugAvailability();
		if(flag2==true)
		{
			msg= Triggerdrug();
		}
		else
		{
			SaveSimulation();
			msg= Triggerdrug();
			msg = "Simulation drug is not available";
		}
		return msg;
			
		
	}
	
	
	public String Triggerdrug()
	{
		Actions act = new Actions(driver);
		act.moveToElement(Endometrium).click().perform();
		WebElement element = driver.findElement(By.xpath("//table[@class='table table-bordered timeTableGrid']/tbody/tr[38]/td[1]//button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Select drugNameT = new Select(drugNametrigger);
		List<WebElement> DrugeleT =  drugNameT.getOptions();
		int size = DrugeleT.size();
		int rows=2;
		int count=0;
		for(int i=0;i<=size;i++)
		{
			String drugNameTName=DrugeleT.get(i).getText();
			//reader.setCellData("Stimulationchart", "DrugNameTrigger", rows, drugNameTName);
			rows++;
			count++;
			if(count==9)
			{
				String name= reader.getCellData("Stimulationchart", "DrugNameTrigger", 9);
				drugNameT.selectByVisibleText(name);
				break;
			}
			
			
			
		}
		calendertrigger.click();
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td"));
		for (int i = 1; i <= Dates.size(); i++) 
		{
			String date1 = reader.getCellData("CycleList", "Date", 2);
			String arr[] = date1.split("/");
			String Datetext = Dates.get(i).getText();
			
			String arr1[] = date1.split("/");
			String day = arr1[0];
		if (Datetext.equals(day)) 
			{
				Dates.get(i).click();
				break;	
			}
		
		}
		HHT.click();
		HHT.sendKeys("10");
		HHT.sendKeys(Keys.TAB);
		MMT.sendKeys("05");
		DoseT.sendKeys("1");
		act.moveToElement(SaveT).click().perform();
		msg= InvalidDate.getText();
	
	return msg;
	}
	
	public LinkedList<String> AddStimulationdrug()
	{
		 
		Actions act = new Actions(driver);
		act.moveToElement(AddSimulation).click().perform();
		act.moveToElement(DrugName);
		Select DN = new Select(DrugName);
		List<WebElement>we = DN.getOptions();
		int size= we.size();
		int rows = 2;
		int count= 0;
		for(int i=0;i<=size;i++)
		{
			
			String DrugName= we.get(i).getText();
			reader.setCellData("Stimulationchart", "DrugName", rows, DrugName);
			rows++;
			count++;
			LinkedList<String>Drugs = new LinkedList<String>();
			Drugs.add(DrugName);
			if(count==size)
			{
				break;
			}
			
		}
		 return new LinkedList<String>();
	
	}
	
}
