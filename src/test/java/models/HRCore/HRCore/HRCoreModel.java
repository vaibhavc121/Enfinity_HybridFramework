package models.HRCore.HRCore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class HRCoreModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor

	public static class CreateBankModel
	{
		public String bankName;
	}

	public static class DeleteBankModel
	{
		public String bankName;
	}

	public static class CreateCalendarModel
	{
		public String calendarName;
		public String fromDate;
	}

	public static class DeleteCalendarModel
	{
		public String calendarName;
	}

	public static class CreateDepartmentModel
	{
		public String deptname;
	}

	public static class DeleteDepartmentModel
	{
		public String deptname;
	}

	public static class CreateDesignationModel
	{
		public String designationName;
	}

	public static class DeleteDesignationModel
	{
		public String designationName;
	}

	public static class CreateDocumentTypeModel
	{
		public String documentTypeName;
	}

	public static class DeleteDocumentTypeModel
	{
		public String documentTypeName;
	}

	public static class CreateGradeModel
	{
		public String gradeName;
		public String minSal;
		public String maxSal;
	}

	public static class DeleteGradeModel
	{
		public String gradeName;
	}

	public static class CreateQualificationModel
	{
		public String qualificationName;
	}

	public static class DeleteQualificationModel
	{
		public String qualificationName;
	}

	public static class CreateReligionModel
	{
		public String religionName;
	}

	public static class DeleteReligionModel
	{
		public String religionName;
	}

	public static class CreateWorkLocationModel
	{
		public String workLocationName;
	}

	public static class DeleteWorkLocationModel
	{
		public String workLocationName;
	}

}
