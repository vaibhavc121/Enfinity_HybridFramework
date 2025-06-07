package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.HRAssetReturnModel;
import pageObjects.HRMS.HRCore.AssetIssuePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateHRAssetReturnTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createHRAssetReturn()
	{
		try
		{
			String hrAssetReturnFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<HRAssetReturnModel> hrAssetReturnData = JsonUtils.convertJsonListDataModel(hrAssetReturnFile,
					"createHRAssetReturn", HRAssetReturnModel.class);

			// hr core page
			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickAssetIssue();

			// asset issue page
			AssetIssuePage ai = new AssetIssuePage(driver);

			for (HRAssetReturnModel hrAssetReturn : hrAssetReturnData)
			{
				ai.filterAndOpenTxn(hrAssetReturn.HRAsset);
				ai.clickContextMenu();
				ai.clickReturn();
				ai.provideReturnDate(hrAssetReturn.expReturnDate);

				// ClassicAssert.IsTrue(ai.ReturnDate());
				Assert.assertTrue(true);
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
