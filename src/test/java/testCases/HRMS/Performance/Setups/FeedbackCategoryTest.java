package testCases.HRMS.Performance.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Performance.Performance.PerformanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Performance.PerformancePage;
import pageObjects.HRMS.Performance.Setups.FeedbackCategoryPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class FeedbackCategoryTest extends BaseTest
{
    String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
    List<PerformanceModel.RatingTypeModel> feedbackCategoryData = JsonUtils.convertJsonListDataModel(performanceFile, "ratingType", PerformanceModel.RatingTypeModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createFeedbackCategory()
    {
        try
        {
            //Performance pg
            PerformancePage pp = new PerformancePage();
            pp.clickPerformance();
            log("clicked on performance link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Feedback Category pg
            FeedbackCategoryPage fp = new FeedbackCategoryPage();
            fp.clickFeedbackCategory();
            log("clicked on feedback category link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            fp.provideName("Proactiveness");
            log("entered name: Proactiveness");

            BasePage.clickViewAndBack();
            log("clicked on view and back btn");

            Assert.assertTrue(BasePage.validateListing("Proactiveness", 2, 1), "Feedback category creation failed: " + "Proactiveness");
            log("Verified: Feedback category created successfully: " + "Proactiveness");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteFeedbackCategory()
    {
        try
        {
            //Performance pg
            PerformancePage pp = new PerformancePage();
            pp.clickPerformance();
            log("clicked on performance link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Feedback Category pg
            FeedbackCategoryPage fp = new FeedbackCategoryPage();
            fp.clickFeedbackCategory();
            log("clicked on feedback category link");

            BasePage.performAction(2, "Proactiveness", "Delete");
            BrowserUtils.navigateBack(BaseTest.getDriver());

            Assert.assertFalse(BasePage.validateListing("Proactiveness", 2, 1), "Feedback category deletion failed: " + "Proactiveness");
            log("Verified: Feedback category deleted successfully: " + "Proactiveness");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}