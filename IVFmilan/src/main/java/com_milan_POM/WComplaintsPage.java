package com_milan_POM;

import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WComplaintsPage extends TestBase
{
	private @FindBy(xpath="//label[@class='col-md-12 col-lg-12 control-label']/following::button[@class='ng-binding']")WebElement Buttoncomplaints;
	@FindBy(xpath="//div[@class='checkboxLayer show']/div[2]")WebElement PresentingComplaints;
	@FindBy(xpath="//div[@id='toasty']")WebElement FlashMessage;
	@FindBy(xpath="//textarea[@name='FollowUpNotes']")WebElement FollowupNotes;
	@FindBy(xpath="//textarea[@name='Reason']")WebElement FollowUpReason;
	@FindBy(xpath="//button[@class='btn btn-primary ng-binding']")WebElement Save;
	@FindBy(xpath="//label [@class='col-sm-12 col-md-12 col-lg-12 control-label']//following::i")WebElement calender;
	List<WebElement>Rows= driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
	
	
	int i;
	int j;
	int count=0;
	
	WComplaintsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public  int NewPatientPresentingComplaints() throws Exception
	{
		List<WebElement>Rows= driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
		int NoofRows= Rows.size();
		if(NoofRows==0)
		{
			Thread.sleep(2000);	
			try{
				WebElement ele = Buttoncomplaints;
			Buttoncomplaints.isEnabled();
			}
			catch(Exception e)
			{
				TestUtil.getScreenshot(driver, "NewPatientPresentingComplaints"+".png");
				throw(e);
			
			
			}
			
			System.out.println("button is disabled"+ Buttoncomplaints.isEnabled()+"buttonisdisplayed"+Buttoncomplaints.isDisplayed());
			Buttoncomplaints.click();
			Thread.sleep(2000);
			List<WebElement> complaints = driver.findElements(By.xpath("//div[@class='checkBoxContainer']/div"));
			for(WebElement comp:complaints)
			{
			comp.click();
			count++;
				if(count==4)
				{
					System.out.println("count is"+ count);
					break;
					
				}
			}
		}
		else
		{
			System.out.println("Patient is existing Patient");
		}
		
		return count;	
			
	}
		
		private void ExistingPatientPresentingComplaints() throws Exception
		{
			List<WebElement>Rows= driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
			int NoofRows= Rows.size();
			if(NoofRows!=0)
				{
					for(int i=1;i<=NoofRows;j++)
						{
							String complaintname=	Rows.get(i).getText();
							Buttoncomplaints.click();
							Thread.sleep(3000);
								List<WebElement> complaints = driver.findElements(By.xpath("//div[@class='checkBoxContainer']/div"));
								int complaintsnamessize= complaints.size();
								for(int j = 1;j<=complaintsnamessize;j++)
									{
										String Names= complaints.get(j).getText();
											if(Names.contentEquals(complaintname))					
											{
												complaints.get(j).click();
												count++;
												break;
											}								
									}						
							}		
				}
			
			}
		public String SaveTheComplaints()
		{
			List<WebElement>Rows= driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
			List<WebElement> complaints = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr/td[2]"));
			int NoofRows= Rows.size();
			for(int k=1;k<=NoofRows;k++)
			{				int SRNO= k;
				//int No=Integer.parseInt(SRNO);
				//List<WebElement> PresentingComplaint=  driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr/td[3]/span"));
				//String Names=PresentingComplaint.get(i).getText();
			
				if(SRNO==1)
				{	
					
					WebElement Onset1 =  driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[4]/select"));
					Select Onsetone= new Select(Onset1);
					Onsetone.selectByVisibleText("Gradual");
					WebElement DurationDay1  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[1]"));
							Select DurationDayone= new Select(DurationDay1); 
							DurationDayone.selectByVisibleText("10");
							WebElement DurationMonth1  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[2]"));
							Select DurationMonthone = new Select(DurationMonth1);
							DurationMonthone.selectByVisibleText("2");
							WebElement DurationYear1  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[3]"));
							Select DurationYearone = new Select(DurationYear1);
							DurationYearone.selectByVisibleText("5");
							
				}
				else if(SRNO==2)
				{
					WebElement Onset2 =  driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[4]/select"));
					Select Onsettwo= new Select(Onset2);
					Onsettwo.selectByVisibleText("Gradual");
					WebElement DurationDay2  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[1]"));
					Select DurationDaytwo= new Select(DurationDay2); 
					DurationDaytwo.selectByVisibleText("10");
					WebElement DurationMonth2  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[2]"));
					Select DurationMonthtwo = new Select(DurationMonth2);
					DurationMonthtwo.selectByVisibleText("2");
					WebElement DurationYear2  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[3]"));
					Select DurationYeartwo = new Select(DurationYear2);
					DurationYeartwo.selectByVisibleText("6");
				}
				else if (SRNO==3) 
				{
					WebElement Onset3 =  driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[4]/select"));
					Select Onsetthree= new Select(Onset3);
					Onsetthree.selectByVisibleText("Gradual");
					WebElement DurationDay3  =  driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select[1]"));
					Select DurationDaythree= new Select(DurationDay3); 
					DurationDaythree.selectByVisibleText("23");
					WebElement DurationMonth3  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[2]"));
					Select DurationMonththree = new Select(DurationMonth3);
					DurationMonththree.selectByVisibleText("2");
					WebElement DurationYear3  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[3]"));
					Select DurationYearthree = new Select(DurationYear3);
					DurationYearthree.selectByVisibleText("6");
					
				}
				else if (SRNO==4) 
				{
					WebElement Onset4 =  driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[4]/select"));
					Select Onsetfour= new Select(Onset4);
					Onsetfour.selectByVisibleText("Sudden");
					WebElement DurationDay4 =  driver.findElement(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select[1]"));
					Select DurationDayfour= new Select(DurationDay4); 
					DurationDayfour.selectByVisibleText("29");
					WebElement DurationMonth4  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[2]"));
					Select DurationMonthfour = new Select(DurationMonth4);
					DurationMonthfour.selectByVisibleText("2");
					WebElement DurationYear4  =  driver.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr["+k+"]/td[5]//select)[3]"));
					Select DurationYearfour = new Select(DurationYear4);
					DurationYearfour.selectByVisibleText("6");
					
				}
				
			}
			TestUtil.VisibleOn(driver, FollowUpReason, 20);
			try
			{
			FollowUpReason.sendKeys("b18AxXqMeOtJgPwWCJALHauhJlcnX9Zi1hmHl3QQS1eWEriLqjBW58N2s5r7qS5ZdsdbJEXXboiPMNmh7DxCblhSCaUasVr1yzgYjOt0pgRWKP4kAPrO7Dsv4JJGqJjXOPWg9fOj4pWmbgcRdHxAam9H8nBHbuDsS4FyryDhoYubkCVRAs90YxmCnXkKXtjDfWcRErPVyW5Al5Zy5jEbmkCqPkYXjXSrLZyjSmV9DbUiXRNcuGw9oGRx2P");
			}
			catch(TimeoutException e)
			{
				Log.getLog();
				throw(e);
			}
			TestUtil.VisibleOn(driver, FollowupNotes, 20);
			FollowupNotes.sendKeys("b18AxXqMeOtJgPwWCJALHauhJlcnX9Zi1hmHl3QQS1eWEriLqjBW58N2s5r7qS5ZdsdbJEXXboiPMNmh7DxCblhSCaUasVr1yzgYjOt0pgRWKP4kAPrO7Dsv4JJGqJjXOPWg9fOj4pWmbgcRdHxAam9H8nBHbuDsS4FyryDhoYubkCVRAs90YxmCnXkKXtjDfWcRErPVyW5Al5Zy5jEbmkCqPkYXjXSrLZyjSmV9DbUiXRNcuGw9oGRx2P");
			Save.click();
			System.out.println(FlashMessage.getText());
			return FlashMessage.getText();
		}
		
		public boolean NextFollowUp()
		{
			try
			{
			TestUtil.VisibleOn(driver, calender, 20);
			}
			catch(TimeoutException e)
			{
				System.out.println("Element is not seen within time");
				throw(e);
			}
			calender.click();
			List<WebElement>Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']/tbody//td/button"));
			int datesize= Dates.size();
			boolean enabledcondition = false;
			for(int i=1;i<=datesize;i++)
			{
				if(Dates.get(i).getText().contains("03"))
				{
				boolean dateenabled= Dates.get(i).isEnabled();
				//System.out.println("Previous date is enabled"+dateenabled);
					 enabledcondition=dateenabled;
						 break;
					
					
				}
				
						
			}
			return enabledcondition;
					
			
			
		}
		
		
		
}
	
			
			
			
			
			
			
		

		



