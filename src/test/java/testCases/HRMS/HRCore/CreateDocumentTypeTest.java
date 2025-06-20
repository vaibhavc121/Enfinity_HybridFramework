package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateDocumentTypeModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.DocumentTypePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateDocumentTypeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createDocumentType()
    {
        try
        {
            String documentTypeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateDocumentTypeModel> documentTypeData = JsonUtils.convertJsonListDataModel(documentTypeFile,
                    "createDocumentType", CreateDocumentTypeModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            sp.clickDocumentType();
            Thread.sleep(2000);

            DocumentTypePage dt = new DocumentTypePage(driver);

            for (CreateDocumentTypeModel document : documentTypeData)
            {
                dt.clickNew();
                dt.provideDocumentTypeName(document.documentTypeName);
                dt.clickSaveBack();

                BasePage.validateListing(document.documentTypeName, 2, 1);
            }
            // ClassicAssert.isTrue(dt.isTxnCreated());
            // ClassicAssert.isTrue(true);
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}