package testCases.HRMS.Learning.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Learning.LearningPage;
import pageObjects.HRMS.Learning.Setups.CourseCategoryPage;
import utilities.BrowserUtils;
import utilities.RetryAnalyzer;

public class CourseCategoryTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createCourseCategory()
    {
        try
        {
            //Learning pg
            LearningPage lp = new LearningPage();
            lp.clickLearning();
            log("clicked on learning link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Course Category pg
            CourseCategoryPage ccp = new CourseCategoryPage();
            ccp.clickCourseCategory();
            log("clicked on course category link");
            BasePage.clickOnNew();
            log("clicked on new button");
            ccp.provideName("CourseCategory");
            log("provided course category name: CourseCategory");

            BasePage.clickViewAndBack();
            log("clicked on view and back button");

            Assert.assertTrue(BasePage.validateListing("CourseCategory", 2, 1), "Course category creation failed: CourseCategory");
            log("Verified: Course category created successfully: CourseCategory");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteCourseCategory()
    {
        //Learning pg
        LearningPage lp = new LearningPage();
        lp.clickLearning();
        log("clicked on learning link");
        BasePage.clickSetups();
        log("clicked on setups link");

        //Course Category pg
        CourseCategoryPage ccp = new CourseCategoryPage();
        ccp.clickCourseCategory();
        log("clicked on course category link");

        BasePage.performAction(2, "CourseCategory", "Delete");
        BrowserUtils.navigateBack(BaseTest.getDriver());

        Assert.assertFalse(BasePage.validateListing("CourseCategory", 2, 1), "Course trainer deletion failed: " + "CourseCategory");
        log("Verified: Course trainer deleted successfully: " + "CourseCategory");
    }
}