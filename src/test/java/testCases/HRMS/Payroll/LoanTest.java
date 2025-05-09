package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.LoanPage;
import pageObjects.HRMS.Payroll.PayrollPage;

public class LoanTest extends BaseTest
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
			logger.info("clicked on loan");
			lp.clkNew();
			logger.info("clicked on new btn");
			lp.clkEmpDD();
			logger.info("clicked on emp dd");
			lp.slctEmp();
			logger.info("emp selected");
			lp.clkLoanTypeDD();
			logger.info("clicked on loan type dd");
			lp.slctLoanType();
			logger.info("loan type selected");
//			lp.clkloanRepaymentStartPeriodDD();
//			logger.info("clicked on loanRepaymentStartPeriodDD");
			lp.setLoanRepaymentStartPeriod();
			logger.info("provided loan repayment start period");
			lp.provideLoanAmt();
			logger.info("loan amt entered");
			lp.provideAmountOfInstallments();
			logger.info("entered amt of installment");
			lp.clkView();
			logger.info("clicked on view");
			lp.clkApprove();
			logger.info("clicked on approved");
			

			Assert.assertTrue(lp.isTxnCreated());
		
			
			
			
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
