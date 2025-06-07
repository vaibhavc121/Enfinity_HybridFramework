package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.LenientShiftModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteLenientShiftTimetableTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteLenientShiftTimetable()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<LenientShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
					"createLenientShiftTimetable", LenientShiftModel.class);

			BasePage.globalSearch("Timetable");
			BasePage.waitTS(3);

			for (LenientShiftModel strict : attendanceData)
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
