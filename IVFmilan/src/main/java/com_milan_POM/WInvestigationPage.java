package com_milan_POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WInvestigationPage extends TestBase 
{
	@FindBy(xpath = "//li[text()='Cycles']")WebElement Cycles;
	@FindBy(xpath = "(//input[@name='txtServiceName'])[2]")WebElement Search;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")WebElement InvestigationPageTitle;
	@FindBy(xpath = "//span[@class='icon-screen ng-binding']")WebElement fornegetiveflashmsg;
	@FindBy(xpath="//div[@class='close-button ng-scope']")WebElement closeflash;
@FindBy(xpath="//*[@class='toast-text ng-scope']//span//following::span")WebElement saveflashmessage;
@FindBy(xpath="(//button[@class='btn btn-primary'])[3]") WebElement Save;
@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement existcycles;
@FindBy(xpath="//i[@class='fa fa-calendar']")WebElement Calender;
@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement DeleteMessage; 
@FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement SaveMessage;
@FindBy(xpath="(//input[@name='txtServiceName'])[2]")WebElement Services;
@FindBy(xpath="//input[@name='txtInstruction']")WebElement Instruction;
@FindBy(xpath="toast-msg ng-binding ng-scope")WebElement AddtoFavorite;
@FindBy(xpath="//textarea[@name='txtReason']")WebElement Reasontext;
@FindBy(xpath="//textarea[@name='txtReason']//following::button[1]")WebElement ReasonSave;
@FindBy(xpath="(//li[text()='Procedures'])[2]")WebElement Procedures;



	String msg;

	static Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	

	WInvestigationPage() 
	{
		PageFactory.initElements(driver, this);
	}

	
	public int SearchResults()
	{
		Services.sendKeys("P");
		List<WebElement>SearchResult = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		int rows = 2;
		int count =0;
		for(int i=0;i<=SearchResult.size();i++)
		{
		String result=	SearchResult.get(i).getText();
		
		reader.setCellData("Investigationlist", "SearchResult", rows,result );
		rows++;
		count++;
		
		if(SearchResult.size()==count)
		{
			break;
		}
		
		}
		
		
		
		
		
		return count;
		
		
	}
	public String SelectedSearchOption()
	{
		Services.sendKeys("ivf");
		Services.sendKeys(Keys.BACK_SPACE);
		int rows=2;
		int j = 1;
		List<WebElement>SearchResult = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		for(int i=0;i<SearchResult.size();i++)
		{
			String resulttext = SearchResult.get(i).getText();
		String text= reader.getCellData("Investigationlist", "SearchResult", rows);
		if(resulttext.equals(text))
		{
		WebElement we=driver.findElement(By.xpath("(//table[@class='table table-hover table-striped'])[3]//tr["+j+"]/td[4]"));
		msg= we.getText();
			break;
		}
		
			
		}
		
		return msg;
		
	}
	public boolean ExisingProcedure()
	{
		List<WebElement> Procedure= driver.findElements(By.xpath("(//div[@class='table-responsive table-bordered']/table)[1]//tbody//tr"));
		int size= Procedure.size();
		boolean flag;
		if(size>1)
		{
			flag = true;
		}
		else
		{
			flag=false;
		}
		
		
		
		return flag;
		
	}
	
	
	public void DateAndInstruction() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(Calender).click().perform();
		TestUtil.Date();
		act.moveToElement(Instruction);
		Instruction.sendKeys("NA");
		
		
	}
	
	public void AddFavorite()
	{
		int count =0;
		List<WebElement>Favorite= driver.findElements(By.xpath("//div[@class='table-responsive table-bordered']/table[1]//tbody/tr/td[2]/span"));
		boolean flag = ExisingProcedure();
		if(flag==true)
		{
			for(WebElement fa:Favorite)
			{
				fa.click();
				
				if(count==Favorite.size())
				{
					break;
				}
			}
			
			//WebElement  favorite = driver.findElement(By.xpath("//div[@class='table-responsive table-bordered']/table[1]//tbody/tr["+j+"]/td[2]/span"));
		}
		else
		{
			return;
			
		}
	}
	public String TooltipFavorite()
	{
		List<WebElement>tooltips = driver.findElements(By.xpath("//span[@class='tooltiptext tooltip-top']"));
		for(int j= 0;j<tooltips.size();j++)
		{
			WebElement tooltipele= tooltips.get(j);
			Actions act = new Actions(driver);
			act.moveToElement(tooltipele).perform();
		boolean flag=	tooltipele.isDisplayed();
			if(flag==true)
			{
				msg= tooltipele.getText();
			}
			break;
		}
		
		
		return msg;
		
	}
	public String DeleteProcedure()
	{
		boolean flag = ExisingProcedure();
		if(flag== true)
		{
		
		List<WebElement>delete = driver.findElements(By.xpath("//div[@class='table-responsive table-bordered']/table[1]//tbody/tr/td[1]/span"));
		
		int count =0;
		for(WebElement Deletewe:delete)
		{	
			Deletewe.click();
		count++;
		if(count>1)
		{
			break;
		}
		}
		Actions act = new Actions(driver);
		act.moveToElement(Reasontext).sendKeys("NA");
		act.moveToElement(ReasonSave).click().perform();
		act.moveToElement(DeleteMessage);
		
		msg=DeleteMessage.getText();
		}
		else
		{
			SelectedSearchOption();
			Save.click();
			msg= SaveMessage.getText();
		}
		
		
		return msg;
		
	}
	
	
	public String SaveProcedure()
	{
		 boolean flag = ExisingProcedure();
		 if(flag==true)
		 {
			msg= SaveMessage.getText();
			 
		 }
		 else
		 {
			 DateAndInstruction();
		msg = SaveMessage.getText();
			 
		 }
		SelectedSearchOption();
		
		return msg;
		
		
	}
	
	public void ClickOnProcedures()
	{
		Actions act = new Actions(driver);
		act.moveToElement(Procedures).click().perform();		
		return; 
		
	}
	
	
	
	
	
	
		

 
		
		
	
	
	
	
		
		
		
			
		
		
		
	
	
	
	
	
	
	

	
	
	
	
	
		 
		
		
		
	
	
		  
		
		
				
		
		
		
		
		
		
		
	
	
	
		



	
	

	

	

}
