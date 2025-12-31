package testCases.HRMS.Learning.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Learning.Learning.LearningModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Learning.LearningPage;
import pageObjects.HRMS.Learning.Setups.CourseTrainerPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CourseTrainerTest extends BaseTest
{
    String learningFile = FileUtils.getDataFile("Learning", "Learning", "LearningData");
    List<LearningModel.CourseRoomModel> courseRoomData = JsonUtils.convertJsonListDataModel(learningFile, "courseRoom",
            LearningModel.CourseRoomModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createCourseTrainer()
    {
        try
        {
            //Learning pg
            LearningPage lp = new LearningPage();
            lp.clickLearning();
            log("clicked on learning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Course Trainer pg
            CourseTrainerPage ctp = new CourseTrainerPage();
            ctp.clickCourseTrainer();
            log("clicked on course trainer link");
            BasePage.clickOnNew();
            log("clicked on new button");

            ctp.provideTrainerName("Vaibhav");
            log("provided course trainer name: Vaibhav");

            BasePage.clickViewAndBack();
            log("clicked on view and back button");

            Assert.assertTrue(BasePage.validateListing("Vaibhav", 2, 1), "Course trainer creation failed: Vaibhav");
            log("Verified: Course trainer created successfully: Vaibhav");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteCourseTrainer()
    {
        //Learning pg
        LearningPage lp = new LearningPage();
        lp.clickLearning();
        log("clicked on learning link");
        BasePage.clickSetups();
        log("clicked on setups link");

        //Course Trainer pg
        CourseTrainerPage ctp = new CourseTrainerPage();
        ctp.clickCourseTrainer();
        log("clicked on course trainer link");

        BasePage.performAction(2, "Vaibhav", "Delete");
        BrowserUtils.navigateBack(BaseTest.getDriver());

        Assert.assertFalse(BasePage.validateListing("Vaibhav", 2, 1), "Course trainer deletion failed: " + "Vaibhav");
        log("Verified: Course trainer deleted successfully: " + "Vaibhav");
    }
}