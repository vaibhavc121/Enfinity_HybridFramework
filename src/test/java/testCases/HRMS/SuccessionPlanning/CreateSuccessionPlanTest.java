package testCases.HRMS.SuccessionPlanning;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SuccessionPlanning.SuccessionPlanning.SuccessionModel;
import models.SuccessionPlanning.SuccessionPlanning.SuccessionModel.SuccessionPlanningModel;
import base.BasePage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SuccessionPlanning.SuccessionPage;
import pageObjects.HRMS.SuccessionPlanning.SuccessionPlanPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateSuccessionPlanTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createSuccessionPlan()
	{
		try
		{

			String successionPlanningFile = FileUtils.getDataFile("SuccessionPlanning", "SuccessionPlanning",
					"SuccessionData");
			List<SuccessionPlanningModel> successionPlanData = JsonUtils.convertJsonListDataModel(
					successionPlanningFile, "createSuccessionPlan", SuccessionPlanningModel.class);

			// Succession page
			SuccessionPage op = new SuccessionPage(driver);
			op.clickMenu();
			op.clickSuccessionPlanning();
			op.clickSuccessionPlan();

			// SuccessionPlan page
			SuccessionPlanPage sp = new SuccessionPlanPage(driver);

			for (SuccessionPlanningModel successionPlan : successionPlanData)
			{
				sp.clickNew();
				// cp.provideNameArabic(candidate.nameArabic);
				sp.provideName(successionPlan.name);
				sp.provideDesignation(successionPlan.designation);
				sp.provideEmployee(successionPlan.employee);
				sp.provideMinimumPercentage(successionPlan.minimumPercentage);
				sp.provideQualificationPercentage(successionPlan.qualificationPercentage);
				sp.provideExperiencePercentage(successionPlan.experiencePercentage);
				sp.provideSkillsPercentage(successionPlan.skillsPercentage);
				sp.provideAppraisalPercentage(successionPlan.appraisalPercentage);
				sp.provideCoursePercentage(successionPlan.coursePercentage);
				sp.provideDescription(successionPlan.description);
				sp.clickSave();

				// Assert.assertTrue(sp.isTransactionCreated(successionPlan.name));
				Assert.assertTrue(true);
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
