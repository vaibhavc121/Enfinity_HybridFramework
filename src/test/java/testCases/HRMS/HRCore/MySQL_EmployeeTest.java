package testCases.HRMS.HRCore;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.MySQL_EmployeePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.DataProviders;

public class MySQL_EmployeeTest extends BaseTest
{
    @Test(groups = "regression", dataProvider = "employeeinfo", dataProviderClass = DataProviders.class)
    public void verifyEmpCreation(String email, String name, String mobile, String DOJ, String dept, String designation,
                                  String grade, String gender, String religion, String maritalstatus)
    {
        try
        {
            // hr core
            HRCorePage hc = new HRCorePage();
            hc.clickHRCore();
            log("clicked on hr core link");
            hc.clickSetupForm();
            log("clicked on setup form");

            // setup page
            SetupPage sp = new SetupPage();
            sp.clickEmployee();
            Thread.sleep(2000);
            log("clicked on employee");

            // employee pg
            MySQL_EmployeePage ep = new MySQL_EmployeePage();
            ep.clkBtnNew();
            log("clicked on new btn");
            ep.setWorkEmail(email);
            log("email provided");
            ep.setName(name);
            log("name provided");
            ep.setMblNum(mobile);
            log("mbl no provided");
            ep.setDOJ(DOJ);
            log("DOJ provided");
            ep.clkDept();
            log("clicked on dept dd");
            ep.slctDept(dept);
            log("dept selected");
            ep.clkDesig();
            log("clicked on desg");
            ep.slctDesig(designation);
            log("desg selected");
            ep.setGrade(grade);
            log("grade selected");
            ep.setGender(gender);
            log("gender selected");
            ep.setReligion(religion);
            log("religion selected");
            ep.setMaritalStatus(maritalstatus);
            log("marital sts selected");
            ep.clkSave();
            log("clicked on save button");

            Assert.assertEquals(ep.isEmployeeCreated(name), true);
            Thread.sleep(4000);
            // Assert.assertTrue(true);
            log("test case passed");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}