package com_milan_POM;

import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.values.XmlValueDisconnectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
	private @FindBy(xpath="//label[@class='col-sm-12 col-md-12 col-lg-12 control-label p-r-0']//following::div/select")WebElement Semen;
	private @FindBy(xpath="//label[text()='Source of Sperm']//following-sibling::div/select")WebElement Sourceofsperm;
	private @FindBy(xpath="(//label[@class='col-sm-12 col-md-12 col-lg-12 control-label small_label'])[2]")WebElement Donor;
	private @FindBy(xpath ="//span[@class='multiSelect inlineBlock buttonClicked']/button")WebElement Indication;
	private @FindBy(xpath="//Button[@class='ng-binding']")WebElement SimulationDrug;
	private@FindBy(xpath="//textarea[@name='txtCyWarning']")WebElement CycleWarnings;
	private@FindBy(xpath="//textarea[@name='txtRemark']")WebElement Remarks;
	private@FindBy(xpath="//button[@class='btn btn-primary']")WebElement Save;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement SaveMessage;
	private @FindBy(xpath="//a[@class='txt_bold ng-binding']")WebElement CycleCode;
	private @FindBy(xpath="//i[@class='fa fa-calendar']")WebElement LMPcalender;
	
	String msg;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	CycleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean NewCycleButtonEnableCondition()
	{
		 System.out.println();
		 boolean flag1 = Newcyclebutton.isEnabled();
		return flag1;
		
	}
	public String ClickonNewCycle()
	{
		System.out.println();
		boolean flag= NewCycleButtonEnableCondition();
		if(NewCycleButtonEnableCondition()==true)
		{
		Newcyclebutton.click();
		 msg = Cyclepagetext.getText();
		}
		else
		{
			msg="Cycle is not created";
			System.out.println("Cycle is not created");
		}
		return msg;
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
	public boolean EnabledconditionARTType()
	{
		ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Artselecttype, 20);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element is not seen within 20 seconds");
		}
		boolean flag= Artselecttype.isEnabled();	
		
		
		return flag;
		
	}
	public String  ARTTypeOption()
	{
		 ClickonNewCycle();
		Select OptionART = new Select(Artselecttype);
	WebElement option =	OptionART.getFirstSelectedOption();
	String OptionName = option.getText();
	reader.setCellData("CycleList", "ARTtype", 2, OptionName);
		return OptionName;
		
	}
	
	public int NoofProtocol() throws Exception
	{
		Thread.sleep(2000);
		String NameofProtocol = null;
		ClickonNewCycle();
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
			Protocolopt.selectByVisibleText(ProtocolName);
			count++;
			rows++;
		}
		if(count>SizeofProtocol)
		{
			break;
		}
	}
		return count;
		
	

}
	public int MethodofSemenCollection()
	{
		System.out.println();
		ClickonNewCycle();
		String sizeofsiemen = null;
		Select semontype = new Select(Semen);
		List<WebElement>Sementypes = semontype.getOptions();
		int Sementypessize = Sementypes.size();
		try
		{
		 sizeofsiemen = Integer.toString(Sementypessize);
		}
		catch( NumberFormatException e)
		{
			System.out.println("int is no convertedinto string");
		}
				//reader.setCellData("CycleList", "SiemenSize", 2, sizeofsiemen); 
				int row= 1;
				int rows=row;
				int count=0;
				rows=row+1;
				for(int i=1;i<Sementypessize;i++)
				{
					
					String SiemenName= Sementypes.get(i).getText();
					reader.setCellData("CycleList", "SiemenName", rows, SiemenName);
					String NameSiemen= reader.getCellData("CycleList", "SiemenName", rows);
					if(SiemenName.equals(NameSiemen));
					{
						semontype.selectByVisibleText(SiemenName);
						count++;
						rows++;
					}
					if(count>Sementypessize)
					{
						break;
					}
					
				}
		
				 
				return count;
		
	}
	public int Sourceofsperm()
	{
		ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Sourceofsperm, 20);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element is not seen within20 seconds");
		}
		Select Sourceofsperm1 = new Select(Sourceofsperm);
			List<WebElement> spearmelmets=	Sourceofsperm1.getOptions();
				int Spearmsize = spearmelmets.size();
				int row= 1;
				int rows=row;
				int count=0;
				rows=row+1;
				 for(int i=0;i<Spearmsize;i++)
				{
					String spermName = spearmelmets.get(i).getText();
					//reader.setCellData("CycleList", "SpermName", rows, spermName);
					String Namesperm= reader.getCellData("CycleList", "SpermName", rows);
					if(spermName.equals(Namesperm))
					{
						Sourceofsperm1.selectByVisibleText(spermName);
						count++;
						rows++;
					}					
					if(count>Spearmsize)
					{
						break;
					}
						
					}
				return count;
				}
	
	
	public String SourceofSpermselection() 
	{
		ClickonNewCycle();
		try
		{
			TestUtil.VisibleOn(driver, Sourceofsperm, 20);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element is not seen within20 seconds");
		}
		Select Sourceofsperm1 = new Select(Sourceofsperm);
		String Spermname=reader.getCellData("CycleList", "SpermName", 4);
		Sourceofsperm1.selectByVisibleText(Spermname);
		 msg = Donor.getText();
		
		return msg;
		
	}
	public boolean IndicationtypeSelection()
	{
	Indication.click();
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
	
	
	public int SimulationDrug()
	{
		SimulationDrug.click();
		List<WebElement>Drugs = driver.findElements(By.xpath("//div[@class='checkBoxContainer']//div"));
		int Size= Drugs.size();
		
		for(WebElement drug:Drugs)
		{
			drug.click();
			int count=0;
			count++;
			if(count==4)
			{
				break;
			}
			
				
		}
		return Size;
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
			String arr[] = date.split(date);
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
		
		MethodofSemenCollection();
		
		Sourceofsperm();
		IndicationtypeSelection();
		InputvalueInTextBoxes();
		LMPDate();
		Save.click();
				
				
	}
	
	public NewCycleListPage ClickonCyclecode() throws Exception
	{
		Thread.sleep(2000);
		CycleCode.click();
		
		
		
		return new NewCycleListPage();
		
	}
	
	public String SaveMessage()
	{
		if(IndicationtypeSelection()==true)
	{
		msg= SaveMessage.getText();
	}
	else
	{
		msg="fillallmandetoryfields";
	}
		return msg;
		
	}
	
	
}
	
	
	
				

		
		
	
	
	

