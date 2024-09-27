package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testBase.BaseClass;

public class TestNGReportManager implements ITestListener
{
	WebDriver driver;

	public void onTestFailure(ITestResult result)
	{
		// Capture and store the screenshot
		String imgPath = new BaseClass().captureScreen(result.getName());

		// Get the driver instance from the failed test class
		Object testClass = result.getInstance();
		driver = ((BaseClass) testClass).getDriver();

		// Attach the screenshot to TestNG report
		Reporter.log("<a href='" + imgPath + "'>Click here to see Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<img src='" + imgPath + "' height='200' width='200'/>");
	}

}
