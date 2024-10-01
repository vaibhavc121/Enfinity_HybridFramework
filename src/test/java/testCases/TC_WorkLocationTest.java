package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import pageObjects.WorkLocationPage;
import testBase.BaseClass;

public class TC_WorkLocationTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyWorkLocation()
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
			sp.clkWorkLocation();
			Thread.sleep(2000);
			logger.info("clicked on worklocation");

			// work location pg
			WorkLocationPage wc = new WorkLocationPage(driver);
			wc.clkNewBtn();
			wc.setName();
			wc.clkSaveBtn();
			boolean act = wc.isWorkLocCreated();

			Assert.assertEquals(act, true);

		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case completed--");

	}

}
