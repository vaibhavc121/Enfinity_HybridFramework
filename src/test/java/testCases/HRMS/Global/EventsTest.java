package testCases.HRMS.Global;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import utilities.BrowserUtils;

public class EventsTest extends BaseTest
{
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

    public void verifyNotificationForPenaltyTxnChanges()
    {
    }
}