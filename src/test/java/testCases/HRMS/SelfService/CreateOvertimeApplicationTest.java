package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.OvertimeRequestModel;
import pageObjects.HRMS.SelfService.OvertimeRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateOvertimeApplicationTest extends BaseTest
{
	public void createOvertimeApplication()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<OvertimeRequestModel> overtimeRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createOvertimeRequest", OvertimeRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Overtime Request page
			OvertimeRequestPage or = new OvertimeRequestPage(driver);

			for (OvertimeRequestModel overtimeRequest : overtimeRequestData)
			{
				// or.scrollDownWebpage();
				or.clickOvertimeRequest();
				or.clickNew();
				or.provideOvertimeDate(overtimeRequest.overtimeDate);
				or.provideOvertimeType(overtimeRequest.overtimeType);
				or.provideHrs(overtimeRequest.hrs);
				or.provideRemarks(overtimeRequest.remarks);

				// additional code
				BasePage.clickOnSave();
				if (BasePage.isTransactionCreated())
				{
					BasePage.clickSaveAndBack();
				} else
				{
					Assert.fail("Test case failed: " + or.displayErrorMsg());
				}

				Assert.assertTrue(or.isTxnCreated(overtimeRequest.overtimeType, overtimeRequest.hrs));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
