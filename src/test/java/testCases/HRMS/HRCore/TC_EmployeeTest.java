package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import testBase.BaseClass;

public class TC_EmployeeTest extends BaseClass
{
	@Test(groups = "regression", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void verifyEmpCreation()
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
			sp.clkEmployee();
			Thread.sleep(2000);
			logger.info("clicked on employee");

			// employee pg
			EmployeePage ep = new EmployeePage(driver);
			ep.clkBtnNew();
			logger.info("clicked on new button");
			ep.setWorkEmail();
			logger.info("work email provided");
//			ep.clkMgrDropdown();
//			logger.info("clicked on mgr dropdown");
//			ep.slctMgr();
//			logger.info("mgr selected");
			ep.setName();
			logger.info("emp name provided");
			ep.clkDept();
			logger.info("clicked on dept");
			ep.slctDept();
			logger.info("dept selected");
			ep.clkDesig();
			logger.info("clicked on designation");
			ep.slctDesig();
			logger.info("designation selected");
			ep.clkSave();
			logger.info("clicked on save button");

			logger.info("assertion started");
			boolean act = ep.verifyEmp();
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
