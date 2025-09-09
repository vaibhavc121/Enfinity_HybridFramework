package testCases.HRMS.SelfService.LeaveTypesTest;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SelfService.LeaveRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import testCases.HRMS.SelfService.LeaveRequestTest;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class AnnualLeaveTest extends BaseTest
{
    String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
    List<SelfServiceModel.EntitlementModel> annualLeaveData = JsonUtils.convertJsonListDataModel(selfServiceFile, "annualLeave.entitlement", SelfServiceModel.EntitlementModel.class);

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

                        Assert.assertTrue(lr.isTxnCreated(data.eligibilityDaysAfterJoining.expFromDate, data.eligibilityDaysAfterJoining.expToDate));
                    } catch (Exception e)
                    {
                        logger.error("Test failed due to exception: ", e);
                        Assert.fail("Test case failed: " + e);
                    }
                } else if (data.eligibilityDaysAfterJoining.days >= 30)
                {
                    try
                    {

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

                        Assert.assertFalse(lr.isTxnCreated(data.eligibilityDaysAfterJoining.expFromDate, data.eligibilityDaysAfterJoining.expToDate));
                    } catch (Exception e)
                    {
                        logger.error("Test failed due to exception: ", e);
                        Assert.fail("Test case failed: " + e);
                    }
                }
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}