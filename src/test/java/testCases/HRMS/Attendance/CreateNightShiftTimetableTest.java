package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.NightShiftModel;
import pageObjects.HRMS.Attendance.TimetablePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateNightShiftTimetableTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createNightShiftTimetable()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<NightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
					"createNightShiftTimetable", NightShiftModel.class);

			BasePage.globalSearch("Timetable");

			TimetablePage tp = new TimetablePage(driver);

			for (NightShiftModel shift : attendanceData)
			{
				tp.clickNew();
				tp.provideTimetableName(shift.name);
				tp.selectDayType(shift.dayType);
				tp.clickNightShift();
				tp.selectMode(shift.mode);
				tp.provideMaximumWorkedHourPerDay(shift.maximumWorkedHourPerDay);
				tp.provideFirstInTime(shift.firstInTime);
				tp.provideFirstOutTime(shift.firstOutTime);
				tp.clickViewBack();

				Assert.assertTrue(BasePage.validateListing(shift.name, 2, 1));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
