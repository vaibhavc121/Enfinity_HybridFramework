package testCases.HRMS.SelfService;

import base.BasePage;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ITSupportModel;
import pageObjects.HRMS.SelfService.ITSupportRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class SupportRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSupportRequest()
    {
        try
        {
            String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport",
                    ITSupportModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            ss.clickTransactions();

            // ITSupport page
            ITSupportRequestPage it = new ITSupportRequestPage();

            for (ITSupportModel itSupport : itSupportData)
            {
                it.clickITSupport();
                it.clickNew();
                it.clickPlusBtn();
                it.provideSubject(itSupport.subject);
                it.selectPriority(itSupport.priority);
                it.provideDesc(itSupport.description);
                it.clickSaveBack();
                // it.clickContextMenu();
                // it.clickView();
                // it.clickOnApproveBack();

                Assert.assertTrue(it.isTxnCreated(itSupport.employee, itSupport.recordDesc));
//				Assert.assertTrue(false);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteITSupportRequest()
    {
        try
        {
            String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport",
                    ITSupportModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("clickSelfService");
            ss.clickTransactions();
            log("clickTransactions");

            // ITSupport page
            ITSupportRequestPage it = new ITSupportRequestPage();
            it.clickITSupport();
            log("clickITSupport");

            BasePage.deleteTxn(5, "001");
            Assert.assertFalse(BasePage.validateListing("001", 5, 5));
//            Assert.assertTrue(false);
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}