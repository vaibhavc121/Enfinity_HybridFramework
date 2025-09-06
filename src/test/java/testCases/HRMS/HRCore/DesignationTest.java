package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateDesignationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.DesignationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DesignationTest extends BaseTest
{

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createDesignation()
    {
        try
        {
            String designationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateDesignationModel> designationData = JsonUtils.convertJsonListDataModel(designationFile,
                    "createDesignation", CreateDesignationModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickDesignation();
            Thread.sleep(2000);

            DesignationPage dp = new DesignationPage();

            for (CreateDesignationModel desg : designationData)
            {
                dp.clickNewButton();
                // dp.setDesignationCode();
                // dp.setDesignation(faker.Name.JobTitle());
                dp.setDesignation(desg.designationName);
                dp.clickGrade();
                dp.selectGrade();
                dp.setJobDescription();
                dp.clickSaveBack();

                BasePage.validateListing(desg.designationName, 3, 2);
                // ClassicAssert.isTrue(BasePage.isTxnCreated());
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteDesignation()
    {
        try
        {
            String designationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteDesignationModel> designationData = JsonUtils.convertJsonListDataModel(designationFile,
                    "deleteDesignation", HRCoreModel.DeleteDesignationModel.class);

            HRCorePage hc = new HRCorePage();
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteDesignationModel desg : designationData)
            {
                sp.clickDesignation();
                Thread.sleep(2000);
                BasePage.deleteTxn(3, desg.designationName);

                Assert.assertFalse(BasePage.validateListing(desg.designationName, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}