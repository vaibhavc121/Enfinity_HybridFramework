package testCases.HRMS.HRCore;

import factory.LoggerFactory;
import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateGradeModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.GradePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class GradeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createGrade()
    {
        try
        {
            String gradeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateGradeModel> gradeData = JsonUtils.convertJsonListDataModel(gradeFile, "createGrade",
                    CreateGradeModel.class);

            HRCorePage hc = new HRCorePage();
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickGrade();
            Thread.sleep(2000);

            GradePage gp = new GradePage();

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
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteGrade()
    {
        try
        {
            String gradeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteGradeModel> gradeData = JsonUtils.convertJsonListDataModel(gradeFile, "deleteGrade",
                    HRCoreModel.DeleteGradeModel.class);

            HRCorePage hc = new HRCorePage();
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteGradeModel grade : gradeData)
            {
                sp.clickGrade();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, grade.gradeName);

                Assert.assertFalse(BasePage.validateListing(grade.gradeName, 2, 1));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}