//package testCases.HRMS.HRCore;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import base.BaseTest;
//import base.BasePage;
//import pageObjects.HRMS.SelfService.SelfServicePage;
//import utilities.FileUtils;
//import utilities.JsonUtils;
//import utilities.RetryAnalyzer;
//import java.util.List;
//
//public class AssetIssueTest extends BaseTest
//{
//	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
//	public void createDepartment()
//	{
//		try
//		{
//			String departmentFile = FileUtils.getDataFile("Hrms", "HRCore", "Department", "DepartmentData");
//			List<CreateDepartmentModel> departmentData = JsonUtils.convertJsonListDataModel(departmentFile,
//					"createDepartment", CreateDepartmentModel.class);
//
//			HRCorePage hc = new HRCorePage(_driver);
//			Thread.sleep(5000);
//			hc.clickHRCore();
//			hc.clickSetupForm();
//
//			SetupPage sp = new SetupPage(_driver);
//			sp.clickDepartment();
//			Thread.sleep(2000);
//
//			DepartmentPage dp = new DepartmentPage(_driver);
//
//			for (CreateDepartmentModel department : departmentData)
//			{
//				dp.clickNew();
//				dp.provideDepartmentName(department.deptname);
//				// dp.selfServiceDD();
//				// dp.clickDeptMgrDD();
//				// dp.selectDeptMgrName();
//				// dp.selectDeptMgr();
//				dp.clickSaveBack();
//
//				ClassicAssert.isTrue(BasePage.validateListing(department.deptname, 3, 2));
//			}
//		} catch (Exception e)
//		{
//			logger.error("Test failed due to exception: ", e);
//			Assert.fail("Test case failed: " + e);
//		}
//	}
//
//}
