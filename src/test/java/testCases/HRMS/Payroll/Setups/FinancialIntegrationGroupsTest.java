package testCases.HRMS.Payroll.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.Setups.FinancialIntegrationGroupsPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class FinancialIntegrationGroupsTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.FinancialIntegrationGroupsModel> fData = JsonUtils.convertJsonListDataModel(payrollFile, "financialIntegrationGroups",
            PayrollModel.FinancialIntegrationGroupsModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createFinancialIntegrationGroups()
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //financial integration groups pg
            FinancialIntegrationGroupsPage fg = new FinancialIntegrationGroupsPage();
            fg.clickfFinancialIntegrationGroup();
            log("clicked on financial integration groups link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            for (PayrollModel.FinancialIntegrationGroupsModel data : fData)
            {
                fg.provideName(data.name);
                log("entered name: " + data.name);

                fg.provideDivision(data.division);
                log("entered division: " + data.division);

                fg.provideDepartment(data.department);
                log("entered department: " + data.department);

                fg.provideProject(data.project);
                log("entered project: " + data.project);

                fg.provideWorkLocation(data.workLocation);
                log("entered work location: " + data.workLocation);

                BasePage.clickViewAndBack();
                log("clicked on view and back btn");

                Assert.assertTrue(BasePage.validateListing(data.name, 3, 2), "Financial Integration Groups creation failed: " + data.name);
                log("Verified: Financial Integration Groups created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteFinancialIntegrationGroups()
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //financial integration groups pg
            FinancialIntegrationGroupsPage fg = new FinancialIntegrationGroupsPage();
            fg.clickfFinancialIntegrationGroup();
            log("clicked on financial integration groups link");

            for (PayrollModel.FinancialIntegrationGroupsModel data : fData)
            {
                BasePage.performAction(3, data.name, "Delete");
                BrowserUtils.navigateBack(BaseTest.getDriver());

                Assert.assertFalse(BasePage.validateListing(data.name, 3, 2), "Financial Integration Groups deletion failed: " + data.name);
                log("Verified: Financial Integration Groups deleted successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}