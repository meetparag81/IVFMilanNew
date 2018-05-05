package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class HomePage extends TestBase
{
	@FindBy(id= "patientBtn")
	private  WebElement Patient;
	@FindBy(xpath="//*[@id='txtfullName']")
	private  WebElement Searchbox1;
	@FindBy (xpath="//ul[@class='dropdown-menu ng-isolate-scope crx_mouse_visited']")WebElement Searchbox;
	@FindBy(xpath="//h5[text()='Prescription']")WebElement title;
	@FindBy(xpath="//span[text()='EMR Dashboard']")WebElement EMRTitle;
	@FindBy(id="patientBtn" )WebElement Paitent;
	@FindBy(xpath="//*[@id='patientDashboard']") WebElement Dashboard;
	@FindBy(xpath="//span[contains (text(), 'EMR Dashboard')]")WebElement Title;
	@FindBy (xpath= "//span[text() = 'Total Count :']//following::span") WebElement SizeOfPaitent;
	@FindBy (xpath="(//input[@type='checkbox'])[1]")WebElement checkbox;
	@FindBy (xpath= "//span[text()='EMR Dashboard']")WebElement Dashboardtitle;
	@FindBy (xpath="//span[text()='Queue Management']//following::i[3]")WebElement calender;
	@FindBy (xpath="//span[text()='Queue Management']//following::input[2]")WebElement searchpaient;
	@FindBy(xpath="//button[text()='Search'][@ class='btn btn-primary']")WebElement Searchbutton;
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	 
	public HomePage()  
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String EMRPageTitle()
	
	{
		title= wait.until(ExpectedConditions.visibilityOf(title));
		return Title.getText();		
	}
		
	public  String Homepagetitle()
	{
		//System.out.println("========Homepagetitle testcase started======");
		String msg= driver.getTitle();
		return msg;
		
	}
	
	public  EMRDashBoardPage ClickonEMR() throws Exception
	{
		//System.out.println("========EMR click testcase started======");
		int i=1;
		int j = 1;
		int size=0;
		
        try {
        	wait.until(ExpectedConditions.visibilityOf(SizeOfPaitent));
        	String s = SizeOfPaitent.getText();
        	 size= Integer.parseInt(s);
   		 System.out.println("Patient size is" + size);
        	}
        catch(NumberFormatException e)
        {
        	//System.out.println("Youve entered non-integer number");
        }
        finally {
           // System. out. println( "finally block executed") ;
         }
         
		for(i=1;i<=125;i++)
				{
				if(j <= 10)
					{
					Thread.sleep(4000);
					WebElement rowcount = driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+ j +"]/td[4]"));					
					String name1=rowcount.getText();
					//System.out.println(name1+ i+ j);
					
											
						Thread.sleep(3000);						
						if(name1.contains("Ms.Geetha"))
							
						{
							Thread.sleep(3000);
							driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+ j +"]/td[1]/a[2]")).click();
							//System.out.println("click on EMR ");
							i=122;
							System.out.println("===========recodfound==============");
							break;	
							
						}
						
						
						j++;
					}
					else
						{
							j=1;
							
							JavascriptExecutor jse = (JavascriptExecutor)driver;
							//jse.executeScript("scroll(0, 250)");
							WebElement element = driver.findElement(By.xpath("//a[contains (text(), 'Next')]"));
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();", element);
							System.out.println("=============clicked on next==========");
				
				
						}
				}
		return  new EMRDashBoardPage();
	}
	public EMRDashBoardPage searchPaient() throws Exception 
	{
		  WebElement Patient1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='patientBtn']")));
	Paitent = wait.until(ExpectedConditions.visibilityOf(Patient));	
	Patient1.click();
	Searchbox1.sendKeys("Parag");
	//Searchbox1.submit();
	//Thread.sleep(1000);
	//checkbox.click();
	TestUtil.VisibleOn(driver, Searchbox1, 10);
	Searchbox1.sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	Searchbox1.sendKeys("g");
	List<WebElement>search= driver.findElements(By.xpath("//ul[@role='listbox']//li/a"));
		 
		 
		 System.out.println("totalsearch"+ search.size());
		// search.get(0).click();			
		 for(int i=0;i<search.size();i++)
				{
				 Thread.sleep(2000);
				 String name = search.get(i).getText();
				 if(name.contains("Parag Agrawal"))
							System.out.println("Paitent found");
					{						
						wait.until(ExpectedConditions.visibilityOfAllElements(search));
						search.get(i).click();
						System.out.println("clicked on Paitent");
						break;
					}
							
				}
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 TestUtil.VisibleOn(driver, checkbox, 20);
			executor.executeScript("arguments[0].click();", checkbox);
		 				 	
		 /*List<WebElement>visits =driver.findElements(By.xpath("//tbody//input[@type='checkbox']"));
		
			System.out.println("visits Rows are" + visits.size());
			//input[@id='0']
			if( visits.size()!=0)
			{
				
				Thread.sleep(3000);
				visits.get(0).click();
				System.out.println(("clickoncheckbox"));
							
			}
				else
				{
					System.out.println("no visits found");*/
				System.out.println("Searchtestcompleted");
			return new EMRDashBoardPage();
		  				
			
			

	}
		public String Dahboardtitle()
		{
			
			String Title= Dashboardtitle.getText();
			return Title;
		}
public EMRDashBoardPage SearchusingCalender() throws Exception
	{
	WebElement Calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Queue Management']//following::i[3]")));
	TestUtil.VisibleOn(driver, Calender, 40);
			Calender.click();
		List<WebElement>dates=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@role='grid']//tbody//td")));
		
		int Total_nodes= dates.size();
		for(int i=0;i<Total_nodes;i++)
		{
			String date= dates.get(i).getText();
			if(date.equals("04"))
			{
			dates.get(i).click();
			break;
			}
			
				
		}
		
		Thread.sleep(3000);
		searchpaient.sendKeys("Vidya");
		TestUtil.VisibleOn(driver, Searchbutton, 20);
		Searchbutton.click();
		int k=1;
			while( k <= 10)
			{
				Thread.sleep(3000);
				WebElement Nameofpatient= driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tr["+k+"]/td[4]"));
				TestUtil.VisibleOn(driver, Nameofpatient, 30);
				String name1=Nameofpatient.getText();
				Thread.sleep(4000);				
				if(name1.contains("Ms.Vidya B E"))
				{
					//Thread.sleep(4000);
					WebElement EMR= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@id='tableToExport']/table/tbody/tr["+ k +"]/td[1]/a[2]"))));
					EMR.click();
					System.out.println("click on EMR ");
					
					System.out.println("===========recodfound==============");
					break;
				}
				k++;
			
			}
			return new EMRDashBoardPage();
	}
}
	
	
		


