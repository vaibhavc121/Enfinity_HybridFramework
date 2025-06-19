package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import base.SelenideBasePage;
import com.codeborne.selenide.WebDriverRunner;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.LoanPage;
import pageObjects.HRMS.Payroll.OvertimePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteLoanTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteLoan()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.LoanModel> loanData = JsonUtils.convertJsonListDataModel(payrollFile, "createLoan",
                    PayrollModel.LoanModel.class);

            driver= WebDriverRunner.getWebDriver();

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
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

                SelenideBasePage.performAction(6, loan.employee, "Amend");
                Assert.assertFalse(SelenideBasePage.validateListing(loan.employee, 6, 6));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

}