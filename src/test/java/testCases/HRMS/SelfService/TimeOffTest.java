package testCases.HRMS.SelfService;

import java.util.List;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.TimeOffModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.TimeOffPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class TimeOffTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createTimeOff()
    {
        try
        {
            String timeOffFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<TimeOffModel> timeOffData = JsonUtils.convertJsonListDataModel(timeOffFile, "createTimeOff",
                    TimeOffModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            BasePage.clickMenuIcon();
            ss.clickSelfService();
            ss.clickTransactions();

            // time off page
            TimeOffPage to = new TimeOffPage(driver);

            for (TimeOffModel timeOff : timeOffData)
            {
                to.clickTimeOff();
                to.clickNew();
                to.providePermissonDate(timeOff.permisionDate);
                to.clickPersoanl();
                // to.clickBusiness();
                // to.clickLeave();
                // to.clickFromTimeField();
                // to.provideHrs(timeOff.getHrs());
                // to.provideMinutes(timeOff.getMinutes());
                // to.clickTimeNotation();
                // to.selectTimeNotation();
                // to.clickOk();
                // issue
                // to.clickUpToTimeField();
                // to.provideUpTOHrs1();
                // to.provideUpToHrs(timeOff.getUpTohrs());
                // to.provideUpToMinutes(timeOff.getUpToMinutes());
                // to.clickUpToTimeNotation();
                // to.selectUpToTimeNotation();
                // to.clickUpToOk();
                to.enterDescription("test");
                BasePage.clickOnSaveAndSubmitBack();
                log("clickOnSaveAndSubmitBack");

                Assert.assertTrue(to.isTxnCreated(timeOff.expPermisionDate));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteTimeOff()
    {
        try
        {
            String timeOffFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<TimeOffModel> timeOffData = JsonUtils.convertJsonListDataModel(timeOffFile, "createTimeOff",
                    TimeOffModel.class);

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            ss.clickTransactions();

            // time off page
            TimeOffPage to = new TimeOffPage(driver);
            to.clickTimeOff();
            // to.selectRow();
            // to.clickOnView();
            // to.clickContextMenu();
            // to.clickDelete();
            // to.clickOk();
            // BasePage.deleteTxn(8, "active");
            //BasePage.deleteTxn(8, "Active");
            BasePage.performAction(8, "Approved", "Amend");
            Assert.assertFalse(BasePage.validateListing("Approved", 8, 8));
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}