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
			logger.info("clicked on leave incashment");
			le.clkNewBtn();
			logger.info("clicked on new btn");
			le.clkEmpDD();
			logger.info("clicked on emp dd");
			le.slctEmp();
			logger.info("employee selected");
			le.clkLeaveTypeDD();
			logger.info("clicked on leave type dd");
			le.slctLeaveType();
			logger.info("selected leave type");
			le.providePaidDays();
			logger.info("provided paid days");
			le.clkViewBtn();
			logger.info("clicked on view btn");
			le.clkApproveBtn();
			logger.info("clicked on approve btn");
			
			Assert.assertTrue(le.isTxnCreated());
			
			
			
			
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
