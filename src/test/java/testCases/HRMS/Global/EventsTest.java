package testCases.HRMS.Global;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PenaltyPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class EventsTest extends BaseTest
{
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void verifyNotificationForEmployeeMasterChanges()
    {
        try
        {
//            String itSupportFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
//            List<ITSupportModel> itSupportData = JsonUtils.convertJsonListDataModel(itSupportFile, "createITSupport", ITSupportModel.class);

            HRCorePage hc = new HRCorePage(driver);
            hc.clickEmployee();
            log("Clicked on Employee link in HR Core");

            BasePage.navigateToEmployee("001");
            log("Navigated to Employee 001");

            EmployeePage ep = new EmployeePage(driver);
            ep.provideMobileNo(faker.letterify("????"));
            log("entered mobile number");
            ep.clickSave();
            log("Clicked on Save button");

            BrowserUtils.refreshPage(driver);
            log("Page refreshed to verify notification");

            TopNavigationBar tnb = new TopNavigationBar(driver);
            tnb.clickBellIcon();
            log("Clicked on Bell Icon to view notifications");

            Assert.assertTrue(tnb.checkNotificationContent("Field Update on Employee Master"));
            log("Verified: Got notification for Employee Master changes");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void verifyNotificationForPenaltyTxnChanges()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.PenaltyModel> penaltyData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createPenalty", PayrollModel.PenaltyModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // penalty pg
            PenaltyPage pn = new PenaltyPage(driver);

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

                // Assert.assertFalse(BasePage.validateListing(penalty.employee, 6, 6));
                // log("assertion passed: Penalty in days deleted successfully");
                BasePage.performAction(6, penalty.employee, "Amend");
                if (!BasePage.validateListing(penalty.expectedDeductionAmt, 6, 6))
                {
                    log("Penalty in days deleted successfully");
                } else
                {
                    throw new RuntimeException("Penalty in days not deleted successfully");
                }

                TopNavigationBar tnb = new TopNavigationBar(driver);
                tnb.clickBellIcon();
                log("Clicked on Bell Icon to view notifications");

                Assert.assertTrue(tnb.checkNotificationContent("Action on transaction"),
                        "Notification for action on transaction not found");
                log("Verified: Got notification when took action on transaction");
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}