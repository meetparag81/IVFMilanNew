package com_milan_POM;

import org.apache.poi.hssf.util.HSSFColor.TEAL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class FemaleDiagnosisPage extends TestBase 
{
	@FindBy(xpath="//span[@class='glyphicon glyphicon-plus']")WebElement Plus;
	@FindBy(xpath="//a[@role='tab']")WebElement Otherdiagnosis;
	@FindBy(name="Code")WebElement Codeinput;
	@FindBy(name="Diagnosis")WebElement description;
	@FindBy(xpath="(//button[@class='btn btn-primary'][@type='button'])[6]")WebElement Save;
	@FindBy(xpath="(//th[text()='Diagnosis']/following::tr[1]/td[4])[2]")WebElement CodeValue;
	@FindBy(xpath="(//th[text()='Diagnosis'])[2]//following::tr/td[3]")WebElement Diagnosistext;
	@FindBy(xpath="//tbody/tr[1]/td[1]//span[@class='like']")WebElement FavoriteDisLike;
	@FindBy(xpath="//tbody/tr[1]/td[1]//span[@class='dislike']")WebElement FavoriteLike;
	@FindBy(xpath="//div[@id='toasty']")WebElement FlashMessage;
	@FindBy(xpath="(//button[@class='btn btn-default'])[6]")WebElement cancel;

	
	 public FemaleDiagnosisPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	
	
	public void ClickOnOtherDiagnosisForExistingPaitent() throws Exception
	{
		//TestUtil.VisibleOn(driver, Otherdiagnosis, 30);
		Otherdiagnosis.click();
		Thread.sleep(3000);
		String val= CodeValue.getText();
		double codeval = Double.parseDouble(val);
		if(val.contains("003"));
		{
		String input= String.valueOf(codeval+001);
		TestUtil.VisibleOn(driver, Plus, 30);
		Plus.click();
		TestUtil.VisibleOn(driver, Codeinput, 30);
		Codeinput.sendKeys(00+input);
		TestUtil.VisibleOn(driver, description, 30);
		description.sendKeys("test");
		}
		TestUtil.VisibleOn(driver, Save, 30);
		Save.click();
		
		
	}
	
	public void ClickOnOtherForNewPaitent() throws Exception
	{
		Otherdiagnosis.click();

		TestUtil.VisibleOn(driver, Plus, 30);
		Plus.click();
		TestUtil.VisibleOn(driver, Codeinput, 30);
		Codeinput.sendKeys("02570");
		TestUtil.VisibleOn(driver, description, 30);
		description.sendKeys("test24570");
		TestUtil.VisibleOn(driver, Save, 30);
		Save.click();
		
		
		
	}
	public String CodeUpdatedMessage() 
	{	
		TestUtil.VisibleOn(driver, FlashMessage, 30);
		String Message= FlashMessage.getText();
		if(Message.contains("Code already exists"))
		{
			cancel.click();
		}
		System.out.println(Message);
		return Message;

	}

	public String Codevalue()
	{
		Otherdiagnosis.click();
		TestUtil.VisibleOn(driver, CodeValue, 30);
		String codevalue = CodeValue.getText(); 
		return codevalue;
		
	}
	public boolean FavoriteEnabledConditionWhenLike()
	{
		System.out.println("Favorite is displayed"+ FavoriteDisLike.isDisplayed()+ "Favorite enable"+ FavoriteDisLike.isEnabled());

		TestUtil.VisibleOn(driver, FavoriteDisLike, 20);
		FavoriteDisLike.isEnabled();
		
		return true;
		
	}
	
	public boolean FavoriteEnabledConditionWhenDislike()
	{
		FavoriteLike.click();
		TestUtil.VisibleOn(driver, FavoriteLike, 20);
		FavoriteLike.isEnabled();
		System.out.println("when clik on favorite"+ FavoriteDisLike.isEnabled());
		
		return false;
		
	}
	
	
	
	
	

}
