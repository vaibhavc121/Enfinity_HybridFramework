package testCases.HRMS.HRCore;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateDepartmentModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.DeptPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateDeptTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void createDepartment()
    {
        try
        {
            String departmentFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateDepartmentModel> departmentData = JsonUtils.convertJsonListDataModel(departmentFile,
                    "createDepartment", CreateDepartmentModel.class);

            HRCorePage hc = new HRCorePage(driver);
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage(driver);
            sp.clickDepartment();
            Thread.sleep(2000);

            DeptPage dp = new DeptPage(driver);

            for (CreateDepartmentModel department : departmentData)
            {
                dp.clickNew();
                dp.provideDepartmentName(department.deptname);
                // dp.selfServiceDD();
                // dp.clickDeptMgrDD();
                // dp.selectDeptMgrName();
                // dp.selectDeptMgr();
                dp.clickSaveBack();

                Assert.assertTrue(BasePage.validateListing(department.deptname, 3, 2));
            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}