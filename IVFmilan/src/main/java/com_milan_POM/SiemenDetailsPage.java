package com_milan_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class SiemenDetailsPage extends TestBase 
{
	@FindBy(xpath="(//label[contains (text(), 'Type of Sperm :')]//following-sibling::label)[1]")WebElement TyppeOfSperm;
	
	String msg;
	
	SiemenDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String TypeOfSperm()
	{
		try
		{
			TestUtil.VisibleOn(driver, TyppeOfSperm, 30);
			TestUtil.ActionForMovetoElement(TyppeOfSperm);
		}
		catch(Exception e)
		{
			System.out.println("Element- TyppeOfSperm is not seen with in 30 sec");
		}
		msg= TyppeOfSperm.getText();
		
		
		return msg;
		
	}

}
