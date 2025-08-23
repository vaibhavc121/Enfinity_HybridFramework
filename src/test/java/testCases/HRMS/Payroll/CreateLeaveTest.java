package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveModel;
import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.LeavePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateLeaveTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage(driver);

            for (LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				logger.info("provided effective date");
                lp.provideLeaveType(leave.leaveTypeUnpaid); //Unpaid Leave
                log("leave type selected");
                lp.provideFromDt(leave.fromDate);
                log("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                log("payment type selected");
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                BasePage.validateMessage("Leave Approved!");
                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeUnpaid, 7, 7), "Failed to create leave for emp: " + leave.employee);
                log("Verified: " + leave.leaveTypeUnpaid + " created for emp: " + leave.employee + " successfully.");
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}