package com_milan_POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class WomenHistoryPage extends TestBase
{
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[1]/a")WebElement MenstrualHistory;
	@FindBy(xpath= "//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[2]/a")WebElement SexualHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[3]/a")WebElement ObstetricHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[4]/a")WebElement medicalHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[5]/a")WebElement familyHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[6]/a")WebElement SurgicalHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[7]/a")WebElement previousTreatmentHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[8]/a")WebElement pastMedicationHistory;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[9]/a")WebElement allergies;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[10]/a")WebElement addictions;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[11]/a")WebElement Vaccination;
	@FindBy(xpath="//main[@id='wrapper']/section/div/section/div[1]/form/div/div[1]/div/div[2]/div[1]//li[12]/a")WebElement socialHistory;
	
	
	 
	public WomenHistoryPage()  
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public SexualHistoryPage ClickonSexsuslHistory() 
	{
		try
		{
		TestUtil.VisibleOn(driver, SexualHistory, 30);
		}
		catch(Exception e)
		{
			System.out.println("Element-SexualHistory is not displayed within 30 sec");
		}
		SexualHistory.click();
		System.out.println("clicked on Sexual history");
		
		 return  new SexualHistoryPage();
			 	
			 		
	}
		 public ObstetricHistoryPage ClickonObstetricHistory() 
			{
			 try
			 {
			 TestUtil.VisibleOn(driver, ObstetricHistory, 30);
			 TestUtil.ActionForMovetoElement(ObstetricHistory);
			 }
			 catch(Exception e)
			 {
				 System.out.println("element is not visible withinthe time period");
				 
			 }
			 ObstetricHistory.click();
			 
			 return  new ObstetricHistoryPage();
		 
			}
		 public  MedicalHistoryPage ClickonMedicalHistory() 
			{
			try
			 {
				 TestUtil.VisibleOn(driver, medicalHistory, 20); 
			 }
			 catch(TimeoutException e)
			 {
				 System.out.println("Element-medicalHistory is not seen within 20 sec");
			 }
			 
			 medicalHistory.click();
			 System.out.println("clicked on MedicalHistory");
			 
				
				return new MedicalHistoryPage() ;
				   
		 
				 
	
			}
		 
		 public FamilyHistoryPage ClicOnFamilyHistory() 
			{
			 try
			 {
				 TestUtil.VisibleOn(driver, familyHistory, 20);
			 }
			 catch(TimeoutException e)
			 {
				 System.out.println("Element-familyHistory is not seen with in20 sec");
			 }
			 
			 familyHistory.click();
			 System.out.println("clicked on FamilyHistory");
			 return  new FamilyHistoryPage();

			}


		public  SurgicalHistoryPage ClickOnSurgicalHistory()  
		{
			
			try
			{
				TestUtil.VisibleOn(driver, SurgicalHistory, 20);
			}
			catch(org.openqa.selenium.TimeoutException e)
			{
				System.out.println("Element-SurgicalHistory is not seen within 20 sec");
			}
			
			SurgicalHistory.click();
			System.out.println("clicked on SurgicalHistory");
			return new SurgicalHistoryPage();
		}
		public  previousTreatmentHistoryPage ClickOnpreviousTreatmentHistory() 
		{

			try
			{
			TestUtil.VisibleOn(driver, previousTreatmentHistory, 20);
			}
			catch(Exception e)
			{
				System.out.println("Element- previousTreatmentHistory is not seen with in 20 sec");
				
			}
			previousTreatmentHistory.click();
			System.out.println("clicked on previousTreatmentHistory");
			return new previousTreatmentHistoryPage();
			
		}
		public  WPastMedicationHistoryPage ClickOnpastMedicationHistory() 
		{
			
			try
			{
			TestUtil.VisibleOn(driver, pastMedicationHistory, 20);
			}
			catch(TimeoutException e)
			{
				System.out.println("Element- pastMedicationHistory is not seen with in 20 sec");
			}
			pastMedicationHistory.click();
			System.out.println("clicked on pastMedicationHistory");
			return new WPastMedicationHistoryPage();
			
		}
		public  AllergiesPage ClickOnAllergies() 
		{
			
			try
			{
				TestUtil.VisibleOn(driver, allergies, 30);
				TestUtil.ActionForMovetoElement(allergies);
				
			}
			catch(TimeoutException e)
			{
				System.out.println("Element- allergies is not seen with in 20 sec");
			}
			allergies.click();
			
			return new AllergiesPage();
		}
		
		public  AddictionsPage ClickOnAddictions() 
		{
		try
			{
			TestUtil.VisibleOn(driver, addictions, 30);
			TestUtil.ActionForMovetoElement(addictions);
			addictions.click();
			}
			catch(Exception e)
			{
				System.out.println("Element-addictions not seen within 20 sec");
				
			}
//			System.out.println("clicked on Addictions");
			return new AddictionsPage();
				
			}
		
		public  VaccinationPage ClickOnVaccination() 
		{
		//	System.out.println("========Vaccination click testcase started======");
			try
			{
				TestUtil.VisibleOn(driver, Vaccination, 20);
			}
			catch(TimeoutException e)
			{
				System.out.println("Element-Vaccination is not seen within 20 sec");
			}
			Vaccination.click();
		//	System.out.println("clicked on Vaccination");
			return new VaccinationPage();
			
		}
		public  socialHistoryPage ClickOnsocialHistory() 
		{
			System.out.println("========Vaccination click testcase started======");
			try
			{
				TestUtil.VisibleOn(driver, socialHistory, 20);
			}
			catch(TimeoutException e)
			{
				System.out.println("Element-Vaccination is not seen within 20 sec");
			}
			socialHistory.click();
			System.out.println("clicked on socialHistoryPage");
			return new socialHistoryPage();
		}
		
		public  MenstrualHistoryPage ClickOnMenstrualHistory() 
		{
			//System.out.println("========MenstrualHistory click testcase started======");
			try
			{
				TestUtil.VisibleOn(driver, MenstrualHistory, 30);
				TestUtil.ActionForMovetoElement(MenstrualHistory);
			}
			catch(TimeoutException e)
			{
				System.out.println("TimeoutException seen");
			}
			MenstrualHistory.click();
			//System.out.println("clicked on MenstrualHistoryPage");
			return new MenstrualHistoryPage();
	
}
}
