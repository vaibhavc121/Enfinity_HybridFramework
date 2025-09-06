package testCases.HRMS.HRCore;

import models.HRCore.HRCore.HRCoreModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.HRCoreModel.CreateDepartmentModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.DeptPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class DepartmentTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createDepartment()
    {
        try
        {
            String departmentFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<CreateDepartmentModel> departmentData = JsonUtils.convertJsonListDataModel(departmentFile,
                    "createDepartment", CreateDepartmentModel.class);

            HRCorePage hc = new HRCorePage();
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();
            sp.clickDepartment();
            Thread.sleep(2000);

            DeptPage dp = new DeptPage();

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

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteDepartment() throws InterruptedException
    {
        try
        {
            String departmentFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
            List<HRCoreModel.DeleteDepartmentModel> departmentData = JsonUtils.convertJsonListDataModel(departmentFile,
                    "deleteDepartment", HRCoreModel.DeleteDepartmentModel.class);

            HRCorePage hc = new HRCorePage();
            Thread.sleep(5000);
            hc.clickHRCore();
            hc.clickSetupForm();

            SetupPage sp = new SetupPage();

            for (HRCoreModel.DeleteDepartmentModel dept : departmentData)
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