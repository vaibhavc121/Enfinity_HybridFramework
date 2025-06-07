package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.LeaveRequestModel;
import pageObjects.HRMS.Global.NotificationPage;
import pageObjects.HRMS.SelfService.LeaveRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class VerifyApproveWorkflowTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void verifyApproveWorkflow()
	{
		try
		{
			String leaveRequestFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<LeaveRequestModel> leaveRequestData = JsonUtils.convertJsonListDataModel(leaveRequestFile,
					"checkWorkflow", LeaveRequestModel.class);

			BasePage.logoutAndLogin("rohitc@test.com", "123");

			// self service module
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Leave Request page
			LeaveRequestPage lr = new LeaveRequestPage(driver);

			// create leave request as employee
			for (LeaveRequestModel leaveRequest : leaveRequestData)
			{
				lr.clickLeaveRequest();
				Thread.sleep(5000);
				lr.clickNew();
				lr.hoverAndClick(leaveRequest.leaveType);
				lr.provideFromDate(leaveRequest.fromDate);
				lr.provideToDate(leaveRequest.toDate);
				lr.clickSaveAndSubmit();
				// lr.clickSave();

				// ClassicAssert.isTrue(lr.isTxnCreated(leaveRequest.expFromDate,
				// leaveRequest.expToDate));
			}

			// approve the leave request from manager login
			BasePage.logoutAndLogin("vaibhav@test.com", "123");
			NotificationPage np = new NotificationPage(driver);
			for (LeaveRequestModel leaveRequest : leaveRequestData)
			{
				np.clickBellIcon();
				np.isLeaveDataCorrect(leaveRequest.expEmpName, "Approve");
			}

			// amend the txn
			BasePage.logoutAndLogin("rohitc@test.com", "123");
			ss.clickSelfService();
			ss.clickTransactions();
			lr.clickLeaveRequest();
			for (LeaveRequestModel leaveRequest : leaveRequestData)
			{
				BasePage.performAction(7, "Approve", "Amend");
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
