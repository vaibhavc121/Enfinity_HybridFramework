package testCases.HRMS.Payroll;

import base.BasePage;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.IndemnityAdjustmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.ReportsPage;
import pageObjects.HRMS.Payroll.TicketAdjustmentPage;
import utilities.DateUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class IndemnityAdjustmentTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.IndemnityAdjustmentModel> indemnityAdjData = JsonUtils.convertJsonListDataModel(payrollFile,
            "createIndemnityAdjustment", PayrollModel.IndemnityAdjustmentModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createIndemnityAdjustment()
    {
        try
        {
            for (PayrollModel.IndemnityAdjustmentModel data : indemnityAdjData)
            {
                // payroll pg
                PayrollPage pp = new PayrollPage();
                pp.clkPayroll();
                log("clicked on payroll link");

                // getting balance from the report
                pp.clickReports();
                log("clicked on reports");
                ReportsPage rp = new ReportsPage();
                rp.openReport(data.reportName);
                double indemnityBal = rp.getIndemnityBalance(data.employee, data.asOnDate, data.indemnityType);
                double expIndemnityBal = indemnityBal + 1;

                // payroll pg
                pp.clkPayroll();
                log("clicked on payroll link");
                pp.clkTxn();
                log("clicked on txn");

                // Indemnity Adjustment pg
                IndemnityAdjustmentPage ia = new IndemnityAdjustmentPage();

                ia.clkIndemnityAdjustment();
                log("clicked on ind adj");

                ia.clkNewBtn();
                log("clicked on new btn");

                ia.provideEffectiveDate(data.effectiveDate);
                log("effective date provided");

                ia.provideEmployee(data.employee);
                log("emp selected");

                ia.provideIndemnity(data.indemnityType);
                log("indemnity selected");

                ia.providePaidDays(data.paidDays);
                log("paid days provided");

                ia.clkView();
                log("clicked on view");

                ia.clkApprove();
                log("clicked on approve");

                Assert.assertTrue(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2, "Approved", 7, 7), "Indemnity Adjustment creation failed");

                pp.clickReports();
                BasePage.closeUnwantedTab();
                rp.openReport(data.reportName);

                Assert.assertEquals(rp.getIndemnityBalance(data.employee, data.asOnDate, data.indemnityType), expIndemnityBal, "Ticket Adjustment creation failed");
                log("Verified: Indemnity Adjustment created successfully for emp: " + data.employee);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteIndemnityAdjustment()
    {
        for (PayrollModel.IndemnityAdjustmentModel data : indemnityAdjData)
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");

            pp.clkTxn();
            log("clicked on txn");

            // indemnity adjustment pg
            IndemnityAdjustmentPage ea = new IndemnityAdjustmentPage();
            ea.clkIndemnityAdjustment();
            log("clicked on indemnity adjustment");

            BasePage.performAction(2, DateUtils.getCurrentDate("dd-MMM-yyyy"), "Amend");
            try
            {
                ea.clickIndemnityAdjustmentLabel();
            } catch (Exception e)
            {

            }
            //Assert.assertFalse(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2));
            Assert.assertFalse(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2, "Approved", 7, 7), "Indemnity Adjustment deletion failed");
            log("Verified: Indemnity Adjustment deleted successfully for date: " + DateUtils.getCurrentDate("dd-MMM-yyyy") + "for emp: " + data.employee);
        }
    }
}