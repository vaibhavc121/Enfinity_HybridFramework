package testCases.HRMS.Attendance;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel.ShiftModel;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteShiftTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteShift()
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

			for (ShiftModel shift : shiftData)
			{
				BasePage.deleteTxn(2, shift.shiftName);
				Assert.assertFalse(BasePage.validateListing(shift.shiftName, 2, 1));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
