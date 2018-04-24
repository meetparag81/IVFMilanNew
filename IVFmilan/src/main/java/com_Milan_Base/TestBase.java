package com_Milan_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try
		{
			prop = new Properties();
			 ip = new FileInputStream("C:\\Parag\\Paragdata30032018\\Parag\\JavaProgramme\\IVFmilan\\src\\main\\java\\com_Milan_config\\config.proerties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
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
			System.setProperty("webdriver.chrome.driver" ,"C:\\Parag\\Paragdata30032018\\Parag\\Selenium\\Selenium Setup\\chrome exe for 65\\chromedriver.exe");
			driver = new ChromeDriver();
		 }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	
	
	

}
