package testCases.HRMS.Performance;

import base.BasePage;
import base.BaseTest;
import factory.DriverFactory;
import factory.LoggerFactory;
import models.Performance.Performance.PerformanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.Performance.AppraisalCyclePage;
import pageObjects.HRMS.Performance.FeedbackCyclePage;
import pageObjects.HRMS.Performance.PerformancePage;
import pageObjects.HRMS.Performance.ReviewPage;
import utilities.*;

import java.util.List;

public class PerformanceTest extends BaseTest
{
    String appraisalCycleName = "AC_" + DateUtils.getCurrentDateTime("dd-MMM-yyyy_HH:mm:ss");
    String feedbackCycleName = "FC_" + DateUtils.getCurrentDateTime("dd-MMM-yyyy_HH:mm:ss");

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void create360FeedbackCycle()
    {
        try
        {
            String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
            List<PerformanceModel.FeedbackCycleModel> feedbackCycleData = JsonUtils.convertJsonListDataModel(performanceFile, "feedbackCycle", PerformanceModel.FeedbackCycleModel.class);
//            String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
//            List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport", ITSupportModel.class);

            //performance page
            PerformancePage pp = new PerformancePage();
            pp.clickPerformance();
            log("Clicked on Performance module");
            pp.clickFeedbackCycle();
            log("Clicked on 360 Feedback Cycle");

            FeedbackCyclePage fc = new FeedbackCyclePage();
            for (PerformanceModel.FeedbackCycleModel data : feedbackCycleData)
            {
                BasePage.clickOnNew();
                log("Clicked on New button to create new 360 Feedback cycle");
                fc.provideName(feedbackCycleName);
                log("Entered feedback cycle name: " + feedbackCycleName);
                fc.provideDesc(data.description);
                log("Provided description: " + data.description);
                fc.provideProcessFromDate(data.processFromDate);
                log("Provided process from date: " + data.processFromDate);
                fc.provideProcessToDate(data.processToDate);
                log("Provided process to date: " + data.processToDate);
                fc.selectWorkflow(data.workflow);
                log("Selected workflow: " + data.workflow);
                fc.provideMinimumRater(data.minimumRater);
                log("Provided minimum rater: " + data.minimumRater);
                fc.provideMaximumRater(data.maximumRater);
                log("Provided maximum rater: " + data.maximumRater);
                if (data.allowRatingCheckbox)
                {
                    fc.checkAllowRating();
                    log("Checked allow rating checkbox");
                    fc.selectOverallRating(data.overallRating);
                    log("Selected overall rating: " + data.overallRating);
                }
                if (data.manualOverallRatingCheckbox)
                {
                    fc.checkManualOverallRating();
                    log("Checked manual overall rating checkbox");
                }
                fc.scrollDownTOJoiningDateUntil();
                log("Scrolled down to Joining Date Until field");
                fc.provideJoiningDateUntil(DateUtils.getCurrentDate("dd-MMM-yyyy"));
                log("Provided joining date until: " + DateUtils.getCurrentDate("dd-MMM-yyyy"));
                fc.selectEmployee(data.employee);
                log("Selected employee: " + data.employee);

                //region Questions
                fc.clickNext();
                log("Clicked on Next to navigate to Questions tab");

                for (PerformanceModel.FeedbackCycleModel.Question q : data.questions)
                {
                    fc.clickAddQuestion();
                    log("Clicked on Add Question button to add question");

                    fc.provideQuestion(q.question);
                    log("Provided question: " + q.question);

                    fc.provideCategory(q.category);
                    log("Provided category: " + q.category);

                    fc.selectRatingType(q.ratingType);
                    log("Selected rating type: " + q.ratingType);

                    if (q.mandatoryCheckbox)
                    {
                        fc.checkMandatory();
                        log("Checked mandatory checkbox");
                    }

                    fc.clickAdd();
                    log("Clicked Add to save question");
                }
                //endregion

                BasePage.clickOnSave();
                log("Clicked on Save button to save feedback cycle");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void delete360FeedbackCycle()
    {
        try
        {
            String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
            List<PerformanceModel.FeedbackCycleModel> feedbackCycleData = JsonUtils.convertJsonListDataModel(performanceFile, "feedbackCycle", PerformanceModel.FeedbackCycleModel.class);

            //performance page
            PerformancePage pp = new PerformancePage();
            pp.clickPerformance();
            log("Clicked on Performance module");
            pp.clickFeedbackCycle();
            log("Clicked on 360 Feedback Cycle");

            AppraisalCyclePage ac = new AppraisalCyclePage();
            ac.deleteAppraisalCycle(feedbackCycleName, 2, 1);
            // ac.deleteAppraisalCycle("AC_08-Sept-2025_18:06:29", 2, 1);

            Assert.assertFalse(BasePage.validateListing(feedbackCycleName, 2, 1), "Appraisal Cycle deletion failed: " + appraisalCycleName);
            log("Verified: Appraisal Cycle deleted successfully: " + appraisalCycleName);
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void createAppraisalCycle()
    {
        try
        {
            String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
            List<PerformanceModel.AppraisalCycleModel> performanceData = JsonUtils.convertJsonListDataModel(performanceFile, "createAppraisalCycle", PerformanceModel.AppraisalCycleModel.class);

            PerformancePage pp = new PerformancePage();
            AppraisalCyclePage ac = new AppraisalCyclePage();

            pp.clickPerformance();
            log("Clicked on Performance module");
            pp.clickAppraisalCycle();
            log("Clicked on Appraisal Cycle");

            //region Appraisal Cycle page

            for (PerformanceModel.AppraisalCycleModel data : performanceData)
            {
                ac.clickNew();
                log("Clicked on New button to create new appraisal cycle");

                //region Header

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

                ac.scrollPageGoalRating();
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

                BrowserUtils.navigateBack(DriverFactory.getDriver());
                BasePage.waitTS(2);

                //region Validation
                //BasePage.validateMessage("");
                Assert.assertTrue(BasePage.validateListing(appraisalCycleName, 2, 1), "Appraisal Cycle creation failed: " + appraisalCycleName);
                log("Verified: Appraisal Cycle created successfully: " + appraisalCycleName);
                //endregion
            }

            //endregion

        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void deleteAppraisalCycle()
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

            ac.deleteAppraisalCycle(appraisalCycleName, 2, 1);
            // ac.deleteAppraisalCycle("AC_08-Sept-2025_18:06:29", 2, 1);

            Assert.assertFalse(BasePage.validateListing(appraisalCycleName, 2, 1), "Appraisal Cycle deletion failed: " + appraisalCycleName);
            log("Verified: Appraisal Cycle deleted successfully: " + appraisalCycleName);
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class)
    public void reviewAppraisal()
    {
        try
        {
            String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
            List<PerformanceModel.ReviewAppraisalModel> reviewAppraisalData = JsonUtils.convertJsonListDataModel(performanceFile, "reviewAppraisal", PerformanceModel.ReviewAppraisalModel.class);

            BasePage.filterAndOpenTransaction(2, 1, appraisalCycleName, "Edit");
            AppraisalCyclePage ac = new AppraisalCyclePage();
            ac.clickInitiate();
            log("Clicked on Initiate button");

            BasePage.waitTS(2);
            BasePage.pressEnter();
            log("Pressed Enter key");

            //region Validate Notification
            TopNavigationBar tn = new TopNavigationBar();
            tn.clickBellIcon();
            log("Clicked on Bell icon to open Notifications");

            softAssert.assertTrue(tn.validateMyApprovalData(appraisalCycleName), "Notification data not found: " + appraisalCycleName);
            log("Verified: Notification data found: " + appraisalCycleName);

            tn.openTxn();
            BasePage.switchTab();
            BasePage.closeUnwantedTab();
            BasePage.waitTS(3);
            log("tab switched to appraisal review page");

            ReviewPage rp = new ReviewPage();
            for (PerformanceModel.ReviewAppraisalModel data : reviewAppraisalData)
            {
                //rp.provideRating();
            }

            //endregion
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}