package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveOpeningBalanceModel;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.LeaveOpeningBalancePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateLeaveOpeningBalanceTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createLeaveOpeningBalance()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<LeaveOpeningBalanceModel> leaveOpeningData = JsonUtils.convertJsonListDataModel(payrollFile,
					"createLeaveOpeningBalance", LeaveOpeningBalanceModel.class);

			// hr core pg
			HRCorePage hc = new HRCorePage(driver);
			hc.clkHRCore();
			hc.clkEmployee();
			BasePage.navigateToEmployee("001");

			EmployeePage ep = new EmployeePage(driver);
			ep.clkTimeOff();
			double LeaveBal = ep.getAnnualLeaveBal(2);
			double expLeaveBal = LeaveBal + 1;

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// leave opening bal pg
			LeaveOpeningBalancePage ob = new LeaveOpeningBalancePage(driver);

			for (LeaveOpeningBalanceModel leaveOpBal : leaveOpeningData)
			{
				ob.clickLeaveOpeningBalance();
				ob.clickNew();
				ob.provideEmp(leaveOpBal.employee);
				ob.provideEffectiveDate(leaveOpBal.effectiveDate);
				ob.provideLeaveType(leaveOpBal.leaveType);
				ob.providePaidDays(leaveOpBal.paidDays);
				ob.provideRemarks(leaveOpBal.remarks);
				ob.clickView();
				ob.clickApprove();

				hc.clkHRCore();
				hc.clkEmployee();
				BasePage.navigateToEmployee("001");
				ep.clkTimeOff();

				Assert.assertEquals(ep.getAnnualLeaveBal(2), expLeaveBal);
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
