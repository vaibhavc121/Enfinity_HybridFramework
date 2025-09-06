package testCases.HRMS.Recruitment;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.Recruitment.Recruitment.RecruitmentModel.JobModel;
import base.BasePage;
import pageObjects.HRMS.Recruitment.JobPage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateJobTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createJob()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<JobModel> jobData = JsonUtils.convertJsonListDataModel(recruitmentFile, "createJob", JobModel.class);

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            rp.clickJob();

            // job page
            JobPage jp = new JobPage();

            for (JobModel job : jobData)
            {
                jp.clickNew();
                log("clicked on New button to create a new job");

                jp.selectJobTemplate(job.templateName);
                log("Selected job template: " + job.templateName);

                //jp.provideJobTitle(job.jobTitle);
                String jobTitle = faker.job().title();
                jp.provideJobTitle(jobTitle);
                log("Provided job title: " + jobTitle);

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
                log("provided gender: " + job.gender);

                jp.provideMaritalStatus(job.maritalStatus);
                log("provided marital status: " + job.maritalStatus);

                jp.provideNationality(job.nationality);
                log("provided nationality: " + job.nationality);

//				jp.provideDescription(jobTitle);
//				log("Provided description for the job: " + jobTitle);

                jp.clickSave();
                log("Clicked on Save button to save the job details");

                Assert.assertTrue(jp.isTxnCreated(jobTitle));
                log("Job created successfully with title: " + jobTitle);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}