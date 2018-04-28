package com_milan_POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class EMRDashBoardPage extends TestBase
{
	@FindBy(xpath="//a[@id='menuField_women']") WebElement womenfield;
	@FindBy(xpath="//a[@id='menuField_men']") WebElement menfield;
	@FindBy(xpath="//*[@id='0']")WebElement visitwomen;
	@FindBy(xpath = "//a[@class='icoLink femaleHistory'][@title='History']")WebElement Historylinkwomen; 
	@FindBy(xpath="(//a[@title='History'])[2]")WebElement Historylinkmen;
	@FindBy(xpath="//a[@class='icoLink femaleDiagnosis'][@title='Diagnosis']")WebElement FemaleDiagnosis;
	@FindBy(xpath="(//a[@title='Diagnosis'])[2]")WebElement MaleDiagnosis;
	@FindBy(xpath="//input[@id='0']")WebElement visitmen;
	@FindBy(xpath= "//span[contains (text(), 'EMR Dashboard')]")WebElement TitleEMR;
	@FindBy(xpath = "//span[contains (text(), 'History')]")WebElement TitleHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[2]")WebElement Sexualhistory; 
	@FindBy(xpath="(//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input[@type='checkbox'])[1]")WebElement visitw;
	@FindBy(xpath="/html/body/div[1]/div/div/div/table/tbody//tr/td//input[@id='0']") WebElement checkboxvisitm;
	
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	public EMRDashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public  WomenHistoryPage clickOnWomenField() throws InterruptedException
	{
		TestUtil.VisibleOn(driver, womenfield, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menuField_women']")));
		if(womenfield.isDisplayed())
		{
			//System.out.println("womentfield"+ womenfield.isDisplayed());
			TestUtil.VisibleOn(driver, womenfield, 20);
			womenfield.click();
			TestUtil.VisibleOn(driver, Historylinkwomen, 20);
			Historylinkwomen.click();
			//System.out.println("Womenfieldis displayed");
			List<WebElement> visitw=driver.findElements(By.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
			if(visitw.size()!=0)
			{
			System.out.println("Visitcount" + visitw.size());
			//Thread.sleep(3000);
			TestUtil.VisibleElementsOn(driver, visitw, 30);
			visitw.get(0).click();
			System.out.println("Women visit cliked");	
			}
			else
			{
				
			System.out.println("History  not availsble");
			
										
			}
			/*TestUtil.VisibleOn(driver, visitw,30);
			Historylinkwomen.click();
			TestUtil.VisibleOn(driver, womenfield, 30);
		 visitw.click();*/
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
		TestUtil.VisibleOn(driver, TitleHistory, 40);
		String Title=TitleHistory.getText();
		return Title;
		
	}


	public MenHistoryPage clickOnMenField() throws InterruptedException
	{
				Thread.sleep(3000);
			if(menfield.isDisplayed())
			{
				TestUtil.VisibleOn(driver, menfield, 30);
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
						TestUtil.VisibleElementsOn(driver, visitm, 30);
						visitm.get(0).click();
						System.out.println("Men visit cliked");	
						}
						else
						{
							
						System.out.println("History  not availsble");
						
													
						}
						
			}
			else
			{
				System.out.println("MenHistory not found");
				
				
			}
			return  new MenHistoryPage();
	
	
	}
	
	public FemaleDiagnosisPage ClickOnDiagnosis() throws Exception
	{
		TestUtil.VisibleOn(driver, womenfield, 20);
		womenfield.click();	
		//TestUtil.VisibleOn(driver, FemaleDiagnosis, 30);
		Thread.sleep(3000);
		FemaleDiagnosis.click();
		List<WebElement> visitm=driver.findElements(By.xpath("//table[@class='table table-hover table-striped selectPatient_item']/tbody//tr/td//input"));
		if(visitm.size()!=0)
		{
		System.out.println("Visitcount" + visitm.size());
		TestUtil.VisibleElementsOn(driver, visitm, 30);
		visitm.get(0).click();
		System.out.println("Dignosis visit cliked");
		
		}
		else
		{	
			
		System.out.println("History  not availsble");
		
									
		}
		return new FemaleDiagnosisPage();
		
	}
	
			
				
			
			
		
}

