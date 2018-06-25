package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class AllergiesPage extends TestBase
{
	private @FindBy (xpath="(//button[@id='btnAddObstetricHistoryRow'])[2]")
	static WebElement Addrows;
	private @FindBy(xpath="(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]")WebElement Allergytype;
	private @FindBy(xpath="(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[2]")WebElement DrugAllergyType;
	private @FindBy(xpath="//div[@id='allergies']/div/div[2]/div/table/tbody/tr[2]/td[3]/div[2]/input")WebElement FoodAllergy;
	private @FindBy(xpath="(//th[text()='Current Status']//following::select)[3]")WebElement Currentstatus;
	private @FindBy(xpath="(//span[text()='History']//following::span[@class='ng-binding'])[1]")WebElement NoofAllergies;
	private @FindBy(xpath="//button[@id='btnSaveUpdateHistory']")
	static WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement SaveMessage;
	private @FindBy(xpath="//button[@class='btn btn-default']")
	static WebElement Cancel;
	static private @FindBy(xpath="//button[@class='btn btn-primary ng-binding']") WebElement Update;
	 int rows;
	static WebDriverWait wait = new WebDriverWait(driver, 30);
	
	
	
	AllergiesPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean foodvalidation() 
	{
		FoodAllergy.isDisplayed();
		return true;
	}

	public String AllergiesNameOnDashboard() 
	{
		TestUtil.VisibleOn(driver, NoofAllergies, 20);
		
		String Allergies= NoofAllergies.getAttribute("value");
		return Allergies;
		
	}

	public String OptionSelectedinDrugAllergyCurrentstatus() 
	{
		Select statuscurrent = new Select(Currentstatus);
		WebElement status= statuscurrent.getFirstSelectedOption();
		String status1= status.getText();
		System.out.println("Currentstatus is" +status1);
		return status1;
	}

	public String DrugAllergyType()
	{
		Select DrugAllergy = new Select(DrugAllergyType);
		WebElement DrugAllergy1=DrugAllergy.getFirstSelectedOption();
		String DrugName= DrugAllergy1.getText();
	System.out.println("Drugname is"+DrugName);
		return DrugName;
	}
	
	public void AllergySelection() 
	{
		List<WebElement>Selections = driver.findElements(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr"));
		int Selectionssize = Selections.size();
		if(Selectionssize ==0)
		
		{
			AddnewAllergies();
		}
		else
		{
			existingPaitent();
		}
	}

	public static void AddnewAllergies() 
	{
		
		List<WebElement>Allergyrows= driver.findElements(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr"));
				int rows = Allergyrows.size();
				//System.out.println("No of rows"+rows);
				
		rows=rows+1;
		for( int row1=rows ;row1<= 6;row1++)
		{
				TestUtil.VisibleOn(driver, Addrows, 30);
				Addrows.click();
				 WebElement allergy= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]")));
				Select Allergytypes = new Select(allergy);
			List<WebElement>Allergies1=Allergytypes.getOptions();
		
			for(int i=1;i<Allergies1.size();i++)
			{
				String Names = Allergies1.get(i).getText();		
					switch(Names)
					{
					case"Drug Allergy":
					Allergytypes.selectByVisibleText("Drug Allergy");
					WebElement TypeAllergy = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
					Select Allergytype = new Select(TypeAllergy);
					Allergytype.selectByVisibleText("Drug Allergy");
					WebElement Allergy = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[2]"));
					Select Allergy1= new Select(Allergy);
					Allergy1.selectByIndex(1);
					WebElement currentstatus = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
					Select status = new Select(currentstatus);
					status.selectByVisibleText("Present");
					WebElement SinceM = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
					Select month = new Select(SinceM);
					month.selectByVisibleText("10");
					WebElement SinceY = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
					Select Year = new Select(SinceY);
					Year.selectByVisibleText("12");
					WebElement Severity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
					Select Seeveritytype= new Select(Severity);
					Seeveritytype.selectByVisibleText("Severe");
					row1++;
					break;
					
					case"Food Allergy":
						TestUtil.VisibleOn(driver, Addrows, 10);
						Addrows.click();
						WebElement Allergyfood = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]")));
						Select foodAllergy=new Select(Allergyfood);
						foodAllergy.selectByVisibleText("Food Allergy");
					WebElement Allergyfoodinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
					TestUtil.VisibleOn(driver, Allergyfoodinput, 10);
					Allergyfoodinput.sendKeys("foodAllergy");
					WebElement currentstatusfood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
					
					Select foodstatus= new Select(currentstatusfood);
					foodstatus.selectByVisibleText("Absent");
					WebElement SinceMFood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
					Select FromMonthFood = new Select(SinceMFood);
					FromMonthFood.selectByVisibleText("1");
					WebElement SinceYFood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
					Select FromYearFood = new Select(SinceYFood);
					FromYearFood.selectByVisibleText("1");
					WebElement FoodSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
					Select SeverityFood = new Select(FoodSeverity);
					SeverityFood.selectByVisibleText("Mild");
					row1++;
					break;
					case"Skin Allergy":
						Addrows.click();
						WebElement AllergySkin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select skinAllergy = new Select(AllergySkin);
						skinAllergy.selectByVisibleText("Skin Allergy");
						WebElement skinAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						skinAllergyinput.sendKeys("SkinAllergy");
						WebElement currentstatusskin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select skinstatusM = new Select(currentstatusskin);
						skinstatusM.selectByVisibleText("Present");
						WebElement SinceMskin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthSkin = new Select(SinceMskin);
						FromMonthSkin.selectByVisibleText("6");
						WebElement SinceYSkin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearSkin = new Select(SinceYSkin);
						FromYearSkin.selectByVisibleText("4");
						WebElement SkinSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeveritySkin = new Select(SkinSeverity);
						SeveritySkin.selectByVisibleText("Moderate");
						row1++;
						break;
					case"Smoke Allergy":
						Addrows.click();
						WebElement AllergySmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select SmokeAllergy = new Select(AllergySmoke);
						SmokeAllergy.selectByVisibleText("Smoke Allergy");
						WebElement smokeAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						smokeAllergyinput.sendKeys("smokeAllergy");
						WebElement currentstatussmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select smokestatusM = new Select(currentstatussmoke);
						smokestatusM.selectByVisibleText("Present");
						WebElement SinceMSmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthSmoke = new Select(SinceMSmoke);
						FromMonthSmoke.selectByVisibleText("6");
						WebElement SinceYSmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearSmoke = new Select(SinceYSmoke);
						FromYearSmoke.selectByVisibleText("4");	
						WebElement SmokeSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeveritySmoke = new Select(SmokeSeverity);
						SeveritySmoke.selectByVisibleText("Mild");
						row1++;
						break;
					case"Latex Allergy":
						Addrows.click();
						WebElement AllergyLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select LatexAllergy = new Select(AllergyLatex);
						LatexAllergy.selectByVisibleText("Latex Allergy");
						WebElement currentstatusLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select LatexstatusM = new Select(currentstatusLatex);
						LatexstatusM.selectByVisibleText("Present");
						WebElement SinceMLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthLatex = new Select(SinceMLatex);
						FromMonthLatex.selectByVisibleText("3");
						WebElement SinceYLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearLatex = new Select(SinceYLatex);
						FromYearLatex.selectByVisibleText("4");	
						WebElement LatexSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeverityLatex = new Select(LatexSeverity);
						SeverityLatex.selectByVisibleText("Mild");
						row1++;
						break;
					case"Dust Allergy":
						Addrows.click();
						WebElement AllergyDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select DustAllergy = new Select(AllergyDust);
						DustAllergy.selectByVisibleText("Dust Allergy");
						WebElement currentstatusDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select DuststatusM = new Select(currentstatusDust);
						DuststatusM.selectByVisibleText("Present");
						WebElement SinceMDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthDust = new Select(SinceMDust);
						FromMonthDust.selectByVisibleText("3");
						WebElement SinceYDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearDust = new Select(SinceYDust);
						FromYearDust.selectByVisibleText("4");	
						WebElement DustSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeverityDust = new Select(DustSeverity);
						SeverityDust.selectByVisibleText("Mild");
						break;
					/*case"Default":
						Save.click();*/
						
					}//switch
					
					
					
					
					
					
					
				
				}//forallergy
			
			
				
			
			
			
			}//for rows
		Save.click();
		System.out.println("Clicked on Save button");
		return ;
		
		
		
	}
	
	public void PaitentAdd()
	{
		List<WebElement>Allergyrows= driver.findElements(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr"));
		int rows = Allergyrows.size();
		System.out.println("No of rows"+rows);
	
		if(rows<=0)
		{	
			
		}
		else
		{			
			
		}
		
	}
	public void NewAllergies()
	{
		rows=rows+1;
		for( int row1=rows ;row1<= 6;row1++)
		{
				TestUtil.VisibleOn(driver, Addrows, 30);
				Addrows.click();
				 WebElement allergy= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]")));
				Select Allergytypes = new Select(allergy);
			List<WebElement>Allergies1=Allergytypes.getOptions();
		
			for(int i=1;i<Allergies1.size();i++)
			{
				String Names = Allergies1.get(i).getText();		
					switch(Names)
					{
					case"Drug Allergy":
					Allergytypes.selectByVisibleText("Drug Allergy");
					WebElement TypeAllergy = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
					Select Allergytype = new Select(TypeAllergy);
					Allergytype.selectByVisibleText("Drug Allergy");
					WebElement Allergy = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[2]"));
					Select Allergy1= new Select(Allergy);
					Allergy1.selectByIndex(1);
					WebElement currentstatus = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
					Select status = new Select(currentstatus);
					status.selectByVisibleText("Present");
					WebElement SinceM = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
					Select month = new Select(SinceM);
					month.selectByVisibleText("10");
					WebElement SinceY = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
					Select Year = new Select(SinceY);
					Year.selectByVisibleText("12");
					WebElement Severity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
					Select Seeveritytype= new Select(Severity);
					Seeveritytype.selectByVisibleText("Severe");
					row1++;
					break;
					
					case"Food Allergy":
						TestUtil.VisibleOn(driver, Addrows, 10);
						Addrows.click();
						WebElement Allergyfood = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]")));
						Select foodAllergy=new Select(Allergyfood);
						foodAllergy.selectByVisibleText("Food Allergy");
					WebElement Allergyfoodinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
					TestUtil.VisibleOn(driver, Allergyfoodinput, 10);
					Allergyfoodinput.sendKeys("foodAllergy");
					WebElement currentstatusfood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
					
					Select foodstatus= new Select(currentstatusfood);
					foodstatus.selectByVisibleText("Absent");
					WebElement SinceMFood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
					Select FromMonthFood = new Select(SinceMFood);
					FromMonthFood.selectByVisibleText("1");
					WebElement SinceYFood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
					Select FromYearFood = new Select(SinceYFood);
					FromYearFood.selectByVisibleText("1");
					WebElement FoodSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
					Select SeverityFood = new Select(FoodSeverity);
					SeverityFood.selectByVisibleText("Mild");
					row1++;
					break;
					case"Skin Allergy":
						Addrows.click();
						WebElement AllergySkin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select skinAllergy = new Select(AllergySkin);
						skinAllergy.selectByVisibleText("Skin Allergy");
						WebElement skinAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						skinAllergyinput.sendKeys("SkinAllergy");
						WebElement currentstatusskin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select skinstatusM = new Select(currentstatusskin);
						skinstatusM.selectByVisibleText("Present");
						WebElement SinceMskin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthSkin = new Select(SinceMskin);
						FromMonthSkin.selectByVisibleText("6");
						WebElement SinceYSkin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearSkin = new Select(SinceYSkin);
						FromYearSkin.selectByVisibleText("4");
						WebElement SkinSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeveritySkin = new Select(SkinSeverity);
						SeveritySkin.selectByVisibleText("Moderate");
						row1++;
						break;
					case"Smoke Allergy":
						Addrows.click();
						WebElement AllergySmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select SmokeAllergy = new Select(AllergySmoke);
						SmokeAllergy.selectByVisibleText("Smoke Allergy");
						WebElement smokeAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						smokeAllergyinput.sendKeys("smokeAllergy");
						WebElement currentstatussmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select smokestatusM = new Select(currentstatussmoke);
						smokestatusM.selectByVisibleText("Present");
						WebElement SinceMSmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthSmoke = new Select(SinceMSmoke);
						FromMonthSmoke.selectByVisibleText("6");
						WebElement SinceYSmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearSmoke = new Select(SinceYSmoke);
						FromYearSmoke.selectByVisibleText("4");	
						WebElement SmokeSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeveritySmoke = new Select(SmokeSeverity);
						SeveritySmoke.selectByVisibleText("Mild");
						row1++;
						break;
					case"Latex Allergy":
						Addrows.click();
						WebElement AllergyLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select LatexAllergy = new Select(AllergyLatex);
						LatexAllergy.selectByVisibleText("Latex Allergy");
						WebElement currentstatusLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select LatexstatusM = new Select(currentstatusLatex);
						LatexstatusM.selectByVisibleText("Present");
						WebElement SinceMLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthLatex = new Select(SinceMLatex);
						FromMonthLatex.selectByVisibleText("3");
						WebElement SinceYLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearLatex = new Select(SinceYLatex);
						FromYearLatex.selectByVisibleText("4");	
						WebElement LatexSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeverityLatex = new Select(LatexSeverity);
						SeverityLatex.selectByVisibleText("Mild");
						row1++;
						break;
					case"Dust Allergy":
						Addrows.click();
						WebElement AllergyDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select DustAllergy = new Select(AllergyDust);
						DustAllergy.selectByVisibleText("Dust Allergy");
						WebElement currentstatusDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select DuststatusM = new Select(currentstatusDust);
						DuststatusM.selectByVisibleText("Present");
						WebElement SinceMDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthDust = new Select(SinceMDust);
						FromMonthDust.selectByVisibleText("3");
						WebElement SinceYDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearDust = new Select(SinceYDust);
						FromYearDust.selectByVisibleText("4");	
						WebElement DustSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeverityDust = new Select(DustSeverity);
						SeverityDust.selectByVisibleText("Mild");
						break;
					/*case"Default":
						Save.click();*/
						
					}//switch
					
					
					
					
					
					
					
				
				}//forallergy
		}
		
		
	}
	public  String SaveMessageForNewPaient()
	{
		String message= SaveMessage.getText();
		return message;
	}
	
	public String AllergiesOnDashboardforNewPatient()
	{
		String msg= NoofAllergies.getText();
		
		return msg;
		
	}

	
	public static void existingPaitent()
	{
		List<WebElement>typeofallergies= driver.findElements(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr"));
		int size=typeofallergies.size();
		for(int i=1;i<=size;i++)
		{
			WebElement option= driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+i+"]//td[2]//select"));
			Select option1 = new Select(option);
		WebElement ele=	option1.getFirstSelectedOption();
	String elementtext = ele.getText();
	System.out.println(elementtext);
	if(elementtext.equals("Drug Allergy"));
	{
		/*Addrows.click();
		Update.click();
		break;*/
		
	}
	 if(elementtext.equals("Skin Allergy"))
	{
		
	}
	else if(elementtext.contains("Drug Allergy"))
	{
		
	}
	


		}	
	}
}

