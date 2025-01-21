package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.HRCore.WorkLocationPage;
<<<<<<< HEAD
import testBase.BaseClass;
import utilities.CommonActions;
=======
>>>>>>> fe4da3ab4c8c03bea3f28604da3e8ec4e3405a3e

public class TC_WorkLocationTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyWorkLocation()
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
			sp.clkWorkLocation();
			Thread.sleep(2000);
			logger.info("clicked on worklocation");

			// work location pg
			WorkLocationPage wc = new WorkLocationPage(driver);
			wc.clkNewBtn();
			wc.setName();
			wc.clkSaveBtn();
			boolean act = CommonActions.IsTxnCreated();

			Assert.assertEquals(act, true);
			logger.info("test case passed");

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
