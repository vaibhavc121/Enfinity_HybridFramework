package testCases.HRMS.Performance;

import base.BasePage;
import base.BaseTest;
import models.Performance.Performance.PerformanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Performance.AppraisalCyclePage;
import pageObjects.HRMS.Performance.PerformancePage;
import utilities.DateUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PerformanceTest extends BaseTest
{
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class)
    public void createAppraisalCycle()
    {
        try
        {
            String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
            List<PerformanceModel.AppraisalCycleModel> performanceData = JsonUtils.convertJsonListDataModel(performanceFile, "createAppraisalCycle", PerformanceModel.AppraisalCycleModel.class);

            //region Page Initializations
            PerformancePage pp = new PerformancePage();
            AppraisalCyclePage ac = new AppraisalCyclePage();
            //endregion

            //region Performance page
            pp.clickPerformance();
            log("Clicked on Performance module");
            pp.clickAppraisalCycle();
            log("Clicked on Appraisal Cycle");
            //endregion

            //region Appraisal Cycle page

            for (PerformanceModel.AppraisalCycleModel data : performanceData)
            {
                ac.clickNew();
                log("Clicked on New button to create new appraisal cycle");

                //region Header

                String appraisalCycleName = "AC" + DateUtils.getCurrentDateTime("dd-MMM-yyyy HH:mm:ss");

                ac.enterName(appraisalCycleName);
                log("Entered Name: " + appraisalCycleName);

                ac.enterAppraisalFromDate(data.appraisalFromDate);
                log("Entered Appraisal From Date: " + data.appraisalFromDate);

                ac.enterAppraisalToDate(data.appraisalToDate);
                log("Entered Appraisal To Date: " + data.appraisalToDate);

                ac.enterProcessFromDate(data.processFromDate);
                log("Entered Process From Date: " + data.processFromDate);

                ac.enterProcessToDate(data.processToDate);
                log("Entered Process To Date: " + data.processToDate);

                ac.enterDescription(data.description);
                log("Entered Description: " + data.description);

                //endregion

                //region Feature to be included

                ac.enableGoals(data.goals);
                log("Goals feature enabled: " + data.goals);

                ac.enableKRA(data.KRA);
                log("KRA feature enabled: " + data.KRA);

                ac.enableCompetency(data.competency);
                log("Competency feature enabled: " + data.competency);

                ac.enableReviewQuestions(data.reviewQuestions);
                log("Review Questions feature enabled: " + data.reviewQuestions);

                ac.enterGoalsWeightage(data.goalsWeightage);
                log("Entered Goals Weightage: " + data.goalsWeightage);

                ac.enterKRAWeightage(data.KRAWeightage);
                log("Entered KRA Weightage: " + data.KRAWeightage);

                ac.enterCompetencyWeightage(data.competencyWeightage);
                log("Entered Competency Weightage: " + data.competencyWeightage);

                //endregion

                //region Rating

                ac.scrollPageToManualWorkflow();
                log("Scrolled down the page to access Rating section");

                ac.selectGoalRating(data.goalRating);
                log("Selected Goal Rating: " + data.goalRating);

                ac.selectKeyResultAreaRating(data.keyResultAreaRating);
                log("Selected Key Result Area Rating: " + data.keyResultAreaRating);

                ac.selectCompetencyRating(data.competencyRating);
                log("Selected Competency Rating: " + data.competencyRating);

                ac.selectOverallRating(data.overallRating);
                log("Selected Overall Rating: " + data.overallRating);

                //endregion

                //region Applicable For

                ac.enterJoiningDateUntil();
                log("Entered Joining Date Until: " + DateUtils.getCurrentDate("dd-MMM-yyyy"));

                ac.selectEmployee(data.employee);
                log("Selected Employee: " + data.employee);

                //endregion

                //region Reviewers

                ac.scrollPageToManualWorkflow();
                log("Scrolled down the page to allowManualWorkflow");

                ac.checkAllowManualWorkflow(data.allowManualWorkflow);
                log("Allow Manual Workflow checked: " + data.allowManualWorkflow);

                ac.selectWorkflow(data.workflow);
                log("Selected Workflow: " + data.workflow);

                ac.enableReviewerOpinion(data.enableReviewerOpinion);
                log("Reviewer Opinion enabled: " + data.enableReviewerOpinion);

                ac.enableSkillSetAssessment(data.enableSkillSetAssessment);
                log("Skill Set Assessment enabled: " + data.enableSkillSetAssessment);

                //endregion

                BasePage.clickOnSave();
                log("Clicked on Save button");

                //region Validation
                BasePage.validateMessage("");
                Assert.assertTrue(BasePage.validateListing(appraisalCycleName, 2, 2));
                log("Verified: Appraisal Cycle created successfully: " + appraisalCycleName);
                //endregion
            }

            //endregion

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}