package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.RosterModel;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.Attendance.RosterPage;

import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateRosterTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createRoster()
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

			// RosterPage
			RosterPage rp = new RosterPage(driver);

			for (RosterModel roster : rosterData)
			{
				rp.clickNew();
				rp.switchTheTab();
				rp.provideFromDate(roster.fromDate);
				rp.provideUptoDate(roster.upToDate);
				rp.provideTimetable(roster.timetable);
				rp.selectExcludeDay(roster.excludeDay);
				rp.provideEmp(roster.applicableFor);
				rp.clickOnGenerate();
				rp.switchTheTab1();
				rp.refreshBrowser();

				Assert.assertTrue(rp.isTransactionCreated(roster.fromDate));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
