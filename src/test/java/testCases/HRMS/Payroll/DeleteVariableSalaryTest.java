package testCases.HRMS.Payroll;

import java.util.List;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.VariableSalaryPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class DeleteVariableSalaryTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteVariableSalary()
    {
        try
        {
            String variableSalFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(variableSalFile,
                    "createVariableSal", VariableSalModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // variable sal pg
            VariableSalaryPage vs = new VariableSalaryPage(driver);

            for (VariableSalModel varSal : leaveRequestData)
            {
                vs.clkVariableSal();
                logger.info("clicked on variable sal");

                BasePage.performAction(6, varSal.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(varSal.employee, 6, 6));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}