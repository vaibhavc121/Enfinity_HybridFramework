package models.HRCore.HRCore;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Payroll.Payroll.PayrollModel;

public class EmployeeModel
{
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)

	public static class EmpModel
	{
		public String email;
		public String name;
		public String mobile;
		public String DOJ;
		public String department;
		public String designation;
		public String payrollSet;
		public String calendar;
		public String indemnity;
		public String grade;
		public String gender;
		public String religion;
		public String maritalStatus;
	}

	public static class PersonalTabModel
	{
		public String nameL2;
		public String displayName;
		public String displayNameL2;
		public String DOB;
		public String nationality;
		public String bloodGroup;
		public String photoVisibility;
		public String mobileNumberVisibility;
		public String emailVisibility;
	}

	public static class JobTabModel
	{
		public String manager;
		public String substituteEmployee;
		public String category;
		public String workLocation;
		public String employmentType;
		public String probationPeriod;
		public String noticePeriod;
		public String priorCompany;
		public String startDate;
		public String qualification;
		public String university;
		public String YearOfPassing;
	}

	public static class PayrollTabModel
	{
		public String payrollset;
		public String paymentMode;
		public String employeebank;
		public String bankAccountType;
		public String govtRecruitmentContractLicense;
		public String basicSalary;
		public String salaryComponent;
		public String amount;
		public String effectiveFromDate;
		public String overtimeType;
		public String relationshipType;
		public String description;
		public String ticketAccrual;
		public String ticketDestination;
		public String ticketEffectiveFromDate;
		public String accrualType;
		public String accrualAmount;
		public String resetAvailedDaysMethod;
		public String BSrelationshipType;
		public String benefitScheme;
		public String BSeffectiveFromDate;
		public String BSeffectiveToDate;
		public List<SalaryComponentModel> salaryComponents;
		public List<OvertimeTypesModel> overtimeTypes;
	}

	public static class SalaryComponentModel
	{
		public String salaryComponent;
		public String amount;
		public String effectiveFromDate;
	}

	public static class OvertimeTypesModel
	{
		public String overtimeType;
	}

	public static class TimeOffTabModel
	{
		public String leaveType;
		public String LTeffectiveFromDate;
		public List<LeaveTypesModel> leaveTypes;
	}

	public static class LeaveTypesModel
	{
		public String leaveType;
		public String LTeffectiveFromDate;
	}

	public static class AttendanceTabModel
	{
		public String calendar;
		public String checkInType;
		public String defaultShift;
		public String policy;
		public String shiftPreference;
	}

	public static class DocumentsTabModel
	{
		public String documentType;
		public String dateOfExpiry;
		public String placeOfDocument;
	}

	public static class PerformanceTabModel
	{
		public String KeyResultAreaName;
		public String weightage;
		public String competencyName;
		public String competenciesWeightage;
		public String skillSetName;
		public String level;
		public String skillSetWeightage;
		public String goalName;
		public String startDate;
		public String dueDate;
		public String priority;
		public String goalsWeightage;
		public List<KRAModel> KRA;
		public List<CompetenciesModel> Competencies;
		public List<SkillSetsModel> SkillSets;
		public List<GoalsModel> Goals;
	}

	public static class KRAModel
	{
		public String KeyResultAreaName;
		public String weightage;
	}

	public static class CompetenciesModel
	{
		public String competencyName;
		public String competenciesWeightage;
	}

	public static class SkillSetsModel
	{
		public String skillSetName;
		public String level;
		public String skillSetWeightage;
	}

	public static class GoalsModel
	{
		public String goalName;
		public String startDate;
		public String dueDate;
		public String priority;
		public String goalsWeightage;
	}

	public static class IntegrationTabModel
	{
		public String financialIntegrationGroup;
		public String division;
		public String department;
		public String project;
		public String segmentWorkLocation;
		public String FromPeriod;
		public String ToPeriod;
		public String sdivision;
		public String sdepartment;
		public String sproject;
		public String sWorkLocation;
		public String Project;
		public String EffectiveFromDate;
		public List<ProjectsModel> Projects;
	}

	public static class ProjectsModel
	{
		public String Project;
		public String EffectiveFromDate;
		public String EffectiveToDate;
	}

	public static class DependentsTabModel
	{
		public String spouseName;
		public String birthDate;
		public String marriageDate;
		public String childrenName;
		public String childrenBirthDate;
		public String dependentName;
		public String dependentBirthDate;
	}

	public static class ResidencyInfoTabModel
	{
		public String secondName;
		public String thirdName;
		public String fourthName;
		public String lastName;
		public String birthPlace;
		public String dateOfEntry;
		public String VisaNumber;
		public String WorkPermitNumber;
		public String ResidenceNumber;
		public String ContractQualification;
		public String NewResidencyPeriod;
		public String NewGovtDesignation;
		public String GovtLicense;
		public String NewContractSalary;
		public String OldContractSalary;
		public String Block;
		public String BuildingNumber;
		public String FlatNumber;
		public String FloorNumber;
		public String Lane;
		public String TypeOfBuilding;
		public String Street;
		public String Qasima;
		public String Area;
		public String PaciNumber;
		public String PreviousSponsorName;
		public String PreviousCompanyAuthorizedSign;
		public String PreviousCompanyName;
		public String OldGovtDesignation;
		public String OldFileNumber;
		public String OldGovernmentLicense;
	}

	public static class DeleteEmpModel
	{
		public String empName;
	}

}
