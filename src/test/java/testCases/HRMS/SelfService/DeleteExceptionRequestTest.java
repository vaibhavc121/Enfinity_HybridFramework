package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pageObjects.HRMS.SelfService.ExceptionRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteExceptionRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteExceptionRequest()
    {
        try
        {
            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            log("clickSelfService");

            ss.clickTransactions();
            log("clickTransactions");

            // ExceptionRequest page
            ExceptionRequestPage er = new ExceptionRequestPage(driver);
            er.createExceptionRequest();
            log("createExceptionRequest");

            //BasePage.deleteTxn(6, "001");
            BasePage.performAction(7, "Approved", "Amend");
            Assert.assertFalse(BasePage.validateListing("001", 6, 6));
            log("assertion successful");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}