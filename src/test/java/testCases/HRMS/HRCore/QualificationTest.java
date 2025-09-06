package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateQualificationModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.QualificationPage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class QualificationTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createQualification()
    {
        try
        {
            String qualificationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateQualificationModel> qualificationData = JsonUtils.convertJsonListDataModel(qualificationFile,
                    "createQualification", CreateQualificationModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickQualification();
            Thread.sleep(2000);

            QualificationPage qp = new QualificationPage();

            for (CreateQualificationModel qualification : qualificationData)
            {
                qp.clickNew();
                qp.provideQualificationName(qualification.qualificationName);
                qp.clickSaveBack();

                BasePage.validateListing(qualification.qualificationName, 2, 1);
            }
            // ClassicAssert.isTrue(qp.isTxnCreated());

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteQualification()
    {
        try
        {
            String qualificationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteQualificationModel> qualificationData = JsonUtils.convertJsonListDataModel(qualificationFile,
                    "deleteQualification", HRCoreModel.DeleteQualificationModel.class);

            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            for (HRCoreModel.DeleteQualificationModel qualification : qualificationData)
            {
                sp.clickQualification();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(2, qualification.qualificationName);

                Assert.assertFalse(BasePage.validateListing(qualification.qualificationName, 2, 1));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}