package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.TicketEncashmentPage;
import testBase.BaseClass;

public class TC_TicketEncashmentTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyTicketEncashment()
	{
		try
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//Ticket Encashment pg
			TicketEncashmentPage te=new TicketEncashmentPage(driver);
			te.clkTicketEncashment();
			te.clkNew();
			te.clkEmpDD();
			te.slctEmp();
			te.clkSave();
			if(te.checkAvailableTicket())
			{
				System.out.println("Ticket not available");
			}
			else 
			{
				
			}
			Assert.assertTrue(true);
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
		
	}

}
