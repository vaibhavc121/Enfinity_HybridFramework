package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveAdjustmentModel;
import models.Payroll.Payroll.PayrollModel.LeaveOpeningBalanceModel;
import pageObjects.HRMS.Payroll.LeaveAdjustmentPage;
import pageObjects.HRMS.Payroll.LeaveOpeningBalancePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class DeleteLeaveOpeningBalanceTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteLeaveOpeningBalance()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<LeaveOpeningBalanceModel> leaveOpeningData = JsonUtils.convertJsonListDataModel(payrollFile,
					"createLeaveOpeningBalance", LeaveOpeningBalanceModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// Leave Opening Balance Page
			LeaveOpeningBalancePage ob = new LeaveOpeningBalancePage(driver);

			for (LeaveOpeningBalanceModel LeaveOpBal : leaveOpeningData)
			{
				ob.clickLeaveOpeningBalance();

				BasePage.performAction(6, LeaveOpBal.employee, "Amend");
				Assert.assertFalse(BasePage.validateListing(LeaveOpBal.employee, 6, 6));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
