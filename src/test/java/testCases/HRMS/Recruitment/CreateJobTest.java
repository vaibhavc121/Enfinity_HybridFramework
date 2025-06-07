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
			RecruitmentPage rp = new RecruitmentPage(driver);
			rp.clickRecruitment();
			rp.clickJob();

			// job page
			JobPage jp = new JobPage(driver);

			for (JobModel job : jobData)
			{
				jp.clickNew();
				jp.provideJobTitle(job.jobTitle);
				jp.provideDepartment(job.department);
				jp.provideDesignation(job.designation);
				jp.provideNumberOfPosition(job.numberOfPosition);
				jp.provideEmploymentType(job.employmentType);
				jp.provideIndustry(job.Industry);
				jp.provideTargetDate(job.TargetDate);
				jp.provideMonthlySal(job.MonthlySal);
				jp.provideAssignedManager(job.assignedManager);
				jp.provideAssignedRecruiter(job.assignedRecruiter);
				jp.provideWorkExperience(job.workExperience);
				jp.provideSkills(job.skills);
				jp.provideCity(job.city);
				jp.provideState(job.state);
				jp.provideCountry(job.country);
				jp.providePostalCode(job.postalCode);
				jp.provideGender(job.gender);
				jp.provideMaritalStatus(job.maritalStatus);
				jp.provideNationality(job.nationality);
				jp.clickSave();

				Assert.assertTrue(jp.isTxnCreated(job.jobTitle));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
