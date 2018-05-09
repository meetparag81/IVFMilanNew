package com_milan_POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
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
double rowdata2,rowdata1;
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
		int count= reader.getColumnCount("Vitals");
		for(int rows=2;rows<=count;rows++)
		{
			System.out.println("test");
		String celldata= reader.getCellData("Vitals", 1, rows);
		}
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
	public boolean BPSystolic()
	{
		boolean Message = true;
		int noofrows= reader.getRowCount("Vitals");
		for(int rows=2;rows<=noofrows;rows++)
		{
			String rowdata= reader.getCellData("Vitals", "BPSystolicval", rows);
			BPSystolic.sendKeys(rowdata);
			try{
				 rowdata1=Double.parseDouble(rowdata);
				 System.out.println(rowdata1);
			      }catch(NumberFormatException e){
				  System.out.println("Number format exception occurred");
			       }
					finally
					{
						System.out.println("finally block executed");
					}
			
			
			if(rowdata1<90.0 || rowdata1>120.0)
			{
				/*String colour=BPSystolic.getCssValue("colour");
				String stringcolour= colour;
				System.out.println(stringcolour);*/
				Message = false;
				break;
			}
			
		}
		//return stringcolour;
		return Message;
		
	}
	
	public String BPSystolic(String value1)
	{
		BPSystolic.clear();
		BPSystolic.sendKeys(value1);
		String BPvalues= BPSystolic.getAttribute("value");
		/*float BPvalues1= Float.parseFloat(BPvalues);
		if(BPvalues1<=90.0 || BPvalues1>=120.0)
		{
			String colour=BPSystolic.getCssValue("colour");
			String stringcolour= colour;
			System.out.println(stringcolour);
			System.out.println("start the test");*/
		return BPvalues;
			
	}
	
	
	public static ArrayList<Object[]>  getdatafromExcelforBPSystolic()
	{
		Exls_Reader reader = null;
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try
		{
		reader= new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int rowcount= reader.getRowCount("Vitals");
		int count= rowcount;
		for(int rows=2;rows<=count;rows++ )
		{
			String BPSystolicval =reader.getCellData("Vitals", 0, rows);
			Object[] obj= {BPSystolicval};
			mydata.add(obj);
		}
		
		return mydata;
	}
	
	
	
	public String  FillVitalsform()
	{
		Weight.sendKeys("100.0");
		Height.sendKeys("170");
		BPDiastolic.sendKeys("120.5");
		BPDiastolic.sendKeys("100.10");
		HR.sendKeys("110.0");
		Temprature.sendKeys("100.0");
		
		
		
		
		
		
		
		
		
		return null;
		
	}
	
	
}
	
	
	
	
	
	


