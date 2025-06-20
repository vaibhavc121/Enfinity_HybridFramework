package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteBankModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteBankTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteBank()
    {
        try
        {
            String bankFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<DeleteBankModel> bankData = JsonUtils.convertJsonListDataModel(bankFile, "deleteBank",
                    DeleteBankModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            for (DeleteBankModel bank : bankData)
            {
                sp.clickBank();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, bank.bankName);

                Assert.assertFalse(BasePage.validateListing(bank.bankName, 2, 1));
                // ClassicAssert.isTrue(BasePage.isTxnCreated());
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}