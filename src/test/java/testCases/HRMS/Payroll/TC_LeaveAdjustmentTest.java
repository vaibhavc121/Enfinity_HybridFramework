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
			logger.info("clicked on leave adj");
			la.clkNewBtn();
			logger.info("clicked on new btn");
			la.clkEmpDD();
			logger.info("clicked on txn");
			la.slctEmp();
			logger.info("employee selected");
			la.clkLeaveTypeDD();
			logger.info("clicked on leave type dd");
			la.slctLeaveType();
			logger.info("leave type selected");
			la.providePaidDaysValue();
			logger.info("provided paid days value");
			la.provideUnpaidDaysValue();
			logger.info("provided unpaid days value");
			la.provideRemarks();
			logger.info("provided remarks");
			la.clkViewBtn();
			logger.info("clicked on view btn");
			la.clkApproveBtn();
			logger.info("clicked on approve btn");
			
			Assert.assertTrue(la.isTxnCreated());
			
			
		} 
		catch (Exception e) 
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
	
}
