package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.OvertimeRequestModel;
import pageObjects.HRMS.SelfService.OvertimeRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class OvertimeApplicationTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createOvertimeApplication()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<OvertimeRequestModel> overtimeRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createOvertimeRequest", OvertimeRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("clicked on SelfService");
            ss.clickTransactions();
            log("clicked on Transactions");

            // Overtime Request page
            OvertimeRequestPage or = new OvertimeRequestPage();

            for (OvertimeRequestModel overtimeRequest : overtimeRequestData)
            {
                // or.scrollDownWebpage();
                or.clickOvertimeRequest();
                log("clicked on Overtime Request");

                or.clickNew();
                log("clicked on New");

                or.provideOvertimeDate(overtimeRequest.overtimeDate);
                log("provided Overtime Date: " + overtimeRequest.overtimeDate);

                or.provideHrs(overtimeRequest.hrs);
                log("provided Hours: " + overtimeRequest.hrs);

                or.provideRemarks(overtimeRequest.remarks);
                log("provided Remarks: " + overtimeRequest.remarks);

                // additional code
                BasePage.clickSaveAndBack();
                log("clicked on Save and Back");
//                if (BasePage.isTransactionCreated())
//                {
//                    BasePage.clickSaveAndBack();
//                } else
//                {
//                    Assert.fail("Test case failed: " + or.displayErrorMsg());
//                }

                Assert.assertTrue(or.isTxnCreated(overtimeRequest.overtimeType, overtimeRequest.hrs));
                log("Verified: Transaction created successfully for Overtime Type: " + overtimeRequest.overtimeType
                        + " with Hours: " + overtimeRequest.hrs);
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteOvertimeApplication()
    {
        // self service page
        SelfServicePage ss = new SelfServicePage();
        ss.clickSelfService();
        ss.clickTransactions();

        // OvertimeRequestPage
        OvertimeRequestPage ot = new OvertimeRequestPage();
        ot.clickOvertimeRequest();

        BasePage.deleteTxn(7, "active");
        Assert.assertFalse(BasePage.validateListing("active", 7, 7));
    }
}