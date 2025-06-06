package models.Onboarding.Onboarding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class OnboardingModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor

	public static class CandidateModel
	{
		public String name;
		public String nameArabic;
		public String email;
		public String mobileNumber;
		public String dateOfBirth;
		public String gender;
		public String maritalStatus;
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
		public String passportNumber;
		public String passportIssueDate;
		public String passportExpiryDate;
		public String visaType;
		public String civilIdNumber;
		public String addQualification;
		public String university;
		public String academicDegree;
		public String majorDegree;
		public String yearOfPassing;
		public String checkbox;
		public String addExperience;
		public String jobTitle;
		public String company;
		public String startDate;
		public String endDate;
		public String workProfile;
	}

}
