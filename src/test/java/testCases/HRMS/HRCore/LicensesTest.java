package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.LicensesPage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.CommonActions;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class LicensesTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLicenses()
    {
        try
        {
            // hr core
            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            log("clicked on hr core link");
            hc.clickSetupForm();
            log("clicked on setup form");

            // setup page
            SetupPage sp = new SetupPage(driver);
            sp.clickLicense();
            Thread.sleep(2000);
            log("clicked on license");

            // license pg
            LicensesPage lp = new LicensesPage(driver);
            lp.clkNewBtn();
            log("clicked on new btn");

            lp.provideName();
            log("provided name");

            lp.selectFileNum();
            log("selected file number");

            BasePage.clickViewAndBack();
            log("Clicked on view and back");

            Assert.assertTrue(BasePage.validateListing("Licenses", 2, 1), "License not created");
            log("Verified: license is created successfully");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteLicenses()
    {
        try
        {
            // hr core
            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            log("clicked on hr core link");
            hc.clickSetupForm();
            log("clicked on setup form");

            // setup page
            SetupPage sp = new SetupPage(driver);
            sp.clickLicense();
            log("clicked on license");
            Thread.sleep(2000);

            BasePage.deleteHrCoreTxn(2, "Licenses");
            Assert.assertFalse(BasePage.validateListing("Licenses", 2, 1), "License not deleted");
            log("Verified: license is deleted successfully");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}