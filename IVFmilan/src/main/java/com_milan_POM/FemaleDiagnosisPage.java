package com_milan_POM;

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
	
	 public FemaleDiagnosisPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	
	
	public void ClickOnOtherDiagnosis() throws Exception
	{
		//TestUtil.VisibleOn(driver, Otherdiagnosis, 30);
		Otherdiagnosis.click();
		Thread.sleep(3000);
		String val= CodeValue.getText();
		int codeval = Integer.parseInt(val);
		if(val.contains("003"));
		TestUtil.VisibleOn(driver, Plus, 30);
		Plus.click();
		TestUtil.VisibleOn(driver, Codeinput, 30);
		Codeinput.sendKeys(("+codeval+"+1));
		TestUtil.VisibleOn(driver, description, 30);
		description.sendKeys("test");
		TestUtil.VisibleOn(driver, Save, 30);
		Save.click();
	}
	public String Codevalue()
	{
		Otherdiagnosis.click();
		String codevalue = CodeValue.getText(); 
		return codevalue;
		
	}
	
	
	
	

}
