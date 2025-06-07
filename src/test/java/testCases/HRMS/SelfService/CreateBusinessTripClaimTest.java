package testCases.HRMS.SelfService;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.BusinessTripClaimModel;
import pageObjects.HRMS.SelfService.BusinessTripClaimPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateBusinessTripClaimTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, enabled = false, description = "locator issue")
	public void createBusinessTripClaim()
	{
		try
		{
			String businessTripClaimFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<BusinessTripClaimModel> businessTripClaimData = JsonUtils.convertJsonListDataModel(
					businessTripClaimFile, "createBusinessTripClaim", BusinessTripClaimModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// expense claim page
			BusinessTripClaimPage ec = new BusinessTripClaimPage(driver);

			for (BusinessTripClaimModel businessTripClaim : businessTripClaimData)
			{
				ec.clickBusinessTripClaim();
				ec.clickNew();
				ec.clickSave();
				ec.scrollDownWebPage();
				ec.clickNewLine();
				ec.provideExpenseDate(businessTripClaim.expenseDate);
				ec.provideRemarks(businessTripClaim.remarks);
				// ec.clickExpenseClaimCategoryDD();
				// ec.selectExpenseClaimCategory(businessTripClaim.getClaimCategory());
				ec.provideExpenseClaimCategory(businessTripClaim.claimCategory);
				// ec.provideCurrency(businessTripClaim.getCurrency());
				ec.provideAmount(businessTripClaim.amount);
			}

			// Assert.assertTrue(ec.isTxnCreated());
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
