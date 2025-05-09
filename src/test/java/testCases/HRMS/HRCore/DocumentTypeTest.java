package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.DocumentTypePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.CommonActions;

public class DocumentTypeTest extends BaseTest
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
			sp.clkDocIsuue();
			Thread.sleep(2000);
			logger.info("clicked on doc type");

			// doctype pg
			DocumentTypePage dt = new DocumentTypePage(driver);
			dt.clkAddIcon();
			logger.info("clicked on new btn");
			dt.setName();
			logger.info("provided doc type name");
			dt.clkSaveBtn();
			logger.info("clicked on save button");
			// dt.clkDocType();
			// Assert.assertTrue(dt.isDocTypeCreated());
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
