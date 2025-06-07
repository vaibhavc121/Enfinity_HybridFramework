package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ResignationModel;
import pageObjects.HRMS.SelfService.ResignationPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateResignationTest extends BaseTest
{
	public void createResignation()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<ResignationModel> resignationData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createResignation", ResignationModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// Resignation page
			ResignationPage rp = new ResignationPage(driver);

			for (ResignationModel resignation : resignationData)
			{
				// rp.scrollDownWebpage();
				rp.clickResignation();
				rp.clickNew();
				rp.provideSubmittedDate(resignation.submittedDate);
				rp.provideRemarks(resignation.remarks);
				rp.clickOnSaveAndBack();

				Assert.assertTrue(rp.isTransactionCreated1());
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
