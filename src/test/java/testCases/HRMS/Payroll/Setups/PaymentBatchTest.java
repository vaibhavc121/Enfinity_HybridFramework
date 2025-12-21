package testCases.HRMS.Payroll.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.Setups.PaymentBatchPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PaymentBatchTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.PaymentBatchModel> paymentBatchData = JsonUtils.convertJsonListDataModel(payrollFile, "paymentBatch",
            PayrollModel.PaymentBatchModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createPaymentBatch()
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //payement batch pg
            PaymentBatchPage pb = new PaymentBatchPage();
            pb.clickPaymentBatch();
            log("clicked on payment batch link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            for (PayrollModel.PaymentBatchModel data : paymentBatchData)
            {
                pb.provideName(data.name);
                log("entered name: " + data.name);

                pb.selectPaymentBatchType(data.paymentBatchType);
                log("selected payment batch type: " + data.paymentBatchType);

                BasePage.clickViewAndBack();
                log("clicked on view and back btn");

                Assert.assertTrue(BasePage.validateListing(data.name, 3, 2), "Payment Batch creation failed: " + data.name);
                log("Verified: Payment Batch created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void deletePaymentBatch()
    {
        try
        {

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //payement batch pg
            PaymentBatchPage pb = new PaymentBatchPage();
            pb.clickPaymentBatch();
            log("clicked on payment batch link");

            for (PayrollModel.PaymentBatchModel data : paymentBatchData)
            {
                BasePage.performAction(2, data.name, "Delete");
                BrowserUtils.navigateBack(BaseTest.getDriver());
                Assert.assertFalse(BasePage.validateListing(data.name, 2, 1), "Payment Batch deletion failed: " + data.name);
                log("Verified: Payment Batch deleted successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}