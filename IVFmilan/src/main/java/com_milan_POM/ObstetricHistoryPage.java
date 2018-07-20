package com_milan_POM;

import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class ObstetricHistoryPage extends TestBase {
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	TestUtil Testutl;
	WebElement Outcome;
	@FindBy(xpath = "//span[text()='G']//following::input[1]")WebElement NewRowcount;
	@FindBy(xpath = "//span[text()='G']//following::input[2]")WebElement StillBorn;
	@FindBy(xpath = "//span[text()='G']//following::input[3]")WebElement LiveBirth;
	@FindBy(xpath = "//span[text()='G']//following::input[4]")WebElement Abortion;
	@FindBy(xpath = "//span[text()='G']//following::input[5]")WebElement Ectopic;
	@FindBy(xpath = "//button[text()='Add Rows'][1]")WebElement AddnewRows;
	@FindBy(xpath = "//th[text()='Year']//following::select[1]")WebElement Year;
	@FindBy(xpath = "//th[text()='Gestation Weeks']//following::select[2]")WebElement Gestation;
	@FindBy(xpath = "//th[text()='Outcome']//following::select[3]")WebElement outcome;
	@FindBy(xpath = "//button[@id='datepicker-1759-4654-title']//preceding::i")WebElement Previousmonth;
	@FindBy(xpath = "//th[text()='Delivery']//following::input[2]")WebElement Birthweight;
	@FindBy(xpath = "//th[text()='Delivery']//following::select[6]")WebElement Delivery;
	@FindBy(xpath = "//th[text()='Complications']//following::select[7]")WebElement Complications;
	@FindBy(xpath = "//th[text()='Congenital Anamoly']//following::select[8]")WebElement CongenitalAnamoly;
	@FindBy(xpath = "//th[text()='Congenital Anamoly']//following::input[3]")WebElement Remark;
	@FindBy(xpath = "//th[text()='Remark']//following::input[3]")WebElement Remarks;
	@FindBy(xpath = "//table[@id='ObstetricHistory']/tbody/tr")	WebElement table;
	@FindBy(xpath = "(//table[@id='ObstetricHistory']/tbody/tr[1]//td//select)[5]")	WebElement DeliveryType;
	@FindBy(xpath = "//button[text()='Add Rows'][1]")WebElement Addrows;
	@FindBy(xpath = "//button[@class='btn btn-primary ng-binding']")WebElement Save;
	@FindBy(xpath = "//*[@id='ObstetricHistory']/tbody/tr[1]/td[14]/span")WebElement Delete;
	@FindBy (xpath="//span[@class='toast-msg ng-binding ng-scope']") WebElement FlashMessage;
	int rows1 = 0;
	int rowcount;
	int rowcount1;
	String msg;
	String thismonth;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");

	public ObstetricHistoryPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean NoOfRows()
	{
		boolean flag;
		List<WebElement>Rows= driver.findElements(By.xpath("//table[@class='table table-hover table-striped table-bordered']//tbody/tr"));
		int NoOfRows = Rows.size();
		if(NoOfRows>2)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		
		return flag;
		
	}
	public boolean ButtonText()
	{
		boolean flag= false;
		try
		{
		TestUtil.VisibleOn(driver, Save, 30);
		TestUtil.ActionForMovetoElement(Save);
		}
		catch(Exception e)
		{
			System.out.println("timeout exception");
		}
		String S= Save.getText();
		if(S.equals("Save"))
		{
			flag= true;
		}
		else
		{
			flag=false;
		}
		
		
		return flag;
	}
	
	public String SaveObstetricHistory()
	{
		boolean flag1 = ButtonText();//save button true
		boolean flag2= NoOfRows();// No of rows greater than 1  then true
		if(flag1==true&&flag2==false)//Save button and New patient
		{
			NewSaveOutcometypes();
			Save.click();
			TestUtil.ActionForMovetoElement(FlashMessage);
			msg= FlashMessage.getText();
			msg = "Record saved successfully!";
		}
		else if(flag1==false&&flag2==true)//update button and existingpatient
		{
			ExistingSaveOutcometypes();
			Save.click();
			TestUtil.ActionForMovetoElement(FlashMessage);
			msg = FlashMessage.getText();
			msg = "Record updated successfully!";
		}
		else if(flag1==true&&flag2==true)//Save button and Existing Patient
		{
			ExistingSaveOutcometypes();
			Save.click();
			TestUtil.ActionForMovetoElement(FlashMessage);
			msg = FlashMessage.getText();
			msg = "Record updated successfully!";
			
			
		}
		else if (flag1==false&&flag2==false)//UpdateButton and NewPatient
		{
			NewSaveOutcometypes();
			Save.click();
			TestUtil.ActionForMovetoElement(FlashMessage);
			msg= FlashMessage.getText();
			msg = "Record saved successfully!";
			
		}
		
		
		
		return msg;
		
	}

	public void NewSaveOutcometypes() 
	{
		List<WebElement> tablerows = driver.findElements(By.xpath("//table[@id='ObstetricHistory']/tbody/tr"));
		int birthoptions = 0;
		birthoptions = birthoptions + 0;
		int rows = tablerows.size();
		rows = rows + 1;
		for (int row1 = rows; row1 <= 5; row1++)
		// while(rows1<=5)
		{
			try
			{
				TestUtil.VisibleOn(driver, Addrows, 30);
			}
			catch(TimeoutException e)
			{
				System.out.println("Timeoutexception seen");
			}
			Addrows.click();
			
			WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
			try
			{
				TestUtil.VisibleOn(driver, Outcome, 30);
			}
			catch(TimeoutException e)
			{
				System.out.println("Timeoutexception seen");
			}
			Select Outcomelist = new Select(Outcome);
			List<WebElement> Typeofoutcome = Outcomelist.getOptions();
			for (int i = 0; i < Typeofoutcome.size(); i++) 
			{
				String Names = Typeofoutcome.get(i).getText();
				switch (Names) 
				{
				case "Livebirth":

					WebElement outcomeLB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
						TestUtil.VisibleOn(driver, outcomeLB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select OutcomeL = new Select(outcomeLB);
					OutcomeL.selectByVisibleText("Livebirth");
					WebElement year = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+ row1 +"]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, year, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select year1 = new Select(year);
					year1.selectByVisibleText("2010");
					WebElement gestation = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[2]"));
					try
					{
						TestUtil.VisibleOn(driver, gestation, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					
					Select Gestation1 = new Select(gestation);
					Gestation1.selectByVisibleText("10");
					WebElement Gender = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[4]"));
					try
					{
						TestUtil.VisibleOn(driver, Gender, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select Gender1 = new Select(Gender);
					Gender1.selectByVisibleText("Male");
					WebElement Deliverytype = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[5]"));
					try
					{
						TestUtil.VisibleOn(driver, Deliverytype, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select Deliverytype1 = new Select(Deliverytype);
					Deliverytype1.selectByVisibleText("Normal");
					row1++;
					System.out.println("Livebirth entries are completed");
					break;
				case "Ectopic":
					Addrows.click();
					WebElement outcomeEB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
						TestUtil.VisibleOn(driver, outcomeEB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select OutcomeE = new Select(outcomeEB);
					OutcomeE.selectByVisibleText("Ectopic");
					WebElement yearE = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearE, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select yearE1 = new Select(yearE);
					try 
					{
						Thread.sleep(3000);
					} 
					catch (InterruptedException e) 
					{
						System.out.println("The InterruptedException is occured");
					}
					// yearE1.selectByIndex(10);
					WebElement gestationEB = driver.findElement(By.xpath("//th[text()='Gestation Weeks']//following::select[2]"));
					try
					{
						TestUtil.VisibleOn(driver, gestationEB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select GestationE = new Select(gestationEB);
					GestationE.selectByVisibleText("10");
					row1++;
					System.out.println("Ectopic entries are completed");
					break;
				case "Abortion":
					Addrows.click();
					WebElement OutcomeAB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
						TestUtil.VisibleOn(driver, OutcomeAB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select OutcomeA = new Select(OutcomeAB);
					OutcomeA.selectByVisibleText("Abortion");
					WebElement yearA = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearA, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select yearA1 = new Select(yearA);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) 
					{
						System.out.println("The InterruptedException is occured");
					
					}
					yearA1.selectByVisibleText("2018");
					WebElement GenderAB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[4]"));
					try
					{
						TestUtil.VisibleOn(driver, GenderAB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select GenderObortion = new Select(GenderAB);
					GenderObortion.selectByVisibleText("Female");
					WebElement gestationA =driver.findElement(By.xpath("//th[text()='Gestation Weeks']//following::select[2]"));
					try
					{
						TestUtil.VisibleOn(driver, gestationA, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select GestationA = new Select(gestationA);
					GestationA.selectByVisibleText("10");
					 WebElement Calender=  driver.findElement(By.xpath("//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//following-sibling::span[@class='input-group-addon']/i"));
					Calender.click();
					TestUtil.Date();
					List<WebElement> Dates = driver.findElements(By.xpath("//table[@role='grid'][@class='uib-daypicker']//tbody//tr//td/button"));
					int rows1=2;
					for(int i1 =1;i1<Dates.size();i1++)
					{
						String Datetext= Dates.get(i1).getText();
						WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
						String text= Monthtextele.getText();
						String Arr[]=text.split(" ");
						String Monthtext = Arr[0]; 
						
						String CyrrentDate=TestUtil.Date();
						String[] Arr1= CyrrentDate.split(",");
						String day= Arr1[0];
						String Month = Arr1[1];
						
					
						boolean flag1= Dates.get(i1).isEnabled();
						rows1++;
						
						if(day.equals(Datetext)&&flag1==true&&Monthtext.equals(Month))
						{
							Dates.get(i1).click();
							break;
						}
					}
					
					row1++;
					System.out.println("Abortion entries are completed");
					break;
				case "Still Born":
					Addrows.click();
					WebElement OutcomeSB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
					TestUtil.VisibleOn(driver, OutcomeSB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexceptionseen");
					}
					Select OutcomeSB1 = new Select(OutcomeSB);
					OutcomeSB1.selectByVisibleText("Still Born");
					WebElement yearSB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearSB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("TimeoutException seen");
					}
					Select yearSB1 = new Select(yearSB);
					try 
					{
						Thread.sleep(2000);
					} 
					catch (InterruptedException e)
					{
						System.out.println("The InterruptedException is occured");
					}
					WebElement GenderSB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[4]"));
					try
					{
						TestUtil.VisibleOn(driver, GenderSB, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select GenderStillborn = new Select(GenderSB);
					GenderStillborn.selectByVisibleText("Male");
					yearSB1.selectByVisibleText("2018");
					WebElement gestationSB = driver.findElement(By.xpath("//th[text()='Gestation Weeks']//following::select[2]"));
					try
					{
						TestUtil.VisibleOn(driver, gestationSB, 30);
					}
					catch(TimeoutException e)
					{
					System.out.println("Timeout exxecption seen");	
					}
					Select GestationSB = new Select(gestationSB);
					GestationSB.selectByVisibleText("10");
					row1++;
					System.out.println("Still Born entries are completed");
					break;

				case "Miscarriage":
					Addrows.click();
					WebElement OutcomeMC = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
						TestUtil.VisibleOn(driver, OutcomeMC, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeout exception seen");
					}
					Select OutcomeMC1 = new Select(OutcomeMC);
					OutcomeMC1.selectByVisibleText("Miscarriage");
					WebElement yearMC = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[3]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearMC, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("TimeoutException seen");
					}
					Select yearMC1 = new Select(yearMC);
					try 
					{
						Thread.sleep(2000);
					} catch (InterruptedException e) 
					{
						System.out.println("The InterruptedException is occured");
					}
					yearMC1.selectByVisibleText("2000");
					WebElement gestationMC = driver.findElement(By.xpath(("//th[text()='Gestation Weeks']//following::select[2]")));
					try
					{
						TestUtil.VisibleOn(driver, gestationMC, 30);
					}
					catch(TestException e)
					{
						System.out.println("Timeout exception seen");
					}
					Select GestationMC = new Select(gestationMC);
					GestationMC.selectByVisibleText("30");
					Delete.click();
					System.out.println("Miscarriage entries are completed");
					break;

				}// switch
				birthoptions++;
			} // outcomefor
		} // rowsfor
		/*if (Save.isDisplayed()) 
		{
			Save.click();
			System.out.println("Save is completed");

		} else {
			System.out.println("Save is not completed");
		}
		String count = NewRowcount.getText();
		while (true) {
			try {
				int Rowscount1 = Integer.parseInt(count);
				break;

			}

			catch (NumberFormatException e) 
			{
				System.out.println("String is not convertedinto number");
				rowcount1 = 5;

			} finally 
			{
				rowcount = rowcount1;
				return rowcount;
			}*/

		

	}// main
	
	public void ExistingSaveOutcometypes() 
	{
		
		List<WebElement> tablerows = driver.findElements(By.xpath("//table[@id='ObstetricHistory']/tbody/tr"));
		
		int birthoptions = 0;
		birthoptions = birthoptions + 0;
		int rows = tablerows.size();
		if(rows>=5)
		{
		rows = rows -4;
		}
		else
		{
			rows=1;
		}
		for (int row1 = rows; row1 <= rows; row1++)
		// while(rows1<=5)
		{
			try
			{
				TestUtil.VisibleOn(driver, Addrows, 30);
			}
			catch(TimeoutException e)
			{
				System.out.println("Timeoutexception seen");
			}
//			Addrows.click();
			
			WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
			
			try
			{
				TestUtil.VisibleOn(driver, Outcome, 30);
			}
			catch(Exception e)
			{
				System.out.println("Timeoutexception seen");
			}
			Select Outcomelist = new Select(Outcome);
			List<WebElement> Typeofoutcome = Outcomelist.getOptions();
			for (int i = 0; i < Typeofoutcome.size(); i++) 
			{
				String Names = Typeofoutcome.get(i).getText();
				switch (Names) 
				{
				case "Livebirth":
					

					WebElement outcomeLB = driver.findElement(By.xpath("(//th[text()='Outcome']//following::tr[" + row1 + "]//div[@class='form-group']/select)[3]"));
					
					try
					{
						 
						TestUtil.VisibleOn(driver, outcomeLB, 30);
						
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select OutcomeL = new Select(outcomeLB);
					OutcomeL.selectByVisibleText("Livebirth");
					
					
					WebElement year = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr["+ row1 +"]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, year, 30);
						TestUtil.ActionForMovetoElement(year);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select year1 = new Select(year);
					year1.selectByVisibleText("2012");
					WebElement gestation = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[2]"));
					try
					{
						TestUtil.VisibleOn(driver, gestation, 30);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					
					Select Gestation1 = new Select(gestation);
					Gestation1.selectByVisibleText("15");
					WebElement Gender = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[4]"));
					try
					{
						TestUtil.VisibleOn(driver, Gender, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select Gender1 = new Select(Gender);
					Gender1.selectByVisibleText("Female");
					WebElement Deliverytype = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[5]"));
					try
					{
						TestUtil.VisibleOn(driver, Deliverytype, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select Deliverytype1 = new Select(Deliverytype);
					Deliverytype1.selectByVisibleText("Caeserian");
					row1++;
					System.out.println("Livebirth entries are completed");
					break;
				case "Ectopic":
				/*	if(rows<1)
					{
					Addrows.click();
					rows++;
					}
					else
					{
						continue;
					}*/
					
					
					try
					{
						WebElement outcomeEB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
						TestUtil.VisibleOn(driver, outcomeEB, 30);
						Select OutcomeE = new Select(outcomeEB);
						OutcomeE.selectByVisibleText("Ectopic");
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					
					WebElement yearE = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearE, 30);
					}
					catch(TimeoutException e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select yearE1 = new Select(yearE);
					try 
					{
						Thread.sleep(3000);
					} 
					catch (InterruptedException e) 
					{
						System.out.println("The InterruptedException is occured");
					}
					// yearE1.selectByIndex(10);
					
					try
					{
						 WebElement gestationEB = driver.findElement(By.xpath("//th[text()='Gestation Weeks']//following::select[2]"));
						TestUtil.VisibleOn(driver, gestationEB, 30);
						Select GestationE = new Select(gestationEB);
						GestationE.selectByVisibleText("10");
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					
					row1++;
					System.out.println("Ectopic entries are completed");
					break;
				case "Abortion":
					/*if(rows<2)
					{
					Addrows.click();
					rows++;
					}
					else
					{
						continue;
					}*/
					WebElement OutcomeAB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
						TestUtil.VisibleOn(driver, OutcomeAB, 30);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select OutcomeA = new Select(OutcomeAB);
					OutcomeA.selectByVisibleText("Abortion");
					WebElement yearA = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearA, 30);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select yearA1 = new Select(yearA);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) 
					{
						System.out.println("The InterruptedException is occured");
					
					}
					yearA1.selectByVisibleText("2018");
					WebElement GenderAB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[4]"));
					try
					{
						TestUtil.VisibleOn(driver, GenderAB, 30);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select GenderObortion = new Select(GenderAB);
					GenderObortion.selectByVisibleText("Female");
					WebElement gestationA =driver.findElement(By.xpath("//th[text()='Gestation Weeks']//following::select[2]"));
					try
					{
						TestUtil.VisibleOn(driver, gestationA, 30);
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					Select GestationA = new Select(gestationA);
					GestationA.selectByVisibleText("10");
					WebElement Dateinput = driver.findElement(By.xpath("//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//following-sibling::input[@id='DateOfAbortion']"));
					Dateinput.clear();
					 WebElement Calender=  driver.findElement(By.xpath("//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//following-sibling::span[@class='input-group-addon']/i"));
					 boolean flag= false;
					 Calender.click();
						String currentdate= TestUtil.Date();
						String arr[] = currentdate.split(",");
						String day= arr[0];
						String month= arr[1];
						String Abyear= arr[2];
						
						TestUtil.ActionForMovetoElement(Dateinput);
						Dateinput.clear();
						WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
						String monthtext= Monthtextele.getText();
						String montharr[] = monthtext.split(" ");
						String Currentmonth= montharr[0];
						String Currentyear= montharr[1];
						if(Currentmonth.equals(month))
						{
							List<WebElement> Adatenodes = driver.findElements(By.xpath("//table[@class='uib-daypicker']//tbody//tr//td/button"));
							try
							{
							TestUtil.VisibleElementsOn(driver, Adatenodes, 30);
							}
							catch(Exception e)
							{
								System.out.println("TimeoutExceptionseen");
							}
							int Totalnodes= Adatenodes.size();
							for(int m=0;m<Totalnodes;m++)
							{
								String datetext = Adatenodes.get(m).getText();
								try
								{
								TestUtil.VisibleOn(driver, Adatenodes.get(m), 30);
								TestUtil.ActionForMovetoElement(Adatenodes.get(m));
								}
								catch(Exception e)
								{
									System.out.println("Exception is seen");
								}
								Actions act = new Actions(driver);
								JavascriptExecutor executor = (JavascriptExecutor) driver;
								boolean flag1= Adatenodes.get(m).isEnabled();
								if(datetext.equals(day)&& flag1==true)
								{
								executor.executeScript("arguments[0].click();", Adatenodes.get(m));	
								
								break;
									
								}
								
							}
						
						}
						else
						{
							Monthtextele.click();
							List<WebElement>Monthnodes = driver.findElements(By.xpath("//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']//div//table//tbody//td"));
							for(WebElement month1:Monthnodes)
							{
								 thismonth= month1.getText();
								boolean flag2= month1.isEnabled();
								if(thismonth.equals(month)&&flag2==true)
								{
									month1.click();
									break;
								}
								
							}
							List<WebElement> datenodes = driver.findElements(By.xpath("//table[@role='grid']//tbody//td/button"));
							try
							{
							TestUtil.VisibleElementsOn(driver, datenodes, 30);
							}
							catch(Exception e)
							{
								System.out.println("TimeoutExceptionseen");
							}
							int Totalnodes= datenodes.size();
							for(int n=0;n<Totalnodes;n++)
							{
								String date = datenodes.get(n).getText();
								
								boolean flag1= datenodes.get(n).isEnabled();
								
								if(date.equals(day)&&flag1==true&&thismonth.equals(month))
								{
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) 
								{
								System.out.println("InterruptedException is seen");
								}
								flag=datenodes.get(n).isEnabled();
								datenodes.get(n).click();
								break;
								}
									
							}
							
						
						}
					
					row1++;
					System.out.println("Abortion entries are completed");
					break;
				case "Still Born":
					/*if(rows<3)
					{
					Addrows.click();
					rows++;
					}
					else
					{
						continue;
					}*/
					
					try
					{
					WebElement OutcomeSB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					TestUtil.VisibleOn(driver, OutcomeSB, 30);
					Select OutcomeSB1 = new Select(OutcomeSB);
					OutcomeSB1.selectByVisibleText("Still Born");
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexceptionseen");
					}
					
					WebElement yearSB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearSB, 30);
					}
					catch(Exception e)
					{
						System.out.println("TimeoutException seen");
					}
					Select yearSB1 = new Select(yearSB);
					try 
					{
						Thread.sleep(2000);
					} 
					catch (InterruptedException e)
					{
						System.out.println("The InterruptedException is occured");
					}
					
					try
					{
						 WebElement GenderSB = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//td//select)[4]"));
						TestUtil.VisibleOn(driver, GenderSB, 30);
						Select GenderStillborn = new Select(GenderSB);
						GenderStillborn.selectByVisibleText("Male");
						yearSB1.selectByVisibleText("2018");
					}
					catch(Exception e)
					{
						System.out.println("Timeoutexception seen");
					}
					
					try
					{
					WebElement GenderSB = driver.findElement(By.xpath("//th[text()='Gestation Weeks']//following::select[2]"));
					TestUtil.VisibleOn(driver, GenderSB, 30);
					Select GestationSB = new Select(GenderSB);
					GestationSB.selectByVisibleText("10");
					}
					catch(Exception e)
					{
					System.out.println("Timeout exxecption seen");	
					}
					
					row1++;
					System.out.println("Still Born entries are completed");
					break;

				case "Miscarriage":
					/*if(rows<4)
					{
					Addrows.click();
					rows++;
					}
					else
					{
						continue;
					}*/
					WebElement OutcomeMC = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[" + row1 + "]//select)[3]"));
					try
					{
						TestUtil.VisibleOn(driver, OutcomeMC, 30);
					}
					catch(Exception e)
					{
						System.out.println("Timeout exception seen");
					}
					Select OutcomeMC1 = new Select(OutcomeMC);
					OutcomeMC1.selectByVisibleText("Miscarriage");
					WebElement yearMC = driver.findElement(By.xpath("(//table[@id='ObstetricHistory']/tbody/tr[3]//select)[1]"));
					try
					{
						TestUtil.VisibleOn(driver, yearMC, 30);
					}
					catch(Exception e)
					{
						System.out.println("TimeoutException seen");
					}
					Select yearMC1 = new Select(yearMC);
					try 
					{
						Thread.sleep(2000);
					} catch (InterruptedException e) 
					{
						System.out.println("The InterruptedException is occured");
					}
					yearMC1.selectByVisibleText("2000");
					WebElement gestationMC = driver.findElement(By.xpath(("//th[text()='Gestation Weeks']//following::select[2]")));
					try
					{
						TestUtil.VisibleOn(driver, gestationMC, 30);
					}
					catch(TestException e)
					{
						System.out.println("Timeout exception seen");
					}
					Select GestationMC = new Select(gestationMC);
					GestationMC.selectByVisibleText("30");
					//Delete.click();
					System.out.println("Miscarriage entries are completed");
					break;

				}// switch
				birthoptions++;
			} // outcomefor
		} // rowsfor
		/*if (Save.isDisplayed()) 
		{
			Save.click();
			System.out.println("Save is completed");

		} else {
			System.out.println("Save is not completed");
		}*/
		/*String count = NewRowcount.getText();
		while (true) {
			try {
				int Rowscount1 = Integer.parseInt(count);
				break;

			}

			catch (NumberFormatException e) 
			{
				System.out.println("String is not convertedinto number");
				rowcount1 = 5;

			} finally 
			{
				rowcount = rowcount1;
				return rowcount;
			}*/

		

	}// main
	
	
	
	
		
	

	public boolean CalenderEnableCondition() 
	{
		WebElement Calender = driver.findElement(By.xpath("(//th[text()='Date']//following::i)[1]"));
		try
		{
			TestUtil.VisibleOn(driver, Calender, 30);
		}
		catch(TestException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Calender.click();
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr//td"));
		try
		{
		TestUtil.VisibleElementsOn(driver, Dates, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeout exception seen");
		}
		int Totaldates = Dates.size();
		for (int j = 0; j < Totaldates; j++) 
		{
			String Date = Dates.get(j).getText();
			if (Date.equals("14"))
			{
				Dates.get(j).click();
			}

		}
		return false;
	}

	public boolean BirthWeightEnabled() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		 try
		 {
			 TestUtil.VisibleOn(driver, Outcome, 30);
		 }
		 catch( TimeoutException e)
		 {
			 System.out.println("Element- Outcome is not seen wihin 30 sec");
		 }
		 
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Birthweight.isDisplayed();
		return true;
	}

	public double BirthWeightText() 
	{		
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
		TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoit exception is seen ");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Birthweight.clear();
		Birthweight.sendKeys("1.234");
		String value = Birthweight.getAttribute("value");
		double val = Double.parseDouble(value);

		return val;

	}

	public boolean OutcomeEnable() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Outcome.isDisplayed();
		return true;
	}

	public String OutcomeIsLiveBirth() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		String count = LiveBirth.getAttribute("value");
		reader.setCellData("ObstetricHistory", "count", 4, count);

		return count;

	}

	public String AbortionOptionValue() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeout exception is seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Abortion");
		String count = Abortion.getAttribute("value");
		reader.setCellData("ObstetricHistory", "count", 2, count);
		return count;

	}

	public String EctopicOptionValue() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Ectopic");
		String count = Ectopic.getAttribute("value");
		reader.setCellData("ObstetricHistory", "count", 3, count);
		return count;
	}

	public boolean DileveryTypeEnabledcondition() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		DeliveryType.isDisplayed();
		return true;

	}

	public boolean RowGridEnableConditition() 
	{
		NewRowcount.isDisplayed();
		return false;

	}

	public boolean StillbornGridEnableConditition() 
	{
		StillBorn.isDisplayed();
		return false;
	}

	public boolean LivebirthEnableConditition() 
	{
		LiveBirth.isDisplayed();
		return false;
	}

	public boolean EctopiccEnableConditition() 
	{
		Ectopic.isDisplayed();
		return false;
	}

	public boolean AbortionEnableConditition() 
	{
		Abortion.isDisplayed();
		return false;
	}

	public boolean DeliveroptionEnableConditition() 
	{

		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Delivery.isDisplayed();
		return true;
	}

	public boolean ComplicationsEnableConditition() 
	{
		Delivery.isDisplayed();
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Complications.isDisplayed();
		return true;
	}

	public boolean CongenitalAnamolyEnableCondition() 
	{
		WebElement Outcome = driver.findElement(By.xpath("//th[text()='Outcome']//following::select[3]"));
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(Outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		CongenitalAnamoly.isDisplayed();
		return true;
	}

	public String LiveBirthPretermcondition() 
	{
		Select Deliveryvalue1 = new Select(Delivery);
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Select GestationPre = new Select(Gestation);
		GestationPre.selectByVisibleText("35");
		WebElement deliveryoption = Deliveryvalue1.getFirstSelectedOption();
		String Deliveryvalue = deliveryoption.getText();

		return Deliveryvalue;

	}

	public String LiveBirthFullTermcondition() 
	{
		Select Deliveryvalue1 = new Select(Delivery);
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Select Gestationfull = new Select(Gestation);
		Gestationfull.selectByVisibleText("42");
		WebElement deliveryoption = Deliveryvalue1.getFirstSelectedOption();
		String Deliveryvalue = deliveryoption.getText();

		return Deliveryvalue;

	}

	public String LiveBirthAbovePostTermcondition() 
	{
		Select Deliveryvalue1 = new Select(Delivery);
		try
		{
			TestUtil.VisibleOn(driver, Outcome, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeoutexception seen");
		}
		Select Outcomelist = new Select(outcome);
		Outcomelist.selectByVisibleText("Livebirth");
		Select Gestationpost = new Select(Gestation);
		Gestationpost.selectByVisibleText(">42");
		WebElement deliveryoption = Deliveryvalue1.getFirstSelectedOption();
		String Deliveryvalue = deliveryoption.getText();

		return Deliveryvalue;

	}

	/*
	 * public String RemarkText() { WebElement remark=
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "//th[text()='Remark']//following::input[3]"))); remark.sendKeys(
	 * "BuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bABuH1sXiBsrRarmbvj0bA"
	 * ); TestUtil.VisibleOn(driver, remark, 40); String Remarkvalue=
	 * remark.getAttribute("value"); return Remarkvalue; }
	 */

}
