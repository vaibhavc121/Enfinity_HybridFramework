package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import factory.DriverFactory;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.LeavePage;
import pageObjects.HRMS.Payroll.LeaveResumptionPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class LeaveResumptionTest extends BaseTest
{
    //region Actual Leave Resumption
    @Test(groups = {"functional", "regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void verifyActualLeaveResumption()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave", PayrollModel.LeaveModel.class);

            // hr core pg
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            log("clicked on hr core link");
            hc.clickEmployee();
            log("clicked on employee link");
            BasePage.navigateToEmployee("003");

            EmployeePage1 ep = new EmployeePage1();
            ep.clkTimeOff();
            log("clicked on time off tab");
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
                log("provided payment type");

                lp.clkView();
                log("clicked on view btn");

                lp.clickApprove();
                log("clicked on approve btn");

                lp.clickEditResumption();
                log("clicked on edit resumption btn");

                BasePage.switchTab();
                log("switched to leave resumption tab");

                BasePage.clickOnViewTxn();
                log("clicked on view btn");

                BasePage.waitTS(2);

                lp.clickResume();
                log("clicked on resume btn");

                BasePage.waitTS(2);

                BasePage.closeUnwantedTab();

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                log("navigated back to leave page");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee1, 5, 5, "Yes", 6, 6));
                log("assertion passed for leave resumption");

                BasePage.clickMenuIcon();
                log("clicked on menu icon");

                hc.clickHRCore();
                log("clicked on hr core link");

                hc.clickEmployee();
                log("clicked on employee link");

                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();
                log("clicked on time off tab");

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = {"functional", "regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteActualLeaveResumption()
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
                BasePage.performAction(5, leave.employee1, "Cancel Resumption");
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

    //region Early Leave Resumption
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void verifyEarlyLeaveResumptionWithEncashDays()
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
                log("provided payment type");

                lp.clkView();
                log("clicked on view btn");

                lp.clickApprove();
                log("clicked on approve btn");

                lp.clickEditResumption();
                log("clicked on edit resumption btn");

                BasePage.switchTab();
                log("switched to leave resumption tab");

                LeaveResumptionPage lrp = new LeaveResumptionPage();
                lrp.provideResumptionDate(leave.expEarlyResumptionDate);
                log("provided resumption date");

                BasePage.clickOnViewTxn();
                log("clicked on view btn");

                BasePage.waitTS(2);

                lp.clickResume();
                log("clicked on resume btn");

                BasePage.waitTS(2);

                BasePage.closeUnwantedTab();
                log("switched to leave tab");

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                log("navigated back to leave page");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee1, 5, 5, "Yes", 6, 6));
                log("assertion passed for leave resumption");

                BasePage.clickMenuIcon();
                log("clicked on menu icon");

                hc.clickHRCore();
                log("clicked on hr core link");

                hc.clickEmployee();
                log("clicked on employee link");

                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();
                log("clicked on time off tab");

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void deleteEarlyLeaveResumptionWithEncashDays()
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
                BasePage.performAction(5, leave.employee1, "Cancel Resumption");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void verifyEarlyLeaveResumptionWithPaidDays()
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
            double expLeaveBal = LeaveBal;

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
                log("provided payment type");

                lp.clkView();
                log("clicked on view btn");

                lp.clickApprove();
                log("clicked on approve btn");

                lp.clickEditResumption();
                log("clicked on edit resumption btn");

                BasePage.switchTab();
                log("switched to leave resumption tab");

                LeaveResumptionPage lrp = new LeaveResumptionPage();
                lrp.provideResumptionDate(leave.expEarlyResumptionDate);
                log("provided resumption date");

                lrp.providePaidDays(leave.paidDays);
                log("provided paid days");

                BasePage.clickOnViewTxn();
                log("clicked on view btn");

                BasePage.waitTS(2);

                lp.clickResume();
                log("clicked on resume btn");

                BasePage.waitTS(2);

                BasePage.closeUnwantedTab();
                log("switched to leave tab");

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                log("navigated back to leave page");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee1, 5, 5, "Yes", 6, 6));
                log("assertion passed for leave resumption");

                BasePage.clickMenuIcon();
                log("clicked on menu icon");

                hc.clickHRCore();
                log("clicked on hr core link");

                hc.clickEmployee();
                log("clicked on employee link");

                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();
                log("clicked on time off tab");

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void deleteEarlyLeaveResumptionWithPaidDays()
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
                BasePage.performAction(5, leave.employee1, "Cancel Resumption");
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

    //region Late Leave Resumption
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 7)
    public void verifyLateLeaveResumptionWithUnpaidDays()
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
                log("provided payment type");

                lp.clkView();
                log("clicked on view btn");

                lp.clickApprove();
                log("clicked on approve btn");

                lp.clickEditResumption();
                log("clicked on edit resumption btn");

                BasePage.switchTab();
                log("switched to leave resumption tab");

                //leave resumption page
                LeaveResumptionPage lrp = new LeaveResumptionPage();
                lrp.provideResumptionDate(leave.expLateResumptionDate);
                log("provided resumption date");

                BasePage.clickOnViewTxn();
                log("clicked on view btn");

                BasePage.waitTS(2);

                lp.clickResume();
                log("clicked on resume btn");

                BasePage.waitTS(2);

                BasePage.closeUnwantedTab();
                log("switched to leave tab");

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                log("navigated back to leave page");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee1, 5, 5, "Yes", 6, 6));
                log("assertion passed for leave resumption");

                //verify the leave balance
                BasePage.clickMenuIcon();
                log("clicked on menu icon");

                hc.clickHRCore();
                log("clicked on hr core link");

                hc.clickEmployee();
                log("clicked on employee link");

                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();
                log("clicked on time off tab");

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 8)
    public void deleteLateLeaveResumptionWithUnpaidDays()
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
                BasePage.performAction(5, leave.employee1, "Cancel Resumption");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 9)
    public void verifyLateLeaveResumptionWithPaidDays()
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
            double expLeaveBal = LeaveBal - 2;

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
                log("provided payment type");

                lp.clkView();
                log("clicked on view btn");

                lp.clickApprove();
                log("clicked on approve btn");

                lp.clickEditResumption();
                log("clicked on edit resumption btn");

                BasePage.switchTab();
                log("switched to leave resumption tab");

                LeaveResumptionPage lrp = new LeaveResumptionPage();
                lrp.provideResumptionDate(leave.expLateResumptionDate);
                log("provided resumption date");

                lrp.providePaidDays(leave.paidDays);
                log("provided paid days");

                BasePage.clickOnViewTxn();
                log("clicked on view btn");

                BasePage.waitTS(2);

                lp.clickResume();
                log("clicked on resume btn");

                BasePage.waitTS(2);

                BasePage.closeUnwantedTab();
                log("switched to leave tab");

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                log("navigated back to leave page");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee1, 5, 5, "Yes", 6, 6));
                log("assertion passed for leave resumption");

                BasePage.clickMenuIcon();
                log("clicked on menu icon");

                hc.clickHRCore();
                log("clicked on hr core link");

                hc.clickEmployee();
                log("clicked on employee link");

                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();
                log("clicked on time off tab");

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 10)
    public void deleteLateLeaveResumptionWithPaidDays()
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
                BasePage.performAction(5, leave.employee1, "Cancel Resumption");
                BasePage.performAction(5, leave.employee1, "Amend");
                Assert.assertFalse(BasePage.validateListing(leave.employee1, 5, 5));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 11)
    public void verifyLateLeaveResumptionWithGrantDays()
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
                log("provided payment type");

                lp.clkView();
                log("clicked on view btn");

                lp.clickApprove();
                log("clicked on approve btn");

                lp.clickEditResumption();
                log("clicked on edit resumption btn");

                BasePage.switchTab();
                log("switched to leave resumption tab");

                LeaveResumptionPage lrp = new LeaveResumptionPage();
                lrp.provideResumptionDate(leave.expLateResumptionDate);
                log("provided resumption date");

                lrp.provideGrantDays(leave.grantDays);
                log("provided paid days");

                BasePage.clickOnViewTxn();
                log("clicked on view btn");

                BasePage.waitTS(2);

                lp.clickResume();
                log("clicked on resume btn");

                BasePage.waitTS(2);

                BasePage.closeUnwantedTab();
                log("switched to leave tab");

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                log("navigated back to leave page");

                Assert.assertTrue(BasePage.validateListing2Fields(leave.employee1, 5, 5, "Yes", 6, 6));
                log("assertion passed for leave resumption");

                BasePage.clickMenuIcon();
                log("clicked on menu icon");

                hc.clickHRCore();
                log("clicked on hr core link");

                hc.clickEmployee();
                log("clicked on employee link");

                BasePage.navigateToEmployee(leave.employee1);
                ep.clkTimeOff();
                log("clicked on time off tab");

                Assert.assertEquals(ep.extractValueFromText(3), expLeaveBal);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 12)
    public void deleteLateLeaveResumptionWithGrantDays()
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
                BasePage.performAction(5, leave.employee1, "Cancel Resumption");
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