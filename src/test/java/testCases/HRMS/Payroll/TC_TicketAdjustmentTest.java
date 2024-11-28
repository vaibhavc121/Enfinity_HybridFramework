package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.TicketAdjustmentPage;
import testBase.BaseClass;

public class TC_TicketAdjustmentTest extends BaseClass
{
	
	@Test(groups = "regression")
	public void verifyTicketAdjustment()
	{
		try
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//ticket adjustment pg
			TicketAdjustmentPage ta=new TicketAdjustmentPage(driver);
			ta.clkTicketAdjustment();
			ta.clkNew();
			ta.clkEmpDD();
			ta.slctEmp();
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
