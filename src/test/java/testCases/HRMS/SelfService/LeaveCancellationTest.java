package testCases.HRMS.SelfService;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Global.NotificationPage;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.SelfService.LeaveRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.BrowserUtils;
import utilities.DateUtils;
import utilities.FileUtils;
import utilities.JsonUtils;

import java.util.List;

public class LeaveCancellationTest extends BaseTest
{
    @Test(groups = "functional", retryAnalyzer = utilities.RetryAnalyzer.class, enabled = false, description = "false bcos not able to amend approved leave request and after reject not able to delete the request")
    public void cancelFutureLeave()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SelfServiceModel.LeaveCancellationModel> leaveCancellationData = JsonUtils.convertJsonListDataModel(selfServiceFile, "leaveCancellation.futureLeave", SelfServiceModel.LeaveCancellationModel.class);

            BasePage.logoutAndLogin("rohitc@test.com", "123");

            // self service module
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            log("clicked on Self Service");

            ss.clickTransactions();
            log("clicked on Transactions");

            // Leave Request page
            LeaveRequestPage lr = new LeaveRequestPage(driver);

            // create leave request as employee
            for (SelfServiceModel.LeaveCancellationModel leaveCancel : leaveCancellationData)
            {
                lr.clickLeaveRequest();
                log("clicked on Leave Request");

                Thread.sleep(5000);

                lr.clickNew();
                log("clicked on New");

                //lr.hoverAndClick(leaveRequest.leaveType);
                lr.clickOnLeaveType(leaveCancel.leaveType, 3); //absent leave
                log("selected leave type: " + leaveCancel.leaveType);

                lr.provideFromDate(DateUtils.addDaysToCurrentDate(7, "dd-MMM-yyyy"));
                log("provided From Date");

                lr.provideToDate(DateUtils.addDaysToCurrentDate(7, "dd-MMM-yyyy"));
                log("provided To Date");

                lr.clickSaveAndSubmit();
                log("clicked on Save and Submit");
                // lr.clickSave();

                // ClassicAssert.isTrue(lr.isTxnCreated(leaveRequest.expFromDate,
                // leaveRequest.expToDate));
            }

            // approve the leave request from manager login
            BasePage.logoutAndLogin("vaibhav@test.com", "123");
            NotificationPage np = new NotificationPage(driver);
            for (SelfServiceModel.LeaveCancellationModel leaveCancel : leaveCancellationData)
            {
                np.clickBellIcon();
                log("clicked on Bell Icon");
                np.isLeaveDataCorrect(leaveCancel.expEmpName, "Approve");
            }

            // Leave Cancellation Request
            BasePage.logoutAndLogin("rohitc@test.com", "123");
            ss.clickSelfService();
            log("clicked on Self Service");
            ss.clickTransactions();
            log("clicked on Transactions");
            lr.clickLeaveRequest();
            log("clicked on Leave Request");
            BasePage.performAction(7, "Approve", "Cancel");
            log("Created Leave Cancellation Request");
            BrowserUtils.refreshPage(driver);
            log("Page refreshed");
            lr.checkCancellationStatus();

            // approve the leave cancellation request from manager login
            BasePage.logoutAndLogin("vaibhav@test.com", "123");
            for (SelfServiceModel.LeaveCancellationModel leaveCancel : leaveCancellationData)
            {
                np.clickBellIcon();
                log("clicked on Bell Icon");
                np.isLeaveDataCorrect(leaveCancel.expEmpName, "Approve");
            }

            // Vaidate Leave Approval
            BasePage.logoutAndLogin("rohitc@test.com", "123");
            ss.clickSelfService();
            log("clicked on Self Service");
            ss.clickTransactions();
            log("clicked on Transactions");
            lr.clickLeaveRequest();
            log("clicked on Leave Request");

            BasePage.filterAndOpenTransaction(7, 7, "Approved", "View");
            lr.checkCancellationStatus1();
            Assert.assertTrue(lr.checkCancellationStatus1(), "Leave cacellation approved failed.");
            log("Verified: Leave cancellation approved successfully");

