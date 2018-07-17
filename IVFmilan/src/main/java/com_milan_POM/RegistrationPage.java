package com_milan_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

import com_Milan_util.TestUtil;

public class RegistrationPage 
{
	
	
	

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver" ,"C:\\Parag\\Paragdata30032018\\Parag\\Selenium\\Selenium Setup\\chrome exe for 65\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.1.94:5050");
		driver.findElement(By.name("LoginName")).sendKeys("Anuradha.A");
		driver.findElement(By.name("password")).sendKeys("palash@1");
		WebElement clinicdrop= driver.findElement(By.xpath("//select[@name='InputSourceOfReference']"));
		Select clinicdrop1= new Select(clinicdrop);
		clinicdrop1.selectByVisibleText("Embrio");
		driver.findElement(By.name("Login")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		
		}
		WebElement Registration = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Registration']"));
		Actions act= new Actions(driver);
		try
		{
		TestUtil.VisibleOn(driver, Registration, 30);
		}
		catch(Exception e)
		{
			System.out.println("Element-Registration is not seen within 30 sec");
		}
		act.moveToElement(Registration).click().perform();
		
		WebElement RegistrationPage= driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Registration']//following-sibling::div//li[1]/a"));
		act.moveToElement(RegistrationPage).click().perform();
		
		WebElement LinkbuttonforAttachpage= driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-sm'])[1]"));
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeAsyncScript("arguments[0].scrollIntoView(true);", LinkbuttonforAttachpage);*/
		try
		{
		TestUtil.VisibleOn(driver, LinkbuttonforAttachpage, 30);
		TestUtil.ActionForMovetoElement(LinkbuttonforAttachpage);
		}
		catch(Exception e)
		{
			System.out.println("Element- LinkbuttonforAttachpage is not seen within 30 sec");
		}
		LinkbuttonforAttachpage.click();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
