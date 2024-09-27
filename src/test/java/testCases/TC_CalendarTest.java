package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CalendarPage;
import pageObjects.HRCorePage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC_CalendarTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyCalendar()
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
			sp.clkCalendar();
			Thread.sleep(2000);
			logger.info("clicked on calendar");

			// calendar pg
			CalendarPage cp = new CalendarPage(driver);
			cp.clkNewBtn();
			logger.info("clicked on new btn");
			cp.setCalName();
			logger.info("entered cal name");
			cp.setCalDate();
			logger.info("entered date");
			cp.setWeekoff();
			logger.info("check weekoff");
			cp.setRestday();
			logger.info("check restday");
			cp.clkSave();
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
