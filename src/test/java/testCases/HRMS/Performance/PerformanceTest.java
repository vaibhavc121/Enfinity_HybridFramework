package testCases.HRMS.Performance;

import base.BasePage;
import base.BaseTest;
import factory.DriverFactory;
import factory.LoggerFactory;
import freemarker.template.utility.DateUtil;
import models.Performance.Performance.PerformanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.Performance.AppraisalCyclePage;
import pageObjects.HRMS.Performance.FeedbackCyclePage;
import pageObjects.HRMS.Performance.PerformancePage;
import pageObjects.HRMS.Performance.ReviewPage;
import utilities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerformanceTest extends BaseTest
{
    String appraisalCycleName = "AC_" + DateUtils.getCurrentDateTime("dd-MMM-yyyy_HH:mm:ss");
    String feedbackCycleName = "FC_" + DateUtils.getCurrentDateTime("dd-MMM-yyyy_HH:mm:ss");

    @Test(groups = {"functional", "regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 1)
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
                /*
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

                 */
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

    @Test(groups = {"functional", "regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 2)
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

    @Test(groups = {"functional", "regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 3)
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

                //ac.enterAppraisalFromDate(data.appraisalFromDate);
                ac.enterAppraisalFromDate(DateUtils.getCurrentDate("dd-MMM-yyyy"));
                log("Entered Appraisal From Date: " + data.appraisalFromDate);

                //ac.enterAppraisalToDate(data.appraisalToDate);
                ac.enterAppraisalToDate(DateUtils.getCurrentDate("dd-MMM-yyyy"));
                log("Entered Appraisal To Date: " + data.appraisalToDate);

                //ac.enterProcessFromDate(data.processFromDate);
                ac.enterProcessFromDate(DateUtils.getCurrentDate("dd-MMM-yyyy"));
                log("Entered Process From Date: " + data.processFromDate);

                //ac.enterProcessToDate(data.processToDate);
                ac.enterProcessToDate(DateUtils.getCurrentDate("dd-MMM-yyyy"));
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

                BasePage.waitTS(2);
                ac.checkAllowManualWorkflow(data.allowManualWorkflow);
                log("Allow Manual Workflow checked: " + data.allowManualWorkflow);
                BasePage.waitTS(2);

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

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 4)
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

    @Test(groups = {"functional", "regression"}, retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void reviewAppraisal()
    {
        try
        {
            String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
            List<PerformanceModel.ReviewAppraisalModel> reviewAppraisalData =
                    JsonUtils.convertJsonListDataModel(performanceFile, "reviewAppraisal", PerformanceModel.ReviewAppraisalModel.class);

            try
            {
                PerformancePage pp = new PerformancePage();
                pp.clickPerformance();
                log("Clicked on Performance module");
                pp.clickAppraisalCycle();
                log("Clicked on Appraisal Cycle");

                BasePage.filterAndOpenTransaction(2, 1, appraisalCycleName, "Edit");
                AppraisalCyclePage ac = new AppraisalCyclePage();
                ac.clickInitiate();
                log("Clicked on Initiate button");

                BasePage.waitTS(2);
                BasePage.pressEnter();
                log("Pressed Enter key");
                BasePage.waitTS(3);
                BrowserUtils.refreshPage(BaseTest.getDriver());
            } catch (Exception ignored)
            {
            }

            //region Validate Notification
            TopNavigationBar tn = new TopNavigationBar();
            tn.clickBellIcon();
            log("Clicked on Bell icon to open Notifications");

            softAssert.assertTrue(tn.validateMyApprovalData(appraisalCycleName), "Notification data not found: " + appraisalCycleName);
            log("Verified: Notification data found: " + appraisalCycleName);

            tn.openTxn();
            BasePage.waitTS(5);
            BasePage.switchTab();
            //BasePage.closeUnwantedTab();
            BasePage.waitTS(3);
            log("tab switched to appraisal review page");

            ReviewPage rp = new ReviewPage();

            for (PerformanceModel.ReviewAppraisalModel data : reviewAppraisalData)
            {

                //region Key Result Areas
                for (PerformanceModel.KRA kra : data.KRA)
                {
                    rp.provideRating(kra.rating);
                    log("Provided KRA rating: " + kra.rating);

                    rp.enterReviewComment(kra.reviewComment);
                    log("Entered KRA review comment: " + kra.reviewComment);

                    rp.enterOverallComment(kra.overallComment);
                    log("Entered KRA overall comment: " + kra.overallComment);

                    BasePage.pressTab();
                    log("Pressed Tab key");

                    rp.enterTrainingRequirements(kra.learningRequirements);
                    log("Entered KRA learning requirements: " + kra.learningRequirements);

                    rp.scrollPage();
                    rp.clickSave();
                }
                //endregion

                //region Goals
                rp.clickGoals();
                for (PerformanceModel.Goal goal : data.goals)
                {
                    rp.provideRating2(goal.rating);
                    log("Provided Goal rating: " + goal.rating);

                    rp.enterReviewComment2(goal.reviewComment);
                    log("Entered Goal review comment: " + goal.reviewComment);

                    rp.enterOverallComment2(goal.overallComment);
                    log("Entered Goal overall comment: " + goal.overallComment);

                    BasePage.pressTab();
                    log("Pressed Tab key");

                    rp.enterTrainingRequirements2(goal.learningRequirements);
                    log("Entered Goal learning requirements: " + goal.learningRequirements);

                    rp.scrollPage();
                    log("Scrolled the page");

                    rp.clickSave();
                    log("Clicked on Save button");
                }
                //endregion

                //region Competencies
                rp.clickCompetencies();
                for (PerformanceModel.Competency comp : data.competencies)
                {
                    rp.provideRating3(comp.rating);
                    log("Provided Competency rating: " + comp.rating);

                    rp.enterReviewComment3(comp.reviewComment);
                    log("Entered Competency review comment: " + comp.reviewComment);

                    rp.enterOverallComment3(comp.overallComment);
                    log("Entered Competency overall comment: " + comp.overallComment);

                    BasePage.pressTab();
                    log("Pressed Tab key");

                    rp.enterTrainingRequirements3(comp.learningRequirements);
                    log("Entered Competency learning requirements: " + comp.learningRequirements);

                    rp.scrollPage();
                    log("Scrolled the page");

                    rp.clickSave();
                    log("Clicked on Save button");
                }
                //endregion

                //region Review Questions
                rp.clickReviewQuestions();
                for (PerformanceModel.ReviewQuestion rq : data.reviewQuestions)
                {
                    rp.enterOverallComment4(rq.overallComment);
                    log("Entered Review Question overall comment: " + rq.overallComment);

                    rp.enterLearningRequirements(rq.learningRequirements);
                    log("Entered Review Question learning requirements: " + rq.learningRequirements);

                    rp.scrollPage();
                    log("Scrolled the page");

                    rp.clickSave();
                    log("Clicked on Save button");
                }
                //endregion

                //region Performance
                rp.clickPerformance();
                for (PerformanceModel.Performance perf : data.performance)
                {
                    rp.enterHikeAmount(perf.hikeAmount);
                    log("Entered Hike Amount: " + perf.hikeAmount);

                    rp.enterHikePercentage(perf.hikePercentage);
                    log("Entered Hike Percentage: " + perf.hikePercentage);

                    rp.selectPromotedDepartment(perf.promotedDepartment);
                    log("Selected Promoted Department: " + perf.promotedDepartment);

                    rp.selectPromotedDesignation(perf.promotedDesignation);
                    log("Selected Promoted Designation: " + perf.promotedDesignation);

                    rp.enterOverallComment(perf.overallComment);
                    log("Entered Performance overall comment: " + perf.overallComment);

                    rp.enterLearningRequirements(perf.learningRequirements);
                    log("Entered Performance learning requirements: " + perf.learningRequirements);

                    rp.scrollPage();
                    log("Scrolled the page");

                    rp.clickSave();
                    log("Clicked on Save button");
                }
                //endregion

                //region Skills & Learning
                rp.clickSkillsAndLearning();
                for (PerformanceModel.SkillAndLearning sl : data.skillsAndLearning)
                {
                    rp.clickSkillsAndLearning();
                    log("Clicked on Skills & Learning tab");
                    rp.provideNewLevel();
                    log("Clicked on New Level button");

                    rp.addRemoveLearningCourse();
                    log("Clicked on Add/Remove Learning Course button");

                    rp.enterOverallComment(sl.overallComment);
                    log("Entered Skills & Learning overall comment: " + sl.overallComment);

                    rp.enterLearningRequirements(sl.learningRequirements);
                    log("Entered Skills & Learning learning requirements: " + sl.learningRequirements);

                    rp.scrollPage();
                    log("Scrolled the page");

                    rp.clickSave();
                    log("Clicked on Save button");
                }

                rp.scrollPageSubmitForOpinion();
                log("Scrolled the page to access Submit For Opinion button");
                rp.clickSubmitForOpinion();
                log("Clicked on Submit For Opinion button");
                BasePage.pressEnter();
                log("Pressed Enter key");
                BasePage.waitTS(3);
                BrowserUtils.refreshPage(BaseTest.getDriver());

                Assert.assertTrue(rp.verifyStatus(), "Status not updated to 'Pending for employee's opinion'");
                log("Verified: Status updated to 'Pending for employee's opinion'");

                //endregion

                //region Employee's opinion
                BasePage.logoutAndLogin("rohitc@test.com", "123");

                //region  Open Opinion Notification
                tn.clickBellIcon();
                log("Clicked on Bell icon to open Notifications");

                softAssert.assertTrue(tn.validateMyApprovalData(appraisalCycleName), "Notification data not found: " + appraisalCycleName);
                log("Verified: Notification data found: " + appraisalCycleName);

                tn.openTxn();
                BasePage.waitTS(5);
                BasePage.switchTab();
                BasePage.closeTab();
                BasePage.waitTS(3);
                log("tab switched to appraisal review page");
                //endregion

                rp.provideEmpOpinionKRA();
                log("Provided Employee's Opinion on KRA");

                rp.scrollPage();
                BasePage.clickOnSave();
                log("Clicked on Save button");

                rp.clickGoals();
                log("Clicked on Goals tab");
                rp.provideEmpOpinionGoal();
                log("Provided Employee's Opinion on Goal");

                rp.scrollPage();
                BasePage.clickOnSave();
                log("Clicked on Save button");

                rp.clickCompetencies();
                log("Clicked on Competencies tab");

                rp.provideEmpOpinionCompetencies();
                log("Provided Employee's Opinion on Competency");

                rp.scrollPage();
                BasePage.clickOnSave();
                log("Clicked on Save button");

                rp.clickSubmit();
                log("Clicked on Submit button");
                BasePage.waitTS(2);
                BasePage.pressEnter();
                log("Pressed Enter key");

                //endregion

                //region Manager review after employee's opinion
                BasePage.logoutAndLogin("vaibhav@test.com", "123");

                //region  Open Opinion Notification
                tn.clickBellIcon();
                log("Clicked on Bell icon to open Notifications");

                softAssert.assertTrue(tn.validateMyApprovalData(appraisalCycleName), "Notification data not found: " + appraisalCycleName);
                log("Verified: Notification data found: " + appraisalCycleName);

                tn.openTxn();
                BasePage.waitTS(5);
                BasePage.switchTab();
                BasePage.closeTab();
                BasePage.waitTS(3);
                log("tab switched to appraisal review page");
                //endregion

                rp.scrollPageApprove();
                log("Scrolled the page to access Approve button");

                BasePage.clickOnApprove();
                log("Clicked on Approve button");

                BasePage.waitTS(2);

                BasePage.pressEnter();
                log("Pressed Enter key");

                //endregion

                //region Validation
                /*
                Map<String, String> expectedData = new HashMap<>();
                expectedData.put("finalScore", "91.00");
                expectedData.put("finalRating", "Strongly Agree");

                for (String key : rp.extractRating().keySet())
                {
                    Assert.assertEquals(
                            rp.extractRating().get(key),
                            expectedData.get(key),
                            key + " mismatch!"
                    );
                }
                */

                for (PerformanceModel.ExpectedRating er : data.expectedRating)
                {
                    Assert.assertTrue(rp.extractRating(er.finalScore, er.finalRating), "Final Score/Rating mismatch!");
                    log("Verified: Final Score/Rating matched successfully!");
                }

                //endregion

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}