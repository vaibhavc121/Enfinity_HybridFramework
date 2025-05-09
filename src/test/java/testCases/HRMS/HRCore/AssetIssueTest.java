package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.AssetIssuePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.CommonActions;

public class AssetIssueTest extends BaseTest
{
	@Test(groups = "regression")
	public void verifyAssetIssue()
	{
		try
		{
			// hr core
			HRCorePage hc = new HRCorePage(driver);
			hc.clkHRCore();
			logger.info("clicked on hr core link");
			hc.clkSetupForm();
			logger.info("clicked on setup form");

			// setup page
			SetupPage sp = new SetupPage(driver);
			sp.clkAsset();
			Thread.sleep(2000);
			logger.info("clicked on asset");

			// Asset issue pg
			AssetIssuePage ap = new AssetIssuePage(driver);
//			ap.clkNewBtn();
//			logger.info("clicked on new button");
			ap.clkAddIcon();
			logger.info("clicked on add icon");
			ap.setName();
			logger.info("provided asset name");
			ap.clkAssetCatDD();
			logger.info("clicked on asset category");
			ap.slctDDValue();
			Thread.sleep(2000);
			logger.info("selected asset cat");
			ap.clkSaveBtn();
			logger.info("clicked on save button");
//			ap.clkAsset();
//			logger.info("clicked on asset");

			Assert.assertTrue(CommonActions.IsTxnCreated());
			logger.info("test case passed");

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}
