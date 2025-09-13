package testCases.HRMS.Payroll;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.VariableSalaryPage;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class CreateVariableSalaryTest extends BaseTest
{
    @Test(groups = "regression", dataProvider = "variableSal", dataProviderClass = DataProviders.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyVariableSalary(String emp, String remarks, String effectiveDate, String salComponent, String amt) // ,
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // variable sal pg
            VariableSalaryPage vs = new VariableSalaryPage();
            vs.clkVariableSal();
            log("clicked on variable sal");
            vs.clkNewBtn();
            log("clicked on new btn");
//			vs.clkEmpDD();
//			log("clicked on emp dd");
//			vs.slctEmp();
//			log("employee selected");
//			vs.provideRemarks(remarks);
//			vs.clkSave();
//			log("clicked on save button");
//			vs.clkNewline();
//			log("clicked on new line");
//			vs.clkSalaryCompDD();
//			log("clicked on sal component dd");
//			vs.slctSalComp();
//			log("selected sal component");
//			vs.clkAmt();
//			log("clicked on amt textbox");
//			vs.provideAmt(amt);
//			log("amt provided");
//			vs.clkViewBtn();
//			log("clicked on view btn");
//			vs.clkApproveBtn();
//			log("clicked on approved button");
//			vs.clkVariableSalLabel();
            log("clicked on variable sal label");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}