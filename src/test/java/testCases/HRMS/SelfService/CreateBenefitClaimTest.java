package testCases.HRMS.SelfService;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.BenefitClaimModel;
import pageObjects.HRMS.SelfService.BenefitClaimPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class CreateBenefitClaimTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createBenefitClaim()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<BenefitClaimModel> benefitClaimData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createBenefitClaim", BenefitClaimModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Benefit Claim page
			BenefitClaimPage bc = new BenefitClaimPage(driver);

			for (BenefitClaimModel benefitClaim : benefitClaimData)
			{
				// bc.scrollDownWebpage();
				bc.clickBenefitClaim();
				bc.clickNew();
				bc.provideClaimDate(benefitClaim.claimDate);
				bc.provideBenefitScheme(benefitClaim.benefitScheme);
				bc.provideClaimAmt(benefitClaim.claimAmount);
				bc.providePaymentType(benefitClaim.paymentType);
				bc.provideRemarks(benefitClaim.remarks);
				bc.clickSave();

				Assert.assertTrue(bc.isTxnCreated(benefitClaim.empName, benefitClaim.claimAmount));
				// ClassicAssert.isTrue(BasePage.isTransactionCreated());
				// ClassicAssert.isTrue(true);
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
