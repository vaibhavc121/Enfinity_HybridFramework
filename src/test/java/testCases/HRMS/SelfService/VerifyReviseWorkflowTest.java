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

public class VerifyReviseWorkflowTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void verifyReviseWorkflow()
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
			log("clickSelfService");

			ss.clickTransactions();
			log("clickTransactions");

			// Leave Request page
			LeaveRequestPage lr = new LeaveRequestPage(driver);

			// create leave request as employee
			for (LeaveRequestModel leaveRequest : leaveRequestData)
			{
				lr.clickLeaveRequest();
				log("clickLeaveRequest");

				Thread.sleep(5000);

				lr.clickNew();
				log("clickNew");

				lr.hoverAndClick(leaveRequest.leaveType);
				log("hoverAndClick");

				lr.provideFromDate(leaveRequest.fromDate);
				log("provideFromDate");

				lr.provideToDate(leaveRequest.toDate);
				log("provideToDate");

				lr.clickSaveAndSubmit();
				log("clickSaveAndSubmit");
				// lr.clickSave();

				// ClassicAssert.isTrue(lr.isTxnCreated(leaveRequest.expFromDate,
				// leaveRequest.expToDate));
			}

			// Revise the leave request from manager login
			BasePage.logoutAndLogin("vaibhav@test.com", "123");
			NotificationPage np = new NotificationPage(driver);
			for (LeaveRequestModel leaveRequest : leaveRequestData)
			{
				np.clickBellIcon();
				log("");
				np.isLeaveDataCorrect(leaveRequest.expEmpName, "Revise");
			}

			// Amend & Delete the txn
			BasePage.logoutAndLogin("rohitc@test.com", "123");
			ss.clickSelfService();
			log("clickSelfService");

			ss.clickTransactions();
			log("clickTransactions");

			lr.clickLeaveRequest();
			log("clickLeaveRequest");

			for (LeaveRequestModel leaveRequest : leaveRequestData)
			{
				BasePage.performAction(7, "Active", "Delete");
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}