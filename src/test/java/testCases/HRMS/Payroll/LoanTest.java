package testCases.HRMS.Payroll;

import base.BasePage;

import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.LoanPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class LoanTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLoan()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LoanModel> loanData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createLoan", PayrollModel.LoanModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // loan pg
            LoanPage lp = new LoanPage();

            for (PayrollModel.LoanModel loan : loanData)
            {
                lp.clickLoan();
                logger.info("clicked on loan");

                lp.clickNew();
                logger.info("clicked on new btn");

                lp.provideEmp(loan.employee);
                logger.info("emp selected");

                lp.provideEffectiveDate(loan.effectiveDate);
                logger.info("provideEffectiveDate");

                lp.provideLoanType(loan.loanType);
                logger.info("loan type selected");

                lp.provideRepaymentStartPeriod(loan.repaymentStartPeriod);
                logger.info("provided loan repayment start period");

                lp.provideLoanAmt(loan.loanAmt);
                logger.info("loan amt entered");

                lp.provideAmountOfInstallments(loan.amountOfInstallments);
                logger.info("entered amt of installment");

                lp.provideRemarks(loan.remarks);
                log("provideRemarks");

                lp.clickViewApproveBack();

                Assert.assertTrue(BasePage.validateListing2Fields(loan.employee, 6, 6, loan.loanAmt, 8, 8));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLoan()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LoanModel> loanData = JsonUtils.convertJsonListDataModel(payrollFile, "createLoan",
                    PayrollModel.LoanModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // Loan pg
            LoanPage lp = new LoanPage();

            for (PayrollModel.LoanModel loan : loanData)
            {
                lp.clickLoan();
                logger.info("clicked on loan");

                BasePage.performAction(6, loan.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(loan.employee, 6, 6));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}