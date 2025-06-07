package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ITSupportModel;
import pageObjects.HRMS.SelfService.ITSupportRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateSupportRequestTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createSupportRequest()
	{
		try
		{
			String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport",
					ITSupportModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// ITSupport page
			ITSupportRequestPage it = new ITSupportRequestPage(driver);

			for (ITSupportModel itSupport : itSupportData)
			{
				it.clickITSupport();
				it.clickNew();
				it.clickPlusBtn();
				it.provideSubject(itSupport.subject);
				it.selectPriority(itSupport.priority);
				it.provideDesc(itSupport.description);
				it.clickSaveBack();
				// it.clickContextMenu();
				// it.clickView();
				// it.clickOnApproveBack();
				Assert.assertTrue(it.isTxnCreated(itSupport.employee, itSupport.recordDesc));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
