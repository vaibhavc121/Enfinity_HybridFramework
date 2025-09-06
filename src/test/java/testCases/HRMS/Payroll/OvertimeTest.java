package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.OvertimeModel;
import pageObjects.HRMS.Payroll.OvertimePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class OvertimeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                logger.info("clicked on overtime");
                op.clickNew();
                logger.info("clicked on new");
                op.provideEmp(ot.employee);
                logger.info("employee selected");
                op.provideEffectiveDate(ot.effectiveDate);
                logger.info("provideEffectiveDate");
                op.provideOvertimeDate(ot.overtimeDate);
                logger.info("provideOvertimeDate");
                op.provideOvertimeType(ot.overtimeType);
                logger.info("provideOvertimeType");
                op.provideHrs(ot.overtimeHrs);
                logger.info("provideHrs");
                // op.clkPayBenefitDD();
                // op.slctPayBenefit();
                // op.clkLeaveType();
                // op.slctLeaveType();

                op.clickApproveBack();
                logger.info("clicked on approve");

                // Assert.assertTrue(BasePage.validateListing2Fields(ot.employee, 7, 7,
                // ot.expectedOvertimeAmt, 9, 9));
                Assert.assertTrue(BasePage.validateListing(ot.employee, 7, 7));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage();

            for (OvertimeModel ot : overtimeData)
            {
                op.clickOvertime();
                logger.info("clicked on overtime");

                BasePage.performAction(7, ot.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(ot.employee, 7, 7));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}