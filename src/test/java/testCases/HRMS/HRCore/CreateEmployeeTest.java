package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.HRCore.HRCore.EmployeeModel.EmpModel;
import base.BasePage;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateEmployeeTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createEmployee()
	{
		try
		{
			String employeeFile = FileUtils.getDataFile("HRCore", "HRCore", "EmployeeData");
			List<EmpModel> employeeInfo = JsonUtils.convertJsonListDataModel(employeeFile, "newEmployee",
					EmpModel.class);

			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			hc.clickSetupForm();

			SetupPage sp = new SetupPage(driver);
			sp.clickEmployee();
			Thread.sleep(2000);

			EmployeePage ep = new EmployeePage(driver);

			for (EmpModel employee : employeeInfo)
			{
				ep.clickNewBtn();
				ep.provideWorkEmail(employee.email);
				ep.provideName(employee.name);
				// ep.clickMgrDropdown();
				// ep.selectMgr();
				ep.provideMobileNumber(employee.mobile);
				ep.provideDOJ(employee.DOJ);

				ep.selectDepartment(employee.department);
				ep.selectDesignation(employee.designation);
				// ep.clearPayrollSet();
				ep.selectPayrollSet(employee.payrollSet);
				ep.selectCalendar(employee.calendar);
				ep.selectIndemnity(employee.indemnity);
				ep.selectGrade(employee.grade);
				ep.selectGender(employee.gender);
				ep.selectReligion(employee.religion);
				ep.selectMaritalStatus(employee.maritalStatus);

				ep.clickSave();

				Assert.assertTrue(ep.validate(employee.name));
			}

			// ClassicAssert.isTrue(ep.isEmployeeCreated(name));

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}