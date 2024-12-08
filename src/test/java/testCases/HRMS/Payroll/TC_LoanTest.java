package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.LoanPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import testBase.BaseClass;

public class TC_LoanTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyLoan()
	{
		try
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//loan pg
			LoanPage lp=new LoanPage(driver);
			lp.clkLoan();
			lp.clkNew();
			lp.clkEmpDD();
			lp.slctEmp();
			lp.clkLoanTypeDD();
			lp.slctLoanType();
			lp.clkloanRepaymentStartPeriodDD();
			lp.setLoanRepaymentStartPeriod();
			lp.provideLoanAmt();
			lp.provideAmountOfInstallments();
			lp.clkView();
			lp.clkApprove();
			lp.isTxnCreated();

			
			
			
			
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
