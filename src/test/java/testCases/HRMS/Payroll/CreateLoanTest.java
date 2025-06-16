package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.LoanPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.RetryAnalyzer;

public class CreateLoanTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void verifyLoan()
	{
		try
		{
			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// loan pg
			LoanPage lp = new LoanPage();
			lp.clickLoan();
			logger.info("clicked on loan");

			lp.clickNew();
			logger.info("clicked on new btn");

			lp.provideEmp("vaibhav");
			logger.info("emp selected");

			lp.provideEffectiveDate("11");
			logger.info("provideEffectiveDate");

			lp.provideLoanType("car");
			logger.info("loan type selected");

//			lp.clkloanRepaymentStartPeriodDD();
//			logger.info("clicked on loanRepaymentStartPeriodDD");
//			lp.setLoanRepaymentStartPeriod();
//			logger.info("provided loan repayment start period");
//			lp.provideLoanAmt();
//			logger.info("loan amt entered");
//			lp.provideAmountOfInstallments();
//			logger.info("entered amt of installment");
//			lp.clkView();
//			logger.info("clicked on view");
//			lp.clkApprove();
//			logger.info("clicked on approved");
//
//			Assert.assertTrue(lp.isTxnCreated());

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}