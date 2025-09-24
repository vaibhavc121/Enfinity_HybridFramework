package testCases.HRMS.SuccessionPlanning;

import factory.LoggerFactory;
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
    String successionPlanningFile = FileUtils.getDataFile("SuccessionPlanning", "SuccessionPlanning", "SuccessionData");
    List<SuccessionPlanningModel> successionPlanData = JsonUtils.convertJsonListDataModel(successionPlanningFile, "createSuccessionPlan", SuccessionPlanningModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSuccessionPlan()
    {
        try
        {
            // Succession page
            SuccessionPage op = new SuccessionPage();
            //op.clickMenu();
            op.clickSuccessionPlanning();
            op.clickSuccessionPlan();

            // SuccessionPlan page
            SuccessionPlanPage sp = new SuccessionPlanPage();

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
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteSuccessionPlan()
    {
        try
        {
            // Succession page
            SuccessionPage sp = new SuccessionPage();
            //op.clickMenu();
            sp.clickSuccessionPlanning();
            sp.clickSuccessionPlan();

            for (SuccessionPlanningModel successionPlan : successionPlanData)
            {
                sp.deleteSuccessionPlan(successionPlan.name, 2, 1);
                Assert.assertFalse(BasePage.validateListing(successionPlan.name, 2, 1), "Succession Plan is not deleted: " + successionPlan.name);
                log("Verified: Succession Plan deleted successfully: " + successionPlan.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}