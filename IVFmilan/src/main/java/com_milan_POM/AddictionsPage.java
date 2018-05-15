package com_milan_POM;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
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
	static Exls_Reader reader = new Exls_Reader(
			"C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	@FindBy(xpath = "(//input[@type='checkbox'])[6]")
	private WebElement smoke;
	@FindBy(xpath = "(//input[@type='checkbox'])[7]")
	private WebElement Alkohol;
	@FindBy(xpath = "(//input[@type='checkbox'])[8]")
	private WebElement Tobaco;
	@FindBy(xpath = "(//input[@type='checkbox'])[9]")
	private WebElement DrugAdiction;
	@FindBy(xpath = "(//input[@type='checkbox'])[10]")
	private WebElement CaffeineAddiction;

	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[1]")
	private WebElement currentstatusSmoke;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[2]")
	private WebElement currentstatusAlcohol;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[3]")
	private WebElement currentstatusTobaco;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[4]")
	private WebElement currentstatusDrugAdiction;
	@FindBy(xpath = "(//select[@id='ddlCurrentStatus'])[4]")
	private WebElement currentstatusCaffeineAddiction;
	@FindBy(xpath = "(//label[text()='Since When'])[7]//following::select")
	private WebElement SinceWhenYearSmoke;
	@FindBy(xpath = "(//label[text()='Since When'])[8]//following::select")
	private WebElement SinceWhenYearAlcohol;
	@FindBy(xpath = "(//label[text()='Since When'])[9]//following::select")
	private WebElement SinceWhenYearTobaco;
	@FindBy(xpath = "(//label[text()='Since When'])[10]//following::select")
	private WebElement SinceWhenDrugYearAdiction;
	@FindBy(xpath = "(//label[text()='Since When'])[11]//following::select")
	private WebElement SinceWhenYearCaffeineAddiction;
	@FindBy(xpath = "(//label[text()='Since When'])[7]//following::select[2]")
	private WebElement SenceWhenMonthSmioke;
	@FindBy(xpath = "(//label[text()='Since When'])[8]//following::select[2]")
	private WebElement SinceWhenMonthAlkohol;
	@FindBy(xpath = "(//label[text()='Since When'])[9]//following::select[2]")
	private WebElement SinceWhenMonthTobaco;
	@FindBy(xpath = "(//label[text()='Since When'])[10]//following::select[2]")
	private WebElement SinceWhenMonthDrugAdiction;
	@FindBy(xpath = "(//label[text()='Since When'])[11]//following::select[2]")
	private WebElement SinceWhenMonthCaffeineAddiction;
	private @FindBy(xpath = "//button[@class='btn btn-primary ng-binding']")
	static WebElement Save;
	private @FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")
	static WebElement FlashMessage;
	private @FindBy(xpath = "//div[@class='toast-text ng-scope']")
	static WebElement flashmsg;
	// Exls_Reader reader = null;
	static int count = 0;
	String names;
	static String Message;

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

	public void SaveAllAddictions(String Addiction, String CurrentStatus, String SinceWhenM, String SinceWhenY,
			String Frequency, String Quantity) throws Exception 
	{

		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='tab-pane active']/div//div//input[@type='checkbox']"));

		count = checkbox.size();
		

			for (int i = 1; i <= count; i++) 
			{
				WebElement checkbox1 = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
				
				if (checkbox1.isSelected() == false) 
				{
					AddictionsPage.NewAddictions(Addiction, CurrentStatus, SinceWhenM, SinceWhenY, Frequency, Quantity);
					break;

				}
				else
				{
					AddictionsPage.ExistingAddictions(Addiction, CurrentStatus, SinceWhenM, SinceWhenY, Frequency, Quantity);
					break;
				}
			}
	}

				
				/*int rows1 = 1;
				int count1 = 0;
				while (rows1 <= 5) 
				{

				rows1++;
				WebElement addictionnames = driver
						.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[1]//label"));
				String names = addictionnames.getText();
				// Thread.sleep(3000);
				String AddictionNames = reader.getCellData("Addictions", "Addictionname", rows1);
				switch (names) {
				case "Smoking":

					WebElement checkboxS = driver.findElement(By.xpath(
							"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean s = checkboxS.isSelected();
					if (s == false) {

						checkboxS.click();
					} else {
						count1++;
						System.out.println("checkbox infront of smoking is already selected");
						break;

					}
					WebElement smoke = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select Addictionamoke = new Select(smoke);
					Addictionamoke.selectByVisibleText(CurrentStatus);
					WebElement MonthS = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SincWhenMonth = new Select(MonthS);
					SincWhenMonth.selectByVisibleText(SinceWhenM);
					WebElement Year = driver.findElement(
							By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SincWhenYear = new Select(Year);
					SincWhenYear.selectByVisibleText(SinceWhenY);
					WebElement frequency = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select frequencyS = new Select(frequency);
					frequencyS.selectByVisibleText(Frequency);
					WebElement Noofcigaret = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					Noofcigaret.sendKeys(Quantity);
					rows1++;
					break;

				case "Alcohol":

					WebElement checkboxA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean a = checkboxA.isSelected();
					if (a == false) {

						checkboxA.click();
					} else {
						count1++;
						System.out.println("checkbox infront of Alkohol is already selected");
						break;

					}
					WebElement Alkohol = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select AddictionAlkohol = new Select(Alkohol);
					AddictionAlkohol.selectByVisibleText(CurrentStatus);
					WebElement MonthA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthA = new Select(MonthA);
					SinceMonthA.selectByVisibleText(SinceWhenM);
					WebElement YearAlkohol = driver.findElement(
							By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearA = new Select(YearAlkohol);
					SinceYearA.selectByVisibleText(SinceWhenY);
					WebElement frequencyA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyA = new Select(frequencyA);
					FrequencyA.selectByVisibleText(Frequency);
					WebElement Alkoholqty = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					Alkoholqty.sendKeys(Quantity);
					rows1++;
					break;
				case "Tobacco":
					WebElement checkboxT = driver.findElement(By.xpath(
							"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean t = checkboxT.isSelected();
					if (t == false) {

						checkboxT.click();
					} else {
						count1++;
						System.out.println("checkbox infront of Tobaco is already selected");

						break;

					}

					WebElement Tobaco = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select AddictionTobaco = new Select(Tobaco);
					AddictionTobaco.selectByVisibleText(CurrentStatus);
					WebElement MonthT = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthT = new Select(MonthT);
					SinceMonthT.selectByVisibleText(SinceWhenM);
					WebElement YearTobaco = driver.findElement(
							By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearT = new Select(YearTobaco);
					SinceYearT.selectByVisibleText(SinceWhenY);
					WebElement frequencyT = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyTobaco = new Select(frequencyT);
					FrequencyTobaco.selectByVisibleText(Frequency);
					WebElement Tobacoqty = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					Tobacoqty.sendKeys(Quantity);
					rows1++;
					break;

				case "Drug Addiction":
					WebElement checkboxDA = driver.findElement(By.xpath(
							"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean da = checkboxDA.isSelected();
					if (da == false) {

						checkboxDA.click();
					} else {
						count1++;
						System.out.println("checkbox infront of Tobaco is already selected");
						break;

					}
					WebElement DrugAddiction = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select Addictiondrug = new Select(DrugAddiction);
					Addictiondrug.selectByVisibleText(CurrentStatus);
					WebElement MonthDA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthDA = new Select(MonthDA);
					SinceMonthDA.selectByVisibleText(SinceWhenM);
					WebElement YearDrugAddiction = driver.findElement(
							By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearDA = new Select(YearDrugAddiction);
					SinceYearDA.selectByVisibleText(SinceWhenY);
					WebElement frequencyDA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyDA = new Select(frequencyDA);
					FrequencyDA.selectByVisibleText(Frequency);
					WebElement DrugAddictionqty = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					DrugAddictionqty.sendKeys(Quantity);
					rows1++;
					break;

				case "Caffeine Addiction":

					WebElement checkboxca = driver.findElement(By.xpath(
							"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean ca = checkboxca.isSelected();
					if (ca == false) {

						checkboxca.click();
					} else {
						count1++;
						System.out.println("checkbox infront of Tobaco is already selected");
						break;

					}

					WebElement CaffeineAddiction = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select Caffeinedrug = new Select(CaffeineAddiction);
					Caffeinedrug.selectByVisibleText(CurrentStatus);
					WebElement MonthCA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthCA = new Select(MonthCA);
					SinceMonthCA.selectByVisibleText(SinceWhenM);
					WebElement YearCaffeineAddiction = driver.findElement(
							By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearCA = new Select(YearCaffeineAddiction);
					SinceYearCA.selectByVisibleText(SinceWhenY);
					WebElement frequencyCA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyDA1 = new Select(frequencyCA);
					FrequencyDA1.selectByVisibleText(Frequency);
					WebElement CaffeineAddictionqty = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					CaffeineAddictionqty.sendKeys(Quantity);
					rows1++;
					break;

				} // switch
			} // for rows
			try 
			{
				String countnew = Integer.toString(count1);
				boolean data = reader.setCellData("Addictions", "countNo", 2, countnew);
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("int is not converted into string");
			} finally 
			{
				System.out.println("Save the form");
			}

		} // while

		Save.click();
		String Message = FlashMessage.getText();

		System.out.println(Message);*/

	

	

	

	public static String NewAddictions(String Addiction1, String CurrentStatus1, String SinceMonth1, String SinceYear1,
			String Frequency1, String Quantity1) 
	{
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='tab-pane active']/div//div//input[@type='checkbox']"));
		count = checkbox.size();
		int rows1 = 1;
		int count1 = 0;
		while (rows1 <= 5) 
		{
			for (int i = 1; i <= 5; i++) 
			{
				rows1++;
				WebElement addictionnames = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[1]//label"));
				String names = addictionnames.getText();				
				switch (names) 
				{
				case "Smoking":

					WebElement checkboxS = driver.findElement(By.xpath(	"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					checkboxS.click();
					WebElement smoke = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select Addictionamoke = new Select(smoke);
					Addictionamoke.selectByVisibleText(CurrentStatus1);
					WebElement MonthS = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SincWhenMonth = new Select(MonthS);
					SincWhenMonth.selectByVisibleText(SinceMonth1);
					WebElement Year = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SincWhenYear = new Select(Year);
					SincWhenYear.selectByVisibleText(SinceYear1);
					WebElement frequency = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select frequencyS = new Select(frequency);
					frequencyS.selectByVisibleText(Frequency1);
					WebElement Noofcigaret = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					Noofcigaret.sendKeys(Quantity1);
					rows1++;
					break;

				case "Alcohol":

					WebElement checkboxA = driver.findElement(By.xpath(	"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean a = checkboxA.isSelected();
					if (a == false) {

						checkboxA.click();
					} else {
						
						System.out.println("checkbox infront of Alkohol is already selected");
						break;

					}
					WebElement Alkohol = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select AddictionAlkohol = new Select(Alkohol);
					AddictionAlkohol.selectByVisibleText(CurrentStatus1);
					WebElement MonthA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthA = new Select(MonthA);
					SinceMonthA.selectByVisibleText(SinceMonth1);
					WebElement YearAlkohol = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearA = new Select(YearAlkohol);
					SinceYearA.selectByVisibleText(SinceYear1);
					WebElement frequencyA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyA = new Select(frequencyA);
					FrequencyA.selectByVisibleText(Frequency1);
					WebElement Alkoholqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					Alkoholqty.sendKeys(Quantity1);
					rows1++;
					break;
				case "Tobacco":
					WebElement checkboxT = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean t = checkboxT.isSelected();
					if (t == false) {

						checkboxT.click();
					} else {
					
						System.out.println("checkbox infront of Tobaco is already selected");

						break;

					}

					WebElement Tobaco = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select AddictionTobaco = new Select(Tobaco);
					AddictionTobaco.selectByVisibleText(CurrentStatus1);
					WebElement MonthT = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthT = new Select(MonthT);
					SinceMonthT.selectByVisibleText(SinceMonth1);
					WebElement YearTobaco = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearT = new Select(YearTobaco);
					SinceYearT.selectByVisibleText(SinceYear1);
					WebElement frequencyT = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyTobaco = new Select(frequencyT);
					FrequencyTobaco.selectByVisibleText(Frequency1);
					WebElement Tobacoqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					Tobacoqty.sendKeys(Quantity1);
					rows1++;
					break;

				case "Drug Addiction":
					WebElement checkboxDA = driver.findElement(By.xpath(
							"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean da = checkboxDA.isSelected();
					if (da == false) {

						checkboxDA.click();
					} else {
						
						System.out.println("checkbox infront of Tobaco is already selected");
						break;

					}
					WebElement DrugAddiction = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select Addictiondrug = new Select(DrugAddiction);
					Addictiondrug.selectByVisibleText(CurrentStatus1);
					WebElement MonthDA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthDA = new Select(MonthDA);
					SinceMonthDA.selectByVisibleText(SinceMonth1);
					WebElement YearDrugAddiction = driver.findElement(
							By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearDA = new Select(YearDrugAddiction);
					SinceYearDA.selectByVisibleText(SinceYear1);
					WebElement frequencyDA = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyDA = new Select(frequencyDA);
					FrequencyDA.selectByVisibleText(Frequency1);
					WebElement DrugAddictionqty = driver
							.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					DrugAddictionqty.sendKeys(Quantity1);
					rows1++;
					break;

				case "Caffeine Addiction":

					WebElement checkboxca = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
					boolean ca = checkboxca.isSelected();
					if (ca == false) {

						checkboxca.click();
					} else {
						
						System.out.println("checkbox infront of Tobaco is already selected");
						break;

					}

					WebElement CaffeineAddiction = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
					Select Caffeinedrug = new Select(CaffeineAddiction);
					Caffeinedrug.selectByVisibleText(CurrentStatus1);
					WebElement MonthCA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
					Select SinceMonthCA = new Select(MonthCA);
					SinceMonthCA.selectByVisibleText(SinceMonth1);
					WebElement YearCaffeineAddiction = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
					Select SinceYearCA = new Select(YearCaffeineAddiction);
					SinceYearCA.selectByVisibleText(SinceYear1);
					WebElement frequencyCA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
					Select FrequencyDA1 = new Select(frequencyCA);
					FrequencyDA1.selectByVisibleText(Frequency1);
					WebElement CaffeineAddictionqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
					CaffeineAddictionqty.sendKeys(Quantity1);
					rows1++;
				}//switch
			}//for
		}//while
		Save.click();
		String Message = FlashMessage.getText();

		System.out.println(Message);
		return Message;
	}
		
		public static String ExistingAddictions(String Addiction2, String CurrentStatus2, String SinceMonth2, String SinceYear2,String Frequency2, String Quantity2)
		{
			count++;
		int count1 = 0;
				List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='tab-pane active']/div//div//input[@type='checkbox']"));
				count = checkbox.size();
				int rows1 = 1;
				int count2 = 0;
				while (rows1 <= 5) 
				{
					for (int i = 1; i <= 5; i++) 
					{
						rows1++;
						WebElement addictionnames = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[1]//label"));
						String names = addictionnames.getText();
						
						switch (names) 
						{
						case "Smoking":

							WebElement checkboxS = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
							boolean s = checkboxS.isSelected();
							if(s==false)
							{

								checkboxS.click();
							} else 
							{
								
								System.out.println("checkbox infront of Smoking is already selected");
								

							}
							count1++;
							WebElement smoke = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
							Select Addictionamoke = new Select(smoke);
							Addictionamoke.selectByVisibleText("Yes");
							WebElement MonthS = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
							Select SincWhenMonth = new Select(MonthS);
							//SincWhenMonth.deselectByVisibleText("Yes");
							SincWhenMonth.selectByVisibleText(SinceMonth2);
							WebElement Year = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
							Select SincWhenYear = new Select(Year);
							//SincWhenYear.deselectByVisibleText(SinceYear2);
							SincWhenYear.selectByVisibleText(SinceYear2);
							WebElement frequency = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
							Select frequencyS = new Select(frequency);
							//frequencyS.deselectByVisibleText(Frequency2);
							frequencyS.selectByVisibleText(Frequency2);
							WebElement Noofcigaret = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
							Noofcigaret.clear();
							Noofcigaret.sendKeys(Quantity2);
							rows1++;
							break;

						case "Alcohol":

							WebElement checkboxA = driver.findElement(By.xpath(	"//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
							boolean a = checkboxA.isSelected();
							if (a == false)
							{

								checkboxA.click();
							} else {
									System.out.println("checkbox infront of Alkohol is already selected");
								}
							count1++;
							WebElement Alkohol = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
							Select AddictionAlkohol = new Select(Alkohol);
							//AddictionAlkohol.deselectByVisibleText(CurrentStatus2);
							AddictionAlkohol.selectByVisibleText(CurrentStatus2);
							WebElement MonthA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
							Select SinceMonthA = new Select(MonthA);
							//SinceMonthA.deselectByVisibleText(SinceMonth2);
							SinceMonthA.selectByVisibleText(SinceMonth2);
							
							WebElement YearAlkohol = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
													
							Select SinceYearA = new Select(YearAlkohol);
							SinceYearA.selectByVisibleText(SinceYear2);
							WebElement frequencyA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
							Select FrequencyA = new Select(frequencyA);
							FrequencyA.selectByVisibleText(Frequency2);
							WebElement Alkoholqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
							Alkoholqty.clear();
							Alkoholqty.sendKeys(Quantity2);
							rows1++;
							break;
						case "Tobacco":
							WebElement checkboxT = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
							boolean t = checkboxT.isSelected();
							if (t == false) 
							{

								checkboxT.click();
							} 
							else {
								System.out.println("checkbox infront of Tobacco is already selected");
							}
							count1++;
							WebElement Tobaco = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
							Select AddictionTobaco = new Select(Tobaco);
							//AddictionTobaco.deselectByVisibleText(CurrentStatus2);
							AddictionTobaco.selectByVisibleText(CurrentStatus2);
							WebElement MonthT = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
							Select SinceMonthT = new Select(MonthT);
							//SinceMonthT.deselectByVisibleText(SinceMonth2);
							SinceMonthT.selectByVisibleText(SinceMonth2);
							WebElement YearTobaco = driver.findElement(	By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
							Select SinceYearT = new Select(YearTobaco);
							//SinceYearT.deselectByVisibleText(SinceYear2);
							SinceYearT.selectByVisibleText(SinceYear2);
							WebElement frequencyT = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
							Select FrequencyTobaco = new Select(frequencyT);
							//FrequencyTobaco.deselectByValue(Frequency2);
							FrequencyTobaco.selectByVisibleText(Frequency2);
							WebElement Tobacoqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
							Tobacoqty.clear();
							Tobacoqty.sendKeys(Quantity2);
							rows1++;
							break;

						case "Drug Addiction":
							WebElement checkboxDA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
							boolean da = checkboxDA.isSelected();
							if (da == false) 
							{

								checkboxDA.click();
							} 
							else {
								System.out.println("checkbox infront of Drug Addiction is already selected");
							}
							count1++;
							WebElement DrugAddiction = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
							Select Addictiondrug = new Select(DrugAddiction);
							//Addictiondrug.deselectByVisibleText(CurrentStatus2);
							Addictiondrug.selectByVisibleText(CurrentStatus2);
							WebElement MonthDA = driver	.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
							Select SinceMonthDA = new Select(MonthDA);
							//SinceMonthDA.deselectByVisibleText(SinceMonth2);
							SinceMonthDA.selectByVisibleText(SinceMonth2);
							WebElement YearDrugAddiction = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
							Select SinceYearDA = new Select(YearDrugAddiction);
							//SinceYearDA.deselectByVisibleText(SinceYear2);
							SinceYearDA.selectByVisibleText(SinceYear2);
							WebElement frequencyDA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
							Select FrequencyDA = new Select(frequencyDA);
							//FrequencyDA.deselectByVisibleText(Frequency2);
							FrequencyDA.selectByVisibleText(Frequency2);
							WebElement DrugAddictionqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
							DrugAddictionqty.clear();
							DrugAddictionqty.sendKeys(Quantity2);
							rows1++;
							break;

						case "Caffeine Addiction":
							
							
							WebElement checkboxca = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]//div//label/input[@type='checkbox']"));
							boolean ca = checkboxca.isSelected();
							if (ca == false) 
							{

								checkboxca.click();
							} 
							else {
								System.out.println("checkbox infront of Caffeine Addiction is already selected");
							}
							count1++;
							WebElement CaffeineAddiction = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[2]//select[1]"));
							Select Caffeinedrug = new Select(CaffeineAddiction);
							//Caffeinedrug.deselectByVisibleText(CurrentStatus2);
							Caffeinedrug.selectByVisibleText(CurrentStatus2);
							WebElement MonthCA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1]"));
							Select SinceMonthCA = new Select(MonthCA);
							//SinceMonthCA.deselectByVisibleText(SinceMonth2);
							SinceMonthCA.selectByVisibleText(SinceMonth2);
							WebElement YearCaffeineAddiction = driver.findElement(By.xpath("(//div[@class='tab-pane active']/div[" + i + "]/div[3]//select[1])[2]"));
							Select SinceYearCA = new Select(YearCaffeineAddiction);
							//SinceYearCA.deselectByVisibleText(SinceYear2);
							SinceYearCA.selectByVisibleText(SinceYear2);
							WebElement frequencyCA = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[4]//select[1]"));
							Select FrequencyDA1 = new Select(frequencyCA);
							//FrequencyDA1.deselectByVisibleText(Frequency2);
							FrequencyDA1.selectByVisibleText(Frequency2);
							WebElement CaffeineAddictionqty = driver.findElement(By.xpath("//div[@class='tab-pane active']/div[" + i + "]/div[5]//div//input"));
							CaffeineAddictionqty.clear();
							CaffeineAddictionqty.sendKeys(Quantity2);
							rows1++;
				
				
				
				
				
			
			}//switch
					}//for
					try 
					{
						String countnew = Integer.toString(count1);
						boolean data = reader.setCellData("Addictions", "countNo", 2, countnew);
					} 
					catch (NumberFormatException e) 
					{
						System.out.println("int is not converted into string");
					} finally 
					{
						System.out.println("Save the form");
					}

				} // while

				Save.click();
				String Message = FlashMessage.getText();

				System.out.println(Message);
				return Message;
					
				
	}
		
		
		
	
				
				public String FlashMessage() 
				{
					String Message = FlashMessage.getText();
					return Message;
				}
				
		}


