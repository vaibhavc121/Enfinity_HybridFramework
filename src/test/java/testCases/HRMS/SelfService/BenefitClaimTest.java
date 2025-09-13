package testCases.HRMS.SelfService;

import java.util.List;

import base.BasePage;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.BenefitClaimModel;
import pageObjects.HRMS.SelfService.BenefitClaimPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class BenefitClaimTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createBenefitClaim()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<BenefitClaimModel> benefitClaimData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createBenefitClaim", BenefitClaimModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("Clicked on Self Service module");
            ss.clickTransactions();
            log("Clicked on Transactions");

            // Benefit Claim page
            BenefitClaimPage bc = new BenefitClaimPage();

            for (BenefitClaimModel benefitClaim : benefitClaimData)
            {
                // bc.scrollDownWebpage();
                bc.clickBenefitClaim();
                bc.clickNew();
                bc.provideClaimDate(benefitClaim.claimDate);
                bc.provideBenefitScheme(benefitClaim.benefitScheme);
                bc.provideClaimAmt(benefitClaim.claimAmount);
                bc.providePaymentType(benefitClaim.paymentType);
                bc.provideRemarks(benefitClaim.remarks);
                bc.clickSave();

                Assert.assertTrue(bc.isTxnCreated(benefitClaim.empName, benefitClaim.claimAmount));
                // ClassicAssert.isTrue(BasePage.isTransactionCreated());
                // ClassicAssert.isTrue(true);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteBenefitClaim()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<BenefitClaimModel> benefitClaimData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createBenefitClaim", BenefitClaimModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            ss.clickTransactions();

            // Benefit Claim page
            BenefitClaimPage bc = new BenefitClaimPage();
            bc.clickBenefitClaim();

            BasePage.deleteTxn(6, "001");
            // BasePage.performAction(6, "001", "Amend");
            Assert.assertFalse(BasePage.validateListing("001", 6, 6));
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}