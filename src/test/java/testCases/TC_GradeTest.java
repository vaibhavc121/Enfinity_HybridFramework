package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GradePage;
import pageObjects.HrCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_GradeTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyGrade()
	{
		try
		{
			// hr core
			HrCorePage hc = new HrCorePage(driver);
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

			Assert.assertTrue(true);

		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case completed--");
	}

}
