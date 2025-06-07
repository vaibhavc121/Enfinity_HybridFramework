package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.HRAssetRequestModel;
import pageObjects.HRMS.SelfService.HRAssetRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteHRAssetRequestTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, description = "dont check delete bcos i am checking asset return so txn cannot keep active for delete", enabled = false)
	public void deleteHRAssetRequest()
	{
		try
		{
			String hrAssetRequestFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<HRAssetRequestModel> hrAssetRequestData = JsonUtils.convertJsonListDataModel(hrAssetRequestFile,
					"createHRAssetRequest", HRAssetRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// HR asset request page
			HRAssetRequestPage ar = new HRAssetRequestPage(driver);
			ar.clickHRAssetRequest();
			ar.test();
			BasePage.deleteTxn(7, "active");
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
