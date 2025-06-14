package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.LenientShiftModel;
import pageObjects.HRMS.Attendance.TimetablePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateLenientShiftTimetableTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createLenientShiftTimetable()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<LenientShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
					"createLenientShiftTimetable", LenientShiftModel.class);

			BasePage.globalSearch("Timetable");

			TimetablePage tp = new TimetablePage(driver);

			for (LenientShiftModel strict : attendanceData)
			{
				tp.clickNew();
				tp.provideTimetableName(strict.name);
				tp.selectDayType(strict.dayType);
				tp.selectMode(strict.mode);
				tp.provideMaximumWorkedHourPerDay(strict.maximumWorkedHourPerDay);
				tp.provideWorkedHourPerDay(strict.workedHourPerDay);
				tp.provideHourlyMinCheckInTime(strict.hourlyMinCheckInTime);
				tp.provideHourlyMaxCheckOutTime(strict.hourlyMaxCheckOutTime);
				tp.clickViewBack();

				Assert.assertTrue(BasePage.validateListing(strict.name, 2, 1));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}