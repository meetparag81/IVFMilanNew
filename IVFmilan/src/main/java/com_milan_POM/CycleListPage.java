package com_milan_POM;

import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.values.XmlValueDisconnectedException;
import org.openqa.selenium.By;
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
	private@FindBy(xpath="//textarea[@name='txtCyWarning']")WebElement CycleWarnings;
	private@FindBy(xpath="//textarea[@name='txtRemark']")WebElement Remarks;
	private@FindBy(xpath="//button[@class='btn btn-primary']")WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement SaveMessage;
	private @FindBy(xpath="//a[@class='txt_bold ng-binding']")WebElement CycleCode;
	private @FindBy(xpath="//i[@class='fa fa-calendar']")WebElement LMPcalender;
	private @FindBy(xpath="//a[@class='txt_bold ng-binding']")WebElement Cyclecode;
	
	
	String msg;
	String Name;
	String Name1;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	CycleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean NewCycleButtonEnableCondition()
	{
		 
		Actions act = new Actions(driver);
		act.moveToElement(Newcyclebutton);
		try
		{
			TestUtil.VisibleOn(driver, Newcyclebutton, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element- Newcyclebutton is not seen within30 seconds");
		}
		 boolean flag1 = Newcyclebutton.isEnabled();
		return flag1;
		
	}
	public String ClickonNewCycle() throws Exception
	{
		Thread.sleep(3000);
		boolean flag= NewCycleButtonEnableCondition();
		if(NewCycleButtonEnableCondition()==true)
		{
			Actions act = new Actions(driver);
			act.moveToElement(Newcyclebutton).click().perform();
		//Newcyclebutton.click();
			Thread.sleep(2000);
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
		System.out.println();
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
	public boolean EnabledconditionARTType() throws Exception
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
	public String  ARTTypeOption() throws Exception
	{
		// ClickonNewCycle();
		Select OptionART = new Select(Artselecttype);
	WebElement option =	OptionART.getFirstSelectedOption();
	String OptionName = option.getText();
	reader.setCellData("CycleList", "ARTtype", 2, OptionName);
		return OptionName;
		
	}
	
	public String NoofProtocol() throws Exception
	{
		Thread.sleep(2000);
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
		catch(XmlValueDisconnectedException e)
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
			Name= NoofProtocol.get(i).getText();
			break;
		}
	}
		return Name;
		 
		
	

}
	public String MethodofSemenCollection() throws Exception
	{
		
		//ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Semen, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("element- Semen is not seen within 30 sec");
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
				
				Name= Siementypes.get(i).getText();
				Siementypes.get(i).click();
				
				break;
			}
				
			
		
			
		}
		return Name;
		
	}
	public String SourceofspermPartner() throws Exception
	{
		//ClickonNewCycle();
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
			if(count==2)
			{
				Name= Sourceofsperms.get(i).getText();
				Sourceofsperms.get(i).click();
				WebElement SOSName = driver.findElement(By.xpath("(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[1]"));
				 Name1=SOSName.getText();
				 break;
				
						
			}
			/*else
			{
				
				WebElement SOSName = driver.findElement(By.xpath("(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[2]"));
				 Name1=SOSName.getText();
				 if(Name.equals(Name1))
					{
							break;
					}
			}*/
			
			
			
			
		}
		return Name;
	}
		
		
			
				
	
	
	public String SourceofSpermselectionDonor() throws Exception 
	{
		//ClickonNewCycle();
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
				Sourceofsperms.get(i).click();
				Name= Sourceofsperms.get(i).getText();
				WebElement SOSName = driver.findElement(By.xpath("(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[1]"));
				 Name1=SOSName.getText();
				if(Name.equals(Name1))
				{
						break;
				}
				msg = Donor.getText();
		
		
			}
		}
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
	
	
	public String SimulationDrug() throws Exception
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
		for(int i=0;i<=Size;i++)
		{
			String drugName=reader.getCellData("CycleList", "Stimulation Drug", 20);
			Name= Drugs.get(i).getText();
			if(Name.equals(drugName))
			{
				Drugs.get(i).click();
				break;
			}
			
		 
		
		/* if(count<=1542)
		 {
			 Name= Drugs.get(i).getText();
				reader.setCellData("CycleList", "Stimulation Drug", rows, Name);
				 rows++;
					count++;
				if(count==1542)
				{
					break;
				}*/
		 }
		return Name;
		 
			
				
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
	public void LMPDate()
	{
		LMPcalender.click();
		List<WebElement>Dates = driver.findElements(By.xpath("//table[@class='uib-daypicker']//following-sibling::tbody//tr/td"));
		for(int i =1;i<=Dates.size();i++)
		{
			String Datetext= Dates.get(i).getText();
			String date= reader.getCellData("CycleList", "Date", 2);
			String arr[] = date.split("/");
			String day = arr[0];
			if(Datetext.equals(day))
			{
				Dates.get(i).click();
				
				break;
			}
		}
		
	}
	public void SaveTheCycle() throws Exception
	{
		
		NoofProtocol();
		LMPDate();
		InputvalueInTextBoxes();
		IndicationtypeSelection();
		SourceofspermPartner();
		MethodofSemenCollection();
		SimulationDrug();
		//SourceofSpermselectionDonor();
		
		Save.click();
				
				
	}
	public boolean SaveEnablecondition()
	{
		boolean save= Save.isEnabled();
		return save;
		
	}
	
	public String SaveMessage()
	{
		boolean save= Save.isEnabled();
		
		if(save==true)
		{
			msg= SaveMessage.getText();
		}
		else
		{
			msg= "Fill all mandetory fields.";
		}
		
		
		return msg;
		
	}
	
	public NewCycleListPage ClickonCyclecode() throws Exception
	{
		Thread.sleep(2000);
		CycleCode.click();
		
		
		
		return new NewCycleListPage();
		
	}
	public CycleOverviewPage ClickOnCycleCode()
	{
		Actions act = new Actions(driver);
		act.moveToElement(Cyclecode).click().perform();
		return new CycleOverviewPage();
		
	}
	
	
	
}
	
	
	
				

		
		
	
	
	

