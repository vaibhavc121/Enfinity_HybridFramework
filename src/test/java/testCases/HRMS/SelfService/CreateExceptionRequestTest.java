package testCases.HRMS.SelfService;

import base.BasePage;
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

public class CreateExceptionRequestTest extends BaseTest
{

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createExceptionRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<ExceptionRequestModel> exceptionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createExceptionRequest", ExceptionRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            BasePage.clickMenuIcon();
            ss.clickSelfService();
            log("clickSelfService");

            ss.clickTransactions();
            log("clickTransactions");

            // ExceptionRequest page
            ExceptionRequestPage er = new ExceptionRequestPage(driver);

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
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}