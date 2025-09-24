package testCases.HRMS.Recruitment;

import base.BasePage;
import base.BaseTest;
import factory.DriverFactory;
import factory.LoggerFactory;
import models.Recruitment.Recruitment.RecruitmentModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.Recruitment.CandidatePage;
import pageObjects.HRMS.Recruitment.JobApplicationTrackingPage;
import pageObjects.HRMS.Recruitment.JobPage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import utilities.FileUtils;
import utilities.JavaScriptUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class RecruitmentTest extends BaseTest
{
    private static String JobTitle;
    private static String candidateName;

    //region Create Candidate
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createCandidate()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.CandidateModel> candidateData = JsonUtils.convertJsonListDataModel(recruitmentFile,
                    "createCandidate", RecruitmentModel.CandidateModel.class);

            // recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            rp.clickCandidate();

            // candidate page
            CandidatePage cp = new CandidatePage();

            for (RecruitmentModel.CandidateModel candidate : candidateData)
            {
                cp.clickNew();
                log("Clicked on New button");

                //region Personal Information
                candidateName = faker.name().firstName();
                cp.provideName(candidateName);
                log("Provided Name");

                cp.provideEmail(faker.internet().emailAddress());
                log("Provided Email");

                cp.provideMobileNumber(candidate.mobile);
                log("Provided Mobile Number");

                cp.provideDateOfBirth(candidate.dob);
                log("Provided Date of Birth");

                cp.selectGender(candidate.gender);
                log("gender selected");

                cp.selectMaritalStatus(candidate.maritalStatus);
                log("Provided Marital Status");

                if (candidate.checkbox1)
                {
                    cp.clickDrivingLicense();
                    log("Clicked on Driving License checkbox");
                }

                //endregion

                //region Address Information
                cp.provideCity(candidate.city);
                log("Provided City");

                cp.provideState(candidate.state);
                log("Provided State");

                cp.provideCountry(candidate.country);
                log("Provided Country");

                cp.providePostalCode(candidate.postalCode);
                log("Provided Postal Code");

                //endregion

                //region Professional Information
                cp.scrollDown();
                cp.provideWorkExpInYears(candidate.workExperienceInYear);
                log("Provided Work Experience in Years");

                cp.provideCurrentJobTitle(candidate.currentJobTitle);
                log("Provided Current Job Title");

                cp.provideCurrentEmployer(candidate.currentEmployer);
                log("Provided Current Employer");

                cp.provideSkills(candidate.skills);
                log("Provided Skills");

                cp.provideCurrentSalary(candidate.currentSalary);
                log("Provided Current Salary");

                cp.provideExpectedSalary(candidate.expectedSalary);
                log("Provided Expected Salary");

                cp.provideNoticePeriodInDays(candidate.noticePeriodInDays);
                log("Provided Notice Period in Days");

                if (candidate.checkbox2)
                {
                    cp.clickOverseas();
                    log("Clicked on Overseas checkbox");
                }

                //endregion

                //region Document Information
                cp.providePassportNumber(candidate.passportNumber);
                log("Provided Passport Number");

                cp.providePassportIssueDate(candidate.passportIssueDate);
                log("Provided Passport Issue Date");

                cp.providePassportExpiryDate(candidate.passportExpiryDate);
                log("Provided Passport Expiry Date");

                cp.provideVisaType(candidate.visaType);
                log("Provided Visa Type");

                cp.provideCivilIdNumber(candidate.civilIdNumber);
                log("Provided Civil ID Number");

                //endregion

                cp.clickSave();
                log("Clicked on Save button");

                Assert.assertEquals(cp.getCandidateName(), candidateName);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Create Job
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void createJob()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.JobModel> jobData = JsonUtils.convertJsonListDataModel(recruitmentFile, "createJob", RecruitmentModel.JobModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            BasePage.openSidebar();
            BasePage.openSidebar();
            rp.clickJob();

            // job page
            JobPage jp = new JobPage();

            for (RecruitmentModel.JobModel job : jobData)
            {
                jp.clickNew();
                log("clicked on New button to create a new job");

                jp.selectJobTemplate(job.templateName);
                log("Selected job template: " + job.templateName);

                //jp.provideJobTitle(job.jobTitle);
                JobTitle = faker.job().title();
                jp.provideJobTitle(JobTitle);
                log("Provided job title: " + JobTitle);

                jp.provideCompany(job.company);
                log("Provided company: " + job.company);

                jp.provideDepartment(job.department);
                log("Provided department: " + job.department);

                jp.provideDesignation(job.designation);
                log("Provided designation: " + job.designation);

                jp.provideNumberOfPosition(job.numberOfPosition);
                log("Provided number of positions: " + job.numberOfPosition);

                jp.provideEmploymentType(job.employmentType);
                log("Provided employment type: " + job.employmentType);

                jp.provideIndustry(job.Industry);
                log("Provided industry: " + job.Industry);

                jp.provideTargetDate();
                log("Provided target date: " + job.TargetDate);

                jp.provideMonthlySal(job.MonthlySal);
                log("Provided monthly salary: " + job.MonthlySal);

                jp.provideAssignedManager(job.assignedManager);
                log("Provided assigned manager: " + job.assignedManager);

                jp.provideAssignedRecruiter(job.assignedRecruiter);
                log("Provided assigned recruiter: " + job.assignedRecruiter);

                jp.provideWorkExperience(job.workExperience);
                log("Provided work experience: " + job.workExperience);

                jp.provideSkills(job.skills);
                log("Provided skills: " + job.skills);

                jp.scrollPage();

                jp.provideCity(job.city);
                log("Provided city: " + job.city);

                jp.provideState(job.state);
                log("Provided state: " + job.state);

                jp.provideCountry(job.country);
                log("Provided country: " + job.country);

                jp.providePostalCode(job.postalCode);
                log("Provided postal code: " + job.postalCode);

                jp.provideGender(job.gender);
                log("provided gender: " + job.gender);

                jp.provideMaritalStatus(job.maritalStatus);
                log("provided marital status: " + job.maritalStatus);

                jp.provideNationality(job.nationality);
                log("provided nationality: " + job.nationality);

//				jp.provideDescription(jobTitle);
//				log("Provided description for the job: " + jobTitle);

                jp.clickSave();
                log("Clicked on Save button to save the job details");

                Assert.assertTrue(jp.isTxnCreated(JobTitle));
                log("Job created successfully with title: " + JobTitle);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Assign Job to Candidate

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void assignJobToCandidate()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.AdvanceCandidateSearchModel> candidateSearch = JsonUtils.convertJsonListDataModel(recruitmentFile, "jobApplicationTracking1.advanceCandidateSearch", RecruitmentModel.AdvanceCandidateSearchModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            log("Clicked on Recruitment");

            //rp.clickOnSidebar();
            BasePage.openSidebar();
            rp.clickJob();
            log("Clicked on Job");

            // Job Application Tracking page
            JobApplicationTrackingPage ja = new JobApplicationTrackingPage();

            for (RecruitmentModel.AdvanceCandidateSearchModel search : candidateSearch)
            {
                ja.openJobFromListing(JobTitle);
//                ja.openJobFromListing("International Marketing Orchestrator");
                log("Opened job from listing: " + JobTitle);

                ja.clickAdvanceCandidateSearch();
                log("Clicked on Advance Candidate Search");

                ja.provideSkills(search.skills);
                log("Provided skills: " + search.skills);

                ja.provideMinimumWorkExperience(search.minimumWorkExperience);
                log("Provided minimum work experience: " + search.minimumWorkExperience);

                ja.provideMaximumWorkExperience(search.maximumWorkExperience);
                log("Provided maximum work experience: " + search.maximumWorkExperience);

                ja.provideMinimumSalaryRange(search.minimumSalaryRange);
                log("Provided minimum salary range: " + search.minimumSalaryRange);

                ja.provideMaximumSalaryRange(search.maximumSalaryRange);
                log("Provided maximum salary range: " + search.maximumSalaryRange);

                ja.provideMinimumNoticePeriodInDays(search.minimumNoticePeriodInDays);
                log("Provided minimum notice period in days: " + search.minimumNoticePeriodInDays);

                ja.provideMaximumNoticePeriodInDays(search.maximumNoticePeriodInDays);
                log("Provided maximum notice period in days: " + search.maximumNoticePeriodInDays);

//                ja.provideNationality(search.nationalityCountries);
//                log("select nationality: " + search.nationalityCountries);

                ja.provideVisaType(search.visaType);
                log("Provided visa type: " + search.visaType);

                JavaScriptUtils.scrollToBottom(DriverFactory.getDriver()
                );

                ja.provideGender(search.gender);
                log("Provided gender");

//                if (search.drivingLicense)
//                {
//                    ja.clickDrivingLicense();
//                    log("Clicked on Driving License checkbox");
//                }

                ja.provideMinimumAge(search.minimumAge);
                log("Provided minimum age: " + search.minimumAge);

                ja.provideMaximumAge(search.maximumAge);
                log("Provided maximum age: " + search.maximumAge);

                ja.clickSearchCandidates();
                log("Clicked on Search Candidates button");

                ja.scrollToTop();
                log("Scrolled to top of the page");

                BasePage.waitTS(2);

                //JavaScriptUtils.scrollToBottom(driver);

                ja.selectCandidate(candidateName);
//                ja.selectCandidate("Raleigh");
                log("Selected candidate: " + candidateName);

                BasePage.waitTS(2);
                ja.clickAssign();
                log("Clicked on Assign Job button");
                BasePage.waitTS(2);

                //Assert.assertTrue(ja.isScreeningLabelDisplay());
                Assert.assertTrue(ja.candidateLabelDisplay(candidateName));
//                Assert.assertTrue(ja.candidateLabelDisplay("Raleigh"));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    //endregion

    //region Schedule Interview
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void scheduleInterview()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.AdvanceCandidateSearchModel> candidateSearch = JsonUtils.convertJsonListDataModel(recruitmentFile, "jobApplicationTracking1.advanceCandidateSearch", RecruitmentModel.AdvanceCandidateSearchModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            log("Clicked on Recruitment");
            BasePage.openSidebar();
            rp.clickJob();
            log("Clicked on Job");

            // Job Application Tracking page
            JobApplicationTrackingPage ja = new JobApplicationTrackingPage();

            for (RecruitmentModel.AdvanceCandidateSearchModel search : candidateSearch)
            {
                ja.openJobFromListing(JobTitle);
//                ja.openJobFromListing("Customer IT Strategist");
                log("Opened job from listing: " + JobTitle);

                ja.clickOnCandidates();
                log("Clicked on Candidates");

                ja.clickScreeningPipeline();
                log("Clicked on Screening Pipeline");

                ja.changePipelineStatus("Screening", "Interview");
                log("Changed pipeline status from Screening to Interview");

                ja.clickInterviewPipeline();
                log("Clicked on Interview Pipeline");

                ja.clickInterviewButton();
                log("Clicked on Interview button");

                ja.clickNewButton();
                log("Clicked on New button to schedule an interview");

                ja.selectInterviewType();
                log("Selected interview type");

                ja.provideInterviewDateTime();
                log("Provided interview date and time");

                ja.provideInterviewDuration();
                log("Provided interview duration");

                ja.selectInterviewMode();
                log("Selected interview mode");

                ja.provideLocation();
                log("Provided location for the interview");

                ja.selectInterviewer();
                log("Selected interviewer");

                ja.selectGuestInterviewer();
                log("Selected guest interviewer");

                ja.clickSave();
                log("Clicked on Save button to schedule the interview");

                ja.clickCancel();
                log("Clicked on Cancel button to close the interview dialog");

                Assert.assertTrue(ja.getStatusOfInterview(), "Interview is not scheduled successfully");
                log("Interview scheduled successfully for candidate: " + candidateName);

                ja.clickCloseSchduledInterviewPopupIcon();
                log("Closed Scheduled Interview Popup");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    //endregion

    //region Offer Job to Candidate
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void offerJobToCandidate()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.AdvanceCandidateSearchModel> candidateSearch = JsonUtils.convertJsonListDataModel(recruitmentFile, "jobApplicationTracking1.advanceCandidateSearch", RecruitmentModel.AdvanceCandidateSearchModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            log("Clicked on Recruitment");
            BasePage.openSidebar();
            rp.clickJob();
            log("Clicked on Job");

            // Job Application Tracking page
            JobApplicationTrackingPage ja = new JobApplicationTrackingPage();

            for (RecruitmentModel.AdvanceCandidateSearchModel search : candidateSearch)
            {
                ja.openJobFromListing(JobTitle);
//                ja.openJobFromListing("Customer IT Strategist");
                log("Opened job from listing: " + JobTitle);

                ja.clickOnCandidates();
                log("Clicked on Candidates");

                ja.clickInterviewPipeline();
                log("Clicked on Interview Pipeline");

                //ja.clickCloseSchduledInterviewPopupIcon();
                //log("Clicked on Close Scheduled Interview Popup Icon");

                ja.changePipelineStatus("Interview", "Offered");
                log("Changed pipeline status from Interview to Offered");

                ja.clickCancelPopupInterview();
                log("Clicked on Cancel button to close the dialog");

                ja.clickOfferedPipeline();
                log("Clicked on Offered Pipeline");

                ja.provideOfferLetter();

                Assert.assertTrue(ja.checkOfferStatus(), "Offer letter is not generated successfully");
                BaseTest.log("Offer letter is generated successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Complete Hiring Process
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void completeHiringProcess()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.AdvanceCandidateSearchModel> candidateSearch = JsonUtils.convertJsonListDataModel(recruitmentFile, "jobApplicationTracking1.advanceCandidateSearch", RecruitmentModel.AdvanceCandidateSearchModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            log("Clicked on Recruitment");
            BasePage.openSidebar();
            rp.clickJob();
            log("Clicked on Job");

            // Job Application Tracking page
            JobApplicationTrackingPage ja = new JobApplicationTrackingPage();

            for (RecruitmentModel.AdvanceCandidateSearchModel search : candidateSearch)
            {
                ja.openJobFromListing(JobTitle);
//                ja.openJobFromListing("Customer IT Strategist");
                log("Opened job from listing: " + JobTitle);

                ja.clickOnCandidates();
                log("Clicked on Candidates");

                ja.clickOfferedPipeline();
                log("Clicked on offered Pipeline");

                //ja.clickCloseSchduledInterviewPopupIcon();
                //log("Clicked on Close Scheduled Interview Popup Icon");

                ja.changePipelineStatus("Offered", "Hired");
                log("Changed pipeline status from Offered to Hired");

                ja.clickHiredPipeline();
                log("Clicked on hired Pipeline");

                //region Onboarding Process
                ja.clickInitiateOnboardingIcon();
                log("Clicked on Initiate Onboarding Icon");

                ja.selectProcess();
                log("Selected Onboarding Process");

                ja.clickNext();
                log("Clicked on Next button");

                ja.provideJoiningDate();
                log("Provided Joining Date");

                ja.provideArrivalTime();
                log("Provided Arrival Time");

                ja.selectContactPerson();
                log("Selected Contact Person");

                ja.selectDepartment();
                log("Selected Department");

                ja.selectDesignation();
                log("Selected Designation");

                ja.selectWorkLocation();
                log("Selected Work Location");

                ja.provideWelcomeMessage();
                log("Provided Welcome Message");

                ja.provideWelcomeUrl();
                log("Provided Welcome URL");

                ja.provideOtherInstructions();
                log("Provided Other Instructions");

                ja.clickAddIcon();
                log("Clicked on Add Icon to add onboarding details");

                ja.provideQuestionName();
                log("Provided Question Name");

                ja.selectType();
                log("Selected Type");

                ja.clickSave1();
                log("Clicked on Save button to save onboarding details");

                ja.clickInitate();
                log("Clicked on Initiate button to complete the hiring process");

                //endregion

                //region Convert Candidate to Employee
                ja.clickConvertToEmployeeIcon();
                log("Clicked on Convert to Employee Icon");

                BasePage.waitTS(5);

                BasePage.switchTab();
                log("Switched to the employee tab");

                // Employee Page
                EmployeePage ep = new EmployeePage();
                ep.selectDepartment("QC");
                log("Selected Department");

                ep.selectPayrollSet("PS0- Calendar days");
                log("Selected Payroll Set");

                ep.selectCalendar("Calendar");
                log("Selected Calendar");

                ep.selectIndemnity("Indemnity");
                log("Selected Indemnity");

                ep.clickSave();
                log("Clicked on Save button");

                Assert.assertTrue(ep.isEmployeeNameDisplay(candidateName), "Employee is not created");
//                Assert.assertTrue(ep.isEmployeeNameDisplay("Larae"),"Employee is not created");
                log("Employee created successfully with name: " + candidateName);

                //endregion

                //region Delete Employee
                ep.clickSettingButton();
                log("Clicked on Setting Button");

                ep.clickDelete();
                log("Clicked on Delete button");

                ep.clickOk();
                log("Clicked on OK button to confirm deletion");

                Assert.assertFalse(ep.validateEmpDelete(candidateName), "Employee " + candidateName + " is not deleted.");
//                Assert.assertFalse(ep.validateEmpDelete("Larae"), "Employee " + "Larae" + " is not deleted.");

                //endregion
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion
}