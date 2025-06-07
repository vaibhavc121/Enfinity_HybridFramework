package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteGradeModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteGradeTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteGrade()
	{
		try
		{
			String gradeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<DeleteGradeModel> gradeData = JsonUtils.convertJsonListDataModel(gradeFile, "deleteGrade",
					DeleteGradeModel.class);

			HRCorePage hc = new HRCorePage(driver);
			Thread.sleep(5000);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			for (DeleteGradeModel grade : gradeData)
			{
				sp.clickGrade();
				Thread.sleep(2000);
				BasePage.deleteHrCoreTxn(2, grade.gradeName);

				Assert.assertFalse(BasePage.validateListing(grade.gradeName, 2, 1));
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
