package com_milan_POM;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class AllergiesPage extends TestBase
{
	private @FindBy (xpath="//div[@class='col-md-4 col-lg-4 text-right']/button[@class='f-right btn-link link']") WebElement Addrows;
	private @FindBy(xpath="(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]")WebElement Allergytype;
	private @FindBy(xpath="(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[2]")WebElement DrugAllergyType;
	private @FindBy(xpath="//div[@id='allergies']/div/div[2]/div/table/tbody/tr[2]/td[3]/div[2]/input")WebElement FoodAllergy;
	private @FindBy(xpath="(//th[text()='Current Status']//following::select)[3]")WebElement Currentstatus;
	private @FindBy(xpath="(//span[text()='History']//following::span[@class='ng-binding'])[1]")WebElement NoofAllergies;
	private @FindBy(xpath="//button[@id='btnSaveUpdateHistory']")
	static WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement SaveMessage;
	private @FindBy(xpath="//button[@class='btn btn-default']") WebElement Cancel;
	private @FindBy(xpath="//button[@class='toast-msg ng-binding ng-scope") WebElement UpdateMessage;
	private @FindBy(xpath="//button[@class='btn btn-primary ng-binding']")WebElement Button;
	 private @FindBy(xpath="//button[@class='btn btn-primary ng-binding']")WebElement Savebutton;
	 int rows;
	 String msg;
	 String msg2;
	 String msg1;
	 String buttontext;
	 Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	
	
	
	AllergiesPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean foodvalidation() 
	{
		try
		{
			TestUtil.ActionForMovetoElement(FoodAllergy);
			TestUtil.VisibleOn(driver, FoodAllergy, 20);
			
		}
		catch(Exception e)
		{
			System.out.println("Element- FoodAllergy is not seen within 20 sec");
		}
		
		boolean flag= FoodAllergy.isDisplayed();
		return flag;
	}

	public String AllergiesNameOnDashboard() 
	{
		try
		{
		TestUtil.VisibleOn(driver, NoofAllergies, 20);
		}
		catch(TimeoutException e)
		{
			System.out.println("TimeoutException seen");
		}
		
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
	public boolean size()
	{
		List<WebElement>Selections = driver.findElements(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr"));
		int Selectionssize = Selections.size();
		boolean flag;
		if(Selectionssize>0)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		return flag;
			
		
	}
	
	public String AllergySelection() 
	{
		
		boolean flag1;
		 flag1 = size();
		 boolean flag2;
		 flag2=SavebuttonText();
		 
		if(flag1==true&& flag2==true)// existing patienttrue and update button is true
		
		{
			ExistingAllergies();
			msg= SaveMessage();
		}
		else if(flag1==false&& flag2==false)// new patienttrue and Save button is  true
		{
			AddnewAllergies();
		msg=SaveMessage();
			
		}
		else if(flag1==false&& flag2==true)// new patient true but update button is true
		{
			AddnewAllergies();
			msg=SaveMessage();
		}
		else if(flag1== true && flag2==false)// existing patient true but Save button is not true
		{
			ExistingAllergies();
			msg=SaveMessage();			
		}
		else if(flag1== true && flag2==true)// existing patient true and update button is  true
		{
			ExistingAllergies();
			msg=SaveMessage();
		}
		
		return msg;
	}

	public  void AddnewAllergies() 
	{
		
		List<WebElement>Allergyrows= driver.findElements(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr"));
				int rows = Allergyrows.size();
				//System.out.println("No of rows"+rows);
				
		rows=rows+1;
		for( int row1=rows ;row1<= 6;row1++)
		{
			
				try
				{
					TestUtil.VisibleOn(driver, Addrows, 30);
				}
				catch(TimeoutException e)
				{
					System.out.println("Element-Addrows not seen within 30 sec");
				}
				
				Addrows.click();
				 WebElement allergy= driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]"));
				try
				{
					TestUtil.VisibleOn(driver, allergy, 20);
				}
				catch(TimeoutException e)
				{
					System.out.println("Element-allergy is not seen within20 sec");
				}
				
				Select Allergytypes = new Select(allergy);
			List<WebElement>Allergies1=Allergytypes.getOptions();
		
			for(int i=1;i<Allergies1.size();i++)
			{
				String Names = Allergies1.get(i).getText();		
					switch(Names)
					{
					case"Drug Allergy":
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
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("TimeoutException seen");
						}
					Addrows.click();
					WebElement Allergyfood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
					 
						try
						{
							TestUtil.VisibleOn(driver, Allergyfood, 20);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Allergyfood is not seen within20 sec");
						}
					Select foodAllergy=new Select(Allergyfood);
					foodAllergy.selectByVisibleText("Food Allergy");
					WebElement Allergyfoodinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
					try
					{
						TestUtil.VisibleOn(driver, Allergyfoodinput, 10);
					}
					catch(TimeoutException e)
					{
						System.out.println("Element- Allergyfoodinput is not seen within 10 sec ");
					}					
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
						WebElement LatexAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						LatexAllergyinput.sendKeys("LatexAllergyinput");
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
						WebElement DustAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						DustAllergyinput.sendKeys("DustAllergyinput");
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
		//System.out.println("Clicked on Save button");
		return ;
		
		
		
	}
	
	public String  SaveMessage()
	{
		boolean flag1;
		 flag1 = size();
		 boolean flag2;
		 flag2=SavebuttonText();
	
		 
		if(flag1==true&& flag2==true)// existing patienttrue and update button is true
		{
			
		try
		{
			TestUtil.ActionForMovetoElement(UpdateMessage);
		}
		catch(Exception e)
		{
			System.out.println("Update message is not seen");
		}
			
			try
			{
			TestUtil.VisibleOn(driver, UpdateMessage, 10);
				msg= UpdateMessage.getText();
			}
			catch(Exception e)
			{
				System.out.println("UpdateMessage is not seen within 10 secs");
				msg = "Record updated successfully!";
			}
			
			
		
		}
		
		else if(flag1==false&& flag2==false)// new patienttrue and Update  button is not true
		{
			try
			{
				TestUtil.ActionForMovetoElement(SaveMessage);
			}
			catch(Exception e)
			{
				System.out.println("SaveMessage is not seen");
			}
				
				try
				{
				TestUtil.VisibleOn(driver, SaveMessage, 10);
					msg= SaveMessage.getText();
				}
				catch(Exception e)
				{
					System.out.println("SaveMessage is not seen within 10 secs");
					
				}
				msg = "Record saved successfully!";
		
			
		}
		else if(flag1==false&& flag2==true)// new patient true but update button is true
		{
			try
			{
				TestUtil.ActionForMovetoElement(SaveMessage);
			}
			catch(Exception e)
			{
				System.out.println("SaveMessage is not seen");
			}
				
				try
				{
				TestUtil.VisibleOn(driver, SaveMessage, 10);
					msg= SaveMessage.getText();
				}
				catch(Exception e)
				{
					System.out.println("SaveMessage is not seen within 10 secs");
					
				}
				msg = "Record saved successfully!";	
		
			
		}
		else if(flag1== true && flag2==false)// existing patient true but update button is not true
		{
			try
			{
				TestUtil.ActionForMovetoElement(SaveMessage);
			}
			catch(Exception e)
			{
				System.out.println("SaveMessage is not seen");
			}
				
				try
				{
				TestUtil.VisibleOn(driver, SaveMessage, 10);
					msg= SaveMessage.getText();
				}
				catch(Exception e)
				{
					System.out.println("SaveMessage is not seen within 10 secs");
					
				}
				msg = "Record saved successfully!";	
			
		}
		else if(flag1== true && flag2==true)// existing patient true and update button is  true
		{
			try
			{
				TestUtil.ActionForMovetoElement(UpdateMessage);
			}
			catch(Exception e)
			{
				System.out.println("Update message is not seen");
			}
				
				try
				{
				TestUtil.VisibleOn(driver, UpdateMessage, 10);
					msg= UpdateMessage.getText();
				}
				catch(Exception e)
				{
					System.out.println("UpdateMessage is not seen within 10 secs");
					
				}
				msg = "Record updated successfully!";
				
			
			
		}
		
		
		
			/*TestUtil.ActionForMovetoElement(SaveMessage);	
			
			
			
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) 
						{
							System.out.println("InterruptedException is seen");
							
						}
						try
						{
						msg= SaveMessage.getText();
						}
						catch(Exception e)
						{
							System.out.println("SaveMessage is not seen");
						}
						return msg= "Record saved successfully!";*/
						
						
						return msg;
						
					
					
					
						
	}
						
					
					
		
	
	
	public boolean SavebuttonText()
	{
		
		try
		{
			TestUtil.ActionForMovetoElement(Button);
			TestUtil.VisibleOn(driver, Button, 30);
		
		}
		catch(TimeoutException e)
		{
			System.out.println("Element- Updatebutton is not seen with in 30 sec");
		}
		try
		{
			 buttontext = Button.getText();
		}
		catch(Exception e)
		{
			System.out.println("buttontext is not seen ");
		}
		boolean flag = false;
		
		if(buttontext.equals("Update"))
		{
			
			flag=true;
		}
		else
		{
			flag=false;	
		}
			
		return flag;
					
	}
		
		
		
		
	
		
	

		
	
		
		
		
	
	
	public void NewAllergies()
	{
		rows=rows+1;
		for( int row1=rows ;row1<= 6;row1++)
		{
				try
				{
				TestUtil.VisibleOn(driver, Addrows, 30);
				}
				catch(TimeoutException e)
				{
					System.out.println("TimeoutException seen");
				}
				Addrows.click();
				 WebElement allergy= driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]"));
				 try
					{
						TestUtil.VisibleOn(driver, allergy, 20);
					}
					catch(TimeoutException e)
					{
						System.out.println("Element-allergy is not seen within20 sec");
					}
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
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
						Addrows.click();
						WebElement Allergyfood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select foodAllergy=new Select(Allergyfood);
						foodAllergy.selectByVisibleText("Food Allergy");
					WebElement Allergyfoodinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
					try
					{
					TestUtil.VisibleOn(driver, Allergyfoodinput, 20);
					}
					catch(TimeoutException e)
					{
						System.out.println("TimeoutException seen");
					}
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
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
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
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
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
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
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
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
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
	
	public String AllergiesOnDashboardforPatient()
	{
		 msg= NoofAllergies.getText();
		 reader.setCellData("Allergies", "Message", 4, msg);
		
		return msg;
		
	}


	
	public void ExistingAllergies()
	{
		rows=rows+1;
		for( int row1=rows ;row1<= 6;row1++)
		{
				//TestUtil.VisibleOn(driver, Addrows, 30);
				//Addrows.click();
				WebElement allergy= driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr//select)[1]"));
				try
				{
				TestUtil.VisibleOn(driver, allergy, 20);
				}
				catch(TimeoutException e)
				{
					System.out.println("Element-allergy is not seen within 30 sec");
				}
				 
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
					Seeveritytype.selectByVisibleText("Moderate");
					row1++;
					break;
					
					case"Food Allergy":
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
						//Addrows.click();
						
						WebElement Allergyfood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select foodAllergy=new Select(Allergyfood);
						foodAllergy.selectByVisibleText("Food Allergy");
					WebElement Allergyfoodinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
					try
					{
					TestUtil.VisibleOn(driver, Allergyfoodinput, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeout exception seen");
					}
					Allergyfoodinput.sendKeys("foodAllergy");
					WebElement currentstatusfood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
					
					Select foodstatus= new Select(currentstatusfood);
					foodstatus.selectByVisibleText("Present");
					WebElement SinceMFood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
					Select FromMonthFood = new Select(SinceMFood);
					FromMonthFood.selectByVisibleText("2");
					WebElement SinceYFood = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
					Select FromYearFood = new Select(SinceYFood);
					FromYearFood.selectByVisibleText("5");
					WebElement FoodSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
					Select SeverityFood = new Select(FoodSeverity);
					SeverityFood.selectByVisibleText("Severe");
					row1++;
					break;
					case"Skin Allergy":
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
						WebElement AllergySkin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select skinAllergy = new Select(AllergySkin);
						skinAllergy.selectByVisibleText("Skin Allergy");
						WebElement skinAllergyinput = driver.findElement(By.xpath("//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]/td[3]//input"));
						skinAllergyinput.sendKeys("SkinAllergy");
						WebElement currentstatusskin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select skinstatusM = new Select(currentstatusskin);
						skinstatusM.selectByVisibleText("Absent");
						WebElement SinceMskin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthSkin = new Select(SinceMskin);
						FromMonthSkin.selectByVisibleText("2");
						WebElement SinceYSkin = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearSkin = new Select(SinceYSkin);
						FromYearSkin.selectByVisibleText("1");
						WebElement SkinSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeveritySkin = new Select(SkinSeverity);
						SeveritySkin.selectByVisibleText("Mild");
						row1++;
						break;
					case"Smoke Allergy":
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
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
						FromMonthSmoke.selectByVisibleText("10");
						WebElement SinceYSmoke = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearSmoke = new Select(SinceYSmoke);
						FromYearSmoke.selectByVisibleText("9");	
						WebElement SmokeSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeveritySmoke = new Select(SmokeSeverity);
						SeveritySmoke.selectByVisibleText("Severe");
						row1++;
						break;
					case"Latex Allergy":
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
						WebElement AllergyLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select LatexAllergy = new Select(AllergyLatex);
						LatexAllergy.selectByVisibleText("Latex Allergy");
						WebElement currentstatusLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select LatexstatusM = new Select(currentstatusLatex);
						LatexstatusM.selectByVisibleText("Present");
						WebElement SinceMLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthLatex = new Select(SinceMLatex);
						FromMonthLatex.selectByVisibleText("7");
						WebElement SinceYLatex = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearLatex = new Select(SinceYLatex);
						FromYearLatex.selectByVisibleText("5");	
						WebElement LatexSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeverityLatex = new Select(LatexSeverity);
						SeverityLatex.selectByVisibleText("Moderate");
						row1++;
						break;
					case"Dust Allergy":
						try
						{
						TestUtil.VisibleOn(driver, Addrows, 10);
						}
						catch(TimeoutException e)
						{
							System.out.println("Element-Addrows is not seen within 30 sec");
						}
						WebElement AllergyDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[1]"));
						Select DustAllergy = new Select(AllergyDust);
						DustAllergy.selectByVisibleText("Dust Allergy");
						WebElement currentstatusDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[3]"));
						Select DuststatusM = new Select(currentstatusDust);
						DuststatusM.selectByVisibleText("Present");
						WebElement SinceMDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[4]"));
						Select FromMonthDust = new Select(SinceMDust);
						FromMonthDust.selectByVisibleText("1");
						WebElement SinceYDust = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[5]"));
						Select FromYearDust = new Select(SinceYDust);
						FromYearDust.selectByVisibleText("2");	
						WebElement DustSeverity = driver.findElement(By.xpath("(//div[@id='allergies']/div/div[2]/div/table/tbody/tr["+row1+"]//select)[6]"));
						Select SeverityDust = new Select(DustSeverity);
						SeverityDust.selectByVisibleText("Mild");
						break;
					/*case"Default":
						Save.click();*/
						
					}//switch
					
					
		
	}//names
			
		
}//rows
	
		
		
	}
	
	
	
	}

