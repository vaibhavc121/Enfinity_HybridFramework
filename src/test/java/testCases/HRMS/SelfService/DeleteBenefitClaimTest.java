package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.BenefitClaimModel;
import pageObjects.HRMS.SelfService.BenefitClaimPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteBenefitClaimTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteBenefitClaim()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<BenefitClaimModel> benefitClaimData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"deleteBenefitClaim", BenefitClaimModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Benefit Claim page
			BenefitClaimPage bc = new BenefitClaimPage(driver);
			bc.clickBenefitClaim();

			BasePage.deleteTxn(9, "active");
			Assert.assertFalse(BasePage.validateListing("active", 9, 9));

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
