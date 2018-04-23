package com_milan_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;

public class Loginpage extends TestBase
{
	@FindBy(xpath="//input[@id='userName']")
	 WebElement username;
	@FindBy(id="password")
	 WebElement password;
	@FindBy(name="InputSourceOfReference")
	 WebElement clinic;
	@FindBy(name="Login")
	 WebElement Loginbutton;
	@FindBy (name= "Login" )
	 WebElement homepagetxt;
	@FindBy (xpath= "//span[text() = 'Total Count :']//following::span") WebElement SizeOfPaitent;
	
	
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	public Loginpage()  
	{
		
		PageFactory.initElements(driver, this);
	}

	public HomePage Verifylogin(String un, String psw) throws Exception
	{
		username.sendKeys(un);
		
		password.sendKeys(psw);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		clinic= wait.until(ExpectedConditions.visibilityOf(clinic));
		//clinic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@id='InputSourceOfReference']"))));
		Select drop = new Select(clinic);
		Thread.sleep(2000);
		drop.selectByVisibleText("Milann - Kumarapark");
		Loginbutton.click();
		return  new HomePage();
		
		
				
	}
	public  String Homepagetitle()
	{
		System.out.println("========Homepagetitle testcase started======");
		String msg= driver.getTitle();
		return msg;
		
	}
	
	
	/*public  EMRDashBoardPage ClickonEMR() throws Exception
	{
		System.out.println("========EMR click testcase started======");
		int i=1;
		int j = 1;
		int size=0;
		
        try {
        	String s = SizeOfPaitent.getText();
        	 size= Integer.parseInt(s);
   		 System.out.println("Patient size is" + size);
        	}
        catch(NumberFormatException e)
        {
        	System.out.println("You've entered non-integer number");
        }
         
		for(i=1;i<=size;i++)
		{
		if(j <= 10)
			{
			Thread.sleep(3000);
			String name1=driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+ j +"]/td[4]")).getText();
			//System.out.println(name1+ i+ j);
			
									
				Thread.sleep(3000);
				if(name1.contains("Ms.Lakshmi"))
					
				{
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+ j +"]/td[1]/a[2]")).click();
					System.out.println("click on EMR ");
					i=122;
					System.out.println("===========recodfound==============");
					break;	
					
				}
				
				
				j++;
			}
			else
			{
				j=1;
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				//jse.executeScript("scroll(0, 250)");
				WebElement element = driver.findElement(By.xpath("//a[contains (text(), 'Next')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				System.out.println("=============clicked on next==========");
				
		
	}


	
	
	
	
		
}
		return  new EMRDashBoardPage();
	}*/
}


