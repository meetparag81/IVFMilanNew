package com_milan_POM;

import java.util.Iterator;
import java.util.List;

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
			reader.setCellData("CycleList", "ProtocolName", rows, ProtocolName);
		String NameofProtocol = reader.getCellData("CycleList", "ProtocolName", rows);
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
}
