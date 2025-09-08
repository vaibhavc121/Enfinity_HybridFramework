package testCases.HRMS.Payroll;

import java.util.List;

import factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.TicketAdjustmentModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.ReportsPage;
import pageObjects.HRMS.Payroll.TicketAdjustmentPage;
import utilities.*;

public class TicketAdjustmentTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<TicketAdjustmentModel> ticketAdjData = JsonUtils.convertJsonListDataModel(payrollFile,
            "createTicketAdjustment", TicketAdjustmentModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createTicketAdjustment()
    {
        try
        {
            for (TicketAdjustmentModel ticketAdj : ticketAdjData)
            {
                // payroll pg
                PayrollPage pp = new PayrollPage();
                pp.clkPayroll();
                log("clicked on payroll link");

                // getting balance from the report
                pp.clickReports();
                log("clicked on reports");
                ReportsPage rp = new ReportsPage();
                rp.openReport(ticketAdj.reportName);
                double ticketBal = rp.getTicketBalance(ticketAdj.employee);
                double expTicketBal = ticketBal + 1;

                pp.clkPayroll();
                log("clicked on payroll link");
                pp.clkTxn();
                log("clicked on txn");

                // ticket adjustment pg
                TicketAdjustmentPage ta = new TicketAdjustmentPage();
                ta.clickTicketAdjustment();
                log("clicked on ticket adjustment");
                ta.clickNew();
                log("clicked on new");
                ta.provideEmployee(ticketAdj.employee);
                log("emp selected");
                ta.selectPaymentType(ticketAdj.paymentType);
                log("payment type selected");
                ta.clickSave();
                log("clicked on save");
                ta.provideIssueTickets(ticketAdj.issueTickets);
                log("provided issue ticket");
                ta.clickView();
                log("clicked on view");
                BasePage.clickOnApprove();
                log("clicked on approve");

                //BasePage.clickOnHamburgerMenu();
                pp.clickReports();
                BasePage.closeUnwantedTab();
                rp.openReport(ticketAdj.reportName);

                Assert.assertEquals(rp.getTicketBalance(ticketAdj.employee), expTicketBal, "Ticket Adjustment creation failed");
                log("Verified: Ticket Adjustment created successfully for emp: " + ticketAdj.employee);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteTicketAdjustment()
    {
        for (TicketAdjustmentModel ticketAdj : ticketAdjData)
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");

            pp.clkTxn();
            log("clicked on txn");

            // ticket adjustment pg
            TicketAdjustmentPage ta = new TicketAdjustmentPage();
            ta.clickTicketAdjustment();
            log("clicked on ticket adjustment");

            BasePage.performAction(2, DateUtils.getCurrentDate("dd-MMM-yyyy"), "Amend");
            try
            {
                ta.clickTicketAdjustmentLabel();
            } catch (Exception e)
            {

            }
            //Assert.assertFalse(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2));
            Assert.assertFalse(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2, "Approved", 7, 7), "Ticket Adjustment deletion failed");
            log("Verified: Ticket Adjustment deleted successfully for date: " + DateUtils.getCurrentDate("dd-MMM-yyyy") + "for emp: " + ticketAdj.employee);
        }
    }
}