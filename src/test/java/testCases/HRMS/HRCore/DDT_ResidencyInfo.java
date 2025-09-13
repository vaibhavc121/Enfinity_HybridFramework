package testCases.HRMS.HRCore;

import factory.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.EmployeePage1;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.DataProviders;

public class DDT_ResidencyInfo extends BaseTest
{
    @Test(groups = "datadriven", dataProvider = "ResidencyInfo", dataProviderClass = DataProviders.class)
    public void verifyResidencyInfo(String sname, String tname, String fname, String lname)
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
            EmployeePage1 ep = new EmployeePage1();
            ep.filterEmp();
            log("emp name entered");
            Thread.sleep(3000);
            ep.clkFilteredEmp();
            log("clicked on filtered employee");
            ep.clkResidencyInfo();
            log("clicked on residency info tab");

            ep.setSecName(sname);
            log("provided sec name");
            ep.setThirdName(tname);
            log("provided third nm");
            ep.setFourthName(fname);
            log("provided fourth nm");
            ep.setLastName(lname);
            log("provided last nm");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}