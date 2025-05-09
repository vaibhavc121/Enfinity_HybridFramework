package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.TicketAdjustmentPage;

public class TicketAdjustmentTest extends BaseTest
{

	@Test(groups = "regression")
	public void verifyTicketAdjustment()
	{
		try
		{
			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// ticket adjustment pg
			TicketAdjustmentPage ta = new TicketAdjustmentPage(driver);
			ta.clkTicketAdjustment();
			logger.info("clicked on ticket adjustment");
			ta.clkNew();
			logger.info("clicked on new");
			ta.clkEmpDD();
			logger.info("clicked on emp dd");
			ta.slctEmp();
			logger.info("emp selected");
			ta.clkPaymentTypeDD();
			logger.info("clicked on payment type dd");
			ta.slctPaymentType();
			logger.info("payment type selected");
			ta.clkSave();
			logger.info("clicked on save");
			ta.provideIssueTicket();
			logger.info("provided issue ticket");
			ta.clkView();
			logger.info("clicked on view");
			ta.clkApprove();
			logger.info("clicked on approve");

			Assert.assertTrue(ta.isTxnCreated());

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
