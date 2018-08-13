package com_milan_POM;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class SiemenProcessingPage extends TestBase {
	@FindBy(xpath = "//a[contains (text(),'Preliminary Details')]")
	WebElement PreliminaryDetails;
	@FindBy(xpath = "//a[contains (text(),'Preliminary Details')]")
	WebElement PreparationAssessment;
	@FindBy(xpath = "//label[contains (text(), 'Type of Sperm')]//following-sibling::div/select")
	WebElement TypeofspermFrom;
	@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 col-lg-5']/button)[1]")
	WebElement Spermiogram;
	@FindBy(xpath = "//table[@id='profile_table']//tr[5]/td[2]")
	WebElement Progressiveperc;
	@FindBy(xpath = "//table[@id='profile_table']//tr[8]/td[2]")
	WebElement nonProgressiveperc;
	@FindBy(xpath = "//span[@class='toast-msg ng-binding ng-scope']")
	WebElement flashmessage;
	@FindBy(xpath = "//label[contains (text(), 'Method of Semen Collection')]//following-sibling::div/select[1]")
	WebElement MethodofSemenCollection;
	@FindBy(xpath = "//label[contains (text(),'Done By')]//following-sibling::div/select")
	WebElement DoneBy;
	@FindBy(xpath = "//label[contains (text(),'Witnessed By')]//following-sibling::div/select")
	WebElement WitnessBy;
	@FindBy(xpath = "//label[contains (text(), 'Semen Preparation Method')]//following::select[1]")
	WebElement SiemenPreperationMethod;
	@FindBy(xpath = "//a[contains (text(), 'Semen Preparation Details')]")WebElement SemenPreparationDetails;
	@FindBy(xpath="//label[contains (text(),  'Semen Preparation Method')]//following-sibling::div/select")WebElement SemenPreparationMethod; 
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	String msg;
	private String value;
	private int val;

	public SiemenProcessingPage() 
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public void ClickOnPreliminaryDetails() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, PreliminaryDetails, 30);
			TestUtil.ActionForMovetoElement(PreliminaryDetails);
		} 
		catch (Exception e) 
		{
			System.out.println("Element- PreliminaryDetails is not seen with in 30 sec");

		}
		PreliminaryDetails.click();
		TypeOfSperm();
		MethodofSemenCollection();
		DoctorAndWitnessBy();

	}

	public void DoctorAndWitnessBy() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, DoneBy, 30);
			TestUtil.ActionForMovetoElement(DoneBy);
		} 
		catch (Exception e) 
		{
			System.out.println("Element-DoneBy is not seen wirth in 30 sec");
		}
		Select done = new Select(DoneBy);
		done.selectByIndex(2);
		try 
		{
			TestUtil.VisibleOn(driver, WitnessBy, 30);
			TestUtil.ActionForMovetoElement(WitnessBy);
		} 
		catch (Exception e) 
		{
			System.out.println("Element- WitnessBy is not seen within 30 sec");
		}
		Select witness = new Select(WitnessBy);
		witness.selectByIndex(3);

	}

	public void TypeOfSperm() 
	{

		try 
		{
			TestUtil.VisibleOn(driver, TypeofspermFrom, 30);
		} 
		catch (Exception e) 
		{
			System.out.println("Element- Typeofsperm is not seen with in 30 sec");
		}
		Select Typeofsperm1 = new Select(TypeofspermFrom);
		Typeofsperm1.selectByVisibleText("Fresh");

	}

	public void MethodofSemenCollection() 
	{
		Select sel = new Select(MethodofSemenCollection);
		sel.selectByVisibleText("Ejaculation");

	}

	public void ClickOnSemenPreparationDetails() 
	{
		try 
		{
			TestUtil.VisibleOn(driver, SemenPreparationDetails, 30);
			TestUtil.ActionForMovetoElement(SemenPreparationDetails);

		} 
		catch (Exception e) 
		{
			System.out.println("Element-SemenPreparationDetails is not seen within 30 sec");
		}
		SemenPreparationDetails.click();

		try 
		{
			TestUtil.VisibleOn(driver, SiemenPreperationMethod, 30);
		} catch (Exception e) 
		{
			System.out.println("Element-SiemenPreperationMethod is not seen with in 30 sec");
		}
		Select SemenMetod = new Select(SemenPreparationMethod);
		SemenMetod.selectByVisibleText("Swim Up Technique");
		
	}

	public int Progressiveperc(String prog)
	{
		try 
		{
			TestUtil.VisibleOn(driver, Progressiveperc, 30);
			TestUtil.ActionForMovetoElement(Progressiveperc);

		}
		catch (Exception e) 
		{
			System.out.println("Element- Progressiveperc is not seen within 30 sec");
		}
		Progressiveperc.clear();
		Progressiveperc.sendKeys(prog);
		String s = Progressiveperc.getText();
		int val = Integer.parseInt(s);
		return val;

	}

	public int nonProgressive(String nonprog) 
	{
		try 
		{
			TestUtil.VisibleOn(driver, nonProgressiveperc, 30);
			TestUtil.ActionForMovetoElement(nonProgressiveperc);

		} 
		catch (Exception e) 
		{
			System.out.println("Element- nonProgressiveperc is not seen within 30 sec");
		}
		nonProgressiveperc.clear();
		nonProgressiveperc.sendKeys(nonprog);
		String s = nonProgressiveperc.getText();
		try 
		{
			val = Integer.parseInt(s);
		} 
		catch (Exception e) 
		{
			System.out.println("Numberformatexception is seen");
		}

		return val;

	}

	public boolean Percentage() 
	{
		boolean flag = false;
		float percentage = (nonProgressive(value) / Progressiveperc(value)) * 100;
		if (percentage > 100) 
		{
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;

	}

	public String MessageForPercentage() 
	{
		boolean flag1 = Percentage();
		if (flag1 == true) 
		{
			try 
			{
				TestUtil.VisibleOn(driver, flashmessage, 10);
				TestUtil.ActionForMovetoElement(flashmessage);
			} catch (Exception e) {
				System.out.println("Element-flashmessage is not seen with in 10 sec");
			}
			msg = flashmessage.getText();
			// msg = "Sum of Progressive, Non Progressive & Immotility can not
			// be more than 100.";

		} else 
		{
			return msg = "Percentage is lessthan 100";
		}
		return msg;

	}

	public String PreparationAssessment() 
	{
		Progressiveperc(value);
		nonProgressive(value);
		return msg;

	}

	public void testdata() 
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try 
		{
			reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		int rowcount = reader.getRowCount("SiemenProcessing");
		int count = rowcount;
		for (int rows = 2; rows <= count; rows++) 
		{

			String Progressive = reader.getCellData("SiemenProcessing", 0, rows);
			String NonProgressive = reader.getCellData("SiemenProcessing", 1, rows);

		}

	}
}
