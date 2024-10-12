package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeptPage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_DeptTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyDept()
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
			sp.clkDept();
			Thread.sleep(2000);
			logger.info("clicked on dept");

			// dept page
			DeptPage dp = new DeptPage(driver);
			dp.clkNewbtn();
			logger.info("clicked on new btn");
			dp.setDeptName();
			logger.info("dept name entered");
			dp.clkSelfServiceDD();
			logger.info("clicked self servide dd");
			dp.clkDeptMgrDD();
			logger.info("clicked dept mgr dd");
			dp.setDeptMgrName();
			logger.info("dept mgr name entered");
			dp.slctDeptMgr();
			logger.info("dept mgr selected");
			dp.clkSave();
			logger.info("clicked on save button");

			Assert.assertTrue(true);

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}
