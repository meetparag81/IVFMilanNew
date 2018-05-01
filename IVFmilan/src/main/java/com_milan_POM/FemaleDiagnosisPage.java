package com_milan_POM;

import java.util.List;

import org.apache.poi.hssf.util.HSSFColor.TEAL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class FemaleDiagnosisPage extends TestBase 
{
	@FindBy(xpath="//span[@class='glyphicon glyphicon-plus']")WebElement Plus;
	@FindBy(xpath="//a[@role='tab'][1]")WebElement Otherdiagnosis;
	@FindBy(name="Code")WebElement Codeinput;
	@FindBy(name="Diagnosis")WebElement description;
	@FindBy(xpath="(//button[@class='btn btn-primary'][@type='button'])[6]")WebElement Save;
	@FindBy(xpath="(//th[text()='Diagnosis']/following::tr[1]/td[4])[2]")WebElement CodeValue;
	@FindBy(xpath="(//th[text()='Diagnosis'])[2]//following::tr/td[3]")WebElement Diagnosistext;
	@FindBy(xpath="//tbody/tr[2]/td[1]//span[@class='like']")WebElement FavoriteDisLike;
	@FindBy(xpath="//tbody/tr[3]/td[1]//span[@class='dislike']")WebElement FavoriteLike;
	@FindBy(xpath="//div[@id='toasty']")WebElement FlashMessage;
	@FindBy(xpath="//div[@id='toasty']/div")WebElement favoritemessage;
	@FindBy(xpath="//div[@id='toasty']/div")WebElement unfavoritemessage;
	@FindBy(xpath="(//button[@class='btn btn-default'])[6]")WebElement cancel;
	@FindBy(xpath="(//a[text()='Next'])[2]")WebElement Next;
	@FindBy(xpath="(//th[text()='Select']//following::input)[2]")WebElement checkbox;
	@FindBy(xpath="//th[text()='Type']//following::select")WebElement Typebox;

	
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
		Codeinput.sendKeys("02574");
		TestUtil.VisibleOn(driver, description, 30);
		description.sendKeys("test24574");
		TestUtil.VisibleOn(driver, Save, 30);
		Save.click();
		
		
		
	}
	public String CodeUpdatedMessage() 
	{	
		TestUtil.VisibleOn(driver, FlashMessage, 20);
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
	public String FavoriteTheFavoriteIcon() throws Exception
	{
				
		//System.out.println("Favorite is displayed"+ FavoriteDisLike.isDisplayed()+ "Favorite enable"+ FavoriteDisLike.isEnabled());
		Otherdiagnosis.click();
		List<WebElement>Favorite= driver.findElements(By.xpath("(//table[@class='table table-hover table-striped'])[2]/tbody/tr/td[2]//span[@class='like']"));
		int Size= Favorite.size();
		for(int j=1;j<=25;j++)
		{
				if(Size!=0)
				{
				
					for( int i=1;i<=Size;i++)
					{
						Thread.sleep(1000);
						boolean enabled = Favorite.get(i).isEnabled();
						boolean displayed=Favorite.get(i).isDisplayed();
						if(enabled== true&&displayed==true)
						{
							Favorite.get(i).click();
							break;
						}
					}
					String FavMessage= favoritemessage.getText();
					
					return FavMessage;
				}
				else
				{
					Save.click();
				}
		}
			
		String FavMessage= unfavoritemessage.getText();
		return FavMessage;
			
			
			
		
		
		

		
		
		
		

		
	}
	
	public String UnFavoriteTheFaviorite() throws Exception
	{
		Otherdiagnosis.click();
		List<WebElement>favorite1=driver.findElements(By.xpath("(//table[@class='table table-hover table-striped'])[2]/tbody/tr/td[2]//span[@class='dislike']"));
		int Size= favorite1.size();
		for(int j=1;j<=25;j++)
		{
				if(Size!=0)
				{
				
					for( int i=1;i<Size;i++)
					{
						Thread.sleep(1000);
						boolean enabled = favorite1.get(i).isEnabled();
						boolean displayed=favorite1.get(i).isDisplayed();
						if(enabled== true&&displayed==true)
						{
							favorite1.get(i).click();
							break;
						}
					}
					TestUtil.VisibleOn(driver, unfavoritemessage, 30);
					String UnFavMessage= favoritemessage.getText();
					System.out.println(UnFavMessage);
					return UnFavMessage;
				}
				else
				{
					Save.click();
				}
		}
			
		String FavMessage= favoritemessage.getText();
		return FavMessage;
				
	}
	
	
	
	
	public boolean TypeSelectionboxEnablecondition()
	{
		TestUtil.VisibleOn(driver, checkbox, 30);
		checkbox.click();
		Select Type1 = new Select(Typebox);
		Type1.selectByVisibleText("Final");
		Typebox.isDisplayed();
		
		return true;
		
	}
	
	
	
	
	

}

