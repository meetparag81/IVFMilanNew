package com_milan_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;

public class CycleListPage extends TestBase 
{
	@FindBy(xpath="//button[@class='f-right btn-txt-link']")WebElement Newcyclebutton ;
	@FindBy(xpath="//span[text()='Cycle List']")WebElement CyclelistTitle;
	
	CycleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean NewCycleButtonEnableCondition()
	{
		 boolean flag1 = Newcyclebutton.isEnabled();
		return flag1;
		
	}
	public String CycleListTitle()
	{
		String msg= CyclelistTitle.getText();
		System.out.println(msg);
		return msg;
	}
	

}
