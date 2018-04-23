package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com_Milan_Base.TestBase;

public class EMRDashBoardPage extends TestBase
{
	@FindBy(xpath="//a[@id='menuField_women']") WebElement womenfield;
	@FindBy(xpath="//a[@id='menuField_men']") WebElement menfield;
	@FindBy(xpath="//*[@id='0']")WebElement visitwomen;
	@FindBy(xpath = "//a[@title='History']")WebElement Historylinkwomen; 
	@FindBy(xpath="(//a[@title='History'])[2]")WebElement Historylinkmen;
	@FindBy(xpath="//input[@id='0']")WebElement visitmen;
	@FindBy(xpath= "//span[contains (text(), 'EMR Dashboard')]")WebElement TitleEMR;
	@FindBy(xpath = "//span[contains (text(), 'History')]")WebElement TitleHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[2]")WebElement Sexualhistory; 
	@FindBy(xpath="/html/body/div[1]/div/div/div/table/tbody//tr/td//input[@id='0']")WebElement visitw;
	@FindBy(xpath="/html/body/div[1]/div/div/div/table/tbody//tr/td//input[@id='0']") WebElement checkboxvisitm;
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	public EMRDashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public  WomenHistoryPage clickOnWomenField() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menuField_women']")));
		if(womenfield.isDisplayed())
		{
			//System.out.println("womentfield"+ womenfield.isDisplayed());
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menuField_women']")));
			womenfield.click();
			//System.out.println("Womenfieldis displayed");
			Thread.sleep(3000);
			Historylinkwomen.click();
		 Thread.sleep(3000);
		 visitw.click();
			//visitwomen.click();
			System.out.println("Women visit cliked");
		}
		else
		{
			System.out.println("WomenHistory not foung");
		}
		return new WomenHistoryPage();
		
		


	}
		
	public String TitleHistoryPage() 
	{
		String Title=TitleHistory.getText();
		return Title;
		
	}


	public MenHistoryPage clickOnMenField() throws InterruptedException
	{
				Thread.sleep(3000);
			if(menfield.isDisplayed())
			{
				wait.until(ExpectedConditions.visibilityOf(menfield));
				menfield.click();
				//System.out.println("menfield"+ menfield.isDisplayed());
				
			/*List<WebElement>checkbox= driver.findElements(By.xpath("html/body/div[1]/div/div/div/table/tbody/tr//td[1]"));
			System.out.println ("checkbox size is"+checkbox.size());
			checkbox.get(0).click();*/
				Thread.sleep(3000);				
				Historylinkmen.click();
				//System.out.println(" Clicked onMen History");
				List<WebElement> visitm=driver.findElements(By.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
						if(visitm.size()!=0)
						{
						System.out.println("Visitcount" + visitm.size());
						Thread.sleep(3000);
						visitm.get(1).click();
						System.out.println("Men visit cliked");	
						}
						else
						{
							
						}				
			}
			else
			{
				System.out.println("MenHistory not found");
				
				
			}
			return  new MenHistoryPage();
	
	
	}
			
				
			
			
		
		}

