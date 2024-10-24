package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AssetIssuePage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_AssetIssueTest extends BaseClass
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
			ap.clkAsset();
			logger.info("clicked on asset");

			Assert.assertTrue(ap.isHrAssetCreated());

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}
