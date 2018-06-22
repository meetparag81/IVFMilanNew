package com_Milan_Test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_milan_POM.AddictionsPage;
import com_milan_POM.AllergiesPage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.FamilyHistoryPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.ObstetricHistoryPage;
import com_milan_POM.SexualHistoryPage;
import com_milan_POM.SurgicalHistoryPage;
import com_milan_POM.VaccinationPage;
import com_milan_POM.WomenHistoryPage;
import com_milan_POM.WPastMedicationHistoryPage;
import com_milan_POM.previousTreatmentHistoryPage;
import com_milan_POM.socialHistoryPage;
import com_milan_POM.SearchPage;

public class WomenHistoryPageTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	FamilyHistoryPage FHP;
	SexualHistoryPage SHP;
	SurgicalHistoryPage SurgicalPage;
	previousTreatmentHistoryPage PTHP;
	WPastMedicationHistoryPage PMH;
	AllergiesPage Allergies;
	AddictionsPage Addictions;
	VaccinationPage Vaccination;
	socialHistoryPage socialHistory;
	SearchPage SearchPage;
	ObstetricHistoryPage OHP;
	
	public WomenHistoryPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		//EMRPage= HomePage.ClickonEMR();
		//EMRPage= HomePage.SearchusingCalender();
		EMRPage= HomePage.searchPaient();
		WHP= EMRPage.clickOnWomenField();	
	}
	
	@Test(priority=1)
	public void SexualHistoryTest() 
	{
		SHP= WHP.ClickonSexsuslHistory();
	}
	
	@Test(priority=2)
	public void ObstetricHistoryTest() 
	{
		OHP= WHP.ClickonObstetricHistory();
	}
	@Test(priority=3)
	public void MedicalHistoryTest() throws Throwable
	{
		WHP.ClickonMedicalHistory();
	}
	
	@Test(priority=4)
	public void FamilyHistoryTest () 
	{
		WHP.ClicOnFamilyHistory();
	}
	
	@Test(priority=5)
	public void SurgicalHistoryTest () 
	{
		WHP.ClickOnSurgicalHistory();
	}
	
	@Test(priority=6)
	public void PreviousTreatmentHistoryTest() 
	{
		PTHP= WHP.ClickOnpreviousTreatmentHistory();
	}
	@Test(priority=7)
	public void pastMedicationHistoryTest() 
	{
		PMH= WHP.ClickOnpastMedicationHistory();
	}
	
	@Test(priority=8)
	public void AllergiesTest() 
	{
		Allergies= WHP.ClickOnAllergies();
	}
	
	@Test(priority=9)
	public void AddictionsTest() 
	{
		Addictions= WHP.ClickOnAddictions();
	}
	@Test(priority=9)
	public void VaccinationTest() throws Exception
	{
		Vaccination = WHP.ClickOnVaccination();
	}
	
	@Test(priority=10)
	public void socialHistoryTest() 
	{
		socialHistory = WHP.ClickOnsocialHistory();
	}
	
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
