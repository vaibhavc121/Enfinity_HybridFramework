package testCases.HRMS.Payroll;

import base.BasePage;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PromotionPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PromotionTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createPromotion()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel1(payrollFile,
                    "createPromotion", PayrollModel.PromotionModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // promotion pg
            PromotionPage pr = new PromotionPage();

            for (PayrollModel.PromotionModel proData : promotionData)
            {
                pr.clickPromotion();
                log("clicked on promotion link");

                pr.clickNew();
                log("clicked on new button");

                pr.provideEmployee(proData.employee);
                log("provided employee");

                pr.provideEffectiveDate(proData.effectiveDate);
                log("provided effective date");

                pr.selectPromotionType(proData.promotionType);
                log("selected promotion type");

                pr.provideNewDesignation(proData.newDesignation);
                log("provided new designation");

//				pr.clickSave();
//				log("clicked on save button");
//
//				pr.scrollToElement();
//				log("scrolled to element- salaries");
//
//				pr.clickSalaries();
//				log("clicked on salaries");
//
//				pr.clickNew1();
//				log("clicked on new button in salaries");
//
//				pr.provideSalComp(proData.salComp);
//				log("provided salary component");
//
//				pr.provideIncrementAmt(proData.incrementAmt);
//				log("provided increment amount");
//
//				pr.provideEffectiveFromDate(proData.salCompEffectiveFromDate);
//				log("provided effective from date");

                pr.clickViewApproveBack();
                log("clicked on view approve and navigate back");

                Assert.assertTrue(BasePage.validateListing(proData.employee, 6, 6),
                        "Promotion for employee: " + proData.employee + " is not created successfully");

//				Assert.assertEquals(pr.getSalary(proData.employee), proData.expectedSal,
//						"Salary after promotion is not as expected for employee: " + proData.employee);

            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deletePromotion()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel(payrollFile, "createPromotion",
                    PayrollModel.PromotionModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // promotion pg
            PromotionPage lp = new PromotionPage();

            for (PayrollModel.PromotionModel loan : promotionData)
            {
                lp.clickPromotion();
                log("clicked on promotion");

                BasePage.performAction(6, "001", "Amend");
                Assert.assertFalse(BasePage.validateListing("001", 6, 6));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}