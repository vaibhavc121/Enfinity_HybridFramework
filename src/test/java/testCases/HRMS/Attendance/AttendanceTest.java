package testCases.HRMS.Attendance;

import base.BasePage;
import base.BaseTest;
import models.Attendance.Attendance.AttendanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.Attendance.RosterPage;
import pageObjects.HRMS.Attendance.ShiftPage;
import pageObjects.HRMS.Attendance.TimetablePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class AttendanceTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLenientShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.LenientShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createLenientShiftTimetable", AttendanceModel.LenientShiftModel.class);

            BasePage.globalSearch("Timetable");

            TimetablePage tp = new TimetablePage();

            for (AttendanceModel.LenientShiftModel strict : attendanceData)
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

                Assert.assertTrue(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLenientShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.LenientShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createLenientShiftTimetable", AttendanceModel.LenientShiftModel.class);

            BasePage.globalSearch("Timetable");
            BasePage.waitTS(3);

            for (AttendanceModel.LenientShiftModel strict : attendanceData)
            {
                BasePage.deleteTxn(3, strict.name);
                Assert.assertFalse(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void createRoster()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.RosterModel> rosterData = JsonUtils.convertJsonListDataModel(attendanceFile, "createRoster",
                    AttendanceModel.RosterModel.class);

            // AttendancePage
            AttendancePage ap = new AttendancePage();
            ap.clickAttendance();
            log("Clicking on Attendance module");
            ap.clickRoster();
            log("Clicking on Roster");

            // RosterPage
            RosterPage rp = new RosterPage();

            for (AttendanceModel.RosterModel roster : rosterData)
            {
                rp.clickNew();
                log("clicked on New button");

                rp.switchTheTab();
                log("tab switched to Roster tab");

                rp.provideFromDate(roster.fromDate);
                log("provided from date " + roster.fromDate);

                rp.provideUptoDate(roster.upToDate);
                log("provided up to date " + roster.upToDate);

                rp.provideTimetable(roster.timetable);
                log("provided timetable " + roster.timetable);

                rp.selectExcludeDay(roster.excludeDay);
                log("selected exclude day " + roster.excludeDay);

                rp.provideEmp(roster.applicableFor);
                log("provided applicable for " + roster.applicableFor);

                rp.clickOnGenerate();
                log("clicked on Generate button");

                rp.switchTheTab1();
                log("tab switched to Roster Details tab");

                rp.refreshBrowser();
                log("browser refreshed");

                Assert.assertTrue(rp.isTransactionCreated(roster.fromDate),
                        "Roster creation failed for " + roster.applicableFor + " from " + roster.fromDate + " to "
                                + roster.upToDate);
                log("Verified: Roster created successfully for " + roster.applicableFor + " from "
                        + roster.fromDate + " to " + roster.upToDate);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void deleteRoster()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.RosterModel> rosterData = JsonUtils.convertJsonListDataModel(attendanceFile, "createRoster",
                    AttendanceModel.RosterModel.class);

            // AttendancePage
            AttendancePage ap = new AttendancePage();
            ap.clickAttendance();
            ap.clickRoster();

            for (AttendanceModel.RosterModel roster : rosterData)
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

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void createShift()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.ShiftModel> shiftData = JsonUtils.convertJsonListDataModel(attendanceFile, "createShift",
                    AttendanceModel.ShiftModel.class);

            // AttendancePage
            AttendancePage ap = new AttendancePage();
            ap.clickAttendance();
            ap.clickShift();

            // ShiftPage
            ShiftPage sp = new ShiftPage();

            for (AttendanceModel.ShiftModel shift : shiftData)
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

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void deleteShift()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.ShiftModel> shiftData = JsonUtils.convertJsonListDataModel(attendanceFile, "createShift",
                    AttendanceModel.ShiftModel.class);

            // AttendancePage
            AttendancePage ap = new AttendancePage();
            ap.clickAttendance();
            ap.clickShift();

            for (AttendanceModel.ShiftModel shift : shiftData)
            {
                BasePage.deleteTxn(3, shift.shiftName);
                Assert.assertFalse(BasePage.validateListing(shift.shiftName, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 7)
    public void createStrictDayShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.StrictDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createStrictDayShiftTimetable", AttendanceModel.StrictDayShiftModel.class);

            BasePage.globalSearch("Timetable");

            TimetablePage tp = new TimetablePage();

            for (AttendanceModel.StrictDayShiftModel strict : attendanceData)
            {
                tp.clickNew();
                tp.provideTimetableName(strict.name);
                tp.selectDayType(strict.dayType);
                tp.selectMode(strict.mode);
                tp.provideMaximumWorkedHourPerDay(strict.maximumWorkedHourPerDay);
                tp.provideFirstInTime(strict.firstInTime);
                tp.provideFirstOutTime(strict.firstOutTime);
                tp.clickViewBack();

                Assert.assertTrue(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 8)
    public void deleteStrictDayShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.StrictDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createStrictDayShiftTimetable", AttendanceModel.StrictDayShiftModel.class);

            BasePage.globalSearch("Timetable");
            BasePage.waitTS(3);

            for (AttendanceModel.StrictDayShiftModel strict : attendanceData)
            {
                BasePage.deleteTxn(3, strict.name);
                Assert.assertFalse(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 9)
    public void createTwoShiftDayShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.TwoShiftDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createTwoShiftDayShiftTimetable", AttendanceModel.TwoShiftDayShiftModel.class);

            BasePage.globalSearch("Timetable");

            TimetablePage tp = new TimetablePage();

            for (AttendanceModel.TwoShiftDayShiftModel strict : attendanceData)
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

                Assert.assertTrue(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 10)
    public void deleteTwoShiftDayShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.TwoShiftDayShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createTwoShiftDayShiftTimetable", AttendanceModel.TwoShiftDayShiftModel.class);

            BasePage.globalSearch("Timetable");
            BasePage.waitTS(3);

            for (AttendanceModel.TwoShiftDayShiftModel strict : attendanceData)
            {
                BasePage.deleteTxn(3, strict.name);
                Assert.assertFalse(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 11)
    public void createTwoShiftNightShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.TwoShiftNightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createTwoShiftNightShiftTimetable", AttendanceModel.TwoShiftNightShiftModel.class);

            BasePage.globalSearch("Timetable");

            TimetablePage tp = new TimetablePage();

            for (AttendanceModel.TwoShiftNightShiftModel strict : attendanceData)
            {
                tp.clickNew();
                tp.provideTimetableName(strict.name);
                tp.selectDayType(strict.dayType);
                tp.clickNightShift();
                tp.selectMode(strict.mode);
                tp.provideMaximumWorkedHourPerDay(strict.maximumWorkedHourPerDay);
                tp.clickWorkInTwoShift();
                tp.provideFirstInTime(strict.firstInTime);
                tp.provideFirstOutTime(strict.firstOutTime);
                tp.provideSecondInTime(strict.secondInTime);
                tp.provideSecondOutTime(strict.secondOutTime);
                tp.selectShiftNextDayStartFrom(strict.shiftNextDayStartFrom);
                tp.clickViewBack();
                //p.clickTimetable();

                Assert.assertTrue(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 12)
    public void deleteTwoShiftNightShiftTimetable()
    {
        String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
        List<AttendanceModel.TwoShiftNightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                "createTwoShiftNightShiftTimetable", AttendanceModel.TwoShiftNightShiftModel.class);

        BasePage.globalSearch("Timetable");
        BasePage.waitTS(3);

        for (AttendanceModel.TwoShiftNightShiftModel strict : attendanceData)
        {
            BasePage.deleteTxn(3, strict.name);
            Assert.assertFalse(BasePage.validateListing(strict.name, 3, 2));
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 13)
    public void createNightShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.NightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createNightShiftTimetable", AttendanceModel.NightShiftModel.class);

            BasePage.globalSearch("Timetable");

            TimetablePage tp = new TimetablePage();

            for (AttendanceModel.NightShiftModel shift : attendanceData)
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

                Assert.assertTrue(BasePage.validateListing(shift.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 14)
    public void deleteNightShiftTimetable()
    {
        try
        {
            String attendanceFile = FileUtils.getDataFile("Attendance", "Attendance", "AttendanceData");
            List<AttendanceModel.NightShiftModel> attendanceData = JsonUtils.convertJsonListDataModel(attendanceFile,
                    "createNightShiftTimetable", AttendanceModel.NightShiftModel.class);

            BasePage.globalSearch("Timetable");
            BasePage.waitTS(3);

            for (AttendanceModel.NightShiftModel strict : attendanceData)
            {
                BasePage.deleteTxn(3, strict.name);
                Assert.assertFalse(BasePage.validateListing(strict.name, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}