package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.LoanPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PromotionPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeletePromotionTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deletePromotion()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel(payrollFile, "createPromotion",
                    PayrollModel.PromotionModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            logger.info("clicked on payroll link");
            pp.clkTxn();
            logger.info("clicked on txn");

            // promotion pg
            PromotionPage lp = new PromotionPage(driver);

            for (PayrollModel.PromotionModel loan : promotionData)
            {
                lp.clickPromotion();
                logger.info("clicked on promotion");


                BasePage.performAction(6, "001", "Amend");
                Assert.assertFalse(BasePage.validateListing("001", 6, 6));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}