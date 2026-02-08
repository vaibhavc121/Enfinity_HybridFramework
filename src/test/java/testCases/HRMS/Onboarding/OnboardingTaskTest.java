package testCases.HRMS.Onboarding;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Onboarding.OnboardingPage;
import pageObjects.HRMS.Onboarding.OnboardingTaskPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class OnboardingTaskTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createOnboardingTask()
    {
        try
        {
            // String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            // List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport", ITSupportModel.class);

            // onboarding page
            OnboardingPage op = new OnboardingPage();
            op.clickOnboarding();
            log("Clicked on Onboarding");

            BasePage.globalSearchEquals("Onboarding Task");
            log("Searched for Onboarding Task");

            BasePage.clickOnNew();
            log("Clicked on New Button");

            OnboardingTaskPage otp = new OnboardingTaskPage();
            otp.provideName("Complete Documentation");
            log("Provided Task Name");

            otp.selectCategory("Manager");
            log("Selected Category");

            otp.selectAssignTo("Manager");
            log("Selected Assign To");

            otp.provideDueOn("On Hire Date");
            log("Provided Due On");

            otp.provideDesc("desc");
            log("Provided Description");

            BasePage.clickViewAndBack();
            log("Clicked on View and Back");

            Assert.assertTrue(BasePage.validateListing("Complete Documentation", 2, 1), "Onboarding task creation failed: " + "Complete Documentation");
            log("Verified: Onboarding task created successfully: " + "Complete Documentation");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteOnboardingTask()
    {
        try
        {
            // String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            // List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport", ITSupportModel.class);

            // onboarding page
            OnboardingPage op = new OnboardingPage();
            op.clickOnboarding();
            log("Clicked on Onboarding");

            BasePage.globalSearchEquals("Onboarding Task");
            log("Searched for Onboarding Task");

            BasePage.deleteTxn(2, "Complete Documentation");
            Assert.assertFalse(BasePage.validateListing("Complete Documentation", 2, 1));
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}