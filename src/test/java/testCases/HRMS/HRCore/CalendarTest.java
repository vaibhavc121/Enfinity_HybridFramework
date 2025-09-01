package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateCalendarModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.CalendarPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CalendarTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createCalendar()
    {
        try
        {
            String calendarFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateCalendarModel> calendarData = JsonUtils.convertJsonListDataModel(calendarFile, "createCalendar",
                    CreateCalendarModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            log("Clicked on HR Core module");
            hc.clickSetupForm();
            log("Clicked on Setup form");

            SetupPage sp = new SetupPage(driver);
            sp.clickCalendar();
            log("Clicked on Calendar link");
            Thread.sleep(2000);

            CalendarPage cp = new CalendarPage(driver);
            for (CreateCalendarModel calendar : calendarData)
            {
                cp.clickNewButton();
                log("Clicked on New button");
                cp.provideCalendarName(calendar.calendarName);
                log("Provided Calendar Name: " + calendar.calendarName);
                cp.provideFromDate(calendar.fromDate);
                log("Provided From Date: " + calendar.fromDate);
                cp.setWeekoff();
                log("Set Weekoff");
                cp.setRestday();
                log("Set Restday");
                cp.clickSaveBack();
                log("Clicked on Save & Back button");

                BasePage.validateListing(calendar.calendarName, 2, 1);
                log("Verified: Calendar created successfully - " + calendar.calendarName);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteCalendar()
    {
        try
        {
            String calendarFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteCalendarModel> calendarData = JsonUtils.convertJsonListDataModel(calendarFile, "deleteCalendar",
                    HRCoreModel.DeleteCalendarModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            log("Clicked on HR Core module");
            hc.clickSetupForm();
            log("Clicked on Setup form");

            SetupPage sp = new SetupPage(driver);
            for (HRCoreModel.DeleteCalendarModel calendar : calendarData)
            {
                sp.clickCalendar();
                log("Clicked on Calendar link");
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, calendar.calendarName);

                Assert.assertFalse(BasePage.validateListing(calendar.calendarName, 2, 1));
                log("Verified: Calendar deleted successfully - " + calendar.calendarName);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}