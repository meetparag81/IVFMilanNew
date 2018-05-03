package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;

public class WComplaintsPage extends TestBase
{
	@FindBy(xpath="(//label[text()='LMP']//following::button)[1]")WebElement Buttoncomplaints;
	@FindBy(xpath="//div[@class='checkboxLayer show']/div[2]")WebElement PresentingComplaints;
	
	
	int i;
	int j;
	int count=0;
	
	WComplaintsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public  int PresentingComplaints() throws Exception
	{
		
		List<WebElement>Rows= driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
		int NoofRows= Rows.size();
		if(NoofRows!=0)
		{
			for(int i=1;i<=NoofRows;j++)
			{
			String complaintname=	Rows.get(i).getText();
			Buttoncomplaints.click();
			Thread.sleep(3000);
				List<WebElement> complaints = driver.findElements(By.xpath("//div[@class='checkBoxContainer']/div"));
				int complaintsnamessize= complaints.size();
				for(int j = 1;i<=complaintsnamessize;j++)
				{
					String Names= complaints.get(j).getText();
					if(Names.contentEquals(complaintname))					
					{
						complaints.get(j).click();
						count++;
						break;
					}
					
					
				}
				
			}
			
			
		}
		else
		{
			Thread.sleep(2000);	
			Buttoncomplaints.isEnabled();
			
			System.out.println("button is disabled"+ Buttoncomplaints.isEnabled()+"buttonisdisplayed"+Buttoncomplaints.isDisplayed());
			Buttoncomplaints.click();
			Thread.sleep(2000);
			List<WebElement> complaints = driver.findElements(By.xpath("//div[@class='checkBoxContainer']/div"));
			complaints.get(i).click();
			count++;
		}
		if(Rows.size()<=1)	
		{
			String rowsname= Rows.get(i).getText();
		}
		return count;
		
		
	}

}

