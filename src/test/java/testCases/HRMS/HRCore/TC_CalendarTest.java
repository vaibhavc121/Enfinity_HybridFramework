package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HRMS.HRCore.CalendarPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;

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
			Thread.sleep(10000);
			logger.info("check restday");
			cp.clkSave();
			logger.info("clicked on save button");

			Assert.assertTrue(cp.isCalendarCreated());
			// Assert.assertTrue(true);
			logger.info("test case passed");

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
