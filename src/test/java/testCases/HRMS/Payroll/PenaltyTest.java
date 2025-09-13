package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Global.NotificationPage;
import pageObjects.HRMS.Login.LoginPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PenaltyPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PenaltyTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createPenaltyInDays()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PenaltyModel> penaltyData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createPenalty", PayrollModel.PenaltyModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            LoginPage.clickMenuIcon();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // penalty pg
            PenaltyPage pn = new PenaltyPage();

            for (PayrollModel.PenaltyModel penalty : penaltyData)
            {
                pn.clickOnPenalty();
                log("clicked on penalty link");

                pn.clickNew();
                log("clicked on new button");

                pn.provideEmployee(penalty.employee);
                log("provided employee");

                pn.providePenaltyDate(penalty.penaltyDate);
                log("provided penalty date");

                pn.providePenaltyType(penalty.penaltyType);
                log("provided penalty type");

                pn.providePenaltyInDays(penalty.penaltyInDays);
                log("provided penalty in days");

                pn.clickSaveViewApproveBack();
                log("clicked on view approve back button");

                Assert.assertTrue(BasePage.validateListing(penalty.expectedDeductionAmt, 6, 6));
                //Assert.assertTrue(BasePage.validateListing(penalty.employee, 7, 7));
                log("assertion passed: Penalty in days created successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deletePenaltyInDays()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PenaltyModel> penaltyData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createPenalty", PayrollModel.PenaltyModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            LoginPage.clickMenuIcon();
            log("clicked on menu icon");
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // penalty pg
            PenaltyPage pn = new PenaltyPage();

            for (PayrollModel.PenaltyModel penalty : penaltyData)
            {
                pn.clickOnPenalty();
                log("clicked on penalty link");

                BasePage.performAction(7, penalty.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(penalty.employee, 7, 7),
                        "Penalty in days not deleted successfully");
                log("assertion passed: Penalty in days deleted successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void createPenaltyInAmt()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PenaltyModel> penaltyData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createPenalty", PayrollModel.PenaltyModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // penalty pg
            PenaltyPage pn = new PenaltyPage();

            for (PayrollModel.PenaltyModel penalty : penaltyData)
            {
                pn.clickOnPenalty();
                log("clicked on penalty link");

                pn.clickNew();
                log("clicked on new button");

                pn.provideEmployee(penalty.employee);
                log("provided employee");

                pn.providePenaltyDate(penalty.penaltyDate);
                log("provided penalty date");

                pn.providePenaltyType(penalty.penaltyType);
                log("provided penalty type");

                pn.providePenaltyInAmount(penalty.penaltyInAmt);
                log("provided penalty in days");

                pn.clickSaveViewApproveBack();
                log("clicked on view approve back button");

                Assert.assertTrue(BasePage.validateListing(penalty.expectedDeductionAmt, 6, 6));
                log("assertion passed: Penalty in amt created successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void deletePenaltyInAmt()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PenaltyModel> penaltyData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createPenalty", PayrollModel.PenaltyModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // penalty pg
            PenaltyPage pn = new PenaltyPage();

            for (PayrollModel.PenaltyModel penalty : penaltyData)
            {
                pn.clickOnPenalty();
                log("clicked on penalty link");

                BasePage.performAction(7, penalty.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(penalty.employee, 7, 7));
                log("assertion passed: Penalty in Amt deleted successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}