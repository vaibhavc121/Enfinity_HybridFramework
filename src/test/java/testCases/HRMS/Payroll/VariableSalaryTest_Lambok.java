package testCases.HRMS.Payroll;

import java.util.List;

import base.BasePage;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.PayrollPage;

import pageObjects.HRMS.Payroll.VariableSalaryPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class VariableSalaryTest_Lambok extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void verifyVariableSalary()
    {
        try
        {
            String variableSalFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(variableSalFile,
                    "createVariableSal", VariableSalModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // variable sal pg
            VariableSalaryPage vs = new VariableSalaryPage();

            for (VariableSalModel varSal : leaveRequestData)
            {
                vs.clkVariableSal();
                log("clicked on variable sal");
                vs.clkNewBtn();
                log("clicked on new btn");
                vs.provideEmp(varSal.employee);
                log("employee selected");
                vs.provideEffectiveDate(varSal.effectiveDate);
                //vs.provideRemarks(varSal.remarks);
                vs.clkSave();
                log("clicked on save button");
                vs.clkNewline();
                log("clicked on new line");
                vs.provideSalaryComp(varSal.salComponent);
                log("selected sal component");
                vs.provideAmt(varSal.amt);
                log("amt provided");
                vs.clkViewBtn();
                log("clicked on view btn");
                vs.clkApproveBack();
                log("clicked on approved button");

                Assert.assertTrue(BasePage.validateListing2Fields(varSal.employee, 6, 6, varSal.amt, 7, 7));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteVariableSalary()
    {
        try
        {
            String variableSalFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(variableSalFile,
                    "createVariableSal", VariableSalModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // variable sal pg
            VariableSalaryPage vs = new VariableSalaryPage();

            for (VariableSalModel varSal : leaveRequestData)
            {
                vs.clkVariableSal();
                log("clicked on variable sal");

                BasePage.performAction(6, varSal.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(varSal.employee, 6, 6));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}