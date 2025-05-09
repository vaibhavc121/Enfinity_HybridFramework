package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.GradePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.CommonActions;

public class GradeTest extends BaseTest
{
	@Test(groups = "regression")
	public void verifyGrade()
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
			sp.clkGrade();
			Thread.sleep(2000);
			logger.info("clicked on grade");

			// grade pg
			GradePage gp = new GradePage(driver);
			gp.clkNewBtn();
			logger.info("clicked on new btn");
			gp.setGrade();
			logger.info("entered grade");
			gp.setMinSal();
			logger.info("entered min sal ");
			gp.setMaxSal();
			logger.info("entered max sal");
			gp.clkIndemnityDD();
			logger.info("clicked on indemnity dropdown");
			Thread.sleep(3000);
			gp.slctIndemnity();
			logger.info("indeminity selected");
			gp.btnSave();
			logger.info("clicked on save button");

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
