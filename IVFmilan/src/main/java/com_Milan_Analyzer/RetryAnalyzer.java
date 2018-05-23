package com_Milan_Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com_Milan_Base.TestBase;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int counter = 0;
	int retrylimit=3;
	
	 
	
	
	

	@Override
	public boolean retry(ITestResult result) 
	{
		if(counter < retrylimit)
		{
			counter++;
			return true;
		}
		return false;

		
	}

}
