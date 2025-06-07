package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.LeaveRequestModel;
import pageObjects.HRMS.SelfService.LeaveExtensionPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteLeaveExtensionTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, enabled = false)
	public void deleteLeaveExtension()
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

			// Leave extension page
			LeaveExtensionPage le = new LeaveExtensionPage(driver);
			// le.clickLeaveExtension();

			BasePage.deleteTxn(7, "active");

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
