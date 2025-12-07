package testCases.HRMS.SelfService.LeaveTypesTest;

import annotations.Owner;
import annotations.Reset;
import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SelfService.LeaveRequestPage;
import pageObjects.HRMS.SelfService.LeaveTypesPage.ConfigureLeaveTypeSetting;
import pageObjects.HRMS.SelfService.SelfServicePage;
import testCases.HRMS.SelfService.LeaveRequestTest;
import utilities.DateUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class AnnualLeaveTest extends BaseTest
{
    String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
    List<SelfServiceModel.EntitlementModel> annualLeaveData = JsonUtils.convertJsonListDataModel(selfServiceFile, "annualLeave.entitlement", SelfServiceModel.EntitlementModel.class);
    ConfigureLeaveTypeSetting stg = new ConfigureLeaveTypeSetting();

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void verifyEligibilityDaysAfterJoining()
    {
        try
        {
            for (SelfServiceModel.EntitlementModel data : annualLeaveData)
            {
                BasePage.logoutAndLogin("vikas@test.com", "123");
                if (data.eligibilityDaysAfterJoining.days == 0)
                {
                    try
                    {
                        stg.configureLeaveType(data.eligibilityDaysAfterJoining.leaveType, "EligibilityDaysAfterJoining0", data.eligibilityDaysAfterJoining.days);

                        // self service page
                        SelfServicePage ss = new SelfServicePage();
                        ss.clickSelfService();
                        ss.clickTransactions();

                        // leave request page
                        LeaveRequestPage lr = new LeaveRequestPage();

                        lr.clickLeaveRequest();
                        Thread.sleep(5000);
                        lr.clickNew();
                        lr.hoverAndClick(data.eligibilityDaysAfterJoining.leaveType); //Annual leave
                        lr.provideFromDate(data.eligibilityDaysAfterJoining.fromDate);
                        lr.provideToDate(data.eligibilityDaysAfterJoining.toDate);
                        // lr.clickOnSaveSubmit();
                        lr.clickSave();

                        Assert.assertTrue(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2, "Active", 7, 7), "Leave request is not created: " + data.eligibilityDaysAfterJoining.leaveType);
                        log("Veified: Leave request is created successfully: " + data.eligibilityDaysAfterJoining.leaveType);

                        LeaveRequestTest lrp = new LeaveRequestTest();
                        lrp.deleteLeaveRequest();
                    } catch (Exception e)
                    {
                        LoggerFactory.getLogger().error("Test failed due to exception: ", e);
                        Assert.fail("Test case failed: " + e);
                    }
                } else if (data.eligibilityDaysAfterJoining.days >= 30)
                {
                    try
                    {
                        stg.configureLeaveType(data.eligibilityDaysAfterJoining.leaveType, "EligibilityDaysAfterJoining30", data.eligibilityDaysAfterJoining.days);

                        // self service page
                        SelfServicePage ss = new SelfServicePage();
                        ss.clickSelfService();
                        ss.clickTransactions();

                        // leave request page
                        LeaveRequestPage lr = new LeaveRequestPage();

                        lr.clickLeaveRequest();
                        Thread.sleep(5000);
                        lr.clickNew();
                        lr.hoverAndClick(data.eligibilityDaysAfterJoining.leaveType); //sick leave
                        lr.provideFromDate(data.eligibilityDaysAfterJoining.fromDate);
                        lr.provideToDate(data.eligibilityDaysAfterJoining.toDate);
                        // lr.clickOnSaveSubmit();
                        lr.clickSave();
                        BasePage.waitTS(3);

                        Assert.assertFalse(BasePage.validateListing2Fields(DateUtils.getCurrentDate("dd-MMM-yyyy"), 2, 2, "Active", 7, 7));
                        log("Veified: Leave request is not created as expected: " + data.eligibilityDaysAfterJoining.leaveType);
                    } catch (Exception e)
                    {
                        LoggerFactory.getLogger().error("Test failed due to exception: ", e);
                        Assert.fail("Test case failed: " + e);
                    }
                }
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class)
    @Owner("Vaibhav")

    public void resetSettings()
    {
        String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
        List<SelfServiceModel.EntitlementModel1> annualLeaveData = JsonUtils.convertJsonListDataModel(selfServiceFile, "resetAnnualLeave.entitlement", SelfServiceModel.EntitlementModel1.class);

        ConfigureLeaveTypeSetting clt = new ConfigureLeaveTypeSetting();
        for (SelfServiceModel.EntitlementModel1 data : annualLeaveData)
        {
            clt.resetSettings(data.leaveType, data);
        }
    }
}