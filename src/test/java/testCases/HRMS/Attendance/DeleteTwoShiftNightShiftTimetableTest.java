package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.TwoShiftNightShiftModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteTwoShiftNightShiftTimetableTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteTwoShiftNightShiftTimetable()
    {
        String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
        List<TwoShiftNightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                "createTwoShiftNightShiftTimetable", TwoShiftNightShiftModel.class);

        BasePage.globalSearch("Timetable");
        BasePage.waitTS(3);

        for (TwoShiftNightShiftModel strict : attendanceData)
        {
            BasePage.deleteTxn(2, strict.name);
            Assert.assertFalse(BasePage.validateListing(strict.name, 2, 1));
        }
    }
}