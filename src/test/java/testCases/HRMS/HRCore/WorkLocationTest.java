package testCases.HRMS.HRCore;

import factory.LoggerFactory;
import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateWorkLocationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.HRCore.WorkLocationPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class WorkLocationTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createWorkLocation()
    {
        try
        {
            String workLocationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateWorkLocationModel> workLocationData = JsonUtils.convertJsonListDataModel(workLocationFile,
                    "createWorkLocation", CreateWorkLocationModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickWorkLocation();
            Thread.sleep(2000);

            WorkLocationPage wl = new WorkLocationPage();
            for (CreateWorkLocationModel workLocation : workLocationData)
            {
                wl.clickNew();
                wl.provideWorkLocName(workLocation.workLocationName);
                wl.clickSaveBack();

                BasePage.validateListing(workLocation.workLocationName, 2, 1);
            }
            // ClassicAssert.isTrue(wl.isTxnCreated());

        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteWorkLocation()
    {
        try
        {
            String workLocationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteWorkLocationModel> workLocationData = JsonUtils.convertJsonListDataModel(workLocationFile,
                    "createWorkLocation", HRCoreModel.DeleteWorkLocationModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteWorkLocationModel wl : workLocationData)
            {
                sp.clickWorkLocation();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, wl.workLocationName);

                Assert.assertFalse(BasePage.validateListing(wl.workLocationName, 2, 1));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}