package com_Milan_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Listeners;

import com_Milan_util.TestNGListners;
import com_Milan_util.TestUtil;
import com_Milan_util.WebEventListener;
 
@Listeners(com_Milan_util.TestNGListners.class)
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverEventListener e_driver;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try
		{
			prop = new Properties();
			 ip = new FileInputStream("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_config\\config.proerties");
			try {
				prop.load(ip);
			} catch (IOException e) 
			{
				
				System.out.println("IOException is seen");
			}
		}
		catch (FileNotFoundException e) 
		{
			
			System.out.println("FileNotFoundException is seen");
		}
			
		
	}
	
	public static void initalization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Parag\\Paragdata30032018\\Parag\\Selenium\\Selenium Setup\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();		
		}	
		else if(browsername.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver" ,"C:\\Parag\\Selenium\\Selenium Setup\\chromeexe for 67to69\\chromedriver.exe");
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.logfile", "C:\\chromelogsB68\\chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			System.out.println("Webdriver Logs are created");
		 }
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
			WebDriverEventListener eventListener =  new TestNGListners();
			e_driver.register(eventListener);
			driver = e_driver;			
		e_driver.register(eventListener);
		driver = e_driver;
		try
		{
		driver.manage().window().maximize();
		}
		catch(WebDriverException e)
		{
			System.out.println("Webdriver exception seen");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try
		{
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			System.out.println("url is not entered");
			
		}
		
	}
	
	
	

}

