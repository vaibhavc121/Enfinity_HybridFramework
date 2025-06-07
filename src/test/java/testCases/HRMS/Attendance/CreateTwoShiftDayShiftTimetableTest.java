package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.TwoShiftDayShiftModel;
import pageObjects.HRMS.Attendance.TimetablePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateTwoShiftDayShiftTimetableTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createTwoShiftDayShiftTimetable()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<TwoShiftDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
					"createTwoShiftDayShiftTimetable", TwoShiftDayShiftModel.class);

			BasePage.globalSearch("Timetable");

			TimetablePage tp = new TimetablePage(driver);

			for (TwoShiftDayShiftModel strict : attendanceData)
			{
				tp.clickNew();
				tp.provideTimetableName(strict.name);
				tp.selectDayType(strict.dayType);
				tp.selectMode(strict.mode);
				tp.provideMaximumWorkedHourPerDay(strict.maximumWorkedHourPerDay);
				tp.clickWorkInTwoShift();
				tp.provideFirstInTime(strict.firstInTime);
				tp.provideFirstOutTime(strict.firstOutTime);
				tp.provideSecondInTime(strict.secondInTime);
				tp.provideSecondOutTime(strict.secondOutTime);
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
