package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.TimeOffModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.TimeOffPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteTimeOffTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteTimeOff()
	{
		try
		{
			String timeOffFile = FileUtils.getDataFile("SelfService", "SelfService", "TimeOffData");
			List<TimeOffModel> timeOffData = JsonUtils.convertJsonListDataModel(timeOffFile, "createTimeOff",
					TimeOffModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// time off page
			TimeOffPage to = new TimeOffPage(driver);
			to.clickTimeOff();
			// to.selectRow();
			// to.clickOnView();
			// to.clickContextMenu();
			// to.clickDelete();
			// to.clickOk();
			BasePage.deleteTxn(8, "active");

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
