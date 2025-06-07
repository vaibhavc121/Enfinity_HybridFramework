package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.HRAssetRequestModel;
import pageObjects.HRMS.SelfService.HRAssetRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateHRAssetRequest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createHRAssetRequest()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<HRAssetRequestModel> hrAssetRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createHRAssetRequest", HRAssetRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// HR asset request page
			HRAssetRequestPage ar = new HRAssetRequestPage(driver);

			for (HRAssetRequestModel HRAssetRequest : hrAssetRequestData)
			{
				ar.clickHRAssetRequest();
				ar.clickNew();
				ar.provideTxnDate(HRAssetRequest.txnDate);
				ar.provideEffectiveDate(HRAssetRequest.effectiveDate);
				ar.clickSave();
				ar.clickNewLine();
				ar.clickHRAssetDD();
				ar.selectHRAsset(HRAssetRequest.HRAsset);
				// ar.provideExpReturnDate(HRAssetRequest.expReturnDate);
				ar.clickView();
				ar.clickOnApproveBack();

				Assert.assertTrue(HRAssetRequestPage.isTransactionCreated(HRAssetRequest.txnDate1, HRAssetRequest.emp,
						HRAssetRequest.status));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
