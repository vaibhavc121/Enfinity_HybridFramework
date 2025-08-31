package testCases.HRMS.SelfService;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.LeaveRequestModel;
import pageObjects.HRMS.SelfService.LeaveRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class LeaveRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createLeaveRequest()
    {
        try
        {
            String leaveRequestFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<LeaveRequestModel> leaveRequestData = JsonUtils.convertJsonListDataModel(leaveRequestFile,
                    "createLeaveRequest", LeaveRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            ss.clickTransactions();

            // leave request page
            LeaveRequestPage lr = new LeaveRequestPage(driver);

            for (LeaveRequestModel leaveRequest : leaveRequestData)
            {
                lr.clickLeaveRequest();
                Thread.sleep(5000);
                lr.clickNew();
                lr.hoverAndClick(leaveRequest.leaveType); //sick leave
                lr.provideFromDate(leaveRequest.fromDate);
                lr.provideToDate(leaveRequest.toDate);
                // lr.clickOnSaveSubmit();
                lr.clickSave();

                Assert.assertTrue(lr.isTxnCreated(leaveRequest.expFromDate, leaveRequest.expToDate));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
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