package pageObjects.HRMS.HRCore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class EmployeePage extends BasePage
{

	public EmployeePage(WebDriver driver)
	{
		super(driver);

	}

	// Setting Button Page Objects
	@FindBy(xpath = "//i[@class='dx-icon dx-icon-setup-icon']")
	WebElement settingButton;

	@FindBy(xpath = "//div[contains(text(),'Delete')]")
	WebElement delete;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[15]")
	WebElement timeline;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[16]")
	WebElement accessRights;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[17]")
	WebElement disableLoginAccess;

	@FindBy(xpath = "//div[contains(text(),'Reset Password')]")
	WebElement resetPassword;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[19]")
	WebElement setting;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[20]")
	WebElement severance;

	// Create Employee Page Objects
	@FindBy(css = "#MainMenu_DXI0_Img")
	WebElement newbtn;

	@FindBy(name = "Email")
	WebElement workEmail;

	@FindBy(name = "Name")
	WebElement name;

	@FindBy(xpath = "//input[contains(@id,'ParentId')]")
	WebElement slctmgr;

	@FindBy(xpath = "//input[contains(@id,'MobileNumber')]")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[contains(@id,'JoiningDate')]")
	WebElement joiningDate;

	@FindBy(xpath = "//div[normalize-space()='OFF']")
	WebElement nonpayroll;

	@FindBy(xpath = "//input[contains(@id,'DepartmentId')]")
	WebElement slctdept;

	@FindBy(xpath = "//input[contains(@id,'DesignationId')]")
	WebElement slctdesg;

	@FindBy(xpath = "//input[contains(@id,'PayrollSetId')]")
	WebElement payrollset;

	@FindBy(xpath = "//input[contains(@id,'CalendarId')]")
	WebElement slctcalendar;

	@FindBy(xpath = "//input[contains(@id,'GratuityId')]")
	WebElement indemnity;

	@FindBy(xpath = "//input[contains(@id,'GradeId')]")
	WebElement grade;

	@FindBy(xpath = "//input[contains(@id,'Gender')]")
	WebElement gender;

	@FindBy(xpath = "//input[contains(@id,'ReligionId')]")
	WebElement religion;

	@FindBy(xpath = "//input[contains(@id,'MaritalStatus')]")
	WebElement maritalstatus;

	@FindBy(xpath = "//div[normalize-space()='No']")
	WebElement systemaccess;

	@FindBy(xpath = "//input[contains(@id,'CustomUsername')]")
	WebElement username;

	@FindBy(xpath = "//input[contains(@id,'RoleIds')]")
	WebElement roles;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//h2[normalize-space()='Suraj']")
	WebElement empname;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/p[1]/span[1]/a[1]")
	WebElement result;

	@FindBy(xpath = "//a[normalize-space()='001 | Vaibhav Chavan']")
	WebElement clkfilteredemp;

	@FindBy(tagName = "h2")
	WebElement empText;

	@FindBy(xpath = "//h4[@class='font-size-h2']")
	WebElement myInfoEmp;

	// Tab Page Objects
	@FindBy(xpath = "//span[contains(text(),'Job')]")
	WebElement job;

	@FindBy(xpath = "//a[@id='employeeProfileMenu_DXI2_T']//span[@class='dx-vam dxm-contentText'][normalize-space()='Payroll']")
	WebElement payroll;

	@FindBy(xpath = "//span[normalize-space()='Time Off']")
	WebElement timeOff;

	@FindBy(xpath = "//a[@id='employeeProfileMenu_DXI4_T']//span[@class='dx-vam dxm-contentText'][normalize-space()='Attendance']")
	WebElement attendance;

	@FindBy(xpath = "//span[normalize-space()='Documents']")
	WebElement documents;

	@FindBy(xpath = "//a[@id='employeeProfileMenu_DXI6_T']//span[@class='dx-vam dxm-contentText'][normalize-space()='Performance']")
	WebElement performance;

	@FindBy(xpath = "//a[@id='employeeProfileMenu_DXI7_T']//span[@class='dx-vam dxm-contentText'][normalize-space()='Learning']")
	WebElement learning;

	@FindBy(xpath = "//span[normalize-space()='Integration']")
	WebElement integration;

	@FindBy(xpath = "//span[normalize-space()='Dependents']")
	WebElement dependents;

	@FindBy(xpath = "//img[@id='employeeProfileMenu_DXI14_PImg']")
	WebElement metaballsMenu;

	@FindBy(xpath = "//span[normalize-space()='Residency Info']")
	WebElement residencyInfo;

	@FindBy(xpath = "//a[@id='employeeProfileMenu_DXI11_T']//span[@class='dx-vam dxm-contentText'][normalize-space()='Onboarding']")
	WebElement onboarding;

	@FindBy(xpath = "//span[normalize-space()='Offboarding']")
	WebElement offboarding;

	@FindBy(xpath = "//span[normalize-space()='Career Path']")
	WebElement careerPath;

	// Personal Tab Page Objects
	@FindBy(xpath = "//input[@name='NameL2']")
	WebElement nameL2;

	@FindBy(name = "DisplayName")
	WebElement displayName;

	@FindBy(name = "DisplayNameL2")
	WebElement displayNameL2;

	@FindBy(xpath = "//input[@aria-haspopup='true']")
	WebElement DOB;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/main[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement clicknationality;

	@FindBy(xpath = "//input[@aria-expanded='true']")
	WebElement nationality;

	@FindBy(xpath = "//input[contains(@id,'BloodGroup')]")
	WebElement clickBloodGroup;

	@FindBy(xpath = "//input[contains(@id,'BloodGroup')]")
	WebElement bloodGroup;

	@FindBy(xpath = "//input[contains(@id,'PhotoVisibility')]")
	WebElement clickPhotoVisibility;

	@FindBy(xpath = "//input[contains(@id,'PhotoVisibility')]")
	WebElement photoVisibility;

	@FindBy(xpath = "//input[contains(@id,'MobileNumberVisibility')]")
	WebElement clickMobileNumberVisibility;

	@FindBy(xpath = "//input[contains(@id,'MobileNumberVisibility')]")
	WebElement mobileNumberVisibility;

	@FindBy(xpath = "//input[contains(@id,'EmailVisibility')]")
	WebElement clickEmailVisibility;

	@FindBy(xpath = "//input[contains(@id,'EmailVisibility')]")
	WebElement emailVisibility;

	// Job Page Objects
	@FindBy(xpath = "//input[contains(@id,'ManagerEmployeeId')]")
	WebElement manager;

	@FindBy(xpath = "//div[@class='dx-switch-off']")
	WebElement keyEmployee;

	@FindBy(xpath = "//input[contains(@id,'SubstituteEmployeeId')]")
	WebElement substituteEmployee;

	@FindBy(xpath = "//input[contains(@id,'EmployeeCategoryId')]")
	WebElement employeeCategory;

	@FindBy(xpath = "//input[contains(@id,'WorkLocationId')]")
	WebElement workLocation;

	@FindBy(xpath = "//input[contains(@id,'EmploymentType')]")
	WebElement employmentType;

	@FindBy(xpath = "//input[contains(@id,'ProbationPeriodInDays')]")
	WebElement probationPeriod;

	@FindBy(xpath = "//input[contains(@id,'NoticePeriodInDays')]")
	WebElement noticePeriod;

	@FindBy(xpath = "//div[@title='Add Work Experience']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addWorkExpButton;

	@FindBy(xpath = "//input[contains(@id,'PriorCompany')]")
	WebElement priorCompany;

	@FindBy(xpath = "//input[contains(@id,'StartDate')]")
	WebElement StartDate;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement saveWorkExp;

	@FindBy(xpath = "//div[@title='Add Qualification']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addQualification;

	@FindBy(xpath = "//input[contains(@id,'QualificationId')]")
	WebElement qualification;

	@FindBy(xpath = "//input[contains(@id,'University')]")
	WebElement university;

	@FindBy(xpath = "//input[contains(@id,'YearOfPassing')]")
	WebElement YOP;

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement saveQualification;

	// Payroll Tab Page Objects
	@FindBy(xpath = "//input[contains(@id,'PayrollSetId')]")
	WebElement payrollsetid;

	@FindBy(xpath = "//div[@id='NonPayroll']//div[@class='dx-switch-off'][normalize-space()='OFF']")
	WebElement nonpayrollbtn;

	@FindBy(xpath = "//input[contains(@id,'PaymentMode')]")
	WebElement paymentMode;

	@FindBy(xpath = "//input[contains(@id,'BankId')]")
	WebElement employeebank;

	@FindBy(xpath = "//input[contains(@id,'BankAccountNumber')]")
	WebElement bankAccountNumber;

	@FindBy(xpath = "//input[contains(@id,'IbanNumber')]")
	WebElement IbanNumber;

	@FindBy(xpath = "//input[contains(@id,'BankAccountType')]")
	WebElement bankAccountType;

	@FindBy(xpath = "//input[contains(@id,'GovtRecruitmentContractLicenseId')]")
	WebElement govtRecruitmentContractLicense;

	// salary Component section
	@FindBy(xpath = "//p[normalize-space()='Salary Components']/../..//i[@class='dx-icon dx-icon-add']")
	WebElement addSalaryComponentsBtn;

	@FindBy(xpath = "//span[normalize-space()='Salary Component']//following::input[contains(@id,'SalaryComponentId')]")
	WebElement salaryComponent;

	@FindBy(xpath = "//input[contains(@id,'Amount')]")
	WebElement amount;

	@FindBy(xpath = "//input[contains(@id,'EffectiveFromDate')]")
	WebElement effectiveFromDate;

	@FindBy(xpath = "//div[@id='SaveButton']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement saveSalComponent;

	// edit basic salary
	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/main[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/i[1]")
	WebElement editBasicSalBtn;

	@FindBy(xpath = "//div[contains(text(),'Change Salary')]")
	WebElement changeSalary;

	@FindBy(xpath = "//input[contains(@id,'IncrementAmount')]")
	WebElement incrementAmount;

	@FindBy(xpath = "//div[@id='SaveButton']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement saveBasicSalary;

	// delete basic salary
	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/main[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[2]/div[1]/i[1]")
	WebElement deleteBasicSalBtn;

	@FindBy(xpath = "//span[normalize-space()='Delete']")
	WebElement deleteBasicSalaryComponent;

	// overtime types section
	@FindBy(xpath = "//p[normalize-space()='Overtime Types']//following::i[@class='dx-icon dx-icon-add']")
	WebElement addOvertimeTypes;

	@FindBy(xpath = "//input[contains(@id,'OvertimeTypeId')]")
	WebElement overtimeType;

	@FindBy(xpath = "//div[@id='EmployeeOvertimeTypePopupForm']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement saveOvertimeType;

	// tickets section
	@FindBy(xpath = "//div[@title='Add Ticket']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addTicketsBtn;

	@FindBy(xpath = "//input[contains(@id,'RelationshipType')]")
	WebElement relationshipType;

	@FindBy(xpath = "//input[contains(@id,'Description')]")
	WebElement description;

	@FindBy(xpath = "//input[contains(@id,'TicketAccrualId')]")
	WebElement ticketAccrual;

	@FindBy(xpath = "//input[contains(@id,'TicketDestinationId')]")
	WebElement ticketDestination;

	@FindBy(xpath = "//span[normalize-space()='Effective From Date:']//following::input[contains(@id,'EffectiveFromDate')]")
	WebElement ticketEffectiveFromDate;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-text']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement saveTicket;

	// Miscellaneous Accrual Earnings section
	@FindBy(xpath = "//div[@title='Add Miscellaneous Accrual Earning']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addMiscellaneousAccrual;

	@FindBy(xpath = "//input[contains(@id,'AccrualType')]")
	WebElement accrualType;

	@FindBy(xpath = "//input[contains(@id,'_Amount')]")
	WebElement accrualAmount;

	@FindBy(xpath = "//input[contains(@id,'ResetAvailedDaysMethod')]")
	WebElement resetAvailedDaysMethod;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement miscellaneousAccrualSave;

	// Benefit Schemes section
	@FindBy(xpath = "//div[@title='Add Benefit Scheme']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addBenefitScheme;

	@FindBy(xpath = "//input[contains(@id,'RelationshipType')]")
	WebElement BSrelationshipType;

	@FindBy(xpath = "//input[contains(@id,'BenefitSchemeId')]")
	WebElement benefitScheme;

	@FindBy(xpath = "/html[1]/body[1]/div[12]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement BSeffectiveFromDate;

	@FindBy(xpath = "/html[1]/body[1]/div[12]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement BSeffectiveToDate;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement BSsave;

	// TimeOff Tab Page Objects
	@FindBy(xpath = "//span[normalize-space()='Assign Leave Type']")
	WebElement assignLeaveType;

	@FindBy(xpath = "//input[contains(@id,'NewLeaveTypeId')]")
	WebElement leaveType;

	@FindBy(xpath = "//input[contains(@id,'EffectiveFromDate')]")
	WebElement LTeffectiveFromDate;

	// Attendance Tab Page Objects
	@FindBy(xpath = "//input[contains(@id,'CalendarId')]")
	WebElement calendar;

	@FindBy(xpath = "//div[@class='dx-switch-off']")
	WebElement presentByDefault;

	@FindBy(xpath = "//input[contains(@id,'CheckInType')]")
	WebElement checkInType;

	@FindBy(xpath = "//input[contains(@id,'DefaultShiftId')]")
	WebElement defaultShift;

	@FindBy(xpath = "//input[contains(@id,'PolicyGroupId')]")
	WebElement policy;

	@FindBy(xpath = "//input[contains(@id,'ShiftPreference')]")
	WebElement shiftPreference;

	// Documents Tab Page Objects
	@FindBy(xpath = "//div[@class='dx-switch-on']")
	WebElement showActive;

	@FindBy(xpath = "//div[@class='dx-switch-off']")
	WebElement showAll;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addDocuments;

	@FindBy(xpath = "//input[contains(@id,'DocumentTypeId')]")
	WebElement documentType;

	@FindBy(xpath = "//input[contains(@id,'DocumentNumber')]")
	WebElement documentNumber;

	@FindBy(xpath = "//input[contains(@id,'DateOfExpiry')]")
	WebElement dateOfExpiry;

	@FindBy(xpath = "//input[contains(@id,'PlaceOfDocument')]")
	WebElement placeOfDocument;

	@FindBy(xpath = "//span[normalize-space()='Add Attachment']")
	WebElement addAttachment;

	// Performance Tab Page Objects
	// Key Result Areas
	@FindBy(xpath = "//div[@title='Add Key Result Area']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addKRABtn;

	@FindBy(xpath = "//input[contains(@id,'KeyResultAreaName')]")
	WebElement KeyResultAreaName;

	@FindBy(xpath = "//input[contains(@id,'Weightage')]")
	WebElement weightage;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement KRAsave;

	// Competencies
	@FindBy(xpath = "//div[@title='Add Competency']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addCompetencies;

	@FindBy(xpath = "//input[contains(@id,'CompetencyName')]")
	WebElement competencyName;

	@FindBy(xpath = "//input[contains(@id,'CompetencyName')]//following::input[contains(@id,'Weightage')]")
	WebElement competenciesWeightage;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement competenciesSave;

	// Skill Sets
	@FindBy(xpath = "//div[@title='Add Skill Set']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addSkillSetBtn;

	@FindBy(xpath = "//input[contains(@id,'SkillSetName')]")
	WebElement skillSetName;

	@FindBy(xpath = "//input[contains(@id,'Level')]")
	WebElement level;

	@FindBy(xpath = "//input[contains(@id,'Level')]//following::input[//input[contains(@id,'Weightage')]][2]")
	WebElement skillSetWeightage;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement skillSetsave;

	// Goals
	@FindBy(xpath = "//div[@title='Add Goal']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addGoalsBtn;

	@FindBy(xpath = "//span[contains(text(),'Goal (Arabic):')]//preceding::input[contains(@id,'GoalName')]")
	WebElement goalName;

	@FindBy(xpath = "//input[contains(@id,'StartDate')]")
	WebElement startDate;

	@FindBy(xpath = "//input[contains(@id,'DueDate')]")
	WebElement dueDate;

	@FindBy(xpath = "//input[contains(@id,'Priority')]")
	WebElement priority;

	@FindBy(xpath = "//input[contains(@id,'DescriptionL2')]//following::input[contains(@id,'Weightage')]")
	WebElement goalsWeightage;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement goalSave;

	// Integration Tab Page Objects
	// Cost Allocation section
	@FindBy(xpath = "//input[contains(@id,'FinancialIntegrationGroupId')]")
	WebElement financialIntegrationGroup;

	@FindBy(xpath = "//input[contains(@id,'Segment1')]")
	WebElement division;

	@FindBy(xpath = "//input[contains(@id,'Segment2')]")
	WebElement department;

	@FindBy(xpath = "//input[contains(@id,'Segment3')]")
	WebElement project;

	@FindBy(xpath = "//input[contains(@id,'Segment4')]")
	WebElement segmentWorkLocation;

	// Default Cost Allocation section
	@FindBy(xpath = "//i[@class='dx-icon dx-icon-add']")
	WebElement defaultCostAllocationBtn;

	@FindBy(xpath = "//input[contains(@id,'FromPeriodId')]")
	WebElement FromPeriod;

	@FindBy(xpath = "//input[contains(@id,'ToPeriodId')]")
	WebElement ToPeriod;

	@FindBy(xpath = "//div[@aria-label='Data grid with 0 rows and 5 columns']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addRowBtn;

	@FindBy(xpath = "//div[@class='dx-show-invalid-badge dx-textbox dx-texteditor dx-editor-outlined dx-texteditor-empty dx-widget']//input[@role='textbox']")
	WebElement sdivision;

	@FindBy(xpath = "//div[@class='dx-show-invalid-badge dx-textbox dx-texteditor dx-editor-outlined dx-texteditor-empty dx-widget']//input[@role='textbox']")
	WebElement sdepartment;

	@FindBy(xpath = "td[role='gridcell'][aria-describedby='dx-col-9']")
	WebElement sproject;

	@FindBy(xpath = "td[role='gridcell'][aria-describedby='dx-col-10']")
	WebElement sWorkLocation;

	@FindBy(xpath = "//div[@id='SaveButton']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement costAllocationsave;

	// Project section
	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/main[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/i[1]")
	WebElement AddProjectsBtn;

	@FindBy(xpath = "//input[contains(@id,'ProjectId')]")
	WebElement Project;

	@FindBy(xpath = "//input[contains(@id,'EffectiveFromDate')]")
	WebElement EffectiveFromDate;

	@FindBy(xpath = "//input[contains(@id,'EffectiveToDate')]")
	WebElement EffectiveToDate;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@aria-label='Save']//div[@class='dx-button-content']")
	WebElement empProjectsave;

	// Dependents Tab Page Objects

	// Spouse section
	@FindBy(xpath = "//div[@title='Add Spouse']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addSpousesBtn;

	@FindBy(xpath = "//span[normalize-space()='Name:']//following::input[contains(@id,'Name')][1]")
	WebElement spouseName;

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement birthDate;

	@FindBy(xpath = "//input[contains(@id,'MarriageDate')]")
	WebElement marriageDate;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement spouseSave;

	// Childrens section
	@FindBy(xpath = "//div[@title='Add Child']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addChildrensBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement childrenName;

	@FindBy(xpath = "/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement childrenBirthDate;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement childrenSave;

	// Others section
	@FindBy(xpath = "//div[@title='Add Dependent']//i[@class='dx-icon dx-icon-edit-button-addrow']")
	WebElement addOthersBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement dependentName;

	@FindBy(xpath = "/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement dependentBirthDate;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']//span[@class='dx-button-text'][normalize-space()='Save']")
	WebElement OtherSave;

	// ResidencyInfo Tab Page Objects
	// basic details
	@FindBy(name = "SecondName")
	WebElement secondName;

	@FindBy(name = "ThirdName")
	WebElement thirdName;

	@FindBy(name = "FourthName")
	WebElement fourthName;

	@FindBy(name = "LastName")
	WebElement lastName;

	@FindBy(name = "FirstNameL2")
	WebElement firstNameArabic;

	@FindBy(name = "SecondNameL2")
	WebElement secondNameArabic;

	@FindBy(name = "ThirdNameL2")
	WebElement thirdNameArabic;

	@FindBy(name = "FourthNameL2")
	WebElement fourthNameArabic;

	@FindBy(name = "LastNameL2")
	WebElement lastNameArabic;

	@FindBy(name = "BirthPlace")
	WebElement birthPlace;

	// Work Permit Details
	@FindBy(xpath = "//div[@class='dx-switch-off']")
	WebElement OnCompanyResidencyYes;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	WebElement OnCompanyResidencyNo;

	@FindBy(xpath = "//input[contains(@id,'DateOfEntry')]")
	WebElement dateOfEntry;

	@FindBy(xpath = "//input[contains(@id,'VisaNumber')]")
	WebElement VisaNumber;

	@FindBy(xpath = "//input[contains(@id,'WorkPermitNumber')]")
	WebElement WorkPermitNumber;

	@FindBy(xpath = "//input[contains(@id,'ResidenceNumber')]")
	WebElement ResidenceNumber;

	@FindBy(xpath = "//input[contains(@id,'ContractQualification')]")
	WebElement ContractQualification;

	@FindBy(xpath = "//input[contains(@id,'NewResidencyPeriod')]")
	WebElement NewResidencyPeriod;

	@FindBy(xpath = "//input[contains(@id,'NewGovtDesignationId')]")
	WebElement NewGovtDesignation;

	@FindBy(xpath = "//input[contains(@id,'GovtRecruitmentContractLicenseId')]")
	WebElement GovtLicense;

	@FindBy(xpath = "//input[contains(@id,'NewContractSalary')]")
	WebElement NewContractSalary;

	@FindBy(xpath = "//input[contains(@id,'OldContractSalary')]")
	WebElement OldContractSalary;

	// Address Details
	@FindBy(xpath = "//input[contains(@id,'Block')]")
	WebElement Block;

	@FindBy(xpath = "//input[contains(@id,'BuildingNumber')]")
	WebElement BuildingNumber;

	@FindBy(xpath = "//input[contains(@id,'FlatNumber')]")
	WebElement FlatNumber;

	@FindBy(xpath = "//input[contains(@id,'FloorNumber')]")
	WebElement FloorNumber;

	@FindBy(xpath = "//input[contains(@id,'Lane')]")
	WebElement Lane;

	@FindBy(xpath = "//input[contains(@id,'TypeOfBuilding')]")
	WebElement TypeOfBuilding;

	@FindBy(xpath = "//input[contains(@id,'Street')]")
	WebElement Street;

	@FindBy(xpath = "//input[contains(@id,'Qasima')]")
	WebElement Qasima;

	@FindBy(xpath = "//input[contains(@id,'Area')]")
	WebElement Area;

	@FindBy(xpath = "//input[contains(@id,'PaciNumber')]")
	WebElement PaciNumber;

	// Previous Sponsor Details
	@FindBy(xpath = "//input[contains(@id,'PreviousSponsorName')]")
	WebElement PreviousSponsorName;

	@FindBy(xpath = "//input[contains(@id,'PreviousCompanyAuthorizedSign')]")
	WebElement PreviousCompanyAuthorizedSign;

	@FindBy(xpath = "//input[contains(@id,'PreviousCompanyName')]")
	WebElement PreviousCompanyName;

	@FindBy(xpath = "//input[contains(@id,'OldGovtDesignationId')]")
	WebElement OldGovtDesignation;

	@FindBy(xpath = "//input[contains(@id,'OldFileNumber')]")
	WebElement OldFileNumber;

	@FindBy(xpath = "//input[contains(@id,'OldGovernmentLicense')]")
	WebElement OldGovernmentLicense;

	// Delete Employee Page Objects
	// @FindBy(xpath = "//i[@class='dx-icon dx-icon-setup-icon']")
	// WebElement settingButton;

	// @FindBy(xpath = "//div[contains(text(),'Delete')]")
	// WebElement delete;

	// @FindBy(xpath = "//span[normalize-space()='Ok']")
	// WebElement ok;

	// @FindBy(xpath =
	// "/html[1]/body[1]/div[9]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")
	// WebElement ok;

	// @FindBy(xpath = "div[aria-label='Ok'] span[class='dx-button-text']")
	// WebElement ok;

	@FindBy(xpath = "//div[@aria-label='Ok']//div[@class='dx-button-content']")
	WebElement ok;

	@FindBy(xpath = "//img[@class='account-image']")
	WebElement rightAreaMenu;

	@FindBy(xpath = "//span[normalize-space()='Log Off']")
	WebElement logOff;

	// Setting Button Action Methods
	public void clickResetPwd()
	{
		resetPassword.click();
	}

	// Create Employee Action Methods
	public void clickNewBtn()
	{
		clickOnNew();
	}

	public void provideWorkEmail(String email)
	{
		workEmail.sendKeys(email);
	}

	public void provideName(String value)
	{
		name.sendKeys(value);
	}

	public void selectMgr(String value)
	{
		provideAndEnter(slctmgr, value);
	}

	public void provideMobileNumber(String mbl)
	{
		mobileNumber.sendKeys(mbl);
	}

	public void provideDOJ(String doj)
	{
		provideAndEnter(joiningDate, doj);
	}

	public void clickNonPayrollBtn()
	{
		nonpayroll.click();
	}

	public void selectDepartment(String dept)
	{
		provideAndEnter(slctdept, dept);
	}

	public void selectDesignation(String desg)
	{
		provideAndEnter(slctdesg, desg);
	}

	public void selectPayrollSet(String value)
	{
		provideAndEnter(payrollset, value);
	}

	public void selectCalendar(String value)
	{
		provideAndEnter(slctcalendar, value);
	}

	public void selectIndemnity(String value)
	{
		provideAndEnter(indemnity, value);
	}

	public void selectGrade(String value)
	{
		provideAndEnter(grade, value);
	}

	public void selectGender(String value)
	{
		provideAndEnter(gender, value);
	}

	public void selectReligion(String value)
	{
		provideAndEnter(religion, value);
	}

	public void selectMaritalStatus(String value)
	{
		provideAndEnter(maritalstatus, value);
	}

	public void clickSystemAccessBtn()
	{
		systemaccess.click();
	}

	public void provideUserName(String actusername)
	{
		username.sendKeys(actusername);
	}

	public void clickRoles() throws InterruptedException
	{
		roles.click();
		waitTS(1);
	}

	public void selectRole(String value)
	{
		provideAndEnter(roles, value);
	}

	public void clickSave()
	{
		clickOnSave();
	}

	public boolean validate(String value)
	{
		String empNm = empText.getText();
		return empNm.contains(value);
	}

	public boolean myInfoValidation(String value)
	{
		String empNm = myInfoEmp.getText();
		return empNm.contains(value);
	}

	public boolean isEmployeeCreated(String empname)
	{
		return resultEmployee().contains(empname);
	}

	// Tab Action Methods
	public void clickJob()
	{
		job.click();
	}

	public void clickPayroll()
	{
		payroll.click();
	}

	public void clickTimeOff()
	{
		timeOff.click();
	}

	public void clickAttendance()
	{
		attendance.click();
	}

	public void clickDocuments()
	{
		documents.click();
	}

	public void clickPerformance()
	{
		performance.click();
	}

	public void clickLearning()
	{
		learning.click();
	}

	public void clickIntegration()
	{
		integration.click();
	}

	public void clickDependents()
	{
		dependents.click();
	}

	public void clickMetaballsMenu()
	{
		metaballsMenu.click();
	}

	public void clickResidencyInfo()
	{
		residencyInfo.click();
	}

	public void clickOnboarding()
	{
		onboarding.click();
	}

	public void clickOffboarding()
	{
		offboarding.click();
	}

	public void clickCareerPath()
	{
		careerPath.click();
	}

	// Personal Tab Action Methods
	public void provideNameL2(String value)
	{
		nameL2.sendKeys(value);
	}

	public void provideDisplayName(String value)
	{
		displayName.sendKeys(value);
	}

	public void provideDisplayNameL2(String value)
	{
		displayNameL2.sendKeys(value);
	}

	public void provideDOB(String value)
	{
		DOB.sendKeys(value);
	}

	public void clickNationality()
	{
		clicknationality.click();
	}

	public void selectNationality(String value)
	{
		selectDropdownOption(value);
	}

	public void clickBloodGroup() throws InterruptedException
	{
		clickBloodGroup.click();
		waitTS(1);
	}

	public void selectBloodGroup(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickPhotoVisibility() throws InterruptedException
	{
		clickPhotoVisibility.click();
		waitTS(1);
	}

	public void selectPhotoVisibility(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickMblNoVisibility() throws InterruptedException
	{
		clickMobileNumberVisibility.click();
		waitTS(1);
	}

	public void selectMblNoVisibility(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickEmailVisibility() throws InterruptedException
	{
		clickEmailVisibility.click();
		waitTS(1);
	}

	public void selectEmailVisibility(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	// Job Action Methods
	public void clickManager() throws InterruptedException
	{
		manager.click();
		waitTS(1);
	}

	public void selectManager(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void enableKeyEmp() throws InterruptedException
	{
		keyEmployee.click();
		waitTS(1);
	}

	public void clickSubstituteEmployee() throws InterruptedException
	{
		substituteEmployee.click();
		waitTS(1);
	}

	public void selectSubstituteEmployee(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickEmployeeCategory() throws InterruptedException
	{
		employeeCategory.click();
		waitTS(1);
	}

	public void selectEmployeeCategory(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickWorkLocation() throws InterruptedException
	{
		workLocation.click();
		waitTS(1);
	}

	public void selectWorkLocation(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickEmploymentType() throws InterruptedException
	{
		employmentType.click();
		waitTS(1);
	}

	public void selectEmploymentType(String value) throws InterruptedException
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void provideProbationPeriod(String value) throws InterruptedException
	{
		probationPeriod.click();
		probationPeriod.sendKeys(Keys.CONTROL + "a");
		probationPeriod.sendKeys(Keys.DELETE);
		probationPeriod.sendKeys(value);
		waitTS(1);
	}

	public void provideNoticePeriod(String value) throws InterruptedException
	{
		noticePeriod.click();
		noticePeriod.sendKeys(Keys.CONTROL + "a");
		noticePeriod.sendKeys(Keys.DELETE);
		noticePeriod.sendKeys(value);
		waitTS(1);
	}

	// work experience starts
	public void clickAddWorkExpBtn() throws InterruptedException
	{
		addWorkExpButton.click();
		waitTS(1);
	}

	public void providePriorCompany(String value) throws InterruptedException
	{
		priorCompany.sendKeys(value);
		waitTS(1);
	}

	public void provideStartDate(String value) throws InterruptedException
	{
		StartDate.sendKeys(value);
		waitTS(1);
	}

	public void clickSaveBtn() throws InterruptedException
	{
		saveWorkExp.click();
		waitTS(1);
	}
	// work experience ends

	// qualification starts
	public void addQualificationBtn() throws InterruptedException
	{
		addQualification.click();
		waitTS(1);
	}

	public void clickQualification() throws InterruptedException
	{
		qualification.click();
		waitTS(1);
	}

	public void selectQualification() throws InterruptedException
	{
		selectDropdownOption("BCA");
		waitTS(1);
	}

	public void provideUniversity(String value) throws InterruptedException
	{
		university.sendKeys(value);
		waitTS(1);
	}

	public void provideYOP(String value)
	{
		YOP.sendKeys(value);
		waitTS(1);
	}

	public void saveQualification()
	{
		saveQualification.click();
		waitTS(1);
	}
	// qualification ends

	// Payroll Tab Action Methods
	public void clickPayrollSetID()
	{
		payrollsetid.click();
	}

	public void selectPayrollSetID(String value)
	{
		selectDropdownOption(value);
	}

	public void enableNonPayrollBtn()
	{
		nonpayrollbtn.click();
	}

	public void clickPaymentMode()
	{
		paymentMode.click();
	}

	public void selectPaymentMode(String value)
	{
		selectDropdownOption(value);
	}

	public void clickEmpBank()
	{
		employeebank.click();
		waitTS(1);
	}

	public void selectEmpBank(String value)
	{
		selectDropdownOption(value);
	}

	public void provideBankAcNo()
	{
		bankAccountNumber.sendKeys(randomNumber());
	}

	public void provideIBANNo()
	{
		IbanNumber.sendKeys(randomNumber());
	}

	public void clickBankAcType()
	{
		bankAccountType.click();
	}

	public void selectBankAcType(String value)
	{
		selectDropdownOption(value);
	}

	public void clickGovtLicense()
	{
		govtRecruitmentContractLicense.click();
		waitTS(1);
	}

	public void selectGovtLicense(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void deleteBasicSalaryComponent()
	{
		WebElement elementToHover = driver.findElement(By.xpath("..."));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		deleteBasicSalBtn.click();
		waitTS(2);
		deleteBasicSalaryComponent.click();
	}

	public void editBasicSalaryComponent(String value)
	{
		WebElement elementToHover = driver.findElement(By.xpath("..."));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		editBasicSalBtn.click();
		waitTS(1);
		changeSalary.click();
		incrementAmount.click();
		incrementAmount.sendKeys(Keys.CONTROL + "a");
		incrementAmount.sendKeys(Keys.DELETE);
		incrementAmount.sendKeys(value);
		waitTS(1);
		saveBasicSalary.click();
	}

	public void provideBasicSalAmt(String value)
	{
		incrementAmount.click();
		incrementAmount.sendKeys(Keys.CONTROL + "a");
		incrementAmount.sendKeys(Keys.DELETE);
		incrementAmount.sendKeys(value);
		waitTS(1);
	}

	public void clickAddSalaryComponentBtn()
	{
		addSalaryComponentsBtn.click();
		waitTS(1);
	}

	public void clickSalaryComponent()
	{
		salaryComponent.click();
		waitTS(1);
	}

	public void selectSalComponent(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void provideAmt(String value)
	{
		amount.click();
		amount.sendKeys(Keys.CONTROL + "a");
		amount.sendKeys(Keys.DELETE);
		amount.sendKeys(value);
		waitTS(1);
	}

	public void provideEffectiveFromDate(String value)
	{
		effectiveFromDate.click();
		effectiveFromDate.sendKeys(Keys.CONTROL + "a");
		effectiveFromDate.sendKeys(Keys.DELETE);
		effectiveFromDate.sendKeys(value);
		waitTS(1);
	}

	public void saveSalComponent()
	{
		saveSalComponent.click();
		waitTS(5);
	}

	public void clickOvertimeTypesBtn()
	{
		addOvertimeTypes.click();
	}

	public void clickOvertimeType()
	{
		overtimeType.click();
		waitTS(1);
	}

	public void selectOvertimeType(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void saveOvertimeType()
	{
		saveOvertimeType.click();
		waitTS(5);
	}

	public void scrollDownWebPageTicket()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Tickets')]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void addTicketBtn()
	{
		addTicketsBtn.click();
		waitTS(1);
	}

	public void clickRelationshipType()
	{
		relationshipType.click();
		waitTS(1);
	}

	public void selectRelationshipType(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void provideDesc(String value)
	{
		description.sendKeys(value);
		waitTS(1);
	}

	public void clickTicketAccrual()
	{
		ticketAccrual.click();
		waitTS(1);
	}

	public void selectTicketAccrual(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickTicketDestination()
	{
		ticketDestination.click();
		waitTS(1);
	}

	public void selectTicketDestination(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void provideTicketEffectiveFromDate(String value)
	{
		ticketEffectiveFromDate.sendKeys(value);
		waitTS(1);
	}

	public void clickSaveTicket()
	{
		saveTicket.click();
		waitTS(1);
	}

	public void clickAddMiscellaneousAccrualEarnings()
	{
		addMiscellaneousAccrual.click();
		waitTS(1);
	}

	public void clickAccrualType()
	{
		accrualType.click();
		waitTS(1);
	}

	public void selectAccrualType(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickResetAvailedDaysMethod()
	{
		resetAvailedDaysMethod.click();
		waitTS(1);
	}

	public void selectResetAvailedDaysMethod(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void saveMiscellaneousAccrual()
	{
		miscellaneousAccrualSave.click();
		waitTS(1);
	}

	public void clickBenefitSchemes()
	{
		waitTS(1);
		addBenefitScheme.click();
		waitTS(1);
	}

	public void clickRelationshipTypeBS()
	{
		BSrelationshipType.click();
		waitTS(1);
	}

	public void bsSelectRelationshipType(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickBenefitScheme()
	{
		benefitScheme.click();
		waitTS(1);
	}

	public void selectBenefitScheme(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void provideBSEffectiveFromDate(String value)
	{
		BSeffectiveFromDate.sendKeys(value);
		waitTS(1);
	}

	public void provideBSEffectiveToDate(String value)
	{
		BSeffectiveToDate.sendKeys(value);
		waitTS(1);
	}

	public void bsSave()
	{
		BSsave.click();
	}

	// TimeOff Tab Action Methods
	public void clickAssignLeaveType()
	{
		assignLeaveType.click();
	}

	public void clickLeaveType()
	{
		leaveType.click();
		waitTS(1);
	}

	public void selectLeaveType(String value)
	{
		selectDropdownOption(value);
	}

	public void ltProvideEffectiveFromDate(String value)
	{
		LTeffectiveFromDate.click();
		LTeffectiveFromDate.sendKeys(Keys.CONTROL + "a");
		LTeffectiveFromDate.sendKeys(Keys.DELETE);
		LTeffectiveFromDate.sendKeys(value);
		waitTS(1);
	}

	public void ltClickSave()
	{
		clickSave();
	}

	// Attendance Tab Action Methods
	public void clickAttendanceCalendar()
	{
		calendar.click();
		waitTS(1);
	}

	public void selectAttendanceCalendar(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void enablePresentByDefault()
	{
		presentByDefault.click();
		waitTS(1);
	}

	public void clickCheckInType()
	{
		checkInType.click();
		waitTS(1);
	}

	public void selectCheckInType(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickDefaultShift()
	{
		defaultShift.click();
		waitTS(1);
	}

	public void selectDefaultShift(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickPolicy()
	{
		policy.click();
		waitTS(1);
	}

	public void selectPolicy(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void clickShiftPreference()
	{
		shiftPreference.click();
		waitTS(1);
	}

	public void selectShiftPreference(String value)
	{
		selectDropdownOption(value);
	}

	// Documents Tab Action Methods
	public void showActiveDocs()
	{
		showActive.click();
	}

	public void showAllDocs()
	{
		showAll.click();
	}

	public void addDocuments()
	{
		addDocuments.click();
		waitTS(1);
	}

	public void clickDocType()
	{
		documentType.click();
		waitTS(1);
	}

	public void selectDocType(String value)
	{
		selectDropdownOption(value);
	}

	public void provideDocNumber()
	{
		documentNumber.sendKeys(randomNumber());
	}

	public void provideDateOfExpiry(String value)
	{
		dateOfExpiry.sendKeys(value);
	}

	public void clickPlaceOfDocument()
	{
		placeOfDocument.click();
	}

	public void selectPlaceOfDocument(String value)
	{
		selectDropdownOption(value);
	}

	public void empDocClickSave()
	{
		clickSave();
		waitTS(1);
	}

	public void addAttachment()
	{
		addAttachment.sendKeys("C:\\\\Users\\\\admin\\\\Downloads\\\\Employee Contract_190120251111.pdf");
	}

	// Performance Tab Action Methods
	public void addKRABtn()
	{
		addKRABtn.click();
	}

	public void clickKeyResultAreaName()
	{
		KeyResultAreaName.click();
		waitTS(1);
	}

	public void selectResultAreaName(String value)
	{
		selectDropdownOption(value);
	}

	public void provideWeightage(String value)
	{
		weightage.sendKeys(value);
	}

	public void clickKRAsave()
	{
		KRAsave.click();
		waitTS(1);
	}

	public void clickAddCompetencies()
	{
		addCompetencies.click();
	}

	public void clickCompetencyName()
	{
		competencyName.click();
		waitTS(1);
	}

	public void selectCompetencyName(String value)
	{
		selectDropdownOption(value);
	}

	public void provideCompetenciesWeightage(String value)
	{
		competenciesWeightage.sendKeys(value);
	}

	public void clickCompetenciesSave()
	{
		competenciesSave.click();
		waitTS(1);
	}

	public void clickaddSkillSetBtn()
	{
		addSkillSetBtn.click();
		waitTS(1);
	}

	public void clickSkillSetName()
	{
		skillSetName.click();
		waitTS(1);
	}

	public void selectSkillSetName(String value)
	{
		selectDropdownOption(value);
	}

	public void clickLevel()
	{
		level.click();
		waitTS(1);
	}

	public void selectLevel(String value)
	{
		selectDropdownOption(value);
	}

	public void provideSkillSetWeightage(String value)
	{
		skillSetWeightage.sendKeys(value);
	}

	public void clickskillSetsave()
	{
		skillSetsave.click();
		waitTS(2);
	}

	public void clickaddGoalsBtn()
	{
		addGoalsBtn.click();
	}

	public void provideGoalName(String value)
	{
		goalName.sendKeys(value);
	}

	public void provideGoalsStartDate(String value)
	{
		startDate.sendKeys(value);
	}

	public void provideGoalsDueDate(String value)
	{
		dueDate.sendKeys(value);
	}

	public void clickPriority()
	{
		priority.click();
		waitTS(1);
	}

	public void selectPriority(String value)
	{
		selectDropdownOption(value);
	}

	public void provideGoalsWeightage(String value)
	{
		goalsWeightage.sendKeys(value);
	}

	public void clickGoalSave()
	{
		goalSave.click();
		waitTS(1);
	}

	// Integration Tab Action Methods
	public void clickFinancialIntegrationGroup()
	{
		financialIntegrationGroup.click();
	}

	public void selectFinancialIntegrationGroup(String value)
	{
		selectDropdownOption(value);
	}

	public void provideDivision(String value)
	{
		division.sendKeys(value);
	}

	public void provideDepartment(String value)
	{
		department.sendKeys(value);
	}

	public void provideProject(String value)
	{
		project.sendKeys(value);
	}

	public void provideSegmentWorkLocation(String value)
	{
		segmentWorkLocation.sendKeys(value);
		waitTS(1);
	}

	public void clickDefaultCostAllocationBtn()
	{
		defaultCostAllocationBtn.click();
		waitTS(1);
	}

	public void clickFromPeriod()
	{
		FromPeriod.click();
		waitTS(1);
	}

	public void selectFromPeriod(String value)
	{
		selectDropdownOption(value);
	}

	public void clickToPeriod()
	{
		ToPeriod.click();
		waitTS(1);
	}

	public void selectToPeriod(String value)
	{
		selectDropdownOption(value);
	}

	public void clickAddRowBtn()
	{
		addRowBtn.click();
	}

	public void providesdivision(String value)
	{
		sdivision.sendKeys(value);
	}

	public void providesdepartment(String value)
	{
		sdepartment.sendKeys(value);
	}

	public void providesproject(String value)
	{
		sproject.sendKeys(value);
	}

	public void providesWorkLocation(String value)
	{
		sWorkLocation.sendKeys(value);
	}

	public void clickCostAllocationsave()
	{
		costAllocationsave.click();
	}

	public void clickAddProjectsBtn()
	{
		AddProjectsBtn.click();
		waitTS(1);
	}

	public void clickProject()
	{
		Project.click();
		waitTS(1);
	}

	public void selectProject(String value)
	{
		selectDropdownOption(value);
	}

	public void provideProjectEffectiveFromDate(String value)
	{
		EffectiveFromDate.sendKeys(value);
	}

	public void provideProjectEffectiveToDate(String value)
	{
		EffectiveToDate.sendKeys(value);
	}

	public void clickEmpProjectsave()
	{
		empProjectsave.click();
		waitTS(1);
	}

	public void saveAllInfo()
	{
		clickSave();
	}

	// Dependents Tab Action Methods
	public void clickAddSpousesBtn()
	{
		addSpousesBtn.click();
	}

	public void provideSpouseName(String value)
	{
		spouseName.sendKeys(value);
	}

	public void provideSpouseBirthDate(String value)
	{
		birthDate.sendKeys(value);
	}

	public void provideSpouseMarriageDate(String value)
	{
		marriageDate.sendKeys(value);
	}

	public void clickAddChildrensBtn()
	{
		addChildrensBtn.click();
	}

	public void provideChildrenName(String value)
	{
		childrenName.sendKeys(value);
	}

	public void providechildrenBirthDate(String value)
	{
		childrenBirthDate.sendKeys(value);
	}

	public void clickChildrenSave()
	{
		childrenSave.click();
	}

	public void clickAddOthersBtn()
	{
		addOthersBtn.click();
	}

	public void provideDependentName(String value)
	{
		dependentName.sendKeys(value);
	}

	public void provideDependentBirthDate(String value)
	{
		dependentBirthDate.sendKeys(value);
	}

	public void clickOtherSave()
	{
		OtherSave.click();
	}

	// ResidencyInfo Tab Action Methods
	public void provideSecondName(String value)
	{
		secondName.sendKeys(value);
	}

	public void providethirdName(String value)
	{
		thirdName.sendKeys(value);
	}

	public void providefourthName(String value)
	{
		fourthName.sendKeys(value);
	}

	public void providelastName(String value)
	{
		lastName.sendKeys(value);
	}

	public void providebirthPlace(String value)
	{
		birthPlace.sendKeys(value);
	}

	public void providedateOfEntry(String value)
	{
		dateOfEntry.sendKeys(value);
	}

	public void provideVisaNumber(String value)
	{
		VisaNumber.sendKeys(value);
	}

	public void provideWorkPermitNumber(String value)
	{
		WorkPermitNumber.sendKeys(value);
	}

	public void provideResidenceNumber(String value)
	{
		ResidenceNumber.sendKeys(value);
		waitTS(2);
	}

	public void clickContractQualification()
	{
		ContractQualification.click();
	}

	public void selectContractQualification(String value)
	{
		selectDropdownOption(value);
	}

	public void clickNewResidencyPeriod()
	{
		NewResidencyPeriod.click();
		waitTS(1);
	}

	public void selectNewResidencyPeriod(String value)
	{
		selectDropdownOption(value);
	}

	public void clickNewGovtDesignation()
	{
		NewGovtDesignation.click();
		waitTS(1);
	}

	public void selectNewGovtDesignation(String value)
	{
		selectDropdownOption(value);
	}

	public void clickGovermenttLicense()
	{
		GovtLicense.click();
		waitTS(1);
	}

	public void selectGovermenttLicense(String value)
	{
		selectDropdownOption(value);
	}

	public void provideNewContractSalary(String value)
	{
		NewContractSalary.sendKeys(value);
	}

	public void scrollDownWebPageOldContract()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//input[contains(@id,'OldContractSalary')]")));
	}

	public void provideOldContractSalary(String value)
	{
		OldContractSalary.sendKeys(value);
	}

	public void provideBlock(String value)
	{
		Block.sendKeys(value);
	}

	public void provideBuildingNumber(String value)
	{
		BuildingNumber.sendKeys(value);
	}

	public void provideFlatNumber(String value)
	{
		FlatNumber.sendKeys(value);
	}

	public void provideFloorNumber(String value)
	{
		FloorNumber.sendKeys(value);
	}

	public void provideLane(String value)
	{
		Lane.sendKeys(value);
	}

	public void clickTypeOfBuilding()
	{
		TypeOfBuilding.click();
		waitTS(1);
	}

	public void selectTypeOfBuilding(String value)
	{
		selectDropdownOption(value);
	}

	public void provideStreet(String value)
	{
		Street.sendKeys(value);
	}

	public void provideQasima(String value)
	{
		Qasima.sendKeys(value);
	}

	public void provideArea(String value)
	{
		Area.sendKeys(value);
	}

	public void providePaciNumber(String value)
	{
		PaciNumber.sendKeys(value);
	}

	public void providePreviousSponsorName(String value)
	{
		PreviousSponsorName.sendKeys(value);
	}

	public void providePreviousCompanyAuthorizedSign(String value)
	{
		PreviousCompanyAuthorizedSign.sendKeys(value);
	}

	public void providePreviousCompanyName(String value)
	{
		PreviousCompanyName.sendKeys(value);
	}

	public void clickOldGovtDesignation(String value)
	{
		OldGovtDesignation.click();
		waitTS(2);
	}

	public void selectOldGovtDesignation(String value)
	{
		selectDropdownOption(value);
		waitTS(1);
	}

	public void provideOldFileNumber(String value)
	{
		OldFileNumber.sendKeys(value);
	}

	public void provideOldGovernmentLicense(String value)
	{
		OldGovernmentLicense.sendKeys(value);
	}

	public void saveResidencyInfo()
	{
		clickSave();
	}

	// Delete Employee Action Methods
	public void clickSettingButton()
	{
		settingButton.click();
		waitTS(2);
	}

	public void clickDelete()
	{
		delete.click();
		waitTS(2);
	}

	public void clickOk()
	{
		ok.click();
		waitTS(3);
	}

	public void clickRightAreaMenu()
	{
		rightAreaMenu.click();
		waitTS(1);
	}

	public void clicklogOff()
	{
		logOff.click();
	}

	public boolean validateEmpDelete(String value)
	{
		filterByIndex(2, value);
		waitTS(2);
		String employee = resultValue(1);
		return employee.contains(value);
	}

}
