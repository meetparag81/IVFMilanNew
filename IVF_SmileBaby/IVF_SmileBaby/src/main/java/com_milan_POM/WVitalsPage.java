package com_milan_POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WVitalsPage extends TestBase
{
private @FindBy(xpath=("(//input[@type='text'])[2]"))WebElement Weight;
private @FindBy(xpath="(//input[@type='text'])[3]")WebElement Height;
private @FindBy(xpath="(//input[@type='text'])[4]") WebElement BMI;
private @FindBy(xpath="(//input[@type='text'])[5]")WebElement BPSystolic;
private @FindBy(xpath="(//input[@type='text'])[6]")WebElement BPDiastolic;
private @FindBy(xpath="(//input[@type='text'])[7]")WebElement HR;
private @FindBy(xpath="(//input[@type='text'])[8]")WebElement Temprature;
private @FindBy(xpath="//button[@class='btn btn-primary ng-binding']")WebElement Save;
private @FindBy(xpath="//div[@id='toasty']/comment()") WebElement FlashMessage;
private@FindBy(xpath="//label[text()='BMI']")WebElement BMITitle;
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
	
	
	
	public String HRValue()
	{
		HR.sendKeys("59");
		String colour= HR.getCssValue("value");
		return colour;
	}
	
	
	public boolean BPSystolic()
	{
		boolean Message = true;
		int noofrows= reader.getRowCount("Vitals");
		for(int rows=2;rows<=noofrows;rows++)
		{
			String rowdata= reader.getCellData("Vitals", 3, rows);
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
	
	public String BPSystolic(String value)
	{
		BPSystolic.clear();
		BPSystolic.sendKeys(value);
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
	public String SaveAllvalues(String weightval,String Heightval,String BPSystolicval, String BPDiastolicval,String HRRangeval,String Tempval ) 
	{
		Weight.clear();
		Weight.sendKeys(weightval);
		Height.clear();
		Height.sendKeys(Heightval);
		BPSystolic.clear();
		BPSystolic.sendKeys(BPSystolicval);
		BPDiastolic.clear();
		BPDiastolic.sendKeys(BPDiastolicval);
		BPSystolic.clear();
		HR.clear();
		HR.sendKeys(HRRangeval);
		Temprature.clear();
		Temprature.sendKeys(Tempval);
		Save.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
	String message="";//	FlashMessage.getText();
		
		
		return message;
	}
		
		
		
	
	
	
	public float BMIvalue(String weightval, String Heightval) 
	{
		Weight.clear();
		Weight.sendKeys(weightval);
		Height.clear();
		Height.sendKeys(Heightval);
		BMITitle.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		String BMIvalue= BMI.getAttribute("value");
		float BMI = Float.parseFloat(BMIvalue);
		return BMI;
		
	
	
		
	}

	public static ArrayList<Object[]>  getdatafromExcel()
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
			
			String Weight =reader.getCellData("Vitals", 0, rows);
			String Height =reader.getCellData("Vitals", 1, rows);
			String BPSystolic  = reader.getCellData("Vitals", 2, rows);
			String BPDiastolic  = reader.getCellData("Vitals", 3, rows);
			String HRRange = reader.getCellData("Vitals", 4, rows);
			String Temp = reader.getCellData("Vitals", 5, rows);
			
			Object[] obj= {Weight,Height,BPSystolic,BPDiastolic,HRRange,Temp};
			mydata.add(obj);
		}
		
		return mydata;
	}
	
	
	
	
	
	
	public Double  ExpectedResult()
	{
		Double Expected1 = null;
		int count= reader.getRowCount("Vitals");
		for(int rows=2;rows<=count;rows++)
		{
		 String Expected = reader.getCellData("Vitals", "BMI", rows);
		 Double Exp= Double.parseDouble(Expected);
		 Expected1= Exp;
		 
		}
		return Expected1;
		
		}
}
	
	
	
	
	
	


