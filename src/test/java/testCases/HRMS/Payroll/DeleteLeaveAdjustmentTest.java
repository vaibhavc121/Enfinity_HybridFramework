package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveAdjustmentModel;
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.LeaveAdjustmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class DeleteLeaveAdjustmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteLeaveAdjustment()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<LeaveAdjustmentModel> leaveAdjData = JsonUtils.convertJsonListDataModel(payrollFile,
					"createLeaveAdjustment", LeaveAdjustmentModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// leave adjustment pg
			LeaveAdjustmentPage la = new LeaveAdjustmentPage(driver);

			for (LeaveAdjustmentModel LeaveAdjustment : leaveAdjData)
			{
				la.clkLeaveAdj();
				logger.info("clicked on leave adj");

				BasePage.performAction(6, LeaveAdjustment.employee, "Amend");
				Assert.assertFalse(BasePage.validateListing(LeaveAdjustment.employee, 6, 6));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
