package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HRMS.HRCore.DesignationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
<<<<<<< HEAD
import testBase.BaseClass;
import utilities.CommonActions;
=======
>>>>>>> fe4da3ab4c8c03bea3f28604da3e8ec4e3405a3e

public class TC_DesignationTest extends BaseClass
{

	@Test(groups = "regression")
	public void verifyDesignation() throws InterruptedException
	{
		try
		{
			// hr core
			HRCorePage hc = new HRCorePage(driver);
			Thread.sleep(5000);
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

			Assert.assertTrue(CommonActions.IsTxnCreated());
			logger.info("test case passed");
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
