package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteQualificationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteQualificationTest extends BaseTest
{
	public void deleteQualification()
	{
		try
		{
			String qualificationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<DeleteQualificationModel> qualificationData = JsonUtils.convertJsonListDataModel(qualificationFile,
					"deleteQualification", DeleteQualificationModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			for (DeleteQualificationModel qualification : qualificationData)
			{
				sp.clickQualification();
				Thread.sleep(2000);
				BasePage.deleteHrCoreTxn(2, qualification.qualificationName);

				Assert.assertFalse(BasePage.validateListing(qualification.qualificationName, 2, 1));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
