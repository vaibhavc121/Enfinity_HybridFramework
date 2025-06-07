package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.StrictDayShiftModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteStrictDayShiftTimetableTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteStrictDayShiftTimetable()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<StrictDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
					"createStrictDayShiftTimetable", StrictDayShiftModel.class);

			BasePage.globalSearch("Timetable");
			BasePage.waitTS(3);

			for (StrictDayShiftModel strict : attendanceData)
			{
				BasePage.deleteTxn(2, strict.name);
				Assert.assertFalse(BasePage.validateListing(strict.name, 2, 1));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
