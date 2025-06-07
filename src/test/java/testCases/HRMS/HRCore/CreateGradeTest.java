package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateGradeModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.GradePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateGradeTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createGrade()
	{
		try
		{
			String gradeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
			List<CreateGradeModel> gradeData = JsonUtils.convertJsonListDataModel(gradeFile, "createGrade",
					CreateGradeModel.class);

			HRCorePage hc = new HRCorePage(driver);
			Thread.sleep(5000);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			sp.clickGrade();
			Thread.sleep(2000);

			GradePage gp = new GradePage(driver);

			for (CreateGradeModel grade : gradeData)
			{
				gp.clickNew();
				gp.provideGradeName(grade.gradeName);
				gp.provideMinSal(grade.minSal);
				gp.provideMaxSal(grade.maxSal);
				gp.clickSaveBack();

				BasePage.validateListing(grade.gradeName, 2, 1);
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
