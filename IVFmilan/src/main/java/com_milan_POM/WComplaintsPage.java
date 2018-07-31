package com_milan_POM;

import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class WComplaintsPage extends TestBase {
	private @FindBy(xpath = "//span[@class='multiSelect inlineBlock']/button") WebElement Buttoncomplaints;
	@FindBy(xpath = "//div[@class='checkboxLayer show']/div[2]")
	WebElement PresentingComplaints;
	@FindBy(xpath = "//div[@id='toasty']")
	WebElement FlashMessage;
	@FindBy(xpath = "//textarea[@name='FollowUpNotes']")
	WebElement FollowupNotes;
	@FindBy(xpath = "//textarea[@name='Reason']")
	WebElement FollowUpReason;
	@FindBy(xpath = "//button[@class='btn btn-primary ng-binding']")
	WebElement Save;
	@FindBy(xpath = "//label [@class='col-sm-12 col-md-12 col-lg-12 control-label']//following::i")
	WebElement calender;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")
	WebElement Updateflash;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")
	WebElement SaveFash;
	@FindBy(xpath = "//label[contains(text(),'Next Follow Up')]//following-sibling::div//input")WebElement Inputcalender;
	List<WebElement> Rows = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
	int i;
	int j;
	int count = 0;
	String msg;

	WComplaintsPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public boolean complaints() 
	{
		boolean flag = false;
		List<WebElement> complaintRows = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
		int NoofRows = complaintRows.size();
		String followup = FollowUpReason.getAttribute("value");
		String FollowupNotes1 = FollowupNotes.getAttribute("value");

		if (NoofRows == 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	public int AddPatientComplaints() {
		List<WebElement> complaintRows = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
		int NoofRows = complaintRows.size();
		if (NoofRows == 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				System.out.println("The InterruptedException is occured");
			}
			try {
				WebElement ele = Buttoncomplaints;
				Buttoncomplaints.isEnabled();
			} catch (Exception e) {
				System.out.println("Buttoncomplaints- button is not visible");

			}
			Buttoncomplaints.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("The InterruptedException is occured");
			}
			List<WebElement> complaints = driver.findElements(By.xpath("//div[@class='checkBoxContainer']/div"));
			for (WebElement comp : complaints) {
				comp.click();
				count++;
				if (count == 4) {
					System.out.println("count is" + count);
					break;

				}
			}
		} else {
			System.out.println("Patient has existing complaints");
		}

		return count;

	}

	public String ExistingPatientPresentingComplaints() {
		List<WebElement> Rows = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
		List<WebElement> complaints = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr/td[2]"));
		int NoofRows = Rows.size();
		if (NoofRows > 0) {
			// AddPatientComplaints();
			for (int k = 1; k <= 4; k++) {
				int SRNO = k;
				switch (SRNO) {
				case (1):
					WebElement Onset1 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsetone = new Select(Onset1);
					Onsetone.selectByVisibleText("Sudden");
					WebElement DurationDay1 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[1]"));
					Select DurationDayone = new Select(DurationDay1);
					DurationDayone.selectByVisibleText("10");
					WebElement DurationMonth1 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonthone = new Select(DurationMonth1);
					DurationMonthone.selectByVisibleText("2");
					WebElement DurationYear1 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYearone = new Select(DurationYear1);
					DurationYearone.selectByVisibleText("5");
					WebElement Modailty = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval = new Select(Modailty);
					Modailtyval.selectByVisibleText("Decreased");
					break;

				case (2):

					WebElement Onset2 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsettwo = new Select(Onset2);
					Onsettwo.selectByVisibleText("Gradual");
					WebElement DurationDay2 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[1]"));
					Select DurationDaytwo = new Select(DurationDay2);
					DurationDaytwo.selectByVisibleText("10");
					WebElement DurationMonth2 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonthtwo = new Select(DurationMonth2);
					DurationMonthtwo.selectByVisibleText("2");
					WebElement DurationYear2 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYeartwo = new Select(DurationYear2);
					DurationYeartwo.selectByVisibleText("6");
					WebElement Modailty2 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval2 = new Select(Modailty2);
					Modailtyval2.selectByVisibleText("Decreased");
					break;

				case (3):
					WebElement Onset3 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsetthree = new Select(Onset3);
					Onsetthree.selectByVisibleText("Sudden");
					WebElement DurationDay3 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[5]//select[1]"));
					Select DurationDaythree = new Select(DurationDay3);
					DurationDaythree.selectByVisibleText("23");
					WebElement DurationMonth3 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonththree = new Select(DurationMonth3);
					DurationMonththree.selectByVisibleText("2");
					WebElement DurationYear3 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYearthree = new Select(DurationYear3);
					DurationYearthree.selectByVisibleText("6");
					WebElement Modailty3 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval3 = new Select(Modailty3);
					Modailtyval3.selectByVisibleText("Decreased");
					break;

				case (4):

					WebElement Onset4 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsetfour = new Select(Onset4);
					Onsetfour.selectByVisibleText("Sudden");
					WebElement DurationDay4 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[5]//select[1]"));
					Select DurationDayfour = new Select(DurationDay4);
					DurationDayfour.selectByVisibleText("29");
					WebElement DurationMonth4 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonthfour = new Select(DurationMonth4);
					DurationMonthfour.selectByVisibleText("2");
					WebElement DurationYear4 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYearfour = new Select(DurationYear4);
					DurationYearfour.selectByVisibleText("6");
					WebElement Modailty4 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval4 = new Select(Modailty4);
					Modailtyval4.selectByVisibleText("Decreased");
					break;

				}
			}
		}
		try {
			TestUtil.VisibleOn(driver, FollowUpReason, 20);
		} catch (TimeoutException e) {
			System.out.println("FollowUpReason is not seen within 20 seconds");
		}
		FollowUpReason.clear();
		FollowUpReason.sendKeys(
				"b18AxXqMeOtJgPwWCJALHauhJlcnX9Zi1hmHl3QQS1eWEriLqjBW58N2s5r7qS5ZdsdbJEXXboiPMNmh7DxCblhSCaUasVr1yzgYjOt0pgRWKP4kAPrO7Dsv4JJGqJjXOPWg9fOj4pWmbgcRdHxAam9H8nBHbuDsS4FyryDhoYubkCVRAs90YxmCnXkKXtjDfWcRErPVyW5Al5Zy5jEbmkCqPkYXjXSrLZyjSmV9DbUiXRNcuGw9oGRx2P");
		try {
			TestUtil.VisibleOn(driver, FollowupNotes, 20);
		} catch (Exception e) {
			System.out.println("TimeoutExceptionseen");
		}
		FollowupNotes.sendKeys(
				"b18AxXqMeOtJgPwWCJALHauhJlcnX9Zi1hmHl3QQS1eWEriLqjBW58N2s5r7qS5ZdsdbJEXXboiPMNmh7DxCblhSCaUasVr1yzgYjOt0pgRWKP4kAPrO7Dsv4JJGqJjXOPWg9fOj4pWmbgcRdHxAam9H8nBHbuDsS4FyryDhoYubkCVRAs90YxmCnXkKXtjDfWcRErPVyW5Al5Zy5jEbmkCqPkYXjXSrLZyjSmV9DbUiXRNcuGw9oGRx2P");
		Save.click();
		return msg = Updateflash.getText();

	}

	public int NumberOfComplaints() {

		Buttoncomplaints.click();
		complaints();
		List<WebElement> complaints = driver.findElements(By.xpath("//div[@class='checkBoxContainer']//div"));
		int complaintsnamessize = complaints.size();
		return complaintsnamessize;
	}

	public String SaveTheComplaints() {
		List<WebElement> Rows = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tr/td[3]"));
		List<WebElement> complaints = driver
				.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody/tr/td[2]"));
		int NoofRows = Rows.size();
		if (NoofRows <= 0) {
			AddPatientComplaints();
			for (int k = 1; k <= 4; k++) {
				int SRNO = k;
				switch (SRNO) {
				case (1):
					WebElement Onset1 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsetone = new Select(Onset1);
					Onsetone.selectByVisibleText("Gradual");
					WebElement DurationDay1 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[1]"));
					Select DurationDayone = new Select(DurationDay1);
					DurationDayone.selectByVisibleText("10");
					WebElement DurationMonth1 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonthone = new Select(DurationMonth1);
					DurationMonthone.selectByVisibleText("2");
					WebElement DurationYear1 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYearone = new Select(DurationYear1);
					DurationYearone.selectByVisibleText("5");
					WebElement Modailty = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval = new Select(Modailty);
					Modailtyval.selectByVisibleText("Stable");

					break;

				case (2):

					WebElement Onset2 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsettwo = new Select(Onset2);
					Onsettwo.selectByVisibleText("Gradual");
					WebElement DurationDay2 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[1]"));
					Select DurationDaytwo = new Select(DurationDay2);
					DurationDaytwo.selectByVisibleText("10");
					WebElement DurationMonth2 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonthtwo = new Select(DurationMonth2);
					DurationMonthtwo.selectByVisibleText("2");
					WebElement DurationYear2 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYeartwo = new Select(DurationYear2);
					DurationYeartwo.selectByVisibleText("6");
					WebElement Modailty2 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval2 = new Select(Modailty2);
					Modailtyval2.selectByVisibleText("Decreased");
					break;

				case (3):
					WebElement Onset3 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsetthree = new Select(Onset3);
					Onsetthree.selectByVisibleText("Gradual");
					WebElement DurationDay3 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[5]//select[1]"));
					Select DurationDaythree = new Select(DurationDay3);
					DurationDaythree.selectByVisibleText("23");
					WebElement DurationMonth3 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonththree = new Select(DurationMonth3);
					DurationMonththree.selectByVisibleText("2");
					WebElement DurationYear3 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYearthree = new Select(DurationYear3);
					DurationYearthree.selectByVisibleText("6");
					WebElement Modailty3 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval3 = new Select(Modailty3);
					Modailtyval3.selectByVisibleText("Increased");
					break;

				case (4):

					WebElement Onset4 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[4]/select"));
					Select Onsetfour = new Select(Onset4);
					Onsetfour.selectByVisibleText("Sudden");
					WebElement DurationDay4 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]/td[5]//select[1]"));
					Select DurationDayfour = new Select(DurationDay4);
					DurationDayfour.selectByVisibleText("29");
					WebElement DurationMonth4 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[2]"));
					Select DurationMonthfour = new Select(DurationMonth4);
					DurationMonthfour.selectByVisibleText("2");
					WebElement DurationYear4 = driver
							.findElement(By.xpath("(//table[@class='table table-hover table-striped']//tbody/tr[" + k
									+ "]/td[5]//select)[3]"));
					Select DurationYearfour = new Select(DurationYear4);
					DurationYearfour.selectByVisibleText("6");
					WebElement Modailty4 = driver.findElement(By.xpath(
							"//table[@class='table table-hover table-striped']//tbody/tr[" + k + "]//td[6]/select"));
					Select Modailtyval4 = new Select(Modailty4);
					Modailtyval4.selectByVisibleText("Irregular");
					break;

				}
			}

			try
			{
				TestUtil.VisibleOn(driver, FollowUpReason, 20);
			}

			catch (TimeoutException e)
			{
				System.out.println("FollowUpReason is not seen within 20 seconds");
			}
			FollowUpReason.clear();
			FollowUpReason.sendKeys(
					"b18AxXqMeOtJgPwWCJALHauhJlcnX9Zi1hmHl3QQS1eWEriLqjBW58N2s5r7qS5ZdsdbJEXXboiPMNmh7DxCblhSCaUasVr1yzgYjOt0pgRWKP4kAPrO7Dsv4JJGqJjXOPWg9fOj4pWmbgcRdHxAam9H8nBHbuDsS4FyryDhoYubkCVRAs90YxmCnXkKXtjDfWcRErPVyW5Al5Zy5jEbmkCqPkYXjXSrLZyjSmV9DbUiXRNcuGw9oGRx2P");

			FollowupNotes.clear();
			try {
				TestUtil.VisibleOn(driver, FollowupNotes, 20);
			} catch (TimeoutException e) {
				System.out.println("TimeoutException seen");
			}
			FollowupNotes.sendKeys(
					"b18AxXqMeOtJgPwWCJALHauhJlcnX9Zi1hmHl3QQS1eWEriLqjBW58N2s5r7qS5ZdsdbJEXXboiPMNmh7DxCblhSCaUasVr1yzgYjOt0pgRWKP4kAPrO7Dsv4JJGqJjXOPWg9fOj4pWmbgcRdHxAam9H8nBHbuDsS4FyryDhoYubkCVRAs90YxmCnXkKXtjDfWcRErPVyW5Al5Zy5jEbmkCqPkYXjXSrLZyjSmV9DbUiXRNcuGw9oGRx2P");
			Save.click();
			// System.out.println(FlashMessage.getText());
			msg = SaveFash.getText();
		} else {
			ExistingPatientPresentingComplaints();
		}

		return msg;

	}

	public String MessageforPaitent()
	{

		if (complaints() == true) 
		{
			msg = SaveFash.getText();
		} else 
		{
			msg = Updateflash.getText();
		}

		return msg;

	}

	public String LMPDate() 
	{
		int count = 0;
		int count1 = count - 1;

		try {
			TestUtil.VisibleOn(driver, calender, 20);
		} catch (TimeoutException e) {
			System.out.println("Element is not seen within time");
			throw (e);
		}
		calender.click();
		List<WebElement> Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
		boolean flag = true;
		for (int l = 0; l < Dates.size(); l++) 
		{

			count1++;
			if (flag == false) 
			{
				break;
			}

			String firstdate = Dates.get(l).getText();

			if (firstdate.equals("01")) 
			{

				for (int i = count1; i < Dates.size(); i++) 
				{

					String Datetext = Dates.get(i).getText();
					WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
					String text = Monthtextele.getText();
					String Arr[] = text.split(" ");
					String Monthtext = Arr[0];

					String CyrrentDate = TestUtil.Date();
					String[] Arr1 = CyrrentDate.split(",");
					String day = Arr1[0];
					String Month = Arr1[1];

					boolean flag1 = Dates.get(i).isEnabled();

					if (Datetext.equals(day) && flag1 == true && Monthtext.equals(Month)) 
					{
						Dates.get(i).click();
						try {
							TestUtil.VisibleOn(driver, Inputcalender, 30);
							TestUtil.ActionForMovetoElement(Inputcalender);

						} 
						catch (Exception e) 
						{
							System.out.println("Element- Inputcalender is snot seen with in 30 sec");

						}
						flag = false;
						msg = Inputcalender.getAttribute("value");
						break;
					}
					
					

				}
			}
		}
		return msg;

	}

	public boolean NextFollowUp()
		{
			String Date = LMPDate();
				
				String CurrentDate=TestUtil.DateForCompare();
				
				boolean flag= false;
				if(CurrentDate.equals(Date))
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			
						
				{

			return flag;
				}
		}
}
