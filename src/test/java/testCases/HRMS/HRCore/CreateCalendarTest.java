package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateCalendarModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.CalendarPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateCalendarTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createCalendar()
    {
        try
        {
            String calendarFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateCalendarModel> calendarData = JsonUtils.convertJsonListDataModel(calendarFile, "createCalendar",
                    CreateCalendarModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            sp.clickCalendar();
            Thread.sleep(2000);

            CalendarPage cp = new CalendarPage(driver);
            for (CreateCalendarModel calendar : calendarData)
            {
                cp.clickNewButton();
                cp.provideCalendarName(calendar.calendarName);
                cp.provideFromDate(calendar.fromDate);
                cp.setWeekoff();
                cp.setRestday();
                cp.clickSaveBack();

                BasePage.validateListing(calendar.calendarName, 2, 1);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}