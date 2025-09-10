package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.OvertimeModel;
import pageObjects.HRMS.Payroll.OvertimePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.DateUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class OvertimeTest extends BaseTest
{

    @Test(groups = {"regression", "functional"}, retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createNormalOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createNormalOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                log("clicked on overtime");

                op.clickNew();
                log("clicked on new");

                op.provideEmp(ot.employee);
                log("employee selected");

                op.provideEffectiveDate(ot.effectiveDate);
                log("provideEffectiveDate");

                op.provideOvertimeDate(ot.overtimeDate);
                log("provideOvertimeDate");

                op.provideOvertimeType(ot.overtimeType);
                log("provideOvertimeType");

                op.provideHrs(ot.overtimeHrs);
                log("provideHrs");

                BasePage.provideDescription(ot.remarks);
                log("description provided");

                op.clickApproveBack();
                log("clicked on approve");

                Assert.assertTrue(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2,
                        ot.expectedOvertimeAmt, 8, 8), "Overtime creation failed: " + ot.employee);
                log("Verified: Overtime created successfully: " + ot.employee + ", Overtime Amount: " + ot.expectedOvertimeAmt);
                //Assert.assertTrue(BasePage.validateListing(ot.employee, 7, 7));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = {"regression", "functional"}, retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteNormalOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createNormalOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                log("clicked on overtime");

                BasePage.performAction(7, ot.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2), "Overtime deletion failed: " + ot.employee);
                log("Verified: Overtime deleted successfully: " + ot.employee);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void createWeekendOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createWeekendOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                log("clicked on overtime");

                op.clickNew();
                log("clicked on new");

                op.provideEmp(ot.employee);
                log("employee selected");

                op.provideEffectiveDate(ot.effectiveDate);
                log("provideEffectiveDate");

                op.provideOvertimeDate(ot.overtimeDate);
                log("provideOvertimeDate");

                op.provideOvertimeType(ot.overtimeType);
                log("provideOvertimeType");

                op.provideHrs(ot.overtimeHrs);
                log("provideHrs");

                BasePage.provideDescription(ot.remarks);
                log("description provided");

                op.clickApproveBack();
                log("clicked on approve");

                Assert.assertTrue(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2,
                        ot.expectedOvertimeAmt, 8, 8), "Overtime creation failed: " + ot.employee);
                log("Verified: Overtime created successfully: " + ot.employee + ", Overtime Amount: " + ot.expectedOvertimeAmt);
                //Assert.assertTrue(BasePage.validateListing(ot.employee, 7, 7));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void deleteWeekendOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createWeekendOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                log("clicked on overtime");

                BasePage.performAction(7, ot.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2), "Overtime deletion failed: " + ot.employee);
                log("Verified: Overtime deleted successfully: " + ot.employee);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void createHolidayOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createHolidayOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                log("clicked on overtime");

                op.clickNew();
                log("clicked on new");

                op.provideEmp(ot.employee);
                log("employee selected");

                op.provideEffectiveDate(ot.effectiveDate);
                log("provideEffectiveDate");

                op.provideOvertimeDate(ot.overtimeDate);
                log("provideOvertimeDate");

                op.provideOvertimeType(ot.overtimeType);
                log("provideOvertimeType");

                op.provideHrs(ot.overtimeHrs);
                log("provideHrs");

                BasePage.provideDescription(ot.remarks);
                log("description provided");

                op.clickApproveBack();
                log("clicked on approve");

                Assert.assertTrue(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2,
                        ot.expectedOvertimeAmt, 8, 8), "Overtime creation failed: " + ot.employee);
                log("Verified: Overtime created successfully: " + ot.employee + ", Overtime Amount: " + ot.expectedOvertimeAmt);
                // Assert.assertTrue(BasePage.validateListing(ot.employee, 7, 7));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void deleteHolidayOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createHolidayOvertime",
                    OvertimeModel.class);
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                log("clicked on overtime");

                BasePage.performAction(7, ot.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2), "Overtime deletion failed: " + ot.employee);
                log("Verified: Overtime deleted successfully: " + ot.employee);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}