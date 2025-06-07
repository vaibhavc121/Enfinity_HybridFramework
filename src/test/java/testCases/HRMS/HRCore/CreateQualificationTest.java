package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateQualificationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.QualificationPage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateQualificationTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createQualification()
	{
		try
		{
			String qualificationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<CreateQualificationModel> qualificationData = JsonUtils.convertJsonListDataModel(qualificationFile,
					"createQualification", CreateQualificationModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			sp.clickQualification();
			Thread.sleep(2000);

			QualificationPage qp = new QualificationPage(driver);

			for (CreateQualificationModel qualification : qualificationData)
			{
				qp.clickNew();
				qp.provideQualificationName(qualification.qualificationName);
				qp.clickSaveBack();

				BasePage.validateListing(qualification.qualificationName, 2, 1);
			}
			// ClassicAssert.isTrue(qp.isTxnCreated());

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
