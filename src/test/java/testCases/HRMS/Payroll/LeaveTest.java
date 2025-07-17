package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.LeavePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class LeaveTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage(driver);

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                logger.info("clicked on leave");
                lp.clkNewBtn();
                logger.info("clicked on new btn");
                lp.provideEmp(leave.employee);
                logger.info("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				logger.info("provided effective date");
                lp.provideLeaveType(leave.leaveTypeUnpaid); //Unpaid Leave
                logger.info("leave type selected");
                lp.provideFromDt(leave.fromDate);
                logger.info("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                logger.info("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                logger.info("clicked on view btn");
                lp.clkApproveBack();
                logger.info("clicked on approve btn");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeUnpaid, 9, 9));

            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage(driver);

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                logger.info("clicked on leave");
                BasePage.performAction(5, leave.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee, 5, 5));

            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLeave1()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage(driver);

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                logger.info("clicked on leave");
                lp.clkNewBtn();
                logger.info("clicked on new btn");
                lp.provideEmp(leave.employee);
                logger.info("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				logger.info("provided effective date");
                lp.provideLeaveType(leave.leaveTypec); //Unpaid Leave
                logger.info("leave type selected");
                lp.provideFromDt(leave.fromDate);
                logger.info("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                logger.info("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                logger.info("clicked on view btn");
                lp.clkApproveBack();
                logger.info("clicked on approve btn");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveType, 9, 9));

            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLeave1()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage(driver);

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                logger.info("clicked on leave");
                BasePage.performAction(5, leave.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee, 5, 5));

            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}