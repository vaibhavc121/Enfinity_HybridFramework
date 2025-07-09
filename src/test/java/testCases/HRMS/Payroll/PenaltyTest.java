package testCases.HRMS.Payroll;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PenaltyPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class PenaltyTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createPenaltyInDays()
    {
        try
        {
//            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
//            List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(payrollFile,
//                    "createVariableSal", VariableSalModel.class);
//
//            // payroll pg
//            PayrollPage pp = new PayrollPage(driver);
//            pp.clkPayroll();
//            log("clicked on payroll link");
//            pp.clkTxn();
//            log("clicked on txn");
//
//            // penalty pg
//            PenaltyPage pn = new PenaltyPage(driver);
//
//            pn.clickOnPenalty();
//            log("clicked on penalty link");
//
//            pn.clickNew();
//            log("clicked on new button");
//
//            pn.provideEmployee();
//            log("provided employee");
//
//            pn.providePenaltyDate();
//            log("provided penalty date");
//
//            pn.providePenaltyType();
//            log("provided penalty type");




        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }

    }

}