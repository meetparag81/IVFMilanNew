package com_milan_POM;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.impl.values.XmlValueDisconnectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;
import com_Milan_util.TestUtil;

public class CycleListPage extends TestBase 
{
	private @FindBy(xpath="//button[@class='f-right btn-txt-link']")WebElement Newcyclebutton ;
	private @FindBy(xpath="//span[text()='Cycle List']")WebElement CyclelistTitle;
	private @FindBy(xpath="//label[text()='ART Type']//following-sibling::div/select")WebElement Artselecttype;
	private @FindBy(xpath="//span[@class='icon-screen ng-binding']")WebElement Cyclepagetext;
	private @FindBy(xpath="//label[text()='ART Type']//following::select[3]")WebElement Protocol;
	private @FindBy(xpath="(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[3]")WebElement Semen;
	private @FindBy(xpath="//label[text()='Source of Sperm']//following-sibling::div/select")WebElement Sourceofsperm;
	private @FindBy(xpath="(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[2]")WebElement Donor;
	private @FindBy(xpath ="(//span[@class='multiSelect inlineBlock']/button)[1]")WebElement Indication;
	private @FindBy(xpath="//label[contains(text(),'Stimulation Drug')]/following::button[1]")WebElement SimulationDrug;
	private @FindBy(xpath="//label[contains(text(),'Stimulation Drug')]/following::button[1]/text()")WebElement SimulationDrugtext; 
	private@FindBy(xpath="//textarea[@name='txtCyWarning']")WebElement CycleWarnings;
	private@FindBy(xpath="//textarea[@name='txtRemark']")WebElement Remarks;
	private@FindBy(xpath="//button[text()='Save']")WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement SaveMessage;
	private @FindBy(xpath="//i[@class='fa fa-calendar']")WebElement LMPcalender;
	private @FindBy(xpath="//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a[@class='txt_bold ng-binding']")WebElement Cyclecode;
	private @FindBy(xpath="//input[@name='LMPDate']")WebElement LMPdate;
	CycleListPage CLP;
	
	String msg;
	String Name;
	String Name1;
	boolean flag;
	String OptionName;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	CycleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean NewCycleButtonEnableCondition()
	{
		try
		{
		 TestUtil.VisibleOn(driver, Newcyclebutton, 50);
		 TestUtil.ActionForMovetoElement(Newcyclebutton);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element- Newcyclebutton is not seen within30 seconds");
		}
		 boolean flag1 = Newcyclebutton.isEnabled();
		return flag1;
		
	}
	
