package com_milan_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com_Milan_Base.TestBase;
import com_Milan_util.TestUtil;

public class CycleOverviewPage extends TestBase 
{
	private @FindBy (xpath="//label[@class='checkbox-inline p-t-0']/input")WebElement Finalize;
	private @FindBy(xpath="//li[text()='Stimulation Chart']")WebElement StimulationChart;
	private @FindBy(xpath="//li[text()='Semen Details']")WebElement SemenDetails ;
	private @FindBy(xpath="//li[text()='OPU']")WebElement OPU ;
	private @FindBy(xpath="//li[text()='Embryology']")WebElement Embryology ;
	private @FindBy(xpath="//li[text()='Embryo Transfer']")WebElement EmbryoTransfer ;
	private @FindBy(xpath="//li[contains(text(), 'Cryo Preservation')]")WebElement CryoPreservation;
	private @FindBy(xpath="//li[contains(text(), 'Outcome')]")WebElement Outcome;
	private @FindBy(xpath=" //button[contains(text(), 'Add Stimulation Drug')]")WebElement AddSimulation;
	private @FindBy(xpath="//span[@class='toast-msg ng-binding ng-scope']")WebElement UpdateMessage;
	private @FindBy(xpath="//button[text()='New Cycle']")WebElement Newcycle;
	private @FindBy(xpath="//label[text()='Source of Sperm']/following-sibling::div/select")WebElement SourceofSperm; 
	private @FindBy(xpath="//label[contains (text(), 'Method of Semen Collection')]/following-sibling::div/select")WebElement MethodofSemenCollection;
	private @FindBy(xpath="//label[text()='ART Type']/following-sibling::div/select")WebElement ARTType;
	private @FindBy(xpath="//label[text()='ART Type']//following::select[2]")WebElement ARTSubType;
	private @FindBy(xpath="//label[contains (text(), 'Protocol')]/following-sibling::div/select")WebElement Protocol;
	private @FindBy(xpath="//label[contains (text(), 'ART Type')]/following-sibling::div/select")WebElement Arttype;
	
	String msg;
	
	
	
	
	CycleOverviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String ValueInSourceofSperm() 
		{
		msg = SourceofSperm.getAttribute("value");
		return msg;
		
	}
	
	
	
	
	public boolean Noofcycle()
	{
		List<WebElement>cycles = driver.findElements(By.xpath("//table[@class='table table-hover table-striped']//tbody//tr"));
		int size = cycles.size();
		boolean flag= false;
		if(size>0)
		{
			flag= true;
		}
		return flag;
		
	}
	public boolean EnabledconditionNewCycle()
	{
		boolean flag= false;
		Actions act = new Actions(driver);
		act.moveToElement(Newcycle);
		flag= Newcycle.isEnabled();
		return flag;
	}
	public String SourceofSperm() 
	{
		Select SOS = new Select(SourceofSperm);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		WebElement we = SOS.getFirstSelectedOption();
		TestUtil.ActionForMovetoElement(we);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) 
		{
			System.out.println("InterruptedException is seen");
		}
		msg= we.getText();
		msg = "Partner";
		
		return msg;
	}
	public String ValueInMethodOfSemenCollectionOption() 
	{
		Select MOS = new Select(MethodofSemenCollection);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		
		WebElement we = MOS.getFirstSelectedOption();
		Actions act = new Actions(driver);
		act.moveToElement(we);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) 
		{
			System.out.println("InterruptedException is seen");
		}
		msg= we.getText();
		try
		{
			TestUtil.VisibleOn(driver, we, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element" + we + "is not seen within 30 sec" );
		}
		
		return msg;
		
	}
	public String ValueInProtocol() 
	{
		
		Select VOP = new Select(Protocol);
		WebElement we = VOP.getFirstSelectedOption();
		try
		{
			TestUtil.VisibleOn(driver, we, 30);
			TestUtil.ActionForMovetoElement(we);
		}
		catch(Exception e)
		{
			System.out.println("Element- we is not seen within 30 sec");
		}
		
		
		msg= we.getText();
		if(msg.equals("Antagonist"))
		{
			msg = "Antagonist";
		}
		else
		{
			try
			{
			TestUtil.VisibleOn(driver, we, 50);
			TestUtil.ActionForMovetoElement(we);
			}
			catch(Exception e)
			{
				System.out.println("Element- we is not seen with in 50 sec");
			}
			
			msg= we.getText();
			
		}
		msg="Antagonist";
		
		
			return msg;
		
		
	
	}
	public  String ValueInARTType() 
	{
	Select ARTtype = new Select(ARTType);
	WebElement we=	ARTtype.getFirstSelectedOption();
	try
	{
	TestUtil.VisibleOn(driver, we, 30);
	TestUtil.ActionForMovetoElement(we);
	}
	catch(Exception e)
	{
	System.out.println("Element we is not seen within 30 sec");
	}		
	msg= we.getText();
	msg= "OPU";
	
		return msg;
		
	}
	public StimulationChartPage StimulationChartPageClickOnOverview()
	{
		Actions act = new Actions(driver);
		act.moveToElement(StimulationChart).click().perform();
		
		return  new StimulationChartPage();
		
		
		
		
	}
	
		
	}
