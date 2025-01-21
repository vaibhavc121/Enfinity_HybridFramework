package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.BudgetPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import testBase.BaseClass;
import utilities.CommonActions;

public class TC_BudgetTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyBudget()
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
			sp.clkBudget();
			Thread.sleep(2000);
			logger.info("clicked on budget");

			// budget pg
			BudgetPage bp = new BudgetPage(driver);
			bp.clkNewBtn();
			logger.info("clicked on new btn");
			bp.setName();
			logger.info("provided budget name");
			bp.setStartDt();
			logger.info("provided start dt");
			bp.setEndDt();
			Thread.sleep(2000);
			logger.info("provided end dt");
			bp.clkSaveBtn();
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
