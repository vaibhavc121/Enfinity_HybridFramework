package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class DDT_ResidencyInfo extends BaseClass
{
	@Test(groups = "datadriven", dataProvider = "ResidencyInfo", dataProviderClass = DataProviders.class)
	public void verifyResidencyInfo(String sname, String tname, String fname, String lname)
	{
		try
		{
			// hr core
			HRCorePage hc = new HRCorePage(driver);
			hc.clkHRCore();
			logger.info("clicked on hr core link");
			hc.clkSetupForm();
			logger.info("clicked on setup form");

			// setup page
			SetupPage sp = new SetupPage(driver);
			sp.clkEmployee();
			Thread.sleep(2000);
			logger.info("clicked on employee");

			// employee pg
			EmployeePage ep = new EmployeePage(driver);
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

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
			//test commit
			
		}
	}
}
