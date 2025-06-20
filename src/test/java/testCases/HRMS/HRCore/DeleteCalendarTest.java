package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteCalendarModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteCalendarTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteCalendar()
    {
        try
        {
            String calendarFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<DeleteCalendarModel> calendarData = JsonUtils.convertJsonListDataModel(calendarFile, "deleteCalendar",
                    DeleteCalendarModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            for (DeleteCalendarModel calendar : calendarData)
            {
                sp.clickCalendar();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, calendar.calendarName);

                Assert.assertFalse(BasePage.validateListing(calendar.calendarName, 2, 1));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}