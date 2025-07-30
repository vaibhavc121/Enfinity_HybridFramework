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
		public String templateName;
		public String jobTitle;
		public String company;
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

	public static class CandidateModel
	{
		public String mobile;
		public String dob;
		public String gender;
		public String maritalStatus;
		public boolean checkbox1;

		public String city;
		public String state;
		public String country;
		public String postalCode;

		public String workExperienceInYear;
		public String currentJobTitle;
		public String currentEmployer;
		public String skills;
		public String currentSalary;
		public String expectedSalary;
		public String noticePeriodInDays;
		public boolean checkbox2;

		public String passportNumber;
		public String passportIssueDate;
		public String passportExpiryDate;
		public String visaType;
		public String civilIdNumber;
	}

	public static class AdvanceCandidateSearchModel
	{
		public String skills;

		public String minimumWorkExperience;
		public String maximumWorkExperience;

		public String minimumSalaryRange;
		public String maximumSalaryRange;

		public String minimumNoticePeriodInDays;
		public String maximumNoticePeriodInDays;

		public String nationalityCountries;
		public String visaType;
		public String gender;
		public boolean drivingLicense;

		public String minimumAge;
		public String maximumAge;
	}



}