package testCases.HRMS.Payroll.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.Setups.SalaryComponentPage;
import utilities.DateUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class SalaryComponentTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.SalaryComponentModel> salaComponentData = JsonUtils.convertJsonListDataModel(payrollFile, "salaryComponent",
            PayrollModel.SalaryComponentModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSalaryComponent()
    {
        try
        {
            for (PayrollModel.SalaryComponentModel data : salaComponentData)
            {
                // payroll pg
                PayrollPage pp = new PayrollPage();
                pp.clkPayroll();
                log("clicked on payroll link");
                BasePage.clickSetups();
                log("clicked on setups link");

                // Salary Component pg
                SalaryComponentPage sc = new SalaryComponentPage();
                sc.clickSalaryComponent();
                log("clicked on salary component");

                sc.clickNew();
                log("clicked on new btn");

                sc.provideName(data.name);
                log("provided name: " + data.name);

                sc.selectEarningOrDeduction(data.earningOrDeduction);
                log("selected earning or deduction: " + data.earningOrDeduction);

                sc.selectComputationType(data.computationType);
                log("selected computation type: " + data.computationType);

                sc.selectCalculationMethod(data.calculationMethod);
                log("selected calculation method: " + data.calculationMethod);

                sc.selectSalaryComponentGroup(data.salaryComponentGroup);
                log("selected salary component group: " + data.salaryComponentGroup);

                BasePage.clickViewAndBack();
                log("clicked on view btn and back to salary component list");

                Assert.assertTrue(BasePage.validateListing(data.name, 2, 1), "Salary Component creation failed: " + data.name);
                log("Verified: Salary Component created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteSalaryComponent()
    {
        try
        {
            for (PayrollModel.SalaryComponentModel data : salaComponentData)
            {
                // payroll pg
                PayrollPage pp = new PayrollPage();
                pp.clkPayroll();
                log("clicked on payroll link");
                BasePage.clickSetups();
                log("clicked on setups link");

                // Salary Component pg
                SalaryComponentPage sc = new SalaryComponentPage();
                sc.clickSalaryComponent();
                log("clicked on salary component");

                BasePage.performAction(2, data.name, "Delete");
                Assert.assertFalse(BasePage.validateListing(data.name, 2, 1), "Salary component deletion failed: " + data.name);
                log("Verified: salary component deleted successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}