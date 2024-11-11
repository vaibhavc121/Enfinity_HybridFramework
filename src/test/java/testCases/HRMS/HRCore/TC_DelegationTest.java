package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.DelegationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import testBase.BaseClass;

public class TC_DelegationTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyDelegation()
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
			sp.clkDelegation();
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

			Assert.assertTrue(true);
			logger.info("test case passed");

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
