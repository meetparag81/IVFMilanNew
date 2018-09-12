package com_Milan_Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_milan_POM.Loginpage;
import com_milan_POM.HomePage;
import com_milan_POM.EMRDashBoardPage;
import com_milan_POM.FemaleReportUploadPage;
//small changes
public class FemaleReportUploadPageTest extends TestBase 
{
	Loginpage LoginPage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	FemaleReportUploadPage FRP;
	static int no1=2;
	static int i = 6;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	 public FemaleReportUploadPageTest()
	 {
		 super();
	 }
	 
	 @BeforeMethod
	 public void Setup()
	 {
		 TestBase.initalization();
		 LoginPage = new Loginpage();
		 HomePage = LoginPage.Verifylogin(prop.getProperty("username"),prop.getProperty("password"));
		 EMRPage = HomePage.searchPaient();
		 EMRPage.ClickWomenField();	
		 FRP= EMRPage.ClickonReportUpload();
	 
	 }
	 
	 @Test(priority= 3,enabled=true)
	 public void FemaleReportUploadTitleTest()
	 {
		String act=  FRP.FemaleReportUploadTitle();
		String exp = "Female Report Upload";
		Assert.assertEquals(act, exp);
		System.out.println("FemaleReportUploadTitleTest is completed");
	 }
	 @Test (priority=2,enabled=true)
	 public void MessageForInvalidUploadTest() 
	 {
		 boolean flag;
		flag= FRP.MessageForInvalidUpload(); 
		Assert.assertFalse(flag);
		System.out.println("MessageForInvalidUploadTest is completed");
	 }
	 @Test(priority=1,groups = {"functional" }, enabled= true)
	 public void SelectReportCategoryOptionTest()
	 {
		 
		boolean flag= false;
		for(int j=2; j<=6;j++)
		{
			
			 
			 if(i>0)
			 {
				 flag= true;
				 FRP.SelectReportCategoryOption(no1 ); 
				 String act = FRP.FlashMessage();
				 String Exp = "Record saved successfully.";
				 Assert.assertEquals(act, Exp);
				 i--;
				 no1++;
				 System.out.println("MessageForInvalidUploadTest is completed");
				 
			 }
			 else
			 {
				 flag= false;  
			 }
			
		}
			
			 
		 
	 }
	 
	 @Test(priority=1,groups = {"functional" },dataProvider="GetTestData", enabled= true)
	 public void SelectReportCategoryOptionNewTest(String category,String Name,String no)
	 {
		 
		boolean flag= false;
		for(int j=2; j<=6;j++)
		{
			
			 
			 if(i>0)
			 {
				 flag= true;
				 FRP.SelectReportCategoryOptionNew(category,Name,no ); 
				 String act = FRP.FlashMessage();
				 String Exp = "Record saved successfully.";
				 Assert.assertEquals(act, Exp);
				 i--;
				 no1++;
				 System.out.println("MessageForInvalidUploadTest is completed");
				 
			 }
			 else
			 {
				 flag= false;  
			 }
		}
		}
	 
	 
	 
	 @DataProvider
		public  Iterator<Object[]> GetTestData()
		{
			
			ArrayList<Object[]>	FemaleReportUpload= FemaleReportUploadPage.getdatafromExcel();
		return FemaleReportUpload.iterator();
		
		}
	 
	 
	 @AfterMethod
	 public void Teardown()
	 {
		 try
		 {
		 driver.quit();
		 }
		 catch(UnreachableBrowserException e)
		 {
			 System.out.println("UnreachableBrowserException is seen");
		 }
	 }
	 
	

}
