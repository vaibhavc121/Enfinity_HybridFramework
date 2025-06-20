package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteDesignationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteDesignationTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteDesignation()
    {
        try
        {
            String designationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<DeleteDesignationModel> designationData = JsonUtils.convertJsonListDataModel(designationFile,
                    "deleteDesignation", DeleteDesignationModel.class);

            HRCorePage hc = new HRCorePage(driver);
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            for (DeleteDesignationModel desg : designationData)
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