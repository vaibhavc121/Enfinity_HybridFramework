package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BudgetPage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

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

			Assert.assertTrue(bp.isBudgetCreated());
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

		logger.info("--test case completed--");

	}
}