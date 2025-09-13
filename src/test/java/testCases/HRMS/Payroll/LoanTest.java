package testCases.HRMS.Payroll;

import base.BasePage;

import factory.LoggerFactory;
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
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // loan pg
            LoanPage lp = new LoanPage();

            for (PayrollModel.LoanModel loan : loanData)
            {
                lp.clickLoan();
                log("clicked on loan");

                lp.clickNew();
                log("clicked on new btn");

                lp.provideEmp(loan.employee);
                log("emp selected");

                lp.provideEffectiveDate(loan.effectiveDate);
                log("provideEffectiveDate");

                lp.provideLoanType(loan.loanType);
                log("loan type selected");

                lp.provideRepaymentStartPeriod(loan.repaymentStartPeriod);
                log("provided loan repayment start period");

                lp.provideLoanAmt(loan.loanAmt);
                log("loan amt entered");

                lp.provideAmountOfInstallments(loan.amountOfInstallments);
                log("entered amt of installment");

                lp.provideRemarks(loan.remarks);
                log("provideRemarks");

                lp.clickViewApproveBack();

                Assert.assertTrue(BasePage.validateListing2Fields(loan.employee, 6, 6, loan.loanAmt, 8, 8));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
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
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Loan pg
            LoanPage lp = new LoanPage();

            for (PayrollModel.LoanModel loan : loanData)
            {
                lp.clickLoan();
                log("clicked on loan");

                BasePage.performAction(6, loan.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(loan.employee, 6, 6));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}