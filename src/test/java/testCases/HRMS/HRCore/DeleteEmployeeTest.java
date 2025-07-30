package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.EmployeeModel.DeleteEmpModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteEmployeeTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteEmployee()
	{
		try
		{
			// instead of for loop you can use repeat attribute
			for (int i = 1; i <= 1; i++)
			{
				String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
				List<DeleteEmpModel> deleteEmployee = JsonUtils.convertJsonListDataModel(employeeFile, "deleteEmployee",
						DeleteEmpModel.class);

				HRCorePage hc = new HRCorePage(driver);
				hc.clickHRCore();
				log("clicked on HR Core module");
				hc.clickSetupForm();
				log("clicked on Setup Form");

				SetupPage sp = new SetupPage(driver);
				sp.clickEmployee();
				log("clicked on Employee");
				Thread.sleep(2000);

				for (DeleteEmpModel del : deleteEmployee)
				{
					BasePage.navigateToEmployee(del.empName);
					BasePage.switchTab();
					log("switched to Employee tab for " + del.empName);

					EmployeePage ep = new EmployeePage(driver);
					ep.clickSettingButton();
					log("clicked on setting button");

					ep.clickDelete();
					log("clicked on delete button");
					ep.clickOk();
					log("clicked on OK button to confirm deletion");
					// ClassicAssert.isTrue(BasePage.isEmployeeDeleted(), "Employee not deleted");
					// ep.clickRightAreaMenu();
					// ep.clickLogOff();
					// BasePage.closeTab();

					Assert.assertFalse(ep.validateEmpDelete(del.empName), "Employee " + del.empName + " is not deleted.");
					log("Employee " + del.empName + " deleted successfully");
				}
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}