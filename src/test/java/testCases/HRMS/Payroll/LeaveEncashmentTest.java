package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.LeaveEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.RetryAnalyzer;

public class CreateLeaveEncashmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createLeaveEncashment()
	{
		try
		{
			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// Leave Encashment pg
			LeaveEncashmentPage le = new LeaveEncashmentPage(driver);
			le.clkLeaveEncashment();
			logger.info("clicked on leave incashment");
			le.clkNewBtn();
			logger.info("clicked on new btn");
			le.clkEmpDD();
			logger.info("clicked on emp dd");
			le.slctEmp();
			logger.info("employee selected");
			le.clkLeaveTypeDD();
			logger.info("clicked on leave type dd");
			le.slctLeaveType();
			logger.info("selected leave type");
			le.providePaidDays();
			logger.info("provided paid days");
			le.clkViewBtn();
			logger.info("clicked on view btn");
			le.clkApproveBtn();
			logger.info("clicked on approve btn");

			Assert.assertTrue(le.isTxnCreated());

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
