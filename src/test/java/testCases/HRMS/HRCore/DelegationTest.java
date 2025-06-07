package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.DelegationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.CommonActions;

public class DelegationTest extends BaseTest
{
	@Test(groups = "regression")
	public void verifyDelegation()
	{
		try
		{
			// hr core
			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			logger.info("clicked on hr core link");
			hc.clickSetupForm();
			logger.info("clicked on setup form");

			// setup page
			SetupPage sp = new SetupPage(driver);
			sp.clickDelegation();
			Thread.sleep(2000);
			logger.info("clicked on delegation");

			// delegation pg
			DelegationPage dp = new DelegationPage(driver);
			dp.clkNewBtn();
			logger.info("clicked on new btn");
			dp.clkDelegateeDD();
			logger.info("clicked on delegatee dropdown");
			dp.slctDelegatee();
			logger.info("selected delegatee");
			dp.clkSaveBtn();
			logger.info("clicked on save btn");

			Assert.assertTrue(CommonActions.IsTxnCreated());
			logger.info("test case passed");

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
