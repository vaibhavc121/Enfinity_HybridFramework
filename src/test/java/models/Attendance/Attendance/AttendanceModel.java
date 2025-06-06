package models.Attendance.Attendance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class AttendanceModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor

	public static class ShiftModel
	{
		public String shiftName;
		public String defaultTimetable;
	}

	public static class RosterModel
	{
		public String fromDate;
		public String upToDate;
		public String timetable;
		public String excludeDay;
		public String applicableFor;
	}

	public static class StrictDayShiftModel
	{
		public String name;
		public String dayType;
		public String mode;
		public String maximumWorkedHourPerDay;
		public String firstInTime;
		public String firstOutTime;
	}

	public static class LenientShiftModel
	{
		public String name;
		public String dayType;
		public String mode;
		public String maximumWorkedHourPerDay;
		public String workedHourPerDay;
		public String hourlyMinCheckInTime;
		public String hourlyMaxCheckOutTime;
	}

	public static class TwoShiftDayShiftModel
	{
		public String name;
		public String dayType;
		public String mode;
		public String maximumWorkedHourPerDay;
		public String firstInTime;
		public String firstOutTime;
		public String secondInTime;
		public String secondOutTime;
	}

	public static class NightShiftModel
	{
		public String name;
		public String dayType;
		public String mode;
		public String maximumWorkedHourPerDay;
		public String firstInTime;
		public String firstOutTime;
	}

	public static class TwoShiftNightShiftModel
	{
		public String name;
		public String dayType;
		public String mode;
		public String maximumWorkedHourPerDay;
		public String firstInTime;
		public String firstOutTime;
		public String secondInTime;
		public String secondOutTime;
		public String shiftNextDayStartFrom;
	}

}
