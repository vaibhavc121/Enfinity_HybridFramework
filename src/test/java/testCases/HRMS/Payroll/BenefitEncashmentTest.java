package testCases.HRMS.Payroll;

import java.util.List;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.BenefitSchemeEncashmentModel;
import pageObjects.HRMS.Payroll.BenefitEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class BenefitEncashmentTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createBenefitEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<BenefitSchemeEncashmentModel> benefitSchemeEncashmentData = JsonUtils.convertJsonListDataModel(
                    payrollFile, "createBenefitSchemeEncashment", BenefitSchemeEncashmentModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Benefit Encashment pg
            BenefitEncashmentPage be = new BenefitEncashmentPage();

            for (BenefitSchemeEncashmentModel benefitEncashment : benefitSchemeEncashmentData)
            {

                be.clkBenefitEncashment();
                log("clicked on benefit encashment");

                be.clkNew();
                log("clicked on new btn");

                be.provideEmp(benefitEncashment.employee);
                log("employee slctd");

                be.provideEffectiveDate(benefitEncashment.effectiveDate);
                log("slctd effective dt");

                be.provideBenefitScheme(benefitEncashment.employeeBenefitScheme);
                log("benefit sceme slctd");

                be.provideReqAmt(benefitEncashment.requestedAmount);
                log("req amt provided");

                be.provideApprovedAmt(benefitEncashment.approvedAmount);
                log("approved amt provided");

                be.selectPaymentType(benefitEncashment.paymentType);

                be.provideRemarks(benefitEncashment.remarks);

                be.clkView();
                log("clicked on view");

                be.clkApproveBack();
                log("clicked on approve and came on listing");

                Assert.assertTrue(BasePage.validateListing2Fields(benefitEncashment.employee, 6, 6,
                        benefitEncashment.approvedAmount, 9, 9));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteBenefitEncashment()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<BenefitSchemeEncashmentModel> benefitSchemeEncashmentData = JsonUtils.convertJsonListDataModel(
                    payrollFile, "createBenefitSchemeEncashment", BenefitSchemeEncashmentModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // Benefit Encashment pg
            BenefitEncashmentPage be = new BenefitEncashmentPage();

            for (BenefitSchemeEncashmentModel benefitEncashment : benefitSchemeEncashmentData)
            {

                be.clkBenefitEncashment();
                log("clicked on benefit encashment");

                BasePage.performAction(6, benefitEncashment.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(benefitEncashment.employee, 6, 6));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}