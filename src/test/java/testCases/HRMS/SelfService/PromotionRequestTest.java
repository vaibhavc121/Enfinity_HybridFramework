package testCases.HRMS.SelfService;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.PromotionRequestModel;
import pageObjects.HRMS.Payroll.PromotionPage;
import pageObjects.HRMS.SelfService.PromotionRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PromotionRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createPromotionRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createPromotionRequest", PromotionRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            BasePage.openSidebar();
            ss.clickTeam();
            ss.openPromotionRequest("Rohit Chavan");

            PromotionPage pr = new PromotionPage();

            for (PromotionRequestModel proData : promotionRequestData)
            {
                pr.selectPromotionType(proData.promotionTypeSalRevision);
                log("selected promotion type: " + proData.promotionTypeSalRevision);

                pr.providePromotionPeriod(proData.promotionPeriod);
                log("provided Promotion Period: " + proData.promotionPeriod);

                BasePage.clickOnSave();
                log("clicked on save button popup");

                pr.clickReviseBtn();
                log("clicked on revise button");

                pr.provideIncrementAmt(proData.incrementAmt);
                log("provided increment amount: " + proData.incrementAmt);

                pr.provideRemarks(proData.remarks);
                log("provided remarks: " + proData.remarks);

                pr.savePopup();
                log("popup saved");

                Assert.assertTrue(pr.isCorrectRviseAmtDisplay(proData.incrementAmt), "Revise amount is not correct.");

                pr.clickSaveAndSubmit();
                log("clicked save and submit button");

                Assert.assertTrue(BasePage.validateListing(proData.employee, 7, 7),
                        "Promotion for employee: " + proData.employee + " is not created successfully");
                log("Verified: Promotion for employee: " + proData.employee + " is created successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deletePromotionRequest()
    {
        String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
        List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                "createPromotionRequest", PromotionRequestModel.class);

        // self service page
        SelfServicePage ss = new SelfServicePage();
        ss.clickSelfService();
        ss.clickTransactions();

        // Promotion Request page
        PromotionRequestPage pr = new PromotionRequestPage();
        // pr.scrollDownWebpage();
        pr.clickPromotionRequest();

        BasePage.deleteTxn(6, "001");
        Assert.assertFalse(BasePage.validateListing("001", 6, 6));
    }
}