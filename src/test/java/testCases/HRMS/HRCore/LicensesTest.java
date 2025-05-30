package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.LicensesPage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.CommonActions;

public class LicensesTest extends BaseTest
{
	@Test(groups = "regression")
	public void verifyLicenses()
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
			sp.clkLicense();
			Thread.sleep(2000);
			logger.info("clicked on license");

			// license pg
			LicensesPage lp = new LicensesPage(driver);
			lp.clkNewBtn();
			lp.setName();
			lp.clkFileNumDD();
			lp.slctFileNum();
			lp.clkSaveBtn();

			// Assert.assertEquals(lp.isLicenseCreated(), true);
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
