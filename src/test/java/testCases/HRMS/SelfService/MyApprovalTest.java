package testCases.HRMS.SelfService;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SelfService.ExceptionRequestPage;
import pageObjects.HRMS.SelfService.MyApprovalsPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.TimeOffPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class MyApprovalTest extends BaseTest
{
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class)
    public void verifyBulkApproval()
    {
        try
        {
            BasePage.logoutAndLogin("rohitc@test.com", "123");

            //region Pageobjects
            SelfServicePage ss = new SelfServicePage(driver);
            ExceptionRequestPage erp = new ExceptionRequestPage(driver);
            TimeOffPage top = new TimeOffPage(driver);
            CreateExceptionRequestTest er = new CreateExceptionRequestTest();
            CreateTimeOffTest to = new CreateTimeOffTest();
            //endregion

            //region Create Exception Request
            er.createExceptionRequest();
            //endregion

            //region Create TimeOff Request
            to.createTimeOff();
            //endregion

            //region Bulk approve the leave request from manager login
            BasePage.logoutAndLogin("vaibhav@test.com", "123");
            BasePage.clickMenuIcon();
            ss.clickSelfService();
            log("clicked on Self Service");
            ss.clickMyApprovals();
            log("clicked on My Approvals");

            MyApprovalsPage ma = new MyApprovalsPage(driver);
            ma.bulkApproveRequest("Rohit Chavan");
            //endregion

            //region Assertion
            Assert.assertTrue(ma.isApproveButtonDisplay(), "Bulk approval failed, approve button is still displayed.");
            log("Verified: Transactions are bulk approved successfully");
            //endregion

            //region Delete Exception Request
            // self service page
            BasePage.clickMenuIcon();
            ss.clickSelfService();
            log("clickSelfService");

            ss.clickTransactions();
            log("clickTransactions");

            erp.createExceptionRequest();
            log("click Exception Request");

            BasePage.performAction(6, "002", "Amend");
            Assert.assertFalse(BasePage.validateListing("001", 6, 6), "Exception request not deleted successfully.");
            log("Verified: Exception request deleted successfully");
            //endregion

            //region Delete TimeOff Request
            BasePage.clickMenuIcon();
            ss.clickSelfService();
            ss.clickTransactions();

            // time off page
            top.clickTimeOff();
            // to.selectRow();
            // to.clickOnView();
            // to.clickContextMenu();
            // to.clickDelete();
            // to.clickOk();
            // BasePage.deleteTxn(8, "active");
            BasePage.performAction(5, "002", "Amend");
            Assert.assertFalse(BasePage.validateListing("001", 5, 5), "Time off request not deleted successfully.");
            log("Verified: Time off request deleted successfully");
            //endregion

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}