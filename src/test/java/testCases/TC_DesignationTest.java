package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesignationPage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_DesignationTest extends BaseClass
{

	@Test(groups = "regression")
	public void verifyDesignation() throws InterruptedException
	{
		try
		{
			// hr core
			HRCorePage hc = new HRCorePage(driver);
			hc.clkHRCore();
			logger.info("clicked on hr core link");
			hc.clkSetupForm();
			logger.info("clicked on setup form");

			// setup page
			SetupPage sp = new SetupPage(driver);
			sp.clkDesignation();
			Thread.sleep(2000);
			logger.info("clicked on desg");

			// designation pg
			DesignationPage dp = new DesignationPage(driver);
			dp.clkNewBtn();
			logger.info("clicked on new btn");
			dp.setDesigCode();
			logger.info("entered desg code");
			dp.setDesignation();
			logger.info("entered desg");
//			dp.clkGrade();
//			logger.info("clicked on grade");
//			dp.slctGrade();
//			logger.info("selected grade");
			dp.setJobDesc();
			logger.info("provided job desc");
			dp.clkSave();
			logger.info("clicked on save btn");
		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case completed--");

	}

}
