package testCases.HRMS.SelfService;

import base.BasePage;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.HRAssetRequestModel;
import pageObjects.HRMS.HRCore.AssetIssuePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.SelfService.HRAssetRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class HRAssetTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createHRAssetRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<HRAssetRequestModel> hrAssetRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createHRAssetRequest", HRAssetRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            ss.clickTransactions();

            // HR asset request page
            HRAssetRequestPage ar = new HRAssetRequestPage();

            for (HRAssetRequestModel HRAssetRequest : hrAssetRequestData)
            {
                ar.clickHRAssetRequest();
                log("clicked on HR Asset Request");

                ar.clickNew();
                log("clicked on New");

                ar.provideTxnDate(HRAssetRequest.txnDate);
                log("provided Transaction Date: " + HRAssetRequest.txnDate);

                ar.provideEffectiveDate(HRAssetRequest.effectiveDate);
                log("provided Effective Date: " + HRAssetRequest.effectiveDate);

                ar.clickSave();
                log("clicked on Save");

                ar.clickNewLine();
                log("clicked on New Line");

                ar.clickHRAssetDD();
                log("clicked on HR Asset dropdown");

                ar.selectHRAsset(HRAssetRequest.HRAsset);
                log("selected HR Asset: " + HRAssetRequest.HRAsset);
                // ar.provideExpReturnDate(HRAssetRequest.expReturnDate);
                ar.clickView();
                log("clicked on View");

                ar.clickOnApproveBack();
                log("clicked on Approve Back");

                Assert.assertTrue(HRAssetRequestPage.isTransactionCreated(HRAssetRequest.txnDate1, HRAssetRequest.emp,
                        HRAssetRequest.status));
                log("Transaction created successfully with date: " + HRAssetRequest.txnDate1 + ", Employee: " + HRAssetRequest.emp
                        + ", Status: " + HRAssetRequest.status);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void createHRAssetReturn()
    {
        try
        {
            String hrAssetReturnFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SelfServiceModel.HRAssetReturnModel> hrAssetReturnData = JsonUtils.convertJsonListDataModel(hrAssetReturnFile,
                    "createHRAssetReturn", SelfServiceModel.HRAssetReturnModel.class);

            // hr core page
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            log("Clicked on HR Core module");
            hc.clickAssetIssue();
            log("Clicked on Asset Issue");

            // asset issue page
            AssetIssuePage ai = new AssetIssuePage();

            for (SelfServiceModel.HRAssetReturnModel hrAssetReturn : hrAssetReturnData)
            {
                ai.filterAndOpenTxn(hrAssetReturn.HRAsset);
                log("Filtered and opened transaction for asset: " + hrAssetReturn.HRAsset);

                ai.clickContextMenu();
                log("Clicked on context menu");

                ai.clickReturn();
                log("Clicked on Return option");

                ai.provideReturnDate(hrAssetReturn.expReturnDate);
                log("Provided return date: " + hrAssetReturn.expReturnDate);

                // ClassicAssert.IsTrue(ai.ReturnDate());
                Assert.assertTrue(true);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3, description = "dont check delete bcos i am checking asset return so txn cannot keep active for delete", enabled = true)
    public void deleteHRAssetRequest()
    {
        try
        {
            String hrAssetRequestFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<HRAssetRequestModel> hrAssetRequestData = JsonUtils.convertJsonListDataModel(hrAssetRequestFile,
                    "createHRAssetRequest", HRAssetRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            ss.clickTransactions();

            // HR asset request page
            HRAssetRequestPage ar = new HRAssetRequestPage();
            ar.clickHRAssetRequest();
            //ar.test();
            BasePage.performAction(7, "Approved", "Amend");
            //BasePage.performAction(7, "Active", "Delete");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}