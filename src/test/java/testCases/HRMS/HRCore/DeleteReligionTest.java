package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteReligionModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteReligionTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteReligion()
	{
		try
		{
			String religionFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<DeleteReligionModel> religionData = JsonUtils.convertJsonListDataModel(religionFile, "createReligion",
					DeleteReligionModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			for (DeleteReligionModel religion : religionData)
			{
				sp.clickReligion();
				Thread.sleep(2000);
				BasePage.deleteHrCoreTxn(2, religion.religionName);

				Assert.assertFalse(BasePage.validateListing(religion.religionName, 2, 1));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
