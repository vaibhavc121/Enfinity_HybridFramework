package testCases.HRMS.SelfService;

import base.BasePage;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.SupportRequestCategoryModel;
import pageObjects.HRMS.SelfService.SupportRequestCategoryPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class SupportRequestCategoryTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSupportRequestCategory()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SupportRequestCategoryModel> supportRequestCategoryData = JsonUtils.convertJsonListDataModel(
                    selfServiceFile, "createSupportRequestCategory", SupportRequestCategoryModel.class);

            // global search
            SupportRequestCategoryPage sr = new SupportRequestCategoryPage();

            for (SupportRequestCategoryModel src : supportRequestCategoryData)
            {
                BasePage.globalSearch("support request category");
                logger.info("searched and opened support request category");

                sr.clickNew();
                logger.info("clicked on new button");

                sr.provideCategoryname(src.categoryName);
                logger.info("provided category name: " + src.categoryName);

                sr.selectRequestedTo(src.requestedTo);
                logger.info("selected requested to: " + src.requestedTo);

                sr.selectPriority(src.priority);
                logger.info("selected priority: " + src.priority);

                sr.selectWorkflow(src.workflow);
                logger.info("selected workflow: " + src.workflow);

                sr.requireAttachment(src.attachment);
                logger.info("set require attachment: " + src.attachment);

                sr.provideDesc(src.desc);
                logger.info("provided description: " + src.desc);

                sr.clickSaveBack();
                logger.info("clicked on save and navigate back");

                Assert.assertTrue(sr.isTransactionCreated(null, src.categoryName, null));
                logger.info("Support Request Category created successfully: " + src.categoryName);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("VRC- Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteSupportReqCategory()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SelfServiceModel.DeleteSupportRequestCategoryModel> supportRequestCategoryData = JsonUtils.convertJsonListDataModel(
                    selfServiceFile, "deleteSupportRequestCategory", SelfServiceModel.DeleteSupportRequestCategoryModel.class);

            // SupportRequestCategory
            SupportRequestCategoryPage sr = new SupportRequestCategoryPage();
            for (SelfServiceModel.DeleteSupportRequestCategoryModel SRC : supportRequestCategoryData)
            {
                BasePage.globalSearch("support request category");
                log("searched for support request category");

                sr.deleteTransaction(2, SRC.categoryName);
                log("deleted support request category: " + SRC.categoryName);

                Assert.assertFalse(BasePage.validateListing(SRC.categoryName, 2, 1));
                log("assertion passed: Support Request Category deleted successfully: " + SRC.categoryName);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("VRC- Test case failed: " + e);
        }
    }
}