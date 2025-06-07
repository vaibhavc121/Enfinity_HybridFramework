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
import utilities.DataUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateLeaveAdjustmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createLeaveAdjustment()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<LeaveAdjustmentModel> leaveAdjData = JsonUtils.convertJsonListDataModel(payrollFile,
					"createLeaveAdjustment", LeaveAdjustmentModel.class);

			// hr core pg
			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickEmployee();
			BasePage.navigateToEmployee("001");

			EmployeePage1 ep = new EmployeePage1(driver);
			ep.clkTimeOff();
			double LeaveBal = ep.getAnnualLeaveBal(3);
			double expLeaveBal = LeaveBal + 1;

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

				la.clkNewBtn();
				logger.info("clicked on new btn");

				la.provideEmp(LeaveAdjustment.employee);
				logger.info("employee selected");

				la.provideEffectiveDate(LeaveAdjustment.effectiveDate);
				logger.info("provied effective date");

				la.provideLeaveType(LeaveAdjustment.leaveType);
				logger.info("leave type selected");

				la.providePaidDaysValue(LeaveAdjustment.paidDays);
				logger.info("provided paid days value");

//				la.provideUnpaidDaysValue();
//				logger.info("provided unpaid days value");

				la.provideRemarks(LeaveAdjustment.remarks);
				logger.info("provided remarks");

				la.clkViewBtn();
				logger.info("clicked on view btn");

				la.clkApproveBtn();
				logger.info("clicked on approve btn");

				hc.clickHRCore();
				hc.clickEmployee();
				BasePage.navigateToEmployee("001");
				ep.clkTimeOff();

				Assert.assertEquals(ep.extractValueFromText(), expLeaveBal);

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
