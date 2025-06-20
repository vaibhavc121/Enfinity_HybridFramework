package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.DeleteDepartmentModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DeleteDeptTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void deleteDepartment() throws InterruptedException
    {
        try
        {
            String departmentFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<DeleteDepartmentModel> departmentData = JsonUtils.convertJsonListDataModel(departmentFile,
                    "deleteDepartment", DeleteDepartmentModel.class);

            HRCorePage hc = new HRCorePage(driver);
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);

            for (DeleteDepartmentModel dept : departmentData)
            {
                sp.clickDepartment();
                Thread.sleep(2000);
                BasePage.deleteHrCoreTxn(3, dept.deptname);

                Assert.assertFalse(BasePage.validateListing(dept.deptname, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}