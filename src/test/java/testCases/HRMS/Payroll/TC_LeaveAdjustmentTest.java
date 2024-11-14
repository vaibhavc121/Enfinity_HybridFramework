package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.LeaveAdjustmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import testBase.BaseClass;

public class TC_LeaveAdjustmentTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyLeaveAdjustment()
	{
		try 
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//leave adjustment pg
			LeaveAdjustmentPage la=new LeaveAdjustmentPage(driver);
			la.clkLeaveAdj();
			la.clkNewBtn();
			la.clkEmpDD();
			la.slctEmp();
			la.clkLeaveTypeDD();
			la.slctLeaveType();
			la.providePaidDaysValue();
			la.provideUnpaidDaysValue();
			la.provideRemarks();
			la.clkViewBtn();
			la.clkApproveBtn();
			
			Assert.assertTrue(la.isTxnCreated());
			
			
		} 
		catch (Exception e) 
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
	
}
