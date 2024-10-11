package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BankPage;
import pageObjects.CorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_BankTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyBank()
	{
		try
		{
			// hr core
			CorePage hc = new CorePage(driver);
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

			boolean act = bp.isBankCreated();
			Assert.assertEquals(act, true);
		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("test case completed");
	}
}
