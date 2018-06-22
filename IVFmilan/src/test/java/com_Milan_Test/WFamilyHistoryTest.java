package com_Milan_Test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.FamilyHistoryPage;
import com_milan_POM.HomePage;
import com_milan_POM.Loginpage;
import com_milan_POM.SexualHistoryPage;
import com_milan_POM.SurgicalHistoryPage;
import com_milan_POM.WomenHistoryPage;

public class WFamilyHistoryTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	FamilyHistoryPage FHP;
	SexualHistoryPage SHP;
	SurgicalHistoryPage SurgicalPage;

	public WFamilyHistoryTest()
	{
		super();
	}
	
	@ BeforeMethod
	public void Seup() 
		{
			TestBase.initalization();
			Loginpage= new Loginpage();
			HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
			EMRPage= HomePage.searchPaient();
			//EMRPage= HomePage.ClickonEMR();
			WHP= EMRPage.clickOnWomenField();	
		}
}
