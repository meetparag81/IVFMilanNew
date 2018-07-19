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
import com_Milan_util.TestUtil;

public class MenstrualHistoryPage extends TestBase
{
	@FindBy(xpath= "//label[text()= 'Age of Menarche(In years)']//following::select[1]")WebElement AgeofMenarche;
	@FindBy(xpath="//label[text()='LMP']//following::i")WebElement lmpPcalender;
	@FindBy(xpath="//label[text()='Amenorrhea Type']//following::select[1]")WebElement AmenorrheaType;
	@FindBy(xpath="//label[text()='Cycle Duration']//following::input[1]")WebElement CycleDuration;
	@FindBy(xpath="//label[text()='Cycle Duration']//following::input[2]")WebElement Menstruation ;
	@FindBy(xpath="//button[@id='btnSaveUpdateHistory']")WebElement Save;
	@FindBy(xpath="//button[text()=' Update'][@class='btn btn-primary ng-binding']")WebElement Update;
	@FindBy(xpath="//label[text()='Menstrual Flow']//following::select[1]")WebElement MenstrualFlow;
	@FindBy(xpath="//label[text()='Menstrual Flow']//following::textarea[1]")WebElement MenstrualFlowtext;
	@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement UpdateMessage;
	@FindBy(xpath = "//label[text()='Dysmennorhea']//following-sibling::div/select")WebElement Dysmennorhea;
	@FindBy(xpath="//label[text()='Intermenstrual Bleeding']//following-sibling::div/select")WebElement IntermenstrualBleeding;
	@FindBy(xpath="//label[text()='LMP']//following-sibling::div//input[@id='Date']")WebElement Datetext;
	
	String msg;
	String thismonth;
	
	
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
		boolean flag= false;
		lmpPcalender.click();
		String currentdate= TestUtil.Date();
		String arr[] = currentdate.split(",");
		String day= arr[0];
		String month= arr[1];
		String year= arr[2];
		
