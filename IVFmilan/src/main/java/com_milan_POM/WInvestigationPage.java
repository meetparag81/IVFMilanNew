package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;

public class WInvestigationPage extends TestBase
{
	@FindBy(xpath="//li[text()='Cycles']") WebElement Cycles;
	@FindBy(xpath="(//input[@name='txtServiceName'])[2]")WebElement Search;
	
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	int count=0;
	int rows=1;
	WInvestigationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public int Setsearchvalue()
	{
		System.out.println();
		Cycles.click();
	String Name=reader.getCellData("Investigation", "Search", 2);
		Search.sendKeys(Name);
		List<WebElement>searchlist= driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-isolate-scope']/li"));
		int size= searchlist.size();
		
		for(int i=0;i<size;i++)
		{
			rows++;
			
			
			String resultnames= searchlist.get(i).getText();
			
			while(rows<size)
			{
			
			reader.setCellData("Investigation", "Searchresult", rows, resultnames);
			
			break;
			}
			
		}
		return size;
	}
		
		
		
	
	public void ARTCycle()
	{
		
	}
	
	
	
	

}
