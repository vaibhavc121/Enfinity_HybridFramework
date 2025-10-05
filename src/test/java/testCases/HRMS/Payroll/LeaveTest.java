package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.LeavePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.text.DecimalFormat;
import java.util.List;

public class LeaveTest extends BaseTest
{
    //region Unpaid Leave
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1, enabled = true)
    public void createUnpaidLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				log("provided effective date");
                lp.provideLeaveType(leave.leaveTypeUnpaid); //Unpaid Leave
                log("leave type selected");
                lp.provideFromDt(leave.fromDate);
                log("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeUnpaid, 7, 7));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2, enabled = true)
    public void deleteUnpaidLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                BasePage.performAction(5, leave.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    //endregion

    //region Condolence Leave
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1, enabled = true)
    public void createCondolenceLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("003");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getLeaveBal(1);
            double expLeaveBal = LeaveBal - 1;

            // payroll pg
            PayrollPage pp = new PayrollPage();
            BasePage.clickMenuIcon();
            log("clicked on menu icon");
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee1);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				log("provided effective date");
                lp.provideLeaveType(leave.leaveTypeCondolence); //Unpaid Leave
                log("leave type selected");
                lp.provideFromDt(leave.fromDate);
                log("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                hc.clickHRCore();
                hc.clickEmployee();
                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();

                Assert.assertEquals(ep.extractValueFromText(1), expLeaveBal);
                //Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeCondolence, 9, 9));

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 2, enabled = true)
    public void deleteCondolenceLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Haj Leave
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 3, enabled = true)
    public void createHajLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("003");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getLeaveBal(4);
            double expLeaveBal = LeaveBal - 1;

            // payroll pg
            PayrollPage pp = new PayrollPage();
            BasePage.clickMenuIcon();
            log("clicked on menu icon");
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee1);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				log("provided effective date");
                lp.provideLeaveType(leave.leaveTypeHaj);
                log("leave type selected");
                lp.provideFromDt(leave.fromDate);
                log("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                hc.clickHRCore();
                hc.clickEmployee();
                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();

                Assert.assertEquals(ep.extractValueFromText(4), expLeaveBal);
                //Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeCondolence, 9, 9));

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 4, enabled = true)
    public void deleteHajLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Maternity Leave
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 5, enabled = true)
    public void createMaternityLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("003");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getLeaveBal(5);
            double expLeaveBal = LeaveBal - 1;

            // payroll pg
            PayrollPage pp = new PayrollPage();
            BasePage.clickMenuIcon();
            log("clicked on menu icon");
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee1);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				log("provided effective date");
                lp.provideLeaveType(leave.leaveTypeMaternity);
                log("leave type selected");
                lp.provideFromDt(leave.fromDate);
                log("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                hc.clickHRCore();
                hc.clickEmployee();
                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();

                Assert.assertEquals(ep.extractValueFromText(5), expLeaveBal);
                //Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeCondolence, 9, 9));

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 6, enabled = true)
    public void deleteMaternityLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Sick Leave
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 7, enabled = true)
    public void createSickLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("003");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getLeaveBal(3);
            double expLeaveBal = LeaveBal - 1;

            // payroll pg
            PayrollPage pp = new PayrollPage();
            BasePage.clickMenuIcon();
            log("clicked on menu icon");
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee1);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				log("provided effective date");
                lp.provideLeaveType(leave.leaveTypeSick);
                log("leave type selected");
                lp.provideFromDt(leave.fromDate);
                log("provided from date");
                lp.provideUpToDt(leave.uptoDate);
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                hc.clickHRCore();
                hc.clickEmployee();
                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
                //Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeCondolence, 9, 9));

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 8, enabled = true)
    public void deleteSickLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Annual Leave
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 9)
    public void createAnnualLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickEmployee();
            BasePage.navigateToEmployee("003");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            double LeaveBal = ep.getLeaveBal(6);
            double expLeaveBal1 = LeaveBal - 1;
            DecimalFormat df = new DecimalFormat("#.##");
            String expLeaveBal = df.format(expLeaveBal1);
            double expLeaveBalance = Double.parseDouble(expLeaveBal);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            BasePage.clickMenuIcon();
            log("clicked on menu icon");
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                lp.clkNewBtn();
                log("clicked on new btn");
                lp.provideEmp(leave.employee1);
                log("emp selected");
//				lp.provideEffectiveDt(leave.effectiveDate);
//				log("provided effective date");
                lp.provideLeaveType(leave.leaveTypeAnnual);
                log("leave type selected");
                lp.provideFromDate();
                log("provided from date");
                lp.provideUpToDate();
                log("provided upto date");
                lp.providePaymentType(leave.paymentType);
                lp.clkView();
                log("clicked on view btn");
                lp.clkApproveBack();
                log("clicked on approve btn");

                hc.clickHRCore();
                hc.clickEmployee();
                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();

                Assert.assertEquals(ep.extractValueFromText(6), expLeaveBalance);
                BasePage.openSidebar();
                //Assert.assertTrue(BasePage.validateListing2Fields(leave.employee, 5, 5, leave.leaveTypeCondolence, 9, 9));

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 10)
    public void deleteAnnualLeave()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
                    PayrollModel.LeaveModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // leave pg
            LeavePage lp = new LeavePage();

            for (PayrollModel.LeaveModel leave : leaveData)
            {
                lp.clkLeave();
                log("clicked on leave");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion
}