package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.PromotionRequestModel;
import pageObjects.HRMS.SelfService.PromotionRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreatePromotionRequestTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createPromotionRequest()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createPromotionRequest", PromotionRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Promotion Request page
			PromotionRequestPage pr = new PromotionRequestPage(driver);
			pr.clickPromotionRequest();
			pr.clickNew();

			for (PromotionRequestModel promotionRequest : promotionRequestData)
			{
				pr.provideTxnDate(promotionRequest.txnDate);
				pr.provideEffectiveDate(promotionRequest.effectiveDate);
				pr.provideType(promotionRequest.type);
				pr.provideNewDepartment(promotionRequest.newDepartment);
				pr.provideNewDesignation(promotionRequest.newDesignation);
				pr.provideNewWorkLocation(promotionRequest.newWorkLocation);
				pr.provideNewProject(promotionRequest.newProject);
				pr.provideDescription(promotionRequest.description);
				pr.saveAndBack();

				Assert.assertTrue(BasePage.validateListing("Vaibhav Chavan", 6, 6));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
