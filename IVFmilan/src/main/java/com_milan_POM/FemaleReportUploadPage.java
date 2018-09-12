package com_milan_POM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class FemaleReportUploadPage extends TestBase {
	private @FindBy(xpath = "//span[text()='Female Report Upload']") WebElement ReportUploadText;
	private @FindBy(xpath = "//label[contains (text(),  'Report Category')]//following::select[1]") WebElement ReportCategory;
	private @FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']") WebElement Splashmessage;
	private @FindBy(xpath = "//label[text()='Browse']//following::span[@class='btn btn-primary fileinput-button']") WebElement Attach;
	private @FindBy(xpath = "//div[@class='row form-horizontal'][1]") WebElement Attachclick;
	private @FindBy(xpath="(//label[@class='col-md-12 col-lg-12 control-label'])[3]//following::input[1]")WebElement ReportNameele;
	private @FindBy(xpath="//label[text()='Report Date']//following-sibling::div//div//span/i")WebElement Reportcalender;
	private @FindBy(xpath="//button[text()='Save']")WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement FlashMessage;
	private String msg;
	static int no1=2;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");

	public FemaleReportUploadPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public String FemaleReportUploadTitle() 
	{
		try {
			TestUtil.VisibleOn(driver, ReportUploadText, 30);
		} catch (TimeoutException e) {
			System.out.println("Element-ReportUploadText is not seen with in 30 sec");
		}

		TestUtil.ActionForMovetoElement(ReportUploadText);

		msg = ReportUploadText.getText();
		return msg;
	}

	public void SelectReportCategoryOption(int no)
	{
		TestUtil.ActionForMovetoElement(ReportCategory);

		boolean flag1 = MessageForInvalidUpload();
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		if (flag1 == false) 
		{
			Attach.click();
			try {
				Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\FemaleReportUpload\\Report4.exe");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			int rowsize = reader.getRowCount("FReportUpload");
			for (int i = no; i <= rowsize; i++) 
			{
				 String ReportCategorytext = reader.getCellData("FReportUpload", "ReportCategory", i);
				Select ReportCategory1 = new Select(ReportCategory);
				ReportCategory1.selectByVisibleText("Radiology");
				String ReportName = reader.getCellData("FReportUpload", "ReportName", i);
				TestUtil.ActionForMovetoElement(ReportNameele);
				ReportNameele.sendKeys(ReportName);
				DatePicker();
				break;
				
				
			}
			TestUtil.ActionForMovetoElement(Save);
			Save.click();
			
		}

	}
	
	
	public void SelectReportCategoryOptionNew(String category, String name, String no)
	{
		TestUtil.ActionForMovetoElement(ReportCategory);

		boolean flag1 = MessageForInvalidUpload();
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		if (flag1 == false) 
		{
			Attach.click();
			try {
				Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\FemaleReportUpload\\Report4.exe");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			int rowsize = reader.getRowCount("FReportUpload");
			for (int i = no1; i <= rowsize; i++) 
			{
				 String ReportCategorytext = reader.getCellData("FReportUpload", "ReportCategory", i);
				Select ReportCategory1 = new Select(ReportCategory);
				ReportCategory1.selectByVisibleText("Radiology");
				String ReportName = reader.getCellData("FReportUpload", "ReportName", i);
				TestUtil.ActionForMovetoElement(ReportNameele);
				ReportNameele.sendKeys(ReportName);
				DatePicker();
				no1++;
				break;
				
				
			}
			TestUtil.ActionForMovetoElement(Save);
			Save.click();
			
		}

	}
	
	
	public String FlashMessage()
	{
		TestUtil.ActionForMovetoElement(FlashMessage);
		
		return FlashMessage.getText();
		
	}
	
	
	public void DatePicker()
	{
		int count=0;
		int count1=count-1;
		TestUtil.ActionForMovetoElement(Reportcalender);
		Reportcalender.click();
		List<WebElement>Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
		boolean flag= true ;
		for(int l =0;l<Dates.size();l++)
		{
			count1++;
			if(flag==false)
			{
				break;
			}
			
			String firstdate = Dates.get(l).getText();
			
			if(firstdate.equals("01"))
			{
				
				for(int i =count1;i<=Dates.size();i++)
				{
					
					String Datetext= Dates.get(i).getText();
					WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
					String text= Monthtextele.getText();
					String Arr[]=text.split(" ");
					String Monthtext = Arr[0]; 
					
					String CyrrentDate=TestUtil.Date();
					String[] Arr1= CyrrentDate.split(",");
					String day= Arr1[0];
					String Month = Arr1[1];
					
				
					boolean flag1= Dates.get(i).isEnabled();
					
					
					if(Datetext.equals(day)&&flag1==true&&Monthtext.equals(Month))
					{
						Dates.get(i).click();
						flag= false;
						break;
					}
				}
			}
		}
		
	}
	
	
	

	public boolean MessageForInvalidUpload() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, Attach, 30);
		} 
		catch (TimeoutException e) 
		{
			System.out.println("Element-Attach is not seen within 30 sec");
		}
		TestUtil.ActionForMovetoElement(Attach);
		Attach.click();
		try 
		{
			try 
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e) 
			{
				System.out.println("InterruptedException is seen");
			}
			Runtime.getRuntime().exec("C:\\Parag\\Git\\IVFmilan\\AutoIT\\FemaleReportUpload\\Report3.exe");
		} 
		catch (IOException e) 
		{
			System.out.println("I/O exception seen");
		}
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		Attachclick.click();

		boolean flag = false;
		msg = SplashMessage();
		String msg1 = "Attactment should be in png ,jpeg , pdf format.";
		if (msg.equals(msg1)) 
		{
			flag = false;
		}

		return flag;

	}

	public String SplashMessage() 
	{
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		TestUtil.ActionForMovetoElement(Splashmessage);
		msg = Splashmessage.getText();

		return msg;

	}
	
	
	public static ArrayList<Object[]> getdatafromExcel()
	{
		Exls_Reader reader = null;

		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		int count1 = reader.getRowCount("Female Report Upload");
		for (int rows = 2; rows <= count1; rows++) 
		{

			String ReportCategory = reader.getCellData("Female Report Upload", 0, rows);
			String ReportName = reader.getCellData("Female Report Upload", 1, rows);
			String No = reader.getCellData("Female Report Upload", 2, rows);
			

			Object[] obj = { ReportCategory, ReportName  };
			mydata.add(obj);
		}

		return mydata;
	}
	



}
