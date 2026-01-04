package testCases.HRMS.SuccessionPlanning.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.SuccessionPlanning.SuccessionPlanning.SuccessionModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SuccessionPlanning.Setups.ReadinessPage;
import pageObjects.HRMS.SuccessionPlanning.SuccessionPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class ReadinessTest extends BaseTest
{
    String successionPlanningFile = FileUtils.getDataFile("SuccessionPlanning", "SuccessionPlanning", "SuccessionData");
    List<SuccessionModel.ReadinessModel> readinessData = JsonUtils.convertJsonListDataModel(successionPlanningFile, "readiness", SuccessionModel.ReadinessModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createReadiness()
    {
        try
        {
            SuccessionPage op = new SuccessionPage();
            op.clickSuccessionPlanning();
            log("clicked on succession planning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Readiness pg
            ReadinessPage rp = new ReadinessPage();
            rp.clickReadiness();
            log("clicked on readiness link");

            for (SuccessionModel.ReadinessModel readiness : readinessData)
            {
                BasePage.clickOnNew();
                log("clicked on new button");
                rp.provideName(readiness.name);
                log("provided readiness name: " + readiness.name);
                rp.provideFromPercentage(readiness.fromPercentage);
                log("provided from percentage: " + readiness.fromPercentage);
                rp.provideToPercentage(readiness.toPercentage);
                log("provided to percentage: " + readiness.toPercentage);
                BasePage.clickViewAndBack();
                log("clicked on view and back button");

                Assert.assertTrue(BasePage.validateListing(readiness.name, 2, 1), "Readiness creation failed: " + readiness.name);
                log("Verified: Readiness created successfully: " + readiness.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteReadiness()
    {
        SuccessionPage op = new SuccessionPage();
        op.clickSuccessionPlanning();
        log("clicked on succession planning link");
        BasePage.clickSetups();
        log("clicked on setups link");

        //Readiness pg
        ReadinessPage rp = new ReadinessPage();
        rp.clickReadiness();
        log("clicked on readiness link");
        for (SuccessionModel.ReadinessModel readiness : readinessData)
        {
            BasePage.performAction(2, readiness.name, "Delete");
            BrowserUtils.navigateBack(BaseTest.getDriver());

            Assert.assertFalse(BasePage.validateListing(readiness.name, 2, 1), "Readiness is not deleted: " + readiness.name);
            log("Verified: Readiness deleted successfully: " + readiness.name);
        }
    }
}