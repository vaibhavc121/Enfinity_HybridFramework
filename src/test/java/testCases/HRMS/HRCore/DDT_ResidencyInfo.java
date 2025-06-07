package testCases.HRMS.HRCore;

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
			HRCorePage hc = new HRCorePage(driver);
			hc.clickHRCore();
			logger.info("clicked on hr core link");
			hc.clickSetupForm();
			logger.info("clicked on setup form");

			// setup page
			SetupPage sp = new SetupPage(driver);
			sp.clickEmployee();
			Thread.sleep(2000);
			logger.info("clicked on employee");

			// employee pg
			EmployeePage1 ep = new EmployeePage1(driver);
			ep.filterEmp();
			logger.info("emp name entered");
			Thread.sleep(3000);
			ep.clkFilteredEmp();
			logger.info("clicked on filtered employee");
			ep.clkResidencyInfo();
			logger.info("clicked on residency info tab");

			ep.setSecName(sname);
			logger.info("provided sec name");
			ep.setThirdName(tname);
			logger.info("provided third nm");
			ep.setFourthName(fname);
			logger.info("provided fourth nm");
			ep.setLastName(lname);
			logger.info("provided last nm");

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);

		}
	}
}
