package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateDesignationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.DesignationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateDesignationTest extends BaseTest
{

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createDesignation()
    {
        try
        {
            String designationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateDesignationModel> designationData = JsonUtils.convertJsonListDataModel(designationFile,
                    "createDesignation", CreateDesignationModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            sp.clickDesignation();
            Thread.sleep(2000);

            DesignationPage dp = new DesignationPage(driver);

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
}