package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRCorePage;
import pageObjects.QualificationPage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_QualificationTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyQualification() throws InterruptedException
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
			sp.clkQualification();
			Thread.sleep(2000);
			logger.info("clicked on qualification");

			// qualification pg
			QualificationPage qp = new QualificationPage(driver);
			qp.clkNewBtn();
			logger.info("clicked on new btn");
			qp.setName();
			logger.info("provided qualification");
			qp.clickQualificationDD();
			logger.info("clicked qlfctn dd");
			qp.slctType();
			logger.info("selected qlfctn type");
			qp.clkSaveBtn();
			logger.info("clicked on save button");

			Assert.assertTrue(qp.isQualificationCreated());
		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case completed--");

	}
}