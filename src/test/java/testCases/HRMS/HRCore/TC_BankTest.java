package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.BankPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import testBase.BaseClass;
import utilities.CommonActions;

public class TC_BankTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyBank()
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
			sp.clkBank();
			Thread.sleep(2000);
			logger.info("clicked on bank");

			// bank pg
			BankPage bp = new BankPage(driver);
			bp.clkNewBtn();
			logger.info("clicked on new btn");
			bp.setName();
			logger.info("provided bank name");
			bp.checkToggle();
			logger.info("clicked on IBAN toggle btn");
			bp.clkSave();
			logger.info("clicked on save button");

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