		TestUtil.ActionForMovetoElement(Datetext);
		Datetext.clear();
		WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
		String monthtext= Monthtextele.getText();
		String montharr[] = monthtext.split(" ");
		String Currentmonth= montharr[0];
		String Currentyear= montharr[1];
		if(Currentmonth.equals(month))
		{
			List<WebElement> datenodes = driver.findElements(By.xpath("//table[@role='grid']//tbody//td/button"));
			try
			{
			TestUtil.VisibleElementsOn(driver, datenodes, 30);
			}
			catch(Exception e)
			{
				System.out.println("TimeoutExceptionseen");
			}
			int Totalnodes= datenodes.size();
			for(int i=0;i<Totalnodes;i++)
			{
				String date = datenodes.get(i).getText();
				
				boolean flag1= datenodes.get(i).isEnabled();
				if(date.equals(day)&&month.equals(Currentmonth) );
				{
					
					datenodes.get(i).click();
					
					break;
				}
			}
		
		}
		else
		{
			Monthtextele.click();
			List<WebElement>Monthnodes = driver.findElements(By.xpath("//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']//div//table//tbody//td"));
			for(WebElement month1:Monthnodes)
			{
				 thismonth= month1.getText();
				boolean flag2= month1.isEnabled();
				if(thismonth.equals(month)&&flag2==true)
				{
					month1.click();
					break;
				}
				
			}
			List<WebElement> datenodes = driver.findElements(By.xpath("//table[@role='grid']//tbody//td/button"));
			try
			{
			TestUtil.VisibleElementsOn(driver, datenodes, 30);
			}
			catch(Exception e)
			{
				System.out.println("TimeoutExceptionseen");
			}
			int Totalnodes= datenodes.size();
			for(int i=0;i<Totalnodes;i++)
			{
				String date = datenodes.get(i).getText();
				
				boolean flag1= datenodes.get(i).isEnabled();
				
				if(date.equals(day)&&flag1==true&&thismonth.equals(month))
				{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) 
				{
				System.out.println("InterruptedException is seen");
				}
				flag=datenodes.get(i).isEnabled();
				datenodes.get(i).click();
				break;
				}
					
			}
			
		
		}
		
		return flag;
		
	}
	
	public boolean AmenorrheaType()
	{
		WebElement Ammenorhea = driver.findElement(By.xpath("//label[text()='Ammenorhea']//following::select[1]"));
		try
		{
			TestUtil.VisibleOn(driver, Ammenorhea, 30);
		}
		catch(Exception e)
		{
			System.out.println("Element-Ammenorhea is not seen within 30 sec ");
		}
		Select Ammenorheatest= new Select(Ammenorhea);
		Ammenorheatest.selectByVisibleText("Absent");
		AmenorrheaType.isDisplayed();		
		return false;
		
	}
	
	
	public String GetCycleDurationvalue() 
	{
		
	WebElement CycleDurationvalue= driver.findElement(By.xpath("//label[text()='Cycle Duration']//following::input[1]"));
	try
	{
		TestUtil.VisibleOn(driver, CycleDurationvalue, 30);
	}
	catch(Exception e)
	{
		System.out.println("Element-CycleDurationvalue is not seen within 30 sec ");
	}
	CycleDurationvalue.clear();
	CycleDurationvalue.sendKeys("20");
	String CycleDurationvalue1 = CycleDuration.getAttribute("value");
	//System.out.println("value in CycleDuration is" + CycleDurationvalue1  );
	
	return CycleDurationvalue1;		
	}
	public void SaveValuesInDurations()
	{
		double a = 0.1;
		double b =0.2;
		String s = String.valueOf(a);
		String s1 = String.valueOf(b);
		//System.out.println("CycleDuration"+s);
		
		if(CycleDuration.isDisplayed())
		{
			CycleDuration.sendKeys(s);
			
		}
		if(Menstruation.isDisplayed())
		{
			Menstruation.sendKeys(s1);
		}
		
	}
	
	public String GetMenstruationvalue()
	{
		WebElement Menstruation= driver.findElement(By.xpath("//label[text()='Cycle Duration']//following::input[2]"));
		try
		{
		TestUtil.VisibleOn(driver, Menstruation, 30);
		}
		catch(Exception e)
		{
			System.out.println("Element-Menstruation is not seen within 30 sec ");
		}
		Menstruation.clear();
		Menstruation.sendKeys("10");
		String Menstruationvalue = Menstruation.getAttribute("value");
		
		
		return Menstruationvalue;
		
	}
	
	public boolean MenstrualFlowText()
	{
		Select IntermenstrualBleeding1 = new Select(MenstrualFlow);
		IntermenstrualBleeding1.selectByVisibleText("Scanty");
		WebElement MenstrualFlowtext =driver.findElement(By.xpath("//label[text()='Menstrual Flow']//following::textarea[1]"));
		try
		{
			TestUtil.VisibleOn(driver, MenstrualFlowtext, 30);
		}
		catch(Exception e)
		{
			System.out.println("Element-MenstrualFlowtext is not seen within 30 sec ");
		}
		
		System.out.println(MenstrualFlowtext.isDisplayed());
		return true;
	}
	public void DysmennorheaOption()
	{
		Select Dysmennorhea1 = new Select(Dysmennorhea);
		Dysmennorhea1.selectByVisibleText("Absent");
	}
	
	public void IntermenstrualBleedingOption()
	{
		Select IntermenstrualBleeding1 = new Select(IntermenstrualBleeding);
		IntermenstrualBleeding1.selectByVisibleText("Present");
	}
	
	
	public boolean SaveButton()
	{
		boolean flag;
		msg = Update.getText();
		if(msg.equals("Update"))
		{
			flag= false;
		}
		else
		{
			flag= true;
		}
		
		
		
		return flag;
		
	}
	
	public String SaveTheForm()
	{
		AgeOfMenarcheFirst();
		DatePicker();
		SaveValuesInDurations();
		MenstrualFlowText();
		DysmennorheaOption();
		IntermenstrualBleedingOption();
		
		boolean flag= SaveButton();
		if(flag==false)
		{
			Update.click();
			TestUtil.VisibleOn(driver, UpdateMessage, 20);
			TestUtil.ActionForMovetoElement(UpdateMessage);
			msg= UpdateMessage.getText();
			msg="Record updated successfully!";
			
		}
		else
		{
			Save.click();
			msg = "Record saved successfully!";
		}
		
		
		return msg;
	}
	
	
	
	

}
