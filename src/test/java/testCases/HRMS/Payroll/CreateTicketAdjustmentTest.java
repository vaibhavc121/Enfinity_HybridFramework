package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveAdjustmentModel;
import models.Payroll.Payroll.PayrollModel.TicketAdjustmentModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.ReportsPage;
import pageObjects.HRMS.Payroll.TicketAdjustmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateTicketAdjustmentTest extends BaseTest
{

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void verifyTicketAdjustment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<TicketAdjustmentModel> ticketAdjData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createTicketAdjustment", TicketAdjustmentModel.class);

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
                rp.openReport(ticketAdj.reportName);

                Assert.assertEquals(rp.getTicketBalance(ticketAdj.employee), expTicketBal);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}