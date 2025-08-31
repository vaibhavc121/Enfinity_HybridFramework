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

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            sp.clickBank();
            Thread.sleep(2000);

            BankPage bp = new BankPage(driver);

            for (CreateBankModel bank : bankData)
            {
                bp.clickNew();
                bp.provideBankName(bank.bankName);
                bp.clickSaveBack();

                BasePage.validateListing(bank.bankName, 2, 1);
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

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            log("clickHRCore");
            hc.clickSetupForm();
            log("clickSetupForm");

            SetupPage sp = new SetupPage(driver);
            for (HRCoreModel.DeleteBankModel bank : bankData)
            {
                sp.clickBank();
                log("clicked on Bank");
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, bank.bankName);
                Assert.assertFalse(BasePage.validateListing(bank.bankName, 2, 1), "Transaction not deleted: " + bank.bankName);
                log("Verified: Transaction deleted successfully");
                // ClassicAssert.isTrue(BasePage.isTxnCreated());
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}