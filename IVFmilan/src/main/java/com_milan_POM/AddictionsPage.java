package com_milan_POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class AddictionsPage extends TestBase {
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	TestUtil Testutl;

	@FindBy(xpath = "(//input[@type='checkbox'])[6]")
	WebElement smoke;
	@FindBy(xpath = "(//input[@type='checkbox'])[7]")
	WebElement Alkohol;
	@FindBy(xpath = "(//input[@type='checkbox'])[8]")
	WebElement Tobaco;
	@FindBy(xpath = "(//input[@type='checkbox'])[9]")
	WebElement DrugAdiction;
	@FindBy(xpath = "(//input[@type='checkbox'])[10]")
	WebElement CaffeineAddiction;

	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[1]")
	WebElement currentstatusSmoke;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[2]")
	WebElement currentstatusAlcohol;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[3]")
	WebElement currentstatusTobaco;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[4]")
	WebElement currentstatusDrugAdiction;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[4]")
	WebElement currentstatusCaffeineAddiction;
	@FindBy(xpath = "(//label[text()='Since When'])[7]//following::select")
	WebElement SinceWhenYearSmoke;
	@FindBy(xpath = "(//label[text()='Since When'])[8]//following::select")
	WebElement SinceWhenYearAlcohol;
	@FindBy(xpath = "(//label[text()='Since When'])[9]//following::select")
	WebElement SinceWhenYearTobaco;
	@FindBy(xpath = "(//label[text()='Since When'])[10]//following::select")
	WebElement SinceWhenDrugYearAdiction;
	@FindBy(xpath = "(//label[text()='Since When'])[11]//following::select")
	WebElement SinceWhenYearCaffeineAddiction;
	@FindBy(xpath = "(//label[text()='Since When'])[7]//following::select[2]")
	WebElement SenceWhenMonthSmioke;
	@FindBy(xpath = "(//label[text()='Since When'])[8]//following::select[2]")
	WebElement SinceWhenMonthAlkohol;
	@FindBy(xpath = "(//label[text()='Since When'])[9]//following::select[2]")
	WebElement SinceWhenMonthTobaco;
	@FindBy(xpath = "(//label[text()='Since When'])[10]//following::select[2]")
	WebElement SinceWhenMonthDrugAdiction;
	@FindBy(xpath = "(//label[text()='Since When'])[11]//following::select[2]")
	WebElement SinceWhenMonthCaffeineAddiction;
	private @FindBy(xpath = "//button[@class='btn btn-primary ng-binding']") WebElement Save;
	Exls_Reader reader = null;
	int count = 0;
	String names,Message;

	AddictionsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean CurrentStatusEnableForSmoke() {
		TestUtil.ClickOn(driver, smoke, 20);
		if (smoke.isDisplayed()) {
			smoke.click();
		}
		currentstatusSmoke.isDisplayed();
		return true;

	}

	public boolean CurrentStatusEnableConditionForAlcohol() {
		TestUtil.ClickOn(driver, Alkohol, 20);
		if (Alkohol.isDisplayed()) {
			Alkohol.click();
		}
		currentstatusAlcohol.isDisplayed();
		return true;
	}

	public boolean CurrentStatusEnableConditionForTobaco() {
		TestUtil.ClickOn(driver, Tobaco, 20);
		if (Alkohol.isDisplayed()) {
			Alkohol.click();
		}
		currentstatusTobaco.isDisplayed();
		return true;
	}

	public boolean CurrentStatusEnableConditionForDrugAdiction() {
		TestUtil.ClickOn(driver, DrugAdiction, 20);
		if (DrugAdiction.isDisplayed()) {
			DrugAdiction.click();
		}
		currentstatusDrugAdiction.isDisplayed();
		return true;
	}

	public boolean CurrentStatusEnableConditionForCaffeineAddiction() {
		TestUtil.ClickOn(driver, CaffeineAddiction, 20);
		if (CaffeineAddiction.isDisplayed()) {
			CaffeineAddiction.click();
		}
		currentstatusCaffeineAddiction.isDisplayed();
		return true;
	}

	public boolean EnableConditionForSinceWhenDrugAdiction() {
		TestUtil.ClickOn(driver, DrugAdiction, 20);
		if (DrugAdiction.isDisplayed()) {
			DrugAdiction.click();
		}
		SinceWhenDrugYearAdiction.isDisplayed();
		return true;
	}

	public boolean EnableConditionSinceWhenForAlkohol() {
		TestUtil.ClickOn(driver, Alkohol, 20);
		if (Alkohol.isDisplayed()) {
			Alkohol.click();
		}
		SinceWhenYearAlcohol.isDisplayed();
		return true;
	}

	public boolean EnableConditionSinceWhenForTobaco() {
		TestUtil.ClickOn(driver, Tobaco, 20);
		if (Tobaco.isDisplayed()) {
			Tobaco.click();
		}
		SinceWhenYearTobaco.isDisplayed();
		return true;
	}

	public boolean EnableConditionSinceWhenForSmoke() {
		TestUtil.ClickOn(driver, Tobaco, 20);
		if (smoke.isDisplayed()) {
			smoke.click();
		}
		SinceWhenYearSmoke.isDisplayed();
		return true;
	}

	public boolean EnableConditionSinceWhenYearFor() {
		TestUtil.ClickOn(driver, Tobaco, 20);
		if (smoke.isDisplayed()) {
			smoke.click();
		}
		SenceWhenMonthSmioke.isDisplayed();
		return true;
	}

	public boolean EnableconditionSinceWhenMonthForSmoke() {
		smoke.click();
		SinceWhenMonthTobaco.isDisplayed();
		return true;
	}

	public boolean EnableconditionSinceWhenMonthForAlkohol() {
		Alkohol.click();
		SinceWhenMonthAlkohol.click();
		return true;
	}

	public boolean EnableconditionSinceWhenMonthForTobaco() {
		Tobaco.click();
		SinceWhenMonthTobaco.isDisplayed();
		return true;
	}

	public boolean EnableconditionSinceWhenMonthForDrugAdiction() {
		DrugAdiction.click();
		SinceWhenMonthDrugAdiction.isDisplayed();
		return true;
	}

	public boolean EnableconditionSinceWhenMonthForCaffeineAddiction() {
		CaffeineAddiction.click();
		SinceWhenMonthCaffeineAddiction.isDisplayed();
		return true;
	}

	public static ArrayList<Object[]> getdatafromExcel() {
		Exls_Reader reader = null;

		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		int count1 = reader.getRowCount("Addictions");
		for (int rows = 2; rows <= count1; rows++) {

			String Addiction = reader.getCellData("Addictions", 0, rows);
			String CurrentStatus = reader.getCellData("Addictions", 1, rows);
			String SinceWhenM = reader.getCellData("Addictions", 2, rows);
			String SinceWhenY = reader.getCellData("Addictions", 3, rows);
			String Frequency = reader.getCellData("Addictions", 4, rows);
			String Quantity = reader.getCellData("Addictions", 5, rows);

			Object[] obj = { Addiction, CurrentStatus, SinceWhenM, SinceWhenY, Frequency, Quantity };
			mydata.add(obj);
		}

		return mydata;
	}

	public String SaveAllAddictions(String Addiction, String CurrentStatus, String SinceWhenM, String SinceWhenY,
			String Frequency, String Quantity) throws Exception {

		List<WebElement> checkbox = driver.findElements(By
				.xpath("//label[@class='col-md-12 col-sm-12 col-lg-12 control-label p-t-25']/input[@type='checkbox']"));
		count = checkbox.size();
		int rows = 2;
		while (rows <= 5) 
		{
			for (int i = 1; i <= count; i++)
			{
				WebElement addictionnames = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[1]//label"));
				String names = addictionnames.getText();
				Thread.sleep(2000);
				String AddictionNames = "Smoking";// reader.getCellData("Addictions",
													// 0, rows);
				if (names.equals(AddictionNames)) 
				{
					checkbox.get(i).click();
					WebElement smoke = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select CurrentstatusAddiction = new Select(smoke);
					CurrentstatusAddiction.selectByVisibleText(CurrentStatus);
					WebElement Month = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SincWhenMonth = new Select(Month);
					SincWhenMonth.selectByVisibleText(SinceWhenM);
					WebElement Year = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SincWhenYear = new Select(Year);
					SincWhenYear.selectByVisibleText(SinceWhenY);
					WebElement frequency = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select frequency1 = new Select(frequency);
					frequency1.selectByVisibleText(Frequency);
					rows++;

				} 
				else if (names.equals(AddictionNames)) 
				{
					checkbox.get(i).click();

				} 
				else if (names.equals(AddictionNames)) 
				{
					checkbox.get(i).click();
				} 
				else if (names.equals(AddictionNames)) 
				{
					checkbox.get(i).click();
				} 
				else if (names.equals(AddictionNames)) 
				{

					checkbox.get(i).click();
				}

			}
			//Save.click();
			String Message = null;

			

		}
		return Message;

	}
}