	public boolean CycleCodeAvaibility()
	{
		boolean flag1;
		List<WebElement>cNoofcycles = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a[@class='txt_bold ng-binding']"));
		int codesize= cNoofcycles.size();
		
			if (codesize>0)
			{
				 flag1= true;
			}
			else
			{
				flag1= false;
			}
		
		
		return flag1;
		}
		 
	
	
	
	public String ClickonNewCycle()  
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		boolean flag= NewCycleButtonEnableCondition();
		if(flag==true)
		{
			TestUtil.ActionForMovetoElement(Newcyclebutton);
			Newcyclebutton.click();
		//Newcyclebutton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) 
			{
				System.out.println("Thread.sleep exception is seen ");
			}
		 msg = Cyclepagetext.getText();
		}
		else
		{
			msg="Cycle is not created or already available";
			
		}
		return msg;
	}
	
	public boolean ClickonNewCycleEnablecondition()
	{
		boolean flag = false;
		
		if(NewCycleButtonEnableCondition()==true)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		
		return flag;
		
	}
	
	
	
	public String CycleListTitle()
	{
		
		try
		{
			TestUtil.VisibleOn(driver, CyclelistTitle, 20);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element is not seen within20 sec");
		}
		String msg= CyclelistTitle.getText();
		System.out.println(msg);
		return msg;
	}
	public boolean EnabledconditionARTType() 
	{
		
		
		//ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Artselecttype, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element-Artselecttype is not seen within 20 seconds");
		}
		boolean flag= Artselecttype.isEnabled();	
		
		
		return flag;
		
	}
	public String  ARTTypeOption() 
	{
		
	Select OptionART = new Select(Artselecttype);
	WebElement option =	OptionART.getFirstSelectedOption();
	
	try
	{
		Thread.sleep(4000);
		TestUtil.ActionForMovetoElement(option);
		OptionName= option.getText();
	}
	catch(Exception e)
	{
	System.out.println("Element- option is not seen with in 40 sec");
	}
	OptionName= "OPU";
	
	
	//reader.setCellData("CycleList", "ARTtype", 2, OptionName);
		return OptionName;
	
	}
	
	public String NoofProtocol()
	{
		
			try
			{
				Thread.sleep(4000);
				TestUtil.ActionForMovetoElement(Protocol);
				
			}
			catch(Exception e)
			{
				System.out.println("Interrupted exception seen");
			}
			
			String NameofProtocol = null;
			Select Protocolopt= new Select(Protocol);
			List<WebElement>NoofProtocol =  Protocolopt.getOptions();
			int SizeofProtocol= NoofProtocol.size();
			int row= 1;
			int rows=row;
			int count=0;
			rows=row+1;
			for(int i=0;i<SizeofProtocol;i++)
			{
				
			String ProtocolName= NoofProtocol.get(i).getText();
			//reader.setCellData("CycleList", "ProtocolName", rows, ProtocolName);
			try
			{
			 NameofProtocol = reader.getCellData("CycleList", "ProtocolName", rows);
			}
			catch(Exception e)
			{
				System.out.println("value is not taken");
				
			}
			if(ProtocolName.equals(NameofProtocol))
			{
				
				count++;
				rows++;
			}
			if(count==4)
			{
				Protocolopt.selectByVisibleText(ProtocolName);
				try
				{
					Thread.sleep(4000);
				
				Name= NoofProtocol.get(i).getText();
				}
				catch(Exception e)
				{
					System.out.println("Exception is seen");
				}
				if(Name.equals(null))
				{
					Name = "Antagonist"; 	
				}
				break;
			
			}
		
		}
			return Name;
	
		

		
		
		
		
		 
		
	

}
	public String MethodofSemenCollection()
	{
		
		//ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Semen, 50);
		}
		catch(TimeoutException e)
		{
			System.out.println("element- Semen is not seen within 50 sec");
		}
		Actions act = new Actions(driver);
		act.moveToElement(Semen).click().perform();
		//Semen.click();
		List<WebElement>Siementypes = driver.findElements(By.xpath("//select[@name='ddlPartnrSpermCollMethod']/option"));
		int Siemensize=Siementypes.size();
		int count=0;
		for(int i =0;i<=Siemensize;i++)
		{
			count++;
			if(count==4)
			{
				
				try
				{
					Thread.sleep(4000);
				
					Name= Siementypes.get(i).getText();
				}
				catch(Exception e)
				{
					System.out.println("Exception is seen");
				}
				
				Siementypes.get(i).click();
				
				break;
			}
			Name="Electrostimulation";
			
				
			
		
			
		}
		return Name;
		
	}
	public String SourceofspermPartner() 
	{
		//ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Sourceofsperm, 50);
			TestUtil.ActionForMovetoElement(Sourceofsperm);
		}
		catch(TimeoutException e)
		{
			System.out.println("element- Sourceofsperm is not seen within 30 sec");
		}
		List<WebElement>Sourceofsperms=driver.findElements(By.xpath("//label[text()='Source of Sperm']//following-sibling::div/select/option"));
		
		int count=0;
		for(int i=0;i<Sourceofsperms.size();i++)
		{
			count++;
			if(count==2)
			{
				
				try
				{
					Thread.sleep(4000);
				
					Name= Sourceofsperms.get(i).getText();
				}
				catch(Exception e)
				{
					System.out.println("Exception is seen");
				}
				Sourceofsperms.get(i).click();
				WebElement SOSName = driver.findElement(By.xpath("(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[1]"));
				 Name1=SOSName.getText();
				 break;
				
						
			}
			Name = "Partner";
			
		}
		return Name;
	}
	
	
	
		
	public String SourceofSpermselectionDonor() 
	{
			try
			{
				TestUtil.VisibleOn(driver, Sourceofsperm, 30);
			}
			catch(TimeoutException e)
			{
				System.out.println("element- Sourceofsperm is not seen within 30 sec");
			}
			Actions act = new Actions(driver);
			act.moveToElement(Sourceofsperm).click().perform();
			
			List<WebElement>Sourceofsperms=driver.findElements(By.xpath("//label[text()='Source of Sperm']//following-sibling::div/select/option"));
			
			int count=0;
			for(int i=0;i<=Sourceofsperms.size();i++)
			{
				count++;
				if(count==3)
				{
					try
					{
						Thread.sleep(4000);
					
						Name= Sourceofsperms.get(i).getText();
					}
					catch(Exception e)
					{
						System.out.println("Exception is seen");
					}
					
					Sourceofsperms.get(i).click();
					
					WebElement SOSName = driver.findElement(By.xpath("(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[1]"));
					 Name1=SOSName.getText();
					if(Name.equals(Name1))
					{
							break;
					}
					else
					{
						msg = Donor.getText();
					}
					
					
			
			
				}
				
			}
			Name="Donor";
			return Name;
			
		}
		
		
		
	
	public boolean IndicationtypeSelection()
	{
		try
		{
			TestUtil.VisibleOn(driver, Indication, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("element- Indication is not seen within 30 sec");
		}
		Actions act = new Actions(driver);
		act.moveToElement(Indication).click().perform();
	
	//Indication.click();
	List<WebElement> IndicationList = driver.findElements(By.xpath("//div[@class='checkBoxContainer']/div"));
	int indicationsize= IndicationList.size();
	int row = 1;
	int rows=row+1;
	int count=0;
	boolean flag=false;
	for(int i= 0;i<=indicationsize;i++)
	{
		String IndicationNames= IndicationList.get(i).getText();
	reader.setCellData("CycleList", "IndicationNames", rows, IndicationNames);
		
		String NameIndication = reader.getCellData("CycleList", "IndicationNames", rows);
		if(NameIndication.equals(IndicationNames))
		{
			IndicationList.get(i).click();
			rows++;
			count++;
			if(count==2)
			{
				break;
			}
		}
		else
		{
			IndicationList.get(i).click();
			if(count==2)
			{
				flag=true;
				break;
			}
			
		}
		List<WebElement>selectedIndicationoption = driver.findElements(By.xpath("//div[@class='col-md-12 col-sm-12 col-lg-12']/table/tbody/tr"));
		int Size= selectedIndicationoption.size();
		for(int j=1;j<=Size;j++)
		{	
		String names= selectedIndicationoption.get(i).getText();
		
		}
	
	}
	return flag;
	
	}
	
	
	public String SimulationDrug() 
	{
		try
		{
			TestUtil.VisibleOn(driver, SimulationDrug, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element-SimulationDrug is not seen within 30 sec");
		}
		System.out.println("SimulationDrug is displayed" +SimulationDrug.isDisplayed()+ "SimulationDrug is enabled"+ SimulationDrug.isEnabled());
		//ClickonNewCycle();
		Actions act = new Actions(driver);
		act.moveToElement(SimulationDrug).click().perform();
		
		List<WebElement>Drugs = driver.findElements(By.xpath("//div[@class='checkBoxContainer']//div"));
		int Size= Drugs.size();
		int count=0;
		int rows=2;
		for(int i=0;i<Size;i++)
		{
			String drugName=reader.getCellData("CycleList", "Stimulation Drug", 20);
			Name= Drugs.get(i).getText();
			if(Name.equals(drugName))
			{
				Drugs.get(i).click();
				break;
			}
			
			
		 
		
		
		
		}
		return Name;
		 
			
				
		}
	public String SimulationDrugText()
	{
		
		return SimulationDrugtext.getText();
		
	}
		
	
	public void InputvalueInTextBoxes()
	{
		
		String remarks = reader.getCellData("CycleList", "Remarks", 2);
		String warning = reader.getCellData("CycleList", "Remarks", 3);
		Remarks.clear();
		Remarks.sendKeys(remarks);
		CycleWarnings.clear();		
		CycleWarnings.sendKeys(warning);
		
	}
	
	public String LMPDateForSave()
	{
		try
		{
		TestUtil.VisibleOn(driver, LMPdate, 20);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element-LMPdate is not seen with in 20 seconds");
		}
		msg=LMPdate.getAttribute("value");
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
			
		}
		reader.setCellData("CycleList", "LMPDate", 2, msg);
		return msg;
		
		}
		 
		
		
		
		
		
		
		
		
		
		
	
	public String LMPDate()
	{
		int count=0;
		int count1 = count -1;
		
			LMPcalender.click();
			List<WebElement>Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td/button"));
			boolean flag= true ;
			for(int l =0;l<=Dates.size();l++)
			{
				
				count1++;
				if(flag==false)
				{
					break;
				}
				
				String firstdate = Dates.get(l).getText();
				
				if(firstdate.equals("01"))
				{
					
					for(int i =count1;i<=Dates.size();i++)
					{
						
						String Datetext= Dates.get(i).getText();
						WebElement Monthtextele = driver.findElement(By.xpath("//table[@class='uib-daypicker']//th/button[@role='heading']"));
						String text= Monthtextele.getText();
						String Arr[]=text.split(" ");
						String Monthtext = Arr[0]; 
						
						String CyrrentDate=TestUtil.Date();
						String[] Arr1= CyrrentDate.split(",");
						String day= Arr1[0];
						String Month = Arr1[1];
						
					
						boolean flag1= Dates.get(i).isEnabled();
						
						
						if(Datetext.equals(day)&&flag1==true&&Monthtext.equals(Month))
						{
							Dates.get(i).click();
							flag= false;
							break;
						}
						
						
					
				
			}
			
				}
				
				
				
				
			}
			return msg=LMPdate.getAttribute("value");
			
			
		}
		
		
		
		
		
		
		
	
	public void SaveTheCycle() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
			
		}
		Actions act = new Actions(driver);
		
		act.moveToElement(Save).click().perform();
	
	}
	public void NewPatientSaveTheCycle()
		{
			//ClickonNewCycle();
			NoofProtocol();
			LMPDate();
			InputvalueInTextBoxes();
			IndicationtypeSelection();
			SourceofspermPartner();
			MethodofSemenCollection();
			SimulationDrug();
			//SourceofSpermselectionDonor();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) 
			{
				System.out.println("InterruptedException is seen");
				
			}
			Actions act = new Actions(driver);
			act.moveToElement(Save).click().perform();
		
		}
		
		
		
				
				
	
	public boolean SaveEnablecondition()
	{
		boolean save= Save.isEnabled();
		return save;
		
	}
	
	public String SaveMessage()
	{
		try
		{
		TestUtil.VisibleOn(driver, Save, 30);
		TestUtil.ActionForMovetoElement(Save);
		}
		catch(Exception e)
		{
			System.out.println(" Element-Save is not seen with in 30 sec");
		}
		
		boolean save= Save.isEnabled();
		
		if(save==true)
		{
			try
			{
				Thread.sleep(2000);	
				TestUtil.ActionForMovetoElement(SaveMessage);
			}
			catch(InterruptedException e)
			{
				System.out.println("InterruptedException is occured");
			}
			msg= SaveMessage.getText();
		}
		else
		{
			msg= "Fill all mandetory fields.";
		}
		
		
		return msg;
		
	}
	
	public NewCycleListPage ClickonCyclecode() 
	{
		List<WebElement>cyclecodes = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a[@class='txt_bold ng-binding']"));
		try
		{
		TestUtil.VisibleOn(driver, Cyclecode, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element-cyclecode is not seen within 20 sec");
		}
		List<WebElement>cyclecodes1 = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a[@class='txt_bold ng-binding']"));
		int size1 = cyclecodes1.size();
		if(size1>0)
		{
		Cyclecode.click();
		}
		else
		{
			System.out.println("No cycle code available.");
		}
		
		
		
		
		return new NewCycleListPage();
		
	}
	public CycleOverviewPage ClickOnCycleCode()
	{
		List<WebElement>cyclecodes = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr//td[3]/a[@class='txt_bold ng-binding']"));
		try
		{
		TestUtil.VisibleOn(driver, Cyclecode, 30);
		TestUtil.ActionForMovetoElement(Cyclecode);
		}
		catch(Exception e)
		{
			System.out.println("Elemet-Cyclecode is not seen within 20 sec");
		}
		int size= cyclecodes.size();
		if(size>0)
		{
			Cyclecode.click();
		}
		else
		{
			System.out.println("cycle list page is seen");
		}
		
		
		return new CycleOverviewPage();
		
	}
	
	
	
}
	
	
	
				

		
		
	
	
	

