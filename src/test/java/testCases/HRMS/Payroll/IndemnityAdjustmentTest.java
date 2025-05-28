package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.IndemnityAdjustmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.RetryAnalyzer;

public class IndemnityAdjustmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void verifyIndemnityAdjustment()
	{
		try
		{
			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// Indemnity Adjustment pg
			IndemnityAdjustmentPage ia = new IndemnityAdjustmentPage(driver);
			ia.clkIndemnityAdjustment();
			logger.info("clicked on ind adj");
			ia.clkNewBtn();
			logger.info("clicked on new btn");
			ia.clkEmpDD();
			logger.info("clicked on emp dd");
			ia.slctEmp();
			logger.info("emp selected");
			ia.clkIndemnityDD();
			logger.info("clicked on ind dd");
			ia.slctIndemnity();
			logger.info("end selected");
			ia.providePaidDays();
			logger.info("paid days provided");
			ia.clkView();
			logger.info("clicked on view");
			ia.clkApprove();
			logger.info("clicked on approve");

			Assert.assertTrue(ia.isTxnCreated());
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
