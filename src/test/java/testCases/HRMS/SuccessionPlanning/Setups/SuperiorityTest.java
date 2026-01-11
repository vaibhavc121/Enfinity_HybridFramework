package testCases.HRMS.SuccessionPlanning.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.SuccessionPlanning.SuccessionPlanning.SuccessionModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SuccessionPlanning.Setups.SuperiorityPage;
import pageObjects.HRMS.SuccessionPlanning.SuccessionPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class SuperiorityTest extends BaseTest
{
    String successionPlanningFile = FileUtils.getDataFile("SuccessionPlanning", "SuccessionPlanning", "SuccessionData");
    List<SuccessionModel.SuperiorityModel> superiorityData = JsonUtils.convertJsonListDataModel(successionPlanningFile, "superiority", SuccessionModel.SuperiorityModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSuperiority()
    {
        try
        {
            SuccessionPage op = new SuccessionPage();
            op.clickSuccessionPlanning();
            log("clicked on succession planning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Superiority pg
            SuperiorityPage sp = new SuperiorityPage();
            sp.clickSuperiority();
            log("clicked on superiority link");
            for (SuccessionModel.SuperiorityModel superiority : superiorityData)
            {
                BasePage.clickOnNew();
                log("clicked on new button");
                sp.provideName(superiority.name);
                log("provided superiority name: " + superiority.name);
                sp.provideFromPercentage(superiority.fromPercentage);
                log("provided from percentage: " + superiority.fromPercentage);
                sp.provideToPercentage(superiority.toPercentage);
                log("provided to percentage: " + superiority.toPercentage);
                BasePage.clickViewAndBack();
                log("clicked on view and back button");

                Assert.assertTrue(BasePage.validateListing(superiority.name, 2, 1), "Superiority creation failed: " + superiority.name);
                log("Verified: Superiority created successfully: " + superiority.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteSuperiority()
    {
        try
        {
            SuccessionPage op = new SuccessionPage();
            op.clickSuccessionPlanning();
            log("clicked on succession planning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Superiority pg
            SuperiorityPage sp = new SuperiorityPage();
            sp.clickSuperiority();
            log("clicked on superiority link");

            for (SuccessionModel.SuperiorityModel superiority : superiorityData)
            {
                BasePage.performAction(2, superiority.name, "Delete");
                BrowserUtils.navigateBack(BaseTest.getDriver());

                Assert.assertFalse(BasePage.validateListing(superiority.name, 2, 1), "Superiority deletion failed: " + superiority.name);
                log("Verified: Superiority deleted successfully: " + superiority.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}