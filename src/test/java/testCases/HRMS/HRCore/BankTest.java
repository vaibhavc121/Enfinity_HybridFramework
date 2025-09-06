package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateBankModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.BankPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class BankTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createBank()
    {
        try
        {
            String bankFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateBankModel> bankData = JsonUtils.convertJsonListDataModel(bankFile, "createBank",
                    CreateBankModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            BaseTest.log("Click on HRCore module");
            hc.clickSetupForm();
            BaseTest.log("Click on Setup form");

            SetupPage sp = new SetupPage();
            sp.clickBank();
            BaseTest.log("Clicked on Bank");
            Thread.sleep(2000);

            BankPage bp = new BankPage();

            for (CreateBankModel bank : bankData)
            {
                bp.clickNew();
                BaseTest.log("Clicked on New button");
                bp.provideBankName(bank.bankName);
                BaseTest.log("Provided Bank Name: " + bank.bankName);
                bp.clickSaveBack();
                BaseTest.log("Clicked on Save and Back button");

                BasePage.validateListing(bank.bankName, 2, 1);
                BaseTest.log("Verified: Bank created successfully: " + bank.bankName);
            }
            // ClassicAssert.isTrue(bp.isTxnCreated());

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteBank()
    {
        try
        {
            String bankFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteBankModel> bankData = JsonUtils.convertJsonListDataModel(bankFile, "deleteBank",
                    HRCoreModel.DeleteBankModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            log("clickHRCore");
            hc.clickSetupForm();
            log("clickSetupForm");

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteBankModel bank : bankData)
            {
                sp.clickBank();
                log("clicked on Bank");
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, bank.bankName);
                Assert.assertFalse(BasePage.validateListing(bank.bankName, 2, 1), "Transaction not deleted: " + bank.bankName);
                log("Verified: Bank deleted successfully: " + bank.bankName);
                // ClassicAssert.isTrue(BasePage.isTxnCreated());
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}