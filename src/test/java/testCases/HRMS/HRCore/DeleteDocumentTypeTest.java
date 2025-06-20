package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteDocumentTypeModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteDocumentTypeTest extends BaseTest
{
    public void deleteDocumentType()
    {
        try
        {
            String documentTypeFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<DeleteDocumentTypeModel> documentTypeData = JsonUtils.convertJsonListDataModel(documentTypeFile,
                    "createDocumentType", DeleteDocumentTypeModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            for (DeleteDocumentTypeModel doc : documentTypeData)
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