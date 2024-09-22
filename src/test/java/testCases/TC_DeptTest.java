package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeptPage;
import pageObjects.HrCorePage;
import testBase.BaseClass;

public class TC_DeptTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyDept()
	{
		try
		{
			// hr core
			HrCorePage hc = new HrCorePage(driver);
			hc.clkHRCore();
			logger.info("clicked on hr core link");
			hc.clkSetupForm();
			logger.info("clicked on setup form");

			// dept page
			DeptPage dp = new DeptPage(driver);
			dp.clkDept();
			Thread.sleep(2000);
			logger.info("clicked on dept");
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
			Assert.fail();
		}

	}
}
