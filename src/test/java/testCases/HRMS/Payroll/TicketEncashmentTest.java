package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.TicketEncashmentModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.TicketEncashmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class TicketEncashmentTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createTicketEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<TicketEncashmentModel> ticketEncashmentData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createTicketEncashment", TicketEncashmentModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Ticket Encashment pg
            TicketEncashmentPage te = new TicketEncashmentPage(driver);

            for (TicketEncashmentModel ticketEncashment : ticketEncashmentData)
            {
                te.clickTicketEncashment();
                log("clicked on Ticket Encashment link");

                te.clickNew();
                log("clicked on new button");

                te.provideEmp(ticketEncashment.employee);
                log("Provided employee: " + ticketEncashment.employee);
                // te.provideEffectiveDate(ticketEncashment.effectiveDate);
                te.providePaymentType(ticketEncashment.paymentType);
                log("Provided payment type: " + ticketEncashment.paymentType);

                te.clickSave();
                log("clicked on save button");

                te.provideIssueTickets(ticketEncashment.issueTickets);
                log("Provided issue tickets: " + ticketEncashment.issueTickets);

                te.clickSave1();
                log("clicked on save button");

                te.clickView();
                log("clicked on view button");

                te.clickApproveBack();
                log("clicked on approve & navigate back to listing");

                Assert.assertTrue(BasePage.validateListing2Fields(ticketEncashment.employee, 6, 6, "Approved", 7, 7), "Ticket Encashment creation failed");
                log("Verified: Ticket Encashment created successfully: " + ticketEncashment.employee);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteTicketEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<TicketEncashmentModel> ticketEncashmentData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createTicketEncashment", TicketEncashmentModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Ticket Encashment pg
            TicketEncashmentPage te = new TicketEncashmentPage(driver);

            for (TicketEncashmentModel ticketEncashment : ticketEncashmentData)
            {
                te.clickTicketEncashment();
                log("clicked on Ticket Encashment link");

                BasePage.performAction(7, "Approved", "Amend");
                Assert.assertFalse(BasePage.validateListing2Fields(ticketEncashment.employee, 6, 6, "Approved", 7, 7), "Ticket Encashment deletion failed");
                log("Verified: Ticket Encashment deleted successfully: " + ticketEncashment.employee);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}