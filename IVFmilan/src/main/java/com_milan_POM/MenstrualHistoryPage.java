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

public class MenstrualHistoryPage extends TestBase
{
	@FindBy(xpath= "//label[text()= 'Age of Menarche(In years)']//following::select[1]")WebElement AgeofMenarche;
	@FindBy(xpath="//label[text()='LMP']//following::i")WebElement lmpPcalender;
	@FindBy(xpath="//label[text()='Amenorrhea Type']//following::select[1]")WebElement AmenorrheaType;
	@FindBy(xpath="//label[text()='Cycle Duration']//following::input[1]")WebElement CycleDuration;
	@FindBy(xpath="//label[text()='Cycle Duration']//following::input[2]")WebElement Menstruation ;
	@FindBy(xpath="//button[@id='btnSaveUpdateHistory']")WebElement Save;
	@FindBy(xpath="//label[text()='Menstrual Flow']//following::select[1]")WebElement MenstrualFlow;
	@FindBy(xpath="//label[text()='Menstrual Flow']//following::textarea[1]")WebElement MenstrualFlowtext;
	WebDriverWait wait= new WebDriverWait(driver, 50);
	
	
	MenstrualHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String AgeOfMenarcheFirst()
	{
		Select AgeofMenarcheY= new Select(AgeofMenarche);
		AgeofMenarcheY.selectByVisibleText("8");
		List<WebElement>year= AgeofMenarcheY.getOptions();
		String  first= year.get(1).getText();
		
		System.out.println("valueofelement"+first);		
		return  first;
		
	}
	public String AgeOfMenarcheLast()
	{
		Select AgeofMenarcheY= new Select(AgeofMenarche);
		AgeofMenarcheY.selectByVisibleText("8");
		List<WebElement>year= AgeofMenarcheY.getOptions();
		String  Last= year.get(11).getText();
		
		System.out.println("valueofelement"+Last);		
		return  Last;
		
	}
	public boolean DatePicker()
	{
		lmpPcalender.click();
		List<WebElement> datenodes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//tbody//td")));
		int Totalnodes= datenodes.size();
		for(int i=0;i<Totalnodes;i++)
		{
			String date = datenodes.get(i).getText();
			WebElement date1= datenodes.get(i);
			if(date.equals("28"));
			{
				date1.isDisplayed();
				break;
			}
		}
		
		
		
		
		
		return false;
		
	}
	
	public boolean AmenorrheaType()
	{
		WebElement Ammenorhea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Ammenorhea']//following::select[1]")));
		Select Ammenorheatest= new Select(Ammenorhea);
		Ammenorheatest.selectByVisibleText("Absent");
		AmenorrheaType.isDisplayed();		
		return false;
		
	}
	public String GetCycleDurationvalue() throws Exception
	{
		
	WebElement CycleDurationvalue= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Cycle Duration']//following::input[1]")));
	CycleDurationvalue.sendKeys("20");
	String CycleDurationvalue1 = CycleDuration.getAttribute("value");
	System.out.println("value in CycleDuration is" + CycleDurationvalue1  );
	
	return CycleDurationvalue1;		
	}
	public void Savevaluesindurations()
	{
		double a = 0.1;
		double b =0.2;
		String s = String.valueOf(a);
		String s1 = String.valueOf(b);
		System.out.println("CycleDuration"+s);
		
		if(CycleDuration.isDisplayed())
		{
			CycleDuration.sendKeys(s);
			
		}
		if(Menstruation.isDisplayed())
		{
			Menstruation.sendKeys(s1);
		}
		Save.click();
	}
	
	public String GetMenstruationvalue()
	{
		WebElement Menstruation= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Cycle Duration']//following::input[2]")));
		Menstruation.sendKeys("10");
		String Menstruationvalue = Menstruation.getAttribute("value");
		
		
		return Menstruationvalue;
		
	}
	
	public boolean MenstrualFlowText()
	{
		Select IntermenstrualBleeding1 = new Select(MenstrualFlow);
		IntermenstrualBleeding1.selectByVisibleText("Scanty");
		WebElement MenstrualFlowtext =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Menstrual Flow']//following::textarea[1]")));	
		System.out.println(MenstrualFlowtext.isDisplayed());
		return true;
	}
	
	
	
	

}
