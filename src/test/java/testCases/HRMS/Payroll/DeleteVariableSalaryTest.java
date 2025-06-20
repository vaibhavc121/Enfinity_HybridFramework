package testCases.HRMS.Payroll;

import java.util.List;

import base.SelenideBasePage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pages.HRMS.VariableSalaryPage;
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

            driver = WebDriverRunner.getWebDriver();

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // variable sal pg
            pages.HRMS.VariableSalaryPage vs = new VariableSalaryPage();

            for (VariableSalModel varSal : leaveRequestData)
            {
                vs.clkVariableSal();
                logger.info("clicked on variable sal");

                SelenideBasePage.performAction(6, varSal.employee, "Amend");
                Assert.assertFalse(SelenideBasePage.validateListing(varSal.employee, 6, 6));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}