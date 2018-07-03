package com_milan_POM;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class FamilyHistoryPage extends TestBase
{
	@FindBy(xpath="(//button[@class='btn btn-link link'])[2]")WebElement Addrows;
	@FindBy(xpath="//th[text()='Type of Disease']//following::select[1]")WebElement TypeofDiesese;
	@FindBy(xpath="//th[text()='Maternal/Paternal']//following::select[2]")WebElement Maternal;
	@FindBy(xpath="//th[text()='Relationship']//following::select[3]")WebElement Relationship;
	@FindBy(xpath="//th[text()='Type of Disease']//following::select[4]")WebElement Status;
	@FindBy(xpath="//th[text()='Type of Disease']//following::input")WebElement Remarks;
	@FindBy(xpath="//button[text()=' Update']")WebElement UpdateText;
	String msg;
	
	

	FamilyHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean NoofRows()
	{
		List<WebElement>rows = driver.findElements(By.xpath("//h5[text()='Family History']//following::table[1]//tbody//tr"));
		List<WebElement>rows1 = new LinkedList<>();
	boolean flag=rows1.addAll(rows);
	int size= rows.size();
		
		
	if(size>0)	
	{
		flag=true;
	}
	else
	{
		flag=false;
	}
	
	return flag;
		
		
	}
	
	public String SaveFamilyHistory()
	{
		boolean flag1= NoofRows();
		if(flag1==true)
		{
		
		}
		else
		{
			
		}
		
		return msg;
		
	}
	public String NewUser()
	{
		int rows=1;
		for( int row1=rows ;row1<= 6;row1++)
		{
			try
			{
				TestUtil.VisibleOn(driver, Addrows, 30);
			}
			catch(TimeoutException e)
			{
				System.out.println("Element-Addrows not seen within 30 sec");
			}			
			Addrows.click();
			Select diesesetype = new Select(TypeofDiesese);
			List<WebElement>diesese= diesesetype.getAllSelectedOptions();
		int size=diesese.size();
			for(int i=1;i<=size;i++)
			{
				String diesesname= diesese.get(i).getText();
				switch(diesesname)
				{
				case "Cardiac Disease":
					WebElement diesease1= driver.findElement(By.xpath("//h5[text()='Family History']//following::table[1]//tbody/tr[1]/td[2]/select"));
					diesesetype.selectByVisibleText("Cardiac Disease");
					
				
				}
				
				
			}
			
			
		}
		return msg;
	}
	
	
	
	List<WebElement>Dieseses = driver.findElements(By.xpath("//select[@id='TypeOfDiseaseID']"));
	
	public boolean RelationshipEnablecondition()
	{
		Select TypeofDiesese1= new Select(TypeofDiesese);
		TypeofDiesese1.selectByVisibleText("");
		return false;
	}

	
	
}


