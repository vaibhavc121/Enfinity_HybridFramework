package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.DesignationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
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

			Assert.assertTrue(dp.isDesgCreated());
			logger.info("test case passed");
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}