package models.Recruitment.Recruitment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class RecruitmentModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class JobModel
	{
		public String jobTitle;
		public String department;
		public String designation;
		public String numberOfPosition;
		public String employmentType;
		public String Industry;
		public String TargetDate;
		public String MonthlySal;
		public String assignedManager;
		public String assignedRecruiter;
		public String workExperience;
		public String skills;
		public String city;
		public String state;
		public String country;
		public String postalCode;
		public String gender;
		public String maritalStatus;
		public String nationality;
	}

}
