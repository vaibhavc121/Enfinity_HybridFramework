package testCases.HRMS.Recruitment.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import pageObjects.HRMS.Recruitment.Setups.InterviewTypePage;
import utilities.BrowserUtils;
import utilities.RetryAnalyzer;

public class InterviewTypeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createInterviewType()
    {
        try
        {
            //Recruitment pg
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            log("clicked on recruitment link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Interview Type pg
            InterviewTypePage itp = new InterviewTypePage();
            itp.clickInterviewType();
            log("clicked on interview type link");
            BasePage.clickOnNew();
            log("clicked on new button");
            itp.provideName("InterviewType");
            log("provided interview type name: InterviewType");
            BasePage.clickViewAndBack();
            log("clicked on view and back button");

            Assert.assertTrue(BasePage.validateListing("InterviewType", 2, 1), "Interview type creation failed: InterviewType");
            log("Verified: Interview type created successfully: InterviewType");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteInterviewType()
    {
        //Recruitment pg
        RecruitmentPage rp = new RecruitmentPage();
        rp.clickRecruitment();
        log("clicked on recruitment link");
        BasePage.clickSetups();
        log("clicked on setups link");

        //Interview Type pg
        InterviewTypePage itp = new InterviewTypePage();
        itp.clickInterviewType();
        log("clicked on interview type link");

        BasePage.performAction(2, "InterviewType", "Delete");
        BrowserUtils.navigateBack(BaseTest.getDriver());

        Assert.assertFalse(BasePage.validateListing("InterviewType", 2, 1), "Course trainer deletion failed: " + "InterviewType");
        log("Verified: Course trainer deleted successfully: " + "InterviewType");
    }
}