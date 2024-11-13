package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.LeavePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import testBase.BaseClass;

public class TC_LeaveTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyLeave()
	{
		try 
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//leave pg
			LeavePage lp=new LeavePage(driver);
			lp.clkLeave();
			logger.info("clicked on leave");
			lp.clkNewBtn();
			logger.info("clicked on new btn");
			lp.clkEmpDD();
			logger.info("clicked on empl dd");
			lp.slctEmp();
			logger.info("emp selected");
			lp.provideEffectiveDt();
			logger.info("provided effective date");
			lp.clkLeaveTypeDD();
			logger.info("clicked on leave type dd");
			lp.slctLeaveType();
			logger.info("leave type selected");
			lp.provideFromDt();
			logger.info("provided from date");
			lp.provideUpToDt();
			logger.info("provided upto date");
			lp.clkView();
			logger.info("clicked on view btn");
			lp.clkApprove();
			logger.info("clicked on approve btn");
			lp.clkLeaveLink();
			logger.info("clicked on leave link");
			
			Assert.assertTrue(lp.isLeaveCreated());
			
			
		} 
		catch (Exception e) 
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
