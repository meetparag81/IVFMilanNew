

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Test1 
{
	
	
	
	public static void main(String[] args) throws Exception 
	{
				WebDriver driver;
				System.setProperty("webdriver.chrome.driver" ,"C:\\Parag\\Paragdata30032018\\Parag\\Selenium\\Selenium Setup\\chrome exe for 65\\chromedriver.exe");
				driver = new ChromeDriver(); 
				driver.get("http://115.112.255.101:90/#/Login");
				driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("smitha.p");
				driver.findElement(By.id("password")).sendKeys("milann@1");
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				 WebElement clinic;
				 clinic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@id='InputSourceOfReference']"))));
				Select drop = new Select(clinic);
				drop.selectByVisibleText("Milann - Kumarapark");
				driver.findElement(By.name("Login")).click();
				 WebElement patient;
				 patient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patientBtn")));	
				 patient.click();
				
				 driver.findElement(By.id("txtfullName")).sendKeys("Ramesh");
				 //Thread.sleep(1000);
				 List<WebElement>search= driver.findElements(By.xpath("//ul[@role='listbox']//li/a[@tabindex= '-1']"));
				 System.out.println("totalsearch"+ search.size());
				
			for(int i=0;i<search.size();i++)
					{
						
							if(search.get(i).getText().contains("Chaya Ramesh"))
							{
								Actions act = new Actions(driver);
								act.moveToElement(search.get(i)).perform();
								//search.get(i).click();
								System.out.println("clicked on Paitent");
								break;
							}
							
							WebElement visit= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody//td/div/input[@id=0]"));
							System.out.println("checkbox is displayed"+ visit.isDisplayed());
							System.out.println("checkbox is displayed"+ visit.isDisplayed());
							System.out.println("checkbox is displayed"+ visit.isSelected());
							Thread.sleep(5000);
							visit.click();
							System.out.println("after checkbox click");
								List<WebElement>visit1 =driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody//td/div/input"));
								System.out.println("History Row are" + visit1.size());
								for(int j=0;j<visit1.size();j++)
									{
											Thread.sleep(3000);
											List<WebElement> checkboxes=driver.findElements(By.xpath("html/body/div[1]/div/div/div/table/tbody//tr/td//input"));
											for(int k=0;k<checkboxes.size();k++)
													{
												if(k==0)
												{
													checkboxes.get(k).click();
													break;
												}
												System.out.println(("clickoncheckbox"));
													}
											Thread.sleep(3000);
											
											
											visit.click();
									
											/*Actions act = new Actions(driver);
											act.click(checkbox);
											*/
														
													
											}
								
								
												
									
						}
					
					
					
					
			}
			
												/*List<WebElement>history =driver.findElements(By.xpath("html/body/div[1]/div/div/table/tbody//tr/td/div//input"));
												System.out.println("History Row sare" + history.size());
												for(int j=0;j<history.size();j++)
												{
													if(history.size()!=0)
													{
													driver.findElement(By.xpath("html/body/div[1]/div/div/table/tbody//tr/td/div//input[1]")).click();
													System.out.println(("clickoncheckbox"));
													}
													else
													{
														
													}*/
			}
			
					
		 
		
	


