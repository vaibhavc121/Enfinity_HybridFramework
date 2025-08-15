package testCases.HRMS.Global;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Login.LoginPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PenaltyPage;
import testCases.HRMS.Payroll.PenaltyTest;
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
            hc.clickHRCore();
            hc.clickEmployee();
            log("Clicked on Employee link in HR Core");

            BasePage.navigateToEmployee("001");
            log("Navigated to Employee 001");

            EmployeePage ep = new EmployeePage(driver);
            BasePage.switchTab();
            log("Switched to Employee tab");
            ep.provideMobileNo(faker.letterify("????"));
            log("entered mobile number");
            ep.clickJsSave();
            log("Clicked on Save button");

            BrowserUtils.refreshPage(driver);
            log("Page refreshed to verify notification");
            BrowserUtils.navigateBack(driver);
            log("Navigated back to Employee page");

            TopNavigationBar tnb = new TopNavigationBar(driver);
            tnb.clickBellIcon();
            log("Clicked on Bell Icon to view notifications");
            tnb.clickNotifications();
            log("Clicked on Notifications");

            Assert.assertTrue(tnb.checkNotificationContent("Field Update on Employee Master"),
                    "Notification for Employee Master changes not found");
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
            PenaltyTest pt = new PenaltyTest();
            pt.createPenaltyInDays();
            pt.deletePenaltyInDays();

            TopNavigationBar tnb = new TopNavigationBar(driver);
            tnb.clickBellIcon();
            log("Clicked on Bell Icon to view notifications");
            tnb.clickNotifications();
            log("Clicked on Notifications");

            Assert.assertTrue(tnb.checkNotificationContent("Action on transaction"),
                    "Notification for action on transaction not found");
            log("Verified: Got notification when took action on transaction");
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}