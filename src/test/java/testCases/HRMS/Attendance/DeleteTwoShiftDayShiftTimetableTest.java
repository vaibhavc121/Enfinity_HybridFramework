package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.TwoShiftDayShiftModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteTwoShiftDayShiftTimetableTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteTwoShiftDayShiftTimetable()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<TwoShiftDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
					"createTwoShiftDayShiftTimetable", TwoShiftDayShiftModel.class);

			BasePage.globalSearch("Timetable");
			BasePage.waitTS(3);

			for (TwoShiftDayShiftModel strict : attendanceData)
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
