package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateReligionModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.ReligionPage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class ReligionTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createReligion()
    {
        try
        {
            String religionFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateReligionModel> religionData = JsonUtils.convertJsonListDataModel(religionFile, "createReligion",
                    CreateReligionModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickReligion();
            Thread.sleep(2000);

            ReligionPage rp = new ReligionPage();
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

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteReligion()
    {
        try
        {
            String religionFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteReligionModel> religionData = JsonUtils.convertJsonListDataModel(religionFile, "createReligion",
                    HRCoreModel.DeleteReligionModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteReligionModel religion : religionData)
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