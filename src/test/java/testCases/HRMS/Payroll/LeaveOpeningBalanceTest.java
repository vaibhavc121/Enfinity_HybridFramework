package testCases.HRMS.Payroll;

import java.util.List;

import factory.LoggerFactory;
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

public class LeaveOpeningBalanceTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLeaveOpeningBalance()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveOpeningBalanceModel> leaveOpeningData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLeaveOpeningBalance", LeaveOpeningBalanceModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            log("clicked on HRCore link");
            hc.clickEmployee();
            log("clicked on Employee");
            BasePage.navigateToEmployee("001");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            log("clicked on TimeOff");
            double LeaveBal = ep.getLeaveBal(2);
            double expLeaveBal = LeaveBal + 1;

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave opening bal pg
            LeaveOpeningBalancePage ob = new LeaveOpeningBalancePage();

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

                Assert.assertEquals(ep.getLeaveBal(2), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLeaveOpeningBalance()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveOpeningBalanceModel> leaveOpeningData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLeaveOpeningBalance", LeaveOpeningBalanceModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Leave Opening Balance Page
            LeaveOpeningBalancePage ob = new LeaveOpeningBalancePage();

            for (LeaveOpeningBalanceModel LeaveOpBal : leaveOpeningData)
            {
                ob.clickLeaveOpeningBalance();

                BasePage.performAction(6, LeaveOpBal.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(LeaveOpBal.employee, 6, 6));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}