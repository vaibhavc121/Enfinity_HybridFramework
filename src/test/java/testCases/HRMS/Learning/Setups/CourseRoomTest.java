package testCases.HRMS.Learning.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Learning.Learning.LearningModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Learning.LearningPage;
import pageObjects.HRMS.Learning.Setups.CourseRoomPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CourseRoomTest extends BaseTest
{
    String learningFile = FileUtils.getDataFile("Learning", "Learning", "LearningData");
    List<LearningModel.CourseRoomModel> courseRoomData = JsonUtils.convertJsonListDataModel(learningFile, "courseRoom",
            LearningModel.CourseRoomModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createCourseRoom()
    {
        try
        {
            //Learning pg
            LearningPage lp = new LearningPage();
            lp.clickLearning();
            log("clicked on learning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Course Room pg
            CourseRoomPage crp = new CourseRoomPage();
            crp.clickCourseRoom();
            log("clicked on course room link");
            BasePage.clickOnNew();
            log("clicked on new button");

            for (LearningModel.CourseRoomModel data : courseRoomData)
            {
                crp.provideName(data.name);
                log("provided course room name: " + data.name);
                crp.provideCapacity(data.capacity);
                log("provided course room capacity: " + data.capacity);
                crp.provideLocation(data.location);
                log("provided course room location: " + data.location);
                crp.provideFacilities(data.facilities);
                log("provided course room facilities: " + data.facilities);

                BasePage.clickViewAndBack();
                log("clicked on view and back button");

                Assert.assertTrue(BasePage.validateListing(data.name, 2, 1), "Course room creation failed: " + data.name);
                log("Verified: Course room created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteCourseRoom()
    {
        try
        {
            //Learning pg
            LearningPage lp = new LearningPage();
            lp.clickLearning();
            log("clicked on learning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Course Room pg
            CourseRoomPage crp = new CourseRoomPage();
            crp.clickCourseRoom();
            log("clicked on course room link");

            for (LearningModel.CourseRoomModel data : courseRoomData)
            {
                BasePage.performAction(2, data.name, "Delete");
                BrowserUtils.navigateBack(BaseTest.getDriver());

                Assert.assertFalse(BasePage.validateListing(data.name, 2, 1), "Course room deletion failed: " + data.name);
                log("Verified: Course room deleted successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}