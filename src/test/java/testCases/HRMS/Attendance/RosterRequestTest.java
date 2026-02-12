package testCases.HRMS.Attendance;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Attendance.Attendance.AttendanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.Attendance.RosterRequestPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class RosterRequestTest extends BaseTest
{
    String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
    List<AttendanceModel.RosterRequestModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
            "rosterRequest", AttendanceModel.RosterRequestModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createRosterRequest()
    {
        try
        {
            AttendancePage ap = new AttendancePage();
            ap.clickAttendance();
            log("Clicked on Attendance menu");
            ap.clickRosterRequest();
            log("Clicked on Roster Request");

            RosterRequestPage rp = new RosterRequestPage();
            BasePage.clickOnNew();
            log("Clicked on New button to create new roster request");

            for (AttendanceModel.RosterRequestModel data : attendanceData)
            {
                rp.enterFromDate(data.fromDate);
                log("Entered From Date: " + data.fromDate);
                rp.enterToDate(data.toDate);
                log("Entered To Date: " + data.toDate);
                rp.enterTimetable(data.timetable);
                log("Entered Timetable: " + data.timetable);
                rp.enterEmployee(data.employee);
                log("Entered Employee: " + data.employee);
                BasePage.clickOnSave();
                log("Clicked on Save button to save the roster request");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteRosterRequest()
    {
        try
        {
            
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}