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

public class DeleteOvertimeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteOvertime()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<OvertimeModel> overtimeData = JsonUtils.convertJsonListDataModel(payrollFile, "createOvertime",
                    OvertimeModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // overtime pg
            OvertimePage op = new OvertimePage(driver);

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