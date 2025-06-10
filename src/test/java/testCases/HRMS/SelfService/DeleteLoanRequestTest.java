package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pageObjects.HRMS.SelfService.LoanRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteLoanRequestTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteLoanRequest()
	{
		try
		{
			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// LoanRequestPage
			LoanRequestPage lr = new LoanRequestPage(driver);
			lr.clickLoanRequest();

			BasePage.deleteTxn(7, "active");
			Assert.assertFalse(BasePage.validateListing("active", 7, 7));
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
