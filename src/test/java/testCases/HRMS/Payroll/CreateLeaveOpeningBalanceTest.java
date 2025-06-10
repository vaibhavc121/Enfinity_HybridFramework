package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveOpeningBalanceModel;
import pageObjects.HRMS.HRCore.EmployeePage1;
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
			hc.clickHRCore();
			hc.clickEmployee();
			BasePage.navigateToEmployee("001");

			EmployeePage1 ep = new EmployeePage1(driver);
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
				log("clicked on LeaveOpening Balance");

				ob.clickNew();
				log("clicked on New");

				ob.provideEmp(leaveOpBal.employee);
				log("provided Emp");

				ob.provideEffectiveDate(leaveOpBal.effectiveDate);
				log("provided Effective Date");

				ob.provideLeaveType(leaveOpBal.leaveType);
				log("provided LeaveType");

				ob.providePaidDays(leaveOpBal.paidDays);
				log("provided PaidDays");

				ob.provideRemarks(leaveOpBal.remarks);
				log("provided Remarks");

				ob.clickView();
				log("clicked on View");

				ob.clickApprove();
				log("clickApprove");

				hc.clickHRCore();
				log("clickHRCore");

				hc.clickEmployee();
				log("clickEmployee");

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
