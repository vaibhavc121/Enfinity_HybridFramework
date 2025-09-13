package testCases.HRMS.Attendance;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.NightShiftModel;
import pageObjects.HRMS.Attendance.TimetablePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateNightShiftTimetableTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createNightShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<NightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createNightShiftTimetable", NightShiftModel.class);

            BasePage.globalSearch("Timetable");
            log("");

            TimetablePage tp = new TimetablePage();

            for (NightShiftModel shift : attendanceData)
            {
                //vaibhav
                tp.clickNew();
                log("clickNew");

                tp.provideTimetableName(shift.name);
                log("provideTimetableName");

                tp.selectDayType(shift.dayType);
                log("selectDayType");

                tp.clickNightShift();
                log("clickNightShift");

                tp.selectMode(shift.mode);
                log("selectMode");

                tp.provideMaximumWorkedHourPerDay(shift.maximumWorkedHourPerDay);
                log("provideMaximumWorkedHourPerDay");

                tp.provideFirstInTime(shift.firstInTime);
                log("provideFirstInTime");

                tp.provideFirstOutTime(shift.firstOutTime);
                log("provideFirstOutTime");

                tp.clickViewBack();
                log("clickViewBack");

                Assert.assertTrue(BasePage.validateListing(shift.name, 3, 2));
                log("assertion completed");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}