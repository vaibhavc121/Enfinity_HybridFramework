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
            log("Clicked on HR Core");
            hc.clickSetupForm();
            log("Clicked on Setup Form");

            SetupPage sp = new SetupPage(driver);
            sp.clickEmployee();
            log("Clicked on Employee");
            Thread.sleep(2000);

            EmployeePage ep = new EmployeePage(driver);

            for (EmpModel employee : employeeInfo)
            {
                ep.clickNewBtn();
                log("Clicked on New Button");

                ep.provideWorkEmail(employee.email);
                log("provided work email: " + employee.email);

                ep.provideName(employee.name);
                log("provided name: " + employee.name);

                // ep.clickMgrDropdown();
                // ep.selectMgr();
                ep.provideMobileNumber(employee.mobile);
                log("provided mobile number: " + employee.mobile);

                ep.provideDOJ(employee.DOJ);
                log("provided date of joining: " + employee.DOJ);

                ep.selectDepartment(employee.department);
                log("selected department: " + employee.department);

                ep.selectDesignation(employee.designation);
                log("selected designation: " + employee.designation);

                // ep.clearPayrollSet();
                ep.selectPayrollSet(employee.payrollSet);
                log("selected payroll set: " + employee.payrollSet);

                ep.selectCalendar(employee.calendar);
                log("selected calendar: " + employee.calendar);

                ep.selectIndemnity(employee.indemnity);
                log("selected indemnity: " + employee.indemnity);

                ep.selectGrade(employee.grade);
                log("selected grade: " + employee.grade);

                ep.selectGender(employee.gender);
                log("selected gender: " + employee.gender);

                ep.selectReligion(employee.religion);
                log("selected religion: " + employee.religion);

                ep.selectMaritalStatus(employee.maritalStatus);
                log("selected marital status: " + employee.maritalStatus);

                ep.clickSave();
                log("Clicked on Save Button");

                Assert.assertTrue(ep.validate(employee.name),
                        "Employee creation failed for: " + employee.name);
                log("Verified: Employee created successfully with name: " + employee.name);
            }

            // ClassicAssert.isTrue(ep.isEmployeeCreated(name));

        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}