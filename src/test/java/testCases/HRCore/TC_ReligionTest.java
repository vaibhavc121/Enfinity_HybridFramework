package testCases.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRCorePage;
import pageObjects.ReligionPage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_ReligionTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyReligion()
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
			sp.clkReligion();
			Thread.sleep(2000);
			logger.info("clicked on religion");

			// religion pg
			ReligionPage rp = new ReligionPage(driver);
			rp.clkBtnNew();
			logger.info("clicked on new button");
			rp.setReligionName();
			logger.info("provided religion");
			rp.clkSaveBtn();
			logger.info("clicked on save button");
			boolean act = rp.isReligionCreated();

			Assert.assertEquals(act, true);
			logger.info("test case passed");

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}
