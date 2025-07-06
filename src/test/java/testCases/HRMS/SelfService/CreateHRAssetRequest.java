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
				log("clicked on HR Asset Request");

				ar.clickNew();
				log("clicked on New");

				ar.provideTxnDate(HRAssetRequest.txnDate);
				log("provided Transaction Date: " + HRAssetRequest.txnDate);

				ar.provideEffectiveDate(HRAssetRequest.effectiveDate);
				log("provided Effective Date: " + HRAssetRequest.effectiveDate);

				ar.clickSave();
				log("clicked on Save");

				ar.clickNewLine();
				log("clicked on New Line");

				ar.clickHRAssetDD();
				log("clicked on HR Asset dropdown");

				ar.selectHRAsset(HRAssetRequest.HRAsset);
				log("selected HR Asset: " + HRAssetRequest.HRAsset);
				// ar.provideExpReturnDate(HRAssetRequest.expReturnDate);
				ar.clickView();
				log("clicked on View");

				ar.clickOnApproveBack();
				log("clicked on Approve Back");

				Assert.assertTrue(HRAssetRequestPage.isTransactionCreated(HRAssetRequest.txnDate1, HRAssetRequest.emp,
						HRAssetRequest.status));
				log("Transaction created successfully with date: " + HRAssetRequest.txnDate1 + ", Employee: " + HRAssetRequest.emp
						+ ", Status: " + HRAssetRequest.status);
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}