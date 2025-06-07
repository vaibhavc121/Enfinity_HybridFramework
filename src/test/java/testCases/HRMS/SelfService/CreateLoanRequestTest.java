package testCases.HRMS.SelfService;

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

public class CreateLoanRequestTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createLoanRequest()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<LoanRequestModel> loanRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createLoanRequest", LoanRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Loan Request page
			LoanRequestPage lr = new LoanRequestPage(driver);

			for (LoanRequestModel loan : loanRequestData)
			{
				lr.clickLoanRequest();
				lr.clickNew();
				lr.clickPlusBtn();
				lr.provideLoanAmt(loan.loanAmt);
				lr.provideInstallmentAmt(loan.installmentAmt);
				lr.selectRepaymentStartPeriod(loan.repaymentStartPeriod);
				lr.provideRemarks(loan.remarks);
				lr.clickSave();

				Assert.assertTrue(lr.isTxnCreated(loan.loanType, loan.loanAmt));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
