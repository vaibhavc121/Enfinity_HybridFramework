package testCases.HRMS.Attendance;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Attendance.Attendance.AttendanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.Attendance.RosterRequestPage;
import utilities.DateUtils;
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
                BasePage.clickOnViewApproveBack();
                log("Clicked on Save button to save the roster request");

                Assert.assertTrue(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2),
                        "Roster is not created successfully");
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
            AttendancePage ap = new AttendancePage();
            ap.clickAttendance();
            log("Clicked on Attendance menu");
            ap.clickRosterRequest();
            log("Clicked on Roster Request");

            for (AttendanceModel.RosterRequestModel data : attendanceData)
            {
                BasePage.deleteTxn(2, DateUtils.getCurrentDate("dd-MMM-yyyy"));
                Assert.assertFalse(BasePage.validateListing(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2),
                        "Roster request not deleted successfully");
                log("Assertion passed: Roster request deleted successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}