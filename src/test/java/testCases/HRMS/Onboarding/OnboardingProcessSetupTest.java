package testCases.HRMS.Onboarding;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Onboarding.OnboardingPage;
import pageObjects.HRMS.Onboarding.OnboardingProcessSetupPage;
import pageObjects.HRMS.Onboarding.OnboardingTaskPage;
import utilities.RetryAnalyzer;

public class OnboardingProcessSetupTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createOnboardingProcessSetupTest()
    {
        try
        {
            // String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            // List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport", ITSupportModel.class);

            // onboarding page
            OnboardingPage op = new OnboardingPage();
            op.clickOnboarding();
            log("Clicked on Onboarding");

            BasePage.globalSearchEquals("Onboarding Process Setup");
            log("Searched for Onboarding Process Setup");

            BasePage.clickOnNew();
            log("Clicked on New Button");

            OnboardingProcessSetupPage otp = new OnboardingProcessSetupPage();
            otp.provideName("Onboarding Process Setup");
            log("Provided Process Name");

            BasePage.clickOnSave();
            log("Clicked on Save");

            otp.provideArrivalTime("12:00 AM");
            log("Provided Arrival Time");

            otp.selectWorkLocation("Sharq City");
            log("Selected Work Location");

            otp.selectContactPerson("001 | Vaibhav Chavan");
            log("Selected Contact Person");

            otp.provideWelcomeNote("Welcome to the company!");
            log("Provided Welcome Note");

            otp.provideURL();
            log("Provided URL");

            otp.provideOtherInstructions("Please complete your profile and submit the required documents.");
            log("Provided Other Instructions");

            otp.scrollToEmpIntroEmailTemplate();
            log("Scrolled to Employee Introduction Email Template");

            otp.selectEmpIntroEmailTemplate("10000 | Generic");
            log("Selected Employee Introduction Email Template");

            otp.selectEmailParticipants("HR");
            log("Selected Email Participants");

            otp.provideEmailRecipient("abc@gmail.com");
            log("Provided Email Recipient");

            BasePage.clickViewAndBack();
            log("Clicked on View and Back");

            Assert.assertTrue(BasePage.validateListing("Onboarding Process Setup", 2, 1), "Onboarding Process Setup task creation failed: " + "Onboarding Process Setup");
            log("Verified: OnboardingProcessSetup created successfully: " + "Onboarding Process Setup");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteOnboardingProcessSetupTest()
    {
        try
        {
            // String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            // List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport", ITSupportModel.class);

            // onboarding page
            OnboardingPage op = new OnboardingPage();
            op.clickOnboarding();
            log("Clicked on Onboarding");

            BasePage.globalSearchEquals("Onboarding Process Setup");
            log("Searched for Onboarding Process Setup");

            BasePage.deleteTxn(2, "Onboarding Process Setup");
            Assert.assertFalse(BasePage.validateListing("Onboarding Process Setup", 2, 1));
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}