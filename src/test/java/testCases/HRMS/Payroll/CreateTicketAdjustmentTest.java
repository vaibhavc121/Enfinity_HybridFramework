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
				PayrollPage pp = new PayrollPage(driver);
				pp.clkPayroll();
				logger.info("clicked on payroll link");

				// getting balance from the report
				pp.clickReports();
				ReportsPage rp = new ReportsPage(driver);
				rp.openReport(ticketAdj.reportName);
				double ticketBal = rp.getTicketBalance(ticketAdj.employee);
				double expTicketBal = ticketBal + 1;

				pp.clkPayroll();
				BasePage.clickOnHamburgerMenu();
				logger.info("clicked on payroll link");
				pp.clkTxn();
				logger.info("clicked on txn");

				// ticket adjustment pg
				TicketAdjustmentPage ta = new TicketAdjustmentPage(driver);
				ta.clickTicketAdjustment();
				logger.info("clicked on ticket adjustment");
				ta.clickNew();
				logger.info("clicked on new");
				ta.provideEmployee(ticketAdj.employee);
				logger.info("emp selected");
				ta.selectPaymentType(ticketAdj.paymentType);
				logger.info("payment type selected");
				ta.clickSave();
				logger.info("clicked on save");
				ta.provideIssueTickets(ticketAdj.issueTickets);
				logger.info("provided issue ticket");
				ta.clickView();
				logger.info("clicked on view");
				BasePage.clickOnApprove();
				logger.info("clicked on approve");

				BasePage.clickOnHamburgerMenu();
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
