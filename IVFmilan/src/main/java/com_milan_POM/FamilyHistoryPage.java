package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;

public class FamilyHistoryPage extends TestBase
{
	@FindBy(xpath="//button[@id='btnAddFamilyHistoryRow']")WebElement Addrow;
	@FindBy(xpath="//select[@id='TypeOfDiseaseID']")WebElement TypeofDiesese;
	
	
	
	

	FamilyHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	List<WebElement>Dieseses = driver.findElements(By.xpath("//select[@id='TypeOfDiseaseID']"));
	
	public boolean RelationshipEnablecondition()
	{
		Select TypeofDiesese1= new Select(TypeofDiesese);
		TypeofDiesese1.selectByVisibleText("");
		return false;
	}

	
	
}


