package testCases.HRMS.SelfService;

import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.PromotionRequestModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PromotionPage;
import pageObjects.HRMS.SelfService.PromotionRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class PromotionRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSalaryRevisionRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createPromotionRequestSalRevision", PromotionRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("Clicked on Self Service module");
            BasePage.openSidebar();
            ss.clickTeam();
            log("Clicked on Team");
            ss.openPromotionRequest("Rohit Chavan");

            PromotionPage pr = new PromotionPage();

            for (PromotionRequestModel proData : promotionRequestData)
            {
                pr.selectPromotionType(proData.promotionTypeSalRevision);
                log("selected promotion type: " + proData.promotionTypeSalRevision);

                pr.providePromotionPeriod(proData.promotionPeriod);
                log("provided Promotion Period: " + proData.promotionPeriod);

                BasePage.clickOnSave();
                log("clicked on save button popup");

                pr.clickReviseBtn();
                log("clicked on revise button");

                pr.provideIncrementAmt(proData.incrementAmt);
                log("provided increment amount: " + proData.incrementAmt);

                pr.provideRemarks(proData.remarks);
                log("provided remarks: " + proData.remarks);

                pr.savePopup();
                log("popup saved");

                BasePage.waitTS(2);

                // pr.scrollPage();
                // log("scrolled the page to verify revised amount");

                Assert.assertTrue(pr.isCorrectRviseAmtDisplay(proData.incrementAmt), "Revise amount is not correct.");

                pr.clickSaveAndSubmitPromotionReq();
                log("clicked save and submit button");

                Assert.assertTrue(BasePage.validateListing(proData.employee, 4, 4),
                        "Promotion for employee: " + proData.employee + " is not created successfully");
                log("Verified: Promotion for employee: " + proData.employee + " is created successfully");
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteSalaryRevisionRequest()
    {
        String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
        List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                "createPromotionRequestSalRevision", PromotionRequestModel.class);

        // self service page
        SelfServicePage ss = new SelfServicePage();
        ss.clickSelfService();
        ss.clickTransactions();

        // Promotion Request page
        PromotionRequestPage pr = new PromotionRequestPage();
        // pr.scrollDownWebpage();
        pr.clickPromotionRequest();

        BasePage.performAction(4, "002", "Amend");
        Assert.assertFalse(BasePage.validateListing("002", 4, 4));
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void createJobProfileRevisionRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createPromotionReqJobProfileRevision", PromotionRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("Clicked on Self Service module");
            BasePage.openSidebar();
            ss.clickTeam();
            log("Clicked on Team");
            ss.openPromotionRequest("Rohit Chavan");

            // promotion pg
            PromotionPage pr = new PromotionPage();

            for (PromotionRequestModel proData : promotionRequestData)
            {
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

                // pr.provideManager(proData.manager);
                // log("provided manager: " + proData.manager);

                pr.provideProject(proData.Project);
                log("provided project: " + proData.Project);

                pr.savePopup();
                log("popup saved");

                pr.clickSaveAndSubmitPromotionReq();
                log("clicked on save&submit and navigate back");

                Assert.assertTrue(BasePage.validateListing2Fields(proData.employee, 4, 4, "Job Profile Revision", 8, 8),
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
    public void deleteJobProfileRevisionRequest()
    {
        try
        {
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<PromotionRequestModel> promotionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createPromotionReqJobProfileRevision", PromotionRequestModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage();
            ss.clickSelfService();
            log("Clicked on Self Service module");
            ss.clickTransactions();
            log("Clicked on Transactions");

            // Promotion Request page
            PromotionRequestPage pr = new PromotionRequestPage();
            pr.clickPromotionRequest();
            log("Clicked on Promotion Request");

            // promotion pg
            PromotionPage lp = new PromotionPage();

            for (PromotionRequestModel proData : promotionRequestData)
            {
                lp.clickPromotion();
                log("clicked on promotion");

                BasePage.performAction(4, proData.employee, "Amend");
                Assert.assertFalse(BasePage.validateListing(proData.employee, 4, 4));
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}