package testCases.HRMS.SelfService.Setups;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.Setups.AnnouncementPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class AnnouncementTest extends BaseTest
{
    String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
    List<SelfServiceModel.AnnouncementModel> announcementData = JsonUtils.convertJsonListDataModel(selfServiceFile,
            "announcement", SelfServiceModel.AnnouncementModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createAnnouncement()
    {
        try
        {
            //Self service pg
            SelfServicePage ssp = new SelfServicePage();
            ssp.clickSelfService();
            log("clicked on self service link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Announcement pg
            AnnouncementPage ap = new AnnouncementPage();
            ap.clickAnnouncement();
            log("clicked on announcement link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            for (SelfServiceModel.AnnouncementModel data : announcementData)
            {
                ap.provideTitle(data.title);
                log("entered title: " + data.title);

                // ap.provideExpiryDate(data.expiryDate);
                // log("entered expiry date: " + data.expiryDate);

                ap.provideBody(data.body);
                log("entered body: " + data.body);

                ap.provideDepartment(data.department);
                log("entered department: " + data.department);

                // ap.provideWorkLocation(data.workLocation);
                // log("entered work location: " + data.workLocation);

                ap.provideEmployee(data.employee);
                log("entered employee: " + data.employee);

                BasePage.clickOnSave();
                log("clicked on save btn");

                ap.clickPublish();
                log("clicked on publish btn");

                BasePage.waitTS(2);
                BasePage.pressEnter();
                log("pressed enter key");

                BrowserUtils.navigateBack(BaseTest.getDriver());
                log("navigated back to announcement listing page");

                Assert.assertTrue(BasePage.validateListing(data.title, 2, 1), "Announcement creation failed: " + data.title);
                log("Verified: Announcement created successfully: " + data.title);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteAnnouncement()
    {
        try
        {
            //Self service pg
            SelfServicePage ssp = new SelfServicePage();
            ssp.clickSelfService();
            log("clicked on self service link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //Announcement pg
            AnnouncementPage ap = new AnnouncementPage();
            ap.clickAnnouncement();
            log("clicked on announcement link");
            for (SelfServiceModel.AnnouncementModel data : announcementData)
            {
                BasePage.filterAndOpenTransaction(2, 1, data.title, "Edit");
                log("filtered and opened announcement: " + data.title);
                ap.clickContextMenu();
                log("clicked on context menu");
                ap.clickDelete();
                log("clicked on delete btn");
                BasePage.waitTS(2);
                BasePage.pressEnter();
                log("pressed enter key");
                Assert.assertFalse(BasePage.validateListing(data.title, 2, 1), "Announcement deletion failed: " + data.title);
                log("Verified: Announcement deleted successfully: " + data.title);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}