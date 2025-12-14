package testCases.HRMS.Payroll.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.Setups.ProjectPage;
import pageObjects.HRMS.Payroll.Setups.TicketAccrualPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class ProjectTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.ProjectModel> projectData = JsonUtils.convertJsonListDataModel(payrollFile, "project",
            PayrollModel.ProjectModel.class);
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createProject()
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //project pg
            ProjectPage proj = new ProjectPage();
            proj.clickProject();
            log("clicked on project link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            for (PayrollModel.ProjectModel data : projectData)
            {
                proj.enterName(data.name);
                log("entered name: " + data.name);

                proj.selectProjectGroup(data.projectGroup);
                log("selected project group: " + data.projectGroup);

                proj.selectProjectManagerEmployee(data.projectManagerEmployee);
                log("selected project manager employee: " + data.projectManagerEmployee);

                BasePage.clickViewAndBack();
                log("clicked on view and back btn");

                Assert.assertTrue(BasePage.validateListing(data.name, 3, 2), "Project creation failed: " + data.name);
                log("Verified: Project created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteProject()
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //project pg
            ProjectPage proj = new ProjectPage();
            proj.clickProject();
            log("clicked on project link");

            for (PayrollModel.ProjectModel data : projectData)
            {
                BasePage.performAction(3, data.name, "Delete");
                BrowserUtils.navigateBack(BaseTest.getDriver());
                Assert.assertFalse(BasePage.validateListing(data.name, 3, 2), "Project deletion failed: " + data.name);
                log("Verified: Project deleted successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}