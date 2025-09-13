package testCases.HRMS.SelfService;

import base.BasePage;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.LoanRequestModel;
import pageObjects.HRMS.SelfService.LoanRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class LoanRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLoanRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<LoanRequestModel> loanRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createLoanRequest", LoanRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("Clicked on Self Service");
            ss.clickTransactions();
            log("Clicked on Transactions");

            // Loan Request page
            LoanRequestPage lr = new LoanRequestPage();

            for (LoanRequestModel loan : loanRequestData)
            {
                lr.clickLoanRequest();
                log("Clicked on Loan Request");

                lr.clickNew();
                log("Clicked on New button");

                lr.clickPlusBtn();
                log("Clicked on Plus button");

                lr.provideLoanAmt(loan.loanAmt);
                log("Provided Loan Amount: " + loan.loanAmt);

                lr.provideInstallmentAmt(loan.installmentAmt);
                log("Provided Installment Amount: " + loan.installmentAmt);

                lr.selectRepaymentStartPeriod(loan.repaymentStartPeriod);
                log("Selected Repayment Start Period: " + loan.repaymentStartPeriod);

                lr.provideRemarks(loan.remarks);
                log("Provided Remarks: " + loan.remarks);

                lr.clickSave();
                log("Clicked on Save button");

                Assert.assertTrue(lr.isTxnCreated(loan.loanType, loan.loanAmt), "Loan Request creation failed for Loan Type: " + loan.loanType +
                        " and Loan Amount: " + loan.loanAmt);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLoanRequest()
    {
        try
        {
            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            ss.clickTransactions();

            // LoanRequestPage
            LoanRequestPage lr = new LoanRequestPage();
            lr.clickLoanRequest();

            BasePage.deleteTxn(7, "active");
            Assert.assertFalse(BasePage.validateListing("active", 7, 7));
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}