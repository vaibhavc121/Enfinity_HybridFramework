package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ExceptionRequestModel;
import pageObjects.HRMS.SelfService.ExceptionRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateExceptionRequestTest extends BaseTest
{

	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createExceptionRequest()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<ExceptionRequestModel> exceptionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createExceptionRequest", ExceptionRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// ExceptionRequest page
			ExceptionRequestPage er = new ExceptionRequestPage(driver);

			for (ExceptionRequestModel exception : exceptionRequestData)
			{
				er.createExceptionRequest();
				er.clickNew();
				er.provideExceptionDate(exception.exceptionDate);
				er.provideLoginTime(exception.loginTime);
				// er.provideLogoutTime(exception.loginTime);
				er.provideRemarks(exception.remarks);
				er.clickSaveBack();

				Assert.assertTrue(er.isTxnCreated(exception.exceptionDate));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
