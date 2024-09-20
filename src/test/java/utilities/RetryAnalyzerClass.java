package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerClass implements IRetryAnalyzer
{
	int counter = 1;
	int retrylimit = 2;

	@Override
	public boolean retry(ITestResult result)
	{
		if (counter <= retrylimit)
		{
			counter++;
			return true;
		}

		return false;
	}

}
