package com_milan_POM;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class SexualHistoryPage extends TestBase
{
	@FindBy (xpath="//label[text()= 'In relationship since']//following::select[1]")WebElement yeardropdown;
	@FindBy (xpath= "//label[text()= 'In relationship since']//following::select[2] ")WebElement monthdropdown;
	@FindBy (xpath="//label[text()= 'Contraception']//following::select[1]")WebElement Contraception;
	@FindBy	(xpath="//label[text()= 'Trying to concieve since']//following::select[1]")WebElement concieveyears;
	@FindBy	(xpath="//label[text()= 'Trying to concieve since']//following::select[2]")WebElement concievemonths;
	//@FindBy (xpath="//label[text()= 'Duration']//following::select[1]")WebElement Durationyrs;
	@FindBy (xpath="//label[text()= 'Duration']//following::select[2]")WebElement Durationmnths;
	@FindBy (xpath="//label[text()= 'Method of Contraception']//following::select[1]")WebElement MethodofContraception;
	@FindBy	(xpath= "//label[text()= 'Infertility Type']//following::select[1]")WebElement InfertilityType;
	@FindBy (xpath="//label[text()= 'Male Infertility']//following::select[1]")WebElement MaleInfertility; 
	@FindBy (xpath="//label[text()= 'Female Infertility']//following::select[1]")WebElement FemaleInfertility;
	@FindBy (xpath= "//label[text()= 'Frequency of intercourse']//following::select[1]")WebElement Frequencyofintercourse;
	@FindBy(xpath="//label[text()= 'Sexual Dysfunction']//following::select[1]")WebElement SexualDysfunction;
	@FindBy(xpath="//button[@id='btnSaveUpdateHistory']")WebElement Save;
	@FindBy(xpath="//*[@id='toasty']/div//span[text()='Record updated successfully!']")WebElement updatemsg;
	@FindBy(xpath= ("//span[text()='History']"))WebElement History;
	@FindBy(xpath="//label[text()= 'Sexual Dysfunction']//following::textarea[1]")WebElement textboxSexualDysfunction;
	@FindBy(xpath= "//label[text()='Sexual Dysfunction']//following::label[1]")WebElement sexualDysfunctionschar;
	@FindBy(xpath="//label[text()= 'Dyspareunia']//following::select")WebElement Dyspareunia; 
	@FindBy(xpath="//label[text()='Dyspareunia']//following::textarea[1]")WebElement Dyspareuniatext;
	@FindBy(xpath="//label[text()='Lubrication used']//following::select[1]")WebElement Lubricationused;
	@FindBy(xpath="//label[text()='Lubrication used']//following::textarea[1]")WebElement Lubricationusedtext;
	@FindBy(xpath="(//label[text()='Remarks'])[2]//following::textarea[1]")WebElement remarktext;
	
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	
	SexualHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void formfilling() 
	{
		System.out.println("WSexsualHistory form fill testcase started");
		WebElement relasionshipyears= driver.findElement(By.xpath("//label[text()= 'In relationship since']//following::select[1]"));
		try
		{
		TestUtil.VisibleOn(driver, relasionshipyears, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutException");
		}
		Select year = new Select(relasionshipyears);
		year.selectByVisibleText("8");
		List<WebElement>year1 = year.getOptions();
		System.out.println(year1);
		
		Select month = new Select(monthdropdown);		
		month.selectByVisibleText("2");
		Select tryingyrs = new Select(concieveyears);
		tryingyrs.selectByVisibleText("4");
		Select yryingmths = new Select(concievemonths);
		tryingyrs.selectByVisibleText("4");
		try
		{
		TestUtil.VisibleOn(driver, Contraception, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutException seen");
		}
		Select contra= new Select(Contraception);
		contra.selectByVisibleText("Yes");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		/*Select MOC= new Select(MethodofContraception);
		MOC.selectByVisibleText("5");*/
		Select ME= new Select(MaleInfertility);
		ME.selectByVisibleText("No");
		
		WebElement Durationyrs= driver.findElement(By.xpath("//label[text()= 'Duration']//following::select[1]"));
		TestUtil.VisibleOn(driver, Durationyrs, 30);
		System.out.println(Durationyrs.isDisplayed());
		/*Select Durationyears = new Select(Durationyrs);
		Thread.sleep(2000);
		Durationyears.selectByVisibleText("2");*/
		Select MonthsDuration = new Select(Durationmnths);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		MonthsDuration.selectByVisibleText("6");
		Select InefertilityType = new Select(InfertilityType);
		InefertilityType.selectByVisibleText("Primary");
		Select MInfertility = new Select(MaleInfertility);
		MInfertility.selectByVisibleText("No");
		Select FInfertility = new Select(FemaleInfertility);
		FInfertility.selectByVisibleText("Yes");		
		Select incoursefrequency = new Select(Frequencyofintercourse);
		incoursefrequency.selectByVisibleText("Weekly Once");
		Select Dys = new Select(Dyspareunia);
		Dys.selectByVisibleText("Yes");
		Select SexualDyfunction = new Select(SexualDysfunction);
		SexualDyfunction.selectByVisibleText("Yes");
		Save.click();
		
		
		
		
		
	}
	public boolean textboxSexualDysfunction()
	{
		Select SexualDyfunction = new Select(SexualDysfunction);
		SexualDyfunction.selectByVisibleText("Yes");
		textboxSexualDysfunction.sendKeys("Test");
		return  textboxSexualDysfunction.isDisplayed();
		
	}
	
	
	
	public String SexsualHistoryTitle()
	{
	 String message = History.getText();
		return message;
	}
	
		
		



	public boolean validateRelstionship() 
{
		System.out.println("WSexsualHistory form fill testcase started");
		String years= reader.getCellData("SexualHistory", 0, 8);
		Select year = new Select(yeardropdown);
		year.selectByVisibleText("6");
		List<WebElement>year1 = year.getOptions();
		String relationyears= year1.get(7).getText();
		int yearsize= year1.size();
		System.out.println("Relationshipyrs"+relationyears);
		Select month = new Select(monthdropdown);		
		month.selectByVisibleText("2");
		List<WebElement>month1= month.getOptions();
		String relationmonths= month1.get(8).getText();
		int monthsize = month1.size();
		System.out.println(monthsize);
		System.out.println("Relationshipmonths"+ relationmonths);
		WebElement Durationyrs= driver.findElement(By.xpath("//label[text()= 'Duration']//following::select[1]"));
		try
		{
		TestUtil.VisibleOn(driver, Durationyrs, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutException");
		}
		Select Durationyears = new Select(Durationyrs);
		 List<WebElement>durationyear =Durationyears.getOptions();
		 String durationyrs = durationyear.get(7).getText();
		int yrsize= durationyear.size();
		String yrs= reader.getCellData("SexualHistory", 0, 8);
		Durationyears.selectByVisibleText("6");
		//System.out.println("Durationyears"+ durationyrs);
		Select Durationmonth = new Select(Durationmnths);
		 List<WebElement>durationmonth=Durationmonth.getOptions();
		String durationmths= durationmonth.get(9).getText();
		 int mnthsize= durationmonth.size();		 
		 System.out.println("Duration month size"+durationmths);
		 boolean flag=false;
		 if(relationyears.equals(durationyrs)  &&relationmonths.equals(durationmths))
		 {
			 flag=true;
			 Save.click();
		 }
			 
		
		
		return true; 		
	}
	
	
	public int relationshipyears()
	{
		
		Select year = new Select(yeardropdown);
		List<WebElement>years = year.getOptions();
		int relationshipyears=  years.size()-1;
		return relationshipyears;
	
	}
	public int relationshipmonths()
	{
		Select year = new Select(yeardropdown);
		Select month = new Select(monthdropdown);		
		List<WebElement>month1= month.getOptions();
		int relationshipmonths = month1.size()-1;	
		return relationshipmonths;
		
	}
	public double TryingToConcieveSinceYear()
	{
		
		double convinceyears = 0;
		int count= reader.getRowCount("SexualHistory");
		for(int rows=2;rows<=count;rows++)
		{
		String relationsince= reader.getCellData("SexualHistory", 0, rows);
		if(relationsince.equals("12"))
		{
		Select year = new Select(yeardropdown);
		year.selectByVisibleText(relationsince);
		Select concieveyears1 = new Select(concieveyears);
		List<WebElement>years=concieveyears1.getOptions();
				double convinceyears1= years.size()-1;
				convinceyears= convinceyears1;
				break;
				
			}
		
		}	
		return convinceyears;
	}
		
		
		public double TryingToConcieveSinceMonth()
		{
			
			double convinceMonth = 0;
			int count= reader.getRowCount("SexualHistory");
			for(int rows=2;rows<=count;rows++)
			{
			String relationsinceM= reader.getCellData("SexualHistory", 0, rows);
			if(relationsinceM.equals("5"))
			{
			Select year = new Select(monthdropdown);
			year.selectByVisibleText(relationsinceM);
			Select concieveyears1 = new Select(concieveyears);
			List<WebElement>years=concieveyears1.getOptions();
					double convinceMonth1= years.size()-1;
					convinceMonth= convinceMonth1;
					break;
					
				}
			
			}	
			return convinceMonth;
		
	}
	
	
	
	
	
	
	public String SexualDysfunctioncharacters()
	{
		
		final String myLongString = "abcd";
		final int longStringLength = myLongString.length();
		Select SexualDyfunction = new Select(SexualDysfunction);
			SexualDyfunction.selectByVisibleText("Yes");
		WebElement textbox = driver.findElement(By.xpath("//label[text()= 'Sexual Dysfunction']//following::textarea[1]"));
		try
		{
		TestUtil.VisibleOn(driver, textbox, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutException");
		}
		textbox.sendKeys(myLongString);
		
		WebDriverWait wait1= new WebDriverWait(driver, 50);
		WebElement Number= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Sexual Dysfunction']//following::label[1]")));
		String number=Number.getText();
		return number;
		
	}
		
	public boolean DyspareuniaText()
	{
		Select Dyspareuniatest= new Select(Dyspareunia);
		Dyspareuniatest.selectByVisibleText("Yes");
		Dyspareuniatext.isDisplayed();		
		return true;
		
	}
	
	public boolean Lubricationusedtext()
	{
		
		Select Lubricationusedt= new Select(Lubricationused);
		Lubricationusedt.selectByVisibleText("Yes");
		Lubricationusedtext.isDisplayed();		
		return true;		
	}
	public String  Remarktext() 
	{
		String longString = "Q6QYryfgrMIpJ76dgn4RVPZylNFUgpFlSi3j2GYQasyUpI87nzjlBPTsooyvcv3Udk8IGDp4AWfgXbx68Ohw6jbVMMqPzI40F7q7imKWHSuHz18Qj9oqk6wDsDIFvdigS3S8fbF3wTrb25OJCgdpN8MWL2X77Iy95KIgLIbZbk12GU4Cx7hsL6ezsx7WY9JmVLAxP6ooY0z80aPDfiE2QaCgDuYROWz5DFLhYdfAfOGR4C0gvp6QILiiY0";
		remarktext.sendKeys(longString);
		//Save.click();
		WebDriverWait wait1= new WebDriverWait(driver, 50);
		WebElement Number= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='Remarks'])[2]//following::label[1]")));
		String get=	remarktext.getText();
		String number=Number.getText();
		return number;
	}
	
	
		
		
		
	}
	




