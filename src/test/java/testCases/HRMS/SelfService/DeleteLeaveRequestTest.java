package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.LeaveRequestModel;
import pageObjects.HRMS.SelfService.LeaveRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteLeaveRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteLeaveRequest()
    {
        try
        {
            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            log("Navigated to Self Service page");
            ss.clickTransactions();
            log("Clicked on Transactions");

            // leave request page
            LeaveRequestPage lr = new LeaveRequestPage(driver);
            lr.clickLeaveRequest();
            log("Clicked on Leave Request");

            BasePage.deleteTxn(7, "active");
            log("Leave Request deleteted successfully");
            Assert.assertFalse(BasePage.validateListing("active", 7, 7));
            log("Verified: There is no active Leave on the listing page");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}