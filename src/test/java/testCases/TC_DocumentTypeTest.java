package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DocumentTypePage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_DocumentTypeTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyDocType()
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
			sp.clkDocType();
			Thread.sleep(2000);
			logger.info("clicked on doc type");

			// doctype pg
			DocumentTypePage dt = new DocumentTypePage(driver);
			dt.ClkNewBtn();
			logger.info("clicked on new btn");
			dt.setName();
			logger.info("provided doc type name");
			dt.clkSaveBtn();
			logger.info("clicked on save button");

			Assert.assertTrue(dt.isDocTypeCreated());

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}
