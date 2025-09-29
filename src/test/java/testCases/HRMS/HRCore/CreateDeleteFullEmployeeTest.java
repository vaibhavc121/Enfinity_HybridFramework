package testCases.HRMS.HRCore;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.HRCore.HRCore.EmployeeModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.HRCore.EmployeePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateDeleteFullEmployeeTest extends BaseTest
{
    // region Create New Payroll Employee
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createNewPayrollEmployee()
    {
        try
        {
            EmployeeTest et = new EmployeeTest();
            et.createEmployee();
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region Personal Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void verifyPersonalTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.PersonalTabModel> personalTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "personal",
                    EmployeeModel.PersonalTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.PersonalTabModel data : personalTabInfo)
            {
                ep.provideNameL2(data.nameL2);
                log("provided nameL2: " + data.nameL2);

                ep.provideDisplayName(data.displayName);
                log("provided displayName: " + data.displayName);

                ep.provideDisplayNameL2(data.displayNameL2);
                log("provided displayNameL2: " + data.displayNameL2);

                ep.provideDOB(data.DOB);
                log("provided DOB: " + data.DOB);

                ep.selectMaritialStatus(data.maritalStatus);
                log("selected marital status: " + data.maritalStatus);

                ep.selectNationality(data.nationality);
                log("selected nationality: " + data.nationality);

                //ep.provideMobileNo();

                ep.clickBloodGroup();
                log("clicked on blood group dropdown");

                ep.selectBloodGroup(data.bloodGroup);
                log("selected blood group: " + data.bloodGroup);

                BasePage.pressTab();

                ep.clickPhotoVisibility();
                log("clicked on photo visibility dropdown");

                ep.selectPhotoVisibility(data.photoVisibility);
                log("selected photo visibility: " + data.photoVisibility);

                ep.clickMblNoVisibility();
                log("clicked on mobile number visibility dropdown");

                ep.selectMblNoVisibility(data.mobileNumberVisibility);
                log("selected mobile number visibility: " + data.mobileNumberVisibility);

                ep.clickEmailVisibility();
                log("clicked on email visibility dropdown");

                ep.selectEmailVisibility(data.emailVisibility);
                log("selected email visibility: " + data.emailVisibility);

                BasePage.clickOnSave();
                log("clicked on Save button to save personal information");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region Job Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void verifyJobTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.JobTabModel> jobTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "job",
                    EmployeeModel.JobTabModel.class);

            EmployeePage ep = new EmployeePage();
            ep.navigateToEmp();
            for (EmployeeModel.JobTabModel data : jobTabInfo)
            {
                ep.clickJob();
                log("Clicked on Job Tab");

                ep.clickManager();
                log("clicked on manager dropdown");

                ep.selectManager(data.manager);
                log("selected manager: " + data.manager);

                ep.enableKeyEmp();
                log("enabled key employee checkbox");

                ep.clickSubstituteEmployee();
                log("clicked on substitute employee dropdown");

                ep.selectSubstituteEmployee(data.substituteEmployee);
                log("selected substitute employee: " + data.substituteEmployee);

                ep.clickEmployeeCategory();
                log("clicked on employee category dropdown");

                ep.selectEmployeeCategory(data.category);
                log("selected employee category: " + data.category);

                ep.clickWorkLocation();
                log("clicked on work location dropdown");

                ep.selectWorkLocation(data.workLocation);
                log("selected work location: " + data.workLocation);

                ep.clickEmploymentType();
                log("clicked on employment type dropdown");

                ep.selectEmploymentType(data.employmentType);
                log("selected employment type: " + data.employmentType);

                ep.provideProbationPeriod(data.probationPeriod);
                log("provided probation period: " + data.probationPeriod);

                ep.provideNoticePeriod(data.noticePeriod);
                log("provided notice period: " + data.noticePeriod);

                //region work experience section
                ep.clickAddWorkExpBtn();
                log("clicked on add work experience button");

                ep.providePriorCompany(data.priorCompany);
                log("provided prior company: " + data.priorCompany);

                ep.provideStartDate(data.startDate);
                log("provided start date: " + data.startDate);

                ep.clickSaveBtn();
                log("clicked on save button");
                //endregion

                //region qualification section
                ep.addQualificationBtn();
                log("clicked on add qualification button");

                ep.clickQualification();
                log("clicked on qualification dropdown");

                ep.selectQualification();
                log("selected qualification");

                ep.provideUniversity(data.university);
                log("provided university: " + data.university);

                ep.provideYOP(data.YearOfPassing);
                log("provided year of passing: " + data.YearOfPassing);

                ep.saveQualification();
                log("clicked on save qualification button");
                //endregion

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region Payroll Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void verifyPayrollTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.PayrollTabModel> payrollTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "payroll",
                    EmployeeModel.PayrollTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.PayrollTabModel data : payrollTabInfo)
            {
                ep.clickPayroll();
                log("Clicked on payroll Tab");

                ep.clickPayrollSetID();
                log("clicked on payroll set dropdown");

                ep.selectPayrollSetID(data.payrollset);
                log("selected payroll set: " + data.payrollset);

                ep.clickPaymentMode();
                log("clicked on payment mode dropdown");

                ep.selectPaymentMode(data.paymentMode);
                log("selected payment mode");

                ep.clickEmpBank();
                log("clicked on employee bank dropdown");

                ep.selectEmpBank(data.employeebank);
                log("selected employee bank: " + data.employeebank);

                ep.provideBankAcNo();
                log("provided bank account number");

                ep.provideIBANNo();
                log("provided IBAN number");

                ep.clickBankAcType();
                log("clicked on bank account type dropdown");

                ep.selectBankAcType(data.bankAccountType);
                log("selected bank account type: " + data.bankAccountType);

                ep.clickGovtLicense();
                log("clicked on govt recruitment contract license dropdown");

                ep.selectGovtLicense(data.govtRecruitmentContractLicense);
                log("selected govt recruitment contract license: " + data.govtRecruitmentContractLicense);

                ep.deleteBasicSalaryComponent();
                log("deleted existing basic salary component");

                for (EmployeeModel.SalaryComponentModel data1 : data.salaryComponents)
                {
                    ep.clickAddSalaryComponentBtn();
                    ep.clickSalaryComponent();
                    ep.selectSalComponent(data1.salaryComponent);
                    ep.provideAmt(data1.amount);
                    ep.provideEffectiveFromDate(data1.effectiveFromDate);
                    ep.saveSalComponent();
                }

                for (EmployeeModel.OvertimeTypesModel ot : data.overtimeTypes)
                {
                    ep.clickOvertimeTypesBtn();
                    log("clicked overtime types button");

                    ep.clickOvertimeType();
                    log("clicked on overtime type dropdown");

                    ep.selectOvertimeType(data.overtimeType);
                    log("selected overtime type: " + data.overtimeType);

                    ep.saveOvertimeType();
                    log("clicked on save overtime type button");
                }

                ep.scrollDownWebPageTicket();
                log("scrolled down to Ticket Accrual section");

                ep.addTicketBtn();
                log("clicked on ticket button");

                ep.clickRelationshipType();
                log("clicked on relationship type dropdown");

                ep.selectRelationshipType(data.relationshipType);
                log("selected relationship type: " + data.relationshipType);

                ep.provideDesc(data.description);
                log("provided description: " + data.description);

                ep.clickTicketAccrual();
                log("clicked on ticket accrual dropdown");

                ep.selectTicketAccrual(data.ticketAccrual);
                log("selected ticket accrual: " + data.ticketAccrual);

                ep.clickTicketDestination();
                log("clicked on ticket destination dropdown");

                ep.selectTicketDestination(data.ticketDestination);
                log("selected ticket destination: " + data.ticketDestination);

                ep.provideTicketEffectiveFromDate(data.ticketEffectiveFromDate);
                log("provided ticket effective from date: " + data.ticketEffectiveFromDate);

                ep.clickSaveTicket();
                log("clicked on save ticket button");

                ep.clickAddMiscellaneousAccrualEarnings();
                log("clicked on Miscellaneous Accrual Earnings button");

                ep.clickAccrualType();
                log("clicked on accrual type dropdown");

                ep.selectAccrualType(data.accrualType);
                log("selected accrual type: " + data.accrualType);

                ep.clickResetAvailedDaysMethod();
                log("clicked on reset availed days method dropdown");

                ep.selectResetAvailedDaysMethod(data.resetAvailedDaysMethod);
                log("selected reset availed days method: " + data.resetAvailedDaysMethod);

                ep.saveMiscellaneousAccrual();
                log("clicked on save Miscellaneous Accrual button");

                ep.clickBenefitSchemes();
                log("clicked on Benefit Schemes button");

                ep.clickRelationshipTypeBS();
                log("clicked on relationship type dropdown in Benefit Schemes section");

                ep.bsSelectRelationshipType(data.relationshipType);
                log("selected relationship type in Benefit Schemes section: " + data.BSrelationshipType);

                ep.clickBenefitScheme();
                log("clicked on benefit scheme dropdown");

                ep.selectBenefitScheme(data.benefitScheme);
                log("selected benefit scheme: " + data.benefitScheme);

                ep.provideBSEffectiveFromDate(data.BSeffectiveFromDate);
                log("provided effective from date: " + data.BSeffectiveFromDate);

                ep.provideBSEffectiveToDate(data.BSeffectiveToDate);
                log("provided effective to date: " + data.BSeffectiveToDate);

                ep.bsSave();
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region TimeOff Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void verifyTimeOffTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.TimeOffTabModel> timeOffTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "payroll",
                    EmployeeModel.TimeOffTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.TimeOffTabModel data : timeOffTabInfo)
            {
                ep.clickTimeOff();
                log("clicked on TimeOff Tab");

                for (EmployeeModel.LeaveTypesModel lt : data.leaveTypes)
                {
                    ep.clickAssignLeaveType();
                    log("clicked on Assign Leave Type button");

                    ep.clickLeaveType();
                    log("clicked on leave type dropdown");

                    ep.selectLeaveType(lt.leaveType);
                    log("selected leave type: " + lt.leaveType);

                    ep.ltProvideEffectiveFromDate(lt.LTeffectiveFromDate);
                    log("provided effective from date: " + lt.LTeffectiveFromDate);

                    ep.ltClickSave();
                    log("clicked on save button");
                }
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region AttendanceTab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void verifyAttendanceTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.AttendanceTabModel> attendanceTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "attendance",
                    EmployeeModel.AttendanceTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.AttendanceTabModel data : attendanceTabInfo)
            {
                ep.clickAttendance();
                log("clicked on Attendance Tab");

                ep.clickAttendanceCalendar();
                log("clicked on Attendance Calendar dropdown");

                ep.selectAttendanceCalendar(data.calendar);
                log("selected Attendance Calendar: " + data.calendar);

                ep.enablePresentByDefault();
                log("enabled Present By Default checkbox");

                ep.clickCheckInType();
                log("clicked on Check-In Type dropdown");

                ep.selectCheckInType(data.checkInType);
                log("selected check-in type: " + data.checkInType);

                ep.clickDefaultShift();
                log("clicked on Default Shift dropdown");

                ep.selectDefaultShift(data.defaultShift);
                log("selected default shift: " + data.defaultShift);

                ep.clickPolicy();
                log("clicked on Policy dropdown");

                ep.selectPolicy(data.policy);
                log("selected policy: " + data.policy);

                ep.clickShiftPreference();
                log("clicked on Shift Preference dropdown");

                ep.selectShiftPreference(data.shiftPreference);
                log("selected shift preference: " + data.shiftPreference);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region Documents Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 7)
    public void verifyDocumentsTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.DocumentsTabModel> documentsTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "documents",
                    EmployeeModel.DocumentsTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.DocumentsTabModel data : documentsTabInfo)
            {
                ep.clickDocuments();
                log("clicked on documents Tab");

                ep.addDocuments();
                log("clicked on add document button");

                ep.clickDocType();
                log("clicked on document type dropdown");

                ep.selectDocType(data.documentType);
                log("selected document type: " + data.documentType);

                ep.provideDocNumber();
                log("provided document number");

                ep.provideDateOfExpiry(data.dateOfExpiry);
                log("provided date of expiry: " + data.dateOfExpiry);

                ep.clickPlaceOfDocument();
                log("clicked on place of document dropdown");

                ep.selectPlaceOfDocument(data.placeOfDocument);
                log("selected place of document: " + data.placeOfDocument);

                ep.empDocClickSave();
                log("clicked on save document button");

                ep.addAttachment();
                log("clicked on add attachment button");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region Performance Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 8)
    public void verifyPerformanceTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.PerformanceTabModel> performanceTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "performance",
                    EmployeeModel.PerformanceTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.PerformanceTabModel data : performanceTabInfo)
            {
                ep.clickPerformance();
                log("clicked on Performance Tab");
                for (EmployeeModel.KRAModel kra : data.KRA)
                {
                    ep.addKRABtn();
                    log("clicked on add KRA button");

                    ep.clickKeyResultAreaName();
                    log("clicked on Key Result Area Name dropdown");

                    ep.selectResultAreaName(kra.KeyResultAreaName);
                    log("selected Key Result Area Name: " + kra.KeyResultAreaName);

                    ep.provideWeightage(kra.weightage);
                    log("provided weightage: " + kra.weightage);

                    ep.clickKRAsave();
                    log("clicked on save KRA button");
                }
                for (EmployeeModel.CompetenciesModel com : data.Competencies)
                {
                    ep.clickAddCompetencies();
                    log("clicked on Add Competencies button");

                    ep.clickCompetencyName();
                    log("clicked on Competency Name dropdown");

                    ep.selectCompetencyName(com.competencyName);
                    log("selected Competency Name: " + com.competencyName);

                    ep.provideCompetenciesWeightage(com.competenciesWeightage);
                    log("provided Competencies Weightage: " + com.competenciesWeightage);

                    ep.clickCompetenciesSave();
                    log("clicked on save Competencies button");
                }

                for (EmployeeModel.SkillSetsModel ss : data.SkillSets)
                {
                    ep.clickaddSkillSetBtn();
                    log("clicked on add skill set button");

                    ep.clickSkillSetName();
                    log("clicked on Skill Set Name dropdown");

                    ep.selectSkillSetName(ss.skillSetName);
                    log("selected Skill Set Name: " + ss.skillSetName);

                    ep.clickLevel();
                    log("clicked on Level dropdown");

                    ep.selectLevel(ss.level);
                    log("selected Level: " + ss.level);

                    ep.provideSkillSetWeightage(ss.skillSetWeightage);
                    log("provided Skill Set Weightage: " + ss.skillSetWeightage);

                    ep.clickskillSetsave();
                    log("clicked on save Skill Set button");
                }

                for (EmployeeModel.GoalsModel goal : data.Goals)
                {
                    ep.clickaddGoalsBtn();
                    log("clicked on add Goals button");

                    ep.provideGoalName(goal.goalName);
                    log("provided Goal Name: " + goal.goalName);

                    ep.provideGoalsStartDate(goal.startDate);
                    log("provided Goals Start Date: " + goal.startDate);

                    ep.provideGoalsDueDate(goal.dueDate);
                    log("provided Goals Due Date: " + goal.dueDate);

                    ep.clickPriority();
                    log("clicked on Priority dropdown");

                    ep.selectPriority(goal.priority);
                    log("selected Priority: " + goal.priority);

                    ep.provideGoalsWeightage(goal.goalsWeightage);
                    log("provided Goals Weightage: " + goal.goalsWeightage);

                    ep.clickGoalSave();
                    log("clicked on save Goals button");
                }
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region Integration Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 9)
    public void verifyIntegrationTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.IntegrationTabModel> integrationTabInfo = JsonUtils.convertJsonListDataModel(employeeFile, "integration",
                    EmployeeModel.IntegrationTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.IntegrationTabModel data : integrationTabInfo)
            {
                ep.clickIntegration();
                log("clicked on Integration Tab");

                ep.clickFinancialIntegrationGroup();
                log("clicked on Financial Integration Group dropdown");

                ep.selectFinancialIntegrationGroup(data.financialIntegrationGroup);
                log("selected Financial Integration Group: " + data.financialIntegrationGroup);

                ep.provideDivision(data.division);
                log("provided Division: " + data.division);

                ep.provideDepartment(data.department);
                log("provided Department: " + data.department);

                ep.provideProject(data.project);
                log("provided Project: " + data.project);

                ep.provideSegmentWorkLocation(data.segmentWorkLocation);
                log("provided Segment Work Location: " + data.segmentWorkLocation);

                for (EmployeeModel.ProjectsModel project : data.Projects)
                {
                    ep.clickAddProjectsBtn();
                    log("clicked on Add Projects button");

                    ep.clickProject();
                    log("clicked on Project dropdown");

                    ep.selectProject(project.Project);
                    log("selected Project: " + project.Project);

                    ep.provideProjectEffectiveFromDate(project.EffectiveFromDate);
                    log("provided Project Effective From Date: " + project.EffectiveFromDate);

                    ep.provideProjectEffectiveToDate(project.EffectiveToDate);
                    log("provided Project Effective To Date: " + project.EffectiveToDate);

                    ep.clickEmpProjectsave();
                    log("clicked on save Projects button");
                }

                ep.saveAllInfo();
                log("clicked on Save button to save all employee information");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion

    // region ResidencyInfo Tab
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 10)
    public void verifyResidencyInfoTab()
    {
        try
        {
            String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
            List<EmployeeModel.ResidencyInfoTabModel> dataInfoTab = JsonUtils.convertJsonListDataModel(employeeFile, "dataInfo",
                    EmployeeModel.ResidencyInfoTabModel.class);

            EmployeePage ep = new EmployeePage();
            for (EmployeeModel.ResidencyInfoTabModel data : dataInfoTab)
            {
                ep.clickMetaballsMenu();
                log("clicked on metaballs menu");

                ep.clickResidencyInfo();
                log("clicked on Residency Info Tab");

                ep.provideSecondName(data.secondName);
                log("provided Second Name: " + data.secondName);

                ep.providethirdName(data.thirdName);
                log("provided Third Name: " + data.thirdName);

                ep.providefourthName(data.fourthName);
                log("provided Fourth Name: " + data.fourthName);

                ep.providelastName(data.lastName);
                log("provided Last Name: " + data.lastName);

                ep.providebirthPlace(data.birthPlace);
                log("provided Birth Place: " + data.birthPlace);

                ep.providedateOfEntry(data.dateOfEntry);
                log("provided Date Of Entry: " + data.dateOfEntry);

                ep.provideVisaNumber(data.VisaNumber);
                log("provided Visa Number: " + data.VisaNumber);

                ep.provideWorkPermitNumber(data.WorkPermitNumber);
                log("provided Work Permit Number: " + data.WorkPermitNumber);

                ep.provideResidenceNumber(data.ResidenceNumber);
                log("provided Residence Number: " + data.ResidenceNumber);

                ep.clickContractQualification();
                log("clicked on Contract Qualification dropdown");

                ep.selectContractQualification(data.ContractQualification);
                log("selected Contract Qualification: " + data.ContractQualification);

                ep.clickNewResidencyPeriod();
                log("clicked on New Residency Period dropdown");

                ep.selectNewResidencyPeriod(data.NewResidencyPeriod);
                log("selected New Residency Period: " + data.NewResidencyPeriod);

                ep.clickNewGovtDesignation();
                log("clicked on New Govt Designation dropdown");

                ep.selectNewGovtDesignation(data.NewGovtDesignation);
                log("selected New Govt Designation: " + data.NewGovtDesignation);

                ep.clickGovermenttLicense();
                log("clicked on Govermentt License dropdown");

                ep.selectGovermenttLicense(data.GovtLicense);
                log("selected Govermentt License: " + data.GovtLicense);

                ep.provideNewContractSalary(data.NewContractSalary);
                log("provided New Contract Salary: " + data.NewContractSalary);

                ep.scrollDownWebPageOldContract();
                log("scrolled down to Old Contract section");

                ep.provideOldContractSalary(data.OldContractSalary);
                log("provided Old Contract Salary: " + data.OldContractSalary);

                ep.provideBlock(data.Block);
                log("provided Block: " + data.Block);

                ep.provideBuildingNumber(data.BuildingNumber);
                log("provided Building Number: " + data.BuildingNumber);

                ep.provideFlatNumber(data.FlatNumber);
                log("provided Flat Number: " + data.FlatNumber);

                ep.provideFloorNumber(data.FloorNumber);
                log("provided Floor Number: " + data.FloorNumber);

                ep.provideLane(data.Lane);
                log("provided Lane: " + data.Lane);

                ep.clickTypeOfBuilding();
                log("clicked on Type Of Building dropdown");

                ep.selectTypeOfBuilding(data.TypeOfBuilding);
                log("selected Type Of Building: " + data.TypeOfBuilding);

                ep.provideStreet(data.Street);
                log("provided Street: " + data.Street);

                ep.provideQasima(data.Qasima);
                log("provided Qasima: " + data.Qasima);

                ep.provideArea(data.Area);
                log("provided Area: " + data.Area);

                ep.providePaciNumber(data.PaciNumber);
                log("provided Paci Number: " + data.PaciNumber);

                ep.providePreviousSponsorName(data.PreviousSponsorName);
                log("provided Previous Sponsor Name: " + data.PreviousSponsorName);

                ep.providePreviousCompanyAuthorizedSign(data.PreviousCompanyAuthorizedSign);
                log("provided Previous Company Authorized Sign: " + data.PreviousCompanyAuthorizedSign);

                ep.providePreviousCompanyName(data.PreviousCompanyName);
                log("provided Previous Company Name: " + data.PreviousCompanyName);

                ep.clickOldGovtDesignation(data.OldGovtDesignation);
                log("clicked on Old Govt Designation dropdown");

                ep.selectOldGovtDesignation(data.OldFileNumber);
                log("selected Old Govt Designation: " + data.OldFileNumber);

                ep.provideOldGovernmentLicense(data.OldGovernmentLicense);
                log("provided Old Government License: " + data.OldGovernmentLicense);

                ep.saveResidencyInfo();
                log("clicked on Save button to save Residency Info");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    // endregion
}