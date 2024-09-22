package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HrCorePage;
import testBase.BaseClass;

public class TC_HrCoreTest extends BaseClass
{
	@Test(groups = "regression", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyEmpCreation()
	{
		try
		{
			// hr core
			HrCorePage hc = new HrCorePage(driver);
			hc.clkHRCore();
			logger.info("clicked on hr core link");
			hc.clkEmp();
			logger.info("clicked on emp form");
			hc.clkBtnNew();
			logger.info("clicked on new button");
			hc.clkMgrDropdown();
			logger.info("clicked on mgr dropdown");
			hc.slctMgr();
			logger.info("mgr selected");
			hc.setName();
			logger.info("emp name provided");
			hc.clkDept();
			logger.info("clicked on dept");
			hc.slctDept();
			logger.info("dept selected");
			hc.clkDesig();
			logger.info("clicked on designation");
			hc.slctDesig();
			logger.info("designation selected");
			hc.clkSave();
			logger.info("clicked on save button");

			logger.info("assertion started");
			boolean act = hc.verifyEmp();
			Assert.assertEquals(act, true);
			logger.info("test case passed");
		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case ends--");
	}
}
