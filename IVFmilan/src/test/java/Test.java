

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver" ,"D:\\Parag\\Selenium\\Selenium Setup\\chrome exe for 65\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("http://115.112.255.101:90/#/Login");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("smitha.p");
		driver.findElement(By.id("password")).sendKeys("milann@1");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		/*Select clinicdrop = new Select(driver.findElement(By.id("InputSourceOfReference"))); 
		Thread.sleep(2000);
		clinicdrop.selectByVisibleText("Milann - Kumarapark");*/
		//Thread.sleep(3000);
		Select drop1=new Select(driver.findElement(By.xpath("//*[@id='InputSourceOfReference']")));
		drop1.selectByVisibleText("Milann - Kumarapark");
		driver.findElement(By.name("Login")).click();
		
		//td[@id="tableToExport"]/table/tbody/tr[8]/td[4]
		//td[@id="tableToExport"]/table/tbody/tr[9]/td[4]
		
		
		/*String name = driver.findElement(By.xpath("//*[@id='tableToExport']/table/tbody/tr[9]/td[5]")).getText();
		System.out.println("ghh"+name);*/
		
		
			int i=1;
			int j = 1;
			
			for(i=1;i<=104;i++)
			{
				/*for(int j=1;j<=11;j++)
				{*/
					
				
				
				if(j <= 10)
				{
					
					
						String name1=driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+ j +"]/td[4]")).getText();
						System.out.println(name1+ i+ j);
										
					Thread.sleep(3000);
					if(name1.contains("Mr.Panduranga Garag D"))
					{
						
						
						//System.out.println("Paient name is" + name1);
						Thread.sleep(3000);
						driver.findElement(By.xpath("//div[@id='tableToExport']/table/tbody/tr["+ j +"]/td[1]/a[2]")).click();
						System.out.println("click on EMR ");
						//driver.findElement(By.linkText("EMR")).click();
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
					/*WebDriverWait wait = new WebDriverWait(driver, 20);
					 WebElement next;
					next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains (text(), 'Next')]")));	
					next.click();
					*/
				}
				
				
				
			/*}
			/*WebElement page= driver.findElement(By.xpath("//a[contains (text(), 'Next')]"));
			System.out.println(page.isEnabled());
			System.out.println(page.isDisplayed());
			System.out.println(page.isSelected());*/
			
			
	
		}
	}
}


