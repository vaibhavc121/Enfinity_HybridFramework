package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateDocumentTypeModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.DocumentTypePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DocumentTypeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createDocumentType()
    {
        try
        {
            String documentTypeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateDocumentTypeModel> documentTypeData = JsonUtils.convertJsonListDataModel(documentTypeFile,
                    "createDocumentType", CreateDocumentTypeModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickDocumentType();
            Thread.sleep(2000);

            DocumentTypePage dt = new DocumentTypePage();

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

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteDocumentType()
    {
        try
        {
            String documentTypeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteDocumentTypeModel> documentTypeData = JsonUtils.convertJsonListDataModel(documentTypeFile,
                    "createDocumentType", HRCoreModel.DeleteDocumentTypeModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteDocumentTypeModel doc : documentTypeData)
            {
                sp.clickDocumentType();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, doc.documentTypeName);

                Assert.assertFalse(BasePage.validateListing(doc.documentTypeName, 2, 1));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}