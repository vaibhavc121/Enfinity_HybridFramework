package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.RosterModel;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteRosterTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteRoster()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<RosterModel> rosterData = JsonUtils.convertJsonListDataModel(attendanceFile, "createRoster",
					RosterModel.class);

			// AttendancePage
			AttendancePage ap = new AttendancePage(driver);
			ap.clickAttendance();
			ap.clickRoster();

			for (RosterModel roster : rosterData)
			{
				BasePage.deleteTxn(2, roster.applicableFor);
				Assert.assertFalse(BasePage.validateListing(roster.applicableFor, 2, 1));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
