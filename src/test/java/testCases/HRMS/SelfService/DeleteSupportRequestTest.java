package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ITSupportModel;
import pageObjects.HRMS.SelfService.ITSupportRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteSupportRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteITSupportRequest()
    {
        try
        {
            String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport",
                    ITSupportModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            log("clickSelfService");
            ss.clickTransactions();
            log("clickTransactions");

            // ITSupport page
            ITSupportRequestPage it = new ITSupportRequestPage(driver);
            it.clickITSupport();
            log("clickITSupport");

            BasePage.deleteTxn(5, "001");
            Assert.assertFalse(BasePage.validateListing("001", 5, 5));
//            Assert.assertTrue(false);
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}