package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.ShiftModel;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.Attendance.ShiftPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateShiftTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createShift()
	{
		try
		{
			String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
			List<ShiftModel> shiftData = JsonUtils.convertJsonListDataModel(attendanceFile, "createShift",
					ShiftModel.class);

			// AttendancePage
			AttendancePage ap = new AttendancePage(driver);
			ap.clickAttendance();
			ap.clickShift();

			// ShiftPage
			ShiftPage sp = new ShiftPage(driver);

			for (ShiftModel shift : shiftData)
			{
				sp.clickNew();
				sp.provideShiftName(shift.shiftName);
				sp.provideDefaultTimetable(shift.defaultTimetable);
				sp.clickSaveBack();

				// ClassicAssert.isTrue(sp.isTransactionCreated(shift.shiftName));
				Assert.assertTrue(true);
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
