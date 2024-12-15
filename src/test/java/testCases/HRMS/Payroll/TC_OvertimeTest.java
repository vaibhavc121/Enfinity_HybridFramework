package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HRMS.Payroll.OvertimePage;
import pageObjects.HRMS.Payroll.PayrollPage;

public class TC_OvertimeTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyOvertime()
	{
		try
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//overtime pg
			OvertimePage op= new OvertimePage(driver);
			op.clkOvertime();
			logger.info("clicked on overtime");
			op.clkNew();
			logger.info("clicked on new");
			op.clkEmpDD();
			logger.info("clicked on emp dd");
			op.slctEmp();
			logger.info("employee selected");
			op.clickOverTimeDD();
			logger.info("clicked on overtime dd");
			op.slctOvertime();
			logger.info("overtime selected");
			op.provideHrs();
			logger.info("provided hrs");
			//op.clkPayBenefitDD();
			//op.slctPayBenefit();
			//op.clkLeaveType();
			//op.slctLeaveType();
			op.clkView();
			logger.info("clicked on view");
			op.clkApprove();
			logger.info("clicked on approve");
			
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
