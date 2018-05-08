package com_milan_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;

public class WVitalsPage extends TestBase
{
private @FindBy(xpath=("(//input[@type='text'])[2]"))WebElement Weight;
private @FindBy(xpath="(//input[@type='text'])[3]")WebElement Height;
private @FindBy(xpath="(//input[@type='text'])[4]") WebElement BMI;
private @FindBy(xpath="(//input[@type='text'])[5]")WebElement BPSystolic;
private @FindBy(xpath="(//input[@type='text'])[6]")WebElement BPDiastolic;
private @FindBy(xpath="(//input[@type='text'])[7]")WebElement HR;
private @FindBy(xpath="(//input[@type='text'])[8]")WebElement Temprature;
Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	 WVitalsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String WeightinKg()
	{
		
		return Weight.getAttribute("value"); 
		
	}
	public boolean HeightIncm()
	{
		boolean Heightstd = true;
		Weight.sendKeys("181");
		String value1 =Weight.getAttribute("value");
		int val = Integer.parseInt(value1);
		if(val<180)
		{
			boolean flag = false;
		}
			
		
		return Heightstd;		
	}
	
	public boolean BMI()
	{
		Boolean BMIcondition= BMI.isEnabled();
		return BMIcondition;		
	}
	public  int BMIvalue()
	{
		String BMIvalue= BMI.getAttribute("value");
			int BMIval= Integer.getInteger(BMIvalue);
		
		return BMIval;		
	}
	public String HRValue()
	{
		HR.sendKeys("59");
		String colour= HR.getCssValue("value");
		return colour;
	}
	
	public int ValueInHRField()
	{
		String colour= HR.getAttribute("value");
		int valueinHRfield=Integer.parseInt(colour);
		return valueinHRfield;
		
	}
	public String BPSystolic()
	{
		String stringcolour = null;
		int noofrows= reader.getRowCount("Vitals");
		for(int rows=2;rows<=noofrows;rows++)
		{
			String rowdata= reader.getCellData("Vitals", "BPSystolicval", rows);
			BPSystolic.sendKeys(rowdata);
			int rowdata1=Integer.parseInt(rowdata);
			if(rowdata1<90 && rowdata1>120)
			{
				String colour=BPSystolic.getCssValue("value");
				stringcolour= colour;
			}
			
		}
		return stringcolour;
		
	}
	
	
	
	
	
	

}
