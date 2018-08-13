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
	@FindBy(xpath = "//label[contains (text() , 'LMP')]//following-sibling::div//input")WebElement Inputcalender;
	
	String msg;
	String thismonth;
	boolean flag3;
	
	
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
		int count = 0;
		int count1 = count - 1;

		try {
			TestUtil.VisibleOn(driver, lmpPcalender, 20);
		} catch (Exception e) {
			System.out.println("Element is not seen within time");
			
		}
		lmpPcalender.click();
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
		boolean flag = true;
		for (int l = 0; l < Dates.size(); l++) 
		{

			count1++;
			if (flag == false) 
			{
				break;
			}

			String firstdate = Dates.get(l).getText();

			if (firstdate.equals("01")) // this loop starts from 01 date of calender
			{

				for (int i = count1; i < Dates.size(); i++) 
				{

					String Datetext = Dates.get(i).getText();
					WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
					String text = Monthtextele.getText();
					String Arr[] = text.split(" ");
					String Monthtext = Arr[0];

					String CyrrentDate = TestUtil.Date();
					String[] Arr1 = CyrrentDate.split(",");
					String day = Arr1[0];
					String Month = Arr1[1];

					boolean flag1 = Dates.get(i).isEnabled();

					if (Datetext.equals(day) && flag1 == true && Monthtext.equals(Month)) 
					{
						Dates.get(i).click();
						try 
						{
							TestUtil.VisibleOn(driver, Inputcalender, 30);
							TestUtil.ActionForMovetoElement(Inputcalender);

						} 
						catch (Exception e) 
						{
							System.out.println("Element- Inputcalender is snot seen with in 30 sec");

						}
						flag = false;
						
						msg = Inputcalender.getAttribute("value");
						
						
						String Date= TestUtil.DateForCompare();
						if(Date.equals(msg))
						{
							flag3=true;
							break;
						}
						else
						{
							flag3= false;
							break;
						}
						
					}
					
					
				}
			}
		}
		return flag3;
		
		
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
