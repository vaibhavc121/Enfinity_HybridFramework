package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.DeleteSupportRequestCategoryModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.SupportRequestCategoryPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteSupportReqCategoryTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteSupportReqCategory()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<DeleteSupportRequestCategoryModel> supportRequestCategoryData = JsonUtils.convertJsonListDataModel(
					selfServiceFile, "deleteSupportRequestCategory", DeleteSupportRequestCategoryModel.class);

			// SupportRequestCategory
			SupportRequestCategoryPage sr = new SupportRequestCategoryPage(driver);
			for (DeleteSupportRequestCategoryModel SRC : supportRequestCategoryData)
			{
				sr.globalSearch1("support request category");
				sr.deleteTransaction(2, SRC.categoryName);

				Assert.assertFalse(BasePage.validateListing(SRC.categoryName, 2, 1));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("VRC- Test case failed: " + e);
		}
	}

}
