package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.SupportRequestCategoryModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.SupportRequestCategoryPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateSupportRequestCategoryTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createSupportRequestCategory()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<SupportRequestCategoryModel> supportRequestCategoryData = JsonUtils.convertJsonListDataModel(
					selfServiceFile, "createSupportRequestCategory", SupportRequestCategoryModel.class);

			// global search
			SupportRequestCategoryPage sr = new SupportRequestCategoryPage(driver);

			for (SupportRequestCategoryModel src : supportRequestCategoryData)
			{
				sr.globalSearch1("support request category");
				sr.clickNew();
				sr.provideCategoryname(src.categoryName);
				sr.selectRequestedTo(src.requestedTo);
				sr.selectPriority(src.priority);
				sr.selectWorkflow(src.workflow);
				sr.requireAttachment(src.attachment);
				sr.provideDesc(src.desc);
				sr.clickSaveBack();

				Assert.assertTrue(sr.isTransactionCreated(null, src.categoryName, null));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("VRC- Test case failed: " + e);
		}
	}

}
