package com_milan_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class Loginpage extends TestBase {
	@FindBy(xpath = "//input[@id='userName']")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(name = "InputSourceOfReference")
	private WebElement clinic;
	@FindBy(name = "Login")
	private WebElement Loginbutton;
	@FindBy(name = "Login")
	private WebElement homepagetxt;
	@FindBy(xpath = "//span[text() = 'Total Count :']//following::span")
	WebElement SizeOfPaitent;
	private @FindBy(xpath = "//span[@class='errorMsg ng-binding']")
	WebElement Msgcorrectusername;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	

	public Loginpage() {

		PageFactory.initElements(driver, this);
	}

	public HomePage Verifylogin(String un, String psw) 
	{
		username.sendKeys(un);

		password.sendKeys(psw);

		try
		{
		TestUtil.VisibleOn(driver, clinic, 30);
		}
		catch(Exception e)
		{
			System.out.println("TimeoutExceptionseen");
		}
				Select drop = new Select(clinic);
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Element seen within 20 secs");
		}
		drop.selectByVisibleText("Lavida Fertility Bangkok");
		Loginbutton.click();
		return new HomePage();

	}

	public String Homepagetitle() 
	{
		
		String msg = driver.getTitle();
		return msg;

	}

	public boolean ButtonEnableCondition(String un) {
		username.sendKeys(un);
		boolean flag = Loginbutton.isEnabled();

		if (flag == false) {
			System.out.println("username or password is bot entered");
		}
		return flag;

	}

	public String Invalidusername(String un) 
	{
		username.clear();
		username.sendKeys(un);
		password.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		String message = Msgcorrectusername.getText();
		return message;
	}

	public String Invaliduserpassword(String un, String psw) 
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(psw);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		clinic = wait.until(ExpectedConditions.visibilityOf(clinic));
		Select drop = new Select(clinic);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		drop.selectByVisibleText("Lavida Fertility Bangkok");
		Loginbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("The InterruptedException is occured");
		}
		String message = Msgcorrectusername.getText();
		return message;

	}
}
