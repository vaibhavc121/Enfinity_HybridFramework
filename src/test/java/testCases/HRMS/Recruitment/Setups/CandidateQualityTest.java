package testCases.HRMS.Recruitment.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Learning.LearningPage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import pageObjects.HRMS.Recruitment.Setups.CandidateQualityPage;
import utilities.BrowserUtils;
import utilities.RetryAnalyzer;

public class CandidateQualityTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createCandidateQuality()
    {
        try
        {
            //Recruitment pg
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            log("clicked on recruitment link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Candidate Quality pg
            CandidateQualityPage cqp = new CandidateQualityPage();
            cqp.clickCandidateQuality();
            log("clicked on candidate quality link");
            BasePage.clickOnNew();
            log("clicked on new button");
            cqp.provideName("CandidateQuality");
            log("provided candidate quality name: CandidateQuality");
            BasePage.clickViewAndBack();
            log("clicked on view and back button");

            Assert.assertTrue(BasePage.validateListing("CandidateQuality", 2, 1), "Candidate quality creation failed: CandidateQuality");
            log("Verified: Candidate quality created successfully: CandidateQuality");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteCandidateQuality()
    {
        //Recruitment pg
        RecruitmentPage rp = new RecruitmentPage();
        rp.clickRecruitment();
        log("clicked on recruitment link");
        BasePage.clickSetups();
        log("clicked on setups link");

        //Candidate Quality pg
        CandidateQualityPage cqp = new CandidateQualityPage();
        cqp.clickCandidateQuality();
        log("clicked on candidate quality link");

        BasePage.performAction(2, "CandidateQuality", "Delete");
        BrowserUtils.navigateBack(BaseTest.getDriver());

        Assert.assertFalse(BasePage.validateListing("CandidateQuality", 2, 1), "Course trainer deletion failed: " + "CandidateQuality");
        log("Verified: Course trainer deleted successfully: " + "CandidateQuality");
    }
}