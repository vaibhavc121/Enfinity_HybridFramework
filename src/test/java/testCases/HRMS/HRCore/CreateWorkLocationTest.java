package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateWorkLocationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.HRCore.WorkLocationPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateWorkLocationTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createWorkLocation()
	{
		try
		{
			String workLocationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<CreateWorkLocationModel> workLocationData = JsonUtils.convertJsonListDataModel(workLocationFile,
					"createWorkLocation", CreateWorkLocationModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			sp.clickWorkLocation();
			Thread.sleep(2000);

			WorkLocationPage wl = new WorkLocationPage(driver);
			for (CreateWorkLocationModel workLocation : workLocationData)
			{
				wl.clickNew();
				wl.provideWorkLocName(workLocation.workLocationName);
				wl.clickSaveBack();

				BasePage.validateListing(workLocation.workLocationName, 2, 1);
			}
			// ClassicAssert.isTrue(wl.isTxnCreated());

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
