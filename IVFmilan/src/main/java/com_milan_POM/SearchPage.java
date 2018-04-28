package com_milan_POM;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class SearchPage extends TestBase
{
	@FindBy(id= "patientBtn")
	private  WebElement Patient;
	@FindBy(xpath="//input[@name = 'txtUsrName']")
	private  WebElement Searchbox1;
	@FindBy (xpath="//ul[@class='dropdown-menu ng-isolate-scope crx_mouse_visited']")WebElement Searchbox;
	@FindBy(xpath="//a[@id='patientDashboard']")WebElement title;
	@FindBy(xpath="//span[text()='EMR Dashboard']")WebElement EMRTitle;
	@FindBy(id="patientBtn" )WebElement Paitent;
	@FindBy(xpath="//*[@id='patientDashboard']") WebElement Dashboard;
	@FindBy(xpath="//span[contains (text(), 'EMR Dashboard')]")WebElement Title;
	@FindBy (xpath= "//span[text() = 'Total Count :']//following::span") WebElement SizeOfPaitent;
	@FindBy (xpath= "//span[text()='EMR Dashboard']")WebElement Dashboardtitle;
	@FindBy (xpath="//input[@id='0']")WebElement checkbox;
	@FindBy (xpath="//span[text()='Queue Management']//following::i[3]")WebElement calender;
	@FindBy (xpath="//span[text()='Queue Management']//following::input[2]")WebElement searchpaient;
	@FindBy(xpath="//button[text()='Search']")WebElement Searchbutton;
	@FindBy(xpath="//span[@class='icon-screen ng-binding']")WebElement QueueManagement;
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	

	public SearchPage()  
	{
		
		PageFactory.initElements(driver, this);
	}
	

	public EMRDashBoardPage searchPaient() throws Exception 
		{
			  WebElement Patient1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@id='patientBtn']")));
		//Paitent = wait.until(ExpectedConditions.visibilityOf(Patient));
	
		Patient1.click();
		
		System.out.println("SearchtestStarted");
		//Thread.sleep(3000);
		Searchbox1.sendKeys("Judith");
		Thread.sleep(1000);
		driver.findElement(By.xpath(("//input[@name = 'txtUsrName']"))).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		Searchbox1.sendKeys("h");
		
		
		List<WebElement>search= driver.findElements(By.xpath("//ul[@role='listbox']//li/a"));
			 
			 
			 System.out.println("totalsearch"+ search.size());
			// search.get(0).click();			
			 for(int i=0;i<search.size();i++)
					{
					 Thread.sleep(2000);
					 if(search.get(i).getText().contains("Parag Agrawal"))
								System.out.println("Paitent found");
						{
							
							wait.until(ExpectedConditions.visibilityOfAllElements(search));
							search.get(i).click();
							System.out.println("clicked on Paitent");
							break;
						}
								
					}
			 /*JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", checkbox);*/
			 				 	
			 List<WebElement>visits =driver.findElements(By.xpath("//tbody//input[@type='checkbox']"));
			
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
						System.out.println("no visits found");
					}
				System.out.println("Searchtestcompleted");
			  				
				return  new EMRDashBoardPage();
				

		}
	public String Dahboardtitle()
	{
		WebElement Dashboard= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='EMR Dashboard']")));
		String Title= Dashboard.getText();
		return Title;
	}
	
	public EMRDashBoardPage SearchusingCalender() throws Exception
	{
	WebElement Calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Queue Management']//following::i[3]")));
	TestUtil.VisibleOn(driver, Calender, 30);
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
		
		searchpaient.sendKeys("Vidya");
		Searchbutton.click();
		int k=1;
			while( k <= 10)
			{
				WebElement Nameofpatient= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+k+"]/td[4]")));
				String name1=Nameofpatient.getText();
			//System.out.println(name1);
			   
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


	public String  QueueManagementpage() 
	{
		String Title=QueueManagement.getText();
		return Title;
		
	}
	
	
	
}