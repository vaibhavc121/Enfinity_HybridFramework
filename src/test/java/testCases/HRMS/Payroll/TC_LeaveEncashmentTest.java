package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.LeaveEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import testBase.BaseClass;

public class TC_LeaveEncashmentTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyLeaveEncashment()
	{
		try
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//Leave Encashment pg
			LeaveEncashmentPage le=new LeaveEncashmentPage(driver);
			le.clkLeaveEncashment();
			le.clkNewBtn();
			le.clkEmpDD();
			le.slctEmp();
			le.clkLeaveTypeDD();
			le.slctLeaveType();
			le.providePaidDays();
			le.clkViewBtn();
			
			Assert.assertTrue(le.isTxnCreated());
			
			
			
			
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
