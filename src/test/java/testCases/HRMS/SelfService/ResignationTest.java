package testCases.HRMS.SelfService;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ResignationModel;
import pageObjects.HRMS.SelfService.ResignationPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class ResignationTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createResignation()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<ResignationModel> resignationData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createResignation", ResignationModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            ss.clickTransactions();

            // Resignation page
            ResignationPage rp = new ResignationPage(driver);

            for (ResignationModel resignation : resignationData)
            {
                // rp.scrollDownWebpage();
                rp.clickResignation();
                rp.clickNew();
                rp.provideSubmittedDate(resignation.submittedDate);
                rp.provideRemarks(resignation.remarks);
                rp.clickOnSaveAndBack();

                Assert.assertTrue(rp.isTransactionCreated1());
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteResignation()
    {
        // self service page
        SelfServicePage ss = new SelfServicePage(driver);
        ss.clickSelfService();
        ss.clickTransactions();

        // Resignation page
        ResignationPage rp = new ResignationPage(driver);
        rp.clickResignation();

        BasePage.deleteTxn(6, "active");
        Assert.assertFalse(BasePage.validateListing("active", 6, 6));
    }
}