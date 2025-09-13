package testCases.HRMS.Payroll;

import java.util.List;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveEncashmentModel;
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.LeaveEncashmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class LeaveEncashmentTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLeaveEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveEncashmentModel> leaveEncashData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLeaveEncashment", LeaveEncashmentModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("001");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getLeaveBal(2);
            double expLeaveBal = LeaveBal - 1;

            // payroll pg
            PayrollPage pp = new PayrollPage();
            BasePage.navigateToModule("Payroll");
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Leave Encashment pg
            LeaveEncashmentPage le = new LeaveEncashmentPage();
            for (LeaveEncashmentModel LeaveEncashment : leaveEncashData)
            {
                le.clkLeaveEncashment();
                log("clicked on leave incashment");
                le.clkNewBtn();
                log("clicked on new btn");
                le.provideEffectiveDate(LeaveEncashment.effectiveDate);
                log("provided effective date");
                le.provideEmp(LeaveEncashment.employee);
                log("employee selected");
                le.provideLeaveType(LeaveEncashment.leaveType);
                log("selected leave type");
                le.providePaidDays(LeaveEncashment.paidDays);
                log("provided paid days");
                le.selectPaymentType(LeaveEncashment.paymentType);
                log("provided payment type");
                le.clkViewBtn();
                log("clicked on view btn");
                le.clkApproveBtn();
                log("clicked on approve btn");

                BasePage.navigateToModule("HR Core");
                hc.clickEmployee();
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
    public void deleteLeaveEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveEncashmentModel> leaveEncashData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLeaveEncashment", LeaveEncashmentModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave adjustment pg
            LeaveEncashmentPage le = new LeaveEncashmentPage();

            for (LeaveEncashmentModel LeaveEncashment : leaveEncashData)
            {
                le.clkLeaveEncashment();
                log("clicked on leave adj");

                BasePage.performAction(6, LeaveEncashment.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(LeaveEncashment.employee, 6, 6));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}