package testCases.HRMS.Recruitment;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Recruitment.Recruitment.RecruitmentModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Recruitment.JobPage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class RecruitmentRequestTest extends BaseTest
{
    private static String JobTitle;

    String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
    List<RecruitmentModel.JobModel> jobData = JsonUtils.convertJsonListDataModel(recruitmentFile, "createJob", RecruitmentModel.JobModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void verifyRecruitmentReqAndJobCreation()
    {
        try
        {

            // Recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            BasePage.openSidebar();
            BasePage.openSidebar();
            rp.clickRecruitmentRequest();

            // job page
            JobPage jp = new JobPage();

            for (RecruitmentModel.JobModel job : jobData)
            {
                BasePage.clickOnNew();
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

                BasePage.pressTab();
                log("Pressed Tab");

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

                jp.clickOnSaveAndSubmitBack();
                log("Clicked on Save and Submit button and navigated back to listing page");

                Assert.assertTrue(BasePage.validateListing(JobTitle, 4, 4), "Recruitment request creation failed, Job title not found in listing: " + JobTitle);
                log("Recruitment request created successfully with title: " + JobTitle);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2, dependsOnMethods = "verifyRecruitmentReqAndJobCreation")
    public void verifyJobCreatedOrNot()
    {
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3, dependsOnMethods = "verifyJobCreatedOrNot")
    public void deleteCreatedJob()
    {
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 4, dependsOnMethods = "deleteCreatedJob")
    public void deleteRecruitmentRequest()
    {
    }
}