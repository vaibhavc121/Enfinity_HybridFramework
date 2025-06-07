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

public class DeletePromotionRequestTest extends BaseTest
{
	public void deletePromotionRequest()
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
		// pr.scrollDownWebpage();
		pr.clickPromotionRequest();

		BasePage.deleteTxn(6, "001");
		Assert.assertFalse(BasePage.validateListing("001", 6, 6));
	}

}
