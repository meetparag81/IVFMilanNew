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

public class ObstetricHistoryPage extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	TestUtil Testutl;
	@FindBy(xpath="//span[text()='G']//following::input[1]")WebElement NewRowcount; 
	@FindBy(xpath="//span[text()='G']//following::input[2]")WebElement StillBorn;
	@FindBy(xpath="//span[text()='G']//following::input[3]")WebElement LiveBirth ; 
	@FindBy(xpath="//span[text()='G']//following::input[4]")WebElement Abortion;
	@FindBy(xpath="//span[text()='G']//following::input[5]")WebElement Ectopic;
	@FindBy(xpath="//button[text()='Add Rows'][1]")WebElement AddnewRows;
	@FindBy(xpath="//th[text()='Year']//following::select[1]")WebElement Year;
	@FindBy(xpath="//th[text()='Gestation Weeks']//following::select[2]") WebElement Gestation;  
	@FindBy(xpath="//th[text()='Outcome']//following::select[3]")WebElement outcome;
	@FindBy(xpath= "//button[@id='datepicker-1759-4654-title']//preceding::i")WebElement Previousmonth;
	@FindBy(xpath="//th[text()='Delivery']//following::input[2]")WebElement Birthweight;
	@FindBy(xpath="//th[text()='Delivery']//following::select[6]")WebElement Delivery;
	@FindBy(xpath="//th[text()='Complications']//following::select[7]")WebElement Complications;
	@FindBy(xpath="//th[text()='Congenital Anamoly']//following::select[8]")WebElement CongenitalAnamoly;
	@FindBy(xpath="//th[text()='Congenital Anamoly']//following::input[3]")WebElement Remark;
	@FindBy(xpath="//th[text()='Remark']//following::input[3]")WebElement Remarks;
	@FindBy(xpath="//table[@id='ObstetricHistory']/tbody/tr")WebElement table;
	@FindBy(xpath="(//table[@id='ObstetricHistory']/tbody/tr[1]//td//select)[5]")WebElement DeliveryType;
	@FindBy(xpath="//button[text()='Add Rows'][1]")WebElement Addrows;
	@FindBy(xpath=".//button[@id='btnSaveUpdateHistory']")WebElement Save;
	@FindBy(xpath="//*[@id='ObstetricHistory']/tbody/tr[1]/td[14]/span")WebElement Delete;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	int rows1=0;
	public ObstetricHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public int SaveOutcometypes() throws InterruptedException
	{
		List<WebElement>tablerows= driver.findElements(By.xpath("//table[@id='ObstetricHistory']/tbody/tr"));
		int birthoptions = 0;
		birthoptions= birthoptions+0;
		int rows = tablerows.size();
		rows= rows+1;
		for(int row1=rows;row1<=5;row1++)
		//while(rows1<=5)
		{		
			TestUtil.VisibleOn(driver, Addrows, 30);			  
			Addrows.click();
			WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
			Select Outcomelist = new Select(Outcome);
			List<WebElement>Typeofoutcome = Outcomelist.getOptions();
			for(int i=0;i<Typeofoutcome.size();i++)
			{
				String Names = Typeofoutcome.get(i).getText();
					switch(Names)
					{
						case "Livebirth":
							
							WebElement outcomeLB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[3]"));
							TestUtil.VisibleOn(driver, outcomeLB, 40);
							Select OutcomeL= new Select(outcomeLB);
							OutcomeL.selectByVisibleText("Livebirth");			
							WebElement year= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[1]//select)[1]")));
							Select year1 = new Select(year);
							year1.selectByVisibleText("2010");
							WebElement gestation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[2]")));
							Select Gestation1= new Select(gestation);
							Gestation1.selectByVisibleText("10");						
							WebElement Gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//td//select)[4]")));
							Select Gender1 = new Select(Gender);
							Gender1.selectByVisibleText("Male");
							WebElement Deliverytype= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//td//select)[5]")));
							Select Deliverytype1= new Select(Deliverytype);
							Deliverytype1.selectByVisibleText("Normal");	
							row1++;
								System.out.println("Livebirth entries are completed");
								break;
					case "Ectopic":
						Addrows.click();
						WebElement outcomeEB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[3]")));
						Select OutcomeE= new Select(outcomeEB);
						OutcomeE.selectByVisibleText("Ectopic");
						WebElement yearE= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[1]")));
						Select yearE1 = new Select(yearE);
						Thread.sleep(3000);
						//yearE1.selectByIndex(10);
						WebElement gestationEB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Gestation Weeks']//following::select[2]")));
						Select GestationE= new Select(gestationEB);
						GestationE.selectByVisibleText("10");
						row1++;
						System.out.println("Ectopic entries are completed");
						break;
					case "Abortion":
						Addrows.click();
						WebElement OutcomeAB= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[3]")));
						Select OutcomeA=new Select(OutcomeAB);
						OutcomeA.selectByVisibleText("Abortion");
						WebElement yearA= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[1]")));
						Select yearA1 = new Select(yearA);
						Thread.sleep(2000);
						yearA1.selectByVisibleText("2018");
						WebElement gestationA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Gestation Weeks']//following::select[2]")));
						Select GestationA= new Select(gestationA);
						GestationA.selectByVisibleText("10");
						row1++;
						System.out.println("Abortion entries are completed");
						break;
					case "Still Born":
						Addrows.click();
						WebElement OutcomeSB= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[3]")));
						Select OutcomeSB1= new Select(OutcomeSB);
						OutcomeSB1.selectByVisibleText("Still Born");
						WebElement yearSB= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[1]")));
						Select yearSB1 = new Select(yearSB);
						Thread.sleep(2000);
						yearSB1.selectByVisibleText("2018");
						WebElement gestationSB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Gestation Weeks']//following::select[2]")));
						Select GestationSB= new Select(gestationSB);
						GestationSB.selectByVisibleText("10");
						row1++;
						System.out.println("Still Born entries are completed");
						break;
						
					case "Miscarriage":
						Addrows.click();
						WebElement OutcomeMC= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+row1+"]//select)[3]")));
						Select OutcomeMC1= new Select(OutcomeMC);
						OutcomeMC1.selectByVisibleText("Miscarriage");
						WebElement yearMC= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[3]//select)[1]")));
						Select yearMC1 = new Select(yearMC);
						Thread.sleep(2000);
						yearMC1.selectByVisibleText("2000");
						WebElement gestationMC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Gestation Weeks']//following::select[2]")));
						Select GestationMC= new Select(gestationMC);
						GestationMC.selectByVisibleText("30");
						Delete.click();
						System.out.println("Miscarriage entries are completed");
						break;
						
					}//switch	
					birthoptions++;
			}//outcomefor
		}//rowsfor
		if(Save.isDisplayed())
		{
			Save.click();
			System.out.println("Save is completed");
			
		}
		else
		{
			System.out.println("Save is not completed");
		}
		String  count= NewRowcount.getText();
		int Rowscount = Integer.parseInt(count);
		return Rowscount;
		
		
				
				
					
		
		
	}//main
	public boolean CalenderEnableCondition()
	{
		WebElement Calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//th[text()='Date']//following::i)[1]")));
		Calender.click();
		List<WebElement>Dates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']/tbody/tr//td")));
		int Totaldates =Dates.size();
		for(int j=0;j<Totaldates;j++)
		{
			String Date= Dates.get(j).getText();
			if(Date.equals("14"))
			{
				Dates.get(j).click();
			}
		
	}
			return false;
	}
	
	public boolean BirthWeightEnabled()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Birthweight.isDisplayed();		
		return true;
	}
	
	
	public double BirthWeightText()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Birthweight.sendKeys("1.234");
		String value= Birthweight.getAttribute("value");
		double val= Double.parseDouble(value);
		
		
		
		
		return val;		
		
	}
	
	public boolean OutcomeEnable()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Outcome.isDisplayed();
		return true;
	}
	
	public String OutcomeIsLiveBirth()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		String count = LiveBirth.getAttribute("value");
		
		return count;
		
	}
	
	public String AbortionOptionValue()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Abortion");
		String count = Abortion.getAttribute("value");
		
		return count;
		
	}
	public String EctopicOptionValue()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Ectopic");
		String count = Ectopic.getAttribute("value");
		return count;	
	}
	
	public boolean DileveryTypeEnabledcondition()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		DeliveryType.isDisplayed();
		return true;
		
	}
	public boolean RowGridEnableConditition()
	{
		NewRowcount.isDisplayed();
		return false;
		
	}
	public boolean StillbornGridEnableConditition()
	{
		StillBorn.isDisplayed();
		return false;
	}
	public boolean LivebirthEnableConditition()
	{
		LiveBirth.isDisplayed();
		return false;
	}
	
	public boolean EctopiccEnableConditition()
	{
		Ectopic.isDisplayed();
		return false;
	}
	public boolean AbortionEnableConditition()
	{
		Abortion.isDisplayed();
		return false;
	}
	
	public boolean DeliveroptionEnableConditition()
	{
		
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Delivery.isDisplayed();
		return true;
	}
	public boolean ComplicationsEnableConditition()
	{
		Delivery.isDisplayed();
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Complications.isDisplayed();
		return true;
	}
	public boolean CongenitalAnamolyEnableCondition()
	{
		WebElement Outcome= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Outcome']//following::select[3]")));
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		CongenitalAnamoly.isDisplayed();
		return true;		
	}
	public String LiveBirthPretermcondition() 
	{
		Select Deliveryvalue1 = new Select(Delivery);
		TestUtil.VisibleOn(driver, outcome, 30);
		Select Outcomelist = new Select(outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Select GestationPre = new Select(Gestation);
		GestationPre.selectByVisibleText("35");
		WebElement deliveryoption= Deliveryvalue1.getFirstSelectedOption();
		String Deliveryvalue= deliveryoption.getText();
		
		return Deliveryvalue;
		
	}
	public String LiveBirthFullTermcondition() 
	{
		Select Deliveryvalue1 = new Select(Delivery);
		TestUtil.VisibleOn(driver, outcome, 30);
		Select Outcomelist = new Select(outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Select Gestationfull = new Select(Gestation);
		Gestationfull.selectByVisibleText("42");
		WebElement deliveryoption= Deliveryvalue1.getFirstSelectedOption();
		String Deliveryvalue= deliveryoption.getText();
		
		return Deliveryvalue;
		
	}
	public String LiveBirthAbovePostTermcondition() 
	{
		Select Deliveryvalue1 = new Select(Delivery);
		TestUtil.VisibleOn(driver, outcome, 30);
		Select Outcomelist = new Select(outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Select Gestationpost = new Select(Gestation);
		Gestationpost.selectByVisibleText(">42");
		WebElement deliveryoption= Deliveryvalue1.getFirstSelectedOption();
		String Deliveryvalue= deliveryoption.getText();
		
		return Deliveryvalue;
		
	}
	
	
	
	
	
	
	
	
	
	/*public String RemarkText()
	{
		WebElement remark= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Remark']//following::input[3]")));
		remark.sendKeys("BuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bA");
		TestUtil.VisibleOn(driver, remark, 40);
		String Remarkvalue= remark.getAttribute("value");
		return Remarkvalue;
	}*/
	
	
}

