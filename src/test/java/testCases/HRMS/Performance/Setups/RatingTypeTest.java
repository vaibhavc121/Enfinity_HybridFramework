package testCases.HRMS.Performance.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Performance.Performance.PerformanceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Performance.PerformancePage;
import pageObjects.HRMS.Performance.Setups.RatingTypePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class RatingTypeTest extends BaseTest
{
    String performanceFile = FileUtils.getDataFile("Performance", "Performance", "PerformanceData");
    List<PerformanceModel.RatingTypeModel> ratingTypeData = JsonUtils.convertJsonListDataModel(performanceFile, "ratingType", PerformanceModel.RatingTypeModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createRatingType()
    {
        try
        {
            //Performance pg
            PerformancePage pp = new PerformancePage();
            pp.clickPerformance();
            log("clicked on performance link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Rating Type pg
            RatingTypePage rp = new RatingTypePage();
            rp.clickRatingType();
            log("clicked on rating type link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            for (PerformanceModel.RatingTypeModel data : ratingTypeData)
            {
                rp.provideName(data.name);
                log("entered name: " + data.name);

                rp.selectRatingType(data.ratingType);
                log("selected rating type: " + data.ratingType);

                BasePage.clickOnSave();
                log("clicked on save btn");

                BasePage.clickOnNewLine();
                log("clicked on new line btn");

                BasePage.clickViewAndBack();
                log("clicked on view and back btn");

                Assert.assertTrue(BasePage.validateListing(data.name, 3, 2), "Rating Type creation failed: " + data.name);
                log("Verified: Rating Type created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteRatingType()
    {
    }
}