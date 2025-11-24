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
    public void createSalaryRevision()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel1(payrollFile,
                    "createPromotionSalRevision", PayrollModel.PromotionModel.class);

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
                log("provided employee: " + proData.employee);

                pr.selectPromotionType(proData.promotionTypeSalRevision);
                log("selected promotion type: " + proData.promotionTypeSalRevision);

                pr.providePromotionPeriod(proData.promotionPeriod);
                log("provided effective date: " + proData.promotionPeriod);

                BasePage.clickOnSave();
                log("clicked on save button popup");

                pr.clickAssignNewSalaryComponent();
                log("clicked on assign new salary component");

                pr.provideSalComponent(proData.salComp);
                log("provided salary component: " + proData.salComp);

                pr.provideAmt(proData.incrementAmt);
                log("provided increment amount: " + proData.incrementAmt);

                pr.provideEffectiveFromDt(proData.salCompEffectiveFromDate);
                log("provided effective from date: " + proData.salCompEffectiveFromDate);

                pr.clickSave();
                log("clicked on save button");
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

                Assert.assertTrue(BasePage.validateListing(proData.employee, 7, 7),
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
    public void deleteSalaryRevision()
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

                BasePage.performAction(7, "001", "Amend");
                Assert.assertFalse(BasePage.validateListing("001", 7, 7));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void createJobProfileRevision()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel1(payrollFile,
                    "createPromotionJobProfileRevision", PayrollModel.PromotionModel.class);

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
                log("provided employee: " + proData.employee);

                pr.selectPromotionType(proData.promotionTypeJobProfileRevision);
                log("selected promotion type: " + proData.promotionTypeJobProfileRevision);

                BasePage.clickOnSave();
                log("clicked on save button popup");

                pr.provideDept(proData.department);
                log("provided department: " + proData.department);

                pr.provideDesignation(proData.designation);
                log("provided designation: " + proData.designation);

                pr.provideWorkLocation(proData.workLocation);
                log("provided work location: " + proData.workLocation);

                pr.provideManager(proData.manager);
                log("provided manager: " + proData.manager);

                pr.provideProject(proData.Project);
                log("provided project: " + proData.Project);

                pr.savePopup();
                log("popup saved");

                pr.clickViewApproveBack();
                log("clicked on view approve and navigate back");

                Assert.assertTrue(BasePage.validateListing(proData.employee, 7, 7),
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

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void deleteJobProfileRevision()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel1(payrollFile,
                    "createPromotionJobProfileRevision", PayrollModel.PromotionModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // promotion pg
            PromotionPage lp = new PromotionPage();

            for (PayrollModel.PromotionModel promotion : promotionData)
            {
                lp.clickPromotion();
                log("clicked on promotion");

                BasePage.performAction(7, "001", "Amend");
                Assert.assertFalse(BasePage.validateListing("001", 7, 7));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}