package testCases.HRMS.SelfService;

import base.BasePage;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.SelfService.ExceptionRequestPage;
import pageObjects.HRMS.SelfService.MyApprovalsPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.TimeOffPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class MyApprovalTest extends BaseTest
{
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class)
    public void verifyBulkApproval()
    {
        try
        {
            //region Create Exception Request
            String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SelfServiceModel.ExceptionRequestModel> exceptionRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
                    "createExceptionRequest", SelfServiceModel.ExceptionRequestModel.class);

            BasePage.logoutAndLogin("rohitc@test.com", "123");

            // self service page
            SelfServicePage ss = new SelfServicePage(driver);
            ss.clickSelfService();
            log("clickSelfService");

            ss.clickTransactions();
            log("clickTransactions");

            // ExceptionRequest page
            ExceptionRequestPage er = new ExceptionRequestPage(driver);

            for (SelfServiceModel.ExceptionRequestModel exception : exceptionRequestData)
            {
                er.createExceptionRequest();
                log("createExceptionRequest");

                er.clickNew();
                log("clickNew");

                er.provideExceptionDate(exception.exceptionDate);
                log("provided Exception Date: " + exception.exceptionDate);

                er.provideLoginTime(exception.loginTime);
                log("provided Login Time: " + exception.loginTime);

                er.provideLogoutTime(exception.logotTime);
                log("provided Logout Time: " + exception.logotTime);

                er.provideRemarks(exception.remarks);
                log("provided Remarks: " + exception.remarks);

                er.clickSaveBack();
                log("clickSaveBack");

                //Assert.assertTrue(er.isTxnCreated(exception.exceptionDate));
                if (er.isTxnCreated(exception.exceptionDate))
                {
                    log("Transaction created successfully for date: " + exception.exceptionDate);
                } else
                {
                    throw new Exception("Transaction creation failed for date: " + exception.exceptionDate);
                }
            }
            //endregion

            //region Create TimeOff Request
            String timeOffFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
            List<SelfServiceModel.TimeOffModel> timeOffData = JsonUtils.convertJsonListDataModel(timeOffFile, "createTimeOff",
                    SelfServiceModel.TimeOffModel.class);

            // self service page
            ss.clickSelfService();
            ss.clickTransactions();

            // time off page
            TimeOffPage to = new TimeOffPage(driver);

            for (SelfServiceModel.TimeOffModel timeOff : timeOffData)
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
                to.clickSave();

                //Assert.assertTrue(to.isTxnCreated(timeOff.expPermisionDate));
                if (to.isTxnCreated(timeOff.expPermisionDate))
                {
                    log("Transaction created successfully for date: " + timeOff.expPermisionDate);
                } else
                {
                    throw new Exception("Transaction creation failed for date: " + timeOff.expPermisionDate);
                }
            }
            //endregion

            //region Bulk approve the leave request from manager login
            BasePage.logoutAndLogin("vaibhav@test.com", "123");
            ss.clickSelfService();
            log("clicked on Self Service");
            ss.clickMyApprovals();
            log("clicked on My Approvals");

            MyApprovalsPage ma = new MyApprovalsPage(driver);
            ma.bulkApproveRequest("Rohit Chavan");
            //endregion

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}