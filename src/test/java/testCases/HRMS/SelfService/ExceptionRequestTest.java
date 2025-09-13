package testCases.HRMS.SelfService;

import base.BasePage;
import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.ExceptionRequestModel;
import pageObjects.HRMS.SelfService.ExceptionRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class ExceptionRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createExceptionRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<ExceptionRequestModel> exceptionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createExceptionRequest", ExceptionRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            BasePage.clickMenuIcon();
            ss.clickSelfService();
            log("clickSelfService");

            ss.clickTransactions();
            log("clickTransactions");

            // ExceptionRequest page
            ExceptionRequestPage er = new ExceptionRequestPage();

            for (ExceptionRequestModel exception : exceptionRequestData)
            {
                er.createExceptionRequest();
                log("createExceptionRequest");

                er.clickNew();
                log("clickNew");

                er.provideExceptionDate(exception.exceptionDate);
                log("provided Exception Date: " + exception.exceptionDate);

                er.provideLoginTime(exception.loginTime);
                log("provided Login Time: " + exception.loginTime);

                er.provideLogoutTime(exception.logotTime);
                log("provided Logout Time: " + exception.logotTime);

                er.provideRemarks(exception.remarks);
                log("provided Remarks: " + exception.remarks);

                BasePage.clickOnSaveAndSubmitBack();
                log("clickOnSaveAndSubmitBack");

                Assert.assertTrue(er.isTxnCreated(exception.exceptionDate));
                log("Verified: Transaction created successfully for date: " + exception.exceptionDate);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteExceptionRequest()
    {
        try
        {
            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("clickSelfService");

            ss.clickTransactions();
            log("clickTransactions");

            // ExceptionRequest page
            ExceptionRequestPage er = new ExceptionRequestPage();
            er.createExceptionRequest();
            log("createExceptionRequest");

            //BasePage.deleteTxn(6, "001");
            BasePage.performAction(7, "Approved", "Amend");
            Assert.assertFalse(BasePage.validateListing("001", 6, 6));
            log("assertion successful");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}