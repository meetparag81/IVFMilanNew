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
	@FindBy(xpath="//div[@id='toasty']/div")WebElement DeleteMessage;
	@FindBy(xpath="(//a[@role='tab'])[2]")WebElement FavouriteDiagnosis;
	@FindBy(xpath="(//a[text()='Favourite Diagnosis']//following::input)[11]")WebElement SearchFavorite;
	
	@FindBy(xpath="(//a[text()='Last'])[3]")WebElement Last;
	@FindBy(xpath="(//table[@class='table table-hover table-striped'])[3]//tr/td[3]")WebElement Favoritename;
	@FindBy(xpath="(//table[@class='table table-hover table-striped'])[3]//tr/td[1]/button")WebElement Delete;
	@FindBy(xpath="(//div[@class='btn input-group-addon'])[3]")WebElement Searchckick;
	@FindBy(name="Reason")WebElement Reasonfordelete;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[5]")WebElement SaveonReason;
	@FindBy(xpath="//table[@class='table table-hover table-striped']/tbody/tr[1]/td[2]/div")WebElement ClickFavorite;
	
	
	
	int count;
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
		Codeinput.sendKeys("delete189");
		TestUtil.VisibleOn(driver, description, 30);
		description.sendKeys("delete1189");
		}
		TestUtil.VisibleOn(driver, Save, 30);
		Save.click();
		
		
		
	}
	
	public void ClickOnOtherDiagbosisForNewPaitent() throws Exception
	{
		Otherdiagnosis.click();

		TestUtil.VisibleOn(driver, Plus, 30);
		Plus.click();
		TestUtil.VisibleOn(driver, Codeinput, 30);
		Codeinput.sendKeys("delete1389");
		TestUtil.VisibleOn(driver, description, 30);
		description.sendKeys("delete1389");
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
	public String ClickonFavoriteIcon() throws Exception
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
						Thread.sleep(3000);
						//boolean enabled = Favorite.get(i).isEnabled();
						boolean displayed=Favorite.get(i).isDisplayed();
						if(displayed==true)
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
						Thread.sleep(3000);
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
	
	public String DeleteFromFavorite() throws Exception
	{
		Otherdiagnosis.click();	
		List<WebElement>code=driver.findElements(By.xpath("(//div[@class='table-responsive table-bordered fixed_header'])[1]//tr/td[4]"));
		TestUtil.VisibleElementsOn(driver, code, 30);
		
		for(int i=1;i<=code.size();i++)
		{
			Thread.sleep(2000);
			WebElement codename= driver.findElement(By.xpath("(//div[@class='table-responsive table-bordered fixed_header'])[1]//tr["+i+"]/td[4]"));
			String codename1= codename.getText();
			if(codename1.contains("delete1289"))
			{
				ClickFavorite.click();
				break;
			}
		}		
		FavouriteDiagnosis.click();
		Thread.sleep(3000);
		SearchFavorite.sendKeys("delete1289");
		Thread.sleep(1000);
		Searchckick.click();
		Last.click();
		TestUtil.VisibleOn(driver, Favoritename, 30);
		String Name= Favoritename.getText();
		if(Name.contains("delete1289"))
		{
			Delete.click();
			TestUtil.VisibleOn(driver, Reasonfordelete, 20);
			Reasonfordelete.sendKeys("NA");
			SaveonReason.click();
			
		}
		else
		{
			System.out.println("Favorite is not onlast page");	
		}
		TestUtil.VisibleOn(driver, DeleteMessage, 30);
		return DeleteMessage.getText();		
	}
	
	public boolean checkboxclick() throws Exception
	{
		FavouriteDiagnosis.click();
		List<WebElement>checkboxes= driver.findElements(By.xpath("(//table[@class='table table-hover table-striped'])[3]//td[2]/input[@type='checkbox']"));
		int sizechecboxes= checkboxes.size();
		for(WebElement  checkbox:checkboxes)
		{
			checkbox.click();
		}
		Thread.sleep(3000);
		List<WebElement>Types= driver.findElements(By.xpath("(//table[@class='table table-hover table-striped'])[3]//td[5]/select"));
		for(WebElement Type:Types)
		{
		boolean check =	Type.isDisplayed();
		if(check==true)
		{
		 count++;
			
		}
		if(count<=4)
		{
			System.out.println("Typebox"+ count+ "is enabled");
		}
			
		}
		return true;
		
		
		
	}
	
	
	
	
	

}

