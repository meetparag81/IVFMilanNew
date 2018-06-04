package com_milan_POM;

import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.values.XmlValueDisconnectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_Excelutility.Exls_Reader;

public class CycleListPage extends TestBase 
{
	private @FindBy(xpath="//button[@class='f-right btn-txt-link']")WebElement Newcyclebutton ;
	private @FindBy(xpath="//span[text()='Cycle List']")WebElement CyclelistTitle;
	private @FindBy(xpath="//label[text()='ART Type']//following-sibling::div/select")WebElement Artselecttype;
	private @FindBy(xpath="//span[@class='icon-screen ng-binding']")WebElement Cyclepagetext;
	private @FindBy(xpath="//label[text()='ART Type']//following::select[3]")WebElement Protocol;
	private @FindBy(xpath="//label[@class='col-sm-12 col-md-12 col-lg-12 control-label p-r-0']//following::div/select")WebElement Semen;
	private @FindBy(xpath="//label[text()='Source of Sperm']//following-sibling::div/select")WebElement Sourceofsperm;
	String msg ="";
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Git\\IVFmilan\\src\\main\\java\\com_Milan_TestData\\Milandata.xlsx");
	CycleListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean NewCycleButtonEnableCondition()
	{
		 boolean flag1 = Newcyclebutton.isEnabled();
		return flag1;
		
	}
	public String ClickonNewCycle()
	{
		
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
		String msg= CyclelistTitle.getText();
		System.out.println(msg);
		return msg;
	}
	public boolean EnabledconditionARTType()
	{
		ClickonNewCycle();
		boolean flag= Artselecttype.isEnabled();	
		
		
		return flag;
		
	}
	public String  ARTTypeOption()
	{
		 ClickonNewCycle();
		Select OptionART = new Select(Artselecttype);
	WebElement option =	OptionART.getFirstSelectedOption();
	String OptionName = option.getText();
	//reader.removeColumn("CycleList", 0);
	//reader.addColumn("CycleList", "ARTtype");
	reader.setCellData("CycleList", "ARTtype", 2, OptionName);
		return OptionName;
		
	}
	
	public int NoofProtocol()
	{
		String NameofProtocol;
		ClickonNewCycle();
		Select Protocolopt= new Select(Protocol);
		List<WebElement>NoofProtocol =  Protocolopt.getOptions();
		int SizeofProtocol= NoofProtocol.size();
		int row= 1;
		int rows=row;
		int count=0;
		rows=row+1;
		for(int i=1;i<SizeofProtocol;i++)
		{
			
		String ProtocolName= NoofProtocol.get(i).getText();
		reader.setCellData("CycleList", "ProtocolName", rows, ProtocolName);
		try
		{
		 NameofProtocol = reader.getCellData("CycleList", "ProtocolName", rows);
		}
		catch(XmlValueDisconnectedException e)
		{
			System.out.println("value is not taken");
			throw(e);
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
				reader.setCellData("CycleList", "SiemenSize", 2, sizeofsiemen); 
				int row= 1;
				int rows=row;
				int count=0;
				rows=row+1;
				for(int i=1;i<Sementypessize;i++)
				{
					
					String SiemenName= Sementypes.get(i).getText();
					//reader.setCellData("CycleList", "SiemenName", rows, SiemenName);
					String NameSiemen= reader.getCellData("CycleList", "SiemenName", rows);
					if(SiemenName.equals(NameSiemen));
					{
						semontype.selectByVisibleText(SiemenName);
						count++;
						row++;
					}
					if(count>Sementypessize)
					{
						break;
					}
					
					
					
					
				}
		
				 
				return count;
		
	}
	public void Sourceofsperm()
	{
		
		Select Sourceofsperm1 = new Select(Sourceofsperm);
			List<WebElement> spearmelets=	Sourceofsperm1.getOptions();
				int Spearmsize = spearmelets.size();
				int row= 1;
				int rows=row;
				int count=0;
				rows=row+1;
				 for(int i=0;i<=Spearmsize;i++)
				{
					String spermName = spearmelets.get(i).getText();
					reader.setCellData("CycleList", "SourceofSperm", rows, spermName);
					String Namesperm= reader.getCellData("CycleList", "SourceofSperm", rows);
					if(spermName.equals(Namesperm))
			
						Sourceofsperm1.selectByVisibleText(spermName);
						
					}
					
				}

		
		
	}
	
	

