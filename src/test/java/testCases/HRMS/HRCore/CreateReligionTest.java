package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateReligionModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.ReligionPage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateReligionTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createReligion()
	{
		try
		{
			String religionFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<CreateReligionModel> religionData = JsonUtils.convertJsonListDataModel(religionFile, "createReligion",
					CreateReligionModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			sp.clickReligion();
			Thread.sleep(2000);

			ReligionPage rp = new ReligionPage(driver);
			for (CreateReligionModel religion : religionData)
			{
				rp.clickNew();
				rp.provideReligionName(religion.religionName);
				rp.clickSaveBack();

				BasePage.validateListing(religion.religionName, 2, 1);
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