            BrowserUtils.navigateBack(driver);
            BasePage.performAction(7, "Approve", "Amend");
            log("Transaction amend successfully");
            Assert.assertFalse(BasePage.validateListing("Approved", 7, 7));
            log("Verified: There is no approved request on the listing page");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = utilities.RetryAnalyzer.class)
    public void verifyUserIsRestrictedFromCancellingInProcessOrApprovedLeave()
    {
        try
        {
            //region Test Data Setup
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SelfServiceModel.LeaveCancellationModel> leaveCancellationData = JsonUtils.convertJsonListDataModel(selfServiceFile, "leaveCancellation.futureLeave", SelfServiceModel.LeaveCancellationModel.class);
            //endregion

            //region Page Objects
            SelfServicePage ss = new SelfServicePage(driver);
            LeaveRequestPage lr = new LeaveRequestPage(driver);
            //endregion

            //region self service module: Create Leave Request
            BasePage.logoutAndLogin("rohitc@test.com", "123");

            ss.clickSelfService();
            log("clicked on Self Service");

            ss.clickTransactions();
            log("clicked on Transactions");

            // Leave Request page

            // create leave request as employee
            for (SelfServiceModel.LeaveCancellationModel leaveCancel : leaveCancellationData)
            {
                lr.clickLeaveRequest();
                log("clicked on Leave Request");

                Thread.sleep(5000);

                lr.clickNew();
                log("clicked on New");

                //lr.hoverAndClick(leaveRequest.leaveType);
                lr.clickOnLeaveType(leaveCancel.leaveType, 3); //absent leave
                log("selected leave type: " + leaveCancel.leaveType);

                lr.provideFromDate(DateUtils.addDaysToCurrentDate(-2, "dd-MMM-yyyy"));
                log("provided From Date");

                lr.provideToDate(DateUtils.addDaysToCurrentDate(-1, "dd-MMM-yyyy"));
                log("provided To Date");

                lr.clickSaveAndSubmit();
                log("clicked on Save and Submit");
                // lr.clickSave();

                // ClassicAssert.isTrue(lr.isTxnCreated(leaveRequest.expFromDate,
                // leaveRequest.expToDate));
            }
            //endregion

            //region approve the leave request from manager login
            BasePage.logoutAndLogin("vaibhav@test.com", "123");
            TopNavigationBar tn = new TopNavigationBar(driver);
            for (SelfServiceModel.LeaveCancellationModel leaveCancel : leaveCancellationData)
            {
                tn.clickBellIcon();
                log("clicked on Bell Icon");
                tn.isLeaveDataCorrect(leaveCancel.expEmpName, "Approve");
            }
            //endregion

            //region Leave Cancellation Request
            BasePage.logoutAndLogin("rohitc@test.com", "123");
            ss.clickSelfService();
            log("clicked on Self Service");
            ss.clickTransactions();
            log("clicked on Transactions");
            lr.clickLeaveRequest();
            log("clicked on Leave Request");
            BasePage.performAction(7, "Approve", "Cancel");
            //endregion

            //region validation
            Assert.assertTrue(lr.checkValidationMessage(), "Validation message not displayed for cancelling approved leave request.");
            log("Verified: User is restricted from cancelling approved leave request");
            //endregion

            //region Delete leave request

            for (SelfServiceModel.LeaveCancellationModel leaveCancel : leaveCancellationData)
            {
                BrowserUtils.navigateBack(driver);
                log("navigated back to Leave Request page");

                BasePage.performAction(7, "Approve", "Amend");
                log("Transaction deleted successfully");
//                Assert.assertFalse(BasePage.validateListing(leaveCancel.expEmpName, 6, 6),
//                        "Leave request not deleted successfully");
                if (!BasePage.validateListing("Approve", 7, 7))
                {
                    log("Verified: There is no approved request on the listing page");
                } else
                {
                    throw new RuntimeException("Leave request not deleted successfully");
                }
            }

            //endregion

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}