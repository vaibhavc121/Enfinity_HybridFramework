package testCases.HRMS.Recruitment;

import base.BasePage;
import base.BaseTest;
import models.Recruitment.Recruitment.RecruitmentModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Recruitment.CandidatePage;
import pageObjects.HRMS.Recruitment.JobApplicationTrackingPage;
import pageObjects.HRMS.Recruitment.JobPage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class RecruitmentTest extends BaseTest
{
    private static String JobTitle;

    //region Create Candidate
    @Test(groups="functional", retryAnalyzer = RetryAnalyzer.class)
    public void createCandidate()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.CandidateModel> candidateData = JsonUtils.convertJsonListDataModel(recruitmentFile,
                    "createCandidate", RecruitmentModel.CandidateModel.class);

            // recruitment page
            RecruitmentPage rp=new RecruitmentPage(driver);
            rp.clickRecruitment();
            rp.clickCandidate();

            // candidate page
            CandidatePage cp=new CandidatePage(driver);

            for(RecruitmentModel.CandidateModel candidate : candidateData)
            {
                cp.clickNew();
                log("Clicked on New button");

                //region Personal Information
                String candidateName = faker.name().firstName();
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

                if(candidate.checkbox1)
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

                if(candidate.checkbox2)
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

                Assert.assertEquals(cp.getCandidateName(),candidateName);
            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Create Job
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createJob()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.JobModel> jobData = JsonUtils.convertJsonListDataModel(recruitmentFile, "createJob", RecruitmentModel.JobModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage(driver);
            rp.clickRecruitment();
            rp.clickJob();

            // job page
            JobPage jp = new JobPage(driver);

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

                jp.provideCity(job.city);
                log("Provided city: " + job.city);

                jp.provideState(job.state);
                log("Provided state: " + job.state);

                jp.provideCountry(job.country);
                log("Provided country: " + job.country);

                jp.providePostalCode(job.postalCode);
                log("Provided postal code: " + job.postalCode);

                jp.provideGender(job.gender);
                log("provided gender: " +job.gender);

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
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
    //endregion

    //region Assign Job to Candidate

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void assignJobToCandidate()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.JobModel> jobData = JsonUtils.convertJsonListDataModel(recruitmentFile, "createJob", RecruitmentModel.JobModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage(driver);
            rp.clickRecruitment();
            log("Clicked on Recruitment");
            rp.clickJob();
            log("Clicked on Job");

            // Job Application Tracking page
            JobApplicationTrackingPage ja = new JobApplicationTrackingPage(driver);
            ja.openJobFromListing(JobTitle);
            log("Opened job from listing: " + JobTitle);

            ja.clickAdvanceCandidateSearch();
            log("Clicked on Advance Candidate Search");






        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }

    }


    //endregion



}