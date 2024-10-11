package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AssetPage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_AssetTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyHRAsset()
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

			// HRAsset pg
			AssetPage ap = new AssetPage(driver);
			ap.clkNewBtn();
			logger.info("clicked on new button");
			ap.setName();
			logger.info("provided asset name");
			ap.clkAssetCatDD();
			logger.info("clicked on asset category");
			ap.slctDDValue();
			Thread.sleep(2000);
			logger.info("selected asset cat");
			ap.clkSaveBtn();
			logger.info("clicked on save button");

			Assert.assertTrue(ap.isHrAssetCreated());

		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case completed--");
	}
}
