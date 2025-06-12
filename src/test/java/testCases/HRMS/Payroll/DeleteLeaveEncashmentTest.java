package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveAdjustmentModel;
import models.Payroll.Payroll.PayrollModel.LeaveEncashmentModel;
import pageObjects.HRMS.Payroll.LeaveAdjustmentPage;
import pageObjects.HRMS.Payroll.LeaveEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class DeleteLeaveEncashmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteLeaveEncashment()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<LeaveEncashmentModel> leaveEncashData = JsonUtils.convertJsonListDataModel(payrollFile,
					"createLeaveEncashment", LeaveEncashmentModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// leave adjustment pg
			LeaveEncashmentPage le = new LeaveEncashmentPage(driver);

			for (LeaveEncashmentModel LeaveEncashment : leaveEncashData)
			{
				le.clkLeaveEncashment();
				logger.info("clicked on leave adj");

				BasePage.performAction(6, LeaveEncashment.employee, "Amend");
				Assert.assertFalse(BasePage.validateListing("Approved", 6, 6));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
