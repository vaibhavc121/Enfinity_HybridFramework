package testCases.HRMS.Payroll;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.SuspendPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class SuspendTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createSuspendTxn()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.SuspendModel> suspendData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createSuspend", PayrollModel.SuspendModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // suspend pg
            SuspendPage sp = new SuspendPage(driver);
            for (PayrollModel.SuspendModel suspend : suspendData)
            {
                sp.clickSuspend();
                log("clicked on suspend link");

                sp.clickNew();
                log("clicked on new button");

                sp.provideEffectiveDate(suspend.effectiveDate);
                log("provided effective date");

                sp.provideEmployee(suspend.employee);
                log("provided employee");

                sp.provideSuspendType(suspend.suspendType);
                log("provided suspend type");

                sp.provideRemarks(suspend.remarks);
                log("provided remarks");

                sp.clickViewApproveBack();
                log("clicked on view approve button");

                Assert.assertTrue(BasePage.validateListing2Fields(suspend.employee, 6, 6,suspend.suspendType, 7,7),
                        "Suspend transaction not created for employee: " + suspend.employee);
                log("Suspend transaction created successfully for employee: " + suspend.employee);
            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void releaseSuspendTxn()
    {
        try
        {
            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
            List<PayrollModel.SuspendModel> suspendData = JsonUtils.convertJsonListDataModel(payrollFile,
                    "createSuspend", PayrollModel.SuspendModel.class);

            // payroll pg
            PayrollPage pp = new PayrollPage(driver);
            pp.clkPayroll();
            log("clicked on payroll link");
            pp.clkTxn();
            log("clicked on txn");

            // suspend pg
            SuspendPage sp = new SuspendPage(driver);
            for (PayrollModel.SuspendModel suspend : suspendData)
            {
                sp.clickSuspend();
                log("clicked on suspend link");

                BasePage.performAction(6, suspend.employee, "Edit Release");

                BasePage.switchTab();
                log("switched to release tab");

                sp.provideReleaseSuspendDate(suspend.releaseSuspendDate);
                log("provided release suspend date");

                BasePage.clickOnView();
                log("clicked on view button");

                BasePage.waitForElement1(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[1]")).click();
                BasePage.waitTS(2);
                BaseTest.log("Clicked on menu image icon");

                sp.clickRelease();
                log("clicked on release button");
                BasePage.waitTS(2);

                BasePage.clickOnOk();
                log("clicked on ok button");

                BasePage.pressEnter();
                log("pressed enter key");
                BasePage.waitTS(1);

                BasePage.waitForElement1(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[1]")).click();
                BasePage.waitTS(2);
                BaseTest.log("Clicked on menu image icon");

                sp.clickRelease();
                log("clicked on release button");
                BasePage.waitTS(2);

                Assert.assertTrue(sp.validateMsg());
                log("Assertion passed: Suspend transaction released successfully for employee: " + suspend.employee);
            }

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}